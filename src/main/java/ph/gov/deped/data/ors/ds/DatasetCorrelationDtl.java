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

    @ManyToOne
    @JoinColumn(name = "dataset_correlation_id", nullable = false)
    private DatasetCorrelation datasetCorrelation;

    @Basic
    @Column(nullable = false)
    private Integer leftColumnId;

    @Column(nullable = false)
    @Type(type = "ph.gov.deped.common.query.OperatorUserType")
    private Operator operator;

    @Basic
    @Column(nullable = false)
    private Integer rightColumnId;

    public DatasetCorrelationDtl() {}

    public Long getId() {
        return id;
    }

    public DatasetCorrelation getDatasetCorrelation() {
        return datasetCorrelation;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setDatasetCorrelation(DatasetCorrelation datasetCorrelation) {
        this.datasetCorrelation = datasetCorrelation;
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
        if (obj == null || !(obj instanceof DatasetCorrelationDtl)) {
            return false;
        }
        DatasetCorrelationDtl rhs = (DatasetCorrelationDtl) obj;
        return new EqualsBuilder()
                .append(this.datasetCorrelation, rhs.datasetCorrelation)
                .append(this.leftColumnId, rhs.leftColumnId)
                .append(this.operator, rhs.operator)
                .append(this.rightColumnId, rhs.rightColumnId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(datasetCorrelation)
                .append(leftColumnId)
                .append(operator)
                .append(rightColumnId)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("datasetCorrelation", datasetCorrelation)
                .append("leftColumnId", leftColumnId)
                .append("operator", operator)
                .append("rightColumnId", rightColumnId)
                .toString();
    }
}
