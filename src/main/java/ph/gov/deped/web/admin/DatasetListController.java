package ph.gov.deped.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/datasets")
public class DatasetListController {

    public static final String DATASET_LIST_VIEW = "admin/dataset";

    @RequestMapping(method = RequestMethod.GET)
    public String list() {
        return DATASET_LIST_VIEW;
    }
}
