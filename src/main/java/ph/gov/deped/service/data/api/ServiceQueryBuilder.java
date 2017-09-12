package ph.gov.deped.service.data.api;

import ph.gov.deped.common.util.builders.impl.PrefixTable;

public interface ServiceQueryBuilder
{
	public String getQuery(PrefixTable pt);
}
