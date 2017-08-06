package ph.gov.deped.data.source;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.config.OrsSettings;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by ej on 8/15/14.
 */
@Configuration
@PropertySource({"classpath:" + AppMetadata.PROPS})
@EnableConfigurationProperties(LiquibaseProperties.class)
public class ApplicationDataSourceSpringConfig implements AppMetadata {
    
    private static final Logger log = LogManager.getLogger(ApplicationDataSourceSpringConfig.class);
    
    public static @Bean PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
        p.setLocations(new Resource[] {
                new ClassPathResource(PROPS)
        });
        p.setIgnoreUnresolvablePlaceholders(true);
        p.setIgnoreResourceNotFound(true);
        return p;
    }

    private @Autowired OrsSettings orsSettings;

    public @Bean(destroyMethod = "close") @Primary @Qualifier(DS) DataSource dataSource() {
        MysqlXADataSource mysqlDs = new MysqlXADataSource();
        mysqlDs.setURL(orsSettings.getDbUrl());
        mysqlDs.setUrl(orsSettings.getDbUrl());
        mysqlDs.setUser(orsSettings.getDbUser());
        mysqlDs.setPassword(orsSettings.getDbPass());
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
        ds.setMaximumPoolSize(500);
        ds.setConnectionTestQuery("SELECT 1");
        ds.setDataSource(mysqlDs);
        ds.setPoolName(DS);
        try {
            ds.setLoginTimeout(60);
        }
        catch (SQLException ex) {
            log.catching(ex);
        }

        return ds;
    }
}
