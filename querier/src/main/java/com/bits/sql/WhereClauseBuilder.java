package com.bits.sql;

/**
 * Created by ej on 9/2/14.
 */
public interface WhereClauseBuilder {

    CriteriaFilterBuilder where(String columnName);

    CriteriaFilterBuilder where(String tablePrefix, String columnName);

    CriteriaFilterBuilder where(ColumnExpression columnExpression);
}
