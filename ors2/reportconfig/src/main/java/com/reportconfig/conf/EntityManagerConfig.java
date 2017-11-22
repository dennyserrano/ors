//package com.reportconfig.conf;
//
//import static org.hibernate.cfg.AvailableSettings.AUTO_CLOSE_SESSION;
//import static org.hibernate.cfg.AvailableSettings.BATCH_VERSIONED_DATA;
//import static org.hibernate.cfg.AvailableSettings.BYTECODE_PROVIDER;
//import static org.hibernate.cfg.AvailableSettings.CACHE_REGION_FACTORY;
//import static org.hibernate.cfg.AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS;
//import static org.hibernate.cfg.AvailableSettings.DIALECT;
//import static org.hibernate.cfg.AvailableSettings.FLUSH_BEFORE_COMPLETION;
//import static org.hibernate.cfg.AvailableSettings.FORMAT_SQL;
//import static org.hibernate.cfg.AvailableSettings.GENERATE_STATISTICS;
//import static org.hibernate.cfg.AvailableSettings.ISOLATION;
//import static org.hibernate.cfg.AvailableSettings.JTA_PLATFORM;
//import static org.hibernate.cfg.AvailableSettings.ORDER_UPDATES;
//import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
//import static org.hibernate.cfg.AvailableSettings.STATEMENT_BATCH_SIZE;
//import static org.hibernate.cfg.AvailableSettings.USE_QUERY_CACHE;
//import static org.hibernate.cfg.AvailableSettings.USE_REFLECTION_OPTIMIZER;
//import static org.hibernate.cfg.AvailableSettings.USE_SECOND_LEVEL_CACHE;
//import static org.hibernate.cfg.AvailableSettings.USE_STRUCTURED_CACHE;
//import static org.hibernate.jpa.AvailableSettings.AUTODETECTION;
//import static org.hibernate.jpa.AvailableSettings.FLUSH_MODE;
//import static org.hibernate.jpa.AvailableSettings.NAMING_STRATEGY;
//import static org.hibernate.jpa.AvailableSettings.SHARED_CACHE_MODE;
//import static org.hibernate.jpa.AvailableSettings.VALIDATION_MODE;
//
//import java.sql.Connection;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
//import javax.persistence.Persistence;
//import javax.sql.DataSource;
//
//import org.hibernate.cache.internal.NoCachingRegionFactory;
//import org.hibernate.context.internal.ThreadLocalSessionContext;
//import org.hibernate.dialect.MySQL5InnoDBDialect;
//import org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform;
//import org.hibernate.jpa.HibernatePersistenceProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.context.annotation.Primary;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.Database;
//import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//
//
//@Configuration
//public class EntityManagerConfig {
//
////	private @Autowired EntityManagerFactoryBuilder emfBuilder;
//	
//    @Autowired
//    @Qualifier("reportconfig_metaDataDBDataSource")
//    private DataSource dataSource;
//    
//    private @Autowired Properties jpaProperties;
//
//    @Bean("reportconfig_entityManagerFactory") 
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder)
//    {
//    	
//    	Map<String, String> map = new HashMap<>();
//        jpaProperties.stringPropertyNames()
//                .stream()
//                .forEach(s -> map.put(s, jpaProperties.getProperty(s)));
//      return builder
//        .dataSource(dataSource)
//        .packages("com.model")
//        .persistenceUnit("ORS_PU")
////        .properties(map)
//        .build();
//    }
//
////    @Bean
////    @Primary 
////	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
////		
////		Map<String, String> map = new HashMap<>();
////        jpaProperties.stringPropertyNames()
////                .stream()
////                .forEach(s -> map.put(s, jpaProperties.getProperty(s)));
////		
////		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
////        jpaVendorAdapter.setGenerateDdl(false);
////        jpaVendorAdapter.setDatabase(Database.MYSQL);
////        jpaVendorAdapter.setDatabasePlatform(MySQL5InnoDBDialect.class.getName());
////        jpaVendorAdapter.setShowSql(true);
////		
////		
////        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
////        emf.setJtaDataSource(dataSource);
//////        emf.setJpaDialect(new HibernateExtendedJpaDialect());
////        emf.setJpaVendorAdapter(jpaVendorAdapter);
////        emf.setPackagesToScan("com.model");
////        emf.setPersistenceUnitName("ORS_PU");
////        emf.setPersistenceProvider(new HibernatePersistenceProvider());
////        emf.setJpaPropertyMap(map);
////        
////        return emf;
////    }
////	
//	
//	
//    
//}
