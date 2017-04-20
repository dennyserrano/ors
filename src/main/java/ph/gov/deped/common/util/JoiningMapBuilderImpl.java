package ph.gov.deped.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.ors.ds.DatasetHead;

public class JoiningMapBuilderImpl implements JoiningMapBuilder 
{

	private List<DatasetHead> datasetList;
	private Map<Long,PrefixTable> joinMap;
	public JoiningMapBuilderImpl(List<DatasetHead> list)
	{
		datasetList=list;
		joinMap=new HashMap<Long, PrefixTable>();
	}
	
	@Override
	public JoiningMap build() 
	{
		for(DatasetHead dh:datasetList)
			
			
			
		return null;
	}
	


}
