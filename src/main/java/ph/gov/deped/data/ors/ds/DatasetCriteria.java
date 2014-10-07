package ph.gov.deped.data.ors.ds;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Type;
import org.springframework.cache.annotation.Cacheable;
import com.bits.sql.FilterType;
import com.bits.sql.Operator;
import ph.gov.deped.data.BaseJpaEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by ej on 8/19/14.
 */
@Entity
@Cacheable("DatasetCriterias")
@javax.persistence.Cacheable
public class DatasetCriteria extends BaseJpaEntity<Long> implements Serializable {

    private static final long serialVersionUID = 2235455537289489269L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dataset_head_id", nullable = false)
    private DatasetHead datasetHead;

    @Basic
    @Column(length = 50, nullable = false)
    private String filterName;

    @Enumerated
    @Column(nullable = false)
    private FilterType filterType;

    @ManyToOne
    @JoinColumn(name = "left_element_id")
    private DatasetElement leftElement;

    @Column(length = 10)
    @Type(type = "ph.gov.deped.common.OperatorUserType")
    private Operator operator;

    @Basic
    @Column(length = 20)
    private String valueType;

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

    public String getValueType() {
        return valueType;
    }

    public DatasetElement getRightElement() {
        return rightElement;
    }

    public String getFilterName() {
        return filterName;
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

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public void setRightElement(DatasetElement rightElement) {
        this.rightElement = rightElement;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DatasetCriteria)) {
            return false;
        }
        DatasetCriteria rhs = (DatasetCriteria) obj;
        return new EqualsBuilder()
                .append(this.datasetHead, rhs.datasetHead)
                .append(this.filterName, rhs.filterName)
                .append(this.filterType, rhs.filterType)
                .append(this.leftElement, rhs.leftElement)
                .append(this.operator, rhs.operator)
                .append(this.valueType, rhs.valueType)
                .append(this.rightElement, rhs.rightElement)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(datasetHead)
                .append(filterName)
                .append(filterType)
                .append(leftElement)
                .append(operator)
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
                .append("filterName", filterName)
                .append("filterType", filterType)
                .append("leftElement", leftElement)
                .append("operator", operator)
                .append("valueType", valueType)
                .append("rightElement", rightElement)
                .toString();
    }
}
