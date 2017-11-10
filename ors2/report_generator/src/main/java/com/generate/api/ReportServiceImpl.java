package com.generate.api;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generate.core.ReportGeneratorFactory;
import com.generate.core.SqlToData;
import com.generate.enums.ExportType;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	private ReportGeneratorFactory factory;
	
	@Override
	public String generate(String sql, ExportType exportType) {
		
		 
		 return null;
	}

}
