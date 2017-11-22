package com.samp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.generate.conf.ReportGeneratorConf;
import com.generate.conf.ReportRepositoryConfiguration;
import com.repo.meta.DatasetRepository;
import com.reportconfig.conf.CentralizedReportConfiguration;
import com.reportconfig.conf.DataSourceConfig;

@Configuration
@EnableAutoConfiguration(exclude={
		CassandraAutoConfiguration.class
		})
@Import({
	CentralizedReportConfiguration.class
})
public class Configurations {
	
	@Autowired
	private DatasetRepository dr;

	
}
