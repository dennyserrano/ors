package ph.gov.deped.service.export.xlsx;

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
import java.util.stream.Stream;

import javax.management.RuntimeErrorException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.meta.ColumnMetadata;

public class ExcelDocumentConsolidator 
{
	//TODO on server start what is directory is not yet present for both single exporter and bulk?
	
	private FileOutputStream fileOutput;
	private Workbook destinationWorkbook;
	private String[] files;
	private ExcelCellWriter cellWriter=new ConsolidatorExcelCellWriter();
	public ExcelDocumentConsolidator(String outputFileName,String[] fileNames) throws FileNotFoundException
	{
		fileOutput=new FileOutputStream(outputFileName);
		files=fileNames;
		destinationWorkbook=new SXSSFWorkbook(100);
	}
	
	public void consolidate() throws IOException
	{
		Sheet destinationSheet= destinationWorkbook.createSheet();
		for(int x=0;x<files.length;x++)
		{
			String fileName=files[x];
			System.out.println("PROCESSING:"+fileName);
			FileInputStream fileInputStream = null;
			
			fileInputStream = new FileInputStream(fileName);
			
			Workbook sourceWorkbook = null;
			
			sourceWorkbook = new XSSFWorkbook(fileInputStream);
			
			Sheet sourceSheet=sourceWorkbook.getSheetAt(0);
			process(destinationWorkbook,sourceSheet,destinationSheet,cellWriter,x);
			sourceWorkbook.close();
			fileInputStream.close();
			
		}
		
		destinationWorkbook.write(fileOutput);

		destinationWorkbook.close();
	
		fileOutput.close();
		
		
	}
	
	private void process(Workbook targetWb,Sheet sourceSheet,Sheet destSheet,ExcelCellWriter cellWriter,int fileIndex)
	{
		int sourceLastRowCount=destSheet.getLastRowNum();
		Iterator<Row> sourceRowIterator= sourceSheet.rowIterator();
		
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
		
		throw new RuntimeErrorException(null, "Cell type:"+cell.getCellType()+" Not Present");
	}
	
//	public static void main(String[] args) throws IOException 
//	{
//		ArrayList<String> aFiles=new ArrayList<>();
//		int cnt=0;
//		try(Stream<Path> paths = Files.walk(Paths.get("/home/denny/projects/ors/"))) {
//		    paths.forEach(filePath -> {
//		        if (Files.isRegularFile(filePath)) {
//		        	if(filePath.toString().contains(".xlsx"))
//		        		aFiles.add(filePath.toString());
//		        }
//		    });
//		} 
//		
//		String[] files=new String[aFiles.size()];
//		
//		files= (String[]) aFiles.toArray(files);
//		
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		br.readLine();
//		ExcelWorkbookConsolidator e=new ExcelWorkbookConsolidator("/home/denny/projects/ors/output.xlsx", files);
//		e.consolidate();
//	}
	
}
