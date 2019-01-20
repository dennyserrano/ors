package com.bits.sql;

public class Test
{
	public static void main(String[] args) {
		ProjectionBuilder pb=QueryBuilders.read();
		pb.select(new Projection(""))
		.from("")
		.groupBy()
		.orderBy("")
		
		.build();
	}
}
