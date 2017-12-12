package com.generate.conf;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties
@Import({
	ReportGenProperties.class,
	ReportComponentConfiguration.class,
	ReportServicesConfiguration.class,
	ReportRepositoryConfiguration.class
	})
public class ReportGeneratorConf {

	public ReportGeneratorConf()
	{
		System.out.println();
	}
	
}
