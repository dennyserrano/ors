package ph.gov.deped.common.util.builders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ph.gov.deped.common.util.ConvertUtil;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.ors.ds.DatasetCorrelation;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;

public class PrefixTableMapBuilder 
{
	private List<DatasetHead> datasetHeads;
	private List<Element> elements;
	private Map<Long,DatasetHead> datasetHeadReferenceMap;
	public PrefixTableMapBuilder(List<DatasetHead> datasetHeads,List<Element> elements)
	{
		this.datasetHeads=datasetHeads;
		this.elements=elements;
		datasetHeadReferenceMap=new HashMap<Long, DatasetHead>();
		if(datasetHeads==null)
			throw new RuntimeException();
		
		if(elements==null)
			throw new RuntimeException();
	}
	
	public Map<Long,PrefixTable> build()
	{
		List<DatasetHead> ldatasetHeads=construct(datasetHeads,elements);
		Map<Long,PrefixTable> map=new HashMap<>();
		
		
		
		ldatasetHeads.forEach(e->{
			map.put(e.getId(), ConvertUtil.toPrefixTable(e));
		});
		
		return map;
	}
	
	
	private List<DatasetHead> construct(List<DatasetHead> datasetHeads,List<Element> uiElements)
    {
    	Map<Long,List<Element>> map=new HashMap<Long, List<Element>>();
    	
    	uiElements.forEach(e->{
    		if(!map.containsKey(e.getDatasetId()))
    		{
    			ArrayList<Element> al=new ArrayList<>();
    			al.add(e);
    			map.put(e.getDatasetId(), al);
    		}
    		else
    		{
    			ArrayList<Element> elementList= (ArrayList<Element>) map.get(e.getDatasetId());
    			elementList.add(e);
    		}
    	});
    	
    	datasetHeads.forEach(e->{
    		List<Element> elementList= map.get(e.getId());
    		Set<DatasetElement> datasetHeadElementList=e.getDatasetElements();
    		HashSet<DatasetElement> finalSet=new HashSet<>();
    		elementList.forEach(elem->{
    			datasetHeadElementList.forEach(setE->{
    				if(elem.getId()==setE.getId())
    						finalSet.add(setE);
    					
    			});
    		});
    		e.setDatasetElements(finalSet);
    	});

    	
    	
    	return datasetHeads;
    	
    }
}