package com.bits.sql;

public enum AggregateTypes{

	SUM("SUM"),
	AVERAGE("AVG"),
	COUNT("COUNT"),
	GROUP("GROUP"),
	COUNT_ALL("COUNT");
	
	
	private String aggregate;
	
	AggregateTypes(String aggregate)
	{
		this.aggregate=aggregate;
	}

	public String getAggregate() {
		return aggregate;
	}
	
}
