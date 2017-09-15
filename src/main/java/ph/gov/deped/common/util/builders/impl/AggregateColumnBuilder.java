package ph.gov.deped.common.util.builders.impl;

import com.bits.sql.AggregateTypes;

import ph.gov.deped.common.util.builders.interfaces.ColumnBuilder;
import ph.gov.deped.data.ors.ds.DatasetElement;

public class AggregateColumnBuilder extends DatasetElementColumnBuilder {

	private AggregateTypes aggregate;
	private String alias;
	private DatasetElement element;
	public AggregateColumnBuilder(AggregateTypes aggregate,DatasetElement de,String prefix,String alias)
	{
		super(prefix,de);
		this.aggregate=aggregate;
		this.alias=alias;
		this.element=de;
	}
	
	
	@Override
	public ColumnExpression build() {
		
		ColumnElement ce=new ColumnElement(getFieldName(), getPrefix());
		ce.setDataType(element.getColumnMetaData().getDataType());
		
		return new NestableColumnElement(alias,
												new AggregateColumn(aggregate.getAggregate(),ce)
										);
	}

}
