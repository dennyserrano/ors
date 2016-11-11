package ph.gov.deped.service.export;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import ph.gov.deped.service.data.api.ExportType;
import ph.gov.deped.service.export.interfaces.ColumnElementFileExporter;
import ph.gov.deped.service.export.text.CsvExporter;
import ph.gov.deped.service.export.xlsx.*;
import ph.gov.deped.service.export.xlsx.stylers.DefaultExcelHeaderStyler;
import ph.gov.deped.service.export.xlsx.stylers.DefaultExcelValueStyler;
import ph.gov.deped.service.export.xlsx.stylers.DisruptedExcelCellStyler;
import ph.gov.deped.service.export.xlsx.stylers.interfaces.ColumnElementExcelHeaderCellStyler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ej on 10/22/14.
 */
@Configuration
public class ExporterSpringConfig {
    
	@Autowired
	private ColumnElementFileExporter excelExporter;
	
    public @Bean Map<ExportType, ColumnElementFileExporter> exporterMap() {
        Map<ExportType, ColumnElementFileExporter> exporters = new HashMap<>(ExportType.values().length);
        exporters.put(ExportType.CSV, null);
        exporters.put(ExportType.XLSX, excelExporter);
        return exporters;
    }
    
//    public @Bean CsvExporter csvExporter() {
//        return new CsvExporter();
//    }
    
    
}
