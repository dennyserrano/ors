package ph.gov.deped.service.meta.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ph.gov.deped.common.command.Command;
import ph.gov.deped.common.command.ICommand;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.data.ors.ds.DatasetTable;
import ph.gov.deped.repo.jpa.ors.ds.DatasetElementRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetHeadRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetTableRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ej on 9/5/14.
 */
public @Command class FindDatasetCommand implements ICommand<FindDatasetContext> {

    private @Autowired DatasetHeadRepository datasetHeadRepository;

    private @Autowired DatasetTableRepository datasetTableRepository;

    private @Autowired DatasetElementRepository datasetElementRepository;

    public void execute(FindDatasetContext context) {
        final long id = context.getRequest().getId();
        DatasetHead head = datasetHeadRepository.findOne(id);
        List<DatasetTable> datasetTables = datasetTableRepository.findByDatasetHead(head);
        List<DatasetElement> datasetElements = datasetTables.parallelStream()
                .map(datasetElementRepository::findByDatasetTable)
                .flatMap(es -> es.parallelStream())
                .collect(Collectors.toList());

        List<Dataset> subDatasets = datasetTables.parallelStream()
                .filter(t -> t.getDerivedFrom() != null)
                .map(DatasetTable::getDerivedFrom)
                .map(datasetHeadRepository::findOne)
                .map(h -> new Dataset(h.getId(), h.getName(), h.getDescription(), h.getTableName()))
                .collect(Collectors.toList());

        List<Element> elements = datasetElements.parallelStream()
                .map(de -> new Element(de.getId(), de.getName(), de.getDescription(), de.getMeaning(), head.getId()))
                .collect(Collectors.toList());

        context.setDataset(new Dataset(head.getId(), head.getName(), head.getDescription(), head.getTableName(), subDatasets, elements));
        context.createResponse();
    }
}
