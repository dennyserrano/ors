package ph.gov.deped.repo.jpa.ebeis;

import static ph.gov.deped.common.query.Projections.column;
import static ph.gov.deped.common.query.QueryBuilders.read;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import ph.gov.deped.common.dw.DbType;
import ph.gov.deped.common.query.JdbcTypes;
import ph.gov.deped.data.ors.meta.ColumnMetadata;
import ph.gov.deped.data.ors.meta.TableMetadata;

public class MetaRepository {
    
    private static final String TBL_WITH_PK = "SELECT ";
    
    private static final String TABLE_SCHEMA = "table_schema";

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
        StringBuilder sql = read()
            .select(column(TABLE_NAME), column(TABLE_ROWS), column(TABLE_COMMENT), column(CREATE_TIME), column(UPDATE_TIME))
            .from("information_schema.tables")
            .where(TABLE_SCHEMA).eq(dbType.getDbName())
                .and("table_type").eq("BASE TABLE")
            .orderBy(TABLE_NAME)
            .build();
        JdbcTemplate template = new JdbcTemplate(dataSource);
        return template.<TableMetadata>query(sql.toString(), (rs, rowNum) -> {
            TableMetadata t = new TableMetadata();
            t.setTableName(rs.getString(TABLE_NAME));
            t.setDbId(dbType.ordinal());
            t.setRowCount(rs.getInt(TABLE_ROWS));
            t.setDescription(rs.getString(TABLE_COMMENT));
            t.setDateCreated(rs.getDate(CREATE_TIME));
            t.setDateUpdated(rs.getDate(UPDATE_TIME));
            return t;
        });
    }
    
    public List<ColumnMetadata> findColumns(TableMetadata table) {
        StringBuilder sql = read()
                .select(column("column_name"), column("column_comment"), column("data_type"), column("character_maximum_length"),
                        column("is_nullable"), column("numeric_precision"), column("numeric_scale"),
                        column("column_type"), column("column_key"))
                .from("information_schema.columns")
                .where(TABLE_SCHEMA).eq(dbType.getDbName())
                .orderBy(TABLE_NAME, "ordinal_position")
                .build();
        JdbcTemplate template = new JdbcTemplate(dataSource);
        return template.<ColumnMetadata>query(sql.toString(), (rs, rowNum) -> {
            ColumnMetadata c = new ColumnMetadata();
            c.setTableId(table.getId());
            c.setColumnName("column_name");
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
            return c;
        });
    }
    
    public DbType getDbType() {
        return dbType;
    }
}
