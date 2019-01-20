package com.bits.sql;

/**
 * Created by ej on 9/2/14.
 */
public interface OrderByClauseBuilder extends SqlBuilder{

    SqlBuilder orderBy(String tablePrefix, String columnName, boolean asc);

    SqlBuilder orderBy(String columnName, boolean asc);
    
    SqlBuilder orderBy(String... columnNames);
}
