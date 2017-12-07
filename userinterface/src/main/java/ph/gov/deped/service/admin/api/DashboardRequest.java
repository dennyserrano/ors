package ph.gov.deped.service.admin.api;

import java.io.Serializable;

import ph.gov.deped.common.command.IRequest;
import ph.gov.deped.common.command.RequestContext;

public class DashboardRequest implements IRequest, Serializable {

    private static final long serialVersionUID = -7618602343540398542L;
    
    private final RequestContext requestContext;
    
    public DashboardRequest(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    public RequestContext getRequestContext() {
        return requestContext;
    }
}
