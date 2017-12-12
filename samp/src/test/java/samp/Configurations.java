package samp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.generate.conf.ReportGeneratorConf;
import com.generate.conf.ReportRepositoryConfiguration;
import com.model.conf.DBProperties;
import com.reportconfig.conf.DataSourceConfig;

@Configuration
@EnableConfigurationProperties
@Import({
	DBProperties.class,
	com.util.builders.config.Configuration.class,
	ReportGeneratorConf.class
})
public class Configurations {

	
	@Autowired
	DBProperties dbProp;
	
	@Bean
	public DataSource dataSource()
	{
		DataSourceConfig ds=new DataSourceConfig();
		
		ds.setDbProp(dbProp);
		return ds.dataSource();
	}
	
}
