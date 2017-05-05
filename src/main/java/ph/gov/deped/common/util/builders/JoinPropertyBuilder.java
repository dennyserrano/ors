package ph.gov.deped.common.util.builders;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.bits.sql.JoinType;

import ph.gov.deped.common.util.ConvertUtil;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.ConditionalOperatorType;
import ph.gov.deped.data.dto.JoinOperator;
import ph.gov.deped.data.ors.ds.DatasetCorrelation;
import ph.gov.deped.data.ors.ds.DatasetCorrelationDtl;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroup;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroupDtl;
import ph.gov.deped.data.ors.ds.DatasetHead;

//joinproperty -> joininfo -> joinoperator - > joininfo -> joinoperator
public class JoinPropertyBuilder
{
	
	private JoinInfoBuilder joinInfoBuilder;
	public JoinPropertyBuilder() {
		super();
		joinInfoBuilder=new JoinInfoBuilder();
	}

	public JoinProperty build(DatasetCorrelationGroupDtl groupDetail)
	{
		JoinProperty jp=new JoinProperty();
		DatasetCorrelation dc=groupDetail.getDatasetCorrelation();
		jp.setJoinType(dc.getJoinType());
		JoinOperator jo=buildJoinOperator(dc.getLeftTablePrefix(),dc.getRightTablePrefix(), new ArrayList<DatasetCorrelationDtl>(dc.getDetails()), 0);
		jp.setJoinInfo(jo.getJoinInfo());
		jp.setJoinType(JoinType.LEFT_JOIN); //for every correlation group detail, there is no way we can determine if what join is used?
		return jp;
	}
	
	public JoinPropertyManualBuilder getManualBuilder()
	{
		return new JoinPropertyManualBuilder();
	}
	
	private JoinOperator buildJoinOperator(String leftPrefix,String rightPrefix,List<DatasetCorrelationDtl> list,int indexBaseCount)
	{
		
		if(indexBaseCount<list.size())
		{
			DatasetCorrelationDtl corDtl=list.get(indexBaseCount);
			JoinInfo<ColumnElement,ColumnElement> ji=joinInfoBuilder.build(
					ConvertUtil.toColumnElement(corDtl.getLeftElement(),leftPrefix),
					ConvertUtil.toColumnElement(corDtl.getRightElement(),rightPrefix)
					);
			ji.setNext(buildJoinOperator(leftPrefix,rightPrefix,list, indexBaseCount+1));
			return new JoinOperator(ji, ConditionalOperatorType.AND);
		}
		else
			return null;
	}
	
	protected class JoinPropertyManualBuilder
	{
		
		private JoinProperty jp;
		public JoinPropertyManualBuilder() {
			super();
			jp=new JoinProperty();
		}

		public JoinProperty build()
		{
			if(jp.getJoinType()==null)
				throw new RuntimeException("No Jointype set!");
			return jp;
		}
		
		public JoinPropertyManualBuilder add(String leftPrefix,String leftElementName,String rightPrefix,String rightElementName)
		{
			if(jp.getJoinInfo()==null)
			{
				jp.setJoinInfo(joinInfoBuilder.build(ConvertUtil.toColumnElement(leftPrefix,leftElementName), ConvertUtil.toColumnElement(rightPrefix,rightElementName)));
			}else
			{
				JoinInfo ji=jp.getJoinInfo();
				ji.setNext(new JoinOperator(joinInfoBuilder.build(ConvertUtil.toColumnElement(leftPrefix,leftElementName), ConvertUtil.toColumnElement(rightPrefix,rightElementName)), ConditionalOperatorType.AND));
			}
			return this;
		}
		
		public JoinPropertyManualBuilder set(JoinType jt)
		{
			jp.setJoinType(jt);
			return this;
		}
		
	}

	
}
