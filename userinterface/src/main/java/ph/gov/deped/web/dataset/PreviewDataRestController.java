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
import com.ejb.stateless.interfaces.QueueServiceBeanRemote;
import com.model.support.Dataset;
import com.model.support.Element;

import ph.gov.deped.data.dto.ColumnElement;
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

//    private DatasetService datasetService;
//
//    public @Autowired void setDatasetService(DatasetService datasetService) {
//        this.datasetService = datasetService;
//    }

//	@Autowired
//	private QueueServiceBeanRemote qsb;
	
    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE })
    public ReturnEntity<List<List<ColumnElement>>> preview(@RequestBody Dataset dataset) {
    	
//    	qsb.queue(dataset);
    	try
    	{
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
    		return null;
//            return new ReturnEntity<List<List<ColumnElement>>>("success", 0, datasetService.getData(dataset, true));
    	}
    	catch(Exception e)
    	{
    		return new ReturnEntity<List<List<ColumnElement>>>(e.getMessage(), 1, null);
    	}
    	
    	
    }
}
