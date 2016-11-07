package ph.gov.deped.service.export.xlsx.abstracts;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.repo.jpa.ors.FormattingRepository;
import ph.gov.deped.service.export.ColumnElementFileExporter;
import ph.gov.deped.service.export.xlsx.CellFormat;
import ph.gov.deped.service.export.xlsx.ElementFormatter;
import ph.gov.deped.service.export.xlsx.ColumnElementExcelCellStyler;
import ph.gov.deped.service.export.xlsx.ExcelCellWriter;
import ph.gov.deped.service.export.xlsx.Formats;
import ph.gov.deped.service.export.xlsx.FormattedElement;

public abstract class AbstractColumnElementExcelExporter implements ColumnElementFileExporter
{
	
	public static final String DEFAULT_SHEET_NAME = "datasets";
	
	public abstract ColumnElementExcelCellStyler getHeaderStyler();
//	public abstract ColumnElementExcelCellStyler getValueStyler();
	public abstract ExcelCellWriter getWriter();
	
	@Autowired
    private FormattingRepository formattingRepository;
	
	@Override
	public void export(String filename, List<List<ColumnElement>> data) 
	{
		FileOutputStream fileOutput = read(filename);
		
		Workbook workbook=workbookInstance();
		
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
	
	
	private Workbook workbookInstance() 
	{
        
        SXSSFWorkbook wb = new SXSSFWorkbook(500);
        wb.createSheet(DEFAULT_SHEET_NAME);
        
        return wb;
    }
	
	protected void doProcess(Workbook workbook,List<List<ColumnElement>> data)
	{
		
		Sheet sheet = workbook.getSheet(DEFAULT_SHEET_NAME);
		List<ColumnElement> headers = data.get(0);
		ExcelCellWriter excelCellWriter=getWriter();
		Map<Integer, CellFormat> columnFormat=formatColumns(data);
		ColumnElementExcelCellStyler headerStyler=getHeaderStyler();
		
		for (int r = 0; r < data.size(); r++) {
            Row row = sheet.createRow(r);
            List<ColumnElement> rowData = data.get(r);
           		 
            for (int c = 0; c < headers.size(); c++)
            {
            	ColumnElement cef=headers.get(c);
            	Cell cell = row.createCell(c);
            	ColumnElement ce = rowData.get(c);
            	
                
            	if(r==0) //is row currently header?
            	{
            		headerStyler.applyStyle(workbook, sheet, row, cell, cef);
            		CellStyle cs=columnFormat.get(c).build(workbook);
            		sheet.setDefaultColumnStyle(c, cs);
            	}
            	
                excelCellWriter.write(workbook, row, cell, ce.getValue());
                
            }
        }
	}
	
	protected Map<Integer, CellFormat> formatColumns(List<List<ColumnElement>> data) {
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
	
	public void setFormattingRepository(FormattingRepository formattingRepository) {
		this.formattingRepository = formattingRepository;
	}
	
	
	
}
