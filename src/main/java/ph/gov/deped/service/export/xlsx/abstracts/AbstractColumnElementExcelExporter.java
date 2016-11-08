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
import ph.gov.deped.service.export.xlsx.ExcelCellWriter;
import ph.gov.deped.service.export.xlsx.Formats;
import ph.gov.deped.service.export.xlsx.FormattedElement;
import ph.gov.deped.service.export.xlsx.stylers.interfaces.ColumnElementExcelHeaderCellStyler;
import ph.gov.deped.service.export.xlsx.stylers.interfaces.ColumnElementExcelValueCellStyler;

public abstract class AbstractColumnElementExcelExporter implements ColumnElementFileExporter
{
	
	public static final String DEFAULT_SHEET_NAME = "datasets";
	
	public abstract ColumnElementExcelHeaderCellStyler getHeaderStyler();
	public abstract ColumnElementExcelValueCellStyler getValueStyler();
	public abstract ExcelCellWriter getWriter();
	
	
	
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
		
		ColumnElementExcelHeaderCellStyler headerStyler=initializeHeaderStyler();
		ColumnElementExcelValueCellStyler valueStyler=initializeValueStyler();
		
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
            		valueStyler.applyStyle(workbook, sheet, c, headers);
            	}
            	
                excelCellWriter.write(workbook, row, cell, ce.getValue());
                
            }
        }
	}
	
	
	private ColumnElementExcelHeaderCellStyler initializeHeaderStyler()
	{
		ColumnElementExcelHeaderCellStyler hs= getHeaderStyler();
		if(hs==null)
			return new ColumnElementExcelHeaderCellStyler() {
				
				@Override
				public void applyStyle(Workbook wb, Sheet sheet, Row row, Cell cell,
						ColumnElement ce) {
					
					
				}
			};
		else
		{
			return hs;
		}
	}
	
	private ColumnElementExcelValueCellStyler initializeValueStyler()
	{
		ColumnElementExcelValueCellStyler vs=getValueStyler();
		
		if(vs==null)
			return new ColumnElementExcelValueCellStyler() {
				
				@Override
				public void applyStyle(Workbook workbook, Sheet sheet, int columnIndex,
						List<ColumnElement> columns) {
					// TODO Auto-generated method stub
					
				}
			};
		else
		{
			return vs;
		}
	}
	
	
}
