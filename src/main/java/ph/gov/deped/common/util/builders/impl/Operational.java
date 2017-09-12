package ph.gov.deped.common.util.builders.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bits.sql.JdbcType;

import ph.gov.deped.data.dto.GenericKeyValue;

public class Operational 
{
	private Conjunctive conjunctive;
	private String operator;
	private List values;
	
	public static final String EQUALS="eq";
	public static final String IN="in";
	
	public Conjunctive in(List list)
	{
		operator="in";
		values=list;
		conjunctive=new Conjunctive();
		return conjunctive;
	}
	
	public Conjunctive eq(Object str)
	{
		operator="eq";
		values=new ArrayList();
		values.add(str);
		conjunctive=new Conjunctive();
		return conjunctive;
	}
	
	public Conjunctive notEq(String str)
	{
		operator="notEq";
		values=new ArrayList();
		values.add(str);
		conjunctive=new Conjunctive();
		return conjunctive;
	}

	public Conjunctive getConjunctive() {
		return conjunctive;
	}

	public String getOperator() {
		return operator;
	}

	public List getValues() {
		return values;
	}
	
	
	
	
}
