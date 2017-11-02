package com.util.builders.impl;

import ph.gov.deped.data.dto.EqualityOperatorType;
import ph.gov.deped.data.dto.JoinOperator;

import com.bits.sql.JoinType;

public class JoinInfo<L,R>
{
	private L left;
	private R right;
	private JoinOperator next;
	private EqualityOperatorType operator;
	
	public JoinInfo(L left,R right,EqualityOperatorType operator)
	{
		this(left,right);
		this.operator=operator;
	}
	
	public JoinInfo(L left,R right,EqualityOperatorType operator,JoinOperator next)
	{
		this(left,right);
		this.operator=operator;
		this.next=next;
	}
	
	private JoinInfo(L left,R right)
	{
		this.left=left;
		this.right=right;
	}
	
	public L getLeft() {
		return left;
	}
	public void setLeft(L left) {
		this.left = left;
	}
	public R getRight() {
		return right;
	}
	public void setRight(R right) {
		this.right = right;
	}

	public JoinOperator getNext() {
		return next;
	}

	public void setNext(JoinOperator next) {
		this.next = next;
	}

	public EqualityOperatorType getOperator() {
		return operator;
	}

	public void setOperator(EqualityOperatorType operator) {
		this.operator = operator;
	}
	
	
}
