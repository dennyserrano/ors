package com.util.builders.api;

import com.util.builders.impl.PrefixTable;


public interface ServiceQueryBuilder
{
	public String getQuery(PrefixTable pt);
}
