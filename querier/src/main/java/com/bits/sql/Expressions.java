package com.bits.sql;

/**
 * Created by PSY on 2014/09/03.
 */
public abstract class Expressions {

    public static ValueExpression string(String value) {
        return () -> "'" + value + "'";
    }

    public static ValueExpression number(Number value) {
        return () -> value.toString();
    }

    public static ValueExpression bool(Boolean value) {
        return () -> value.toString();
    }

    public static ValueExpression character(Character value) {
        return () -> "'" + value.toString() + "'";
    }
}
