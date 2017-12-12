package com.util.builders.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.model.db.DatasetElement;
import com.model.db.DatasetHead;
import com.model.support.GenericKeyValue;
import com.util.builders.interfaces.JoinBuilder;


public class JoinBuilderDatasetElementImpl implements JoinBuilder {

	private DatasetElement de;
	private DatasetHead parent;
	private CorrelationGroupBuilder groupBuilder=new CorrelationGroupBuilder();
	protected JoinBuilderDatasetElementImpl(DatasetHead parent,DatasetElement e)
	{
		de=e;
		this.parent=parent;
	}
	
	@Override
	public List<GenericKeyValue<PrefixTable, JoinProperty>> build() {
		
		if(de.getDatasetCorrelationGroup()==null)
			return new ArrayList<GenericKeyValue<PrefixTable,JoinProperty>>();
		PrefixTable pt=groupBuilder.build(parent.getId(), de.getDatasetCorrelationGroup());
		ArrayList<GenericKeyValue<PrefixTable, JoinProperty>> al=new ArrayList<>();
		for(Entry<PrefixTable, JoinProperty> es:pt.getJoinTables().entrySet())
			al.add(new GenericKeyValue<PrefixTable, JoinProperty>(es.getKey(),es.getValue()));
		return al;
	}

}
