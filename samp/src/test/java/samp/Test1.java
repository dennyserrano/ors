//package samp;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.generate.api.ReportService;
//import com.generate.enums.ConfigurationConstants;
//import com.generate.enums.ExportType;
//import com.model.support.Dataset;
//import com.reportconfig.conf.CentralizedReportConfiguration;
//import com.samp.Configurations;
//import com.thoughtworks.xstream.XStream;
//import com.util.builders.api.ServiceQueryBuilderImpl;
//import com.util.builders.api.TableService;
//import com.util.builders.impl.ColumnExpression;
//import com.util.builders.impl.PrefixTable;
//
//
//
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes=Configurations.class)
//public class Test1 {
//
//	@Autowired
//	TableService ts;
//////	
//	@Autowired
//	ReportService rs;
//	
//	@Test
//	public void test() throws JsonParseException, JsonMappingException, FileNotFoundException, IOException
//	{
//		System.out.println();
//		XStream xs=new XStream();
//		Dataset ds=(Dataset) xs.fromXML(new FileInputStream(new File("/home/denny/dataset.xml")));
////		ds.setId(8L);
////		PrefixTable pt=ts.generateTable(ds);
////		String sql=new ServiceQueryBuilderImpl().getQuery(pt);
//////		System.out.println(sql);
////		List<ColumnExpression> header=collect(new ArrayList<>(), pt);
////		rs.generate(sql,header, ExportType.XLSX);
//	}
//	private List<ColumnExpression> collect(List<ColumnExpression> l,PrefixTable pt)
//	{
//		for(ColumnExpression ce:pt.getColumns())
//			l.add(ce);
//		
//		for(PrefixTable subPT:pt.getJoinTables().keySet())
//			collect(l,subPT);
//		
//		return l;
//	}
//	
//	
//}
