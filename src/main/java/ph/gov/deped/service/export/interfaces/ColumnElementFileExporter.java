package ph.gov.deped.service.export.interfaces;

import ph.gov.deped.common.util.builders.impl.ColumnElement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by PSY on 2014/10/15.
 */
public interface ColumnElementFileExporter {

    void export(String filename, List<List<ColumnElement>> data) throws FileNotFoundException, IOException;
}
