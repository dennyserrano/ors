package com.util.builders.impl;

import ph.gov.deped.common.util.builders.interfaces.ColumnBuilder;

public class SpecialColumnBuilder implements ColumnBuilder {

	private String alias;
	
	public SpecialColumnBuilder(String alias)
	{
		this.alias=alias;
	}
	
	@Override
	public ColumnExpression build() {
		
		return new CountAllColumnElement(alias);
	}

}
