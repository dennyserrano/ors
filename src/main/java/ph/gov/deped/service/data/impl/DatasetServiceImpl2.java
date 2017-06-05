package ph.gov.deped.service.data.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.gov.deped.common.util.builders.PrefixTableMapBuilder;
import ph.gov.deped.common.util.builders.StarSchemaChainImpl;
import ph.gov.deped.common.util.builders.TableChainer;
//import ph.gov.deped.common.util.builders.StarSchemaChainImpl;
//import ph.gov.deped.common.util.builders.TableChainer;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroup;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroupDtl;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;
import ph.gov.deped.service.data.api.DatasetService;
import ph.gov.deped.service.data.api.ServiceQueryBuilder;
import ph.gov.deped.data.ors.ds.DatasetCorrelation;

@Service
public class DatasetServiceImpl2 implements DatasetService
{

	@Autowired
	private DatasetRepository datasetRepository;
	
	private TableChainer tableChainer=new StarSchemaChainImpl();
	
	private ServiceQueryBuilder serviceQueryBuilder=new ServiceQueryBuilderImpl();
	
	@Override
	public List<List<ColumnElement>> getData(Dataset dataset,boolean previewOnly) {
		
		
		List<Long> ids=getIds(dataset.getSubDatasets());
		ids.add(8L);
    	
    	List<DatasetHead> children= datasetRepository.findByIds(ids);
    	
    	for(DatasetHead dh:children)
    		for(DatasetElement de:dh.getDatasetElements())
    			{
    				DatasetCorrelationGroup grp= de.getDatasetCorrelationGroup();
    				if(grp!=null)
    				for(DatasetCorrelationGroupDtl grpDtl:grp.getGroupDetails())
    				System.out.println();
    			}
    			
    	DatasetHead parent=children.stream().filter(e->e.getId().intValue()==8L).findFirst().get();
    	
    	if(ids.size()==0)
    		throw new RuntimeException("No datasets retrieved out of the given ids");
    	
    	PrefixTable finalTable=tableChainer.chain(parent, children, dataset.getFilters());
    	
    	System.out.println("SQL STATEMENT:"+serviceQueryBuilder.getQuery(finalTable));
    	
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
    
    private List<Long> getIds(List<Dataset> subDataset)
    {
    	
    	if(subDataset==null || subDataset.size()==0)
    		return new ArrayList<Long>();
    	else
    	{
    		ArrayList<Long> retList=new ArrayList<Long>();
    		subDataset.forEach(e->{retList.add(e.getId());});
    		return retList;
    	}
    	
    }
	
    
    private class MandatoryDatasetAppender
    {
    	//dataset, element name
    	public final Map<Long,String[]> MANDATORY_SET=new HashMap<>();
    	private List<Long> ids;
    	private List<Element> elements;
    	private List<DatasetHead> datasetHeads;
    	public MandatoryDatasetAppender() 
    	{
    		MANDATORY_SET.put(8L, new String[]{"sy_from","school_name","division_name","school_id","sector_id"});
		}
    	
    	public List<Long> appendMandatoryIds(List<Long> ids)
    	{
    		 ids.addAll(0, MANDATORY_SET.keySet());
    		 return ids;
    	}
    	
    	public MandatoryDatasetAppender setExistingIds(List<Long> ids)
    	{
    		ids=new ArrayList<Long>(MANDATORY_SET.keySet());
    		ids.addAll(ids);
    		return this;
    	}
    	
    	public MandatoryDatasetAppender setFetchedHeads(List<DatasetHead> dh)
    	{
    		this.datasetHeads=dh;
    		return this;
    	}
    	
    	public MandatoryDataset build()
    	{
    		ArrayList<DatasetElement> elements=new ArrayList<DatasetElement>();
    		ArrayList<Element> mandatorySelectedElements=new ArrayList<Element>();
    		for(DatasetHead dh:datasetHeads)
    		{
    			for(DatasetElement de:dh.getDatasetElements())
				{
    				for(String mandatoryElementName:getMandatoryElements())
						if(mandatoryElementName.equals(de.getName()))
						{
							elements.add(de);
							break;
						}
				}
    			
    			for(DatasetElement de:dh.getDatasetElements())
    			{
    				for(Element selectedElement:this.elements)
    					if(selectedElement.getName().equals(de.getName()))
    						elements.add(de);
    			}
    			
    			dh.getDatasetElements().clear();
    			dh.getDatasetElements().addAll(elements);
    			elements.clear();
    		}
    		elements.clear();
    		elements=null;
    		
    		for(Entry<Long, String[]> entry:MANDATORY_SET.entrySet())
    		{
    			for(DatasetHead dh:datasetHeads)
    				if(dh.getId()==entry.getKey())
    				{
    					for(int x=0;x<entry.getValue().length;x++)
    					{
    						String val=entry.getValue()[x];
    						for(DatasetElement de:dh.getDatasetElements())
    							if(de.getName().equals(val))
    								mandatorySelectedElements.add(toElement(de));
    					}
    				}
    		}
    		
    		
  		return new MandatoryDataset(datasetHeads, mandatorySelectedElements);
    	}
    	
    	private Element toElement(DatasetElement de)
    	{
    		return new Element(de.getId(), de.getName(), de.getDescription(), de.getMeaning(), de.getDatasetHead().getId(), false);
    	}
    	private List<String> getMandatoryElements()
    	{
    		List<String> al=new ArrayList<String>();
    		
    		MANDATORY_SET.entrySet().forEach(e->{
    				for(String s:e.getValue())
    					al.add(s);
				}
    		);
    		
    		return al;
    	}
    	
    	public MandatoryDatasetAppender setSelectedElements(List<Element> elements)
    	{
    		this.elements= new ArrayList<Element>(elements);
    		return this;
    	}
    	
    }
    
    private class MandatoryDataset
    {
    	List<DatasetHead> datasetHeads;
    	List<Element> elements;
		
    	
    	
    	public MandatoryDataset(List<DatasetHead> datasetHeads,
				List<Element> elements) {
			super();
			this.datasetHeads = datasetHeads;
			this.elements = elements;
		}
		public List<DatasetHead> getDatasetHeads() {
			return datasetHeads;
		}
		public void setDatasetHeads(List<DatasetHead> datasetHeads) {
			this.datasetHeads = datasetHeads;
		}
		public List<Element> getElements() {
			return elements;
		}
		public void setElements(List<Element> elements) {
			this.elements = elements;
		}
    	
    	
    }

}
