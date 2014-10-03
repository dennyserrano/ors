package ph.gov.deped.service.data.api;

import ph.gov.deped.data.dto.ds.Dataset;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by ej on 9/10/14.
 */
public interface DatasetService {

    List<Map<String, Serializable>> getData(Dataset dataset);
}
