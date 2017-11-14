package com.generate.api;

import java.util.List;

import com.generate.enums.ExportType;
import com.util.builders.impl.ColumnExpression;

public interface ReportService {
	public String generate(String sql,List<ColumnExpression> header,ExportType exportType);
}
