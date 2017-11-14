package com.generate.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generate.core.ReportGenerator;
import com.generate.core.ReportGeneratorFactory;
import com.generate.core.SqlToData;
import com.generate.enums.ExportType;
import com.util.builders.impl.ColumnExpression;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	private ReportGeneratorFactory factory;
	
	

	@Override
	public String generate(String sql, List<ColumnExpression> header,
			ExportType exportType) {
		ReportGenerator<String> rg=factory.get(exportType);
		 
		 return rg.export(sql,header);
	}

}
