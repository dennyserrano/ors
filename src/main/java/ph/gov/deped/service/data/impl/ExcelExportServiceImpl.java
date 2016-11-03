package ph.gov.deped.service.data.impl;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import ph.gov.deped.config.OrsSettings;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.service.data.api.ExportService;
import ph.gov.deped.service.data.api.ExportType;

public class ExcelExportServiceImpl implements ExportService 
{
	
	@Autowired
	public OrsSettings orsSettings;
	
	private ExportType exportType=ExportType.XLSX;
	
	
	@Override
	public String export(Dataset dataset) 
	{
		String filename = randomAlphabetic(8) + "." + exportType.getExtension();
        String tempPath = orsSettings.getTmpDir() + File.separator + filename;
//        try {
//            xlsxExporter.export(tempPath, data);
//        }
//        catch (Exception ex) {
//            throw new RuntimeException(String.format("Failed to generate exported data to file [%s].", ex), ex);
//        }
        
        return null;
	}


	public OrsSettings getOrsSettings() {
		return orsSettings;
	}


	public ExportType getExportType() {
		return exportType;
	}

	
	
	
}
