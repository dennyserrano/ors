package ph.gov.deped.service.meta.api;

import ph.gov.deped.common.command.IRequest;
import ph.gov.deped.common.command.RequestContext;

import java.io.Serializable;

/**
 * Created by ej on 9/5/14.
 */
public class FindDatasetRequest implements IRequest, Serializable {

    private static final long serialVersionUID = 2692710305060843074L;

    private final RequestContext requestContext;

    private final long id;

    public FindDatasetRequest(RequestContext requestContext, long id) {
        this.requestContext = requestContext;
        this.id = id;
    }

    public RequestContext getRequestContext() {
        return requestContext;
    }

    public long getId() {
        return id;
    }
}
