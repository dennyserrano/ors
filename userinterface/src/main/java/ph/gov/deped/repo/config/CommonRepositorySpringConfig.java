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

import java.sql.Connection;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.AUTO_CLOSE_SESSION;
import static org.hibernate.cfg.AvailableSettings.BATCH_VERSIONED_DATA;
import static org.hibernate.cfg.AvailableSettings.BYTECODE_PROVIDER;
import static org.hibernate.cfg.AvailableSettings.CACHE_REGION_FACTORY;
import static org.hibernate.cfg.AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS;
import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.cfg.AvailableSettings.FLUSH_BEFORE_COMPLETION;
import static org.hibernate.cfg.AvailableSettings.FORMAT_SQL;
import static org.hibernate.cfg.AvailableSettings.GENERATE_STATISTICS;
import static org.hibernate.cfg.AvailableSettings.ISOLATION;
import static org.hibernate.cfg.AvailableSettings.JTA_PLATFORM;
import static org.hibernate.cfg.AvailableSettings.ORDER_UPDATES;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.STATEMENT_BATCH_SIZE;
import static org.hibernate.cfg.AvailableSettings.USE_QUERY_CACHE;
import static org.hibernate.cfg.AvailableSettings.USE_REFLECTION_OPTIMIZER;
import static org.hibernate.cfg.AvailableSettings.USE_SECOND_LEVEL_CACHE;
import static org.hibernate.cfg.AvailableSettings.USE_STRUCTURED_CACHE;
import static org.hibernate.jpa.AvailableSettings.AUTODETECTION;
import static org.hibernate.jpa.AvailableSettings.FLUSH_MODE;
import static org.hibernate.jpa.AvailableSettings.NAMING_STRATEGY;
import static org.hibernate.jpa.AvailableSettings.PROVIDER;
import static org.hibernate.jpa.AvailableSettings.SHARED_CACHE_MODE;
import static org.hibernate.jpa.AvailableSettings.TRANSACTION_TYPE;
import static org.hibernate.jpa.AvailableSettings.VALIDATION_MODE;

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
