package ph.gov.deped.service.meta.api;

import ph.gov.deped.common.command.IResponse;
import ph.gov.deped.common.command.ResponseContext;

import java.io.Serializable;
import java.util.List;

import com.model.support.Dataset;

/**
 * Created by ej on 9/5/14.
 */
public class FindAllDatasetsResponse implements IResponse, Serializable {

    private static final long serialVersionUID = -1551006293042624877L;

    private final ResponseContext responseContext;

    private final List<Dataset> datasets;

    public FindAllDatasetsResponse(ResponseContext responseContext, List<Dataset> datasets) {
        this.responseContext = responseContext;
        this.datasets = datasets;
    }

    public ResponseContext getResponseContext() {
        return responseContext;
    }

    public List<Dataset> getDatasets() {
        return datasets;
    }
}
