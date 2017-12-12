package com.model.db;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.io.Serializable;

/**
 * Created by ej on 8/13/14.
 */
@Entity
@Cacheable("TableMetadataCache")
@javax.persistence.Cacheable
public class TableMetadata extends BaseJpaEntity<Integer> implements Serializable {

    public static final String TBL_NAME = "table_metadata";

    public static final String COL_TABLE_ID = "table_id";

    public static final String COL_DB_ID = "db_id";

    public static final String COL_SCHEMA_NAME = "schema_name";

    public static final String COL_TABLE_NAME = "table_name";

    public static final String COL_LOCATION = "location";

    public static final String COL_DESCRIPTION = "description";

    public static final String COL_COL_COUNT = "col_count";

    public static final String COL_ROW_COUNT = "row_count";

    private static final long serialVersionUID = -7588817531339832278L;

    private @Id Integer tableId;

    private @Basic @Column(nullable = false) Integer dbId;

    private @Basic @Column(length = 50) String schemaName;

    private @Basic @Column(nullable = false, length = 50) String tableName;

    private @Basic @Column(length = 100)  String location;

    private @Basic @Column(length = 200)  String description;

    private @Basic int colCount;

    private @Basic int rowCount;

    public TableMetadata() {}

    public TableMetadata(int tableId, Integer dbId, String schemaName, String tableName,
                         String location, String description) {
        this.tableId = tableId;
        this.dbId = dbId;
        this.schemaName = schemaName;
        this.tableName = tableName;
        this.location = location;
        this.description = description;
    }

    public Integer getId() {
        return getTableId();
    }

    public Integer getTableId() {
        return tableId;
    }

    public Integer getDbId() {
        return dbId;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public int getColCount() {
        return colCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public void setDbId(Integer dbId) {
        this.dbId = dbId;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setColCount(int colCount) {
        this.colCount = colCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TableMetadata)) {
            return false;
        }
        TableMetadata rhs = (TableMetadata) obj;
        return new EqualsBuilder()
                .append(this.dbId, rhs.dbId)
                .append(this.schemaName, rhs.schemaName)
                .append(this.tableName, rhs.tableName)
                .append(this.description, rhs.description)
                .append(this.colCount, rhs.colCount)
                .append(this.rowCount, rhs.rowCount)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(dbId)
                .append(schemaName)
                .append(tableName)
                .append(description)
                .append(colCount)
                .append(rowCount)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("tableId", tableId)
                .append("dbId", dbId)
                .append("schemaName", schemaName)
                .append("tableName", tableName)
                .append("description", description)
                .append("colCount", colCount)
                .append("rowCount", rowCount)
                .toString();
    }
}
