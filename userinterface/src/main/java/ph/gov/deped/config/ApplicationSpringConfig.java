package ph.gov.deped.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.stereotype.Repository;

import com.reportconfig.conf.CentralizedDatasourceReportConfig;
import com.reportconfig.conf.CentralizedRepositoriesConfiguration;

import ph.gov.deped.repo.config.CommonRepositorySpringConfig;
import ph.gov.deped.service.config.ServicesSpringConfig;
import ph.gov.deped.web.OrsHttpSessionListener;

/**
 * Created by ej on 8/15/14.
 */
@Configuration
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class
})
@EnableConfigurationProperties
@Import({
		ServicesSpringConfig.class,
        WebSpringConfig.class,
        DefaultViewConfig.class,
        CentralizedDatasourceReportConfig.class,
        CommonRepositorySpringConfig.class,
        EJBConfiguration.class
})


public class ApplicationSpringConfig {
    
    private ApplicationContext applicationContext;
    
    public void setApplicationContext(ApplicationContext applicationContext) {
    	
        this.applicationContext = applicationContext;
    }

//    public @Bean ApplicationEventPublisher applicationEventPublisher() {
//        return new RingBufferApplicationEventPublisher(8, true);
//    }
//
//    public @Bean LocalSettings localSettings() {
//        return new LocalSettings();
//    }
//
//    public @Bean OrsSettings orsSettings() {
//        return new OrsSettings();
//    }
//
//    public @Bean LisSettings lisSettings() {
//        return new LisSettings();
//    }
//
//    public @Bean EbeisSettings ebeisSettings() {
//        return new EbeisSettings();
//    }
//
//    public @Bean CassandraSettings cassandraSettings() {
//        return new CassandraSettings();
//    }
//    
    public @Bean FilterSettings filterSettings() {
        return new FilterSettings();
    }
    
    public @Bean OrsHttpSessionListener orsHttpSessionListener() {
        return new OrsHttpSessionListener();
    }
    
    public @Bean HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
}
