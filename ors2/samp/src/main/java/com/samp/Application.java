package com.samp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.SpringServletContainerInitializer;

import com.reportconfig.conf.CentralizedReportConfiguration;

@SpringBootApplication
public class Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] {Configurations.class}, args).registerShutdownHook();;
//		new Configurations();
	}
	

}
