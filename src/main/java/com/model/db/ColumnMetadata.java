package ph.gov.deped.data.ors.meta;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.cache.annotation.Cacheable;
import ph.gov.deped.data.BaseJpaEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ej on 8/13/14.
 */
@Entity
@Cacheable("ColumnMetadataCache")
@javax.persistence.Cacheable
public class ColumnMetadata extends BaseJpaEntity<Integer> implements Serializable {

    private static final long serialVersionUID = 8953494489180094068L;

    private @Id Integer columnId;

    private @Basic @Column(nullable = false) Integer tableId;

    private @Basic @Column(nullable = false, length = 100) String columnName;

    private @Basic @Column(length = 20, nullable = false) String dataType;

    private @Basic boolean nullable;

    private @Basic Integer min; // also the scale in numeric types

    private @Basic Long max; // also the precision in numeric types

    private @Basic @Column(nullable = false) boolean primaryKey = false;

    public ColumnMetadata() {}

    public ColumnMetadata(Integer columnId, String columnName, String dataType, boolean nullable, Integer min, Long max, boolean primaryKey) {
        this.columnId = columnId;
        this.columnName = columnName;
        this.dataType = dataType;
        this.nullable = nullable;
        this.min = min;
        this.max = max;
        this.primaryKey = primaryKey;
    }

    public Integer getId() {
        return getColumnId();
    }

    public Integer getColumnId() {
        return columnId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public boolean isNullable() {
        return nullable;
    }

    public Integer getMin() {
        return min;
    }

    public Long getMax() {
        return max;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public void setMax(Long max) {
        this.max = max;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ColumnMetadata)) {
            return false;
        }
        ColumnMetadata rhs = (ColumnMetadata) obj;
        return new EqualsBuilder()
                .append(this.tableId, rhs.tableId)
                .append(this.columnName, rhs.columnName)
                .append(this.dataType, rhs.dataType)
                .append(this.nullable, rhs.nullable)
                .append(this.min, rhs.min)
                .append(this.max, rhs.max)
                .append(this.primaryKey, rhs.primaryKey)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(tableId)
                .append(columnName)
                .append(dataType)
                .append(nullable)
                .append(min)
                .append(max)
                .append(primaryKey)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("columnId", columnId)
                .append("tableId", tableId)
                .append("columnName", columnName)
                .append("dataType", dataType)
                .append("nullable", nullable)
                .append("min", min)
                .append("max", max)
                .append("primaryKey", primaryKey)
                .toString();
    }
}
