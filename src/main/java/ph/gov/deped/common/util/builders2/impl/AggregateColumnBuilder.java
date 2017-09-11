package ph.gov.deped.common.util.builders2.impl;

import com.bits.sql.AggregateTypes;

import ph.gov.deped.common.util.builders2.interfaces.ColumnBuilder;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.ColumnExpression;
import ph.gov.deped.data.ors.ds.DatasetElement;

public class AggregateColumnBuilder extends DatasetElementColumnBuilder {

	private AggregateTypes aggregate;
	public AggregateColumnBuilder(AggregateTypes aggregate,DatasetElement de,String prefix)
	{
		super(prefix,de);
		this.aggregate=aggregate;
		
	}
	
	
	@Override
	public ColumnExpression build() {
		
		return new NestableColumnElement(getAlias(),new AggregateColumn(aggregate.getAggregate(),new ColumnElement(getFieldName(), getPrefix())));
	}

}
