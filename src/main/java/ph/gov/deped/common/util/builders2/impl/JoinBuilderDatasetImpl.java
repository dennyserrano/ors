package ph.gov.deped.common.util.builders2.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ph.gov.deped.common.util.builders.JoinProperty;
import ph.gov.deped.common.util.builders.JoinPropertyBuilder;
import ph.gov.deped.common.util.builders2.interfaces.JoinBuilder;
import ph.gov.deped.data.dto.GenericKeyValue;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroup;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;

public class JoinBuilderDatasetImpl implements JoinBuilder {

	protected DatasetHead parent;
	protected DatasetHead child;
	protected String leftPrefix;
	protected String rightPrefix;
	protected JoinBuilderDatasetImpl(String leftPrefix,DatasetHead dh1,String rightPrefix, DatasetHead dh2)
	{
		parent=dh1;
		child=dh2;
		this.leftPrefix=leftPrefix;
		this.rightPrefix=rightPrefix;
	}

	@Override
	public List<GenericKeyValue<PrefixTable, JoinProperty>> build() 
	{
		HashMap<Long,GenericKeyValue<PrefixTable,JoinProperty>> hm=new HashMap<>();
		
		// Duplicate group?
		for(DatasetElement de:child.getDatasetElements())
		{
			if(de.getDatasetCorrelationGroup()!=null)
			{
				long groupId=de.getDatasetCorrelationGroup().getId();
				if(hm.get(groupId)==null)
					hm.put(groupId, new JoinBuilderDatasetElementImpl(parent,de).build().get(0));
			
			}
			
		}
		return new ArrayList<>(hm.values());
	}

}
