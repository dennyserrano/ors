package ph.gov.deped.service.data.api;

import ph.gov.deped.common.util.builders.impl.PrefixTable;
import ph.gov.deped.data.dto.ds.Dataset;

public interface TableService 
{
	public PrefixTable generateTable(Dataset ds);
}
