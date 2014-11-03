package ph.gov.deped.web.user;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ph.gov.deped.data.dto.JsonResponse;
import ph.gov.deped.data.dto.ds.Dataset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ej
 * @since Oct 27, 2014 09:51
 */
@RestController
@RequestMapping("/user/dataset")
public class DatasetSessionController {
    
    @RequestMapping(method = RequestMethod.GET)
    public Dataset get(HttpSession httpSession) {
        return (Dataset) httpSession.getAttribute(Dataset.ATTR_NAME);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public JsonResponse save(@RequestBody Dataset dataset, HttpServletRequest request, HttpSession httpSession) {
        if (httpSession == null) {
            httpSession = request.getSession(true);
        }
        httpSession.setAttribute(Dataset.ATTR_NAME, dataset);
        return new JsonResponse(httpSession.getId(), "SUCCESS", String.format("Saved to HTTP Session [%s]", httpSession.getId()));
    }
}
