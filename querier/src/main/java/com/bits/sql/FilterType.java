package com.bits.sql;

/**
 * Created by ej on 8/19/14.
 */
public enum FilterType {
    /**
     * A single value comparison
     */
    VALUE,

    /**
     * Compare to another element/column.
     */
    COLUMN,

    /**
     * This filter should be compared against multiple values.
     * eg. Between, In
     */
    VALUES
}
