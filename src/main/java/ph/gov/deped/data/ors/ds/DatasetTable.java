package ph.gov.deped.data.ors.ds;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import ph.gov.deped.data.BaseJpaEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ej on 8/18/14.
 */
@Entity
@Table(catalog = "orsdb")
public class DatasetTable extends BaseJpaEntity<Long> implements Serializable {

    private static final long serialVersionUID = 9140805894728670779L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dataset_head_id", nullable = false)
    private DatasetHead datasetHead;

    @Column(nullable = false)
    private Integer tableId;

    @Column(length = 10)
    private String prefix;

    @Column
    private Long derivedFrom;

    public DatasetTable() {
    }

    public DatasetTable(Long id, DatasetHead datasetHead, Integer tableId) {
        this.id = id;
        this.datasetHead = datasetHead;
        this.tableId = tableId;
    }

    public Long getId() {
        return id;
    }

    public DatasetHead getDatasetHead() {
        return datasetHead;
    }

    public Integer getTableId() {
        return tableId;
    }

    public String getPrefix() {
        return prefix;
    }

    public Long getDerivedFrom() {
        return derivedFrom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDatasetHead(DatasetHead datasetHead) {
        this.datasetHead = datasetHead;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setDerivedFrom(Long derivedFrom) {
        this.derivedFrom = derivedFrom;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DatasetTable)) {
            return false;
        }
        DatasetTable rhs = (DatasetTable) obj;
        return new EqualsBuilder()
                .append(this.datasetHead, rhs.datasetHead)
                .append(this.tableId, rhs.tableId)
                .append(this.prefix, rhs.prefix)
                .append(this.derivedFrom, rhs.derivedFrom)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(datasetHead)
                .append(tableId)
                .append(prefix)
                .append(derivedFrom)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .appendSuper(super.toString())
                .append("id", id)
                .append("datasetHead", datasetHead)
                .append("tableId", tableId)
                .append("prefix", prefix)
                .append("derivedFrom", derivedFrom)
                .toString();
    }
}
