package ph.gov.deped.common.util.builders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.ors.ds.DatasetCorrelation;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroup;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroupDtl;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;

public class PrefixTableBuilder 
{
	public PrefixTable build(DatasetHead dh)
	{
		PrefixTable pt= new PrefixTable(dh, dh.getTableMetaData());
		dh.getDatasetElements().forEach(e->pt.addColumn(new ColumnElement(e, e.getColumnMetaData())));
		return pt;
	}
	
	private Set<PrefixTable> findAutoJoinTables(DatasetHead dh)
	{
		Set<PrefixTable> hs=new HashSet<PrefixTable>();
		List<DatasetCorrelation> correlationList=mergeTables(dh.getDatasetElements());
		
		
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
	private List<DatasetCorrelation> mergeTables(Set<DatasetElement> ce)
	{
		List<DatasetCorrelation> l=new ArrayList<DatasetCorrelation>();
		for(DatasetElement element:ce)
		{
			DatasetCorrelationGroup corGroup= element.getDatasetCorrelationGroup();
			if(corGroup!=null)
				for(DatasetCorrelationGroupDtl grpDtl:corGroup.getGroupDetails())
					{
						DatasetCorrelation correlation=grpDtl.getDatasetCorrelation();
						if(!l.contains(correlation))
							l.add(correlation);
					}
		}
		return l;
	}
}
