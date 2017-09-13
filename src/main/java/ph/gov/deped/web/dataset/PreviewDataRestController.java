package ph.gov.deped.web.dataset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bits.sql.AggregateTypes;

import ph.gov.deped.common.util.builders.impl.ColumnElement;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.service.data.api.DatasetService;
import ph.gov.deped.service.data.api.TableService;
import ph.gov.deped.service.data.impl.ServiceQueryBuilderImpl;
import ph.gov.deped.web.entity.ReturnEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PSY on 2014/09/29.
 */
@RestController
@RequestMapping("/preview")
@ControllerAdvice
public class PreviewDataRestController {

    private DatasetService datasetService;

    @Autowired
    private TableService tableService;
    
    public @Autowired void setDatasetService(DatasetService datasetService) {
        this.datasetService = datasetService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE })
    public ReturnEntity<List<List<ColumnElement>>> preview(@RequestBody Dataset dataset) {
    	
  
    	try
    	{
    		dataset.setId(8L); //school prof history
    		if(dataset.getAggregateBy()!=null)
        	{
        		
        		ArrayList<Element> al= new ArrayList<Element>(dataset.getElements());
        		for(Element e:dataset.getAggregateBy().getElements())
        		{
        			e.setAggregate(AggregateTypes.GROUP.getAggregate());
        			al.add(e);
        		}
        		dataset.setElements(al);
        	}
    		System.out.println("NEW:"+new ServiceQueryBuilderImpl().getQuery(tableService.generateTable(dataset)));
            return new ReturnEntity<List<List<ColumnElement>>>("success", 0, datasetService.getData(dataset, true));
    	}
    	catch(Exception e)
    	{
    		return new ReturnEntity<List<List<ColumnElement>>>(e.getMessage(), 1, null);
    	}
    	
    	
    }
}
