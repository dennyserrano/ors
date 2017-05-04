package ph.gov.deped.common.util.builders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	private JoinPropertyBuilder joinPropertyBuilder;
	public PrefixTableBuilder() {
		joinPropertyBuilder=new JoinPropertyBuilder();
	}
	
	public PrefixTable build(DatasetHead dh)
	{
		PrefixTable pt= new PrefixTable(dh, dh.getTableMetaData());
		dh.getDatasetElements().forEach(e->pt.addColumn(new ColumnElement(e, e.getColumnMetaData())));
		return pt;
	}
	
	private Set<PrefixTable> findAutoJoinTables(DatasetHead dh)
	{
		Set<PrefixTable> hs=new HashSet<PrefixTable>();
		List<DatasetCorrelationGroup> correlationList=mergeColElementGroup(dh.getDatasetElements());
		PrefixTable head=ConvertUtil.toPrefixTable(dh);
		List<JoinInfo<DatasetElement, DatasetElement>> joinList=new ArrayList<JoinInfo<DatasetElement,DatasetElement>>();
		for(DatasetCorrelationGroup dc:correlationList)
		{
			for(DatasetCorrelationGroupDtl dtl:dc.getGroupDetails())
			{
				joinPropertyBuilder.build(dtl);
				
			}
		}
		
		return null;
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
}