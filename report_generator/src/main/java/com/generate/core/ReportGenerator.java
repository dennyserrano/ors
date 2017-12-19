package com.generate.core;

import java.util.List;

import com.generate.model.File;
import com.util.builders.impl.ColumnExpression;

public interface ReportGenerator<T> {
	public File export(T e,List<ColumnExpression> l);
}
