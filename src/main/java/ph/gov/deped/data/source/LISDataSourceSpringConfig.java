package ph.gov.deped.data.source;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import com.zaxxer.hikari.HikariDataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import ph.gov.deped.common.LisMetadata;
import ph.gov.deped.config.LisSettings;

import javax.sql.DataSource;

import java.sql.SQLException;

/**
 * Created by ej on 8/5/14.
 */
@Configuration
@PropertySource({"classpath:" + LisMetadata.LIS_PROPS})
public class LISDataSourceSpringConfig implements LisMetadata {

    public static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/lis2db";

    public static final String DEFAULT_USER = "root";

    public static final String DEFAULT_PASSWORD = "password";
    
    private static final Logger log = LogManager.getLogger(LISDataSourceSpringConfig.class);

    public static @Bean PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
        p.setLocations(new Resource[] {
                new ClassPathResource(LIS_PROPS)
        });
        return p;
    }

    private @Autowired LisSettings lisSettings;

    public @Bean(destroyMethod = "close") @Qualifier(DS) DataSource lisDataSource() {
        MysqlXADataSource mysqlDs = new MysqlXADataSource();
        mysqlDs.setURL(lisSettings.getDbUrl());
        mysqlDs.setUrl(lisSettings.getDbUrl());
        mysqlDs.setUser(lisSettings.getDbUser());
        mysqlDs.setPassword(lisSettings.getDbPass());
        mysqlDs.setQueryTimeoutKillsConnection(true);
        mysqlDs.setZeroDateTimeBehavior("convertToNull");
        mysqlDs.setCachePreparedStatements(true);
        mysqlDs.setCachePrepStmts(true);
        mysqlDs.setUseServerPreparedStmts(true);
        mysqlDs.setUseServerPrepStmts(true);
        mysqlDs.setCacheServerConfiguration(true);
        mysqlDs.setUseLocalSessionState(true);
        mysqlDs.setUseLocalTransactionState(true);
        mysqlDs.setUseUnbufferedInput(false);
        mysqlDs.setUseReadAheadInput(false);
        try {
            mysqlDs.setPreparedStatementCacheSize(200);
            mysqlDs.setPrepStmtCacheSize(200);
            mysqlDs.setPrepStmtCacheSqlLimit(2048);
        }
        catch (SQLException ex) {
            log.error(ex);
        }

        HikariDataSource ds = new HikariDataSource();
//        ds.setMaximumPoolSize(8);
//        ds.setConnectionTestQuery("SELECT 1");
//        ds.setDataSource(mysqlDs);
//        ds.setPoolName(DS);
//        try {
//            ds.setLoginTimeout(60);
//        }
//        catch (SQLException ex) {
//            log.catching(ex);
//        }

        return ds;
    }
}
