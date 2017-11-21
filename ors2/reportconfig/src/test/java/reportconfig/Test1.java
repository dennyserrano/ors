package reportconfig;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.model.conf.MetaDBProperties;
import com.model.db.DatasetCorrelation;
import com.model.db.DatasetCorrelationGroupDtl;
import com.model.db.DatasetHead;
import com.model.support.Dataset;
import com.repo.meta.DatasetRepository;
import com.reportconfig.conf.CentralizedDatasourceReportConfig;
import com.reportconfig.conf.CentralizedReportConfiguration;
import com.reportconfig.conf.DataSourceConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=CentralizedReportConfiguration.class)
public class Test1 {

	@Autowired
	private DatasetRepository dr;
	
	@Test
	public void t()
	{
		List<DatasetHead> l=dr.findAll();
		
//		MetaDBProperties m;
		System.out.println("hello");
	}
	
}
