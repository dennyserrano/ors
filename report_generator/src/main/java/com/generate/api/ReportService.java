package com.generate.api;

import java.util.List;

import com.generate.enums.ExportType;
import com.generate.model.File;
import com.util.builders.impl.ColumnExpression;

public interface ReportService {
	public File generate(String sql,List<ColumnExpression> header,ExportType exportType);
}
