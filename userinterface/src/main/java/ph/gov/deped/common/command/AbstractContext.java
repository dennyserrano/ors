package ph.gov.deped.common.command;

/**
 * Created by ej on 8/20/14.
 */
public abstract class AbstractContext<REQ extends IRequest, RES extends IResponse> implements IContext<REQ, RES> {

    private static final long serialVersionUID = 5524844296296346253L;

    private final REQ request;

    protected RES response;

    public AbstractContext(REQ request) {
        this.request = request;
    }

    public REQ getRequest() {
        return request;
    }

    public RES getResponse() {
        return this.response;
    }

    public abstract void createResponse();
}
