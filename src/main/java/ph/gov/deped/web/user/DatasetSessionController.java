package ph.gov.deped.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ph.gov.deped.data.dto.DatasetStore;
import ph.gov.deped.data.dto.JsonResponse;
import ph.gov.deped.data.dto.ds.Dataset;

import javax.servlet.http.HttpSession;

/**
 * @author ej
 * @since Oct 27, 2014 09:51
 */
@RestController
@RequestMapping("/user/dataset")
public class DatasetSessionController {
    
    private DatasetStore datasetStore;

    public @Autowired void setDatasetStore(DatasetStore datasetStore) {
        this.datasetStore = datasetStore;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Dataset get() {
        return datasetStore.getDataset();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public JsonResponse save(@RequestBody Dataset dataset, HttpSession httpSession) {
        datasetStore.setSessionId(httpSession.getId());
        datasetStore.setDataset(dataset);
        return new JsonResponse(httpSession.getId(), "SUCCESS", String.format("Saved to HTTP Session [%s]", httpSession.getId()));
    }
}
