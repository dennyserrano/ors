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
import ph.gov.deped.common.util.builders.AutoJoinFinder.AutoJoinTableResult;
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

	private AutoJoinFinder autoJoinFinder;
	private CorrelationGroupBuilder correlationGroupBuilder;
	public PrefixTableBuilder() {
		correlationGroupBuilder=new CorrelationGroupBuilder();
		autoJoinFinder=new AutoJoinFinder(correlationGroupBuilder);
	}
	
	public PrefixTable build(DatasetHead dh)
	{
		PrefixTable pt= new PrefixTable(dh, dh.getTableMetaData());
		
		for(DatasetElement de:dh.getDatasetElements())
			pt.addColumn(new ColumnElement(de, de.getColumnMetaData()));
		AutoJoinTableResult autoResult= autoJoinFinder.find(dh);
	    for(Entry<PrefixTable, JoinProperty>  entry: autoResult.getMap().entrySet())
	    	pt.addJoin(entry.getKey(), entry.getValue());
	    
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
	
	
	
	
}
