package com.model.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Type;
import org.springframework.cache.annotation.Cacheable;


import com.bits.sql.Operator;

/**
 * Created by PSY on 2014/09/30.
 */
@Entity
@Cacheable("DatasetCorrelationsDetails")
@javax.persistence.Cacheable
public class DatasetCorrelationDtl extends BaseJpaEntity<Long> implements Serializable {

    private static final long serialVersionUID = 7515308375929230514L;

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "dataset_correlation_id", nullable = false)
    private DatasetCorrelation datasetCorrelation;

    @ManyToOne
    @JoinColumn(name = "left_dataset_element_id")
    private DatasetElement leftElement;

    @Column(nullable = false)
    @Type(type = "com.model.enums.OperatorUserType")
    private Operator operator;

    @ManyToOne
    @JoinColumn(name = "right_dataset_element_id")
    private DatasetElement rightElement;

    public DatasetCorrelationDtl() {}

    public Long getId() {
        return id;
    }

//    public DatasetCorrelation getDatasetCorrelation() {
//        return datasetCorrelation;
//    }

    
    public Operator getOperator() {
        return operator;
    }

    public DatasetElement getLeftElement() {
        return leftElement;
    }

    public DatasetElement getRightElement() {
        return rightElement;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDatasetCorrelation(DatasetCorrelation datasetCorrelation) {
        this.datasetCorrelation = datasetCorrelation;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setLeftElement(DatasetElement leftElement) {
        this.leftElement = leftElement;
    }

    public void setRightElement(DatasetElement rightElement) {
        this.rightElement = rightElement;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DatasetCorrelationDtl)) {
            return false;
        }
        DatasetCorrelationDtl rhs = (DatasetCorrelationDtl) obj;
        return new EqualsBuilder()
//                .append(this.datasetCorrelation, rhs.datasetCorrelation)
                .append(this.leftElement, rhs.leftElement)
                .append(this.operator, rhs.operator)
                .append(this.rightElement, rhs.rightElement)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
//                .append(datasetCorrelation)
                .append(leftElement)
                .append(operator)
                .append(rightElement)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
//                .append("datasetCorrelation", datasetCorrelation)
                .append("leftElement", leftElement)
                .append("operator", operator)
                .append("rightElement", rightElement)
                .toString();
    }
}
