package com.bits.sql;

/**
 * Created by ej on 9/2/14.
 */
public class CriterionExpression implements SqlExpression {

    private final Criterion criterion;

    public CriterionExpression(Criterion criterion) {
        this.criterion = criterion;
    }

    public String get() {
        StringBuilder sql = new StringBuilder();
        sql.append(criterion.leftExpression().get())
           .append(criterion.operator().get())
           .append(criterion.rightExpression().get());
        return sql.toString();
    }
}
