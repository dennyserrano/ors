package com.model.db;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.cache.annotation.Cacheable;
import ph.gov.deped.data.BaseJpaEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ej
 * @since Nov 24, 2014 12:51
 */
@Entity
@Cacheable("CriteriaHeads")
@javax.persistence.Cacheable
public class CriteriaHead extends BaseJpaEntity<Integer> implements Serializable {
    
    private static final long serialVersionUID = -2952323307149853434L;
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(length = 30, nullable = false, unique = true)
    private String key;
    
    @Column(length = 200, nullable = false)
    private String label;

    @Column(length = 500)
    private String description;

    @ManyToOne
    @JoinColumn(name = "source_dataset_id", nullable = false)
    private DatasetHead datasetSource;

    @ManyToOne
    @JoinColumn(name = "source_key_element_id", nullable = false)
    private DatasetElement elementSourceKey;

    @ManyToOne
    @JoinColumn(name = "source_desc_element_id", nullable = false)
    private DatasetElement elementSourceDesc;

    @Column(nullable = false)
    private boolean visible;

    public CriteriaHead() {}

    public CriteriaHead(Integer id, String key, String label, String description,
                        DatasetHead datasetSource, DatasetElement elementSourceKey,
                        DatasetElement elementSourceDesc, boolean visible) {
        this.id = id;
        this.key = key;
        this.label = label;
        this.description = description;
        this.datasetSource = datasetSource;
        this.elementSourceKey = elementSourceKey;
        this.elementSourceDesc = elementSourceDesc;
        this.visible = visible;
    }

    public Integer getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public DatasetHead getDatasetSource() {
        return datasetSource;
    }

    public DatasetElement getElementSourceKey() {
        return elementSourceKey;
    }

    public DatasetElement getElementSourceDesc() {
        return elementSourceDesc;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDatasetSource(DatasetHead datasetSource) {
        this.datasetSource = datasetSource;
    }

    public void setElementSourceKey(DatasetElement elementSourceKey) {
        this.elementSourceKey = elementSourceKey;
    }

    public void setElementSourceDesc(DatasetElement elementSourceDesc) {
        this.elementSourceDesc = elementSourceDesc;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CriteriaHead)) {
            return false;
        }
        CriteriaHead rhs = (CriteriaHead) obj;
        return new EqualsBuilder()
                .append(this.key, rhs.key)
                .append(this.label, rhs.label)
                .append(this.description, rhs.description)
                .append(this.datasetSource, rhs.datasetSource)
                .append(this.elementSourceKey, rhs.elementSourceKey)
                .append(this.elementSourceDesc, rhs.elementSourceDesc)
                .append(this.visible, rhs.visible)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(key)
                .append(label)
                .append(description)
                .append(datasetSource)
                .append(elementSourceKey)
                .append(elementSourceDesc)
                .append(visible)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("id", id)
                .append("key", key)
                .append("label", label)
                .append("description", description)
                .append("datasetSource", datasetSource)
                .append("elementSourceKey", elementSourceKey)
                .append("elementSourceDesc", elementSourceDesc)
                .append("visible", visible)
                .toString();
    }
}
