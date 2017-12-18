package ph.gov.deped.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import com.generate.core.SqlToData;
import com.model.conf.DataDBProperties;
import com.model.conf.MetaDBProperties;
import com.reportconfig.conf.CentralizedDatasourceReportConfig;
import com.reportconfig.enums.ConfigurationConstants;

@Configuration
@Import({
	CentralizedDatasourceReportConfig.class
})
public class LocalDataSourceConfiguration {

	
	@Autowired
    private SqlToData std;
    
    @Autowired
    @Qualifier(CentralizedDatasourceReportConfig.METADATA_DB_NAME)
    private DataSource ds2;
    
    @Autowired
    private DataDBProperties dataProp;
    
    @Bean
    @Primary
    public SqlToData getStd()
    {
    	std.setDataSource(ds2);
    	return std;
    }

	
}
