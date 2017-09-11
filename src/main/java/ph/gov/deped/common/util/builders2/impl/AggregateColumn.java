package ph.gov.deped.common.util.builders2.impl;

import com.bits.sql.AggregateTypes;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.ColumnExpression;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.meta.ColumnMetadata;

public class AggregateColumn implements ColumnExpression {

	private String aggregate;
	private ColumnElement columnElement;
	public AggregateColumn(String aggregate,ColumnElement ce) {
		
		this.columnElement=ce;
		this.aggregate=aggregate;
	}

	@Override
	public String express() {
		
		return String.format("%s(%s)", aggregate,columnElement.express());
	}

	public ColumnElement getColumnElement() {
		return columnElement;
	}
	
	

}
