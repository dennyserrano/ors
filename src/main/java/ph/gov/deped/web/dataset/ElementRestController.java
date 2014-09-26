package ph.gov.deped.web.dataset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.service.meta.api.MetadataService;

import java.util.List;

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
}
