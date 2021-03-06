package com.generate.xls.export;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.management.RuntimeErrorException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.model.db.ColumnMetadata;
import com.model.db.DatasetElement;
import com.util.builders.impl.ColumnElement;



public class ExcelDocumentConsolidator
{
	//TODO on server start what is directory is not yet present for both single exporter and bulk?
	
	private ColumnElementWorkbookAppender workbookExporter;
	private List<ColumnElement> columns;
	
	private static final Logger log = LogManager.getLogger(ExcelDocumentConsolidator.class);
	
	public ExcelDocumentConsolidator(ColumnElementWorkbookAppender appender,List<ColumnElement> columns)
	{
		workbookExporter=appender;
		this.columns=columns;
		
	}	
	
	public void consolidate(String fileOutputName,String[] fileNames) throws IOException
	{
		if(workbookExporter==null)
			throw new RuntimeException("No appender set");
		
		SXSSFWorkbook wb=new SXSSFWorkbook(100);
		
		for(int x=0;x<fileNames.length;x++)
		{
			String fileName=fileNames[x];
			log.info("consolidating:"+fileName);
			FileInputStream fs=new FileInputStream(fileName);
			Workbook nWb=new XSSFWorkbook(fs);
			workbookExporter.append(nWb, wb, columns,x==0);
			nWb.close();
			fs.close();
		}
		
		System.out.println("filoutoutput:"+fileOutputName);
		FileOutputStream fos=new FileOutputStream(fileOutputName);
		wb.write(fos);
		fos.close();
		wb.dispose();
		System.gc();
		
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

	public void setWorkbookExporter(ColumnElementWorkbookAppender workbookExporter) {
		this.workbookExporter = workbookExporter;
	}

	
	
}
