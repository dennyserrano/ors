package ph.gov.deped.service.etl.meta;

import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.reflections.ReflectionUtils.getAllFields;
import static org.reflections.ReflectionUtils.withAnnotation;
import static org.reflections.ReflectionUtils.withModifier;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.cfg.NamingStrategy;
import org.springframework.boot.orm.jpa.SpringNamingStrategy;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.TypeUtils;

import ph.gov.deped.common.dw.DbType;
import ph.gov.deped.common.query.Operator;
import ph.gov.deped.common.query.ValueTypeMappings;
import ph.gov.deped.common.query.ValueTypes;
import ph.gov.deped.data.ors.meta.ColumnMetadata;
import ph.gov.deped.data.ors.meta.TableMetadata;
import ph.gov.deped.service.meta.api.MetadataSynchronizationException;

/**
 * Created by ej on 8/14/14.
 */
@SuppressWarnings({"unchecked"})
public class MetadataParser {

    private static final Pattern VALID_COL_NAME_PATTERN = Pattern.compile("^[A-Za-z][A-Za-z0-9_]*$");

    private NamingStrategy namingStrategy = new SpringNamingStrategy();

    public void setNamingStrategy(NamingStrategy namingStrategy) {
        this.namingStrategy = namingStrategy;
    }

    public TableMetadata parseJpaEntity(Integer tableId, Class<? extends Serializable> clazz) {
        String tableName = "";
        String schema = "";
        String dbName = "";
        if (AnnotationUtils.isAnnotationDeclaredLocally(Table.class, clazz)) {
            Table table = AnnotationUtils.findAnnotation(clazz, Table.class);
            tableName = table.name();
            schema = table.schema();
            dbName = table.catalog();
        }
        if (isBlank(tableName)) {
            tableName = namingStrategy.tableName(clazz.getSimpleName());
        }
        DbType dbType = DbType.findByName(dbName);
        TableMetadata t = new TableMetadata(tableId, dbType.ordinal(), schema, tableName, "", "");
        t.setTableId(t.hashCode());
        return t;
    }

    public List<ColumnMetadata> parseColumnMetadatas(AtomicInteger colId, Class<? extends Serializable> clazz) {
        Set<Field> fields = getAllFields(
                clazz, 
                withModifier(Modifier.PRIVATE),
                not(withModifier(Modifier.TRANSIENT)),
                not(withModifier(Modifier.STATIC)),
                not(withModifier(Modifier.FINAL)),
                or(
                        withAnnotation(Id.class),
                        withAnnotation(EmbeddedId.class),
                        withAnnotation(Basic.class),
                        withAnnotation(Column.class),
                        withAnnotation(JoinColumn.class)
                )
        );
        // should include the primary key annotated with @Id since it's joined with @Column
        List<ColumnMetadata> columns = fields.parallelStream()
                .filter(f -> f.isAnnotationPresent(Column.class))
                .map(f -> parseField(colId.incrementAndGet(), f))
                .collect(Collectors.toList());
        Optional<ColumnMetadata> pkColumn = columns.parallelStream()
                .filter(ColumnMetadata::isPrimaryKey)
                .findFirst();
        if (!pkColumn.isPresent()) { // @Id field not found, find using @EmbeddedId
            fields.parallelStream()
                    .filter(f -> f.isAnnotationPresent(EmbeddedId.class))
                    .map(f -> parsePrimaryKeys(colId.incrementAndGet(), f))
                    .forEach(columns::addAll);
        }
        return columns;
    }

    public ColumnMetadata parseField(Integer colId, Field field) {
        if (field.isAnnotationPresent(Column.class)) {
            return parseBasicColumn(colId, field);
        }
        else {
            return parseJoinColumn(colId, field);
        }
    }

    public Set<ColumnMetadata> parsePrimaryKeys(Integer colId, Field field) {
        if (!field.isAnnotationPresent(EmbeddedId.class)) {
            return null;
        }
        Class<? extends Serializable> compoundPkType = (Class<? extends Serializable>) field.getType();
        Set<Field> fields = getAllFields(
                compoundPkType, 
                withModifier(Modifier.PRIVATE),
                not(withModifier(Modifier.TRANSIENT)),
                not(withModifier(Modifier.STATIC)),
                not(withModifier(Modifier.FINAL)),
                withAnnotation(Column.class)
        );
        Set<ColumnMetadata> primaryKeyColumns = fields.parallelStream()
                .map(f -> parseBasicColumn(colId, f))
                .map(col -> {
                    col.setPrimaryKey(true);
                    return col;
                })
                .collect(Collectors.toSet());
        
        return primaryKeyColumns;
    }

    protected ColumnMetadata parseBasicColumn(Integer colId, Field field) {
        Column column = field.getAnnotation(Column.class);
        String columnName = column.name();
        if (isBlank(columnName) || !VALID_COL_NAME_PATTERN.matcher(columnName).matches()) {
            columnName = namingStrategy.propertyToColumnName(field.getName());
        }
        boolean nullable = column.nullable();
        ValueTypes valueType = ValueTypeMappings.getValueType((Class<? extends Serializable>) field.getType());
        if (valueType == null) {
            valueType = determineUserType(field);
        }
        if (valueType == null) { // still null? add your custom user type in #determineUserType(Field)
            throw new MetadataSynchronizationException(String.format("Undeterminable field/column type [%s]", field.getType()));
        }
        boolean primaryKey = field.isAnnotationPresent(Id.class);

        return new ColumnMetadata(colId, columnName, valueType.getSqlType(), nullable, nullable ? 0 : 1, column.length(), primaryKey);
    }

    protected ColumnMetadata parseJoinColumn(Integer colId, Field field) {
        JoinColumn joinColumn = field.getAnnotation(JoinColumn.class);
        final String columnName = joinColumn.name() == null ? namingStrategy.propertyToColumnName(field.getName()) : joinColumn.name();
        Field[] fields = field.getType().getDeclaredFields();
        Field referencedField = asList(fields).stream()
                .filter(f -> f.isAnnotationPresent(Id.class))
                .findFirst().get();
        if (referencedField == null) {
            throw new RuntimeException(String.format("Referenced field not found for join column [%s].", columnName));
        }
        ValueTypes valueType = ValueTypeMappings.getValueType((Class<? extends Serializable>) referencedField.getType());
        if (valueType == null) {
            valueType = determineUserType(referencedField);
        }
        if (valueType == null) { // still null? add your custom user type in #determineUserType(Field)
            throw new MetadataSynchronizationException(String.format("Undeterminable field/column type [%s]", referencedField.getType()));
        }
        Column referencedColmn = referencedField.getAnnotation(Column.class);
        final boolean nullable = joinColumn.nullable();
        return new ColumnMetadata(colId, columnName, valueType.getSqlType(), nullable, nullable ? 0 : 1, referencedColmn.length(), false);
    }

    private ValueTypes determineUserType(Field field) {
        Class<?> fieldType = field.getType();
        if (TypeUtils.isAssignable(Operator.class, fieldType)) {
            return ValueTypes.STRING;
        }
        else if (TypeUtils.isAssignable(Enum.class, fieldType)) {
            Enumerated enumerated = field.getAnnotation(Enumerated.class);
            if (EnumType.ORDINAL == enumerated.value()) {
                return ValueTypes.INTEGER;
            }
            else {
                return ValueTypes.STRING;
            }
        }
        return null;
    }
}
