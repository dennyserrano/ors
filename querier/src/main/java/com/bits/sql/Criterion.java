package com.bits.sql;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Represents the SQL:
 * <br/><br/>
 * <code>
 *     [column expression] (=,>,<,<>,>=,<=) [another column expression / value]
 * </code>
 */
@SuppressWarnings({"unchecked"})
public class Criterion {

    private final SqlExpression leftExpression;

    private final Operator operator;

    private final SqlExpression rightExpression;

    public Criterion(SqlExpression leftExpression, Operator operator, SqlExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.operator = operator;
        this.rightExpression = rightExpression;
    }

    public <E extends SqlExpression> E leftExpression() {
        return (E) leftExpression;
    }

    public Operator operator() {
        return operator;
    }

    public <E extends SqlExpression> E rightExpression() {
        return (E) rightExpression;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Criterion rhs = (Criterion) obj;
        return new EqualsBuilder()
                .append(this.leftExpression, rhs.leftExpression)
                .append(this.operator, rhs.operator)
                .append(this.rightExpression, rhs.rightExpression)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(leftExpression)
                .append(operator)
                .append(rightExpression)
                .toHashCode();
    }
}