package com.bits.sql;

public class GroupByClause implements SqlExpression 
{

	private final ColumnExpression columnExpression;
	
	public GroupByClause(ColumnExpression ce) {
		this.columnExpression=ce;
	}
	
	@Override
	public String get() {
		
		return columnExpression.get();
	}

}
