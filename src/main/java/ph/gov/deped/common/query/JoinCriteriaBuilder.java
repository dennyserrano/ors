package ph.gov.deped.common.query;

/**
 * Created by ej on 9/2/14.
 */
public interface JoinCriteriaBuilder {

    JoinOrWhereClauseBuilder eq(String tablePrefix, String columnName);

    JoinOrWhereClauseBuilder eq(SqlExpression expression);
}