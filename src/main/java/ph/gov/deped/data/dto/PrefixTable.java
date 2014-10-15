package ph.gov.deped.data.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.data.ors.meta.TableMetadata;

import java.io.Serializable;
import java.util.LinkedList;

import static java.util.Arrays.asList;

/**
* Created by PSY on 2014/10/15.
*/
public class PrefixTable implements Comparable<PrefixTable>, Serializable {

    private static final long serialVersionUID = 496334103157207379L;

    protected String tablePrefix;

    private long datasetId;

    private long parentId;

    private String datasetName;

    private int tableId;

    private String tableName;

    private int ranking;

    protected LinkedList<ColumnElement> columns = new LinkedList<>();

    public PrefixTable(DatasetHead datasetHead, TableMetadata tableMetadata, ColumnElement... columnElements) {
        this.datasetId = datasetHead.getId();
        this.parentId = datasetHead.getParentDatasetHead();
        this.datasetName = datasetHead.getName();
        this.tableId = tableMetadata.getTableId();
        this.tableName = tableMetadata.getTableName();
        this.ranking = datasetHead.getRanking();
        this.columns.addAll(asList(columnElements));
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public long getDatasetId() {
        return datasetId;
    }

    public long getParentId() {
        return parentId;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public int getTableId() {
        return tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public int getRanking() {
        return ranking;
    }

    public LinkedList<ColumnElement> getColumns() {
        return columns;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public void addColumn(ColumnElement ce) {
        this.columns.add(ce);
    }

    public int compareTo(PrefixTable o) {
        return new Integer(getRanking()).compareTo(new Integer(o.getRanking()));
    }

    public @Override boolean equals(Object o) {
        if (o == null || !(o instanceof PrefixTable)) {
            return false;
        }
        PrefixTable rhs = (PrefixTable) o;
        return new EqualsBuilder()
                .append(this.tablePrefix, rhs.tablePrefix)
                .append(this.datasetId, rhs.datasetId)
                .append(this.parentId, rhs.parentId)
                .append(this.datasetName, rhs.datasetName)
                .append(this.tableId, rhs.tableId)
                .append(this.tableName, rhs.tableName)
                .append(this.ranking, rhs.ranking)
                .isEquals();
    }

    public @Override int hashCode() {
        return new HashCodeBuilder()
                .append(tablePrefix)
                .append(datasetId)
                .append(parentId)
                .append(datasetName)
                .append(tableId)
                .append(tableName)
                .append(ranking)
                .toHashCode();
    }

    public @Override String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("tablePrefix", tablePrefix)
                .append("datasetId", datasetId)
                .append("parentId", parentId)
                .append("datasetName", datasetName)
                .append("tableId", tableId)
                .append("tableName", tableName)
                .append("ranking", ranking)
                .append("columns", columns)
                .toString();
    }
}
