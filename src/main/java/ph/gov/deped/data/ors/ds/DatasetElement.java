package ph.gov.deped.data.ors.ds;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import ph.gov.deped.data.BaseJpaEntity;

import javax.persistence.Basic;
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
public class DatasetElement extends BaseJpaEntity<Long> implements Serializable {

    private static final long serialVersionUID = 5690000895468705426L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dataset_table_id", nullable = false)
    private DatasetTable datasetTable;

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

    public DatasetElement() {}

    public DatasetElement(Long id, DatasetTable datasetTable, Integer columnId) {
        this.id = id;
        this.datasetTable = datasetTable;
        this.columnId = columnId;
    }

    public Long getId() {
        return id;
    }

    public DatasetTable getDatasetTable() {
        return datasetTable;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setDatasetTable(DatasetTable datasetTable) {
        this.datasetTable = datasetTable;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DatasetElement)) {
            return false;
        }
        DatasetElement rhs = (DatasetElement) obj;
        return new EqualsBuilder()
                .append(this.datasetTable, rhs.datasetTable)
                .append(this.columnId, rhs.columnId)
                .append(this.alias, rhs.alias)
                .append(this.function, rhs.function)
                .append(this.name, rhs.name)
                .append(this.meaning, rhs.meaning)
                .append(this.description, rhs.description)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(datasetTable)
                .append(columnId)
                .append(alias)
                .append(function)
                .append(name)
                .append(meaning)
                .append(description)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .appendSuper(super.toString())
                .append("id", id)
                .append("datasetTable", datasetTable)
                .append("columnId", columnId)
                .append("alias", alias)
                .append("function", function)
                .append("name", name)
                .append("meaning", meaning)
                .append("description", description)
                .toString();
    }
}
