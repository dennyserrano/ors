package ph.gov.deped.service.export.xlsx;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ej on 10/21/14.
 */
public class DefaultExcelCellWriter implements ExcelCellWriter {

    public void write(Workbook wb, Row row, Cell cell, FormattedElement fe) {
        CellStyle cellStyle = fe.getCellFormat().build(wb);
        cell.setCellStyle(cellStyle);
        if (fe.getCellType() != null) {
            cell.setCellType(fe.getCellType().intValue());
        }
        if (row.getRowNum() == 0) {
            cell.setCellValue((String) fe.getCellContents());
        }
        else {
            Serializable value = fe.getCellContents();
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
}
