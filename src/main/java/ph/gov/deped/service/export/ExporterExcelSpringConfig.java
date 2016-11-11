package ph.gov.deped.service.export;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import ph.gov.deped.service.export.interfaces.ColumnElementFileExporter;
import ph.gov.deped.service.export.xlsx.DefaultExcelCellWriter;
import ph.gov.deped.service.export.xlsx.DisruptedExcelCellWriter;
import ph.gov.deped.service.export.xlsx.XlsxExporter;
import ph.gov.deped.service.export.xlsx.stylers.DefaultExcelHeaderStyler;
import ph.gov.deped.service.export.xlsx.stylers.DefaultExcelValueStyler;
import ph.gov.deped.service.export.xlsx.stylers.interfaces.ColumnElementExcelHeaderCellStyler;

@Configuration
public class ExporterExcelSpringConfig {

	
	public @Bean ColumnElementFileExporter xlsxExporter() {
    	return new XlsxExporter(defaultExcelCellWriter(),new DefaultExcelHeaderStyler(),defaultExcelCellStyler());
    }
    
    public @Bean DefaultExcelCellWriter defaultExcelCellWriter() {
        return new DefaultExcelCellWriter();
    }
    
//    
//    public @Bean DisruptedExcelCellWriter disruptedExcelCellWriter() {
//        return new DisruptedExcelCellWriter(defaultExcelCellWriter());
//    }
    
    public @Bean DefaultExcelValueStyler defaultExcelCellStyler() {
        return new DefaultExcelValueStyler();
    }
    
    public @Bean ColumnElementExcelHeaderCellStyler disruptedExcelCellStyler() {
        return new DefaultExcelHeaderStyler();
    }
	
}
