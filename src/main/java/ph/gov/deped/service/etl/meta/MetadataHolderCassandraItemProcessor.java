package ph.gov.deped.service.etl.meta;

import com.datastax.driver.core.DataType;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.core.cql.CqlIdentifier;
import org.springframework.cassandra.core.keyspace.CreateTableSpecification;
import org.springframework.cassandra.core.keyspace.TableOption;

import ph.gov.deped.common.query.ValueTypeMappings;
import ph.gov.deped.data.config.CassandraMappings;
import ph.gov.deped.data.ors.meta.ColumnMetadata;
import ph.gov.deped.data.ors.meta.TableMetadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Created by ej on 9/10/14.
 */
public class MetadataHolderCassandraItemProcessor implements ItemProcessor<String, CreateTableSpecification> {

    private MetadataRegistry metadataRegistry;

    public @Autowired void setMetadataRegistry(MetadataRegistry metadataRegistry) {
        this.metadataRegistry = metadataRegistry;
    }

    public CreateTableSpecification process(String item) throws Exception {
        final MetadataHolder metadataHolder = metadataRegistry.getMetadata(item);
        final TableMetadata tableMetadata = metadataHolder.getTableMetadata();
        final String tableName = tableMetadata.getTableName();
        final List<ColumnMetadata> columnMetadataList = new ArrayList<>(metadataHolder.getColumnMetadatas());
        final Optional<ColumnMetadata> primaryKeyColumn = getPrimaryColumn(columnMetadataList);
        if (!primaryKeyColumn.isPresent()) {
            throw new NoPrimaryKeyException(tableName);
        }
        final DataType primaryKeyDataType = getCassandraDataType(primaryKeyColumn.get().getDataType());
        CreateTableSpecification spec = CreateTableSpecification.createTable()
                .ifNotExists()
                .name(tableName)
                .partitionKeyColumn(primaryKeyColumn.get().getColumnName(), primaryKeyDataType)
                .with(TableOption.COMMENT, tableMetadata.getDescription())
                .with(TableOption.CACHING, TableOption.CachingOption.KEYS_ONLY);
        columnMetadataList.forEach(cm -> {
            String columnName = cm.getColumnName();
            DataType dataType = getCassandraDataType(cm.getDataType());
            spec.column(new CqlIdentifier(columnName, true), dataType);
        });
        return spec;
    }

    private DataType getCassandraDataType(int sqlType) {
        Class<? extends Serializable> javaType = ValueTypeMappings.getJavaType(sqlType);
        return CassandraMappings.getCassandraType(javaType);
    }

    private Optional<ColumnMetadata> getPrimaryColumn(List<ColumnMetadata> columnMetadatas) {
        for (Iterator<ColumnMetadata> i = columnMetadatas.iterator(); i.hasNext(); ) {
            ColumnMetadata col = i.next();
            if (col.isPrimaryKey()) {
                i.remove();
                return Optional.of(col);
            }
        }
        return Optional.empty();
    }
}
