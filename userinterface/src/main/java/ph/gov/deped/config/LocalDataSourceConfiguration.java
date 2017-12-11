package ph.gov.deped.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.reportconfig.conf.CentralizedDatasourceReportConfig;
import com.reportconfig.enums.ConfigurationConstants;

@Configuration
@Import({
	CentralizedDatasourceReportConfig.class
})
public class LocalDataSourceConfiguration {

	
//	@Autowired
//	@Qualifier(CentralizedDatasourceReportConfig.METADATA_DB_NAME)
//	private DataSource ds;
//	
//	@Autowired
//	@Qualifier(CentralizedDatasourceReportConfig.DATA_DB_NAME)
//	private DataSource ds2;
	
}
