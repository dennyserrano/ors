package ph.gov.deped.service.export.xlsx;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author ej
 * @since Nov 05, 2014 20:24
 */
public interface ExcelCellStyler {

    void applyStyle(Workbook wb, Row row, Cell cell, FormattedElement fe);
}
