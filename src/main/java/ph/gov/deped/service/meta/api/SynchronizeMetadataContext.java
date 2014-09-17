package ph.gov.deped.service.meta.api;

import ph.gov.deped.common.command.AbstractContext;

/**
 * Created by ej on 8/20/14.
 */
public class SynchronizeMetadataContext extends AbstractContext<SynchronizeMetadataRequest, SynchronizeMetadataResponse> {

    private static final long serialVersionUID = -8818333786903088925L;

    private boolean success;

    public SynchronizeMetadataContext(SynchronizeMetadataRequest request) {
        super(request);
    }

    public SynchronizeMetadataContext success() {
        this.success = true;
        return this;
    }

    public void createResponse() {
        response = new SynchronizeMetadataResponse(success);
    }
}
