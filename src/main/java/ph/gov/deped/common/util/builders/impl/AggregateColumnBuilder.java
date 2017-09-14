package ph.gov.deped.common.util.builders.impl;

import com.bits.sql.AggregateTypes;

import ph.gov.deped.common.util.builders.interfaces.ColumnBuilder;
import ph.gov.deped.data.ors.ds.DatasetElement;

public class AggregateColumnBuilder extends DatasetElementColumnBuilder {

	private AggregateTypes aggregate;
	private String alias;
	public AggregateColumnBuilder(AggregateTypes aggregate,DatasetElement de,String prefix,String alias)
	{
		super(prefix,de);
		this.aggregate=aggregate;
		this.alias=alias;
		
	}
	
	
	@Override
	public ColumnExpression build() {
		
		return new NestableColumnElement(alias,
												new AggregateColumn(aggregate.getAggregate(),new ColumnElement(getFieldName(), getPrefix()))
										);
	}

}
