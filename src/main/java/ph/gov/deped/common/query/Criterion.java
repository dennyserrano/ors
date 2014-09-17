package ph.gov.deped.common.query;

/**
 * Created by ej on 9/2/14.
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
}