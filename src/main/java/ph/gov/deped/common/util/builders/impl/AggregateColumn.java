package ph.gov.deped.common.util.builders.impl;

import com.bits.sql.AggregateTypes;
import com.model.db.ColumnMetadata;
import com.model.db.DatasetElement;

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
