package com.generate.core;

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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.generate.conf.ReportGenProperties;
import com.generate.enums.ExportType;
import com.generate.styles.ColumnElementExcelHeaderCellStyler;
import com.generate.styles.ColumnElementExcelValueCellStyler;
import com.generate.styles.DefaultExcelHeaderStyler;
import com.generate.xls.export.DefaultExcelCellWriter;
import com.generate.xls.export.ExcelDocumentConsolidator;
import com.generate.xls.export.XlsxExporter;
import com.util.builders.impl.ColumnElement;
import com.util.builders.impl.ColumnExpression;
import com.util.builders.impl.PrefixTable;



@Service
public class ExcelExportGeneratorImpl implements ReportGenerator<String>
{
	
	public static final String[] deletionExtension={ExportType.XLSX.getExtension(),"xml"};
	
	private static final Logger log = LogManager.getLogger(ExcelExportGeneratorImpl.class);
	
	
	private ColumnElementExcelHeaderCellStyler headerStyler=new DefaultExcelHeaderStyler();
	
	@Autowired
	private ColumnElementExcelValueCellStyler valueCellStyler;
	
	
	private DefaultExcelCellWriter cellWriter=new DefaultExcelCellWriter();
	
	@Autowired
	private ReportGenProperties props;
	
//	@Autowired
//	private DatasetService datasetService;
//	
//	@Autowired
//	private TableService tableService;
	
	@Autowired
	private SqlToData std;
	
	@Override
	public com.generate.model.File export(String sql,List<ColumnExpression> header) 
	{
		
		String filename = randomAlphabetic(8) + "." + ExportType.XLSX.getExtension();
		String baseTempPath = props.getTmpDir() + File.separator;
		String baseDownloadPath=props.getDonePath() + File.separator;
		String downloadPath = baseDownloadPath + filename;
		int chunksize=props.getChunkSize();
//		LinkedList<PrefixTable> prefixTables= datasetService.getPrefixTables(dataset);
//		PrefixTable table=tableService.generateTable(dataset);
//
//		String sql= new ServiceQueryBuilderImpl().getQuery(table);
//		List<ColumnExpression> sortedColumns= collect(new ArrayList<ColumnExpression>(), table);
		System.out.println("sql:"+toCountSql(sql));
		long dataSize= 2;//std.getDataSize(toCountSql(sql)); 
		log.debug("datasize:"+dataSize);
		
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
				String tmpFile=baseTempPath+randomAlphabetic(8)+ "." + ExportType.XLSX.getExtension();
				List<List<ColumnElement>> data=std.get(sqlRanges[x], header);
				localExporter.export(tmpFile,data);
				if(x==0)
				{
					consolidatorHeaders=new ArrayList<List<ColumnElement>>();
					consolidatorHeaders.add(data.get(0));
				}
				
				files[x]=tmpFile;
			}
			
//			prefixTables.clear();
//			sortedColumns.clear();
//			headers.clear();
			if(consolidatorHeaders!=null)
			{
				ExcelDocumentConsolidator ed=new ExcelDocumentConsolidator(new XlsxExporter(cellWriter,headerStyler,valueCellStyler),consolidatorHeaders.get(0));
				ed.consolidate(downloadPath,files);
				System.gc(); //TODO this should not be here..
				return new com.generate.model.File(filename, baseDownloadPath);
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
	
	private List<ColumnExpression> collect(List<ColumnExpression> l,PrefixTable pt)
	{
		for(ColumnExpression ce:pt.getColumns())
			l.add(ce);
		
		for(PrefixTable subPT:pt.getJoinTables().keySet())
			collect(l,subPT);
		
		return l;
	}
	
	private String toCountSql(String sql)
	{
		String s=sql.split("FROM")[1];
		return String.format("SELECT COUNT(*) FROM %s", s);
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
			if(stringFile!=null)
					Files.delete(Paths.get(new File(stringFile).getAbsolutePath()));
				
		
	}
	

}
