package com.bits.sql;

/**
 * Created by PSY on 2014/10/01.
 */
public interface JoinCriteriaChainBuilder extends SqlBuilder {

    JoinCriteriaBuilder and(String tablePrefix, String columnName);

    JoinCriteriaBuilder and(ColumnExpression columnExpression);
}
