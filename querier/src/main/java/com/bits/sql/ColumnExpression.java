package com.bits.sql;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by ej on 9/2/14.
 */
public class ColumnExpression implements SqlExpression {

    private final String tablePrefix;

    private final String columnName;

    public ColumnExpression(String tablePrefix, String columnName) {
        this.tablePrefix = tablePrefix;
        this.columnName = columnName;
    }
    
    public ColumnExpression(String columnName) {
        this.tablePrefix = "";
        this.columnName = columnName;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public String getColumnName() {
        return columnName;
    }

    public String get() {
        return isBlank(tablePrefix) ? columnName : tablePrefix + "." + columnName;
    }
}
