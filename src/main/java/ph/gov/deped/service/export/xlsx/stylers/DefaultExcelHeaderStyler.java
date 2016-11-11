package ph.gov.deped.service.export.xlsx.stylers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.service.export.xlsx.Formats;
import ph.gov.deped.service.export.xlsx.FormattedElement;
import ph.gov.deped.service.export.xlsx.stylers.interfaces.ColumnElementExcelHeaderCellStyler;

public class DefaultExcelHeaderStyler implements ColumnElementExcelHeaderCellStyler {

	@Override
	public void applyStyle(Workbook wb,Sheet sheet, Row row, Cell cell,ColumnElement ce)
	{
		FormattedElement fe = Formats.headerValue().format(ce);
        CellStyle cellStyle = fe.getCellFormat().build(wb);
        cell.setCellStyle(cellStyle);
        sheet.createFreezePane(0, 1);
	}

}
