package ph.gov.deped.web.dataset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ph.gov.deped.data.dto.KeyValue;
import ph.gov.deped.data.dto.ds.Criterion;
import ph.gov.deped.data.dto.ds.Filter;
import ph.gov.deped.service.data.api.CriteriaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PSY on 2014/10/03.
 */
@RestController
@RequestMapping("/criteria")
public class CriteriaRestController {

    private CriteriaService criteriaService;

    public @Autowired void setCriteriaService(CriteriaService criteriaService) {
        this.criteriaService = criteriaService;
    }

    @RequestMapping(value = "/{headId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
    public List<Criterion> getCriteria(@PathVariable("headId") long headId) {
        List<Criterion> l= criteriaService.findDatasetHeadCriteria(headId);
        return l;
    }
    
    @RequestMapping(value = "/school", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<KeyValue> searchSchoolName(@RequestBody List<Filter> filters) {
        Map<Long, String> map = new HashMap<>();
        filters.forEach(f -> {
                    String value = f.getSelectedOptions() == null || f.getSelectedOptions().isEmpty() ? "" : f.getSelectedOptions().get(0).getKey();
                    map.put(f.getCriterion(), value);
                });
        return criteriaService.searchSchools(map);
    }
}
