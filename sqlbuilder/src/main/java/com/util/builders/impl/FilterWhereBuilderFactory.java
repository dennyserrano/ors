package com.util.builders.impl;

import com.util.builders.interfaces.FilterWhere;


public class FilterWhereBuilderFactory {

	public static FilterWhere get()
	{
		return new WhereBuilderImpl();
	}
	
}
