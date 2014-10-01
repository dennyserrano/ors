package ph.gov.deped.service.meta.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.common.command.Command;
import ph.gov.deped.common.command.ICommand;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.ors.ds.ElementRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;

/**
 * Created by ej on 9/9/14.
 */
public @Command class SaveDatasetCommand implements ICommand<SaveDatasetContext> {

    private DatasetRepository datasetRepository;

    private ElementRepository elementRepository;

    public @Autowired void setDatasetRepository(DatasetRepository datasetRepository) {
        this.datasetRepository = datasetRepository;
    }

    public @Autowired void setElementRepository(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    public @Transactional(value = AppMetadata.TXM) void execute(SaveDatasetContext context) {
        final Dataset dataset = context.getUpdatedDataset();
        DatasetHead head = datasetRepository.findOne(dataset.getId());
        if (head == null) {
            head = new DatasetHead();
        }
        head.setName(dataset.getName());
        head.setDescription(dataset.getDescription());
        head.setOwnerId(0);
        datasetRepository.save(head);
    }
}
