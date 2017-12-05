package com.samp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration.LiquibaseConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//import com.generate.conf.ReportGeneratorConf;
import com.generate.conf.ReportRepositoryConfiguration;
import com.repo.meta.DatasetRepository;
//import com.reportconfig.conf.CentralizedReportConfiguration;
import com.reportconfig.conf.CentralizedRepositoriesConfiguration;
import com.reportconfig.conf.DataSourceConfig;
import com.reportconfig.enums.ConfigurationConstants;

@Configuration
@EnableConfigurationProperties
@EnableAutoConfiguration(exclude={
		CassandraAutoConfiguration.class,
		CassandraDataAutoConfiguration.class,
		LiquibaseAutoConfiguration.class,
		})
@Import({
//	CentralizedReportConfiguration.class,
	CentralizedRepositoriesConfiguration.class
})
public class Configurations {
	
	@Autowired
	@Qualifier(ConfigurationConstants.DATA_DB_DATASOURCE)
	private DataSource dataDBDataSource;
	
	@Autowired
	@Qualifier(ConfigurationConstants.METADATA_DB_DATASOURCE)
	private DataSource metaDBDataSource;
	
	@Bean(com.generate.enums.ConfigurationConstants.DATA_SOURCE_NAME)
	public DataSource getDS1()
	{
		return dataDBDataSource;
	}
	
}
