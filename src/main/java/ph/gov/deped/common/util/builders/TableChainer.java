package ph.gov.deped.common.util.builders;

import java.util.List;

import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.ors.ds.DatasetHead;

public interface TableChainer 
{
	public PrefixTable chain(DatasetHead parent,List<DatasetHead> heads);
}
