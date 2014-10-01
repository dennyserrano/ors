package ph.gov.deped.service.meta.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.common.command.RequestContext;
import ph.gov.deped.common.query.FromClauseBuilder;
import ph.gov.deped.common.query.JoinOrWhereClauseBuilder;
import ph.gov.deped.common.query.OnClauseBuilder;
import ph.gov.deped.common.query.Projection;
import ph.gov.deped.common.query.ProjectionBuilder;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.ors.ds.DatasetCorrelation;
import ph.gov.deped.data.ors.ds.DatasetCorrelationDtl;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.data.ors.meta.ColumnMetadata;
import ph.gov.deped.data.ors.meta.TableMetadata;
import ph.gov.deped.repo.jpa.ors.ds.CorrelationDtlRepository;
import ph.gov.deped.repo.jpa.ors.ds.CorrelationRepository;
import ph.gov.deped.repo.jpa.ors.ds.ElementRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;
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

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static ph.gov.deped.common.query.QueryBuilders.read;

/**
 * Created by ej on 8/20/14.
 */
public @Service class MetadataServiceImpl implements MetadataService {

    private static final Logger log = LogManager.getLogger(MetadataServiceImpl.class);

    private SynchronizeMetadataCommand synchronizeMetadataCommand;

    private FindAllDatasetsCommand findAllDatasetsCommand;

    private FindDatasetCommand findDatasetCommand;

    private DatasetRepository datasetRepository;

    private ElementRepository elementRepository;

    private TableMetadataRepository tableMetadataRepository;

    private ColumnMetadataRepository columnMetadataRepository;

    private CorrelationRepository correlationRepository;

    private CorrelationDtlRepository correlationDtlRepository;

    private DataSource dataSource;

    public @Autowired void setSynchronizeMetadataCommand(SynchronizeMetadataCommand synchronizeMetadataCommand) {
        this.synchronizeMetadataCommand = synchronizeMetadataCommand;
    }

    public @Autowired void setFindAllDatasetsCommand(FindAllDatasetsCommand findAllDatasetsCommand) {
        this.findAllDatasetsCommand = findAllDatasetsCommand;
    }

    public @Autowired void setFindDatasetCommand(FindDatasetCommand findDatasetCommand) {
        this.findDatasetCommand = findDatasetCommand;
    }

    public @Autowired void setDatasetRepository(DatasetRepository datasetRepository) {
        this.datasetRepository = datasetRepository;
    }

    public @Autowired void setElementRepository(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    public @Autowired void setTableMetadataRepository(TableMetadataRepository tableMetadataRepository) {
        this.tableMetadataRepository = tableMetadataRepository;
    }

    public @Autowired void setColumnMetadataRepository(ColumnMetadataRepository columnMetadataRepository) {
        this.columnMetadataRepository = columnMetadataRepository;
    }

    public @Autowired @Qualifier(AppMetadata.DS) void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
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

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<? extends Dataset> findTopLevelDatasets() {
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

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<Dataset> findOwnedDatasets(int ownerId) {
        List<DatasetHead> datasetHeads = datasetRepository.findByVisibleAndOwnerId(true, ownerId, new Sort(Sort.Direction.ASC, DatasetHead.NAME));
        return datasetHeads.parallelStream()
                .map(dh -> new Dataset(dh.getId(), dh.getName(), dh.getDescription(), dh.getParentDatasetHead()))
                .collect(toList());
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<Dataset> findNotOwnedDatasets(int ownerId) {
        List<DatasetHead> datasetHeads = datasetRepository.findByVisibleAndOwnerIdNot(true, ownerId, new Sort(Sort.Direction.ASC, DatasetHead.NAME));
        return datasetHeads.parallelStream()
                .map(dh -> new Dataset(dh.getId(), dh.getName(), dh.getDescription(), dh.getParentDatasetHead()))
                .collect(toList());
    }

    public @Transactional Dataset saveDataset(Dataset dataset) {

        return dataset;
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<Dataset> findSubdatasets(long headId)  {
        List<DatasetHead> subdatasets = datasetRepository.findByParentDatasetHead(headId);
        return subdatasets.parallelStream()
                .map(sd -> findDataset(sd.getId()))
                .collect(toList());
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<Element> findElements(long headId) {
        DatasetHead head = datasetRepository.findOne(headId);
        List<DatasetElement> datasetElements = elementRepository.findByDatasetHead(head);
        return datasetElements.parallelStream()
                .map(de -> new Element(de.getId(), de.getName(), de.getDescription(), de.getMeaning(), head.getId()))
                .collect(toList());
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<Map<String, Serializable>> previewData(Dataset dataset) {
        List<DatasetElement> elements = dataset.getElements().parallelStream()
                .map(Element::getId)
                .map(elementRepository::findOne)
                .collect(toList());
        ProjectionBuilder projectionBuilder = read();
        /**/

        List<ColumnMetadata> columns = elements.parallelStream()
                .map(de -> columnMetadataRepository.findOne(de.getColumnId()))
                .collect(toList());
        TableMetadata tableMetadata = tableMetadataRepository.findOne(columns.get(0).getTableId());
        projectionBuilder.select(new Projection("sy_from"));
        projectionBuilder.select(new Projection("school_id"));
        FromClauseBuilder fromClauseBuilder = columns.stream()
                .map(column -> new Projection(column.getColumnName()))
                .map(projectionBuilder::select)
                .reduce((f1, f2) -> f2).get();
        StringBuilder sql = fromClauseBuilder.from(tableMetadata.getTableName()).where("sy_from").eq(2013).build();
        sql.append(" LIMIT 20");
        log.debug("SQL: [{}]", sql);
        JdbcTemplate template = new JdbcTemplate(dataSource);
        List<Map<String, Serializable>> data = template.query(sql.toString(), (rs, rowNum) -> {
            ResultSetMetaData rsMeta = rs.getMetaData();
            int colCount = rsMeta.getColumnCount();
            Map<String, Serializable> row = new HashMap<>();
            String colName;
            Serializable value;
            for (int i = 1; i <= colCount; i++) {
                colName = rsMeta.getColumnName(i);
                value = (Serializable) rs.getObject(i);
                row.put(colName, value);
            }
            return row;
        });
        Map<String, Serializable> headers = new HashMap<>();
        dataset.getElements().forEach(de -> headers.put(de.getName(), de.getName()));
        headers.put("sy_from", "sy_from");
        headers.put("school_id", "school_id");
        data.add(0, headers);
        return data;
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<Map<String, Serializable>> preview(Dataset dataset) {
        List<DatasetElement> elements = dataset.getElements().parallelStream()
                .map(Element::getId)
                .map(elementRepository::findOne)
                .collect(toList());
        ProjectionBuilder projectionBuilder = read();
        Map<DatasetHead, List<DatasetElement>> map = new HashMap<>();
        elements.forEach(element -> {
            if (!map.containsKey(element.getDatasetHead())) {
                map.put(element.getDatasetHead(), new ArrayList<>());
            }
            map.get(element.getDatasetHead()).add(element);
        });
        Set<PrefixTable> tables = map.entrySet().stream()
                .map(entry -> {
                    PrefixTable p = new PrefixTable();
                    p.prefix = RandomStringUtils.randomAlphabetic(5);
                    p.tableMetadata = tableMetadataRepository.findOne(entry.getKey().getTableId());
                    p.datasetHead = entry.getKey();
                    elements.forEach(element -> {
                        ColumnMetadata cm = columnMetadataRepository.findOne(element.getColumnId());
                        ColumnElement ce = new ColumnElement();
                        ce.column = cm;
                        ce.element = element;
                        p.columns.add(ce);
                    });
                    return p;
                })
                .collect(toSet());
        FromClauseBuilder fromClauseBuilder = tables.stream()
                .map(pt ->
                    pt.columns.stream()
                            .map(ce -> new Projection(pt.prefix, ce.column, ce.element.getName()))
                            .map(projectionBuilder::select)
                            .reduce((p1, p2) -> p2)
                            .get()
                )
                .reduce((f1, f2) -> f2)
                .get();
        PrefixTable pt = tables.iterator().next();
        tables.iterator().remove();
        JoinOrWhereClauseBuilder join;
        if (tables.size() == 1) {
            join = fromClauseBuilder.from(pt.tableMetadata.getTableName());
        }
        else {
            PrefixTable leftTable = pt;
            DatasetCorrelation correlation;
            List<DatasetCorrelationDtl> correlationDetails;
            join = fromClauseBuilder.from(leftTable.tableMetadata, leftTable.prefix);
            OnClauseBuilder onClauseBuilder;
            for (PrefixTable rightTable : tables) {
                correlation = correlationRepository.findByLeftDatasetAndRightDataset(leftTable.datasetHead, rightTable.datasetHead);
                correlationDetails = correlationDtlRepository.findByDatasetCorrelation(correlation);
                switch (correlation.getJoinType()) {
                    case LEFT_JOIN:
                        onClauseBuilder = join.leftJoin(rightTable.tableMetadata, rightTable.prefix);
                        break;
                    case INNER_JOIN:
                        onClauseBuilder = join.innerJoin(rightTable.tableMetadata, rightTable.prefix);
                        break;
                    default: // Cross Join (comma separated joined tables)
                        onClauseBuilder = join.crossJoin(rightTable.tableMetadata, rightTable.prefix);
                }
                ColumnMetadata leftColumn;
                ColumnMetadata rightColumn;

                for (DatasetCorrelationDtl correlationDetail : correlationDetails) {
                    leftColumn = columnMetadataRepository.findOne(correlationDetail.getLeftColumnId());
                    rightColumn = columnMetadataRepository.findOne(correlationDetail.getRightColumnId());
                    onClauseBuilder.on(leftTable.prefix, leftColumn).eq(rightTable.prefix, rightColumn.getColumnName());
                }
                leftTable = rightTable;
            }
        }

        StringBuilder sql = new StringBuilder("KSJFKASDHF"); // TODO sql should came from the query builder above.
        JdbcTemplate template = new JdbcTemplate(dataSource);
        List<Map<String, Serializable>> data = template.query(sql.toString(), (rs, rowNum) -> {
            ResultSetMetaData rsMeta = rs.getMetaData();
            int colCount = rsMeta.getColumnCount();
            Map<String, Serializable> row = new HashMap<>();
            String colName;
            Serializable value;
            for (int i = 1; i <= colCount; i++) {
                colName = rsMeta.getColumnName(i);
                value = (Serializable) rs.getObject(i);
                row.put(colName, value);
            }
            return row;
        });
        return data;
    }

    private static class PrefixTable {
        protected String prefix;
        protected DatasetHead datasetHead;
        protected TableMetadata tableMetadata;
        protected List<ColumnElement> columns = new ArrayList<>();
    }

    private static class ColumnElement {
        protected DatasetElement element;
        protected ColumnMetadata column;
    }
}
