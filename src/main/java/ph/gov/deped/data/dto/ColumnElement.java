package ph.gov.deped.data.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import ph.gov.deped.common.util.builders.JoinInfo;
import ph.gov.deped.data.dto.interfaces.TableColumn;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.meta.ColumnMetadata;

import java.io.Serializable;
import java.util.List;

/**
* Created by PSY on 2014/10/15.
*/
public class ColumnElement implements Comparable<ColumnElement>, Cloneable, Serializable, TableColumn {

    private static final long serialVersionUID = -8460528631378807133L;

    private long elementId;

    private int columnId;

    private String elementName;

    private String columnName;

    private String elementDescription;

    private long datasetId;

    private String tablePrefix;

    private String dataType;
    
    private Long precision;
    
    private int scale;

    private Serializable value;

    private List<JoinInfo<PrefixTable,PrefixTable>> columnCorrelations;
    
	public ColumnElement(DatasetElement element, ColumnMetadata column) {
        this.elementId = element.getId();
        this.columnId = column.getColumnId();
        this.elementName = element.getName();
        this.columnName = column.getColumnName();
        this.elementDescription = element.getDescription();
        this.datasetId = element.getDatasetHead().getId();
        this.dataType = column.getDataType();
        this.scale = column.getMin();
        this.precision = column.getMax();
    }

    public ColumnElement(DatasetElement element, ColumnMetadata column,List<JoinInfo<PrefixTable,PrefixTable>> columnRelations) {
        this.elementId = element.getId();
        this.columnId = column.getColumnId();
        this.elementName = element.getName();
        this.columnName = column.getColumnName();
        this.elementDescription = element.getDescription();
        this.datasetId = element.getDatasetHead().getId();
        this.dataType = column.getDataType();
        this.scale = column.getMin();
        this.precision = column.getMax();
        this.columnCorrelations=columnRelations;
    }
    
    // Copy Constructor: used for cloning this object
    private ColumnElement(long elementId, int columnId, String elementName, String columnName, String elementDescription,
                         long datasetId, String dataType, Long precision, int scale, String tablePrefix, Serializable value) {
        this.elementId = elementId;
        this.columnId = columnId;
        this.elementName = elementName;
        this.columnName = columnName;
        this.elementDescription = elementDescription;
        this.datasetId = datasetId;
        this.dataType = dataType;
        this.precision = precision;
        this.scale = scale;
        this.tablePrefix = tablePrefix;
        this.value = value;
    }

    public long getElementId() {
        return elementId;
    }

    public int getColumnId() {
        return columnId;
    }

    public String getElementName() {
        return elementName;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getElementDescription() {
        return elementDescription;
    }

    public long getDatasetId() {
        return datasetId;
    }

    public String getDataType() {
        return dataType;
    }

    public Long getPrecision() {
        return precision;
    }

    public int getScale() {
        return scale;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }
//
//    public List<ColumnCorrelation> getColumnCorrelations() {
//		return columnCorrelations;
//	}

	@SuppressWarnings({"unchecked"})
    public <O extends Serializable> O getValue() {
        return (O) value;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public void setValue(Serializable value) {
        this.value = value;
    }

    public int compareTo(ColumnElement o) {
        int comparison = new Long(datasetId).compareTo(new Long(o.datasetId));
        if (comparison == 0) {
            return new Long(elementId).compareTo(new Long(o.elementId));
        }
        return comparison;
    }

    public @Override ColumnElement clone() {
        return new ColumnElement(this.elementId, this.columnId, this.elementName, this.columnName, this.elementDescription,
                this.datasetId, this.dataType, this.precision, this.scale, this.tablePrefix, this.value);
    }

    public @Override boolean equals(Object o) {
        if (o == null || !(o instanceof ColumnElement)) {
            return false;
        }
        ColumnElement rhs = (ColumnElement) o;
        return new EqualsBuilder()
                .append(this.elementId, rhs.elementId)
                .append(this.columnId, rhs.columnId)
                .append(this.datasetId, rhs.datasetId)
                .isEquals();
    }

    public @Override int hashCode() {
        return new HashCodeBuilder()
                .append(this.elementId)
                .append(this.columnId)
                .append(this.datasetId)
                .toHashCode();
    }

    public @Override String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("elementId", elementId)
                .append("columnId", columnId)
                .append("elementName", elementName)
                .append("columnName", columnName)
                .append("elementDescription", elementDescription)
                .append("datasetId", datasetId)
                .append("tablePrefix", tablePrefix)
                .append("dataType", dataType)
                .append("precision", precision)
                .append("scale", scale)
                .append("value", value)
                .toString();
    }
}
