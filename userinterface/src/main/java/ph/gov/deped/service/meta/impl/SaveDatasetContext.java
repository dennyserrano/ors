package ph.gov.deped.service.meta.impl;

import ph.gov.deped.common.command.AbstractContext;
import ph.gov.deped.common.command.ResponseContext;
import ph.gov.deped.service.meta.api.SaveDatasetRequest;
import ph.gov.deped.service.meta.api.SaveDatasetResponse;

import java.io.Serializable;

import com.model.support.Dataset;

/**
 * Created by ej on 9/9/14.
 */
public class SaveDatasetContext extends AbstractContext<SaveDatasetRequest, SaveDatasetResponse> implements Serializable {

    private static final long serialVersionUID = -3445024822066766969L;

    private Dataset updatedDataset;

    public SaveDatasetContext(SaveDatasetRequest request) {
        super(request);
    }

    public Dataset getUpdatedDataset() {
        return updatedDataset;
    }

    public void setUpdatedDataset(Dataset updatedDataset) {
        this.updatedDataset = updatedDataset;
    }

    public void createResponse() {
        response = new SaveDatasetResponse(new ResponseContext(true), updatedDataset);
    }
}
