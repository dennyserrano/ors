package ph.gov.deped.common.util.builders;

import com.bits.sql.JoinType;

import ph.gov.deped.data.dto.ColumnElement;

public class JoinInfoBuilder 
{
	public JoinInfo<ColumnElement,ColumnElement> build(ColumnElement left,ColumnElement right)
	{		
		return new JoinInfo<ColumnElement, ColumnElement>(left, right, JoinType.LEFT_JOIN);
	}
	
	public JoinInfo<ColumnElement,ColumnElement> build(ColumnElement left,ColumnElement right, JoinType joinType)
	{
		return new JoinInfo<ColumnElement, ColumnElement>(left, right, JoinType.LEFT_JOIN);
	}
}
