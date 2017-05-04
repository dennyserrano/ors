package ph.gov.deped.data.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import ph.gov.deped.common.util.builders.JoinInfo;
import ph.gov.deped.common.util.builders.JoinProperty;
import ph.gov.deped.data.dto.interfaces.TableColumn;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.data.ors.meta.TableMetadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    private Set<TableColumn> columns = new LinkedHashSet<>();
    
    //PrefixTable - the table to be joined. Becomes one (this table) to many.
    //JoinProperty - defines how the join table be joined to this table (i.e inner join, left join etc)
    //				- contains the fields that are joined to this table.
    private Map<PrefixTable,JoinProperty> joinTables=new HashMap<PrefixTable, JoinProperty>();
    
    
    
    public PrefixTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrefixTable(DatasetHead datasetHead, TableMetadata tableMetadata, ColumnElement... columnElements) {
    	
        this(datasetHead,tableMetadata);
        this.columns.addAll(asList(columnElements));
    }
    
    public void addJoin(PrefixTable prefixTable, JoinProperty join)
    {
    	joinTables.put(prefixTable, join);
    }
    
    private PrefixTable(DatasetHead datasetHead, TableMetadata tableMetadata)
    {
    	this.datasetId = datasetHead.getId();
        this.parentId = datasetHead.getParentDatasetHead();
        this.datasetName = datasetHead.getName();
        this.tableId = tableMetadata.getTableId();
        this.tableName = tableMetadata.getTableName();
        this.ranking = datasetHead.getRanking();
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

    public Set<TableColumn> getColumns() {
        return columns;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public void addColumn(ColumnElement ce) {
        this.columns.add(ce);
    }

    public void addColumn(TableColumn c)
    {
    	this.columns.add(c);
    }
	public int compareTo(PrefixTable o) {
        return new Integer(getRanking()).compareTo(new Integer(o.getRanking()));
    }

	

	public Map<PrefixTable, JoinProperty> getJoinTables() {
		return joinTables;
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
