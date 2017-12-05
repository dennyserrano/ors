package com.util.builders.impl;

import com.bits.sql.AggregateTypes;
import com.model.support.Element;
import com.util.builders.interfaces.ColumnBuilder;


public class ColumnBuilderFactory {

	public static ColumnBuilder get(Element e,String prefix)
	{
		
		if(e.getName().equals("count(*)"))
				return new SpecialColumnBuilder("count");
		if(e.getAggregate()==null)
			return new DatasetElementColumnBuilder(prefix, e.getDatasetElement(),e.getDatasetElement().getName());
		else
			return new AggregateColumnBuilder(AggregateTypes.valueOf(e.getAggregate()), e.getDatasetElement(), prefix,e.getDatasetElement().getName());
	}
	
}
