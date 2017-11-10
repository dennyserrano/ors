package samp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.generate.api.ReportService;
import com.generate.conf.ReportGeneratorConf;
import com.model.db.DatasetCorrelationDtl;
import com.model.support.Dataset;
import com.repo.meta.DatasetRepository;
import com.thoughtworks.xstream.XStream;
import com.util.builders.api.ServiceQueryBuilderImpl;
import com.util.builders.api.TableService;
import com.util.builders.config.Configuration;
import com.util.builders.impl.PrefixTable;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
		Configuration.class,ReportGeneratorConf.class
})
public class Test1 {

	@Autowired
	TableService ts;
	
	@Autowired
	ReportService std;
	
	@Test
	public void test() throws JsonParseException, JsonMappingException, FileNotFoundException, IOException
	{
		
//		XStream xs=new XStream();
//		Dataset ds=(Dataset) xs.fromXML(new FileInputStream(new File("/home/denny/dataset.xml")));
//		ds.setId(8L);
//		PrefixTable pt=ts.generateTable(ds);
	}
	
}
