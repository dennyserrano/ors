package ph.gov.deped.data.ors.ds;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.cache.annotation.Cacheable;
import ph.gov.deped.data.BaseJpaEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

/**
 * Created by ej on 8/18/14.
 */
@Entity
@Cacheable("DatasetHeads")
@javax.persistence.Cacheable
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "dataset_head_name_unique", columnNames = {DatasetHead.COL_NAME})
})
public class DatasetHead extends BaseJpaEntity<Long> implements Serializable {
    
    public static final String NAME = "name";

    public static final String COL_NAME = "name";

    public static final String RANKING = "ranking";

    private static final long serialVersionUID = -1225186733854262660L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private Integer ownerId;

    @Column(length = 50)
    private Long parentDatasetHead;

    @Basic
    @Column
    private Integer tableId;

    @Basic
    @Column
    private Boolean visible;

    @Basic @Column
    private Integer ranking;

    public DatasetHead() {
    }

    public DatasetHead(Long id, String name, Integer ownerId) {
        this(id, name, null, ownerId);
    }

    public DatasetHead(Long id, String name, String description, Integer ownerId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ownerId = ownerId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public Boolean isVisible() {
        return visible;
    }

    public Long getParentDatasetHead() {
        return parentDatasetHead;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public void setParentDatasetHead(Long parentDatasetHead) {
        this.parentDatasetHead = parentDatasetHead;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DatasetHead)) {
            return false;
        }
        DatasetHead rhs = (DatasetHead) obj;
        return new EqualsBuilder()
                .append(this.name, rhs.name)
                .append(this.description, rhs.description)
                .append(this.ownerId, rhs.ownerId)
                .append(this.visible, rhs.visible)
                .append(this.parentDatasetHead, rhs.parentDatasetHead)
                .append(this.tableId, rhs.tableId)
                .append(this.ranking, rhs.ranking)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(name)
                .append(description)
                .append(ownerId)
                .append(visible)
                .append(parentDatasetHead)
                .append(tableId)
                .append(ranking)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .appendSuper(super.toString())
                .append("id", id)
                .append("name", name)
                .append("description", description)
                .append("ownerId", ownerId)
                .append("visible", visible)
                .append("parentDatasetHead", parentDatasetHead)
                .append("tableId", tableId)
                .append("ranking", ranking)
                .toString();
    }
}
