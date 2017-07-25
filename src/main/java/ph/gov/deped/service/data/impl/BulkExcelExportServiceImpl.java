package ph.gov.deped.service.data.impl;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.cassandra.cli.CliParser.newColumnFamily_return;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.thoughtworks.xstream.XStream;

import ph.gov.deped.config.OrsSettings;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.repo.jpa.ors.FormattingRepository;
import ph.gov.deped.service.data.api.DatasetService;
import ph.gov.deped.service.data.api.ExportBulkService;
import ph.gov.deped.service.data.api.ExportServiceOld;
import ph.gov.deped.service.data.api.ExportType;
import ph.gov.deped.service.export.interfaces.ColumnElementWorkbookAppender;
import ph.gov.deped.service.export.xlsx.DefaultExcelCellWriter;
import ph.gov.deped.service.export.xlsx.ExcelDocumentConsolidator;
import ph.gov.deped.service.export.xlsx.XlsxExporter;
import ph.gov.deped.service.export.xlsx.stylers.interfaces.ColumnElementExcelHeaderCellStyler;
import ph.gov.deped.service.export.xlsx.stylers.interfaces.ColumnElementExcelValueCellStyler;
import ph.gov.deped.web.admin.ExportDataController;

@Service("BulkExcelExportServiceImpl")
@Qualifier("BulkExcelExportServiceImpl")
public class BulkExcelExportServiceImpl extends ExcelExportServiceImpl
{
	
	public static final String[] deletionExtension={ExportType.XLSX.getExtension(),"xml"};
	
	private static final Logger log = LogManager.getLogger(BulkExcelExportServiceImpl.class);
	
	@Autowired
	private ColumnElementExcelHeaderCellStyler headerStyler;
	
	@Autowired
	private ColumnElementExcelValueCellStyler valueCellStyler;
	
	@Autowired
	private DefaultExcelCellWriter cellWriter;
	
	@Autowired
	private DatasetService datasetService;
	
	@Override
	public String export(Dataset dataset) 
	{
		
		String filename = randomAlphabetic(8) + "." + exportType.getExtension();
		String baseTempPath = orsSettings.getTmpDir() + File.separator;
		String downloadPath = orsSettings.getWorkingDir() + File.separator + filename;
		int chunksize=orsSettings.getChunkSize();
		LinkedList<PrefixTable> prefixTables= datasetService.getPrefixTables(dataset);
		LinkedList<ColumnElement> sortedColumns= datasetService.getSortedColumns(prefixTables);
		String sql= datasetService.getGeneratedSQL(dataset, prefixTables);
		log.debug("sql:"+toCountSql(sql));
		long dataSize= datasetService.getDataSize(toCountSql(sql)); 
		log.debug("datasize:"+dataSize);
		LinkedList<ColumnElement> headers= datasetService.getHeaders(sortedColumns);
		
		String[] sqlRanges=generateRanges(sql,dataSize,chunksize);
		log.debug("ranges:"+sqlRanges.length);
		
		List<List<ColumnElement>> consolidatorHeaders = null;
		
		XlsxExporter localExporter=new XlsxExporter(cellWriter);
		
		String[] files=new String[sqlRanges.length];
		try
		{
			for(int x=0;x<sqlRanges.length;x++)
			{
				System.out.println("generating:"+sqlRanges[x]);
				String tmpFile=baseTempPath+randomAlphabetic(8)+ "." + exportType.getExtension();
				List<List<ColumnElement>> data=datasetService.getData(sqlRanges[x], prefixTables, sortedColumns,headers);
				localExporter.export(tmpFile,data);
				if(x==0)
				{
					consolidatorHeaders=new ArrayList<List<ColumnElement>>();
					consolidatorHeaders.add(data.get(0));
				}
				
				files[x]=tmpFile;
			}
			
			prefixTables.clear();
			sortedColumns.clear();
//			headers.clear();
			if(consolidatorHeaders!=null)
			{
				ExcelDocumentConsolidator ed=new ExcelDocumentConsolidator(new XlsxExporter(cellWriter,headerStyler,valueCellStyler),consolidatorHeaders.get(0));
				ed.consolidate(downloadPath,files);
				System.gc(); //TODO this should not be here..
				return downloadPath;
			}
			
			
			return null;
			
		}catch(RuntimeException e)
		{
			throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} 
		finally
		{
			try {
				cleanup(files);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
	}
	
	private String toCountSql(String sql)
	{
		String s=sql.split("FROM")[1];
		return String.format("SELECT COUNT(*) FROM %s", s);
	}
	
	protected void writeFormatMetadata(String fileName,List<List<ColumnElement>> data) throws FileNotFoundException
	{
		XStream xstream=new XStream();
		xstream.toXML(data, new FileOutputStream(fileName));
	}
	
	private String[] generateRanges(String sql,long dataSize,double perRecordProcess)
    {
    	 long numberOfGenerations=(long) Math.ceil(dataSize/perRecordProcess);
    	 String[] fArr=new String[(int)numberOfGenerations];
    	 for(long x=0,min=0,max=(long) perRecordProcess;x<numberOfGenerations;x++,min+=max)
    	 {
    		 StringBuffer sb=new StringBuffer(sql);
    		 sb.append(" LIMIT "+min+","+max);
    		 fArr[(int) x]=sb.toString();
    	 }
    	
    	 return fArr;
    }
	
	private void cleanup(String[] files) throws IOException
	{
		
		for(String stringFile:files)
				Files.delete(Paths.get(new File(stringFile).getAbsolutePath()));
		
	}
	

}
