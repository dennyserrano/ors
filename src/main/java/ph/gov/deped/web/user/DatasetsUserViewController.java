package ph.gov.deped.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by PSY on 2014/09/25.
 */
@Controller
@RequestMapping("/user/datasets")
public class DatasetsUserViewController {

    public static final String DATASETS_VIEW = "user/datasets";

    @RequestMapping(method = RequestMethod.GET)
    public String datasets() {
        return DATASETS_VIEW;
    }
}
