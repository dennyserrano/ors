package ph.gov.deped.service.export.xlsx;

import org.springframework.beans.factory.annotation.Autowired;

import ph.gov.deped.service.export.xlsx.abstracts.AbstractColumnElementExcelExporter;
import ph.gov.deped.service.export.xlsx.stylers.DefaultExcelHeaderStyler;
import ph.gov.deped.service.export.xlsx.stylers.DefaultExcelValueStyler;
import ph.gov.deped.service.export.xlsx.stylers.interfaces.ColumnElementExcelHeaderCellStyler;
import ph.gov.deped.service.export.xlsx.stylers.interfaces.ColumnElementExcelValueCellStyler;

public class XlsxExporterNew2 extends AbstractColumnElementExcelExporter 
{

	@Autowired
	ColumnElementExcelValueCellStyler defaultValueStyler;
	
	@Override
	public ColumnElementExcelHeaderCellStyler getHeaderStyler() {
		// TODO Auto-generated method stub
		return new DefaultExcelHeaderStyler();
	}

	@Override
	public ColumnElementExcelValueCellStyler getValueStyler() {
		// TODO Auto-generated method stub
		return defaultValueStyler;
	}

	@Override
	public ExcelCellWriter getWriter() {
		// TODO Auto-generated method stub
		return new DefaultExcelCellWriter();
	}

}
