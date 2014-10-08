package ph.gov.deped.service.meta.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.common.command.Command;
import ph.gov.deped.common.command.ICommand;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;
import ph.gov.deped.repo.jpa.ors.ds.ElementRepository;

/**
 * Created by ej on 9/5/14.
 */
public @Command class FindAllDatasetsCommand implements ICommand<FindAllDatasetsContext> {

    private DatasetRepository datasetRepository;

    private ElementRepository elementRepository;

    public @Autowired void setDatasetRepository(DatasetRepository datasetRepository) {
        this.datasetRepository = datasetRepository;
    }

    public @Autowired void setElementRepository(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) void execute(FindAllDatasetsContext context) {
        List<DatasetHead> datasetHeads = datasetRepository.findByVisibleAndOwnerId(true, 1, new Sort(Sort.Direction.ASC, DatasetHead.RANKING));
        datasetHeads.sort((h1, h2) -> h1.compareTo(h2));
        List<Dataset> datasets = datasetHeads.stream()
                .map(head -> {
                    List<Dataset> subDatasets = datasetRepository.findByParentDatasetHeadAndVisible(head.getId(), true)
                            .parallelStream()
                            .map(sd -> new Dataset(sd.getId(), sd.getName(), sd.getDescription(), sd.getParentDatasetHead()))
                            .collect(Collectors.toList());
                    List<Element> elements = elementRepository.findByDatasetHead(head)
                            .parallelStream()
                            .map(dse -> new Element(dse.getId(), dse.getName(), dse.getDescription(), dse.getMeaning(), dse.getDatasetHead().getId()))
                            .collect(Collectors.toList());
                    return new Dataset(head.getId(), head.getName(), head.getDescription(), head.getParentDatasetHead(), subDatasets, elements);
                }).collect(Collectors.toCollection(LinkedList::new));
        context.setDatasets(datasets);
        context.createResponse();
    }
}
