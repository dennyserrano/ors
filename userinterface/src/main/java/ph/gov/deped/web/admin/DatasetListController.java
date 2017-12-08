package ph.gov.deped.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/datasets")
public class DatasetListController {

    public static final String DATASET_LIST_VIEW = "admin/dataset";

    public static final String DATASET_FORM_VIEW = "admin/datasetForm";

    @RequestMapping(method = RequestMethod.GET)
    public String list() {
        return DATASET_LIST_VIEW;
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String create() {
        return DATASET_FORM_VIEW;
    }

    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id) {
        return DATASET_FORM_VIEW;
    }
}
