package ph.gov.deped.common.util.builders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroup;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroupDtl;
import ph.gov.deped.data.ors.ds.DatasetHead;

public class CorrelationGroupBuilder 
{
	
	private JoinPropertyBuilder joinPropertyBuilder;
	private PrefixTableBuilder prefixTableBuilder;
	
	public CorrelationGroupBuilder() {
		super();
		joinPropertyBuilder=new JoinPropertyBuilder();
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
		
		PrefixTable headTable= getSequence(group.getGroupDetails());
		
		
		return headTable.getJoinTables();
	}
	
	private PrefixTable getSequence(List<DatasetCorrelationGroupDtl> grpDetails)
	{
		prefixTableBuilder=new PrefixTableBuilder();
		DatasetCorrelationGroupDtl first=grpDetails.get(0);
		TableWrapper wrapper=new TableWrapper(prefixTableBuilder.lightBuild(first.getDatasetCorrelation().getLeftDataset()));
		PrefixTable left = null;
		PrefixTable right = null;
		for(DatasetCorrelationGroupDtl dtl:grpDetails)
		{
			PrefixTable localRightPrefix=prefixTableBuilder.lightBuild(dtl.getDatasetCorrelation().getRightDataset());
			PrefixTable localLeftPrefix=prefixTableBuilder.lightBuild(dtl.getDatasetCorrelation().getLeftDataset());
			
			if(left==null && right==null) //first iteration
			{
				left=localLeftPrefix;
				right=localRightPrefix;
			}
			
			if(left.equals(localLeftPrefix))
			{
				wrapper.append(localRightPrefix,joinPropertyBuilder.build(dtl));
				left=localLeftPrefix;
				right=localRightPrefix;
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
