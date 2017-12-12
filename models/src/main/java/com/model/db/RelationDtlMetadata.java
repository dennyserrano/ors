package com.model.db;

import com.bits.sql.Operator;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Type;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.io.Serializable;

/**
 * @author ej
 * @since Nov 05, 2014 11:10
 */
@Entity
@Cacheable("RelationDtlMetadataCache")
@javax.persistence.Cacheable
public class RelationDtlMetadata extends BaseJpaEntity<Integer> implements Serializable {
    
    private static final long serialVersionUID = -7215915496619316004L;
    
    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer relationId;

    @Column(nullable = false)
    private Integer leftColumnId;

    @Column(nullable = false)
    @Type(type = "com.model.enums.OperatorUserType")
    private Operator operator;

    @Column(nullable = false)
    private Integer rightColumnId;

    public RelationDtlMetadata() {}

    public RelationDtlMetadata(Integer id, Integer relationId, Integer leftColumnId,
                               Operator operator, Integer rightColumnId) {
        this.id = id;
        this.relationId = relationId;
        this.leftColumnId = leftColumnId;
        this.operator = operator;
        this.rightColumnId = rightColumnId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public Integer getLeftColumnId() {
        return leftColumnId;
    }

    public Operator getOperator() {
        return operator;
    }

    public Integer getRightColumnId() {
        return rightColumnId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public void setLeftColumnId(Integer leftColumnId) {
        this.leftColumnId = leftColumnId;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setRightColumnId(Integer rightColumnId) {
        this.rightColumnId = rightColumnId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RelationDtlMetadata)) {
            return false;
        }
        RelationDtlMetadata rhs = (RelationDtlMetadata) obj;
        return new EqualsBuilder()
                .append(this.relationId, rhs.relationId)
                .append(this.leftColumnId, rhs.leftColumnId)
                .append(this.operator, rhs.operator)
                .append(this.rightColumnId, rhs.rightColumnId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(relationId)
                .append(leftColumnId)
                .append(operator)
                .append(rightColumnId)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("relationId", relationId)
                .append("leftColumnId", leftColumnId)
                .append("operator", operator)
                .append("rightColumnId", rightColumnId)
                .toString();
    }
}
