package com.util.builders.impl;

public class Where {
	
	private String fieldName;
	private String tablePrefix;
	private Operational operational;
	
	public Operational where(String fieldName,String tablePrefix)
	{
		this.fieldName=fieldName;
		this.tablePrefix=tablePrefix;
		operational=new Operational();
		return operational;
	}
	
	public String getFieldName() {
		return fieldName;
	}

	public Operational getOperational() {
		return operational;
	}

	public String getTablePrefix() {
		return tablePrefix;
	}
	
	
//	public static void main(String[] args) {
//		
//		Where where=new Where();
//		where
//		.where("fieldA")
//		.eq("hello")
//		.and("fieldB")
//		.eq("hi");
//		
//		concat(where);
//	}
//	
//	
//	public static void concat(Where where)
//	{
//		if(where.getOperational()!=null)
//		{
//			System.out.println("Where "+ " "+ where.getFieldName());
//			dig(where.getOperational());
//		}
//	}
//	
//	public static void dig(Operational op)
//	{
//		if(op.getConjunctive()!=null)
//		{
//			System.out.println(op.getOperator()+" "+op.getValues());
//			dig(op.getConjunctive());
//		}
//	}
//	
//	public static void dig(Conjunctive con)
//	{
//		if(con.getOperational()!=null)
//			{
//				System.out.println(con.getConjunctor()+" "+con.getFieldName());
//				dig(con.getOperational());
//			}
//	}
	
}
