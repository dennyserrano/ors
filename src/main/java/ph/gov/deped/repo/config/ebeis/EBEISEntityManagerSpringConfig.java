package ph.gov.deped.repo.config.ebeis;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import ph.gov.deped.common.EbeisMetadata;
import ph.gov.deped.config.EbeisSettings;
import ph.gov.deped.repo.config.CommonRepositorySpringConfig;
import ph.gov.deped.repo.config.HibernateExtendedJpaDialect;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by ej on 8/5/14.
 */
@Configuration
@PropertySource({"classpath:" + EbeisMetadata.EBEIS_PROPS})
public class EBEISEntityManagerSpringConfig implements EbeisMetadata {

    public static @Bean PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
        p.setLocations(new Resource[] {
                new ClassPathResource(EBEIS_PROPS)
        });
        p.setIgnoreUnresolvablePlaceholders(true);
        p.setIgnoreResourceNotFound(true);
        return p;
    }

    private @Autowired @Qualifier(DS) DataSource ebeisDataSource;

    private @Autowired @Qualifier(CommonRepositorySpringConfig.JPA_PROPERTIES_QUALIFIER) Properties jpaProperties;

    private @Autowired EntityManagerFactoryBuilder emfBuilder;

    private @Autowired EbeisSettings ebeisSettings;

    private @Autowired HibernateJpaVendorAdapter jpaVendorAdapter;

    private @Autowired HibernateExtendedJpaDialect jpaDialect;

    private @Autowired HibernatePersistenceProvider persistenceProvider;

    public @Bean(name = EMF) @Qualifier(EMF) LocalContainerEntityManagerFactoryBean ebeisEntityManagerFactory() {
        Map<String, String> map = new HashMap<>();
        jpaProperties.stringPropertyNames()
                .stream()
                .forEach(s -> map.put(s, jpaProperties.getProperty(s)));
        LocalContainerEntityManagerFactoryBean emf = emfBuilder.dataSource(ebeisDataSource).build();
        emf.setJtaDataSource(ebeisDataSource);
        emf.setJpaDialect(jpaDialect);
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPackagesToScan(ebeisSettings.getPersistenceScanPackages().split(","));
        emf.setPersistenceUnitName(ebeisSettings.getPersistenceUnitName());
        emf.setPersistenceProvider(persistenceProvider);
        emf.setJpaPropertyMap(map);
        return emf;
    }
}
