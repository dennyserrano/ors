package com.bits.sql;

/**
 * Created by ej on 9/2/14.
 */
public abstract class QueryBuilders {

    public static ProjectionBuilder read() {
        return new SelectQueryBuilder();
    }
}
