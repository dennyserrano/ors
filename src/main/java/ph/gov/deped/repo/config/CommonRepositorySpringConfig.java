package ph.gov.deped.repo.config;

import org.hibernate.cache.internal.NoCachingRegionFactory;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.SpringNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

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
public class CommonRepositorySpringConfig {

    public static final String JPA_PROPERTIES_QUALIFIER = "jpaProperties";

    private static final String AUTODETECTION_MODE = "class, hbm";

    private static final String DEFAULT_STATEMENT_BATCH_SIZE = "10";

    private static final String COMMIT = "commit";

    private static final String NONE = "NONE";

    private static final String ENABLE_SELECTIVE_SHARED_CACHE_MODE = "ENABLE_SELECTIVE";

    private static final String HIBERNATE_BYTECODE_PROVIDER_CGLIB = "cglib";

    private static final String TRANSACTION_TYPE_VALUE = "RESOURCE_LOCAL";

    private static final String TRUE = Boolean.TRUE.toString();

    private static final String FALSE = Boolean.FALSE.toString();

    public @Bean HibernateJpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(false);
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        jpaVendorAdapter.setDatabasePlatform(MySQL5InnoDBDialect.class.getName());
        jpaVendorAdapter.setShowSql(true);
        return jpaVendorAdapter;
    }

    public @Primary @Bean HibernateExtendedJpaDialect jpaDialect() {
        return new HibernateExtendedJpaDialect();
    }

    public @Bean HibernatePersistenceProvider persistenceProvider() {
        return new HibernatePersistenceProvider();
    }

    @Bean
    @Qualifier(JPA_PROPERTIES_QUALIFIER)
    public Properties jpaProps() {
        Properties props = new Properties();
        props.setProperty(DIALECT, MySQL5InnoDBDialect.class.getName());
        props.setProperty(ISOLATION, String.valueOf(Connection.TRANSACTION_READ_COMMITTED));
        props.setProperty(NAMING_STRATEGY, SpringNamingStrategy.class.getName());
        props.setProperty(FLUSH_BEFORE_COMPLETION, TRUE);
        props.setProperty(AUTO_CLOSE_SESSION, TRUE);
        props.setProperty(AUTODETECTION, AUTODETECTION_MODE);
        props.setProperty(GENERATE_STATISTICS, TRUE);
        props.setProperty(SHOW_SQL, TRUE);
        props.setProperty(FORMAT_SQL, TRUE);
        props.setProperty(ORDER_UPDATES, TRUE);
        props.setProperty(JTA_PLATFORM, NoJtaPlatform.class.getName());
        props.setProperty(CURRENT_SESSION_CONTEXT_CLASS, ThreadLocalSessionContext.class.getName());
        props.setProperty(STATEMENT_BATCH_SIZE, DEFAULT_STATEMENT_BATCH_SIZE);
        props.setProperty(BATCH_VERSIONED_DATA, TRUE);
        props.setProperty(FLUSH_BEFORE_COMPLETION, TRUE);
        props.setProperty(CACHE_REGION_FACTORY, NoCachingRegionFactory.class.getName());
        props.setProperty(USE_SECOND_LEVEL_CACHE, FALSE);
        props.setProperty(USE_STRUCTURED_CACHE, FALSE);
        props.setProperty(USE_QUERY_CACHE, FALSE);
        props.setProperty(VALIDATION_MODE, NONE);
        props.setProperty(FLUSH_MODE, COMMIT);
        props.setProperty(SHARED_CACHE_MODE, ENABLE_SELECTIVE_SHARED_CACHE_MODE);
        props.setProperty(BYTECODE_PROVIDER, HIBERNATE_BYTECODE_PROVIDER_CGLIB);
        props.setProperty(USE_REFLECTION_OPTIMIZER, TRUE);
        additionalProperties(props);
        return props;
    }

    protected void additionalProperties(Properties props) {
        props.setProperty(TRANSACTION_TYPE, TRANSACTION_TYPE_VALUE);
        props.setProperty(PROVIDER, HibernatePersistenceProvider.class.getName());
    }
}
