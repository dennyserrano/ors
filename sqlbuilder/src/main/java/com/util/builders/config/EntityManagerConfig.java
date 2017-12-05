package com.util.builders.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;



@Configuration
public class EntityManagerConfig {

	private @Autowired EntityManagerFactoryBuilder emfBuilder;
	
    @Autowired
    private DataSource dataSource;
    
    private @Autowired @Qualifier(CommonRepositorySpringConfig.JPA_PROPERTIES_QUALIFIER) Properties jpaProperties;
    
    
	public @Bean @Primary LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		Map<String, String> map = new HashMap<>();
        jpaProperties.stringPropertyNames()
                .stream()
                .forEach(s -> map.put(s, jpaProperties.getProperty(s)));
		
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(false);
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        jpaVendorAdapter.setDatabasePlatform(MySQL5InnoDBDialect.class.getName());
        jpaVendorAdapter.setShowSql(true);
		
		
        LocalContainerEntityManagerFactoryBean emf = emfBuilder.dataSource(dataSource).build();
        emf.setJtaDataSource(dataSource);
        emf.setJpaDialect(new HibernateExtendedJpaDialect());
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPackagesToScan("com.model");
//        emf.setPersistenceUnitName("ORS_PU");
        emf.setPersistenceProvider(new HibernatePersistenceProvider());
        emf.setJpaPropertyMap(map);
        return emf;
    }
	
}
