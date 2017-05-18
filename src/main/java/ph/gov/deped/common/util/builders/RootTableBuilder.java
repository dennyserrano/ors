package ph.gov.deped.common.util.builders;

import java.util.List;

import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.ors.ds.DatasetHead;

public class RootTableBuilder 
{
	private PrefixTableBuilder tableBuilder;
	
	public RootTableBuilder()
	{
		tableBuilder=new PrefixTableBuilder();
	}
	
	public PrefixTable build(DatasetHead parent, List<DatasetHead> children)
	{
		return null;
	}
}
