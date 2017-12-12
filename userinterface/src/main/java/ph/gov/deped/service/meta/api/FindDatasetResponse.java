package ph.gov.deped.service.meta.api;

import ph.gov.deped.common.command.IResponse;
import ph.gov.deped.common.command.ResponseContext;

import java.io.Serializable;

import com.model.support.Dataset;

/**
 * Created by ej on 9/5/14.
 */
public class FindDatasetResponse implements IResponse, Serializable {

    private static final long serialVersionUID = 9089262448822743087L;

    private final ResponseContext responseContext;

    private final Dataset dataset;

    public FindDatasetResponse(ResponseContext responseContext, Dataset dataset) {
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
