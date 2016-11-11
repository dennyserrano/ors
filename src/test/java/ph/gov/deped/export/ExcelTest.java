package ph.gov.deped.export;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ph.gov.deped.service.export.xlsx.ConsolidatorExcelCellWriter;
import ph.gov.deped.service.export.xlsx.DefaultExcelCellWriter;
import ph.gov.deped.service.export.xlsx.ExcelCellWriter;


public class ExcelTest 
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		System.out.println("Processing...");
		String baseLocation="/home/denny/Desktop/";
		FileOutputStream fileOutput=new FileOutputStream(baseLocation+"output.xlsx");
		Workbook destinationWorkbook=new SXSSFWorkbook();
		Sheet destinationSheet= destinationWorkbook.createSheet();
		ExcelCellWriter cellWriter=new ConsolidatorExcelCellWriter();
		for(int x=1;x<=11;x++)
		{
			FileInputStream fileInputStream=new FileInputStream(baseLocation+"sample"+x+".xlsx");
			Workbook sourceWorkbook=new XSSFWorkbook(fileInputStream);
			Sheet sourceSheet=sourceWorkbook.getSheetAt(0);
			process(destinationWorkbook,sourceSheet,destinationSheet,cellWriter);
			sourceWorkbook.close();
			System.out.println("Now:"+x);
		}
		destinationWorkbook.write(fileOutput);
		fileOutput.close();
		destinationWorkbook.close();
		System.gc();
		System.out.println("Done...");
		br.readLine();
	}
	
	public static void process(Workbook targetWb,Sheet sourceSheet,Sheet destSheet,ExcelCellWriter cellWriter)
	{
		int sourceLastRowCount=destSheet.getLastRowNum();
		Iterator<Row> sourceRowIterator= sourceSheet.rowIterator();
		sourceRowIterator.next();
		while(sourceRowIterator.hasNext())
		{
			Row sourceRow=sourceRowIterator.next();
			Row destinationRow=destSheet.createRow(sourceLastRowCount);
			
			Iterator<Cell> sourceCellIterator=sourceRow.cellIterator();
			
			while(sourceCellIterator.hasNext())
			{
				Cell sourceCell=sourceCellIterator.next();
				Cell destinationCell=destinationRow.createCell(sourceCell.getColumnIndex());
				destinationCell.setCellType(sourceCell.getCellType());
				cellWriter.write(targetWb, destinationRow, destinationCell,(Serializable) getCellValue(sourceCell));
			}
			
			sourceLastRowCount++;
		}
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
		
		return null;
	}
	
}
