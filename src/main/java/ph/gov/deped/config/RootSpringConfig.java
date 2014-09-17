package ph.gov.deped.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ph.gov.deped.data.config.DataSpringConfig;
import ph.gov.deped.repo.config.EntityManagerSpringConfig;
import ph.gov.deped.repo.config.RepositorySpringConfig;
import ph.gov.deped.security.SecuritySpringConfig;
import ph.gov.deped.service.config.ServicesSpringConfig;

/**
 * Created by ej on 8/22/14.
 */
@Configuration
@Import({
        SecuritySpringConfig.class,
        // Data Sources Spring configurations
        DataSpringConfig.class,
        EntityManagerSpringConfig.class,
        // Repository Spring configurations
        RepositorySpringConfig.class,
        // Services Spring configuration
        ServicesSpringConfig.class
})
public class RootSpringConfig {
}
