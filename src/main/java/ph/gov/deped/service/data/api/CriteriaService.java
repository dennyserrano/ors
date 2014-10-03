package ph.gov.deped.service.data.api;

import ph.gov.deped.data.dto.ds.Criterion;

import java.util.List;

/**
 * Created by PSY on 2014/10/03.
 */
public interface CriteriaService {

    List<Criterion> findDatasetHeadCriteria(long headId);
}
