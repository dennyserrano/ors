package com.generate.conf;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource({"classpath:db.properties"})
@EnableConfigurationProperties(DBProperties.class)
public class PropertySourceConfig {

	public static @Bean PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
        p.setLocations(new Resource[] {
                new ClassPathResource("db.properties")
        });
        p.setIgnoreResourceNotFound(true);
        p.setIgnoreUnresolvablePlaceholders(true);
        return p;
    }
	
	
	

}
