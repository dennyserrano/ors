package com.util.builders.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.model.db.DatasetCorrelationGroup;
import com.model.db.DatasetElement;
import com.model.db.DatasetHead;

import ph.gov.deped.common.util.builders.interfaces.JoinBuilder;
import ph.gov.deped.data.dto.GenericKeyValue;

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
