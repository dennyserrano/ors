package com.generate.conf;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@EnableConfigurationProperties
@EnableAutoConfiguration
@Import({
	PropertySourceConfig.class,
	DataSourceConfig.class,
	ReportServicesConfiguration.class,
	ReportComponentConfiguration.class,
	ReportRepositoryConfiguration.class
	})
public class Configuration
{
	public Configuration()
	{
		System.out.println();
	}
}
