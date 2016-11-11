package ph.gov.deped.export;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thoughtworks.xstream.XStream;

import ph.gov.deped.config.ApplicationSpringConfig;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.service.data.api.DatasetService;
import ph.gov.deped.service.data.api.ExportService;
import ph.gov.deped.service.data.impl.BulkExcelNoStyleExportServiceImpl;
import ph.gov.deped.service.export.ExporterSpringConfig;
import ph.gov.deped.service.export.interfaces.ColumnElementFileExporter;
import ph.gov.deped.service.export.xlsx.ExcelDocumentConsolidator2;
import ph.gov.deped.service.export.xlsx.ExcelDocumentConsolidator;
import ph.gov.deped.service.export.xlsx.XlsxExporter2;
import ph.gov.deped.service.export.xlsx.XlsxExporter2;
import ph.gov.deped.service.export.xlsx.XlsxExporter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
        ApplicationSpringConfig.class,
        ExporterSpringConfig.class
})
public class ExcelExportTest 
{
	
	@Autowired
	DatasetService datasetService;
	
	@Autowired
	XlsxExporter exporter;
	
	@Autowired
	@Qualifier("BulkExcelExportServiceImpl")
	ExportService exportService;
	
	@Test
	@Ignore
	public void xlsxExportTest() throws FileNotFoundException, IOException
	{
		
		XStream s=new XStream();
		Dataset dataset=(Dataset) s.fromXML(new FileInputStream("testdata/schoolinfodataset.xml"));
		
//		List<List<ColumnElement>> l=(List<List<ColumnElement>>) s.fromXML(new FileInputStream("schoolinfolistdata.xml"));
		List<List<ColumnElement>> l=datasetService.getData(dataset, true);
		
		exporter.export(randomAlphabetic(8)+".xlsx", l);
	}
	
	@Test
	@Ignore
	public void consolidationTest() throws IOException
	{
		ArrayList<String> aFiles=new ArrayList<>();
		int cnt=0;
		try(Stream<Path> paths = Files.walk(Paths.get("/home/denny/Desktop/"))) {
		    paths.forEach(filePath -> {
		        if (Files.isRegularFile(filePath)) {
		        	if(filePath.toString().contains(".xlsx"))
		        		aFiles.add(filePath.toString());
		        }
		    });
		} 
		String[] files=new String[aFiles.size()];
		
		files= (String[]) aFiles.toArray(files);
		
		XStream s=new XStream();
		Dataset dataset=(Dataset) s.fromXML(new FileInputStream("testdata/schoolinfodataset.xml"));
		List<List<ColumnElement>> l=datasetService.getData(dataset, true);
		
		ExcelDocumentConsolidator2 consolidator=new ExcelDocumentConsolidator2("/home/denny/Desktop/output.xlsx",files);
		consolidator.consolidate(l);
		
//		ExcelDocumentConsolidator2 consolidator=new ExcelDocumentConsolidator2();
//		consolidator.setWorkbookExporter(exporter);
//		List<ColumnElement> heads=new ArrayList<ColumnElement>(l.get(0));
//		l.clear();
//		consolidator.consolidate("/home/denny/Desktop/fileOUTPUT.xlsx", files, heads);
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		br.readLine();
//		ExcelDocumentConsolidator e=new ExcelDocumentConsolidator(files);
//		e.consolidate();
	}
	
	@Test
	@Ignore
	public void conso2() throws IOException
	{
		ArrayList<String> aFiles=new ArrayList<>();
		int cnt=0;
		try(Stream<Path> paths = Files.walk(Paths.get("/home/denny/Desktop/"))) {
		    paths.forEach(filePath -> {
		        if (Files.isRegularFile(filePath)) {
		        	if(filePath.toString().contains(".xlsx"))
		        		aFiles.add(filePath.toString());
		        }
		    });
		} 
		String[] files=new String[aFiles.size()];
		
		files= (String[]) aFiles.toArray(files);
		
		XStream s=new XStream();
		Dataset dataset=(Dataset) s.fromXML(new FileInputStream("testdata/schoolinfodataset.xml"));
		List<List<ColumnElement>> l=datasetService.getData(dataset, true);
		
//		ExcelDocumentConsolidator2 consolidator=new ExcelDocumentConsolidator2(null);
//		consolidator.setWorkbookExporter(exporter);
		List<ColumnElement> heads=new ArrayList<ColumnElement>(l.get(0));
		l.clear();
//		consolidator.consolidate("/home/denny/Desktop/val/fileOUTPUT.xlsx", files, heads);
		
		System.out.println("Done");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
	}
	
	@Test
//	@Ignore
	public void bulkTest() throws FileNotFoundException, IOException
	{
		XStream s=new XStream();
		Dataset dataset=(Dataset) s.fromXML(new FileInputStream("testdata/schoolinfodataset.xml"));
		exportService.export(dataset);
	}
	
}
