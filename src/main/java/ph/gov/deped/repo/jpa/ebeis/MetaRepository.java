package ph.gov.deped.repo.jpa.ebeis;

import java.sql.Types;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import ph.gov.deped.common.dw.DbType;
import com.bits.sql.JdbcTypes;
import ph.gov.deped.data.ors.meta.ColumnMetadata;
import ph.gov.deped.data.ors.meta.TableMetadata;

public class MetaRepository {

    private static final String TBL_WITH_PK = "SELECT table_name FROM information_schema.columns WHERE "
            + "table_schema = ? AND column_key = 'PRI' GROUP BY table_name";

    private static final String TABLES_SQL = "SELECT table_name, table_rows, table_comment, create_time, update_time "
            + "FROM information_schema.tables WHERE table_schema = ? AND table_type = 'BASE TABLE' ORDER BY table_name";

    private static final String COLUMNS_SQL = "SELECT column_name, column_comment, data_type, character_maximum_length, "
            + "is_nullable, numeric_precision, numeric_scale, column_type, column_key FROM information_schema.columns "
            + "WHERE table_schema = ? AND table_name = ? ORDER BY ordinal_position";

    private static final String UPDATE_TIME = "update_time";

    private static final String CREATE_TIME = "create_time";

    private static final String TABLE_COMMENT = "table_comment";

    private static final String TABLE_ROWS = "table_rows";

    private static final String TABLE_NAME = "table_name";

    private final DataSource dataSource;

    private final DbType dbType;

    public MetaRepository(DataSource dataSource, DbType dbType) {
        this.dataSource = dataSource;
        this.dbType = dbType;
    }

    public List<TableMetadata> findTables() {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        List<String> tablesWithPk = template.query(TBL_WITH_PK,
                new Object[] { dbType.getDbName() },
                (rs, rowNum) -> rs.getString(1));
        List<TableMetadata> tables = template.<TableMetadata> query(TABLES_SQL,
                new Object[] { dbType.getDbName() },
                new int[] { Types.VARCHAR }, (rs, rowNum) -> {
                    TableMetadata t = new TableMetadata();
                    t.setTableName(rs.getString(TABLE_NAME));
                    t.setDbId(dbType.ordinal());
                    t.setRowCount(rs.getInt(TABLE_ROWS));
                    t.setDescription(rs.getString(TABLE_COMMENT));
                    t.setDateCreated(rs.getDate(CREATE_TIME));
                    t.setDateUpdated(rs.getDate(UPDATE_TIME));
                    return t;
                });
        return tables.parallelStream()
                .filter(table -> tablesWithPk.contains(table.getTableName()))
                .filter(table -> !table.getTableName().startsWith("tmp"))
                .collect(Collectors.toList());
    }

    public List<ColumnMetadata> findColumns(TableMetadata table) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        return template.<ColumnMetadata> query(COLUMNS_SQL, new Object[] {
                dbType.getDbName(), table.getTableName() }, new int[] {
                Types.VARCHAR, Types.VARCHAR }, (rs, rowNum) -> {
            ColumnMetadata c = new ColumnMetadata();
            c.setTableId(table.getId());
            c.setColumnName(rs.getString("column_name"));
            int dataType = JdbcTypes.getSqlType(rs.getString("data_type"));
            c.setDataType(dataType);
            boolean nullable = "YES".equals(rs.getString("is_nullable"));
            c.setNullable(nullable);
            if (!JdbcTypes.isNumeric(dataType)) {
                c.setMin(nullable ? 0 : 1);
                c.setMax(rs.getLong("character_maximum_length"));
            }
            else {
                c.setMin(rs.getInt("numeric_scale"));
                c.setMax(rs.getInt("numeric_precision"));
            }
            if ("PRI".equals(rs.getString("column_key"))) {
                c.setPrimaryKey(true);
            }
            return c;
        });
    }

    public DbType getDbType() {
        return dbType;
    }
}
