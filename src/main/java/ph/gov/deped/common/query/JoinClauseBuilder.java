package ph.gov.deped.common.query;

import ph.gov.deped.data.ors.meta.TableMetadata;

/**
 * Created by ej on 9/2/14.
 */
public interface JoinClauseBuilder {

    public static final String LEFT_JOIN = "LEFT JOIN";

    OnClauseBuilder leftJoin(TableMetadata tableMetadata, String tablePrefix);

    OnClauseBuilder leftJoin(String tableName, String tablePrefix);
}
