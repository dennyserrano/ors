package ph.gov.deped.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bits.sql.JdbcType;

import ph.gov.deped.data.dto.GenericKeyValue;

public class Operational 
{
	private Conjunctive conjunctive;
	private String operator;
	private List<GenericKeyValue<Serializable, String>> values;
	
	public static final String EQUALS="eq";
	public static final String IN="in";
	
	public Conjunctive in(List<GenericKeyValue<Serializable, String>> list)
	{
		operator="in";
		values=list;
		conjunctive=new Conjunctive();
		return conjunctive;
	}
	
	public Conjunctive eq(String str)
	{
		operator="eq";
		values=new ArrayList<GenericKeyValue<Serializable, String>>();
		values.add(new GenericKeyValue<Serializable, String>(str, "varchar"));
		conjunctive=new Conjunctive();
		return conjunctive;
	}
	
	public Conjunctive notEq(String str)
	{
		operator="notEq";
		values=new ArrayList<GenericKeyValue<Serializable, String>>();
		values.add(new GenericKeyValue<Serializable, String>(str, "varchar"));
		conjunctive=new Conjunctive();
		return conjunctive;
	}

	public Conjunctive getConjunctive() {
		return conjunctive;
	}

	public String getOperator() {
		return operator;
	}

	public List<GenericKeyValue<Serializable, String>> getValues() {
		return values;
	}
	
	
	
	
}
