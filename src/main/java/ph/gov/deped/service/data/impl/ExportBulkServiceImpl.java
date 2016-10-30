package ph.gov.deped.service.data.impl;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.service.data.api.DatasetService;
import ph.gov.deped.service.data.api.ExportBulkService;
import ph.gov.deped.service.data.api.ExportService;
import ph.gov.deped.service.data.api.ExportType;

@Service
public class ExportBulkServiceImpl implements ExportBulkService 
{

	@Autowired
	private DatasetService datasetService;
	
	@Autowired
	private ExportService exportService;
	
	@Override
	public String export(Dataset dataset, ExportType exportType) 
	{
		LinkedList<PrefixTable> prefixTables= datasetService.getPrefixTables(dataset);
		System.out.println("prefix tables:"+prefixTables.size());
		LinkedList<ColumnElement> sortedColumns= datasetService.getSortedColumns(prefixTables);
		System.out.println("sorted columns:"+sortedColumns.size());
		String sql= datasetService.getGeneratedSQL(dataset, prefixTables);
		System.out.println("sql:"+sql);
		long dataSize= datasetService.getDataSize(sql);
		System.out.println("datasize:"+dataSize);
		
		String[] sqlRanges=generateRanges(sql,dataSize,10000);
		System.out.println("ranges:"+sqlRanges.length);
		
		for(int x=0;x<sqlRanges.length;x++)
		{
			System.out.println("generating:"+sqlRanges[x]);
			exportService.export(null, datasetService.getData(sqlRanges[x], prefixTables, sortedColumns), exportType);
		}
		
		return null;
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
