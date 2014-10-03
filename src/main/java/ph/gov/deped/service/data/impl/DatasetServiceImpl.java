package ph.gov.deped.service.data.impl;

import com.bits.sql.FromClauseBuilder;
import com.bits.sql.JoinOrWhereClauseBuilder;
import com.bits.sql.OnClauseBuilder;
import com.bits.sql.Projection;
import com.bits.sql.ProjectionBuilder;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ph.gov.deped.common.AppMetadata;
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
import ph.gov.deped.repo.jpa.ors.ds.CriteriaRepository;
import ph.gov.deped.repo.jpa.ors.ds.ElementRepository;
import ph.gov.deped.repo.jpa.ors.meta.ColumnMetadataRepository;
import ph.gov.deped.repo.jpa.ors.meta.TableMetadataRepository;
import ph.gov.deped.service.data.api.DatasetService;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.bits.sql.QueryBuilders.read;
import static java.util.stream.Collectors.toList;

/**
 * Created by ej on 9/10/14.
 */
public @Service class DatasetServiceImpl implements DatasetService {

    private TableMetadataRepository tableMetadataRepository;

    private ColumnMetadataRepository columnMetadataRepository;

    private ElementRepository elementRepository;

    private CorrelationRepository correlationRepository;

    private CorrelationDtlRepository correlationDtlRepository;

    private CriteriaRepository criteriaRepository;

    private DataSource dataSource;

    public @Autowired void setTableMetadataRepository(TableMetadataRepository tableMetadataRepository) {
        this.tableMetadataRepository = tableMetadataRepository;
    }

    public @Autowired void setColumnMetadataRepository(ColumnMetadataRepository columnMetadataRepository) {
        this.columnMetadataRepository = columnMetadataRepository;
    }

    public @Autowired void setElementRepository(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    public @Autowired void setCorrelationRepository(CorrelationRepository correlationRepository) {
        this.correlationRepository = correlationRepository;
    }

    public @Autowired void setCorrelationDtlRepository(CorrelationDtlRepository correlationDtlRepository) {
        this.correlationDtlRepository = correlationDtlRepository;
    }

    public @Autowired void setCriteriaRepository(CriteriaRepository criteriaRepository) {
        this.criteriaRepository = criteriaRepository;
    }

    public @Autowired @Qualifier(AppMetadata.DS) void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<Map<String, Serializable>> getData(Dataset dataset) {
        List<DatasetElement> elements = dataset.getElements().parallelStream()
                .map(Element::getId)
                .map(elementRepository::findOne)
                .collect(toList());

        Map<DatasetHead, List<DatasetElement>> map = new HashMap<>();
        elements.forEach(element -> {
            if (!map.containsKey(element.getDatasetHead())) {
                map.put(element.getDatasetHead(), new ArrayList<>());
            }
            map.get(element.getDatasetHead()).add(element);
        });
        List<PrefixTable> tables = map.entrySet().stream()
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
                .collect(toList());
        ProjectionBuilder projectionBuilder = read();
        FromClauseBuilder fromClauseBuilder = tables.stream()
                .map(pt ->
                    pt.columns.stream()
                            .map(ce -> new Projection(pt.prefix, ce.column.getColumnName(), ce.element.getName()))
                            .map(projectionBuilder::select)
                            .reduce((p1, p2) -> p2)
                            .get()
                )
                .reduce((f1, f2) -> f2)
                .get();
        PrefixTable pt = tables.get(0);
        JoinOrWhereClauseBuilder join;
        if (tables.size() == 1) {
            join = fromClauseBuilder.from(pt.tableMetadata.getTableName());
        }
        else { // tables.size() > 1; tables.size() == 0 is invalid.
            PrefixTable leftTable = pt;
            PrefixTable rightTable;
            DatasetCorrelation correlation;
            List<DatasetCorrelationDtl> correlationDetails;
            Iterator<DatasetCorrelationDtl> iterator;
            DatasetCorrelationDtl correlationDtl;
            OnClauseBuilder onClauseBuilder;
            ColumnMetadata leftColumn;
            ColumnMetadata rightColumn;
            join = fromClauseBuilder.from(leftTable.tableMetadata.getTableName(), leftTable.prefix);
            for (int i = 1; i < tables.size(); i++) {
                rightTable = tables.get(i);
                correlation = correlationRepository.findByLeftDatasetAndRightDataset(leftTable.datasetHead, rightTable.datasetHead);
                switch (correlation.getJoinType()) {
                    case LEFT_JOIN:
                        onClauseBuilder = join.leftJoin(rightTable.tableMetadata.getTableName(), rightTable.prefix);
                        break;
                    case INNER_JOIN:
                        onClauseBuilder = join.innerJoin(rightTable.tableMetadata.getTableName(), rightTable.prefix);
                        break;
                    default: // Cross Join
                        onClauseBuilder = join.crossJoin(rightTable.tableMetadata.getTableName(), rightTable.prefix);
                }
                correlationDetails = correlationDtlRepository.findByDatasetCorrelation(correlation);
                iterator = correlationDetails.iterator();
                correlationDtl = iterator.next();
                leftColumn = columnMetadataRepository.findOne(correlationDtl.getLeftColumnId());
                rightColumn = columnMetadataRepository.findOne(correlationDtl.getRightColumnId());
                join = onClauseBuilder.on(leftTable.prefix, leftColumn.getColumnName())
                        .eq(rightTable.prefix, rightColumn.getColumnName());
                while (iterator.hasNext()) {
                    correlationDtl = iterator.next();
                    leftColumn = columnMetadataRepository.findOne(correlationDtl.getLeftColumnId());
                    rightColumn = columnMetadataRepository.findOne(correlationDtl.getRightColumnId());
                    join.and(leftTable.prefix, leftColumn.getColumnName()).eq(rightTable.prefix, rightColumn.getColumnName());
                }

                if (tables.size() > i) {
                    leftTable = rightTable;
                }
            }
        }

        // TODO Implement the WHERE clause here.


        StringBuilder sql = join.build();
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

    private class PrefixTable {

        protected String prefix;

        protected DatasetHead datasetHead;

        protected TableMetadata tableMetadata;

        protected List<ColumnElement> columns = new ArrayList<>();
    }

    private class ColumnElement {

        protected DatasetElement element;

        protected ColumnMetadata column;
    }
}
