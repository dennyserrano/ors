package ph.gov.deped.service.export.xlsx.stylers.interfaces;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import ph.gov.deped.common.util.builders.impl.ColumnElement;

/**
 * @author ej
 * @since Nov 05, 2014 20:24
 */
public interface ColumnElementExcelHeaderCellStyler {

    void applyStyle(Workbook wb,Sheet sheet, Row row, Cell cell,ColumnElement ce);
}
