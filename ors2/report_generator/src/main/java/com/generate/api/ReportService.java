package com.generate.api;

import com.generate.enums.ExportType;

public interface ReportService {
	public String generate(String sql,ExportType exportType);
}
