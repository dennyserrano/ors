package ph.gov.deped;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTesting 
{
	public static void main(String[] args) throws IOException, InvalidFormatException {
		String loc="/home/denny/Desktop/";
		FileOutputStream fOutputStream=new FileOutputStream(loc+"output.xlsx");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		
		System.out.println("Executing.....");
		
		Workbook destinationWorkbook=getDestinationWorkbook(loc+"output.xlsx");
		for(int x=1;x<=8;x++)
		{
			FileInputStream fStream=new FileInputStream(loc+"samp"+x+".xlsx");
			Workbook sourceWorkbook=new XSSFWorkbook(fStream);
			process(sourceWorkbook.getSheetAt(0), destinationWorkbook.getSheetAt(0));
			sourceWorkbook.close();
		}
		
		destinationWorkbook.write(fOutputStream);
		fOutputStream.close();
		destinationWorkbook.close();
		System.gc();
		System.out.println("Done.....");
		
		br.readLine();
		
//		fOutputStream.close();
//		destinationWorkbook.close();
//		
		
	}
	
	
	public static void process(Sheet sourceSheet,Sheet destinationSheet)
	{
		Iterator<Row> i=sourceSheet.rowIterator();
		int cnt=destinationSheet.getLastRowNum();
		while(i.hasNext())
		{
			Row row=i.next();
			Row destinationRow= destinationSheet.createRow(cnt);
			Iterator<Cell> cellIterator= row.cellIterator();
			
			while(cellIterator.hasNext())
			{
				Cell sourceCell=cellIterator.next();
				Cell destinationCell=destinationRow.createCell(sourceCell.getColumnIndex());
				destinationCell.setCellValue("hello");
			}
			cnt++;
		}
	}
	public static Workbook getDestinationWorkbook(String fileName) throws IOException
	{
		File f=new File(fileName);
//		if(f.exists())
//			return new HSSFWorkbook(new FileInputStream(f));
//		else
//			return new XSSFWorkbook(new FileInputStream(fileName));
		
		SXSSFWorkbook wb=new SXSSFWorkbook();
		wb.createSheet();
		return wb;
	}
	
}
