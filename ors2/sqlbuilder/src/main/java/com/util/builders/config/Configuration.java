package com.util.builders.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@EnableConfigurationProperties
@EnableAutoConfiguration
@Import({
	PropertySourceConfig.class,
	DataSourceConfig.class,
	CommonRepositorySpringConfig.class,
	EntityManagerConfig.class,
	SpringRepositoriesConfig.class
	
//	BuilderServices.class
	})
public class Configuration
{
	
}
