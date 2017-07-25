package ph.gov.deped.common.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ph.gov.deped.common.util.builders.JoinInfo;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.dto.interfaces.Aggregatable;
import ph.gov.deped.data.ors.ds.DatasetCorrelation;
import ph.gov.deped.data.ors.ds.DatasetCorrelationDtl;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroup;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;

public class ConvertUtil 
{
	public static PrefixTable toPrefixTable(DatasetHead dh)
	{
		HashSet<ColumnElement> columnElementList=new HashSet<ColumnElement>();
		if(dh.getDatasetElements()!=null)
		{
//			dh.getDatasetElements().forEach(e->{
//				columnElementList.add(toColumnElement(e));
//			});
			
			for(DatasetElement de:dh.getDatasetElements())
			{
				columnElementList.add(toColumnElement(de));
			}
			
		}
		
//		ColumnElement[] ce=new ColumnElement[columnElementList.size()];
		
		return new PrefixTable(dh, dh.getTableMetaData(), columnElementList);
	}
	
	public static ColumnElement toColumnElement(DatasetElement de)
	{
		ColumnElement ce= new ColumnElement(de, de.getColumnMetaData());
		Aggregatable a=de;
		Aggregatable b=ce;
		b.setAggregate(a.getAggregate());
//		ce.setTablePrefix("a");
		return ce;
	}
	
	public static ColumnElement toColumnElement(DatasetElement de,String tablePrefix)
	{
		ColumnElement ce= new ColumnElement(de, de.getColumnMetaData());
		Aggregatable a=de;
		Aggregatable b=ce;
		b.setAggregate(a.getAggregate());
		ce.setTablePrefix(tablePrefix);
		return ce;
	}

	public static ColumnElement toColumnElement(String fieldName)
	{
		ColumnElement ce=new ColumnElement(null,fieldName);
		return ce;
	}
	
	public static ColumnElement toColumnElement(String prefix,String fieldName)
	{
		ColumnElement ce=new ColumnElement(fieldName, prefix);
		return ce;
	}
	
	public static Element toElement(DatasetElement de)
	{
		return new Element(de.getId(),
				de.getName(),
				de.getDescription(),
				de.getMeaning(),
				de.getDatasetHead().getId(),
				false,false);
	}
	
	
}
