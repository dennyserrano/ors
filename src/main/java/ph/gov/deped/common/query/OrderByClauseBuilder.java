package ph.gov.deped.common.query;

import ph.gov.deped.data.ors.meta.ColumnMetadata;

/**
 * Created by ej on 9/2/14.
 */
public interface OrderByClauseBuilder {

    SqlBuilder orderBy(ColumnMetadata columnMetadata, boolean asc);

    SqlBuilder orderBy(String tablePrefix, String columnName, boolean asc);

    SqlBuilder orderBy(String columnName, boolean asc);
    
    SqlBuilder orderBy(String... columnNames);
}
