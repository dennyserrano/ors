package com.model.ui;


import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.model.support.DbType;

/**
 * Created by ej on 8/28/14.
 */
public class Table extends Dataset implements Serializable {

    private static final long serialVersionUID = 4510368628216597916L;

    private final int tableId;

    private DbType dbType;

    public Table(long id, String name, String description, Long parentDatasetHead, int tableId) {
        this(id, name, description, parentDatasetHead, tableId, Collections.emptyList(), Collections.emptyList());
    }

    public Table(long id, String name, String description, Long parentDatasetHead, int tableId, List<Dataset> subDatasets, List<Element> elements) {
        super(id, name, description, parentDatasetHead, subDatasets, elements);
        this.tableId = tableId;
    }

    public int getTableId() {
        return tableId;
    }

    public DbType getDbType() {
        return dbType;
    }

    public void setDbType(DbType dbType) {
        this.dbType = dbType;
    }

    public @Override boolean isPhysical() {
        return true;
    }
}
