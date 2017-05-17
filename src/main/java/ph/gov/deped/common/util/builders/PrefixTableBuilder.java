package ph.gov.deped.common.util.builders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import ph.gov.deped.common.util.ConvertUtil;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.EqualityOperatorType;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.ors.ds.DatasetCorrelation;
import ph.gov.deped.data.ors.ds.DatasetCorrelationDtl;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroup;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroupDtl;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;

public class PrefixTableBuilder 
{

	private CorrelationGroupBuilder correlationGroupBuilder;
	public PrefixTableBuilder() {
		correlationGroupBuilder=new CorrelationGroupBuilder();
	}
	
	public PrefixTable build(DatasetHead dh)
	{
		PrefixTable pt= new PrefixTable(dh, dh.getTableMetaData());
		
		for(DatasetElement de:dh.getDatasetElements())
			pt.addColumn(new ColumnElement(de, de.getColumnMetaData()));
		AutoJoinTableResult autoResult= findAutoJoinTables(dh);
	    for(Entry<PrefixTable, JoinProperty>  entry: autoResult.getMap().entrySet())
	    	pt.addJoin(entry.getKey(), entry.getValue());
	    
	    pt.setTablePrefix(autoResult.headPrefix);
		return pt;
		
	}
	
	public PrefixTable lightBuild(DatasetHead dh) //no auto join included
	{
		PrefixTable pt=new PrefixTable(dh, dh.getTableMetaData());
		return pt;
	}
	
	private AutoJoinTableResult findAutoJoinTables(DatasetHead dh)
	{
		HashMap<PrefixTable,JoinProperty> map=new HashMap<PrefixTable, JoinProperty>();
		List<DatasetCorrelationGroup> correlationList=mergeColElementGroup(dh.getDatasetElements());
		
		//assignment of the parent table prefix is done via reference
		//so upon invocation of correlationGroupBuilder.build(), the head.tablePrefix is filled with the parent prefix
		//which is via DatasetCorrelation
		PrefixTable head=ConvertUtil.toPrefixTable(dh);
		for(DatasetCorrelationGroup dc:correlationList)
				map.putAll(correlationGroupBuilder.build(head, dc));
			
		
		
		return new AutoJoinTableResult(head.getTablePrefix(), map);
	}
	
	//check if the left table of the first element of the dataset correlation 
	//is equal to the parent table id
	//this should be equal so that it could map the fields to be joined by the parent table
	private boolean isAutoJoinInitTableValid(DatasetHead dh, DatasetCorrelation correlation)
	{
		return dh.getId()==correlation.getLeftDataset().getId();
	}
	
	//per DatasetElement, collects each and every auto join table.
	//there is a possibility that mutiple columns has the same join table
	//this should be merged.
	private List<DatasetCorrelationGroup> mergeColElementGroup(Set<DatasetElement> ce)
	{
		List<DatasetCorrelationGroup> l=new ArrayList<DatasetCorrelationGroup>();
		for(DatasetElement element:ce)
		{
			DatasetCorrelationGroup corGroup= element.getDatasetCorrelationGroup();
			if(corGroup!=null)
				if(!l.contains(corGroup))
					l.add(corGroup);
		}
		return l;
	}
	
	private List<DatasetCorrelationGroupDtl> parentGroupDetails(DatasetHead dh,List<DatasetCorrelationGroupDtl> list)
	{
		
		return list.parallelStream()
		.filter(e->e.getDatasetCorrelation().getLeftDataset().getId()==dh.getId())
		.collect(Collectors.toList());
		
	}
	
	private class AutoJoinTableResult
	{
		private String headPrefix;
		private Map<PrefixTable, JoinProperty> map;
		public AutoJoinTableResult(String headPrefix, Map map) {
			super();
			this.headPrefix = headPrefix;
			this.map = map;
		}
		public String getHeadPrefix() {
			return headPrefix;
		}
		public Map<PrefixTable, JoinProperty> getMap() {
			return map;
		}
		
		
	}
	
}
