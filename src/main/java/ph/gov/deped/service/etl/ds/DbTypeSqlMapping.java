package ph.gov.deped.service.etl.ds;

import ph.gov.deped.common.dw.DbType;
import ph.gov.deped.service.etl.meta.MetadataHolder;

/**
 * Created by ej on 9/10/14.
 */
public class DbTypeSqlMapping {

    private final DbType dbType;

    private final StringBuilder sql;

    private final MetadataHolder metadataHolder;

    public DbTypeSqlMapping(DbType dbType, StringBuilder sql, MetadataHolder metadataHolder) {
        this.dbType = dbType;
        this.sql = sql;
        this.metadataHolder = metadataHolder;
    }

    public DbType getDbType() {
        return dbType;
    }

    public StringBuilder getSql() {
        return sql;
    }

    public MetadataHolder getMetadataHolder() {
        return metadataHolder;
    }
}
