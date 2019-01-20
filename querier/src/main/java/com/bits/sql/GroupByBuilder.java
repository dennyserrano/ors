package com.bits.sql;

public interface GroupByBuilder extends SqlBuilder {

	public OrderByClauseBuilder groupBy(String tablePrefix, String columnName);
	public OrderByClauseBuilder groupBy(String columnName);
	public OrderByClauseBuilder groupBy(String... columnName);
}
