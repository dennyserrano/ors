package ph.gov.deped.web.dataset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.service.meta.api.MetadataService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PSY on 2014/09/25.
 */
@RestController
@RequestMapping("/elements")
public class ElementRestController {

    private MetadataService metadataService;

    public @Autowired void setMetadataService(MetadataService metadataService) {
        this.metadataService = metadataService;
    }

    @RequestMapping(value = "/{headId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Element> findElementsOfHead(@PathVariable("headId") long headId) {
        return metadataService.findElements(headId);
    }
    
    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public Map<Dataset, Map<Long, Element>> renderElements(HttpSession httpSession) {
        Map<Dataset, Map<Long, Element>> table = new HashMap<>();
        Dataset dataset = (Dataset) httpSession.getAttribute(Dataset.ATTR_NAME);
        dataset.getSubDatasets().stream()
            .map(d -> { // initialize the container for each row
                Map<Long, Element> row = table.get(d);
                if (row == null) {
                    table.put(d, (row = new HashMap<>()));
                }
                return d;
            })
            .forEach(d -> {
                Map<Long, Element> row = table.get(d);
                d.getElements().forEach(e -> row.put(e.getDatasetId(), e));
            });
        return table;
    }
}
