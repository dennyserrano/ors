package com.bits.sql;

/**
 * Created by ej on 9/2/14.
 */
public interface JoinCriteriaBuilder {

    JoinOrWhereClauseBuilder eq(String tablePrefix, String columnName);

    JoinOrWhereClauseBuilder eq(SqlExpression rightExpression);
}