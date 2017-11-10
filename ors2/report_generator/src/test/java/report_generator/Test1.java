package report_generator;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.generate.api.ReportService;
import com.generate.conf.ReportGeneratorConf;
import com.generate.enums.ExportType;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
		ReportGeneratorConf.class
})
public class Test1 {

	@Autowired
	private ReportService rs;
	
	@Test
	public void t()
	{
		rs.generate("", ExportType.XLSX);
	}
	
}
