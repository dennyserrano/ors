package ph.gov.deped.data;

public class Where {
	
	private String fieldName;
	private Operational operational;
	
	public Operational where(String fieldName)
	{
		this.fieldName=fieldName;
		operational=new Operational();
		return operational;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Operational getOperational() {
		return operational;
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
