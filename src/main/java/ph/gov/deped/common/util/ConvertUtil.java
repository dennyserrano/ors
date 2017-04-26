package ph.gov.deped.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ph.gov.deped.common.util.builders.JoinInfo;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.ors.ds.DatasetCorrelation;
import ph.gov.deped.data.ors.ds.DatasetCorrelationDtl;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;

public class ConvertUtil 
{
	public static PrefixTable toPrefixTable(DatasetHead dh)
	{
//		List<ColumnElement> columnElementList=new ArrayList<ColumnElement>();
//		if(dh.getDatasetElements()!=null)
//		{
//			dh.getDatasetElements().forEach(e->{
//				columnElementList.add(toColumnElement(e));
//			});
//		}
//		
//		ColumnElement[] ce=new ColumnElement[columnElementList.size()];
		
		return null;
	}
	
	public static ColumnElement toColumnElement(DatasetElement de)
	{
//		Set<DatasetCorrelation> list=de.getDatasetCorrelations();
//		ArrayList<JoinInfo<PrefixTable,PrefixTable>> relationList=new ArrayList<>();
//		
//		if(list!=null)
//		{
//			list.forEach(e->{
//				relationList.add(toJoinTable(e));
//			});
//		}
		return null;
	}
	
	public static JoinInfo<PrefixTable,PrefixTable> toJoinTable(DatasetCorrelation dc)
	{
//			JoinInfo<PrefixTable,PrefixTable> ji=new JoinInfo<PrefixTable,PrefixTable>(toPrefixTable(dc.getLeftDataset()),toPrefixTable(dc.getRightDataset()),dc.getJoinType().toString());
//			PrefixTable prefixLeft=ji.getLeft();
//			PrefixTable prefixRight=ji.getRight();
//			
////			for(DatasetCorrelationDtl dtl: dc.getDetails())
////			{
////				prefixLeft
////			}
			
			return null;
	}
	
	
}
