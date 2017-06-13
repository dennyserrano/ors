package ph.gov.deped.web.dataset;

import org.hibernate.transform.ToListResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ph.gov.deped.data.dto.DatasetStore;
import ph.gov.deped.data.dto.ElementsTable;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.repo.jpa.ors.ds.ElementRepository;
import ph.gov.deped.service.meta.api.MetadataService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;import java.util.stream.Collectors;


/**
 * Created by PSY on 2014/09/25.
 */
@RestController
@RequestMapping("/elements")
public class ElementRestController {

    private MetadataService metadataService;
    private long[] mandatoryIds=new long[]{280,285};
    private DatasetStore datasetStore;

    @Autowired
    private ElementRepository elementRepository; 
    
    public @Autowired void setMetadataService(MetadataService metadataService) {
        this.metadataService = metadataService;
    }

    public @Autowired void setDatasetStore(DatasetStore datasetStore) {
        this.datasetStore = datasetStore;
    }

    @RequestMapping(value = "/{headId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Element> findElementsOfHead(@PathVariable("headId") long headId) {
    	
    	List<Element> elems= metadataService.findElements(headId)
		.parallelStream()
    	.collect(()->new ArrayList<>(),(l,e)->{
    		if(e.isVisible())
    			l.add(e);
    	},(l1,l2)->{
    		l1.addAll(l2);
    	});
    	
    	//temporary
//    	List<Element> mandatoryList=metadataService.findElements(8L)
//    	.parallelStream()
//    	.filter(e->{
//    		for(long mandatoryId:mandatoryIds)
//    			if(e.getId()==mandatoryId)
//    				return true;
//    		
//    		return false;
//    	})
//    	.collect(Collectors.toList());
//    	
//    	ArrayList<Element> al=new ArrayList<>(mandatoryList);
//    	al.addAll(elems);
//    	elems.clear();
//    	mandatoryList.clear();
    	return elems;
    }
    
    @RequestMapping(value="/list/{headId}/{ids}",method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
    public List<Element> listElement(@PathVariable("headId") long headId, @PathVariable("ids") long[] ids)
    {
    	List<Element> elements=findElementsOfHead(headId);
    	ArrayList<Element> returnList=new ArrayList<Element>();
    	
    	for(long id:ids)
    		for(Element e:elements)
    			if(e.getId()==id)
    			{
    				returnList.add(e);
    				break;
    			}
    	return returnList;
    }
//    @RequestMapping(value="/map",method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
//    public Map<Long,Element> mapElement(@PathVariable("headId") long headId)
//    {
//    	HashMap<Long,Element> hm=new HashMap<>();
//    	
//    	List<Element> elementList= metadataService.findElements(headId);
//    	
//    	elementList.forEach(e->{hm.put(e.getId(), e);});
//    	
//    	return hm;
//    }
    
    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ElementsTable elements() {
        Dataset dataset = datasetStore.getDataset();
        ElementsTable table = new ElementsTable();
        dataset.getSubDatasets().stream().forEach(table::addDataset);
        
        dataset.getSubDatasets().forEach(ds->{
        	List<Element> li=ds.getElements()
        	.parallelStream()
        	.collect(()->new ArrayList<>(),(l,e)->{
        		if(e.isVisible())
        			l.add(e);
        	},(l1,l2)->{
        		l1.addAll(l2);
        	});
        	ds.setElements(li);

        });
        
        List<Element> mandatoryList=metadataService.findElements(8L)
            	.parallelStream()
            	.filter(e->{
            		for(long mandatoryId:mandatoryIds)
            			if(e.getId()==mandatoryId)
            				return true;
            		
            		return false;
            	})
            	.collect(Collectors.toList());
        
//        dataset.getSubDatasets().parallelStream().collect()
        int largestNumber = dataset.getSubDatasets().parallelStream()
                .map(Dataset::getElements)
                .mapToInt(List::size)
                .max().getAsInt();
        List<Map<Long, Element>> elements = new ArrayList<>();
        for (int i = 0; i < largestNumber; i++) {
            int idx = i;
            Map<Long, Element> row = new HashMap<>();
            dataset.getSubDatasets().stream()
                    .filter(d -> idx < d.getElements().size())
                    .map(d -> d.getElements())
                    .map(es -> es.get(idx))
                    .forEach(e -> row.put(e.getDatasetId(), e));
            
            
            elements.add(i, row);
        }
        
        elements.get(0).put(9016L, mandatoryList.get(0));
        elements.get(1).put(9016L, mandatoryList.get(1));
        
        table.setElements(elements);
        return table;
    }
}
