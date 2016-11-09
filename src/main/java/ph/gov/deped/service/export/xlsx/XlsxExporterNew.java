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
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
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
import ph.gov.deped.service.export.interfaces.ColumnElementFileExporter;
import ph.gov.deped.service.export.xlsx.stylers.interfaces.ColumnElementExcelHeaderCellStyler;

@Deprecated //use XlsxExporter
public class XlsxExporterNew implements ColumnElementFileExporter 
{
	
	private static final Logger log = LogManager.getLogger(XlsxExporterNew.class);

    public static final String EXTENSION = "." + ExportType.XLSX.getExtension();
    
    public static final String DEFAULT_SHEET_NAME = "datasets";
    
    @Autowired
    private ExcelCellWriter excelCellWriter;
    
    @Autowired
    private ColumnElementExcelHeaderCellStyler excelCellStyler;
    
    @Autowired
    private FormattingRepository formattingRepository;
	
	@Override
	public void export(String filename, List<List<ColumnElement>> data) 
	{
		
		FileOutputStream fileOutput = read(filename);
		
		SXSSFWorkbook workbook=workbookInstance();
		
		doProcess(workbook, data);

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
        
        
        SXSSFWorkbook wb = new SXSSFWorkbook(500);
        wb.createSheet(DEFAULT_SHEET_NAME);
        
        
        return wb;
    }
	
	private FileOutputStream read(String filename)
	{
		FileOutputStream fileOutput = null;
		try {
			fileOutput=new FileOutputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileOutput;
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
    
    private void doProcess(SXSSFWorkbook formattedWorkbook, List<List<ColumnElement>> data)
    {
    	
    	
    	 SXSSFWorkbook wb = formattedWorkbook;
         SXSSFSheet sheet = (SXSSFSheet) wb.getSheet(DEFAULT_SHEET_NAME);
         List<ColumnElement> rowData;
         Map<Integer, CellFormat> columnFormat = formatColumns(data);

         List<ColumnElement> headers = data.get(0);
         
    	 for (int r = 0; r < data.size(); r++) {
             SXSSFRow row = (SXSSFRow) sheet.createRow(r);
             rowData = data.get(r);
            		 
             for (int c = 0; c < headers.size(); c++)
             {
            	ColumnElement cef=headers.get(c);
             	SXSSFCell cell = (SXSSFCell) row.createCell(c);
             	ColumnElement ce = rowData.get(c);
             	
                 
             	if(r==0) //is row currently header?
             	{
             		FormattedElement fe = Formats.headerValue().format(cef);
             		CellStyle cs=columnFormat.get(c).build(formattedWorkbook);
             		sheet.setDefaultColumnStyle(c, cs);
             		cell.setCellStyle(fe.getCellFormat().build(wb));
             	}
             	
                 excelCellWriter.write(wb, row, cell, ce.getValue());
                 
             }
         }

    	 sheet.createFreezePane(0, 1);
    	 
    }

}
