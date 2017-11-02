package ph.gov.deped.common.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bits.sql.AggregateTypes;
import com.model.db.ColumnMetadata;
import com.model.db.DatasetCorrelation;
import com.model.db.DatasetCorrelationDtl;
import com.model.db.DatasetCorrelationGroup;
import com.model.db.DatasetElement;
import com.model.db.DatasetHead;

import ph.gov.deped.common.util.builders.impl.ColumnElement;
import ph.gov.deped.common.util.builders.impl.JoinInfo;
import ph.gov.deped.common.util.builders.impl.PrefixTable;
import ph.gov.deped.data.dto.ds.Element;

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
	
	public static PrefixTable toPrefixTableLight(DatasetHead dh)
	{
		HashSet<ColumnElement> columnElementList=new HashSet<ColumnElement>();
		
//		ColumnElement[] ce=new ColumnElement[columnElementList.size()];
		
		return new PrefixTable(dh, dh.getTableMetaData(), columnElementList);
	}
	
	public static ColumnElement toColumnElement(DatasetElement de)
	{
		ColumnElement ce= new ColumnElement(de, de.getColumnMetaData());
//		Aggregatable a=de;
//		Aggregatable b=ce;
//		b.setAggregate(a.getAggregate());
//		ce.setTablePrefix("a");
		return ce;
	}
	
	public static ColumnElement toColumnElement(DatasetElement de,String tablePrefix)
	{
		ColumnElement ce= new ColumnElement(de, de.getColumnMetaData());
//		Aggregatable a=de;
//		Aggregatable b=ce;
//		b.setAggregate(a.getAggregate());
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
	
	public static Element countAll()
	{
		Element e= new Element(0,"*","","",0,false,true);
		e.setAggregate(AggregateTypes.COUNT_ALL.getAggregate());
		return e;
	}
	
	public static DatasetElement toDatasetElement(Element e)
	{
		DatasetElement de=new DatasetElement();
		de.setId(e.getId());
		de.setAggregate(AggregateTypes.valueOf(e.getAggregate()));
		de.setColumnMetaData(new ColumnMetadata(0, "*", "bigint", false, 0, 0L, false));
		de.setDatasetHead(new DatasetHead(0L, "", 0));
		de.setName("count");
		return de;
	}
	
	
}
