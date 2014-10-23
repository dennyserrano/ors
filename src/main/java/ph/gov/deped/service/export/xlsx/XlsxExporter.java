package ph.gov.deped.service.export.xlsx;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.repo.jpa.ors.FormattingRepository;
import ph.gov.deped.service.data.api.ExportType;
import ph.gov.deped.service.export.Exporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PSY on 2014/10/15.
 */
public class XlsxExporter implements Exporter {
    
    private static final Logger log = LogManager.getLogger(XlsxExporter.class);

    public static final String EXTENSION = "." + ExportType.XLSX.getExtension();
    
    private ExcelCellWriter excelCellWriter;
    
    private FormattingRepository formattingRepository;

    public @Autowired void setExcelCellWriter(ExcelCellWriter excelCellWriter) {
        this.excelCellWriter = excelCellWriter;
    }

    public @Autowired void setFormattingRepository(FormattingRepository formattingRepository) {
        this.formattingRepository = formattingRepository;
    }

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
        
        long startTimestamp = System.currentTimeMillis();
        for (int r = 0; r < data.size(); r++) {
            row = sheet.createRow(r);
            rowData = data.get(r);
            for (int c = 0; c < rowData.size(); c++) {
                cell = row.createCell(c);
                ce = rowData.get(c);
                if (r == 0) { // first row is always the header
                    fe = Formats.headerValue().format(ce);
                }
                else {
                    fe = new FormattedElement(ce, columnFormat.get(ce.getElementName()).getCellFormat());
                }
                excelCellWriter.write(wb, row, cell, fe);
            }
        }
        long totalWriteTime = System.currentTimeMillis() - startTimestamp;
        log.debug("Total Write Time [{}]", totalWriteTime);

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
            throw new RuntimeException(String.format("XLSX File [%s] was not created.", filename), ex);
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
                    String dataType = ce.getDataType();
                    ElementFormatter ef = formattingRepository.findByDatasetElement(ce.getDatasetId(), ce.getElementName());
                    if (ef == null) {
                        ef = formattingRepository.findByKey(dataType);
                    }
                    return ef.format(ce);
                })
                .forEach(fe -> columnFormat.put(fe.getColumnElement().getElementName(), fe));
        return  columnFormat;
    }
}
