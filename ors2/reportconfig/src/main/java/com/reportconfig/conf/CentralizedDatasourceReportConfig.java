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
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.model.conf.DBProperty;
import com.model.conf.DataDBProperties;
import com.model.conf.MetaDBProperties;
import com.reportconfig.enums.ConfigurationConstants;

@Configuration
//@EnableConfigurationProperties
@Import({
	MetaDBProperties.class,
	DataDBProperties.class})

public class CentralizedDatasourceReportConfig {

	@Autowired
	@Qualifier(ConfigurationConstants.METADATA_DB_PROPERTIES_NAME)
	private DBProperty metaDataDBProp;
	
	@Autowired
	@Qualifier(ConfigurationConstants.DATA_DB_PROPERTIES_NAME)
	private DBProperty dataDBProp;
	
	@Bean
	@Primary
	@Qualifier(ConfigurationConstants.METADATA_DB_DATASOURCE)
	public DataSource getMetaDataSource()
	{
		DataSourceConfig dsc= new DataSourceConfig();
		dsc.setDbProp(metaDataDBProp);
		return dsc.dataSource();
	}
	
	@Bean
	@Qualifier(ConfigurationConstants.DATA_DB_DATASOURCE)
	public DataSource getDataDBSource()
	{
		
		DataSourceConfig dsc= new DataSourceConfig();
		dsc.setDbProp(dataDBProp);
		return dsc.dataSource();
	}
	
}
