package ph.gov.deped.web.dataset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.service.meta.api.MetadataService;

import java.util.List;

/**
 * Created by ej on 9/5/14.
 */
@RestController
@RequestMapping("/dataset")
public class DatasetRestController {

    private static final String DATASET_ID = "id";

    private @Autowired MetadataService metadataService;

    @SuppressWarnings({"unchecked"})
    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Dataset> findAvailableDatasets() {
        List<? extends Dataset> datasets = metadataService.findTopLevelDatasets();
        return (List<Dataset>) datasets;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public Dataset findDataset(@PathVariable(DATASET_ID) long id) {
        return metadataService.findDataset(id);
    }

    @RequestMapping(value = "/{id}/sub", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Dataset> findSubdatasets(@PathVariable(DATASET_ID) long headId) {
        return metadataService.findSubdatasets(headId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    public Dataset saveDataset(@PathVariable(DATASET_ID) long id, @RequestBody Dataset dataset) {

        return dataset;
    }

    @RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    public Dataset saveDataset(@RequestBody Dataset dataset) {

        return dataset;
    }

    @RequestMapping(value = "/{id}/data", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public Object loadDataset(@PathVariable(DATASET_ID) long id) {

        return null;
    }
}
