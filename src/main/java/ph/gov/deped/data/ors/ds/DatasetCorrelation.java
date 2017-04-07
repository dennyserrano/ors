package ph.gov.deped.data.ors.ds;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.cache.annotation.Cacheable;

import com.bits.sql.JoinType;

import ph.gov.deped.data.BaseJpaEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.io.Serializable;

/**
 * Created by PSY on 2014/09/30.
 */
@Entity
@Cacheable("DatasetCorrelations")
@javax.persistence.Cacheable
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "dataset_corrrelation_left_right_unique", columnNames = {
                "left_dataset_head_id", "right_dataset_head_id"
        })
})
public class DatasetCorrelation extends BaseJpaEntity<Long> implements Serializable {

    private static final long serialVersionUID = -8758587285371125390L;

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Long id;

    @Basic
    @Column(length = 20, nullable = false)
    private String leftTablePrefix;

    @ManyToOne
    @JoinColumn(name = "left_dataset_head_id", nullable = false)
    private DatasetHead leftDataset;

    @Enumerated
    @Column(nullable = false)
    private JoinType joinType;

    @Basic
    @Column(length = 20, nullable = false)
    private String rightTablePrefix;

    @ManyToOne
    @JoinColumn(name = "right_dataset_head_id", nullable = false)
    private DatasetHead rightDataset;
    
    @ManyToOne
    @JoinColumn(name="datasetElementId",insertable=false,updatable=false,nullable=true)
    private DatasetElement datasetElement;
    
    public DatasetCorrelation() {}



	public DatasetElement getDatasetElement() {
		return datasetElement;
	}



	public void setDatasetElement(DatasetElement datasetElement) {
		this.datasetElement = datasetElement;
	}



	public Long getId() {
        return id;
    }

    public String getLeftTablePrefix() {
        return leftTablePrefix;
    }

    public DatasetHead getLeftDataset() {
        return leftDataset;
    }

    public JoinType getJoinType() {
        return joinType;
    }

    public String getRightTablePrefix() {
        return rightTablePrefix;
    }

    public DatasetHead getRightDataset() {
        return rightDataset;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLeftTablePrefix(String leftTablePrefix) {
        this.leftTablePrefix = leftTablePrefix;
    }

    public void setLeftDataset(DatasetHead leftDataset) {
        this.leftDataset = leftDataset;
    }

    public void setJoinType(JoinType joinType) {
        this.joinType = joinType;
    }

    public void setRightTablePrefix(String rightTablePrefix) {
        this.rightTablePrefix = rightTablePrefix;
    }

    public void setRightDataset(DatasetHead rightDataset) {
        this.rightDataset = rightDataset;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DatasetCorrelation)) {
            return false;
        }
        DatasetCorrelation rhs = (DatasetCorrelation) obj;
        return new EqualsBuilder()
                .append(this.leftTablePrefix, rhs.leftTablePrefix)
                .append(this.leftDataset, rhs.leftDataset)
                .append(this.joinType, rhs.joinType)
                .append(this.rightTablePrefix, rhs.rightTablePrefix)
                .append(this.rightDataset, rhs.rightDataset)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(leftTablePrefix)
                .append(leftDataset)
                .append(joinType)
                .append(rightTablePrefix)
                .append(rightDataset)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("leftTablePrefix", leftTablePrefix)
                .append("leftDataset", leftDataset)
                .append("joinType", joinType)
                .append("rightTablePrefix", rightTablePrefix)
                .append("rightDataset", rightDataset)
                .toString();
    }
}
