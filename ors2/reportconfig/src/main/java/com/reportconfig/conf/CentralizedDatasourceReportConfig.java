package com.reportconfig.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.model.conf.DBProperty;
import com.model.conf.DataDBProperties;
import com.model.conf.MetaDBProperties;

@Configuration
@EnableConfigurationProperties
@Import({
	MetaDBProperties.class,
	DataDBProperties.class})
public class CentralizedDatasourceReportConfig {

	@Autowired
	@Qualifier("reportconfig_metaDBProperty")
	private DBProperty metaDataDBProp;
	
	@Autowired
	@Qualifier("reportconfig_dataDBProperty")
	private DBProperty dataDBProp;
	
	@Bean
	@Qualifier("reportconfig_metaDataDBDataSource")
	public DataSource getMetaDataSource()
	{
		DataSourceConfig dsc= new DataSourceConfig();
		dsc.setDbProp(metaDataDBProp);
		return dsc.dataSource();
	}
	
	@Bean
	@Qualifier("reportconfig_dataDBDataSource")
	public DataSource getDataDBSource()
	{
		
		DataSourceConfig dsc= new DataSourceConfig();
		dsc.setDbProp(dataDBProp);
		return dsc.dataSource();
	}
	
}
