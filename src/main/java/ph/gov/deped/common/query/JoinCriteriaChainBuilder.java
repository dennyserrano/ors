package ph.gov.deped.common.query;

import ph.gov.deped.data.ors.meta.ColumnMetadata;

/**
 * Created by PSY on 2014/10/01.
 */
public interface JoinCriteriaChainBuilder extends SqlBuilder {

    JoinOrWhereClauseBuilder and(String tablePrefix, ColumnMetadata columnMetadata);
}
