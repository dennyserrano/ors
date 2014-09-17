package ph.gov.deped.data.ors.ds;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Type;
import ph.gov.deped.common.query.FilterType;
import ph.gov.deped.common.query.Operator;
import ph.gov.deped.data.BaseJpaEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ej on 8/19/14.
 */
@Entity
@Table(catalog = "orsdb")
public class DatasetCriteria extends BaseJpaEntity<Long> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2235455537289489269L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dataset_head_id", nullable = false)
    private DatasetHead datasetHead;

    @Enumerated
    @Column(nullable = false)
    private FilterType filterType;

    @ManyToOne
    @JoinColumn(name = "left_element_id")
    private DatasetElement leftElement;

    @Column(length = 10)
    @Type(type = "ph.gov.deped.common.query.OperatorUserType")
    private Operator operator;

    @Column(length = 1000)
    private String rightValue;

    @Basic
    private Integer valueType; // refer to java.sql.Types

    @ManyToOne
    @JoinColumn(name = "right_element_id")
    private DatasetElement rightElement;

    public DatasetCriteria() {}

    public DatasetCriteria(Long id, DatasetHead datasetHead, FilterType filterType, DatasetElement leftElement, Operator operator) {
        this.id = id;
        this.datasetHead = datasetHead;
        this.filterType = filterType;
        this.leftElement = leftElement;
        this.operator = operator;
    }

    public Long getId() {
        return id;
    }

    public DatasetHead getDatasetHead() {
        return datasetHead;
    }

    public FilterType getFilterType() {
        return filterType;
    }

    public DatasetElement getLeftElement() {
        return leftElement;
    }

    public Operator getOperator() {
        return operator;
    }

    public String getRightValue() {
        return rightValue;
    }

    public Integer getValueType() {
        return valueType;
    }

    public DatasetElement getRightElement() {
        return rightElement;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDatasetHead(DatasetHead datasetHead) {
        this.datasetHead = datasetHead;
    }

    public void setFilterType(FilterType filterType) {
        this.filterType = filterType;
    }

    public void setLeftElement(DatasetElement leftElement) {
        this.leftElement = leftElement;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setRightValue(String rightValue) {
        this.rightValue = rightValue;
    }

    public void setValueType(Integer valueType) {
        this.valueType = valueType;
    }

    public void setRightElement(DatasetElement rightElement) {
        this.rightElement = rightElement;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DatasetCriteria)) {
            return false;
        }
        DatasetCriteria rhs = (DatasetCriteria) obj;
        return new EqualsBuilder()
                .append(this.datasetHead, rhs.datasetHead)
                .append(this.filterType, rhs.filterType)
                .append(this.leftElement, rhs.leftElement)
                .append(this.operator, rhs.operator)
                .append(this.rightValue, rhs.rightValue)
                .append(this.valueType, rhs.valueType)
                .append(this.rightElement, rhs.rightElement)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(datasetHead)
                .append(filterType)
                .append(leftElement)
                .append(operator)
                .append(rightValue)
                .append(valueType)
                .append(rightElement)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .appendSuper(super.toString())
                .append("id", id)
                .append("datasetHead", datasetHead)
                .append("filterType", filterType)
                .append("leftElement", leftElement)
                .append("operator", operator)
                .append("rightValue", rightValue)
                .append("valueType", valueType)
                .append("rightElement", rightElement)
                .toString();
    }
}
