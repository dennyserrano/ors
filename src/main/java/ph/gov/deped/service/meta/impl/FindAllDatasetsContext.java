package ph.gov.deped.service.meta.impl;

import ph.gov.deped.common.command.AbstractContext;
import ph.gov.deped.common.command.ResponseContext;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.service.meta.api.FindAllDatasetsRequest;
import ph.gov.deped.service.meta.api.FindAllDatasetsResponse;

import java.util.List;

/**
 * Created by ej on 9/5/14.
 */
public class FindAllDatasetsContext extends AbstractContext<FindAllDatasetsRequest, FindAllDatasetsResponse> {

    private static final long serialVersionUID = -7239062682604852172L;

    private List<Dataset> datasets;

    public FindAllDatasetsContext(FindAllDatasetsRequest request) {
        super(request);
    }

    public void setDatasets(List<Dataset> datasets) {
        this.datasets = datasets;
    }

    public void createResponse() {
        response = new FindAllDatasetsResponse(new ResponseContext(true), datasets);
    }
}
