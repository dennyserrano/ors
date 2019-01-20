package com.bits.sql;

import static com.bits.sql.Keywords.DESC;

/**
 * Created by ej on 9/2/14.
 */
public class OrderByClause implements SqlExpression {

    private final ColumnExpression column;

    private final boolean ascending;

    public OrderByClause(ColumnExpression column, boolean ascending) {
        this.column = column;
        this.ascending = ascending;
    }

    public ColumnExpression getColumn() {
        return column;
    }

    public boolean ascending() {
        return ascending;
    }

    public String get() {
        StringBuilder sql = new StringBuilder();
        sql.append(getColumn().get());
        if (!ascending()) {
            sql.append(DESC.get());
        }
        return sql.toString();
    }
}
