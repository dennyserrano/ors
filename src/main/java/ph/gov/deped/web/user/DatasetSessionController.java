package ph.gov.deped.web.user;

import org.springframework.web.bind.annotation.*;
import ph.gov.deped.data.dto.JsonResponse;
import ph.gov.deped.data.dto.ds.Dataset;

import javax.servlet.http.HttpSession;

/**
 * @author ej
 * @since Oct 27, 2014 09:51
 */
@RestController
@RequestMapping("/user/dataset")
@SessionAttributes(value = { Dataset.ATTR_NAME }, types = { Dataset.class })
public class DatasetSessionController {
    
    @RequestMapping(method = RequestMethod.GET)
    public Dataset get(HttpSession httpSession) {
        return (Dataset) httpSession.getAttribute(Dataset.ATTR_NAME);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public JsonResponse save(@RequestBody Dataset dataset, HttpSession httpSession) {
        httpSession.setAttribute(Dataset.ATTR_NAME, dataset);
        return new JsonResponse(httpSession.getId(), "SUCCESS", "Saved to HTTP Session");
    }
}
