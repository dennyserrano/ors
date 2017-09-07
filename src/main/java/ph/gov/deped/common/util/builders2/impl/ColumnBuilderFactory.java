package ph.gov.deped.common.util.builders2.impl;

import com.bits.sql.AggregateTypes;

import ph.gov.deped.common.util.builders2.interfaces.ColumnBuilder;
import ph.gov.deped.data.dto.ColumnExpression;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.ors.ds.DatasetElement;

public class ColumnBuilderFactory {

	public static ColumnBuilder get(Element e,String prefix)
	{
		if(e.getAggregate()==null)
			return new DatasetElementColumnBuilder(prefix, null);
		else
			return new AggregateColumnBuilder(AggregateTypes.valueOf(e.getAggregate()), null, prefix);
	}
	
}
