package ph.gov.deped.web.dataset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ph.gov.deped.data.dto.ElementsTable;
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
    public ElementsTable elements(HttpSession httpSession) {
        Dataset dataset = (Dataset) httpSession.getAttribute(Dataset.ATTR_NAME);
        ElementsTable table = new ElementsTable();
        dataset.getSubDatasets().stream().forEach(table::addDataset);
        int largestNumber = dataset.getSubDatasets().parallelStream()
                .map(Dataset::getElements)
                .mapToInt(List::size)
                .max().getAsInt();
        List<Map<Long, Element>> elements = new ArrayList<>();
        for (int i = 0; i < largestNumber; i++) {
            int idx = i;
            Map<Long, Element> row = new HashMap<>();
            dataset.getSubDatasets().stream()
                    .filter(d -> idx < d.getElements().size())
                    .map(d -> d.getElements())
                    .map(es -> es.get(idx))
                    .forEach(e -> row.put(e.getDatasetId(), e));
            elements.add(i, row);
        }
        table.setElements(elements);
        return table;
    }
}
