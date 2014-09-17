package ph.gov.deped.common.query;

import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.meta.ColumnMetadata;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by ej on 9/2/14.
 */
public class ColumnExpression implements SqlExpression {

    private final String tablePrefix;

    private final String columnName;

    public ColumnExpression(ColumnMetadata columnMetadata) {
        this("", columnMetadata);
    }

    public ColumnExpression(String tablePrefix, ColumnMetadata columnMetadata) {
        this(tablePrefix, columnMetadata.getColumnName());
    }

    public ColumnExpression(DatasetElement element) {
        this("", element);
    }

    public ColumnExpression(String tablePrefix, DatasetElement element) {
        this.tablePrefix = tablePrefix;
        this.columnName = element.getName();
    }

    public ColumnExpression(String tablePrefix, String columnName) {
        this.tablePrefix = tablePrefix;
        this.columnName = columnName;
    }
    
    public ColumnExpression(String columnName) {
        this.tablePrefix = "";
        this.columnName = columnName;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public String getColumnName() {
        return columnName;
    }

    public String get() {
        return isBlank(tablePrefix) ? columnName : tablePrefix + "." + columnName;
    }
}
