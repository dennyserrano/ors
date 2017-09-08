package ph.gov.deped.common.util.builders2.impl;

import java.util.ArrayList;
import java.util.List;

import ph.gov.deped.common.util.builders2.interfaces.WhereBuilder;
import ph.gov.deped.data.Where;
import ph.gov.deped.data.dto.ds.Filter;

public class WhereBuilderImpl implements WhereBuilder{

	private Where where;
	private List<Filter> filters;
	private String prefix;
	private String fieldName;
	public WhereBuilderImpl(String prefix,String fieldName)
	{
		where=new Where();
		filters=new ArrayList<Filter>();
		this.fieldName=fieldName;
		this.prefix=prefix;
	}
	
	@Override
	public Where build() {
		
		where.where(fieldName, prefix);
		return null;
	}
	
	public WhereBuilder add(Filter filter)
	{
		filters.add(filter);
		return this;
		
	}
	

}
