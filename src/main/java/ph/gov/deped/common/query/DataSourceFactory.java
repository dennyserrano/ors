package ph.gov.deped.common.query;

import com.zaxxer.hikari.HikariDataSource;
import ph.gov.deped.common.DbSettings;

import javax.sql.DataSource;

/**
 * Created by ej on 8/29/14.
 */
public class DataSourceFactory {

    private final DbSettings db;

    public DataSourceFactory(DbSettings db) {
        this.db = db;
    }

    public DataSource create() {
        HikariDataSource ds = new HikariDataSource();
        ds.setMaximumPoolSize(2);
        ds.setConnectionTestQuery("SELECT 1");
        ds.setPoolName("DS-Pool-" + db.getDbName());
        ds.setJdbcUrl(db.getJdbcUrl());
        ds.setUsername(db.getDbUser());
        ds.setPassword(db.getDbPass());
        ds.setDriverClassName(db.getDbDriver());
        return ds;
    }
}
