package ph.gov.deped.common.util.builders2.impl;

import com.bits.sql.AggregateTypes;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.ColumnExpression;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.meta.ColumnMetadata;

public class AggregateColumn extends ColumnElement implements ColumnExpression {

	private String aggregate;
	private ColumnElement ce;
	public AggregateColumn(String aggregate,ColumnElement ce) {
		
		this.aggregate=aggregate;
		this.ce=ce;
	}

	@Override
	public String express() {
		
		return String.format("%s(%s)", aggregate,ce.express());
	}

}
