package ph.gov.deped.data.export.xlsx;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.export.Exporter;
import ph.gov.deped.service.data.api.ExportType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bits.sql.JdbcTypes.*;
import static ph.gov.deped.data.export.xlsx.Formats.*;

/**
 * Created by PSY on 2014/10/15.
 */
public class XlsxExporter implements Exporter {

    public static final String EXTENSION = "." + ExportType.XLSX.getExtension();

    public void export(String filename, List<List<ColumnElement>> data) {
        if (!filename.endsWith(EXTENSION)) {
            filename = filename + EXTENSION;
        }
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet();
        XSSFRow row;
        XSSFCell cell;
        List<ColumnElement> rowData;
        ColumnElement ce;
        FormattedElement fe;
        Map<String, FormattedElement> columnFormat = formatColumns(data);
        XlsxCellWriter writer = new XlsxCellWriter();
        
        for (int r = 0; r < data.size(); r++) {
            row = sheet.createRow(r);
            rowData = data.get(r);
            for (int c = 0; c < rowData.size(); c++) {
                cell = row.createCell(c);
                ce = rowData.get(c);
                if (r == 0) { // first row is always the header
                    fe = headerValue().format(ce);
                }
                else {
                    fe = new FormattedElement(ce, columnFormat.get(ce.getElementName()).getCellFormat());
                }
                writer.publish(wb, row, cell, fe);
            }
        }

        // late apply auto sizing for each columns
        row = sheet.getRow(0);
        for (int c = 0; c < row.getLastCellNum(); c++) {
            sheet.autoSizeColumn(c);
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
    }
    
    private Map<String, FormattedElement> formatColumns(List<List<ColumnElement>> data) {
        Map<String, FormattedElement> columnFormat = new HashMap<>(data.size());
        List<ColumnElement> headers = data.get(0);
        headers.stream()
                .map(ce -> {
                    FormattedElement fe;
                    String dataType = ce.getDataType();
                    if ("school_id".equals(ce.getElementName())) {
                        fe = stringValue().format(ce);
                    }
                    else if ("school_year".equals(ce.getElementName()) || "sy_from".equals(ce.getElementName())) {
                        fe = dateFormattedValue("####").format(ce);
                    }
                    else if (isBoolean(dataType, ce.getPrecision())) {
                        fe = stringValue().format(ce);
                        Boolean b = ce.getValue();
                        fe.setValueOverride((b != null && b) ? "YES" : "NO");
                    }
                    else if (isWholeType(dataType)) {
                        fe = longValue().format(ce);
                    }
                    else if (isDecimalType(dataType)) {
                        fe = decimalValue().format(ce);
                    }
                    else if ("date".equals(dataType)) {
                        fe = dateValue().format(ce);
                    }
                    else if ("time".equals(dataType)) {
                        fe = timeValue().format(ce);
                    }
                    else if ("datetime".equals(dataType) || "timestamp".equals(dataType)) {
                        fe = datetimeValue().format(ce);
                    }
                    else {
                        fe = stringValue().format(ce);
                    }
                    return fe;
                })
                .forEach(fe -> columnFormat.put(fe.getColumnElement().getElementName(), fe));
        return  columnFormat;
    }
}
