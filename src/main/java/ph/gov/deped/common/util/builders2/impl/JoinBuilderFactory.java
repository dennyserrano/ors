package ph.gov.deped.common.util.builders2.impl;

import ph.gov.deped.common.util.builders2.interfaces.JoinBuilder;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;

public class JoinBuilderFactory {

	public static JoinBuilder get(DatasetElement de)
	{
		return new JoinBuilderDatasetElementImpl(de.getDatasetHead(), de);
	}
	
	public static JoinBuilder get(DatasetHead d1,DatasetHead d2)
	{
		return new JoinBuilderDatasetImpl(d1, d2);
	}
	
}
