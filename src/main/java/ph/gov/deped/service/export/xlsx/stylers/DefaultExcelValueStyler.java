package ph.gov.deped.service.export.xlsx.stylers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;

import ph.gov.deped.common.util.builders.impl.ColumnElement;
import ph.gov.deped.repo.jpa.ors.FormattingRepository;
import ph.gov.deped.service.export.xlsx.CellFormat;
import ph.gov.deped.service.export.xlsx.ElementFormatter;
import ph.gov.deped.service.export.xlsx.Formats;
import ph.gov.deped.service.export.xlsx.FormattedElement;
import ph.gov.deped.service.export.xlsx.stylers.interfaces.ColumnElementExcelHeaderCellStyler;
import ph.gov.deped.service.export.xlsx.stylers.interfaces.ColumnElementExcelValueCellStyler;

/**
 * @author ej
 * @since Nov 05, 2014 20:25
 */
public class DefaultExcelValueStyler implements ColumnElementExcelValueCellStyler 
{
	
    private FormattingRepository formattingRepository;
	
	public void applyStyle(Workbook workbook, Sheet sheet, int columnIndex, List<ColumnElement> columns) 
	{
		Map<Integer, CellFormat> columnFormat=formatColumns(columns);
		CellStyle cs=columnFormat.get(columnIndex).build(workbook);
		sheet.setDefaultColumnStyle(columnIndex, cs);
		columnFormat.clear();
	}
    
	protected Map<Integer, CellFormat> formatColumns(List<ColumnElement> headers) 
	{
        Map<Integer, CellFormat> columnFormat = new HashMap<>(headers.size());
        AtomicInteger atomicInteger = new AtomicInteger(0);
        headers.stream()
                .map(ce -> {
                    String dataType = ce.getDataType();
                    ElementFormatter ef = formattingRepository.findByDatasetElement(ce.getDatasetId(), ce.getElementName());
                    if (ef == null) {
                        ef = formattingRepository.findByKey(dataType);
                    }
                    if (ef == null) {
                        throw new RuntimeException(String.format("Unable to find formatting for [%s].", ce.getDataType()));
                    }
                    return ef.format(ce);
                })
                .forEach(fe -> columnFormat.put(atomicInteger.getAndIncrement(), fe.getCellFormat()));
        return  columnFormat;
    }

	@Autowired
	public void setFormattingRepository(FormattingRepository formattingRepository) {
		this.formattingRepository = formattingRepository;
	}
	
	
	
	
//	public void applyStyle(Workbook wb,Sheet sheet, Row row, Cell cell,ColumnElement ce)
//	{
////    	FormattedElement fe = Formats.headerValue().format(ce);
////        CellStyle cellStyle = fe.getCellFormat().build(wb);
////        cell.setCellStyle(cellStyle);
////        if (fe.getCellType() != null) {
////            cell.setCellType(fe.getCellType().intValue());
////        }
//    }
}
