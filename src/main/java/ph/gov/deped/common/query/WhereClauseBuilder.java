package ph.gov.deped.common.query;

import ph.gov.deped.data.ors.meta.ColumnMetadata;

/**
 * Created by ej on 9/2/14.
 */
public interface WhereClauseBuilder {

    CriteriaFilterBuilder where(ColumnMetadata columnMetadata);

    CriteriaFilterBuilder where(String columnName);

    CriteriaFilterBuilder where(String tablePrefix, String columnName);

    CriteriaFilterBuilder where(ColumnExpression columnExpression);
}
