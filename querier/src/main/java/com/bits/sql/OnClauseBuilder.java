package com.bits.sql;

/**
 * Created by ej on 9/2/14.
 */
public interface OnClauseBuilder {

    JoinCriteriaBuilder on(String tablePrefix, String columnName);

    JoinCriteriaBuilder on(ColumnExpression columnExpression);
}
