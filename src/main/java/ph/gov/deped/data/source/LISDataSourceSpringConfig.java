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

        HikariDataSource ds = new HikariDataSource();
        ds.setMaximumPoolSize(50);
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
