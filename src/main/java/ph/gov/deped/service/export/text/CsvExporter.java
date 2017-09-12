package ph.gov.deped.service.export.text;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ph.gov.deped.common.util.builders.impl.ColumnElement;
import ph.gov.deped.service.data.api.ExportType;
import ph.gov.deped.service.export.interfaces.ColumnElementFileExporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by PSY on 2014/10/15.
 */
public class CsvExporter implements ColumnElementFileExporter {

    public static final String EXTENSION = "." + ExportType.CSV.getExtension();

    private static final Logger log = LogManager.getLogger(CsvExporter.class);

    public void export(String filename, List<List<ColumnElement>> data) {
        if (!filename.endsWith(EXTENSION)) {
            filename = filename + EXTENSION;
        }
        File csvFile = new File(filename);
        if (!csvFile.exists()) {
            try {
                csvFile.createNewFile();
            }
            catch (IOException ex) {
                log.error("Unable to create CSV file [{}].", ex);
                log.catching(ex);
                throw new RuntimeException(ex);
            }
        }
        try (BufferedWriter out = new BufferedWriter(new FileWriter(csvFile))) {
            List<ColumnElement> values;
            StringBuilder line;
            for (int row = 0; row < data.size(); row++) {
                values = data.get(row);
                line = new StringBuilder();
                for (int col = 0; col < values.size(); col++) {
                    line.append("\"").append(String.valueOf(values.get(col).getValue())).append("\"");
                    if (col < values.size() - 1) {
                        line.append(",");
                    }
                }
                write(out, line.toString());
            }
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void write(BufferedWriter out, String line) throws RuntimeException {
        try {
            out.write(line);
            out.write("\n");
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
