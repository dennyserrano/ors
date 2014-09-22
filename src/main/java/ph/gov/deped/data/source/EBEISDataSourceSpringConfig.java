package ph.gov.deped.data.source;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ph.gov.deped.common.EbeisMetadata;
import ph.gov.deped.config.EbeisSettings;

import javax.sql.DataSource;
import java.sql.SQLException;
/**
 * Created by ej on 8/5/14.
 */
@Configuration
@PropertySource({"classpath:" + EbeisMetadata.EBEIS_PROPS})
public class EBEISDataSourceSpringConfig implements EbeisMetadata {

    public static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/sisdb";

    public static final String DEFAULT_USER = "root";

    public static final String DEFAULT_PASSWORD = "password";

    public static @Bean PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
        p.setLocations(new Resource[] {
                new ClassPathResource(EBEIS_PROPS)
        });
        return p;
    }

    private @Autowired EbeisSettings ebeisSettings;

    public @Bean(name = DS, destroyMethod = "close") @Qualifier(DS) DataSource ebeisDataSource() {
        MysqlXADataSource mysqlDs = new MysqlXADataSource();
        mysqlDs.setURL(ebeisSettings.getDbUrl());
        mysqlDs.setUrl(ebeisSettings.getDbUrl());
        mysqlDs.setUser(ebeisSettings.getDbUser());
        mysqlDs.setPassword(ebeisSettings.getDbPass());
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
}
