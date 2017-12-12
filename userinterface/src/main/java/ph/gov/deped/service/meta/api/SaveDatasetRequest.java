package ph.gov.deped.service.meta.api;

import ph.gov.deped.common.command.IRequest;
import ph.gov.deped.common.command.RequestContext;
import ph.gov.deped.data.dto.ds.Dataset;

import java.io.Serializable;

/**
 * Created by ej on 9/9/14.
 */
public class SaveDatasetRequest implements IRequest, Serializable {

    private static final long serialVersionUID = -3440116273074170290L;

    private final RequestContext requestContext;

    private final Dataset dataset;

    public SaveDatasetRequest(RequestContext requestContext, Dataset dataset) {
        this.requestContext = requestContext;
        this.dataset = dataset;
    }

    public RequestContext getRequestContext() {
        return requestContext;
    }

    public Dataset getDataset() {
        return dataset;
    }
}
