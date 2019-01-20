package com.bits.sql;

import static com.bits.sql.Expressions.string;
import static com.bits.sql.Keywords.AS;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class AggregateProjection extends Projection{

	private String aggregateFunction;
	
	public AggregateProjection(String aggregateFunction,String columnName) {
		super(columnName);
		this.aggregateFunction=aggregateFunction;
	}
	
	public AggregateProjection(String aggregateFunction,String columnName,String tablePrefix,String alias){
		super(tablePrefix,columnName,alias);
		this.aggregateFunction=aggregateFunction;
	}
	
	@Override
	public String get() {
		
		return isBlank(getAlias()) ? getAggregated(getColumnName()) : getAggregated(getColumnName()) + AS.get() + string(getAlias()).get();
	}	
	
	private String getAggregated(String field)
	{

		if(isBlank(aggregateFunction))
			return "";
		else
			return String.format("%s(%s)", aggregateFunction,getPrefixedField(field));
	}
	
	private String getPrefixedField(String field)
	{
		if(isBlank(getTablePrefix()))
			return field;
		else
			return String.format("%s.%s", getTablePrefix(),field);
	}
	
	
}
