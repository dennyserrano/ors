package ph.gov.deped.data.export;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import ph.gov.deped.service.data.api.ExportType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by PSY on 2014/10/15.
 */
public class XlsxExporter implements Exporter {

    public static final String EXTENSION = "." + ExportType.XLSX.getExtension();

    public void export(String filename, List<List<Serializable>> data) {
        if (!filename.endsWith(EXTENSION)) {
            filename = filename + EXTENSION;
        }
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        Sheet sheet = wb.createSheet();
        Row row;
        Cell cell;
        List<Serializable> rowData;
        for (int r = 0; r < data.size(); r++) {
            row = sheet.createRow(r);
            rowData = data.get(r);
            for (int c = 0; c < rowData.size(); c++) {
                cell = row.createCell(c);
                cell.setCellValue(String.valueOf(rowData.get(c)));
            }
        }

        File xlsxFile = new File(filename);
        if (!xlsxFile.exists()) {
            try {
                xlsxFile.createNewFile();
            }
            catch (IOException ex) {
                throw new RuntimeException(String.format("Unable to write XLSX file [%s].", filename), ex);
            }
        }
        try (FileOutputStream out = new FileOutputStream(xlsxFile)) {
            wb.write(out);
        }
        catch (FileNotFoundException ex) {
            throw new RuntimeException(String.format("XLSX File not yet created or was not created [%s].", filename), ex);
        }
        catch (IOException ex) {
            throw new RuntimeException(String.format("Problem writing to XSLX file [%s].", filename), ex);
        }
        finally {
            wb.dispose();
        }
    }
}
