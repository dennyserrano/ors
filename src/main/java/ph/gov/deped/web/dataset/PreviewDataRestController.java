package ph.gov.deped.web.dataset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bits.sql.AggregateTypes;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.service.data.api.DatasetService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PSY on 2014/09/29.
 */
@RestController
@RequestMapping("/preview")
public class PreviewDataRestController {

    private DatasetService datasetService;

    public @Autowired void setDatasetService(DatasetService datasetService) {
        this.datasetService = datasetService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE })
    public List<List<ColumnElement>> preview(@RequestBody Dataset dataset) {
    	if(!dataset.getAggregateBy().getElements().isEmpty())
    	{
    		ArrayList<Element> al= new ArrayList<Element>(dataset.getElements());
    		for(Element e:dataset.getAggregateBy().getElements())
    		{
    			e.setAggregate(AggregateTypes.GROUP.getAggregate());
    			al.add(e);
    		}
    		dataset.setElements(al);
    	}
        return datasetService.getData(dataset, true);
    }
}
