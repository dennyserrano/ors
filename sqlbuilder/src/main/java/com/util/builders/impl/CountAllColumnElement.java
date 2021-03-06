package com.util.builders.impl;


public class CountAllColumnElement implements ColumnExpression {

	private String alias;
	public CountAllColumnElement(String alias)
	{
		this.alias=alias;
	}
	
	@Override
	public String express() {
		
		return String.format("COUNT(*) as %s",alias);
	}

	@Override
	public String alias() {
		// TODO Auto-generated method stub
		return alias;
	}

	@Override
	public String dataType() {
		// TODO Auto-generated method stub
		return "bigint";
	}
	
	

}
