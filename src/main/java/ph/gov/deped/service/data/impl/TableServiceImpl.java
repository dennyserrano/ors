package ph.gov.deped.service.data.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.sql.AggregateTypes;

import ph.gov.deped.common.util.builders.impl.DatasetSourceImpl;
import ph.gov.deped.common.util.builders.impl.PrefixTable;
import ph.gov.deped.common.util.builders.interfaces.PrefixTableBuilder;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;
import ph.gov.deped.service.data.api.TableService;

@Service
public class TableServiceImpl implements TableService {

	
	@Autowired
	private DatasetRepository datasetRepo;
	
	private PrefixTableBuilder prefixTableBuilder;
	
	 private static final long[] MANDATORY_IDS=new long[]{266,267,268,281,285,286,282,283,284};
		private static final ArrayList<Element> MANDATORY_ELEMENTS;
		static{
			MANDATORY_ELEMENTS=new ArrayList<Element>();
			for(long id:MANDATORY_IDS)
				MANDATORY_ELEMENTS.add(new Element(id, "", "", "", 0L, false, false));
		}
	
	
	@Override
	public PrefixTable generateTable(Dataset ds) 
	{
		ArrayList<Element> groupByList=new ArrayList<Element>();
		if(ds.getAggregateBy()!=null)
		{
			ArrayList<Element> al= new ArrayList<Element>(ds.getElements());
    		
    		for(int x=ds.getAggregateBy().getElements().size()-1;x>=0;x--)
    		{
    			Element e=ds.getAggregateBy().getElements().get(x);
    			groupByList.add(e);
    			al.add(0,e);
    		}
    		ds.setElements(al);

		}else
			ds.getElements().addAll(0, MANDATORY_ELEMENTS);
		
		ArrayList<Long> al=new ArrayList<Long>();
		al.add(ds.getId());
		for(Dataset subDataset:ds.getSubDatasets())
			al.add(subDataset.getId());
		
		List<DatasetHead> datasetHeads=datasetRepo.findByIds(al);
		HashMap<Long,DatasetHead> hm=new HashMap<Long, DatasetHead>();
		for(DatasetHead dh:datasetHeads)
			{
				for(DatasetElement de:dh.getDatasetElements())
					System.out.println();
				hm.put(dh.getId(), dh);
			}
		
		
		
		prefixTableBuilder=new DatasetSourceImpl(ds, hm);
		prefixTableBuilder.where(ds.getFilters());
		
		if(ds.getAggregateBy()!=null)
			if(ds.getAggregateBy().isCountIncluded())
				prefixTableBuilder.addSpecialColumn(new Element(0, "count(*)", "", "", 0L, false, false));
		
		for(Element e:groupByList)
		prefixTableBuilder.addGroupBy(e);
		
		return prefixTableBuilder.build();
	}

}
