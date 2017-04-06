package ph.gov.deped.service.data.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;
import ph.gov.deped.service.data.api.DatasetService;

@Service
public class DatasetServiceImpl2 implements DatasetService
{

	@Autowired
	private DatasetRepository datasetRepository;
	
	@Override
	public List<List<ColumnElement>> getData(Dataset dataset,boolean previewOnly) {
		
		
		long[] ids=getIds(dataset.getSubDatasets());
    	
    	if(ids.length==0)
    		throw new RuntimeException("No datasets retrieved out of the given ids");
    	
    	//automatic joining here? 
    	//the tables present here are the ones chosen by the user
    	List<DatasetHead> datasetHeads=datasetRepository.findByIds(ids); 
    	List<Element> selectedUIElements=dataset.getElements();
    	construct(datasetHeads,selectedUIElements);
		
		return null;
	}

	@Override
	public long getDataSize(String sql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getGeneratedSQL(Dataset dataset,
			LinkedList<PrefixTable> prefixTables) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<List<ColumnElement>> getData(String sql,
			LinkedList<PrefixTable> prefixTables,
			LinkedList<ColumnElement> sortedColumns) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<List<ColumnElement>> getData(String sql,
			LinkedList<PrefixTable> prefixTables,
			LinkedList<ColumnElement> sortedColumns,
			LinkedList<ColumnElement> headers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<PrefixTable> getPrefixTables(Dataset dataset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<ColumnElement> getSortedColumns(
			LinkedList<PrefixTable> prefixTables) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<ColumnElement> getHeaders(
			LinkedList<ColumnElement> sortedColumns) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public void getData1(Dataset dataset)
    {
    	
    	
    }
    
    
    private void construct(List<DatasetHead> datasetHeads,List<Element> uiElements)
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
    	
    }
    
    private DatasetElement toDatasetElement(Element elemet)
    {
    	DatasetElement de= new DatasetElement();
//    	de.set
    	return null;
    }
    
    private long[] getIds(List<Dataset> subDataset)
    {
    	
    	if(subDataset==null || subDataset.size()==0)
    		return new long[0];
    	else
    	{
    		long[] ids=new long[subDataset.size()];
    		for(int x=0;x<subDataset.size();x++)
    		{
    			Dataset dataset=subDataset.get(x);
    			ids[x]=dataset.getId();
    		}
    		return ids;
    	}
    	
    }
	

}
