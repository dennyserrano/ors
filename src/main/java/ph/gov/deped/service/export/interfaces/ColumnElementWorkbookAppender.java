package ph.gov.deped.service.export.interfaces;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.service.export.xlsx.stylers.interfaces.ColumnElementExcelValueCellStyler;

public interface ColumnElementWorkbookAppender
{
	Workbook append(Workbook source, Workbook destination, List<ColumnElement> columns,boolean isHeaderIncluded);
}
