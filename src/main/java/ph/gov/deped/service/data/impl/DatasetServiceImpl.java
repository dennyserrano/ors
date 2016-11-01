package ph.gov.deped.service.data.impl;

import com.bits.sql.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.KeyValue;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.dto.ds.Filter;
import ph.gov.deped.data.ors.ds.*;
import ph.gov.deped.data.ors.meta.ColumnMetadata;
import ph.gov.deped.repo.jpa.ors.ds.*;
import ph.gov.deped.repo.jpa.ors.meta.ColumnMetadataRepository;
import ph.gov.deped.repo.jpa.ors.meta.TableMetadataRepository;
import ph.gov.deped.service.data.api.DatasetService;

import javax.sql.DataSource;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import static com.bits.sql.Expressions.number;
import static com.bits.sql.Expressions.string;
import static com.bits.sql.JdbcTypes.getValueMapper;
import static com.bits.sql.JdbcTypes.isBoolean;
import static com.bits.sql.JdbcTypes.isNumeric;
import static com.bits.sql.QueryBuilders.read;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by ej on 9/10/14.
 */
public @Service class DatasetServiceImpl implements DatasetService {

    private static final Logger log = LogManager.getLogger(DatasetServiceImpl.class);

    private static final long SCHOOL_PROFILE_DATASET_ID = 8;

    private static final String DIVISION_ID = "division_id";

    private static final String REGION_ID = "region_id";

    private static final String SCHOOL_YEAR = "school_year";

    private static final String SCHOOL_NAME = "school_name";

    private static final String SCHOOL_ID = "school_id";

    private static final String SECTOR_ID = "sector_id";

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

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<List<ColumnElement>> getData(
            Dataset dataset, boolean previewOnly) {
    	
    	//TODO getDataSize select all fields? count should only be returned
    	//TODO file systems of temp path and final output? be organized
    	//TODO logging? instead of syso?
    	//TODO preview page hanging when data is too big
    	//TODO next buttons should be disabled when there are still loading parts of pages
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
                    PrefixTable p = new PrefixTable(entry.getKey(), tableMetadataRepository.findOne(entry.getKey().getTableId()));
                    entry.getValue().forEach(element -> {
                        ColumnMetadata cm = columnMetadataRepository.findOne(element.getColumnId());
                        ColumnElement ce = new ColumnElement(element, cm);
                        p.addColumn(ce);
                    });
                    return p;
                })
                .collect(toCollection(LinkedList::new));

        lookupMandatoryDatasets(prefixTables);
        
        // load school profile if not present
        PrefixTable schoolProfilePrefixTable = null;
        for (PrefixTable prefixTable : prefixTables) {
            if (prefixTable.getDatasetId() == SCHOOL_PROFILE_DATASET_ID) {
                schoolProfilePrefixTable = prefixTable;
                break;
            }
        }
        lookupPrefixes(tablePrefixMap, prefixTables);
        ProjectionBuilder projectionBuilder = read();
        LinkedList<ColumnElement> sortedColumns = new LinkedList<>();
        FromClauseBuilder fromClauseBuilder = null;
        ColumnElement columnElement;
        List<ColumnElement> ces;
        for (int i = 0; i < prefixTables.size(); i++) {
            PrefixTable pt = prefixTables.get(i);
            ces = new ArrayList<>(pt.getColumns());
            log.trace("Sorting Dataset Head: [{}]", pt.getDatasetName());
            for (int j = 0; j < pt.getColumns().size(); j++) {
                columnElement = ces.get(j);
                sortedColumns.add(columnElement);
                log.trace("Column and Element [{}] added to sortedColumns.", columnElement.getElementName());
                fromClauseBuilder = projectionBuilder.select(new Projection(pt.getTablePrefix(), columnElement.getColumnName(), columnElement.getElementName()));
            }
        }
        PrefixTable prefixTable = schoolProfilePrefixTable;
        JoinOrWhereClauseBuilder join;
        if (prefixTables.size() == 1) { // TODO Investigate if this is still possible since School Profile is always required.
            join = fromClauseBuilder.from(prefixTable.getTableName());
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
            join = fromClauseBuilder.from(leftTable.getTableName(), leftTable.getTablePrefix());
            for (int i = 1; i < prefixTables.size(); i++) {
                rightTable = prefixTables.get(i);
                correlation = correlationRepository.findByLeftDatasetIdAndRightDatasetId(leftTable.getDatasetId(), rightTable.getDatasetId());
                switch (correlation.getJoinType()) {
                    case LEFT_JOIN:
                        onClauseBuilder = join.leftJoin(rightTable.getTableName(), rightTable.getTablePrefix());
                        break;
                    case INNER_JOIN:
                        onClauseBuilder = join.innerJoin(rightTable.getTableName(), rightTable.getTablePrefix());
                        break;
                    default: // Cross Join
                        onClauseBuilder = join.crossJoin(rightTable.getTableName(), rightTable.getTablePrefix());
                }
                correlationDetails = correlationDtlRepository.findByDatasetCorrelation(correlation);
                iterator = correlationDetails.iterator();
                do {
                    correlationDtl = iterator.next();
                    leftColumn = columnMetadataRepository.findOne(correlationDtl.getLeftElement().getColumnId());
                    rightColumn = columnMetadataRepository.findOne(correlationDtl.getRightElement().getColumnId());
                    join = onClauseBuilder.on(leftTable.getTablePrefix(), leftColumn.getColumnName())
                            .eq(rightTable.getTablePrefix(), rightColumn.getColumnName());
                }
                while (iterator.hasNext());
            }
        }

        List<Filter> filters = dataset.getFilters();
        Filter filter = null;
        Optional<ColumnElement> optionalSchoolYearElement = schoolProfilePrefixTable.getColumns().parallelStream()
                .filter(ce -> ce.getElementName().equals(SCHOOL_YEAR)) // find school year element
                .findFirst();
        ColumnElement schoolYearElement;
        if (optionalSchoolYearElement.isPresent()) {
            schoolYearElement = optionalSchoolYearElement.get();
        }
        else {
            DatasetElement schoolYearDatasetElement = elementRepository.findByDatasetHeadIdAndName(schoolProfilePrefixTable.getDatasetId(), SCHOOL_YEAR);
            schoolProfilePrefixTable.addColumn(
                    schoolYearElement = new ColumnElement(schoolYearDatasetElement, columnMetadataRepository.findOne(schoolYearDatasetElement.getColumnId()))
            );
        }
        for (Iterator<Filter> iterator = filters.iterator(); iterator.hasNext(); ) { // lookup and remove school year element
            filter = iterator.next();
            if (filter.getElement() == schoolYearElement.getElementId()) {
                iterator.remove();
                break;
            }
        }
        if (filter == null) { // school year filter not included from the user selection of filters
            filter = lookupSchoolFilter(schoolProfilePrefixTable, schoolYearElement.getElementId());
        }
        // set school year filter first before the other filters
        CriteriaFilterBuilder criteriaFilterBuilder = join.where(schoolProfilePrefixTable.getTablePrefix(), schoolYearElement.getColumnName());
        CriteriaChainBuilder criteriaChainBuilder;
        if (filter.getSelectedOptions() == null || filter.getSelectedOptions().isEmpty()) {
            criteriaChainBuilder = criteriaFilterBuilder.eq(getCurrentYear());
        }
        else {
            criteriaChainBuilder = criteriaFilterBuilder.eq(Integer.parseInt(String.valueOf(filter.getSelectedOptions().get(0).getKey())));
        }
        filters.forEach(f -> {
            DatasetCriteria criterion = criteriaRepository.findOne(f.getCriterion());
            DatasetElement datasetElement = criterion.getLeftElement();
            ColumnMetadata columnMetadata = columnMetadataRepository.findOne(datasetElement.getColumnId());
            String tablePrefix = tablePrefixMap.get(columnMetadata.getTableId());
            String dataType = columnMetadata.getDataType();
            FilterType filterType = criterion.getFilterType();
            switch (filterType) {
                case VALUES:
                    multipleValueFilter(criterion, f, criteriaFilterBuilder, criteriaChainBuilder, columnMetadata, tablePrefix, dataType);
                    break;
                default:
                    singleValueFilter(criterion, f, criteriaFilterBuilder, criteriaChainBuilder, columnMetadata, tablePrefix, dataType);
            }
        });

        Map<Long, List<String>> orderMap = lookupOrderElements();
        orderMap.entrySet().forEach(e -> {
            PrefixTable pt = prefixTables.stream()
                    .filter(table -> e.getKey().equals(table.getDatasetId()))
                    .findFirst().get();
            e.getValue().forEach(name -> {
                DatasetElement orderElement = elementRepository.findByDatasetHeadIdAndName(pt.getDatasetId(), name);
                ColumnMetadata orderColumn = columnMetadataRepository.findOne(orderElement.getColumnId());
                criteriaChainBuilder.orderBy(pt.getTablePrefix(), orderColumn.getColumnName(), true);
            });
        });

        StringBuilder sql = criteriaChainBuilder.build();
        if (previewOnly) { // hack solution to limit returned rows if preview data requested.
            sql.append(" LIMIT 20");
        }
        log.debug("Generated SQL [{}]", sql);
        JdbcTemplate template = new JdbcTemplate(dataSource);
        List<List<ColumnElement>> data = template.query(sql.toString(), (rs, rowNum) -> {
            List<ColumnElement> row = new LinkedList<>();
            sortedColumns.forEach(ce -> {
                try {
                    ColumnElement columnElementWithValue = ce.clone(); 
                    Serializable value = JdbcTypes.getValue(rs, ce.getElementName(), ce.getDataType());
                    columnElementWithValue.setValue(value);
                    row.add(columnElementWithValue);
                }
                catch (SQLException ex) {
                    log.catching(ex);
                    throw log.throwing(new RuntimeException(format("SQL Error while getting value of element [%s].", ce.getElementName()), ex));
                }
            });
            return row;
        });
        
        LinkedList<ColumnElement> headers = sortedColumns.stream()
                .map(ColumnElement::clone) // copy the original user selected column elements
                .map(ce -> {
                    ce.setValue(ce.getElementName()); // set the value as the element description
                    return ce;
                })
                .collect(toCollection(LinkedList::new));
        data.add(0, headers);
        return data;
    }

    private void multipleValueFilter(DatasetCriteria criterion, Filter filter, CriteriaFilterBuilder criteriaFilterBuilder,
                                     CriteriaChainBuilder criteriaChainBuilder, ColumnMetadata columnMetadata,
                                     String tablePrefix, String dataType) {
        criteriaChainBuilder.and(tablePrefix, columnMetadata.getColumnName());
        if (!(criterion.getOperator() instanceof Operators.Multiple)) {
            throw new RuntimeException(String.format("Operator [%s] is not applicable for filter [%s].", criterion.getOperator(), criterion.getFilterName()));
        }
        Operators.Multiple operator = (Operators.Multiple) criterion.getOperator();
        
        switch (operator) {
            case RANGE:
                rangeValueCriteriaBuilder(criterion, filter, criteriaFilterBuilder, dataType);
                break;
            case IN:
                criteriaInValuesBuilder(criterion, filter, criteriaFilterBuilder, dataType);
        }
    }
    
    
    
    private void rangeValueCriteriaBuilder(DatasetCriteria criterion, Filter filter,
                                           CriteriaFilterBuilder criteriaFilterBuilder, String dataType) {
        KeyValue kv1 = filter.getSelectedOptions().get(0);
        KeyValue kv2 = filter.getSelectedOptions().get(1);
        if (!isNumeric(dataType)) {
            throw new UnsupportedOperationException(String.format("Only number data types are applicable for operator [%s].",
                    criterion.getOperator().getName()));
        }
        SqlValueMapper<Number> mapper = getValueMapper(dataType);
        Number min = mapper.apply(kv1.getKey());
        Number max = mapper.apply(kv2.getKey());
        criteriaFilterBuilder.between(min).and(max);
    }
    
    private void criteriaInValuesBuilder(DatasetCriteria criterion, Filter filter,
                                         CriteriaFilterBuilder criteriaFilterBuilder, String dataType) {
        List<ValueExpression> values = filter.getSelectedOptions().stream()
                .map(KeyValue::getKey)
                .map(k -> {
                    if (isNumeric(dataType)) {
                        SqlValueMapper<Number> mapper = getValueMapper(dataType);
                        return number(mapper.apply(k));
                    }
                    else { // String based
                        SqlValueMapper<String> mapper = getValueMapper(dataType);
                        return string(mapper.apply(k));
                    }
                })
                .collect(toList());
        criteriaFilterBuilder.in(values.toArray(new ValueExpression[values.size()]));
    }

    private void singleValueFilter(DatasetCriteria criterion, Filter filter, CriteriaFilterBuilder criteriaFilterBuilder,
                                   CriteriaChainBuilder criteriaChainBuilder, ColumnMetadata columnMetadata,
                                   String tablePrefix, String dataType) {
        String value = filter.getSelectedOptions().get(0).getKey();
        criteriaChainBuilder.and(tablePrefix, columnMetadata.getColumnName());
        if (value == null) { // null case?
            criteriaFilterBuilder.isNull();
        }
        else {
            String str = String.valueOf(value);
            if (!isBlank(str)) { // not null and empty value case
                if (isBoolean(dataType, columnMetadata.getMax())) {
                    SqlValueMapper<Short> mapper = getValueMapper(dataType);
                    Short converted = mapper.apply(value);
                    criteriaFilterBuilder.is((converted != null && converted.shortValue() > 0) ? Boolean.TRUE : Boolean.FALSE);
                }
                else if (isNumeric(dataType)) {
                    SqlValueMapper<Number> mapper = getValueMapper(dataType);
                    criteriaFilterBuilder.eq(mapper.apply(value));
                }
                else { // default is string base
                    SqlValueMapper<String> mapper = getValueMapper(dataType);
                    criteriaFilterBuilder.eq(mapper.apply(value));
                }
            }
        }
    }

    private Filter lookupSchoolFilter(PrefixTable schoolProfilePrefixTable, long schoolYearElementId) {
        List<DatasetCriteria> criterias = criteriaRepository.findByDatasetHeadIdAndLeftElementId(schoolProfilePrefixTable.getDatasetId(), schoolYearElementId);
        DatasetCriteria schoolYearDatasetCriteria = criterias.get(0);
        List<KeyValue> list = new ArrayList<>(asList(new KeyValue(String.valueOf(getCurrentYear()), "")));
        return new Filter(schoolYearDatasetCriteria.getId(), schoolYearElementId, list);
    }

    private int getCurrentYear() {
        LocalDate localDate = LocalDate.now();
        return localDate.getYear();
    }
    
    private void lookupMandatoryDatasets(LinkedList<PrefixTable> prefixTables) {
        Map<Long, Set<String>> mandatoryElements = lookupMandatoryElements();
        mandatoryElements.entrySet().forEach(entry -> {
            Optional<PrefixTable> selectedTable = prefixTables.parallelStream()
                    .filter(prefixTable -> prefixTable.getDatasetId() == entry.getKey())
                    .findFirst();
            PrefixTable prefixTable;
            if (selectedTable.isPresent()) {
                prefixTable = selectedTable.get();
            }
            else {
                DatasetHead datasetHead = datasetRepository.findOne(entry.getKey());
                prefixTable = new PrefixTable(datasetHead, tableMetadataRepository.findOne(datasetHead.getTableId()));
                prefixTables.addFirst(prefixTable);
            }
            lookupMandatoryElements(prefixTable, entry.getValue());
        });
    }
    
    private void lookupMandatoryElements(PrefixTable prefixTable, Set<String> mandatoryElements) {
        long datasetId = prefixTable.getDatasetId();
        // remove mandatory elements first
        Set<ColumnElement> userSelectedNonMandatoryFields = prefixTable.getColumns().stream()
                .filter(ce -> !mandatoryElements.contains(ce.getElementName()))
                .collect(toCollection(LinkedHashSet::new));
        // lookup mandatory elements
        Set<ColumnElement> mandatoryFields = mandatoryElements.stream()
                .map(elementName -> elementRepository.findByDatasetHeadIdAndName(datasetId, elementName))
                .filter(element -> element != null)
                .map(element -> new ColumnElement(element, columnMetadataRepository.findOne(element.getColumnId())))
                .collect(toCollection(LinkedHashSet::new));
        // combine mandatory elements and user selected elements
        Set<ColumnElement> uniqueElements = new LinkedHashSet<>(mandatoryFields);
        uniqueElements.addAll(userSelectedNonMandatoryFields);
        // replace the list of column elements under this prefixed table.
        prefixTable.getColumns().clear();
        uniqueElements.forEach(prefixTable::addColumn);
    }

    private void lookupPrefixes(Map<Integer, String> tablePrefixMap, List<PrefixTable> prefixTables) {
        Iterator<PrefixTable> iterator = prefixTables.iterator();
        PrefixTable leftPrefixTable = iterator.next();
        PrefixTable rightPrefixTable;
        DatasetCorrelation correlation;
        while (iterator.hasNext()) {
            rightPrefixTable = iterator.next();
            correlation = correlationRepository.findByLeftDatasetIdAndRightDatasetId(leftPrefixTable.getDatasetId(), rightPrefixTable.getDatasetId());
            if (isBlank(leftPrefixTable.getTablePrefix())) {
                leftPrefixTable.setTablePrefix(correlation.getLeftTablePrefix());
                tablePrefixMap.put(correlation.getLeftDataset().getTableId(), leftPrefixTable.getTablePrefix());
            }
            rightPrefixTable.setTablePrefix(correlation.getRightTablePrefix());
            tablePrefixMap.put(correlation.getRightDataset().getTableId(), rightPrefixTable.getTablePrefix());
        }
    }

    // Map of Head ID and Element Names
    private Map<Long, List<String>> lookupOrderElements() {
        Map<Long, List<String>> map = new HashMap<>();
        List<String> names = new LinkedList<>();
        names.add(REGION_ID);
        names.add(DIVISION_ID);
        names.add(SECTOR_ID);
        names.add(SCHOOL_ID);
        names.add(SCHOOL_NAME);
        map.put(SCHOOL_PROFILE_DATASET_ID, names);
        return map;
    }
    
    // Map of Head ID and Mandatory Element Names
    private Map<Long, Set<String>> lookupMandatoryElements() {
        Map<Long, Set<String>> map = new HashMap<>();
        Set<String> names = new LinkedHashSet<>();
        names.add(SCHOOL_YEAR);
        names.add("region_shortname");
        names.add("division_name");
        names.add(SCHOOL_ID);
        names.add(SCHOOL_NAME);
        map.put(SCHOOL_PROFILE_DATASET_ID, names);
        return map;
    }

	@Override
	public long getDataSize(String sql) {
		//TODO columns should be at minimum. This is a select all
		JdbcTemplate template = new JdbcTemplate(dataSource);
		return template.query(sql, (rs, rowNum)->{return null;}).size();
	}

	@Override
	public String getGeneratedSQL(Dataset dataset,LinkedList<PrefixTable> prefixTables) {
		
		return getLocalGeneratedSQL(dataset,prefixTables);
	}

	@Override
	public List<List<ColumnElement>> getData(String sql,LinkedList<PrefixTable> argumentprefixTables,LinkedList<ColumnElement> sortedColumns) 
	{
		JdbcTemplate template = new JdbcTemplate(dataSource);
		List<List<ColumnElement>> data = template.query(sql, (rs, rowNum) -> {
          List<ColumnElement> row = new LinkedList<>();
          
          sortedColumns.forEach(ce -> {
              try {
                  ColumnElement columnElementWithValue = ce.clone(); 
                  Serializable value = JdbcTypes.getValue(rs, ce.getElementName(), ce.getDataType());
                  columnElementWithValue.setValue(value);
                  
                  row.add(columnElementWithValue);
              }
              catch (SQLException ex) {
                  log.catching(ex);
                  throw log.throwing(new RuntimeException(format("SQL Error while getting value of element [%s].", ce.getElementName()), ex));
              }
          });
          return row;
      });
		
		 
		
		return data;
	}

	private String getLocalGeneratedSQL(Dataset dataset,LinkedList<PrefixTable> argumentPrefixTables)
	{
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
        LinkedList<PrefixTable> prefixTables = argumentPrefixTables;

        
        
        // load school profile if not present
        PrefixTable schoolProfilePrefixTable = null;
        for (PrefixTable prefixTable : prefixTables) {
            if (prefixTable.getDatasetId() == SCHOOL_PROFILE_DATASET_ID) {
                schoolProfilePrefixTable = prefixTable;
                break;
            }
        }
        lookupPrefixes(tablePrefixMap, prefixTables);
        ProjectionBuilder projectionBuilder = read();
        FromClauseBuilder fromClauseBuilder = null;
        ColumnElement columnElement;
        List<ColumnElement> ces;
        for (int i = 0; i < prefixTables.size(); i++) {
            PrefixTable pt = prefixTables.get(i);
            ces = new ArrayList<>(pt.getColumns());
            log.trace("Sorting Dataset Head: [{}]", pt.getDatasetName());
            for (int j = 0; j < pt.getColumns().size(); j++) {
                columnElement = ces.get(j);
                log.trace("Column and Element [{}] added to sortedColumns.", columnElement.getElementName());
                fromClauseBuilder = projectionBuilder.select(new Projection(pt.getTablePrefix(), columnElement.getColumnName(), columnElement.getElementName()));
            }
        }
        PrefixTable prefixTable = schoolProfilePrefixTable;
        JoinOrWhereClauseBuilder join;
        if (prefixTables.size() == 1) { // TODO Investigate if this is still possible since School Profile is always required.
            join = fromClauseBuilder.from(prefixTable.getTableName());
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
            join = fromClauseBuilder.from(leftTable.getTableName(), leftTable.getTablePrefix());
            for (int i = 1; i < prefixTables.size(); i++) {
                rightTable = prefixTables.get(i);
                correlation = correlationRepository.findByLeftDatasetIdAndRightDatasetId(leftTable.getDatasetId(), rightTable.getDatasetId());
                switch (correlation.getJoinType()) {
                    case LEFT_JOIN:
                        onClauseBuilder = join.leftJoin(rightTable.getTableName(), rightTable.getTablePrefix());
                        break;
                    case INNER_JOIN:
                        onClauseBuilder = join.innerJoin(rightTable.getTableName(), rightTable.getTablePrefix());
                        break;
                    default: // Cross Join
                        onClauseBuilder = join.crossJoin(rightTable.getTableName(), rightTable.getTablePrefix());
                }
                correlationDetails = correlationDtlRepository.findByDatasetCorrelation(correlation);
                iterator = correlationDetails.iterator();
                do {
                    correlationDtl = iterator.next();
                    leftColumn = columnMetadataRepository.findOne(correlationDtl.getLeftElement().getColumnId());
                    rightColumn = columnMetadataRepository.findOne(correlationDtl.getRightElement().getColumnId());
                    join = onClauseBuilder.on(leftTable.getTablePrefix(), leftColumn.getColumnName())
                            .eq(rightTable.getTablePrefix(), rightColumn.getColumnName());
                }
                while (iterator.hasNext());
            }
        }

        List<Filter> filters = dataset.getFilters();
        Filter filter = null;
        Optional<ColumnElement> optionalSchoolYearElement = schoolProfilePrefixTable.getColumns().parallelStream()
                .filter(ce -> ce.getElementName().equals(SCHOOL_YEAR)) // find school year element
                .findFirst();
        ColumnElement schoolYearElement;
        if (optionalSchoolYearElement.isPresent()) {
            schoolYearElement = optionalSchoolYearElement.get();
        }
        else {
            DatasetElement schoolYearDatasetElement = elementRepository.findByDatasetHeadIdAndName(schoolProfilePrefixTable.getDatasetId(), SCHOOL_YEAR);

            schoolProfilePrefixTable.addColumn(
                    schoolYearElement = new ColumnElement(schoolYearDatasetElement, columnMetadataRepository.findOne(schoolYearDatasetElement.getColumnId()))
            );
        }
        for (Iterator<Filter> iterator = filters.iterator(); iterator.hasNext(); ) { // lookup and remove school year element
            filter = iterator.next();
            if (filter.getElement() == schoolYearElement.getElementId()) {
                iterator.remove();
                break;
            }
        }
        if (filter == null) { // school year filter not included from the user selection of filters
            filter = lookupSchoolFilter(schoolProfilePrefixTable, schoolYearElement.getElementId());
        }
        // set school year filter first before the other filters
        CriteriaFilterBuilder criteriaFilterBuilder = join.where(schoolProfilePrefixTable.getTablePrefix(), schoolYearElement.getColumnName());
        CriteriaChainBuilder criteriaChainBuilder;
        if (filter.getSelectedOptions() == null || filter.getSelectedOptions().isEmpty()) {
            criteriaChainBuilder = criteriaFilterBuilder.eq(getCurrentYear());
        }
        else {
            criteriaChainBuilder = criteriaFilterBuilder.eq(Integer.parseInt(String.valueOf(filter.getSelectedOptions().get(0).getKey())));
        }
        filters.forEach(f -> {
            DatasetCriteria criterion = criteriaRepository.findOne(f.getCriterion());
            DatasetElement datasetElement = criterion.getLeftElement();
            ColumnMetadata columnMetadata = columnMetadataRepository.findOne(datasetElement.getColumnId());
            String tablePrefix = tablePrefixMap.get(columnMetadata.getTableId());
            String dataType = columnMetadata.getDataType();
            FilterType filterType = criterion.getFilterType();
            switch (filterType) {
                case VALUES:
                    multipleValueFilter(criterion, f, criteriaFilterBuilder, criteriaChainBuilder, columnMetadata, tablePrefix, dataType);
                    break;
                default:
                    singleValueFilter(criterion, f, criteriaFilterBuilder, criteriaChainBuilder, columnMetadata, tablePrefix, dataType);
            }
        });

        Map<Long, List<String>> orderMap = lookupOrderElements();
        orderMap.entrySet().forEach(e -> {
            PrefixTable pt = prefixTables.stream()
                    .filter(table -> e.getKey().equals(table.getDatasetId()))
                    .findFirst().get();
            e.getValue().forEach(name -> {
                DatasetElement orderElement = elementRepository.findByDatasetHeadIdAndName(pt.getDatasetId(), name);
                ColumnMetadata orderColumn = columnMetadataRepository.findOne(orderElement.getColumnId());
                criteriaChainBuilder.orderBy(pt.getTablePrefix(), orderColumn.getColumnName(), true);
            });
        });

        StringBuilder sql = criteriaChainBuilder.build();
//        if (previewOnly) { // hack solution to limit returned rows if preview data requested.
//            sql.append(" LIMIT 20");
//        }
        
        return sql.toString();
	}

	@Override
	public LinkedList<PrefixTable> getPrefixTables(Dataset dataset) {
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
	        LinkedList<PrefixTable> prefixTables = map.entrySet().stream()
	                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
	                .map(entry -> {
	                    PrefixTable p = new PrefixTable(entry.getKey(), tableMetadataRepository.findOne(entry.getKey().getTableId()));
	                    entry.getValue().forEach(element -> {
	                        ColumnMetadata cm = columnMetadataRepository.findOne(element.getColumnId());
	                        ColumnElement ce = new ColumnElement(element, cm);
	                        p.addColumn(ce);
	                    });
	                    return p;
	                })
	                .collect(toCollection(LinkedList::new));
	        
	        lookupMandatoryDatasets(prefixTables);
	        
	        return prefixTables;
	}

	@Override
	public LinkedList<ColumnElement> getSortedColumns(LinkedList<PrefixTable> prefixTables) 
	{
		LinkedList<ColumnElement> sortedColumns = new LinkedList<>();
		List<ColumnElement> ces;
		ColumnElement columnElement;
		for (int i = 0; i < prefixTables.size(); i++) {
			PrefixTable pt = prefixTables.get(i);
            ces = new ArrayList<>(pt.getColumns());
            for (int j = 0; j < pt.getColumns().size(); j++) {
                columnElement = ces.get(j);
                sortedColumns.add(columnElement);
            }
        }
		
		return sortedColumns;
	}

	@Override
	public LinkedList<ColumnElement> getHeaders(
			LinkedList<ColumnElement> sortedColumns) {
		LinkedList<ColumnElement> headers = sortedColumns.stream()
                .map(ColumnElement::clone) // copy the original user selected column elements
                .map(ce -> {
                    ce.setValue(ce.getElementName()); // set the value as the element description
                    return ce;
                })
                .collect(toCollection(LinkedList::new));
		return headers;
	}

	@Override
	public List<List<ColumnElement>> getData(String sql,
			LinkedList<PrefixTable> prefixTables,
			LinkedList<ColumnElement> sortedColumns,
			LinkedList<ColumnElement> headers) {
		
		List<List<ColumnElement>> data=getData(sql, prefixTables, sortedColumns);
		data.add(0, headers);
		return data;
	}

}
