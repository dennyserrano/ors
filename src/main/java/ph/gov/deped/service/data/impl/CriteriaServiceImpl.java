package ph.gov.deped.service.data.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.config.FilterSettings;
import ph.gov.deped.data.dto.KeyValue;
import ph.gov.deped.data.dto.ds.Criterion;
import ph.gov.deped.data.dto.ds.Filter;
import ph.gov.deped.data.ors.ds.DatasetCriteria;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.ors.ds.CriteriaRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;
import ph.gov.deped.service.data.api.CriteriaService;

import java.util.*;
import java.util.function.Supplier;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by PSY on 2014/10/03.
 */
public @Service class CriteriaServiceImpl implements CriteriaService, InitializingBean {

    private final Map<String, Supplier<List<KeyValue>>> filterValueMap = new TreeMap<>();

    private DatasetRepository datasetRepository;

    private CriteriaRepository criteriaRepository;
    
    private FilterSettings filterSettings;

    public @Autowired void setDatasetRepository(DatasetRepository datasetRepository) {
        this.datasetRepository = datasetRepository;
    }

    public @Autowired void setCriteriaRepository(CriteriaRepository criteriaRepository) {
        this.criteriaRepository = criteriaRepository;
    }

    public @Autowired void setFilterSettings(FilterSettings filterSettings) {
        this.filterSettings = filterSettings;
    }

    public void afterPropertiesSet() throws Exception {
        // set filter values as constant from now. see CriteriaRepositoryImpl.
        // head id and element name separated by colon (:) to be used as key
        filterValueMap.put("8:school_year", criteriaRepository::getSchoolYears);
        filterValueMap.put("8:school_type_id", criteriaRepository::getSchoolTypes);
        filterValueMap.put("8:sector_id", criteriaRepository::getGeneralClassifications);
        filterValueMap.put("8:level_of_education_id", criteriaRepository::getGeneralCurricularOfferings);
        filterValueMap.put("8:region_id", criteriaRepository::getRegionsAndDivisions);
        filterValueMap.put("8:division_id", Collections::emptyList);
        filterValueMap.put("8:school_id", () -> new ArrayList<>(asList(new KeyValue("", ""))));
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<Criterion> findDatasetHeadCriteria(long headId) {
        DatasetHead datasetHead = datasetRepository.findOne(headId);
        List<DatasetCriteria> criterias = criteriaRepository.findByDatasetHeadAndVisible(datasetHead, true);

        if (criterias == null) {
            return Collections.emptyList();
        }
        return criterias.stream()
                .map(c -> new Criterion(c.getId(), c.getFilterName(), c.getFilterType(), c.getLeftElement().getId(), c.getOperator(), c.getInputType(),
                        c.getLabel(), filterValueMap.get(c.getDatasetHead().getId() + ":" + c.getLeftElement().getName()).get()))
                .collect(toList());
    }
    
    public List<KeyValue> searchSchoolNames(List<Filter> filters) {
        Optional<Filter> schoolYearOptional = findFilter(filterSettings.getSchoolYearId(), filters);
        String schoolYearStr = criteriaRepository.getSchoolYears().get(0).getKey();
        if (schoolYearOptional.isPresent()) {
            schoolYearStr = String.valueOf(schoolYearOptional.get().getSelectedOption().getKey());
        }
        int schoolYear = Integer.parseInt(schoolYearStr);
        
        Optional<Filter> levelOfEduOptional = findFilter(filterSettings.getLevelOfEducationId(), filters);
        String levelOfEduStr = criteriaRepository.getGeneralCurricularOfferings().get(0).getKey();
        if (levelOfEduOptional.isPresent()) {
            levelOfEduStr = String.valueOf(levelOfEduOptional.get().getSelectedOption().getKey());
        }
        int levelOfEducation = Integer.parseInt(levelOfEduStr);
        
        Optional<Filter> sectorOptional = findFilter(filterSettings.getSectorId(), filters);
        Integer sectorId = null;
        if (sectorOptional.isPresent()) {
            String sectorStr = String.valueOf(sectorOptional.get().getSelectedOption().getKey());
            sectorId = new Integer(sectorStr);
        }
        
        Optional<Filter> schoolNameOptional = findFilter(filterSettings.getSchoolNameId(), filters);
        String schoolName = "";
        if (schoolNameOptional.isPresent()) {
            schoolName = String.valueOf(schoolNameOptional.get().getSelectedOption().getKey());
        }
        
        Optional<Filter> regionFilter = findFilter(filterSettings.getRegionId(), filters);
        Integer regionId = null;
        if (regionFilter.isPresent() && regionFilter.get().getSelectedOption() != null) {
            String regionStr = String.valueOf(regionFilter.get().getSelectedOption().getKey());
            if (!isBlank(regionStr)) {
                regionId = new Integer(regionStr);
            }
        }

        Optional<Filter> divisionFilter = findFilter(filterSettings.getDivisionId(), filters);
        Integer divisionId = null;
        if (divisionFilter.isPresent() && divisionFilter.get().getSelectedOption() != null) {
            String divisionStr = String.valueOf(divisionFilter.get().getSelectedOption().getKey());
            if (!isBlank(divisionStr)) {
                divisionId = new Integer(divisionStr);
            }
        }
        
        return criteriaRepository.searchSchool(schoolYear, levelOfEducation, sectorId, regionId, divisionId, schoolName);
    }
    
    private Optional<Filter> findFilter(long filterId, List<Filter> filters) {
        return filters.parallelStream()
                .filter(f -> f.getCriterion() == filterId)
                .findFirst();
    }
}
