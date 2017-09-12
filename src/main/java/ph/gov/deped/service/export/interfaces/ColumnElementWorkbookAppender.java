package ph.gov.deped.service.export.interfaces;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import ph.gov.deped.common.util.builders.impl.ColumnElement;
import ph.gov.deped.service.export.xlsx.stylers.interfaces.ColumnElementExcelValueCellStyler;

public interface ColumnElementWorkbookAppender
{
	Workbook append(Workbook source, Workbook destination, List<ColumnElement> columns,boolean isHeaderIncluded);
}
