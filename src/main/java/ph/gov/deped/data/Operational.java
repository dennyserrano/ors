package ph.gov.deped.data;

public class Operational 
{
	private Conjunctive conjunctive;
	private String operator;
	private Object[] values;
	
	public Conjunctive in(Object ...arr)
	{
		operator="in";
		values=arr;
		conjunctive=new Conjunctive();
		return conjunctive;
	}
	
	public Conjunctive eq(String str)
	{
		operator="eq";
		values=new Object[1];
		values[0]=str;
		conjunctive=new Conjunctive();
		return conjunctive;
	}
	
	public Conjunctive notEq(String str)
	{
		operator="notEq";
		values=new Object[1];
		values[0]=str;
		conjunctive=new Conjunctive();
		return conjunctive;
	}

	public Conjunctive getConjunctive() {
		return conjunctive;
	}

	public String getOperator() {
		return operator;
	}

	public Object[] getValues() {
		return values;
	}
	
	
	
}
