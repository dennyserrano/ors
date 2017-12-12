package com.generate.xls.services;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.generate.conf.ReportGenProperties;
import com.generate.enums.ExportType;
import com.generate.xls.export.ColumnElementFileExporter;
import com.model.support.Dataset;


public class ExcelExportServiceImpl implements ExportService 
{
	
	@Autowired
	protected ReportGenProperties appProp;
	
	protected ExportType exportType=ExportType.XLSX;
	
	@Autowired
	protected ColumnElementFileExporter exporter;
	
//	@Autowired
//	protected DatasetService datasetService;
	
//	@Override
//	public String export(Dataset dataset) 
//	{
//		String filename = randomAlphabetic(8) + "." + exportType.getExtension();
//        String tempPath = appProp.getTmpDir() + File.separator + filename;
//        String downloadPath = appProp.getDonePath() + File.separator + filename;
//        
//        List<List<ColumnElement>> list=null;//datasetService.getData(dataset, false);
//        
//        try {
//        	exporter.export(tempPath, list);
//        }
//        catch (Exception ex) {
//            throw new RuntimeException(String.format("Failed to generate exported data to file [%s].", ex), ex);
//        }
//        
//        try {
//            Files.move(Paths.get(tempPath), Paths.get(downloadPath));
//        }
//        catch (IOException ex) {
//            throw new RuntimeException(String.format("Unable to move XLSX File from [%s] to [%s].", tempPath, downloadPath), ex);
//        }
//        
//        return tempPath;
//	}


	public ExportType getExportType() {
		return exportType;
	}

	@Override
	public String export(Dataset dataset) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
