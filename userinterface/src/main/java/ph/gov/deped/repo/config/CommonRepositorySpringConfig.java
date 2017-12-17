package ph.gov.deped.repo.config;

import org.hibernate.cache.internal.NoCachingRegionFactory;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Repository;


/**
 * Created by ej on 8/5/14.
 */
@Configuration
@EntityScan("com.model")
@EnableJpaRepositories(
        basePackages = {"ph.gov.deped.repo.jpa.ors.ds2",
        		"com.repo"
        		},
        includeFilters = {
                @ComponentScan.Filter(value = Repository.class, type = FilterType.ANNOTATION)
        }
)
public class CommonRepositorySpringConfig {

    
}
