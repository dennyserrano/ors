package ph.gov.deped.service.export;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ph.gov.deped.service.data.api.ExportType;
import ph.gov.deped.service.export.text.CsvExporter;
import ph.gov.deped.service.export.xlsx.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ej on 10/22/14.
 */
@Configuration
public class ExporterSpringConfig {
    
    public @Bean Map<ExportType, Exporter> exporterMap() {
        Map<ExportType, Exporter> exporters = new HashMap<>(ExportType.values().length);
        exporters.put(ExportType.CSV, csvExporter());
        exporters.put(ExportType.XLSX, xlsxExporter());
        return exporters;
    }
    
    public @Bean CsvExporter csvExporter() {
        return new CsvExporter();
    }
    
    public @Bean @Primary Exporter xlsxExporter() {
        return new XlsxExporter2();
    }
    
    public @Bean @Primary DefaultExcelCellWriter defaultExcelCellWriter() {
        return new DefaultExcelCellWriter();
    }
    
    public @Bean DisruptedExcelCellWriter disruptedExcelCellWriter() {
        return new DisruptedExcelCellWriter(defaultExcelCellWriter());
    }
    
    public @Bean DefaultExcelCellStyler defaultExcelCellStyler() {
        return new DefaultExcelCellStyler();
    }
    
    public @Bean @Primary DisruptedExcelCellStyler disruptedExcelCellStyler() {
        return new DisruptedExcelCellStyler();
    }
}
