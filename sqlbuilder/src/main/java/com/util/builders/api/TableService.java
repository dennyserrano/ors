package com.util.builders.api;

import com.model.support.Dataset;
import com.util.builders.impl.PrefixTable;



public interface TableService 
{
	public PrefixTable generateTable(Dataset ds);
}
