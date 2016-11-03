package ph.gov.deped.service.data.impl;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ph.gov.deped.config.OrsSettings;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.service.data.api.DatasetService;
import ph.gov.deped.service.data.api.ExportService;
import ph.gov.deped.service.data.api.ExportType;
import ph.gov.deped.service.export.ColumnElementFileExporter;

public class ExcelExportServiceImpl implements ExportService 
{
	
	@Autowired
	protected OrsSettings orsSettings;
	
	protected ExportType exportType=ExportType.XLSX;
	
	@Autowired
	protected ColumnElementFileExporter exporter;
	
	@Autowired
	protected DatasetService datasetService;
	
	@Override
	public String export(Dataset dataset) 
	{
		String filename = randomAlphabetic(8) + "." + exportType.getExtension();
        String tempPath = orsSettings.getTmpDir() + File.separator + filename;
        String downloadPath = orsSettings.getWorkingDir() + File.separator + filename;
        
        List<List<ColumnElement>> list=datasetService.getData(dataset, false);
        
        try {
        	exporter.export(tempPath, list);
        }
        catch (Exception ex) {
            throw new RuntimeException(String.format("Failed to generate exported data to file [%s].", ex), ex);
        }
        
        try {
            Files.move(Paths.get(tempPath), Paths.get(downloadPath));
        }
        catch (IOException ex) {
            throw new RuntimeException(String.format("Unable to move XLSX File from [%s] to [%s].", tempPath, downloadPath), ex);
        }
        
        return tempPath;
	}


	public OrsSettings getOrsSettings() {
		return orsSettings;
	}


	public ExportType getExportType() {
		return exportType;
	}

	
	
	
}
