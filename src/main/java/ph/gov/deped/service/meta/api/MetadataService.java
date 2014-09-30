package ph.gov.deped.service.meta.api;

import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by ej on 8/20/14.
 */
public interface MetadataService {

    void startSynchronizing() throws MetadataSynchronizationException;

    List<? extends Dataset> findTopLevelDatasets();

    List<Dataset> findOwnedDatasets(int ownerId);

    List<Dataset> findNotOwnedDatasets(int ownerId);

    Dataset findDataset(long id);

    Dataset saveDataset(Dataset dataset);

    List<Element> findElements(long headId);

    List<Dataset> findSubdatasets(long headId);

    List<Map<String, Serializable>> preview(Dataset dataset);
}
