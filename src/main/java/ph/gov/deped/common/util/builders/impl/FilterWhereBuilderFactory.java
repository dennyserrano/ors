package ph.gov.deped.common.util.builders.impl;

import ph.gov.deped.common.util.builders.interfaces.FilterWhere;

public class FilterWhereBuilderFactory {

	public static FilterWhere get()
	{
		return new WhereBuilderImpl();
	}
	
}
