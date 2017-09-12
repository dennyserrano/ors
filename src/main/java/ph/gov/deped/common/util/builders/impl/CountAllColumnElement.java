package ph.gov.deped.common.util.builders.impl;


public class CountAllColumnElement implements ColumnExpression {

	private String alias;
	public CountAllColumnElement(String alias)
	{
		this.alias=alias;
	}
	
	@Override
	public String express() {
		
		return String.format("COUNT(*) as %s",alias);
	}

}
