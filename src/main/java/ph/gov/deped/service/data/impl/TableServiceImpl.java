package ph.gov.deped.service.data.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.gov.deped.common.util.builders.impl.DatasetSourceImpl;
import ph.gov.deped.common.util.builders.impl.PrefixTable;
import ph.gov.deped.common.util.builders.interfaces.PrefixTableBuilder;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;
import ph.gov.deped.service.data.api.TableService;

@Service
public class TableServiceImpl implements TableService {

	
	@Autowired
	private DatasetRepository datasetRepo;
	
	private PrefixTableBuilder prefixTableBuilder;
	
	
	@Override
	public PrefixTable generateTable(Dataset ds) 
	{
		
		ArrayList<Long> al=new ArrayList<Long>();
		al.add(ds.getId());
		for(Dataset subDataset:ds.getSubDatasets())
			al.add(subDataset.getId());
		
		List<DatasetHead> datasetHeads=datasetRepo.findByIds(al);
		HashMap<Long,DatasetHead> hm=new HashMap<Long, DatasetHead>();
		for(DatasetHead dh:datasetHeads)
			hm.put(dh.getId(), dh);
		
		
		
		prefixTableBuilder=new DatasetSourceImpl(ds, hm);
		prefixTableBuilder.where(ds.getFilters());
		
		if(ds.getAggregateBy()!=null)
			if(ds.getAggregateBy().isCountIncluded())
				prefixTableBuilder.addSpecialColumn(new Element(0, "count(*)", "", "", 0L, false, false));
		
		return prefixTableBuilder.build();
	}

}
