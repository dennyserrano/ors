package ph.gov.deped.common.util.builders.impl;

import ph.gov.deped.data.dto.EqualityOperatorType;

public class JoinInfoBuilder 
{
	public JoinInfo<ColumnElement,ColumnElement> build(ColumnElement left,ColumnElement right)
	{		
		return new JoinInfo<ColumnElement, ColumnElement>(left,right,EqualityOperatorType.EQ);
	}
	
	public JoinInfo<ColumnElement,ColumnElement> build(ColumnElement left,ColumnElement right, EqualityOperatorType op)
	{
		return new JoinInfo<ColumnElement, ColumnElement>(left, right, op);
	}
}
