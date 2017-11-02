package ph.gov.deped.common.util.builders.impl;

import org.apache.commons.lang3.builder.EqualsBuilder;

import com.model.db.ColumnMetadata;
import com.model.db.DatasetElement;

public class NestableColumnElement extends ColumnElement implements ColumnExpression{

	private ColumnExpression innerColumnElement;
	private String alias;
	public NestableColumnElement(String alias,ColumnExpression ce)
	{
		this.alias=alias;
		innerColumnElement=ce;
		this.setDataType(innerColumnElement.dataType());
	}
	
	@Override
	public String express() {
		
		return String.format("(%s) as %s", innerColumnElement.express(),alias);
	}

	
	@Override
	public boolean equals(Object o) {
		 if (o == null || !(o instanceof NestableColumnElement)) {
	            return false;
	        }
		 NestableColumnElement rhs = (NestableColumnElement) o;
	        return new EqualsBuilder()
	                .append(this.alias, rhs.alias)
	                .isEquals();
	}

	public ColumnExpression getInnerColumnElement() {
		return innerColumnElement;
	}
	
	public String alias() {
		return alias;
	}
	
}
