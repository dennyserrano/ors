package ph.gov.deped.service.meta.api;

import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Table;

import java.util.List;

/**
 * Created by ej on 8/20/14.
 */
public interface MetadataService {

    void startSynchronizing() throws MetadataSynchronizationException;

    List<Table> findPhysicalDatasets();

    List<? extends Dataset> findAllDatasets();

    Dataset findDataset(long id);

    Dataset saveDataset(Dataset dataset);
}
