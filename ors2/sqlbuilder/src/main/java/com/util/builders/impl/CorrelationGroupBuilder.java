package com.util.builders.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;

import com.model.db.DatasetCorrelation;
import com.model.db.DatasetCorrelationGroup;
import com.model.db.DatasetCorrelationGroupDtl;
import com.model.db.DatasetHead;

import ph.gov.deped.common.util.ConvertUtil;
import ph.gov.deped.data.dto.ds.Dataset;

public class CorrelationGroupBuilder 
{
	
	private JoinPropertyBuilder joinPropertyBuilder;
	private Sequence sequence;
	public CorrelationGroupBuilder() {
		super();
		joinPropertyBuilder=new JoinPropertyBuilder();
		sequence=new ZigZagImpl();
	}

	public Map<PrefixTable,JoinProperty> build(PrefixTable parentTable,Dataset leftDataset,DatasetCorrelationGroup group)
	{
		
		if(group.getGroupDetails().size()==0)
			throw new RuntimeException("group details size is 0");

		DatasetCorrelationGroupDtl firstGroupDetail=group.getGroupDetails().iterator().next();
		
		//it is expected that if a dataset's field has a group. The parent dataset's id should first appear at the first row of the group.
		if(firstGroupDetail.getDatasetCorrelation().getLeftDataset().getId()!=parentTable.getDatasetId()) 
			throw new RuntimeException(String.format("Disalignment of parent table and group detail relationship for table id %s",parentTable.getDatasetId()));
		
		parentTable.setTablePrefix(firstGroupDetail.getDatasetCorrelation().getLeftTablePrefix());
		
		PrefixTable headTable= sequence.getSequence(arrange(0,group.getGroupDetails()));
		
		
		return headTable.getJoinTables();
	}
	
	public PrefixTable build(DatasetCorrelationGroup group)
	{
		if(group.getGroupDetails().size()==0)
			throw new RuntimeException("group details size is 0");
		return sequence.getSequence(arrange(0,group.getGroupDetails()));
	}
	
	public PrefixTable build(long referenceId,DatasetCorrelationGroup group)
	{
		if(group.getGroupDetails().size()==0)
			throw new RuntimeException("group details size is 0");
		return sequence.getSequence(arrange(referenceId,group.getGroupDetails()));
	}
	private List<DatasetCorrelationGroupDtl> arrange(long initialId,Set<DatasetCorrelationGroupDtl> set)
	{
		ArrayList<DatasetCorrelationGroupDtl> al= new ArrayList<>();
		long nextId=initialId;
		
		while(nextId!=0)
		{
			int x=0;
			for(DatasetCorrelationGroupDtl dtl:set)
			{
				x++;
				DatasetCorrelation dc=dtl.getDatasetCorrelation();
				if(dc.getLeftDataset().getId()==nextId)
				{
					al.add(dtl);
					nextId=dc.getRightDataset().getId();
					break;
				}
				
				if(x==set.size())
					nextId=0;
			}
			
			
		}
		return al;
	}
	
	
	private interface Sequence
	{
		PrefixTable getSequence(List<DatasetCorrelationGroupDtl> grpDetails);
	}
	
	private class ZigZagImpl implements Sequence
	{

		@Override
		public PrefixTable getSequence(List<DatasetCorrelationGroupDtl> grpDetails) 
		{
			TableWrapper wrapper=null;
			PrefixTable left = null;
			PrefixTable right = null;
			for(DatasetCorrelationGroupDtl dtl:grpDetails)
			{
				DatasetCorrelation dc=dtl.getDatasetCorrelation();
				
				//check if right and left dataset has table mapped?
				PrefixTable localRightPrefix=ConvertUtil.toPrefixTableLight(dc.getRightDataset());
				PrefixTable localLeftPrefix=ConvertUtil.toPrefixTableLight(dc.getLeftDataset());
				localRightPrefix.setTablePrefix(dc.getRightTablePrefix());
				localLeftPrefix.setTablePrefix(dc.getLeftTablePrefix());
				
				if(left==null && right==null) //first iteration
				{
					left=localLeftPrefix;
					right=localRightPrefix;
					wrapper=new TableWrapper(left);
					wrapper.chain(localRightPrefix,joinPropertyBuilder.build(dtl));
					
				}else if(!localLeftPrefix.equals(right))
				{
					throw new RuntimeException("Invalid Sequence:::");
				}
				else
				{
					wrapper.chain(localRightPrefix,joinPropertyBuilder.build(dtl));
					left=localLeftPrefix;
					right=localRightPrefix;
				}
				
			}
			
			return wrapper.getHead();
		}
		
	}
	
//Mixed ZigZag and others
//	private PrefixTable getSequence(List<DatasetCorrelationGroupDtl> grpDetails)
//	{
//		prefixTableBuilder=new PrefixTableBuilder();
//		DatasetCorrelationGroupDtl first=grpDetails.get(0);
//		TableWrapper wrapper=new TableWrapper(prefixTableBuilder.lightBuild(first.getDatasetCorrelation().getLeftDataset()));
//		PrefixTable left = null;
//		PrefixTable right = null;
//		for(DatasetCorrelationGroupDtl dtl:grpDetails)
//		{
//			PrefixTable localRightPrefix=prefixTableBuilder.lightBuild(dtl.getDatasetCorrelation().getRightDataset());
//			PrefixTable localLeftPrefix=prefixTableBuilder.lightBuild(dtl.getDatasetCorrelation().getLeftDataset());
//			
//			if(left==null && right==null) //first iteration
//			{
//				left=localLeftPrefix;
//				right=localRightPrefix;
//			}
//			
//			if(left.equals(localLeftPrefix))
//			{
//				wrapper.append(localRightPrefix,joinPropertyBuilder.build(dtl));
//				left=localLeftPrefix;
//				right=localRightPrefix;
//			}
//			else
//			{
//				wrapper.chain(localRightPrefix,joinPropertyBuilder.build(dtl));
//				left=localLeftPrefix;
//				right=localRightPrefix;
//			}
//			
//		}
//		
//		return wrapper.getHead();
//	}
	
	
	
}
