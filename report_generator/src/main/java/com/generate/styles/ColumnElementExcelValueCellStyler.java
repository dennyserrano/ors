package com.generate.styles;

import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.util.builders.impl.ColumnElement;



public interface ColumnElementExcelValueCellStyler 
{
	public void applyStyle(Workbook workbook,Sheet sheet,int columnIndex, List<ColumnElement> columns);
}
