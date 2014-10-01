package ph.gov.deped.common.query;

import ph.gov.deped.data.ors.meta.TableMetadata;

/**
* Created by ej on 9/2/14.
*/
public interface FromClauseBuilder {

    JoinOrWhereClauseBuilder from(String tableName);

    JoinOrWhereClauseBuilder from(String tableName, String tablePrefix);

    JoinOrWhereClauseBuilder from(TableMetadata tableMetadata, String tablePrefix);
}
