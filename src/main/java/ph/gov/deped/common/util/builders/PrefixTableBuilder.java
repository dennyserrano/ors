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
import ph.gov.deped.data.dto.interfaces.TableColumn;
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
		PrefixTable pt= ConvertUtil.toPrefixTable(dh);
		ArrayList<TableColumn> al=new ArrayList<>(pt.getColumns());
		Map<DatasetCorrelationGroup, List<DatasetElement>> colElementGroupResult=mergeColElementGroup(dh.getDatasetElements());
		TableWrapper tw;
		for(Entry<DatasetCorrelationGroup, List<DatasetElement>> es:colElementGroupResult.entrySet())
		{
			PrefixTable parentTable=correlationGroupBuilder.build(es.getKey());
			tw=new TableWrapper(parentTable);
			if(parentTable.getDatasetId()!=pt.getDatasetId())
				throw new RuntimeException(String.format("There has been a disalignment while auto joining from parent table: %s",pt.getDatasetId()));
			
			for(DatasetElement de:es.getValue())
			{
				ColumnElement ce=ConvertUtil.toColumnElement(de);
				
				if(al.contains(ce))
				{
					ce.setTablePrefix(tw.findTail().getTablePrefix());
					al.set(al.indexOf(ce),ce);
				}
				
			}
			for(Entry<PrefixTable,JoinProperty> j:parentTable.getJoinTables().entrySet())
				pt.addJoin(j.getKey(), j.getValue());
			pt.setTablePrefix(parentTable.getTablePrefix());
		}
		
		if(pt.getTablePrefix()==null)
			pt.setTablePrefix(pt.getTableName());
		
		al.stream().forEach(e->{
			
			ColumnElement ce=((ColumnElement)e);
			if(ce.getTablePrefix()==null)
				ce.setTablePrefix(pt.getTablePrefix());
		});
		pt.setColumns(new HashSet<TableColumn>(al));
		return pt;
	}
	
	public PrefixTable lightBuild(DatasetHead dh) //no auto join included
	{
		PrefixTable pt=new PrefixTable(dh, dh.getTableMetaData());
		return pt;
	}
	
	//per DatasetElement, collects each and every auto join table.
	//there is a possibility that mutiple columns has the same join table
	//this should be merged.
	private Map<DatasetCorrelationGroup,List<DatasetElement>> mergeColElementGroup(Set<DatasetElement> ce)
	{
		
		HashMap<DatasetCorrelationGroup, List<DatasetElement>> hm=new HashMap<DatasetCorrelationGroup, List<DatasetElement>>();
		
		for(DatasetElement element:ce)
		{
			DatasetCorrelationGroup corGroup= element.getDatasetCorrelationGroup();
			if(corGroup!=null)
				if(hm.containsKey(corGroup))				
					hm.get(corGroup).add(element);
				else
				{
					ArrayList<DatasetElement> list=new ArrayList<DatasetElement>();
					list.add(element);
					hm.put(corGroup, list);
				}
				
		}
		return hm;
	}
	

	
	
	
	
}
