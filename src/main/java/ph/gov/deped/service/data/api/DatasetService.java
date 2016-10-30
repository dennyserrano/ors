package ph.gov.deped.service.data.api;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.ds.Dataset;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by ej on 9/10/14.
 */
public interface DatasetService {

    List<List<ColumnElement>> getData(Dataset dataset, boolean previewOnly);
    long getDataSize(String sql);
    String getGeneratedSQL(Dataset dataset,LinkedList<PrefixTable> prefixTables);
    List<List<ColumnElement>> getData(String sql,LinkedList<PrefixTable> prefixTables,LinkedList<ColumnElement> sortedColumns);
	LinkedList<PrefixTable> getPrefixTables(Dataset dataset);
	LinkedList<ColumnElement> getSortedColumns(LinkedList<PrefixTable> prefixTables);
}
