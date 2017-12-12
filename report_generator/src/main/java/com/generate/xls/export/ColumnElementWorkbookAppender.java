package com.generate.xls.export;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.util.builders.impl.ColumnElement;


public interface ColumnElementWorkbookAppender
{
	Workbook append(Workbook source, Workbook destination, List<ColumnElement> columns,boolean isHeaderIncluded);
}
