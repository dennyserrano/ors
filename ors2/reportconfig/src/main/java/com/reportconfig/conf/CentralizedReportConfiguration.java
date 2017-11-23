package com.reportconfig.conf;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@EnableAutoConfiguration(exclude={
//		LiquibaseAutoConfiguration.class,
//		CassandraDataAutoConfiguration.class
//})
@Import({
	CentralizedDatasourceReportConfig.class,
//	EntityManagerConfig.class,
//	CentralizedReportServicesConfiguration.class
	})
public class CentralizedReportConfiguration {

}
