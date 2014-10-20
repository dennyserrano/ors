package ph.gov.deped.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.gov.deped.config.OrsSettings;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.export.Exporter;
import ph.gov.deped.data.export.text.CsvExporter;
import ph.gov.deped.data.export.xlsx.XlsxExporter;
import ph.gov.deped.service.data.api.ExportService;
import ph.gov.deped.service.data.api.ExportType;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

/**
 * Created by PSY on 2014/10/15.
 */
public @Service class ExportServiceImpl implements ExportService {

    private static final Map<ExportType, Exporter> exporters = new HashMap<>(ExportType.values().length);

    private OrsSettings orsSettings;

    public ExportServiceImpl() {
        exporters.put(ExportType.CSV, new CsvExporter());
        exporters.put(ExportType.XLSX, new XlsxExporter());
    }

    public @Autowired void setOrsSettings(OrsSettings orsSettings) {
        this.orsSettings = orsSettings;
    }

    public String export(List<List<ColumnElement>> data, ExportType exportType) {
        Exporter exporter = exporters.get(exportType);
        if (exporter == null) {
            throw new UnsupportedOperationException(String.format("Exporter for type [%s] is not yet supported.", exportType));
        }

        String filename = orsSettings.getTmpDir() + File.separator + randomAlphabetic(8) + "." + exportType.getExtension();
        exporter.export(filename, data);
        return filename;
    }
}
