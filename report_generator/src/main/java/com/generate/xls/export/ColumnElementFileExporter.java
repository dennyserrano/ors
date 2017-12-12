package com.generate.xls.export;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.util.builders.impl.ColumnElement;


/**
 * Created by PSY on 2014/10/15.
 */
public interface ColumnElementFileExporter {

    void export(String filename, List<List<ColumnElement>> data) throws FileNotFoundException, IOException;
}
