package com.model.db;

import com.bits.sql.JoinType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.cache.annotation.Cacheable;
import ph.gov.deped.data.BaseJpaEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author ej
 * @since Nov 05, 2014 11:00
 */
@Entity
@Cacheable("RelationMetadataCache")
@javax.persistence.Cacheable
public class RelationMetadata extends BaseJpaEntity<Integer> implements Serializable {
    
    private static final long serialVersionUID = 4969015405957935794L;
    
    @Id
    @Column(nullable = false)
    private Integer relationId;

    @Column(nullable = false)
    private Integer leftTableId;

    @Column(nullable = false)
    private String leftTablePrefix;
    
    @Enumerated
    @Column(nullable = false)
    private JoinType joinType;

    @Column(nullable = false)
    private Integer rightTableId;

    @Column(nullable = false)
    private String rightTablePrefix;

    public RelationMetadata() {}

    public RelationMetadata(Integer relationId, Integer leftTableId, String leftTablePrefix,
                            JoinType joinType, Integer rightTableId, String rightTablePrefix) {
        this.relationId = relationId;
        this.leftTableId = leftTableId;
        this.leftTablePrefix = leftTablePrefix;
        this.joinType = joinType;
        this.rightTableId = rightTableId;
        this.rightTablePrefix = rightTablePrefix;
    }

    public Integer getId() {
        return getRelationId();
    }
    
    public Integer getRelationId() {
        return relationId;
    }

    public Integer getLeftTableId() {
        return leftTableId;
    }

    public String getLeftTablePrefix() {
        return leftTablePrefix;
    }

    public JoinType getJoinType() {
        return joinType;
    }

    public Integer getRightTableId() {
        return rightTableId;
    }

    public String getRightTablePrefix() {
        return rightTablePrefix;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public void setLeftTableId(Integer leftTableId) {
        this.leftTableId = leftTableId;
    }

    public void setLeftTablePrefix(String leftTablePrefix) {
        this.leftTablePrefix = leftTablePrefix;
    }

    public void setJoinType(JoinType joinType) {
        this.joinType = joinType;
    }

    public void setRightTableId(Integer rightTableId) {
        this.rightTableId = rightTableId;
    }

    public void setRightTablePrefix(String rightTablePrefix) {
        this.rightTablePrefix = rightTablePrefix;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RelationMetadata)) {
            return false;
        }
        RelationMetadata rhs = (RelationMetadata) obj;
        return new EqualsBuilder()
                .append(this.leftTableId, rhs.leftTableId)
                .append(this.leftTablePrefix, rhs.leftTablePrefix)
                .append(this.joinType, rhs.joinType)
                .append(this.rightTableId, rhs.rightTableId)
                .append(this.rightTablePrefix, rhs.rightTablePrefix)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(leftTableId)
                .append(leftTablePrefix)
                .append(joinType)
                .append(rightTableId)
                .append(rightTablePrefix)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("relationId", relationId)
                .append("leftTableId", leftTableId)
                .append("leftTablePrefix", leftTablePrefix)
                .append("joinType", joinType)
                .append("rightTableId", rightTableId)
                .append("rightTablePrefix", rightTablePrefix)
                .toString();
    }
}
