package ph.gov.deped.service.export.xlsx;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.service.export.interfaces.ColumnElementFileExporter;
import ph.gov.deped.service.export.interfaces.ColumnElementWorkbookAppender;
import ph.gov.deped.service.export.xlsx.abstracts.AbstractColumnElementExcelExporter;
import ph.gov.deped.service.export.xlsx.stylers.DefaultExcelHeaderStyler;
import ph.gov.deped.service.export.xlsx.stylers.DefaultExcelValueStyler;
import ph.gov.deped.service.export.xlsx.stylers.interfaces.ColumnElementExcelHeaderCellStyler;
import ph.gov.deped.service.export.xlsx.stylers.interfaces.ColumnElementExcelValueCellStyler;

public class XlsxExporterNew2 implements ColumnElementFileExporter,ColumnElementWorkbookAppender
{
	
	public static final String DEFAULT_SHEET_NAME = "datasets";
	private ExcelCellWriter cellWriter;
	private ColumnElementExcelHeaderCellStyler headerStyler;
	private ColumnElementExcelValueCellStyler cellValueStyler;
	
	public XlsxExporterNew2(ExcelCellWriter writer, ColumnElementExcelHeaderCellStyler headerStyler, ColumnElementExcelValueCellStyler valueStyler)
	{
		if(writer==null)
			throw new RuntimeException("No Writer provided");
		cellWriter=writer;
		this.headerStyler=headerStyler;
		this.cellValueStyler=valueStyler;
		
	}
	
	public XlsxExporterNew2(ExcelCellWriter writer)
	{
		if(writer==null)
			throw new RuntimeException("No Writer provided");
		cellWriter=writer;
		
	}
	
	
	private ExcelCellWriter getWriter()
	{
		return cellWriter;
	}
	
	private ColumnElementExcelHeaderCellStyler initializeHeaderStyler()
	{
		if(headerStyler==null)
			return new ColumnElementExcelHeaderCellStyler() {
				
				@Override
				public void applyStyle(Workbook wb, Sheet sheet, Row row, Cell cell,
						ColumnElement ce) {
					// TODO Auto-generated method stub
					
				}
			};
			else
				return headerStyler;
	}
	
	private ColumnElementExcelValueCellStyler initializeValueStyler()
	{
		if(cellValueStyler==null)
			return new ColumnElementExcelValueCellStyler() {
				
				@Override
				public void applyStyle(Workbook workbook, Sheet sheet, int columnIndex,
						List<ColumnElement> columns) {
					// TODO Auto-generated method stub
					
				}
			};
			else
			return cellValueStyler;
	}
	
	protected Workbook doProcess(Workbook workbook,List<List<ColumnElement>> data)
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
		
		return workbook;
	}
	
	protected Workbook doProcess(Workbook source,Workbook destination,List<ColumnElement> columns)
	{
		Sheet destSheet=destination.getSheet(DEFAULT_SHEET_NAME);
		Sheet sourceSheet=source.getSheet(DEFAULT_SHEET_NAME);
		int sourceLastRowCount=destSheet.getLastRowNum();
		Iterator<Row> sourceRowIterator= sourceSheet.rowIterator();
		ColumnElementExcelHeaderCellStyler headerStyler=initializeHeaderStyler();
		ColumnElementExcelValueCellStyler cellValueStyler=initializeValueStyler();

		List<ColumnElement> headers = columns;
		
//		if(fileIndex!=0) 
//			sourceRowIterator.next();
		
		while(sourceRowIterator.hasNext())
		{
			
			Row sourceRow=sourceRowIterator.next();
			Row destinationRow=destSheet.createRow(sourceLastRowCount);
			
			Iterator<Cell> sourceCellIterator=sourceRow.cellIterator();
			
			while(sourceCellIterator.hasNext())
			{
				Cell sourceCell=sourceCellIterator.next();
				Cell destinationCell=destinationRow.createCell(sourceCell.getColumnIndex());
				
				
				if(sourceRow.getRowNum()==0)
				{
					ColumnElement cef=headers.get(sourceCell.getColumnIndex());
					headerStyler.applyStyle(destination, destSheet, destinationRow, destinationCell,cef);
					cellValueStyler.applyStyle(destination, destSheet, sourceCell.getRowIndex(), columns);
				}
				
				cellWriter.write(destination, destinationRow, destinationCell,(Serializable) getCellValue(sourceCell));
			}
			
			sourceLastRowCount++;
		}
		
		return destination;
	}

	private void initializeWorkbook(Workbook wb)
	{
		if(wb.getSheet(DEFAULT_SHEET_NAME)==null)
			wb.createSheet(DEFAULT_SHEET_NAME);
	}
	
	
	@Override
	public Workbook append(Workbook source, Workbook destination,List<ColumnElement> columns) 
	{
		initializeWorkbook(destination);
		return doProcess(source, destination, columns);
	}

	@Override
	public void export(String filename, List<List<ColumnElement>> data) throws IOException 
	{
		
		FileOutputStream fos=new FileOutputStream(filename);
		Workbook wb=new SXSSFWorkbook();
		initializeWorkbook(wb);
		doProcess(wb, data);
		wb.write(fos);
	}

	
	public static Object getCellValue(Cell cell)
	{
		switch(cell.getCellType())
		{
			case Cell.CELL_TYPE_BLANK:
				return cell.getStringCellValue();
			case Cell.CELL_TYPE_BOOLEAN:
				return cell.getBooleanCellValue();
			case Cell.CELL_TYPE_ERROR:
				return cell.getErrorCellValue();
			case Cell.CELL_TYPE_NUMERIC:
				return cell.getNumericCellValue();
			case Cell.CELL_TYPE_STRING:
				return cell.getStringCellValue();
			
		}
		
		throw new RuntimeErrorException(null, "Cell type:"+cell.getCellType()+" Not Present");
	}
}
