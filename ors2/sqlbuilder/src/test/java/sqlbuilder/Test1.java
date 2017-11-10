package sqlbuilder;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.generate.conf.ReportGeneratorConf;
import com.generate.props.AppProperties;
import com.model.db.DatasetCorrelationDtl;
import com.repo.meta.DatasetRepository;
import com.util.builders.api.TableService;
import com.util.builders.config.Configuration;

import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
		Configuration.class,ReportGeneratorConf.class
})
public class Test1 {

	
	@Autowired
	private TableService dr;
	
//	@Autowired
//	private SqlToData std;
	
	@Autowired
	private AppProperties app;
	
	@Test
	public void t1()
	{
		TableService dc;
		
		System.out.println();
	}
	
}
