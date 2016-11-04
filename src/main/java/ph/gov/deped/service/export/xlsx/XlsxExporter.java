package ph.gov.deped.service.export.xlsx;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.repo.jpa.ors.FormattingRepository;
import ph.gov.deped.service.data.api.ExportType;
import ph.gov.deped.service.export.ColumnElementFileExporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by PSY on 2014/10/15.
 */
public class XlsxExporter implements ColumnElementFileExporter {
    
    private static final Logger log = LogManager.getLogger(XlsxExporter.class);

    public static final String EXTENSION = "." + ExportType.XLSX.getExtension();
    
    public static final String DEFAULT_SHEET_NAME = "datasets";
    
    private ExcelCellWriter excelCellWriter;
    
    private ExcelCellStyler excelCellStyler;
    
    private FormattingRepository formattingRepository;

    public @Autowired void setExcelCellWriter(ExcelCellWriter excelCellWriter) {
        this.excelCellWriter = excelCellWriter;
    }

    public @Autowired void setExcelCellStyler(ExcelCellStyler excelCellStyler) {
        this.excelCellStyler = excelCellStyler;
    }

    public @Autowired void setFormattingRepository(FormattingRepository formattingRepository) {
        this.formattingRepository = formattingRepository;
    }

    public void export(String filename, List<List<ColumnElement>> data) {
        if (!filename.endsWith(EXTENSION)) {
            filename = filename + EXTENSION;
        }
        
        log.info("Initializing XLSX File [{}]...", filename);
        File xlsxFile = initializeXlsx(filename, data);
        
        log.info("Applying XSLX Formatting to file [{}]...", filename);
        XSSFWorkbook formattedWorkbook = applyFormattings(xlsxFile, filename, data);
        
        log.info("Writing data to XLSX File [{}]...", filename);
        streamingWrite(xlsxFile, filename, formattedWorkbook, data);
        
        try {
            formattedWorkbook.close();
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    private File initializeXlsx(String filename, List<List<ColumnElement>> data) {
        log.entry(filename);
        File xlsxFile = new File(filename);
        if (!xlsxFile.exists()) {
            try {
                xlsxFile.createNewFile();
            }
            catch (IOException ex) {
                throw new RuntimeException(String.format("Unable to write XLSX file [%s].", filename), ex);
            }
        }
        
        XSSFWorkbook wb = new XSSFWorkbook();
        wb.createSheet(DEFAULT_SHEET_NAME);

        try (FileOutputStream out = new FileOutputStream(xlsxFile)) {
            wb.write(out);
        }
        catch (FileNotFoundException ex) {
            throw new RuntimeException(String.format("XLSX File [%s] was not created.", filename), ex);
        }
        catch (IOException ex) {
            throw new RuntimeException(String.format("Problem writing to XSLX file [%s].", filename), ex);
        }
        finally {
            try {
                wb.close();
            }
            catch (IOException ex) {
                log.error(ex);
            }
        }
        return log.exit(xlsxFile);
    }

    private XSSFWorkbook applyFormattings(File xlsxFile, String filename, List<List<ColumnElement>> data) {
        log.entry(xlsxFile, filename);
        XSSFWorkbook wb = new XSSFWorkbook();
//        Map<Integer, CellFormat> columnFormat = formatColumns(data);
        XSSFSheet sheet = wb.createSheet(DEFAULT_SHEET_NAME);
        XSSFRow row;
        XSSFCell cell;
        ColumnElement ce;
        FormattedElement fe;

        // apply column formatting.
//        columnFormat.entrySet().parallelStream()
//                .forEach(entry -> {
//                    int col = entry.getKey();
//                    CellStyle cellStyle = entry.getValue().build(wb);
//                    sheet.setDefaultColumnStyle(col, cellStyle); // column style will only be applied on newly created cells after this
//                });

        List<ColumnElement> headers = data.get(0);
        int rows = data.size();
        int cols = headers.size();
        for (int r = 0; r < rows; r++) {
            row = sheet.createRow(r);
            for (int c = 0; c < cols; c++) {
                row.createCell(c);
            }
        }

        // apply headers formatting
        row = sheet.getRow(0);
        for (int c = 0; c < headers.size(); c++) {
            ce = headers.get(c);
            fe = Formats.headerValue().format(ce);
            cell = row.getCell(c);
            excelCellStyler.applyStyle(wb, row, cell, fe);
        }
        
        // Freeze first row or the headers row
        sheet.createFreezePane(0, 1);

        // late apply auto sizing for each columns
        /*row = sheet.getRow(0);
        for (int c = 0; c < row.getLastCellNum(); c++) {
            sheet.autoSizeColumn(c);
        }*/

        try (FileOutputStream out = new FileOutputStream(xlsxFile)) {
            wb.write(out);
        }
        catch (FileNotFoundException ex) {
            throw new RuntimeException(String.format("XLSX File [%s] was not created.", filename), ex);
        }
        catch (IOException ex) {
            throw new RuntimeException(String.format("Problem writing to XSLX file [%s].", filename), ex);
        }

        return log.exit(wb);
    }

    private void streamingWrite(File xlsxFile, String filename, XSSFWorkbook formattedWorkbook, List<List<ColumnElement>> data) {
        log.entry(xlsxFile, filename, formattedWorkbook);
        XSSFWorkbook wb = formattedWorkbook;
        
        XSSFSheet sheet = wb.getSheet(DEFAULT_SHEET_NAME);
        XSSFRow row;
        XSSFCell cell;
        List<ColumnElement> rowData;
        ColumnElement ce;

        long startTimestamp = System.currentTimeMillis();
        for (int r = 0; r < data.size(); r++) {
            row = sheet.getRow(r);
            rowData = data.get(r);
            for (int c = 0; c < rowData.size(); c++) {
                cell = row.getCell(c);
                ce = rowData.get(c);
                excelCellWriter.write(wb, row, cell, ce.getValue());
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

        long totalWriteTime = System.currentTimeMillis() - startTimestamp;
        log.debug("Total Write Time [{}]", totalWriteTime);
        log.exit();
    }
    
    private Map<Integer, CellFormat> formatColumns(List<List<ColumnElement>> data) {
        List<ColumnElement> headers = data.get(0);
        Map<Integer, CellFormat> columnFormat = new HashMap<>(headers.size());
        AtomicInteger atomicInteger = new AtomicInteger(0);
        headers.stream()
                .map(ce -> {
                    String dataType = ce.getDataType();
                    ElementFormatter ef = formattingRepository.findByDatasetElement(ce.getDatasetId(), ce.getElementName());
                    if (ef == null) {
                        ef = formattingRepository.findByKey(dataType);
                    }
                    if (ef == null) {
                        throw new RuntimeException(String.format("Unable to find formatting for [%s].", ce.getDataType()));
                    }
                    return ef.format(ce);
                })
                .forEach(fe -> columnFormat.put(atomicInteger.getAndIncrement(), fe.getCellFormat()));
        return  columnFormat;
    }
}
