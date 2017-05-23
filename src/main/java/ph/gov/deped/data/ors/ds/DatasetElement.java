package ph.gov.deped.data.ors.ds;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.cache.annotation.Cacheable;

import ph.gov.deped.data.BaseJpaEntity;
import ph.gov.deped.data.ors.meta.ColumnMetadata;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by ej on 8/18/14.
 */
@Entity
@Cacheable("DatasetElements")
@javax.persistence.Cacheable
public class DatasetElement extends BaseJpaEntity<Long> implements Serializable {

    private static final long serialVersionUID = 5690000895468705426L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "dataset_head_id", nullable = false)
    private DatasetHead datasetHead;

    @Basic
    private Integer columnId;

    @Column(length = 100)
    private String alias;

    @Column(length = 100)
    private String function;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 1000, nullable = false)
    private String meaning;

    @Column(length = 500)
    private String description;

    @Basic @Column
    private boolean visible;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="columnId",referencedColumnName="columnId",insertable=false,updatable=false)
    private ColumnMetadata columnMetaData;
    
    @OneToOne(fetch=FetchType.LAZY)
    private DatasetCorrelationGroup datasetCorrelationGroup;
    
    public DatasetElement() {}
    

	public Long getId() {
        return id;
    }

    public DatasetHead getDatasetHead() {
        return datasetHead;
    }

    public Integer getColumnId() {
        return columnId;
    }

    public String getAlias() {
        return alias;
    }

    public String getFunction() {
        return function;
    }

    public String getName() {
        return name;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDatasetHead(DatasetHead datasetHead) {
        this.datasetHead = datasetHead;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    

	public DatasetCorrelationGroup getDatasetCorrelationGroup() {
		return datasetCorrelationGroup;
	}


	public void setDatasetCorrelationGroup(
			DatasetCorrelationGroup datasetCorrelationGroup) {
		this.datasetCorrelationGroup = datasetCorrelationGroup;
	}


	public ColumnMetadata getColumnMetaData() {
		return columnMetaData;
	}

	public void setColumnMetaData(ColumnMetadata columnMetaData) {
		this.columnMetaData = columnMetaData;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DatasetElement)) {
            return false;
        }
        DatasetElement rhs = (DatasetElement) obj;
        return new EqualsBuilder()
                .append(this.datasetHead, rhs.datasetHead)
                .append(this.columnId, rhs.columnId)
                .append(this.alias, rhs.alias)
                .append(this.function, rhs.function)
                .append(this.name, rhs.name)
                .append(this.meaning, rhs.meaning)
                .append(this.description, rhs.description)
                .append(this.visible, rhs.visible)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(datasetHead)
                .append(columnId)
                .append(alias)
                .append(function)
                .append(name)
                .append(meaning)
                .append(description)
                .append(visible)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .appendSuper(super.toString())
                .append("id", id)
                .append("datasetHead", datasetHead)
                .append("columnId", columnId)
                .append("alias", alias)
                .append("function", function)
                .append("name", name)
                .append("meaning", meaning)
                .append("description", description)
                .append("visible", visible)
                .toString();
    }
}
