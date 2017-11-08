package com.util.builders.impl;

import com.model.db.DatasetElement;
import com.util.builders.interfaces.ColumnBuilder;


public class DatasetElementColumnBuilder implements ColumnBuilder {

	private DatasetElement element;
	private String prefix;
	private String alias;
	public DatasetElementColumnBuilder(String prefix,DatasetElement element)
	{
		this.element=element;
		this.prefix=prefix;
	}
	
	public DatasetElementColumnBuilder(String prefix,DatasetElement element,String alias)
	{
		this.element=element;
		this.prefix=prefix;
		this.alias=alias;
	}
	
	@Override
	public ColumnExpression build() {
		
		ColumnElement ce= new ColumnElement(getFieldName(),getAlias(),getPrefix());
		ce.setDataType(element.getColumnMetaData().getDataType());
		return ce;
	}

	protected String getAlias()
	{
		return alias;
	}
	
	
	protected String getFieldName()
	{
		return element.getColumnMetaData().getColumnName();
	}
	
	protected String getPrefix()
	{
		return prefix;
	}
	
}
