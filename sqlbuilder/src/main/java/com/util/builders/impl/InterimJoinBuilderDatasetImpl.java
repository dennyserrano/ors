package com.util.builders.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.bits.sql.JoinType;
import com.model.db.DatasetElement;
import com.model.db.DatasetHead;
import com.model.db.TableMetadata;
import com.model.support.GenericKeyValue;


public class InterimJoinBuilderDatasetImpl extends
		JoinBuilderDatasetImpl {
	
	protected InterimJoinBuilderDatasetImpl(String leftPrefix,DatasetHead dh1,String rightPrefix, DatasetHead dh2) {
		super(leftPrefix,dh1,rightPrefix, dh2);
	}

	@Override
	public List<GenericKeyValue<PrefixTable, JoinProperty>> build() 
	{
		List<GenericKeyValue<PrefixTable,JoinProperty>> l= super.build();
		
		PrefixTable pt=new PrefixTable(child,child.getTableMetaData(),new HashSet<>());
		pt.setTablePrefix(rightPrefix);
//		l.add(new GenericKeyValue<>(new PrefixTable(parent,parent.getTableMetaData(),new HashSet<>()), new JoinPropertyBuilder().getManualBuilder().add(leftPrefix, "sy_from", rightPrefix, "sy_from").set(JoinType.LEFT_JOIN).build()) );
		l.add(0,new GenericKeyValue<>(pt, new JoinPropertyBuilder().getManualBuilder()
				.add(leftPrefix, "school_id", rightPrefix, "school_id")
				.add(leftPrefix, "sy_from", rightPrefix, "sy_from")
				.set(JoinType.LEFT_JOIN).build()) );
		return l;
	}
	
	

}
