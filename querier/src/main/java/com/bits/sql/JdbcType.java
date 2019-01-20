package com.bits.sql;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcType<O extends Serializable> {
    protected String dataType;
    protected int sqlType;
    protected Class<O> javaType;
    protected SqlValueMapper<O> sqlValueMapper;
    
    private ResultSetValueRetriever<O> resultSetValueRetriever;

    public JdbcType(String dataType, int sqlType, Class<O> javaType,
                    SqlValueMapper<O> sqlValueMapper, ResultSetValueRetriever<O> resultSetValueRetriever) {
        this.dataType = dataType;
        this.sqlType = sqlType;
        this.javaType = javaType;
        this.sqlValueMapper = sqlValueMapper;
        this.resultSetValueRetriever = resultSetValueRetriever;
    }

    public String getDataType() {
        return dataType;
    }

    public int getSqlType() {
        return sqlType;
    }

    public Class<O> getJavaType() {
        return javaType;
    }

    public O convert(Serializable value) {
        return sqlValueMapper.apply(value);
    }
    
    public O retrieve(ResultSet rs, String colName) throws SQLException {
        return resultSetValueRetriever.retrieve(rs, colName);
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