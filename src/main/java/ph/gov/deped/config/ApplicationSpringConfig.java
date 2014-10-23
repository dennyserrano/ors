package ph.gov.deped.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;
import reactor.spring.context.RingBufferApplicationEventPublisher;

/**
 * Created by ej on 8/15/14.
 */
@Configuration
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class
})
@EnableConfigurationProperties({
        LocalSettings.class,
        OrsSettings.class,
        LisSettings.class,
        EbeisSettings.class,
        CassandraSettings.class
})
@Import({
        RootSpringConfig.class,
        WebSpringConfig.class
})
public class ApplicationSpringConfig implements ApplicationContextAware {
    
    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public @Bean ApplicationEventPublisher applicationEventPublisher() {
        return new RingBufferApplicationEventPublisher(8, true);
    }

    public @Bean LocalSettings localSettings() {
        return new LocalSettings();
    }

    public @Bean OrsSettings orsSettings() {
        return new OrsSettings();
    }

    public @Bean LisSettings lisSettings() {
        return new LisSettings();
    }

    public @Bean EbeisSettings ebeisSettings() {
        return new EbeisSettings();
    }

    public @Bean CassandraSettings cassandraSettings() {
        return new CassandraSettings();
    }
}
