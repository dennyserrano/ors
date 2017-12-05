package com.generate.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.generate.enums.ExportType;

@Component
public class ReportGeneratorFactory 
{
	
	@Autowired
	private ReportGenerator excel;
	
	public ReportGenerator get(ExportType et)
	{
		if(et.getExtension().equals(ExportType.XLSX.getExtension()))
			return excel;
		return null;
	}
}
