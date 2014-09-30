package ph.gov.deped.service.meta.impl;

import com.google.common.base.CaseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.common.command.Command;
import ph.gov.deped.common.command.ICommand;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.ors.ds.DatasetElementRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetHeadRepository;
import ph.gov.deped.repo.jpa.ors.meta.TableMetadataRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ej on 9/5/14.
 */
public @Command class FindAllDatasetsCommand implements ICommand<FindAllDatasetsContext> {

    private DatasetHeadRepository datasetHeadRepository;

    private DatasetElementRepository datasetElementRepository;

    private TableMetadataRepository tableMetadataRepository;

    public @Autowired void setDatasetHeadRepository(DatasetHeadRepository datasetHeadRepository) {
        this.datasetHeadRepository = datasetHeadRepository;
    }

    public @Autowired void setDatasetElementRepository(DatasetElementRepository datasetElementRepository) {
        this.datasetElementRepository = datasetElementRepository;
    }

    public @Autowired void setTableMetadataRepository(TableMetadataRepository tableMetadataRepository) {
        this.tableMetadataRepository = tableMetadataRepository;
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) void execute(FindAllDatasetsContext context) {
        List<DatasetHead> datasetHeads = datasetHeadRepository.findByVisibleAndOwnerId(true, 1, new Sort(Sort.Direction.ASC, DatasetHead.NAME));
        List<Dataset> datasets = datasetHeads.parallelStream()
                .map(head -> {
                    List<Dataset> subDatasets = datasetHeadRepository.findByParentDatasetHead(head.getId())
                            .parallelStream()
                            .map(sd -> new Dataset(sd.getId(), sd.getName(), sd.getDescription(), sd.getParentDatasetHead()))
                            .collect(Collectors.toList());
                    List<Element> elements = datasetElementRepository.findByDatasetHead(head)
                            .parallelStream()
                            .map(dse -> new Element(dse.getId(), dse.getName(), dse.getDescription(), dse.getMeaning(), dse.getDatasetHead().getId()))
                            .collect(Collectors.toList());
                    return new Dataset(head.getId(), head.getName(), head.getDescription(), head.getParentDatasetHead(), subDatasets, elements);
                }).sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
        context.setDatasets(datasets);
        context.createResponse();
    }

    private String toName(String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName);
    }
}
