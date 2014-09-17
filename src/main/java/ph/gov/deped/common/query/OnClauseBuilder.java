package ph.gov.deped.common.query;

import ph.gov.deped.data.ors.meta.ColumnMetadata;

/**
 * Created by ej on 9/2/14.
 */
public interface OnClauseBuilder {

    JoinCriteriaBuilder on(String tablePrefix, ColumnMetadata col);

    JoinCriteriaBuilder on(String tablePrefix, String columnName);

    JoinCriteriaBuilder on(ColumnExpression columnExpression);
}
