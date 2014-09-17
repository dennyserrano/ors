package ph.gov.deped.common.query;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class JdbcType {
    protected String dataType;
    protected int sqlType;
    protected Class<? extends Serializable> javaType;

    public JdbcType(String dataType, int sqlType, Class<? extends Serializable> javaType) {
        this.dataType = dataType;
        this.sqlType = sqlType;
        this.javaType = javaType;
    }

    public String getDataType() {
        return dataType;
    }

    public int getSqlType() {
        return sqlType;
    }

    public Class<? extends Serializable> getJavaType() {
        return javaType;
    }

    public @Override int hashCode() {
        return new HashCodeBuilder().append(dataType).append(sqlType).append(javaType).build();
    }

    public @Override boolean equals(Object o) {
        if (o == null || !(o instanceof JdbcType)) {
            return false;
        }
        JdbcType r = (JdbcType) o;
        return new EqualsBuilder().append(this.dataType, r.dataType).append(this.sqlType, r.sqlType)
                .append(this.javaType, r.javaType).isEquals();

    }
}