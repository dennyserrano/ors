package ph.gov.deped.common.util.builders.impl;

import com.bits.sql.AggregateTypes;

import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.meta.ColumnMetadata;

public class AggregateColumn implements ColumnExpression {

	private String aggregate;
	private ColumnElement columnElement;
	private String alias;
	protected AggregateColumn(String aggregate,ColumnElement ce) {
		
		this.columnElement=ce;
		this.alias=ce.getElementName();
		this.aggregate=aggregate;
	}

	@Override
	public String express() {
		columnElement.setElementName(null);
		return String.format("%s(%s)", aggregate,columnElement.express());
	}

	public ColumnElement getColumnElement() {
		return columnElement;
	}

	@Override
	public String alias() {
		return alias;
	}

	@Override
	public String dataType() {
		// TODO Auto-generated method stub
		return columnElement.dataType();
	}
	
	

}
