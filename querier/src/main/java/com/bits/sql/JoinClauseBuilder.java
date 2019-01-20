package com.bits.sql;

/**
 * Created by ej on 9/2/14.
 */
public interface JoinClauseBuilder {

    OnClauseBuilder leftJoin(String tableName, String tablePrefix);

    OnClauseBuilder innerJoin(String tableName, String tablePrefix);

    OnClauseBuilder crossJoin(String tableName, String tablePrefix);
}
