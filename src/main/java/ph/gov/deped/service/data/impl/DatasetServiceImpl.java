package ph.gov.deped.service.data.impl;

import com.bits.sql.CriteriaChainBuilder;
import com.bits.sql.CriteriaFilterBuilder;
import com.bits.sql.FromClauseBuilder;
import com.bits.sql.JdbcTypes;
import com.bits.sql.JoinOrWhereClauseBuilder;
import com.bits.sql.OnClauseBuilder;
import com.bits.sql.Projection;
import com.bits.sql.ProjectionBuilder;
import com.bits.sql.SqlValueMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.dto.ds.Filter;
import ph.gov.deped.data.ors.ds.DatasetCorrelation;
import ph.gov.deped.data.ors.ds.DatasetCorrelationDtl;
import ph.gov.deped.data.ors.ds.DatasetCriteria;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.data.ors.meta.ColumnMetadata;
import ph.gov.deped.data.ors.meta.TableMetadata;
import ph.gov.deped.repo.jpa.ors.ds.CorrelationDtlRepository;
import ph.gov.deped.repo.jpa.ors.ds.CorrelationRepository;
import ph.gov.deped.repo.jpa.ors.ds.CriteriaRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;
import ph.gov.deped.repo.jpa.ors.ds.ElementRepository;
import ph.gov.deped.repo.jpa.ors.meta.ColumnMetadataRepository;
import ph.gov.deped.repo.jpa.ors.meta.TableMetadataRepository;
import ph.gov.deped.service.data.api.DatasetService;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.ResultSetMetaData;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.bits.sql.QueryBuilders.read;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by ej on 9/10/14.
 */
public @Service class DatasetServiceImpl implements DatasetService {

    private static final Logger log = LogManager.getLogger(DatasetServiceImpl.class);

    public static final String SCHOOL_YEAR = "school_year";

    public static final int SCHOOL_PROFILE_DATASET_ID = 2;

    private TableMetadataRepository tableMetadataRepository;

    private ColumnMetadataRepository columnMetadataRepository;

    private ElementRepository elementRepository;

    private CorrelationRepository correlationRepository;

    private CorrelationDtlRepository correlationDtlRepository;

    private CriteriaRepository criteriaRepository;

    private DataSource dataSource;

    private DatasetRepository datasetRepository;

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

    public @Autowired void setDatasetRepository(DatasetRepository datasetRepository) {
        this.datasetRepository = datasetRepository;
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
        Map<Integer, String> tablePrefixMap = new HashMap<>();
        List<PrefixTable> prefixTables = map.entrySet().stream()
                .map(entry -> {
                    PrefixTable p = new PrefixTable();
                    p.tableMetadata = tableMetadataRepository.findOne(entry.getKey().getTableId());
                    p.datasetHead = entry.getKey();
                    elements.forEach(element -> {
                        ColumnMetadata cm = columnMetadataRepository.findOne(element.getColumnId());
                        ColumnElement ce = new ColumnElement(element, cm);
                        p.columns.add(ce);
                    });
                    return p;
                })
                .collect(toList());
        // load school profile if not present
        PrefixTable schoolProfilePrefixTable = null;
        for (PrefixTable prefixTable : prefixTables) {
            if (prefixTable.datasetHead.getId() == SCHOOL_PROFILE_DATASET_ID) {
                schoolProfilePrefixTable = prefixTable;
                break;
            }
        }
        if (schoolProfilePrefixTable == null) {
            schoolProfilePrefixTable = lookupSchoolProfile(SCHOOL_PROFILE_DATASET_ID);
            prefixTables.add(0, schoolProfilePrefixTable);
        }
        prefixTables.sort((p1, p2) -> p1.datasetHead.getRanking().compareTo(p2.datasetHead.getRanking()));
        lookupPrefixes(tablePrefixMap, prefixTables);
        ProjectionBuilder projectionBuilder = read();
        FromClauseBuilder fromClauseBuilder = prefixTables.stream()
                .map(pt ->
                    pt.columns.stream()
                            .map(ce -> new Projection(pt.prefix, ce.column.getColumnName(), ce.element.getName()))
                            .map(projectionBuilder::select)
                            .reduce((p1, p2) -> p2)
                            .get()
                )
                .reduce((f1, f2) -> f2)
                .get();
        PrefixTable pt = prefixTables.get(0);
        JoinOrWhereClauseBuilder join;
        if (prefixTables.size() == 1) {
            join = fromClauseBuilder.from(pt.tableMetadata.getTableName());
        }
        else { // prefixTables.size() > 1; prefixTables.size() == 0 is invalid.
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
            for (int i = 1; i < prefixTables.size(); i++) {
                rightTable = prefixTables.get(i);
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
                leftColumn = columnMetadataRepository.findOne(correlationDtl.getLeftElement().getColumnId());
                rightColumn = columnMetadataRepository.findOne(correlationDtl.getRightElement().getColumnId());
                join = onClauseBuilder.on(leftTable.prefix, leftColumn.getColumnName())
                        .eq(rightTable.prefix, rightColumn.getColumnName());
                while (iterator.hasNext()) {
                    correlationDtl = iterator.next();
                    leftColumn = columnMetadataRepository.findOne(correlationDtl.getLeftElement().getColumnId());
                    rightColumn = columnMetadataRepository.findOne(correlationDtl.getRightElement().getColumnId());
                    join.and(leftTable.prefix, leftColumn.getColumnName()).eq(rightTable.prefix, rightColumn.getColumnName());
                }

                if (prefixTables.size() > i) {
                    leftTable = rightTable;
                }
            }
        }

        List<Filter> filters = dataset.getFilters();
        Filter filter = null;
        DatasetElement schoolYearElement = schoolProfilePrefixTable.columns.stream()
                .map(ce -> ce.element)
                // make sure the actual school profile dataset to prevent duplicate columns
                .filter(e -> e.getDatasetHead().getId() == SCHOOL_PROFILE_DATASET_ID)
                .filter(e -> e.getName().equals(SCHOOL_YEAR)) // find school year element
                .findFirst().get();
        for (Iterator<Filter> iterator = filters.iterator(); iterator.hasNext(); ) { // lookup and remove school year element
            filter = iterator.next();
            if (filter.getElement() == schoolYearElement.getId()) {
                iterator.remove();
                break;
            }
        }
        if (filter == null) {
            throw new RuntimeException("Missing filter for School Year.");
        }
        // set school year filter first before the other filters
        ColumnMetadata schoolYearColumn = columnMetadataRepository.findOne(schoolYearElement.getColumnId());
        CriteriaFilterBuilder criteriaFilterBuilder = join.where(schoolProfilePrefixTable.prefix, schoolYearColumn.getColumnName());
        CriteriaChainBuilder criteriaChainBuilder;
        if (filter.getSelectedValue() == null) {
            criteriaChainBuilder = criteriaFilterBuilder.eq(getCurrentYear());
        }
        else {
            criteriaChainBuilder = criteriaFilterBuilder.eq(Integer.parseInt(String.valueOf(filter.getSelectedValue())));
        }
        filters.forEach(f -> {
            DatasetCriteria criterion = criteriaRepository.findOne(f.getCriterion());
            DatasetElement datasetElement = criterion.getLeftElement();
            ColumnMetadata columnMetadata = columnMetadataRepository.findOne(datasetElement.getColumnId());
            String tablePrefix = tablePrefixMap.get(columnMetadata.getTableId());
            String dataType = columnMetadata.getDataType();
            Serializable value = f.getSelectedValue();
            criteriaChainBuilder.and(tablePrefix, columnMetadata.getColumnName());
            if (JdbcTypes.isBoolean(dataType, columnMetadata.getMax())) {
                SqlValueMapper<Boolean> mapper = JdbcTypes.getValueMapper(dataType);
                criteriaFilterBuilder.is(mapper.apply(value));
            }
            else if (JdbcTypes.isNumeric(dataType)) {
                SqlValueMapper<Number> mapper = JdbcTypes.getValueMapper(dataType);
                criteriaFilterBuilder.eq(mapper.apply(value));
            }
            else if ("char".equals(dataType)) {
                SqlValueMapper<Character> mapper = JdbcTypes.getValueMapper(dataType);
                criteriaFilterBuilder.eq(mapper.apply(value));
            }
            else { // default is string base
                SqlValueMapper<String> mapper = JdbcTypes.getValueMapper(dataType);
                criteriaFilterBuilder.eq(mapper.apply(value));
            }
        });

        // TODO Implement Order By clause here.

        StringBuilder sql = criteriaChainBuilder.build();
        log.debug("Generated SQL [{}]", sql);
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

    private int getCurrentYear() {
        LocalDate localDate = LocalDate.now();
        return localDate.getYear();
    }

    private PrefixTable lookupSchoolProfile(long schoolProfileDatasetHeadId) {
        DatasetHead schoolProfileDatasetHead = datasetRepository.findOne(schoolProfileDatasetHeadId);
        DatasetElement schoolIdElement = elementRepository.findByDatasetHeadAndName(schoolProfileDatasetHead, "school_id");
        DatasetElement schoolYearElement = elementRepository.findByDatasetHeadAndName(schoolProfileDatasetHead, SCHOOL_YEAR);
        PrefixTable pt = new PrefixTable();
        pt.datasetHead = schoolProfileDatasetHead;
        pt.columns.add(new ColumnElement(schoolIdElement, columnMetadataRepository.findOne(schoolIdElement.getColumnId())));
        pt.columns.add(new ColumnElement(schoolYearElement, columnMetadataRepository.findOne(schoolYearElement.getColumnId())));
        pt.tableMetadata = tableMetadataRepository.findOne(schoolProfileDatasetHead.getTableId());
        return pt;
    }

    private void lookupPrefixes(Map<Integer, String> tablePrefixMap, List<PrefixTable> prefixTables) {
        Iterator<PrefixTable> iterator = prefixTables.iterator();
        PrefixTable leftPrefixTable = iterator.next();
        PrefixTable rightPrefixTable;
        DatasetCorrelation correlation;
        while (iterator.hasNext()) {
            rightPrefixTable = iterator.next();
            correlation = correlationRepository.findByLeftDatasetAndRightDataset(leftPrefixTable.datasetHead, rightPrefixTable.datasetHead);
            if (isBlank(leftPrefixTable.prefix)) {
                leftPrefixTable.prefix = correlation.getLeftTablePrefix();
                tablePrefixMap.put(correlation.getLeftDataset().getTableId(), leftPrefixTable.prefix);
            }
            rightPrefixTable.prefix = correlation.getRightTablePrefix();
            tablePrefixMap.put(correlation.getRightDataset().getTableId(), rightPrefixTable.prefix);
            leftPrefixTable = rightPrefixTable;
        }
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

        private ColumnElement(DatasetElement element, ColumnMetadata column) {
            this.element = element;
            this.column = column;
        }
    }
}
