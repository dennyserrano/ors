package ph.gov.deped.common.util.builders;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
		JoinOperator jo=buildJoinInfo(new ArrayList<DatasetCorrelationDtl>(dc.getDetails()), 0);
		jp.setJoinInfo(jo.getJoinInfo());
		return jp;
	}
	
	private JoinOperator buildJoinInfo(List<DatasetCorrelationDtl> list,int indexBaseCount)
	{
		
		if(list.size()<indexBaseCount)
		{
			DatasetCorrelationDtl corDtl=list.get(indexBaseCount);
			JoinInfo<ColumnElement,ColumnElement> ji=joinInfoBuilder.build(
					ConvertUtil.toColumnElement(corDtl.getLeftElement()),
					ConvertUtil.toColumnElement(corDtl.getRightElement())
					);
			ji.setNext(buildJoinInfo(list, indexBaseCount+1));
			return new JoinOperator(ji, ConditionalOperatorType.AND);
		}
		else
			return null;
	}
	
	
	
}
