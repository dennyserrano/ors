package ph.gov.deped.service.meta.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.common.command.Command;
import ph.gov.deped.common.command.ICommand;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.ors.ds.DatasetElementRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetHeadRepository;

/**
 * Created by ej on 9/9/14.
 */
public @Command class SaveDatasetCommand implements ICommand<SaveDatasetContext> {

    private DatasetHeadRepository datasetHeadRepository;

    private DatasetElementRepository datasetElementRepository;

    public @Autowired void setDatasetHeadRepository(DatasetHeadRepository datasetHeadRepository) {
        this.datasetHeadRepository = datasetHeadRepository;
    }

    public @Autowired void setDatasetElementRepository(DatasetElementRepository datasetElementRepository) {
        this.datasetElementRepository = datasetElementRepository;
    }

    public @Transactional(value = AppMetadata.TXM) void execute(SaveDatasetContext context) {
        final Dataset dataset = context.getUpdatedDataset();
        DatasetHead head = datasetHeadRepository.findOne(dataset.getId());
        if (head == null) {
            head = new DatasetHead();
        }
        head.setName(dataset.getName());
        head.setDescription(dataset.getDescription());
        head.setOwnerId(0);
        datasetHeadRepository.save(head);
    }
}
