package com.bits.sql;

/**
 * Created by PSY on 2014/10/01.
 */
public class JoinColumn implements SqlExpression {

    private final Criterion criterion;

    public JoinColumn(Criterion criterion) {
        this.criterion = criterion;
    }

    public String get() {
        StringBuilder sql = new StringBuilder();
        if (criterion != null) {
            sql.append(criterion.leftExpression().get())
                    .append(criterion.operator().get())
                    .append(criterion.rightExpression().get());
        }
        return sql.toString();
    }
}
