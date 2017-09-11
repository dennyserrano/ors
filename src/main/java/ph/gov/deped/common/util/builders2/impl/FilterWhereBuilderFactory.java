package ph.gov.deped.common.util.builders2.impl;

import ph.gov.deped.common.util.builders2.interfaces.FilterWhere;

public class FilterWhereBuilderFactory {

	public static FilterWhere get()
	{
		return new WhereBuilderImpl();
	}
	
}
