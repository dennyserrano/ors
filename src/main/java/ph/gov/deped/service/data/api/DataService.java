package ph.gov.deped.service.data.api;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by ej on 9/10/14.
 */
public interface DataService {

    LinkedList<Map<String, Serializable>> getData(long datasetId);
}
