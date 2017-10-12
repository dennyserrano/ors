package ph.gov.deped.common.util.builders.impl;

import com.bits.sql.AggregateTypes;

import ph.gov.deped.common.util.builders.interfaces.ColumnBuilder;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.meta.ColumnMetadata;

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
