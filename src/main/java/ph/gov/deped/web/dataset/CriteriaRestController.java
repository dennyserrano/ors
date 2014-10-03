package ph.gov.deped.web.dataset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ph.gov.deped.data.dto.ds.Criterion;
import ph.gov.deped.service.data.api.CriteriaService;

import java.util.List;

/**
 * Created by PSY on 2014/10/03.
 */
@RestController
public class CriteriaRestController {

    private CriteriaService criteriaService;

    public @Autowired void setCriteriaService(CriteriaService criteriaService) {
        this.criteriaService = criteriaService;
    }

    @RequestMapping(value = "/criteria/{headId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
    public List<Criterion> getCriteria(@PathVariable("headId") long headId) {
        return criteriaService.findDatasetHeadCriteria(headId);
    }
}
