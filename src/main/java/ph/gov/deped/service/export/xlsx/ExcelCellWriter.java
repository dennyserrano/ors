package ph.gov.deped.service.export.xlsx;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Created by ej on 10/22/14.
 */
public interface ExcelCellWriter {
    
    void write(Workbook wb, Row row, Cell cell, FormattedElement fe);
}
