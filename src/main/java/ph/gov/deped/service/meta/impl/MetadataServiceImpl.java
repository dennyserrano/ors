package ph.gov.deped.service.meta.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.common.command.RequestContext;
import ph.gov.deped.data.dto.ds.Column;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Table;
import ph.gov.deped.data.ors.meta.ColumnMetadata;
import ph.gov.deped.data.ors.meta.TableMetadata;
import ph.gov.deped.repo.jpa.ors.meta.ColumnMetadataRepository;
import ph.gov.deped.repo.jpa.ors.meta.TableMetadataRepository;
import ph.gov.deped.service.meta.api.FindAllDatasetsRequest;
import ph.gov.deped.service.meta.api.FindAllDatasetsResponse;
import ph.gov.deped.service.meta.api.FindDatasetRequest;
import ph.gov.deped.service.meta.api.FindDatasetResponse;
import ph.gov.deped.service.meta.api.MetadataService;
import ph.gov.deped.service.meta.api.MetadataSynchronizationException;
import ph.gov.deped.service.meta.api.SynchronizeMetadataContext;
import ph.gov.deped.service.meta.api.SynchronizeMetadataRequest;
import ph.gov.deped.service.meta.api.SynchronizeMetadataResponse;

/**
 * Created by ej on 8/20/14.
 */
public @Service class MetadataServiceImpl implements MetadataService {

    private static final Logger log = LogManager.getLogger(MetadataServiceImpl.class);

    private SynchronizeMetadataCommand synchronizeMetadataCommand;

    private FindAllDatasetsCommand findAllDatasetsCommand;

    private FindDatasetCommand findDatasetCommand;

    private TableMetadataRepository tableMetadataRepository;

    private ColumnMetadataRepository columnMetadataRepository;

    public @Autowired void setSynchronizeMetadataCommand(SynchronizeMetadataCommand synchronizeMetadataCommand) {
        this.synchronizeMetadataCommand = synchronizeMetadataCommand;
    }

    public @Autowired void setFindAllDatasetsCommand(FindAllDatasetsCommand findAllDatasetsCommand) {
        this.findAllDatasetsCommand = findAllDatasetsCommand;
    }

    public @Autowired void setFindDatasetCommand(FindDatasetCommand findDatasetCommand) {
        this.findDatasetCommand = findDatasetCommand;
    }

    public @Autowired void setTableMetadataRepository(TableMetadataRepository tableMetadataRepository) {
        this.tableMetadataRepository = tableMetadataRepository;
    }

    public @Autowired void setColumnMetadataRepository(ColumnMetadataRepository columnMetadataRepository) {
        this.columnMetadataRepository = columnMetadataRepository;
    }

    public @Transactional(AppMetadata.TXM) void startSynchronizing() throws MetadataSynchronizationException {
        log.entry();
        SynchronizeMetadataContext context = new SynchronizeMetadataContext(new SynchronizeMetadataRequest());
        synchronizeMetadataCommand.execute(context);
        SynchronizeMetadataResponse response = context.getResponse();
        if (!response.getResponseContext().successful()) {
            throw new MetadataSynchronizationException();
        }
        log.exit();
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<Table> findPhysicalDatasets() {
        log.entry();
        final List<Table> datasets = new ArrayList<>();
        List<TableMetadata> tableMetadatas = tableMetadataRepository.findAll();
        tableMetadatas.forEach(table -> {
            List<ColumnMetadata> columnMetadatas = columnMetadataRepository.findByTableId(table.getId());
            List<Column> columnDtos = columnMetadatas.parallelStream().map(c -> new Column(c.getId(), c.getColumnName(),
                    c.getColumnName(), c.getColumnName(), c.getColumnId(), c.getTableId())) .collect(Collectors.toList());
            Table physicalTable = new Table(table.getId(), table.getTableName(), table.getDescription(), table.getTableId());
            Table logicalTable = new Table(table.getId(), table.getTableName(), table.getDescription(), table.getTableId(),
                    new ArrayList<>(Arrays.asList(physicalTable)), columnDtos);
            datasets.add(logicalTable);
        });
        return log.exit(datasets);
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<? extends Dataset> findAllDatasets() {
        FindAllDatasetsRequest request = new FindAllDatasetsRequest(new RequestContext());
        FindAllDatasetsContext context = new FindAllDatasetsContext(request);
        findAllDatasetsCommand.execute(context);
        FindAllDatasetsResponse response = context.getResponse();
        return response.getDatasets();
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) Dataset findDataset(long id) {
        FindDatasetRequest request = new FindDatasetRequest(new RequestContext(), id);
        FindDatasetContext context = new FindDatasetContext(request);
        findDatasetCommand.execute(context);
        FindDatasetResponse response = context.getResponse();
        return response.getDataset();
    }

    public @Transactional Dataset saveDataset(Dataset dataset) {

        return dataset;
    }
}
