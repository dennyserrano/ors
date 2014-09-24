package ph.gov.deped.service.meta.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.common.command.Command;
import ph.gov.deped.common.command.ICommand;
import ph.gov.deped.common.dw.DbType;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.dto.ds.Table;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.data.ors.ds.DatasetTable;
import ph.gov.deped.data.ors.meta.TableMetadata;
import ph.gov.deped.repo.jpa.ors.ds.DatasetElementRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetHeadRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetTableRepository;
import ph.gov.deped.repo.jpa.ors.meta.TableMetadataRepository;

import com.google.common.base.CaseFormat;

/**
 * Created by ej on 9/5/14.
 */
public @Command class FindAllDatasetsCommand implements ICommand<FindAllDatasetsContext> {

    private DatasetHeadRepository datasetHeadRepository;

    private DatasetTableRepository datasetTableRepository;

    private DatasetElementRepository datasetElementRepository;

    private TableMetadataRepository tableMetadataRepository;

    public @Autowired void setDatasetHeadRepository(DatasetHeadRepository datasetHeadRepository) {
        this.datasetHeadRepository = datasetHeadRepository;
    }

    public @Autowired void setDatasetTableRepository(DatasetTableRepository datasetTableRepository) {
        this.datasetTableRepository = datasetTableRepository;
    }

    public @Autowired void setDatasetElementRepository(DatasetElementRepository datasetElementRepository) {
        this.datasetElementRepository = datasetElementRepository;
    }

    public @Autowired void setTableMetadataRepository(TableMetadataRepository tableMetadataRepository) {
        this.tableMetadataRepository = tableMetadataRepository;
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) void execute(FindAllDatasetsContext context) {
        List<DatasetHead> datasetHeads = datasetHeadRepository.findAll(new Sort(Sort.Direction.ASC, DatasetHead.NAME));
        List<Dataset> datasets = datasetHeads.parallelStream()
                .map(head -> {
                    List<DatasetTable> datasetTables = datasetTableRepository.findByDatasetHead(head);
                    List<Dataset> subDatasets = datasetTables.parallelStream()
                            .filter(t -> t.getDerivedFrom() != null)
                            .map(DatasetTable::getDerivedFrom)
                            .map(datasetHeadRepository::findOne)
                            .map(sd -> new Dataset(sd.getId(), sd.getName(), sd.getDescription()))
                            .collect(Collectors.toList());
                    List<Element> elements = datasetTables.parallelStream()
                            .map(datasetElementRepository::findByDatasetTable)
                            .flatMap(foundElements -> foundElements.parallelStream())
                            .map(dse -> new Element(dse.getId(), dse.getName(), dse.getDescription(), dse.getMeaning(), dse.getDatasetTable().getDatasetHead().getId()))
                            .collect(Collectors.toList());
                    Dataset dataset;
                    if (datasetTables.size() == 1 && datasetTables.get(0).getTableId() != null) { // Physical Table case
                        TableMetadata physicalTable = tableMetadataRepository.findOne(datasetTables.get(0).getTableId());
                        dataset = new Table(head.getId(), toName(head.getName())    , head.getDescription(), datasetTables.get(0).getTableId(), subDatasets, elements);
                        int dbId = physicalTable.getDbId();
                        DbType dbType = DbType.values()[dbId];
                        ((Table) dataset).setDbType(dbType);
                    }
                    else {
                        dataset = new Dataset(head.getId(), head.getName(), head.getDescription(), subDatasets, elements);
                    }
                    return dataset;
                }).sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
        context.setDatasets(datasets);
        context.createResponse();
    }

    private String toName(String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName);
    }
}
