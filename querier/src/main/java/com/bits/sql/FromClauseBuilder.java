package com.bits.sql;

/**
* Created by ej on 9/2/14.
*/
public interface FromClauseBuilder {

    JoinOrWhereClauseBuilder from(String tableName);

    JoinOrWhereClauseBuilder from(String tableName, String tablePrefix);
}
