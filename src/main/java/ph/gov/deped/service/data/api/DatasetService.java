package ph.gov.deped.service.data.api;

import ph.gov.deped.data.dto.ds.Dataset;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ej on 9/10/14.
 */
public interface DatasetService {

    List<List<Serializable>> getData(Dataset dataset, boolean previewOnly);
}
