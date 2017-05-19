package ph.gov.deped.common.util.builders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ph.gov.deped.common.util.ConvertUtil;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.ors.ds.DatasetCorrelation;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroup;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroupDtl;
import ph.gov.deped.data.ors.ds.DatasetHead;

public class CorrelationGroupBuilder 
{
	
	private JoinPropertyBuilder joinPropertyBuilder;
	private PrefixTableBuilder prefixTableBuilder;
	private Sequence sequence;
	public CorrelationGroupBuilder() {
		super();
		joinPropertyBuilder=new JoinPropertyBuilder();
		sequence=new ZigZagImpl();
	}

	public Map<PrefixTable,JoinProperty> build(PrefixTable parentTable,DatasetCorrelationGroup group)
	{
		
		if(group.getGroupDetails().size()==0)
			throw new RuntimeException("group details size is 0");

		DatasetCorrelationGroupDtl firstGroupDetail=group.getGroupDetails().get(0);
		
		//it is expected that if a dataset's field has a group. The parent dataset's id should first appear at the first row of the group.
		if(firstGroupDetail.getDatasetCorrelation().getLeftDataset().getId()!=parentTable.getDatasetId()) 
			throw new RuntimeException(String.format("Disalignment of parent table and group detail relationship for table id %s",parentTable.getDatasetId()));
		
		parentTable.setTablePrefix(firstGroupDetail.getDatasetCorrelation().getLeftTablePrefix());
		
		PrefixTable headTable= sequence.getSequence(group.getGroupDetails());
		
		
		return headTable.getJoinTables();
	}
	
	public PrefixTable build(DatasetCorrelationGroup group)
	{
		if(group.getGroupDetails().size()==0)
			throw new RuntimeException("group details size is 0");
		return sequence.getSequence(group.getGroupDetails());
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
			prefixTableBuilder=new PrefixTableBuilder();
			TableWrapper wrapper=null;
			PrefixTable left = null;
			PrefixTable right = null;
			for(DatasetCorrelationGroupDtl dtl:grpDetails)
			{
				DatasetCorrelation dc=dtl.getDatasetCorrelation();
				PrefixTable localRightPrefix=prefixTableBuilder.lightBuild(dc.getRightDataset());
				PrefixTable localLeftPrefix=prefixTableBuilder.lightBuild(dc.getLeftDataset());
				localRightPrefix.setTablePrefix(dc.getRightTablePrefix());
				localLeftPrefix.setTablePrefix(dc.getLeftTablePrefix());
				
				if(left==null && right==null) //first iteration
				{
					left=localLeftPrefix;
					right=localRightPrefix;
					wrapper=new TableWrapper(left);
					wrapper.chain(localRightPrefix,joinPropertyBuilder.build(dtl));
					
				}else if(left.equals(localLeftPrefix) || !localLeftPrefix.equals(right))
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
