package ph.gov.deped.common.query;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by ej on 9/2/14.
 */
public class QueryTable implements SqlExpression {

    private final String prefix;

    private final String tableName;

    public QueryTable(String tableName) {
        this("", tableName);
    }

    public QueryTable(String prefix, String tableName) {
        this.prefix = prefix;
        this.tableName = tableName;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getTableName() {
        return tableName;
    }

    public String get() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTableName());
        if (!isBlank(getPrefix())) {
            sb.append(" AS ").append(getPrefix());
        }
        return sb.toString();
    }
}
