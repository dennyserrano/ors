package ph.gov.deped.service.meta.api;

import ph.gov.deped.common.command.IRequest;
import ph.gov.deped.common.command.RequestContext;

/**
 * Created by ej on 8/20/14.
 */
public class SynchronizeMetadataRequest implements IRequest {

    private static final long serialVersionUID = 5301908870071977276L;

    private final RequestContext requestContext = new RequestContext();

    public RequestContext getRequestContext() {
        return requestContext;
    }
}
