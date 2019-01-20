package com.bits.sql;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by PSY on 2014/09/03.
 */
public class JoinTable implements SqlExpression {

    private final JoinType joinType;

    private final QueryTable joinTable;

    public JoinTable(JoinType joinType, QueryTable joinTable) {
        this.joinType = joinType;
        this.joinTable = joinTable;
    }

    public QueryTable getJoinTable() {
        return joinTable;
    }

    public JoinType getJoinType() {
        return joinType;
    }

    public String get() {
        StringBuilder sql = new StringBuilder();
        sql.append(joinType.get())
           .append(joinTable.get());

        return sql.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof JoinTable)) {
            return false;
        }
        JoinTable rhs = (JoinTable) obj;
        return new EqualsBuilder()
                .append(this.joinType, rhs.joinType)
                .append(this.joinTable, rhs.joinTable)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(joinType)
                .append(joinTable)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("joinType", joinType)
                .append("joinTable", joinTable)
                .toString();
    }
}
