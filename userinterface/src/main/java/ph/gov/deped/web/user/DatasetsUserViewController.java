package ph.gov.deped.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by PSY on 2014/09/25.
 */
@Controller
@RequestMapping("/user/datasets")
public class DatasetsUserViewController {

    public static final String DATASETS_VIEW = "user/datasets";

    @RequestMapping(method = RequestMethod.GET)
    public String datasets(HttpServletRequest request, HttpSession httpSession) {
        if (httpSession != null && !httpSession.isNew()) {
            httpSession.invalidate();
        }
        request.getSession(true);
        return DATASETS_VIEW;
    }
}
