package ph.gov.deped.service.meta.api;

import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.dto.ds.Table;

import java.util.List;

/**
 * Created by ej on 8/20/14.
 */
public interface MetadataService {

    void startSynchronizing() throws MetadataSynchronizationException;

    List<Table> findPhysicalDatasets();

    List<? extends Dataset> findTopLevelDatasets();

    List<Dataset> findOwnedDatasets(int ownerId);

    List<Dataset> findNotOwnedDatasets(int ownerId);

    Dataset findDataset(long id);

    Dataset saveDataset(Dataset dataset);

    List<Element> findSubdatasetElement(long tableId);

    List<Element> findElements(long headId);

    List<Dataset> findSubdatasets(long headId);
}
