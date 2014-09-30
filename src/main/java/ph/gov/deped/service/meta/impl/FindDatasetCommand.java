package ph.gov.deped.service.meta.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ph.gov.deped.common.command.Command;
import ph.gov.deped.common.command.ICommand;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.ors.ds.DatasetElementRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetHeadRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ej on 9/5/14.
 */
public @Command class FindDatasetCommand implements ICommand<FindDatasetContext> {

    private DatasetHeadRepository datasetHeadRepository;

    private DatasetElementRepository datasetElementRepository;

    public @Autowired void setDatasetHeadRepository(DatasetHeadRepository datasetHeadRepository) {
        this.datasetHeadRepository = datasetHeadRepository;
    }

    public @Autowired void setDatasetElementRepository(DatasetElementRepository datasetElementRepository) {
        this.datasetElementRepository = datasetElementRepository;
    }

    public void execute(FindDatasetContext context) {
        final long id = context.getRequest().getId();
        DatasetHead head = datasetHeadRepository.findOne(id);
        List<DatasetElement> datasetElements = datasetElementRepository.findByDatasetHead(head);

        List<Dataset> subDatasets = datasetHeadRepository.findByParentDatasetHead(head.getId())
                .parallelStream()
                .map(dh -> new Dataset(dh.getId(), dh.getName(), dh.getDescription(), head.getId()))
                .collect(Collectors.toList());

        List<Element> elements = datasetElements.parallelStream()
                .map(de -> new Element(de.getId(), de.getName(), de.getDescription(), de.getMeaning(), head.getId()))
                .collect(Collectors.toList());

        context.setDataset(new Dataset(head.getId(), head.getName(), head.getDescription(), head.getParentDatasetHead(), subDatasets, elements));
        context.createResponse();
    }
}
