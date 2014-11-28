package ph.gov.deped.service.data.api;

import ph.gov.deped.data.dto.KeyValue;
import ph.gov.deped.data.dto.ds.Criterion;

import java.util.List;
import java.util.Map;

/**
 * Created by PSY on 2014/10/03.
 */
public interface CriteriaService {

    List<Criterion> findDatasetHeadCriteria(long headId);

    List<KeyValue> searchSchools(Map<Long, String> filters);
}
