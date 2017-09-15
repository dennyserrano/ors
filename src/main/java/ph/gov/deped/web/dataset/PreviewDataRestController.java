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
import ph.gov.deped.common.util.builders.impl.ColumnExpression;
import ph.gov.deped.common.util.builders.impl.PrefixTable;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.service.data.api.DatasetService;
import ph.gov.deped.service.data.api.TableService;
import ph.gov.deped.service.data.impl.ServiceQueryBuilderImpl;
import ph.gov.deped.service.data.impl.SqlToData;
import ph.gov.deped.web.entity.ReturnEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    
    @Autowired
    private SqlToData std;
    
    public @Autowired void setDatasetService(DatasetService datasetService) {
        this.datasetService = datasetService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE })
    public ReturnEntity<List<List<ColumnElement>>> preview(@RequestBody Dataset dataset) {
    	
  
    	try
    	{
    		dataset.setId(8L); //school prof history

    		PrefixTable pt=tableService.generateTable(dataset);
    		String sql=new ServiceQueryBuilderImpl().getQuery(pt);
    		System.out.println("SQL:"+sql);
    		sql=sql.concat(" LIMIT 20 ");
    		List collected=collect(new ArrayList<ColumnExpression>(),pt);
    		List l=std.get(sql,collected);
            return new ReturnEntity<List<List<ColumnElement>>>("success", 0, l);
    	}
    	catch(Exception e)
    	{
    		return new ReturnEntity<List<List<ColumnElement>>>(e.getMessage(), 1, null);
    	}
    	
    	
    }
    
    private List<ColumnExpression> collect(List<ColumnExpression> l,PrefixTable pt)
	{
		for(ColumnExpression ce:pt.getColumns())
			l.add(ce);
		
		for(PrefixTable subPT:pt.getJoinTables().keySet())
			collect(l,subPT);
		
		return l;
	}
}
