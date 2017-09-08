package ph.gov.deped.common.util.builders2.impl;

import ph.gov.deped.common.util.builders2.interfaces.JoinBuilder;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;

public class JoinBuilderFactory {

	public static JoinBuilder get(Element element,String prefix)
	{
		DatasetElement de=element.getDatasetElement();
		return new JoinBuilderDatasetElementImpl(de.getDatasetHead(), de);
	}
	
	public static JoinBuilder get(Dataset d1,Dataset d2)
	{
		return new JoinBuilderDatasetImpl("",d1.getDatasetHead(),"", d2.getDatasetHead());
	}
	
	public static JoinBuilder interim(String leftPrefix,Dataset d1,String rightPrefix,Dataset d2)
	{
		return new InterimJoinBuilderDatasetImpl(leftPrefix,d1.getDatasetHead(),rightPrefix, d2.getDatasetHead());
	}
	
}
