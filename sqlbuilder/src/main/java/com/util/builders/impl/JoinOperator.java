package com.util.builders.impl;

import com.model.support.ConditionalOperatorType;


public class JoinOperator 
{
	private JoinInfo<ColumnElement,ColumnElement> joinInfo;
	private ConditionalOperatorType operator;
	public JoinOperator(JoinInfo<ColumnElement, ColumnElement> joinInfo,
			ConditionalOperatorType operator) {
		super();
		this.joinInfo = joinInfo;
		this.operator = operator;
	}
	public JoinOperator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JoinInfo<ColumnElement, ColumnElement> getJoinInfo() {
		return joinInfo;
	}
	public void setJoinInfo(JoinInfo<ColumnElement, ColumnElement> joinInfo) {
		this.joinInfo = joinInfo;
	}
	
	
}
