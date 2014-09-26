package ph.gov.deped.data.ors.ds;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import ph.gov.deped.data.BaseJpaEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ej on 8/18/14.
 */
@Entity
@Table(catalog = "orsdb", uniqueConstraints = {
        @UniqueConstraint(name = "dataset_head_name_unique", columnNames = {DatasetHead.COL_NAME})
})
public class DatasetHead extends BaseJpaEntity<Long> implements Serializable {
    
    public static final String NAME = "name";

    public static final String COL_NAME = "name";

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
    private String tableName;

    @Basic
    @Column
    private Boolean visible;

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

    public String getTableName() {
        return tableName;
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

    public void setTableName(String tableName) {
        this.tableName = tableName;
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
                .append(this.tableName, rhs.tableName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(name)
                .append(description)
                .append(ownerId)
                .append(visible)
                .append(tableName)
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
                .append("tableName", tableName)
                .toString();
    }
}
