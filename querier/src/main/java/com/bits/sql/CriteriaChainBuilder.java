package com.bits.sql;

/**
 * Created by ej on 9/2/14.
 */
public interface CriteriaChainBuilder extends SqlBuilder, OrderByClauseBuilder,GroupByBuilder {

    CriteriaFilterBuilder and(String column);

    CriteriaFilterBuilder or(String column);

    CriteriaFilterBuilder and(String tablePrefix, String columnName);

    CriteriaFilterBuilder and(ColumnExpression columnExpression);
}
