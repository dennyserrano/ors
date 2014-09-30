package ph.gov.deped.web.dataset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.service.meta.api.MetadataService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by PSY on 2014/09/29.
 */
@RestController
@RequestMapping("/preview")
public class PreviewDataRestController {

    private MetadataService metadataService;

    public @Autowired void setMetadataService(MetadataService metadataService) {
        this.metadataService = metadataService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE })
    public List<Map<String, Serializable>> preview(@RequestBody Dataset dataset) {
        return metadataService.preview(dataset);
    }
}
