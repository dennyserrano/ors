package com.bits.sql;

/**
 * Created by ej on 9/11/14.
 */
public abstract class Projections {
    
    public static Projection column(String columnName) {
        return new Projection(columnName);
    }

    public static Projection column(String tablePrefix, String columnName, String alias) {
        return new Projection(tablePrefix, columnName, alias);
    }
    
    public static Projection column(AggregateTypes at,String tablePrefix,String columnName,String alias){
    	return new AggregateProjection(at.getAggregate(),columnName,tablePrefix,alias); 
    }
    
    public static Projection sum(String tablePrefix,String columnName,String alias){
    	return new AggregateProjection(AggregateTypes.SUM.getAggregate(),columnName,tablePrefix,alias);
    }
    
}
