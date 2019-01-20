package com.bits.sql;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof QueryTable)) {
            return false;
        }
        QueryTable rhs = (QueryTable) obj;
        return new EqualsBuilder()
                .append(this.prefix, rhs.prefix)
                .append(this.tableName, rhs.tableName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(prefix)
                .append(tableName)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("prefix", prefix)
                .append("tableName", tableName)
                .toString();
    }
}
