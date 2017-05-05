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
		prefixTableBuilder=new PrefixTableBuilder();
	}

	public PrefixTable build(PrefixTable parentTable,DatasetCorrelationGroup group)
	{
		
		if(group.getGroupDetails().size()==0)
			throw new RuntimeException("group details size is 0");

		DatasetCorrelationGroupDtl firstGroupDetail=group.getGroupDetails().get(0);
		
		//it is expected that if a dataset's field has a group. The parent dataset's id should first appear at the first row of the group.
		if(firstGroupDetail.getDatasetCorrelation().getLeftDataset().getId()!=parentTable.getDatasetId()) 
			throw new RuntimeException(String.format("Disalignment of parent table and group detail relationship for table id %s",parentTable.getDatasetId()));
		
		
		JoinProperty firstRowJp= joinPropertyBuilder.build(firstGroupDetail);
		PrefixTable firstRowTable= prefixTableBuilder.lightBuild(firstGroupDetail.getDatasetCorrelation().getRightDataset());
		
		parentTable.addJoin(firstRowTable, firstRowJp);
		
		group.getGroupDetails().remove(0);
		
		
	}
	
	private void findSequence(List<DatasetCorrelationGroupDtl> grpDetails)
	{
		
		
		
		return null;
	}
	
	protected class KeyValue<T,K>
	{
		private T key; 
		private K val;
		public KeyValue(T key, K val) {
			super();
			this.key = key;
			this.val = val;
		}
		
		
	}
}
