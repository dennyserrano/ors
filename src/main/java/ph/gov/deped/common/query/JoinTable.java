package ph.gov.deped.common.query;

import static ph.gov.deped.common.query.Keywords.ON;

/**
 * Created by PSY on 2014/09/03.
 */
public class JoinTable implements SqlExpression {

    private final JoinType joinType;

    private final QueryTable joinTable;

    private Criterion criterion;

    public JoinTable(JoinType joinType, QueryTable joinTable) {
        this(joinType, joinTable, null);
    }

    public JoinTable(JoinType joinType, QueryTable joinTable, Criterion criterion) {
        this.joinType = joinType;
        this.joinTable = joinTable;
        this.criterion = criterion;
    }

    public QueryTable getJoinTable() {
        return joinTable;
    }

    public Criterion getCriterion() {
        return criterion;
    }

    public JoinType getJoinType() {
        return joinType;
    }

    public String get() {
        StringBuilder sql = new StringBuilder();
        sql.append(joinType.get())
           .append(joinTable.get());
        if (criterion != null) {
            sql.append(ON.get());
            sql.append(criterion.leftExpression().get())
               .append(criterion.operator().get())
               .append(criterion.rightExpression().get());
        }

        return sql.toString();
    }
}
