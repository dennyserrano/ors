package ph.gov.deped.service.meta.api;

import ph.gov.deped.common.command.IResponse;
import ph.gov.deped.common.command.ResponseContext;
import ph.gov.deped.data.dto.ds.Dataset;

import java.io.Serializable;

/**
 * Created by ej on 9/9/14.
 */
public class SaveDatasetResponse implements IResponse, Serializable {

    private static final long serialVersionUID = -4024239652866211148L;

    private final ResponseContext responseContext;

    private final Dataset dataset;

    public SaveDatasetResponse(ResponseContext responseContext, Dataset dataset) {
        this.responseContext = responseContext;
        this.dataset = dataset;
    }

    public ResponseContext getResponseContext() {
        return responseContext;
    }

    public Dataset getDataset() {
        return dataset;
    }
}
