package ph.gov.deped.common.query;

import ph.gov.deped.data.ors.meta.ColumnMetadata;

/**
 * Created by ej on 9/2/14.
 */
public interface CriteriaChainBuilder extends SqlBuilder, OrderByClauseBuilder {

    CriteriaFilterBuilder and(ColumnMetadata columnMetadata);

    CriteriaFilterBuilder or(ColumnMetadata columnMetadata);

    CriteriaFilterBuilder and(String column);

    CriteriaFilterBuilder or(String column);

    CriteriaFilterBuilder and(String tablePrefix, String columnName);

    CriteriaFilterBuilder and(ColumnExpression columnExpression);
}
