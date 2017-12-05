package com.generate.xls.services;

import com.generate.enums.ExportType;
import com.model.support.Dataset;


public interface ExportBulkService 
{
	public String export(Dataset dataset,ExportType exportType);
}
