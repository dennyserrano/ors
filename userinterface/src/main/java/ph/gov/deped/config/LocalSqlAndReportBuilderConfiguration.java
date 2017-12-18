package ph.gov.deped.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import com.generate.conf.ReportGeneratorConfiguration;
import com.generate.core.SqlToData;
import com.reportconfig.conf.CentralizedDatasourceReportConfig;
import com.util.builders.config.SqlBuilderConfiguration;

@Configuration
@Import({
	ReportGeneratorConfiguration.class,
    SqlBuilderConfiguration.class
})
public class LocalSqlAndReportBuilderConfiguration {

	
	
}
