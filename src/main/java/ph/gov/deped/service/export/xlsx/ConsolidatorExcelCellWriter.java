package ph.gov.deped.service.export.xlsx;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class ConsolidatorExcelCellWriter implements ExcelCellWriter {

	@Override
	public void write(Workbook wb, Row row, Cell cell, Serializable value) 
	{
		
		if (value == null) {
            cell.setCellType(Cell.CELL_TYPE_BLANK);
        }
        else {
            Class<? extends Serializable> valueType = value.getClass();
            if (Boolean.class.isAssignableFrom(valueType)) {
                cell.setCellValue((Boolean) value);
            }
            else if (Number.class.isAssignableFrom(valueType)) {
                cell.setCellValue(((Number) value).doubleValue());
            }
            else if (Date.class.isAssignableFrom(valueType)) {
                cell.setCellValue((Date) value);
            }
            else if (Calendar.class.isAssignableFrom(valueType)) {
                cell.setCellValue((Calendar) value);
            }
            else {
                cell.setCellValue(value.toString());
            }
        }

	}

}
