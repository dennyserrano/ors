package ph.gov.deped.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.gov.deped.config.OrsSettings;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.service.export.Exporter;
import ph.gov.deped.service.data.api.ExportService;
import ph.gov.deped.service.data.api.ExportType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

/**
 * Created by PSY on 2014/10/15.
 */
public @Service class ExportServiceImpl implements ExportService {

    private OrsSettings orsSettings;
    
    private Exporter xlsxExporter;

    public @Autowired void setOrsSettings(OrsSettings orsSettings) {
        this.orsSettings = orsSettings;
    }

    public @Autowired void setXlsxExporter(Exporter xlsxExporter) {
        this.xlsxExporter = xlsxExporter;
    }

    public String export(String sessionId, List<List<ColumnElement>> data, ExportType exportType) {
        String filename = randomAlphabetic(8) + "." + exportType.getExtension();
        String tempPath = orsSettings.getTmpDir() + File.separator + filename;
        try {
            xlsxExporter.export(tempPath, data);
        }
        catch (Exception ex) {
            throw new RuntimeException(String.format("Failed to generate exported data to file [%s].", ex), ex);
        }
        
        String downloadPath = orsSettings.getWorkingDir() + File.separator + filename;
        try {
            Files.move(Paths.get(tempPath), Paths.get(downloadPath));
        }
        catch (IOException ex) {
            throw new RuntimeException(String.format("Unable to move XLSX File from [%s] to [%s].", tempPath, downloadPath), ex);
        }
        
        return downloadPath;
    }
}
