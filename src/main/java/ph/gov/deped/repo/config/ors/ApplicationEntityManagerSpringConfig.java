package ph.gov.deped.repo.config.ors;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.config.OrsSettings;
import ph.gov.deped.repo.config.CommonRepositorySpringConfig;
import ph.gov.deped.repo.config.HibernateExtendedJpaDialect;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by ej on 8/15/14.
 */
@Configuration
@PropertySource({"classpath:" + AppMetadata.PROPS})
public class ApplicationEntityManagerSpringConfig implements AppMetadata {

    public static @Bean PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
        p.setLocations(new Resource[] {
                new ClassPathResource(PROPS)
        });
        p.setIgnoreResourceNotFound(true);
        p.setIgnoreUnresolvablePlaceholders(true);
        return p;
    }

    private @Autowired @Qualifier(DS) DataSource dataSource;

    private @Autowired @Qualifier(CommonRepositorySpringConfig.JPA_PROPERTIES_QUALIFIER) Properties jpaProperties;

    private @Autowired EntityManagerFactoryBuilder emfBuilder;

    private @Autowired OrsSettings orsSettings;

    private @Autowired HibernateJpaVendorAdapter jpaVendorAdapter;

    private @Autowired HibernateExtendedJpaDialect jpaDialect;

    private @Autowired HibernatePersistenceProvider persistenceProvider;

    public @Bean @Primary LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        Map<String, String> map = new HashMap<>();
        jpaProperties.stringPropertyNames()
                .stream()
                .forEach(s -> map.put(s, jpaProperties.getProperty(s)));
        LocalContainerEntityManagerFactoryBean emf = emfBuilder.dataSource(dataSource).build();
        emf.setJtaDataSource(dataSource);
        emf.setJpaDialect(jpaDialect);
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPackagesToScan(orsSettings.getEmfPackages().split(","));
        emf.setPersistenceUnitName(orsSettings.getPersistenceUnitName());
        emf.setPersistenceProvider(persistenceProvider);
        emf.setJpaPropertyMap(map);
        return emf;
    }
}
