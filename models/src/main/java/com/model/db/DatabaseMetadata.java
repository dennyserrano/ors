package com.model.db;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.cache.annotation.Cacheable;
import ph.gov.deped.data.BaseJpaEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ej on 8/14/14.
 */
@Entity
@Cacheable("DatabaseMetadataCache")
@javax.persistence.Cacheable
public class DatabaseMetadata extends BaseJpaEntity<Integer> implements Serializable {

    public static final int STEP_DEV = 0;

    public static final int STEP_STAGE = 1;

    public static final int STEP_PROD = 2;

    private static final long serialVersionUID = -6158611241120218170L;

    private @Id Integer dbId;

    private @Basic @Column(length = 20, nullable = false) String dbName;

    private @Basic @Column(length = 50, nullable = false) String dbHost;

    private @Basic @Column(nullable = false) int dbPort;

    private @Basic @Column(nullable = false) int dbStep;

    private @Basic @Column(length = 50, nullable = false) String dbUser;

    private @Basic @Column(length = 200, nullable = false) String dbPass;

    public DatabaseMetadata() {}

    public DatabaseMetadata(Integer dbId, String dbName, String dbHost, int dbPort, int dbStep, String dbUser, String dbPass) {
        this.dbId = dbId;
        this.dbName = dbName;
        this.dbHost = dbHost;
        this.dbPort = dbPort;
        this.dbStep = dbStep;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
    }

    public Integer getId() {
        return getDbId();
    }

    public Integer getDbId() {
        return dbId;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbHost() {
        return dbHost;
    }

    public int getDbPort() {
        return dbPort;
    }

    public int getDbStep() {
        return dbStep;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPass() {
        return dbPass;
    }

    public void setDbId(Integer dbId) {
        this.dbId = dbId;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public void setDbHost(String dbHost) {
        this.dbHost = dbHost;
    }

    public void setDbPort(int dbPort) {
        this.dbPort = dbPort;
    }

    public void setDbStep(int dbStep) {
        this.dbStep = dbStep;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public void setDbPass(String dbPass) {
        this.dbPass = dbPass;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        DatabaseMetadata rhs = (DatabaseMetadata) obj;
        return new EqualsBuilder()
                .append(this.dbName, rhs.dbName)
                .append(this.dbHost, rhs.dbHost)
                .append(this.dbPort, rhs.dbPort)
                .append(this.dbStep, rhs.dbStep)
                .append(this.dbUser, rhs.dbUser)
                .append(this.dbPass, rhs.dbPass)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(dbName)
                .append(dbHost)
                .append(dbPort)
                .append(dbStep)
                .append(dbUser)
                .append(dbPass)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("dbId", dbId)
                .append("dbName", dbName)
                .append("dbHost", dbHost)
                .append("dbPort", dbPort)
                .append("dbStep", dbStep)
                .append("dbUser", dbUser)
                .toString();
    }
}
