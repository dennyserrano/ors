package ph.gov.deped.common.util.builders.impl;

import ph.gov.deped.common.util.builders.interfaces.ColumnBuilder;
import ph.gov.deped.data.ors.ds.DatasetElement;

public class DatasetElementColumnBuilder implements ColumnBuilder {

	private DatasetElement element;
	private String prefix;
	public DatasetElementColumnBuilder(String prefix,DatasetElement element)
	{
		this.element=element;
		this.prefix=prefix;
	}
	
	@Override
	public ColumnExpression build() {
		
		return new ColumnElement(getFieldName(),getAlias(),getPrefix());
	}

	protected String getAlias()
	{
		return element.getName();
	}
	
	
	protected String getFieldName()
	{
		return element.getColumnMetaData().getColumnName();
	}
	
	protected String getPrefix()
	{
		return prefix;
	}
	
}
