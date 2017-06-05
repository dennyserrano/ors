package ph.gov.deped.data;

public class Conjunctive {

	private Operational operational;
	private String conjunctor;
	private String fieldName;
	private String tablePrefix;
	
	public Operational and(String tablePrefix,String fieldName)
	{
		operational=new Operational();
		conjunctor="and";
		this.tablePrefix=tablePrefix;
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

	public String getTablePrefix() {
		return tablePrefix;
	}
	
	
	
}
