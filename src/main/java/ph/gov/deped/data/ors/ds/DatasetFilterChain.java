package ph.gov.deped.data.ors.ds;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Type;
import org.springframework.cache.annotation.Cacheable;
import ph.gov.deped.common.query.Operator;
import ph.gov.deped.data.BaseJpaEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by ej on 8/19/14.
 */
@Entity
@Cacheable("DatasetFilterChains")
@javax.persistence.Cacheable
public class DatasetFilterChain extends BaseJpaEntity<Long> implements Serializable {

    private static final long serialVersionUID = 3885030780525586181L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dataset_head_id", nullable = false)
    private DatasetHead datasetHead;

    @ManyToOne
    @JoinColumn(name = "left_filter_id")
    private DatasetCriteria leftFilter;

    @Basic
    private Long parentFilterChain;

    @Column(nullable = false, length = 10)
    @Type(type = "ph.gov.deped.common.query.OperatorUserType")
    private Operator operator;

    @ManyToOne
    @JoinColumn(name = "right_filter_id")
    private DatasetCriteria rightFilter;

    public DatasetFilterChain() {
    }

    public DatasetFilterChain(Long id, DatasetHead datasetHead, Operator operator) {
        this.id = id;
        this.datasetHead = datasetHead;
        this.operator = operator;
    }

    public Long getId() {
        return id;
    }

    public DatasetHead getDatasetHead() {
        return datasetHead;
    }

    public DatasetCriteria getLeftFilter() {
        return leftFilter;
    }

    public Long getParentFilterChain() {
        return parentFilterChain;
    }

    public Operator getOperator() {
        return operator;
    }

    public DatasetCriteria getRightFilter() {
        return rightFilter;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDatasetHead(DatasetHead datasetHead) {
        this.datasetHead = datasetHead;
    }

    public void setLeftFilter(DatasetCriteria leftFilter) {
        this.leftFilter = leftFilter;
    }

    public void setParentFilterChain(Long parentFilterChain) {
        this.parentFilterChain = parentFilterChain;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setRightFilter(DatasetCriteria rightFilter) {
        this.rightFilter = rightFilter;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DatasetFilterChain)) {
            return false;
        }
        DatasetFilterChain rhs = (DatasetFilterChain) obj;
        return new EqualsBuilder()
                .append(this.datasetHead, rhs.datasetHead)
                .append(this.leftFilter, rhs.leftFilter)
                .append(this.parentFilterChain, rhs.parentFilterChain)
                .append(this.operator, rhs.operator)
                .append(this.rightFilter, rhs.rightFilter)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(datasetHead)
                .append(leftFilter)
                .append(parentFilterChain)
                .append(operator)
                .append(rightFilter)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .appendSuper(super.toString())
                .append("id", id)
                .append("datasetHead", datasetHead)
                .append("leftFilter", leftFilter)
                .append("parentFilterChain", parentFilterChain)
                .append("operator", operator)
                .append("rightFilter", rightFilter)
                .toString();
    }
}
