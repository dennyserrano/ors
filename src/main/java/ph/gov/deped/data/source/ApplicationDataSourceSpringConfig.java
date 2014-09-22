package ph.gov.deped.data.source;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.spring.SpringLiquibase;
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

    public static @Bean PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
        p.setLocations(new Resource[] {
                new ClassPathResource(PROPS)
        });
        p.setIgnoreUnresolvablePlaceholders(true);
        p.setIgnoreResourceNotFound(true);
        return p;
    }

    private @Autowired LiquibaseProperties liquibaseProperties;

    private @Autowired OrsSettings orsSettings;

    public @Bean(destroyMethod = "close") @Primary @Qualifier(DS) DataSource dataSource() {
        MysqlXADataSource mysqlDs = new MysqlXADataSource();
        mysqlDs.setURL(orsSettings.getDbUrl());
        mysqlDs.setUrl(orsSettings.getDbUrl());
        mysqlDs.setUser(orsSettings.getDbUser());
        mysqlDs.setPassword(orsSettings.getDbPass());
        mysqlDs.setQueryTimeoutKillsConnection(true);

        HikariDataSource ds = new HikariDataSource();
        ds.setMaximumPoolSize(8);
        ds.setConnectionTestQuery("SELECT 1");
        ds.setDataSource(mysqlDs);
        ds.setPoolName(DS);
        try {
            ds.setLoginTimeout(60);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return ds;
    }

    public @Bean SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(this.liquibaseProperties.getChangeLog());
        liquibase.setContexts(this.liquibaseProperties.getContexts());
        liquibase.setDataSource(dataSource());
        liquibase.setDefaultSchema(this.liquibaseProperties.getDefaultSchema());
        liquibase.setDropFirst(this.liquibaseProperties.isDropFirst());
        liquibase.setShouldRun(this.liquibaseProperties.isEnabled());
        return liquibase;
    }
}
