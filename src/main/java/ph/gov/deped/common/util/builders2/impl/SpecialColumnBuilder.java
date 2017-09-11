package ph.gov.deped.common.util.builders2.impl;

import ph.gov.deped.common.util.builders2.interfaces.ColumnBuilder;
import ph.gov.deped.data.dto.ColumnExpression;

public class SpecialColumnBuilder implements ColumnBuilder {

	private String alias;
	
	public SpecialColumnBuilder(String alias)
	{
		this.alias=alias;
	}
	
	@Override
	public ColumnExpression build() {
		
		return new CountAllColumnElement(alias);
	}

}
