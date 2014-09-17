package ph.gov.deped.service.meta.api;

import ph.gov.deped.common.command.IRequest;
import ph.gov.deped.common.command.RequestContext;

import java.io.Serializable;

/**
 * Created by ej on 9/5/14.
 */
public class FindAllDatasetsRequest implements IRequest, Serializable {

    private static final long serialVersionUID = -3635099213177713528L;

    private final RequestContext requestContext;

    public FindAllDatasetsRequest(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    public RequestContext getRequestContext() {
        return requestContext;
    }
}
