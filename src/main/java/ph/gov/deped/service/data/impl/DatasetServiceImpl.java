package ph.gov.deped.service.data.impl;

import static com.bits.sql.QueryBuilders.read;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

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

import com.bits.sql.CriteriaChainBuilder;
import com.bits.sql.CriteriaFilterBuilder;
import com.bits.sql.FromClauseBuilder;
import com.bits.sql.JdbcTypes;
import com.bits.sql.JoinOrWhereClauseBuilder;
import com.bits.sql.OnClauseBuilder;
import com.bits.sql.Projection;
import com.bits.sql.ProjectionBuilder;
import com.bits.sql.SqlValueMapper;

/**
 * Created by ej on 9/10/14.
 */
public @Service class DatasetServiceImpl implements DatasetService {

    private static final String DIVISION_ID = "division_id";

    private static final String REGION_ID = "region_id";

    private static final Logger log = LogManager.getLogger(DatasetServiceImpl.class);

    public static final String SCHOOL_YEAR = "school_year";

    public static final long SCHOOL_PROFILE_DATASET_ID = 8;

    public static final String SCHOOL_NAME = "school_name";

    public static final String SCHOOL_ID = "school_id";

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

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<List<Serializable>> getData(Dataset dataset, boolean previewOnly) {
        List<DatasetElement> elements = dataset.getElements().stream()
                .map(Element::getId)
                .map(elementRepository::findOne)
                .collect(toList());

        Map<DatasetHead, List<DatasetElement>> map = new HashMap<>();
        elements.forEach(element -> {
            DatasetHead datasetHead = element.getDatasetHead();
            if (!map.containsKey(datasetHead)) {
                map.put(datasetHead, new LinkedList<>());
            }
            map.get(datasetHead).add(element);
        });
        Map<Integer, String> tablePrefixMap = new HashMap<>();
        LinkedList<PrefixTable> prefixTables = map.entrySet().stream()
                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .map(entry -> {
                    PrefixTable p = new PrefixTable();
                    p.tableMetadata = tableMetadataRepository.findOne(entry.getKey().getTableId());
                    p.datasetHead = entry.getKey();
                    entry.getValue().forEach(element -> {
                        ColumnMetadata cm = columnMetadataRepository.findOne(element.getColumnId());
                        ColumnElement ce = new ColumnElement(element, cm);
                        p.columns.add(ce);
                    });
                    return p;
                })
                .collect(toCollection(LinkedList::new));

        lookupMandatoryDatasets(prefixTables);
        
        // load school profile if not present
        PrefixTable schoolProfilePrefixTable = null;
        for (PrefixTable prefixTable : prefixTables) {
            if (prefixTable.datasetHead.getId() == SCHOOL_PROFILE_DATASET_ID) {
                schoolProfilePrefixTable = prefixTable;
                break;
            }
        }
        lookupPrefixes(tablePrefixMap, prefixTables);
        ProjectionBuilder projectionBuilder = read();
        LinkedList<ColumnElement> sortedColumns = new LinkedList<>();
        FromClauseBuilder fromClauseBuilder = null;
        ColumnElement columnElement;
        for (int i = 0; i < prefixTables.size(); i++) {
            PrefixTable pt = prefixTables.get(i);
            for (int j = 0; j < pt.columns.size(); j++) {
                columnElement = pt.columns.get(j);
                sortedColumns.add(columnElement);
                fromClauseBuilder = projectionBuilder.select(new Projection(pt.prefix, columnElement.column.getColumnName(), columnElement.element.getName()));
            }
        }
        PrefixTable prefixTable = schoolProfilePrefixTable;
        JoinOrWhereClauseBuilder join;
        if (prefixTables.size() == 1) { // TODO Investigate if this is still possible since School Profile is always required.
            join = fromClauseBuilder.from(prefixTable.tableMetadata.getTableName());
        }
        else { // prefixTables.size() > 1; prefixTables.size() == 0 is invalid.
            PrefixTable leftTable = prefixTable;
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
                do {
                    correlationDtl = iterator.next();
                    leftColumn = columnMetadataRepository.findOne(correlationDtl.getLeftElement().getColumnId());
                    rightColumn = columnMetadataRepository.findOne(correlationDtl.getRightElement().getColumnId());
                    join = onClauseBuilder.on(leftTable.prefix, leftColumn.getColumnName())
                            .eq(rightTable.prefix, rightColumn.getColumnName());
                }
                while (iterator.hasNext());
            }
        }

        List<Filter> filters = dataset.getFilters();
        Filter filter = null;
        Optional<ColumnElement> optionalSchoolYearElement = schoolProfilePrefixTable.columns.stream()
                .filter(ce -> ce.element.getName().equals(SCHOOL_YEAR)) // find school year element
                .findFirst();
        ColumnElement schoolYearElement;
        if (optionalSchoolYearElement.isPresent()) {
            schoolYearElement = optionalSchoolYearElement.get();
        }
        else {
            DatasetElement schoolYearDatasetElement = elementRepository.findByDatasetHeadAndName(schoolProfilePrefixTable.datasetHead, SCHOOL_YEAR);
            schoolProfilePrefixTable.columns.add(schoolYearElement = new ColumnElement(schoolYearDatasetElement, columnMetadataRepository.findOne(schoolYearDatasetElement.getColumnId())));
        }
        for (Iterator<Filter> iterator = filters.iterator(); iterator.hasNext(); ) { // lookup and remove school year element
            filter = iterator.next();
            if (filter.getElement() == schoolYearElement.element.getId().longValue()) {
                iterator.remove();
                break;
            }
        }
        if (filter == null) { // school year filter not included from the user selection of filters
            filter = lookupSchoolFilter(schoolProfilePrefixTable, schoolYearElement.element);
        }
        // set school year filter first before the other filters
        ColumnMetadata schoolYearColumn = schoolYearElement.column;
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
            if (value == null) { // null case
                criteriaFilterBuilder.isNull();
            }
            else {
                String str = String.valueOf(value);
                if (!isBlank(str)) { // not null and empty value case
                    if (JdbcTypes.isBoolean(dataType, columnMetadata.getMax())) {
                        SqlValueMapper<Boolean> mapper = JdbcTypes.getValueMapper(dataType);
                        criteriaFilterBuilder.is(mapper.apply(value));
                    }
                    else if (JdbcTypes.isNumeric(dataType)) {
                        SqlValueMapper<Number> mapper = JdbcTypes.getValueMapper(dataType);
                        criteriaFilterBuilder.eq(mapper.apply(value));
                    }
                    else { // default is string base
                        SqlValueMapper<String> mapper = JdbcTypes.getValueMapper(dataType);
                        criteriaFilterBuilder.eq(mapper.apply(value));
                    }
                }
            }
        });

        Map<Long, List<String>> orderMap = lookupOrderElements();
        orderMap.entrySet().forEach(e -> {
            PrefixTable pt = prefixTables.stream()
                    .filter(table -> e.getKey().equals(table.datasetHead.getId()))
                    .findFirst().get();
            e.getValue().forEach(name -> {
                DatasetElement orderElement = elementRepository.findByDatasetHeadAndName(pt.datasetHead, name);
                ColumnMetadata orderColumn = columnMetadataRepository.findOne(orderElement.getColumnId());
                criteriaChainBuilder.orderBy(pt.prefix, orderColumn.getColumnName(), true);
            });
        });

        StringBuilder sql = criteriaChainBuilder.build();
        if (previewOnly) { // hack solution to limit returned rows if preview data requested.
            sql.append(" LIMIT 20");
        }
        log.debug("Generated SQL [{}]", sql);
        JdbcTemplate template = new JdbcTemplate(dataSource);
        List<List<Serializable>> data = template.query(sql.toString(), (rs, rowNum) -> {
            List<Serializable> row = new LinkedList<>();
            String columnName;
            Serializable value;
            for (int i = 0; i < sortedColumns.size(); i++) {
                ColumnElement ce = sortedColumns.get(i);
                columnName = ce.element.getName();
                value = (Serializable) rs.getObject(columnName);
                row.add(value);
            }
            return row;
        });
        List<Serializable> headers = new LinkedList<>();
        for (int i = 0; i < sortedColumns.size(); i++) {
            columnElement = sortedColumns.get(i);
            headers.add(columnElement.element.getDescription());
        }
        data.add(0, headers);
        return data;
    }

    private Filter lookupSchoolFilter(PrefixTable schoolProfilePrefixTable, DatasetElement schoolYearElement) {
        List<DatasetCriteria> criterias = criteriaRepository.findByDatasetHeadAndLeftElement(schoolProfilePrefixTable.datasetHead, schoolYearElement);
        DatasetCriteria schoolYearDatasetCriteria = criterias.get(0);
        return new Filter(schoolYearDatasetCriteria.getId(), schoolYearElement.getId(), getCurrentYear());
    }

    private int getCurrentYear() {
        LocalDate localDate = LocalDate.now();
        return localDate.getYear();
    }
    
    private void lookupMandatoryDatasets(List<PrefixTable> prefixTables) {
        Map<Long, List<String>> mandatoryElements = lookupMandatoryElements();
        mandatoryElements.entrySet().forEach(entry -> {
            Optional<PrefixTable> selectedTable = prefixTables.parallelStream()
                    .filter(prefixTable -> prefixTable.datasetHead.getId().equals(entry.getKey()))
                    .findFirst();
            PrefixTable prefixTable;
            if (!selectedTable.isPresent()) {
                DatasetHead datasetHead = datasetRepository.findOne(entry.getKey());
                prefixTable = new PrefixTable();
                prefixTable.datasetHead = datasetHead;
            }
            else {
                prefixTable = selectedTable.get();
            }
            lookupMandatoryElements(prefixTable, entry.getValue());
        });
    }
    
    private void lookupMandatoryElements(PrefixTable prefixTable, List<String> mandatoryElements) {
        DatasetHead datasetHead = prefixTable.datasetHead;
        mandatoryElements.forEach(elementName -> {
            Optional<DatasetElement> selectedElement = prefixTable.columns.stream()
                    .map(ce -> ce.element)
                    .filter(element -> element != null)
                    .filter(element -> element.getName().equals(elementName))
                    .findFirst();
            if (!selectedElement.isPresent()) {
                DatasetElement de = elementRepository.findByDatasetHeadAndName(datasetHead, elementName);
                prefixTable.columns.add(new ColumnElement(de, columnMetadataRepository.findOne(de.getColumnId())));
            }
        });
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
        }
    }

    // Map of Head ID and Element Names
    private Map<Long, List<String>> lookupOrderElements() {
        Map<Long, List<String>> map = new HashMap<>();
        List<String> names = new LinkedList<>();
        names.add(REGION_ID);
        names.add(DIVISION_ID);
        names.add("sector_id");
        names.add(SCHOOL_ID);
        names.add(SCHOOL_NAME);
        map.put(SCHOOL_PROFILE_DATASET_ID, names);
        return map;
    }
    
    // Map of Head ID and Mandatory Element Names
    private Map<Long, List<String>> lookupMandatoryElements() {
        Map<Long, List<String>> map = new HashMap<>();
        List<String> names = new LinkedList<>();
        names.add(SCHOOL_YEAR);
        names.add(REGION_ID);
        names.add(DIVISION_ID);
        names.add(SCHOOL_ID);
        names.add(SCHOOL_NAME);
        map.put(SCHOOL_PROFILE_DATASET_ID, names);
        return map;
    }

    private class PrefixTable implements Comparable<PrefixTable> {

        protected String prefix;

        protected DatasetHead datasetHead;

        protected TableMetadata tableMetadata;

        protected LinkedList<ColumnElement> columns = new LinkedList<>();

        public @Override boolean equals(Object o) {
            if (o == null || !(o instanceof PrefixTable)) {
                return false;
            }
            PrefixTable rhs = (PrefixTable) o;
            return this.datasetHead.equals(rhs.datasetHead);
        }

        public @Override int hashCode() {
            return this.datasetHead.hashCode();
        }

        public int compareTo(PrefixTable o) {
            return this.datasetHead.compareTo(o.datasetHead);
        }
    }

    private class ColumnElement implements Comparable<ColumnElement> {

        protected DatasetElement element;

        protected ColumnMetadata column;

        private ColumnElement(DatasetElement element, ColumnMetadata column) {
            this.element = element;
            this.column = column;
        }
        
        public int compareTo(ColumnElement o) {
            int headCompared = this.element.getDatasetHead().compareTo(o.element.getDatasetHead());
            if (headCompared == 0) {
                return this.element.getId().compareTo(o.element.getId());
            }
            return headCompared;
        }

        public @Override boolean equals(Object o) {
            if (o == null || !(o instanceof ColumnElement)) {
                return false;
            }
            ColumnElement rhs = (ColumnElement) o;
            return this.element.equals(rhs.element) && this.column.equals(rhs.column);
        }
        
        public @Override int hashCode() {
            return this.element.hashCode();
        }
    }
}
