package ph.gov.deped.data;

public class Conjunctive {

	private Operational operational;
	private String conjunctor;
	private String fieldName;
	
	public Operational and(String fieldName)
	{
		operational=new Operational();
		conjunctor="and";
		this.fieldName=fieldName;
		return operational;
	}
	
	public Operational or(String fieldName)
	{
		operational=new Operational();
		conjunctor="or";
		this.fieldName=fieldName;
		return operational;
	}

	public Operational getOperational() {
		return operational;
	}

	public String getConjunctor() {
		return conjunctor;
	}

	public String getFieldName() {
		return fieldName;
	}
	
	
	
}
