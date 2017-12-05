package com.generate.core;

import java.util.List;

import com.util.builders.impl.ColumnExpression;

public interface ReportGenerator<T> {
	public String export(T e,List<ColumnExpression> l);
}
