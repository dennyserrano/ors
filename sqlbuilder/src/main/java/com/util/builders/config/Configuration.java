package com.util.builders.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

//@EnableAutoConfiguration
@Import({
//	CommonRepositorySpringConfig.class,
//	EntityManagerConfig.class,
//	SpringRepositoriesConfig.class,
	BuilderServices.class
	})
public class Configuration
{
	public Configuration()
	{
		System.out.println();
	}
}