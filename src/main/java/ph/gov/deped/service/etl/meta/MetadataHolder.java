package ph.gov.deped.service.etl.meta;

import ph.gov.deped.data.ors.meta.ColumnMetadata;
import ph.gov.deped.data.ors.meta.TableMetadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* Created by ej on 8/14/14.
*/
public class MetadataHolder {

    protected Class<? extends Serializable> keyClass;

    protected TableMetadata tableMetadata;

    protected List<ColumnMetadata> columnMetadatas = new ArrayList<>();

    public MetadataHolder() {}

    public MetadataHolder(Class<? extends Serializable> keyClass) {
        this.keyClass = keyClass;
    }

    public MetadataHolder(TableMetadata tableMetadata, ColumnMetadata... columnMetadatas) {
        this.tableMetadata = tableMetadata;
        this.columnMetadatas.addAll(Arrays.asList(columnMetadatas));
    }

    public MetadataHolder(Class<? extends Serializable> keyClass, TableMetadata tableMetadata, ColumnMetadata... columnMetadatas) {
        this.keyClass = keyClass;
        this.tableMetadata = tableMetadata;
        this.columnMetadatas.addAll(Arrays.asList(columnMetadatas));
    }

    public TableMetadata getTableMetadata() {
        return tableMetadata;
    }

    public MetadataHolder setTableMetadata(TableMetadata tableMetadata) {
        this.tableMetadata = tableMetadata;
        return this;
    }

    public List<ColumnMetadata> getColumnMetadatas() {
        return columnMetadatas;
    }

    public MetadataHolder setColumnMetadatas(List<ColumnMetadata> columnMetadatas) {
        this.columnMetadatas = columnMetadatas;
        return this;
    }
    
    public MetadataHolder addColumnMetadata(ColumnMetadata columnMetadata) {
        this.columnMetadatas.add(columnMetadata);
        return this;
    }

    public Class<? extends Serializable> getKeyClass() {
        return keyClass;
    }

    public void setKeyClass(Class<? extends Serializable> keyClass) {
        this.keyClass = keyClass;
    }
}
