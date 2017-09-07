package ph.gov.deped.common.util.builders2.impl;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.ColumnExpression;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.meta.ColumnMetadata;

public class NestableColumnElement extends ColumnElement implements ColumnExpression{

	private ColumnElement innerColumnElement;
	private String alias;
	public NestableColumnElement(String alias,ColumnElement ce)
	{
		this.alias=alias;
		innerColumnElement=ce;
	}
	
	@Override
	public String express() {
		
		return String.format("(%s) as %s", innerColumnElement.express(),alias);
	}

}
