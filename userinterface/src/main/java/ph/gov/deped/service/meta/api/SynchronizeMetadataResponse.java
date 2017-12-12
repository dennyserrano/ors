package ph.gov.deped.service.meta.api;

import ph.gov.deped.common.command.IResponse;
import ph.gov.deped.common.command.ResponseContext;

/**
 * Created by ej on 8/20/14.
 */
public class SynchronizeMetadataResponse implements IResponse {

    private static final long serialVersionUID = -3247420393032638992L;

    private final ResponseContext responseContext;

    public SynchronizeMetadataResponse(boolean success) {
        this.responseContext = new ResponseContext(success);
    }

    public ResponseContext getResponseContext() {
        return this.responseContext;
    }
}
