package com.util.builders.impl;

import com.model.db.DatasetElement;
import com.model.db.DatasetHead;
import com.model.support.Dataset;
import com.model.support.Element;
import com.util.builders.interfaces.JoinBuilder;


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
