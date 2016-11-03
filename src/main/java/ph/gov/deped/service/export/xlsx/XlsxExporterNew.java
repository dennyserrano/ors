package ph.gov.deped.service.export.xlsx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.repo.jpa.ors.FormattingRepository;
import ph.gov.deped.service.data.api.ExportType;
import ph.gov.deped.service.export.ColumnElementFileExporter;

@Deprecated //use XlsxExporter
public class XlsxExporterNew implements ColumnElementFileExporter 
{
	
	private static final Logger log = LogManager.getLogger(XlsxExporterNew.class);

    public static final String EXTENSION = "." + ExportType.XLSX.getExtension();
    
    public static final String DEFAULT_SHEET_NAME = "datasets";
    
    @Autowired
    private ExcelCellWriter excelCellWriter;
    
    @Autowired
    private ExcelCellStyler excelCellStyler;
    
    @Autowired
    private FormattingRepository formattingRepository;
	
	@Override
	public void export(String filename, List<List<ColumnElement>> data) 
	{
		
		FileOutputStream fileOutput = null;
		try {
			fileOutput=new FileOutputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SXSSFWorkbook workbook=workbookInstance();
		doWrite(workbook, data);
		System.out.println("done write");
		try {
			workbook.write(fileOutput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				workbook.close();
				fileOutput.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private SXSSFWorkbook workbookInstance() {
        
        
        SXSSFWorkbook wb = new SXSSFWorkbook();
        wb.createSheet(DEFAULT_SHEET_NAME);

        
        return wb;
    }
	
	private void  streamingWrite(SXSSFWorkbook formattedWorkbook, List<List<ColumnElement>> data) {
        
        SXSSFWorkbook wb = formattedWorkbook;
        SXSSFSheet sheet = (SXSSFSheet) wb.getSheet(DEFAULT_SHEET_NAME);
//        SXSSFRow row;
//        SXSSFCell cell;
        List<ColumnElement> rowData;
        ColumnElement ce;

        long startTimestamp = System.currentTimeMillis();
        for (int r = 0; r < data.size(); r++) {
            SXSSFRow row = (SXSSFRow) sheet.getRow(r);
            rowData = data.get(r);
            for (int c = 0; c < rowData.size(); c++) {
            	SXSSFCell cell = (SXSSFCell) row.getCell(c);
                ce = rowData.get(c);
//                cell.setCellValue(ce.getValue());
                excelCellWriter.write(wb, row, cell, ce.getValue());
            }
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
    
    private void applyFormattings(SXSSFWorkbook workbook, List<List<ColumnElement>> data) {
        
        SXSSFWorkbook wb =workbook;
        Map<Integer, CellFormat> columnFormat = formatColumns(data);
        SXSSFSheet sheet = (SXSSFSheet) wb.getSheetAt(0);
//        
//
//        // apply column formatting.
        columnFormat.entrySet().parallelStream()
                .forEach(entry -> {
                    int col = entry.getKey();
                    CellStyle cellStyle = entry.getValue().build(wb);
                    sheet.setDefaultColumnStyle(col, cellStyle); // column style will only be applied on newly created cells after this
                });

        List<ColumnElement> headers = data.get(0);
        int rows = data.size();
        int cols = headers.size();
        
        for (int r = 0; r < rows; r++) {
            Row row = (SXSSFRow) sheet.createRow(r);
            for (int c = 0; c < cols; c++) {
               ColumnElement ce=headers.get(c);
               Cell cell= row.createCell(c);
               FormattedElement fe = Formats.headerValue().format(ce);
               excelCellStyler.applyStyle(wb, row, cell, fe);
            }
        }

        // Freeze first row or the headers row
        sheet.createFreezePane(0, 1);

        // late apply auto sizing for each columns
        /*row = sheet.getRow(0);
        for (int c = 0; c < row.getLastCellNum(); c++) {
            sheet.autoSizeColumn(c);
        }*/

       
    }
    
    private void doWrite(SXSSFWorkbook formattedWorkbook, List<List<ColumnElement>> data)
    {
    	System.out.println("writing");
    	 SXSSFWorkbook wb = formattedWorkbook;
         SXSSFSheet sheet = (SXSSFSheet) wb.getSheet(DEFAULT_SHEET_NAME);
         List<ColumnElement> rowData;
         Map<Integer, CellFormat> columnFormat = formatColumns(data);
         columnFormat.entrySet().parallelStream()
						         .forEach(entry -> {
						             int col = entry.getKey();
						             CellStyle cellStyle = entry.getValue().build(wb);
						             sheet.setDefaultColumnStyle(col, cellStyle); // column style will only be applied on newly created cells after this
						         });
         List<ColumnElement> headers = data.get(0);
         
    	 for (int r = 0; r < data.size(); r++) {
             SXSSFRow row = (SXSSFRow) sheet.createRow(r);
             rowData = data.get(r);
             for (int c = 0; c < rowData.size(); c++) {
            	ColumnElement ce=headers.get(c);
             	SXSSFCell cell = (SXSSFCell) row.createCell(c);
                 ce = rowData.get(c);
                 FormattedElement fe = Formats.headerValue().format(ce);
//                 excelCellStyler.applyStyle(wb, row, cell, fe);
                 excelCellWriter.write(wb, row, cell, ce.getValue());
                 
             }
         }
    }

}
