package ph.gov.deped.service.meta.impl;

import ph.gov.deped.common.command.AbstractContext;
import ph.gov.deped.common.command.ResponseContext;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.service.meta.api.FindDatasetRequest;
import ph.gov.deped.service.meta.api.FindDatasetResponse;

/**
 * Created by ej on 9/5/14.
 */
public class FindDatasetContext extends AbstractContext<FindDatasetRequest, FindDatasetResponse> {

    private static final long serialVersionUID = 4050675615531988996L;
    
    private Dataset dataset;

    public FindDatasetContext(FindDatasetRequest request) {
        super(request);
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    public void createResponse() {
        response = new FindDatasetResponse(new ResponseContext(true), dataset);
    }
}
