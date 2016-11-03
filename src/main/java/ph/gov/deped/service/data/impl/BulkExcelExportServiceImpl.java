package ph.gov.deped.service.data.impl;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.gov.deped.config.OrsSettings;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.service.data.api.DatasetService;
import ph.gov.deped.service.data.api.ExportBulkService;
import ph.gov.deped.service.data.api.ExportServiceOld;
import ph.gov.deped.service.data.api.ExportType;
import ph.gov.deped.service.export.xlsx.ExcelDocumentConsolidator;

@Service
public class BulkExcelExportServiceImpl extends ExcelExportServiceImpl
{
	
	@Override
	public String export(Dataset dataset) 
	{
		
		String filename = randomAlphabetic(8) + "." + exportType.getExtension();
		String baseTempPath = orsSettings.getTmpDir() + File.separator;
		String downloadPath = orsSettings.getWorkingDir() + File.separator + filename;
		
		LinkedList<PrefixTable> prefixTables= datasetService.getPrefixTables(dataset);
		System.out.println("prefix tables:"+prefixTables.size());
		LinkedList<ColumnElement> sortedColumns= datasetService.getSortedColumns(prefixTables);
		System.out.println("sorted columns:"+sortedColumns.size());
		String sql= datasetService.getGeneratedSQL(dataset, prefixTables);
		System.out.println("sql:"+sql);
		long dataSize= 49407;//datasetService.getDataSize(sql);
		System.out.println("datasize:"+dataSize);
		LinkedList<ColumnElement> headers= datasetService.getHeaders(sortedColumns);
		
		String[] sqlRanges=generateRanges(sql,dataSize,500);
		System.out.println("ranges:"+sqlRanges.length);
		
		String[] files=new String[sqlRanges.length];
		
		for(int x=0;x<sqlRanges.length;x++)
		{
			System.out.println("generating:"+sqlRanges[x]);
//			files[x]=exporter.export(baseTempPath+randomAlphabetic(8),datasetService.getData(sqlRanges[x], prefixTables, sortedColumns,headers));
			String tmpFile=baseTempPath+randomAlphabetic(8)+ "." + exportType.getExtension();
			exporter.export(tmpFile,datasetService.getData(sqlRanges[x], prefixTables, sortedColumns,headers));
			files[x]=tmpFile;
		}
		
		prefixTables.clear();
		sortedColumns.clear();
		headers.clear();
		
		try {
			new ExcelDocumentConsolidator(downloadPath,files).consolidate();;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.gc();
		
		return downloadPath;
	}
	
	private static String[] generateRanges(String sql,long dataSize,double perRecordProcess)
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

}
