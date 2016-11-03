package ph.gov.deped.service.export;

import ph.gov.deped.data.dto.ColumnElement;

import java.util.List;

/**
 * Created by PSY on 2014/10/15.
 */
public interface ColumnElementFileExporter {

    void export(String filename, List<List<ColumnElement>> data);
}
