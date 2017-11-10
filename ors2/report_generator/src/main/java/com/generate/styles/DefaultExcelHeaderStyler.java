package com.generate.styles;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.util.builders.impl.ColumnElement;


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
