package ph.gov.deped.service.export.xlsx;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author ej
 * @since Nov 05, 2014 20:25
 */
public class DefaultExcelCellStyler implements ExcelCellStyler {
    
    public void applyStyle(Workbook wb, Row row, Cell cell, FormattedElement fe) {
        CellStyle cellStyle = fe.getCellFormat().build(wb);
        cell.setCellStyle(cellStyle);
//        if (fe.getCellType() != null) {
//            cell.setCellType(fe.getCellType().intValue());
//        }
    }
}
