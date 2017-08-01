package ph.gov.deped.service.data.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bits.sql.FilterType;
import com.bits.sql.Operator;
import com.fasterxml.jackson.annotation.JsonProperty;

import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.config.FilterSettings;
import ph.gov.deped.data.dto.KeyValue;
import ph.gov.deped.data.dto.ds.Criterion;
import ph.gov.deped.data.dto.ds.Filter;
import ph.gov.deped.data.ebeis.RefLegislative;
import ph.gov.deped.data.ebeis.RefMunicipality;
import ph.gov.deped.data.ebeis.RefOffice;
import ph.gov.deped.data.ebeis.RefProvince;
import ph.gov.deped.data.ors.ds.DatasetCriteria;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.ors.ds.CriteriaRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;
import ph.gov.deped.repo.jpa.ors.ds.RefLegislativeRepository;
import ph.gov.deped.repo.jpa.ors.ds.RefMunicipalityRepository;
import ph.gov.deped.repo.jpa.ors.ds.RefOfficeRepository;
import ph.gov.deped.repo.jpa.ors.ds.RefProvinceRepository;
import ph.gov.deped.service.data.api.CriteriaService;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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

    @Autowired
    private RefOfficeRepository refOfficeRepository;
    
    @Autowired
    private RefProvinceRepository refProvinceRepository;
    
    @Autowired
    private RefMunicipalityRepository refMunicipalityRepository;
    
    @Autowired
    private RefLegislativeRepository refLegislativeRepository;
    
    
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
        filterValueMap.put("8:sy_from", criteriaRepository::getSchoolYears);
        filterValueMap.put("8:school_type_id", criteriaRepository::getSchoolTypes);
        filterValueMap.put("8:sector_id", criteriaRepository::getGeneralClassifications);
        filterValueMap.put("8:level_of_education_id", criteriaRepository::getGeneralCurricularOfferings);
        filterValueMap.put("8:region_id", criteriaRepository::getRegionsAndDivisions);
        filterValueMap.put("8:division_id", Collections::emptyList);
        filterValueMap.put("8:school_id", () -> new ArrayList<>(asList(new KeyValue("", ""))));
        filterValueMap.put("8:school_classification_id", ()->new ArrayList<>());
        filterValueMap.put("8:coc_id", ()->new ArrayList<>());
        filterValueMap.put("8:district_id", ()->new ArrayList<>());
        filterValueMap.put("8:province_id", ()->new ArrayList<>());
        filterValueMap.put("8:municipality_id", ()->new ArrayList<>());
        filterValueMap.put("8:legislative_id", ()->new ArrayList<>());
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<Criterion> findDatasetHeadCriteria(long headId) {
        DatasetHead datasetHead = datasetRepository.findOne(headId);
        List<DatasetCriteria> criterias = criteriaRepository.findByDatasetHeadAndVisible(datasetHead, true);

        if (criterias == null) {
            return Collections.emptyList();
        }
        
        
        
        return criterias.stream()
                .map(c ->
                		new Criterion(c.getId(), c.getFilterName(), c.getFilterType(), c.getLeftElement().getId(), c.getOperator(),
                        c.getInputType().ordinal(), c.getLabel(), filterValueMap.get(c.getDatasetHead().getId() + ":" + c.getLeftElement().getName()).get()))
                .collect(toList());
    }
    
    public List<KeyValue> searchSchools(Map<Long, String> filters) {
        int schoolYear = Integer.parseInt(filters.get(new Long(filterSettings.getSchoolYearId())));
        int levelOfEducation = Integer.parseInt(filters.get(new Long(filterSettings.getLevelOfEducationId())));
        String sectorStr = filters.get(new Long(filterSettings.getSectorId()));
        Integer sectorId = isBlank(sectorStr) ? null : Integer.parseInt(sectorStr);
        String regionStr = filters.get(new Long(filterSettings.getRegionId()));
        Integer regionId = isBlank(regionStr) ? null : Integer.parseInt(regionStr);
        String divisionStr = filters.get(new Long(filterSettings.getDivisionId()));
        Integer divisionId = isBlank(divisionStr) ? null : Integer.parseInt(divisionStr);
        String schoolName = filters.get(new Long(filterSettings.getSchoolNameId()));
        return criteriaRepository.searchSchool(schoolYear, levelOfEducation, sectorId, regionId, divisionId, schoolName);
    }
    
    private Optional<Filter> findFilter(long filterId, List<Filter> filters) {
        return filters.parallelStream()
                .filter(f -> f.getCriterion() == filterId)
                .findFirst();
    }

    
    

	@Override
	public List<KeyValue> findProvinces(long regionId) {
		
		List<RefProvince> l=refProvinceRepository.findByRefRegionId((short)regionId);
		return l.stream().map(e->{
			return new KeyValue(e.getId().toString(), e.getProvinceName());
		}).collect(Collectors.toList());
		
	}

	@Override
	public List<KeyValue> findMunicipalities(long provinceId, long regionId) {
		
		List<RefMunicipality> l=refMunicipalityRepository.listBy((short)regionId, (short)provinceId);
		return l.stream().map(e->{
			return new KeyValue(e.getId().toString(), e.getMunicipalityName());
		}).collect(Collectors.toList());
	}

	@Override
	public List<KeyValue> findLegislatives(long provinceId, long regionId) {
		
		List<RefLegislative> l=refLegislativeRepository.listBy((short)regionId, (short)provinceId);
		return l.stream().map(e->{
			return new KeyValue(e.getId().toString(), e.getDistrictLabel().getDescription());
		}).collect(Collectors.toList());
	}

	@Override
	public List<KeyValue> findDistricts(long divisionId, long regionId) {
		List<RefOffice> l=refOfficeRepository.findByOfficeTypeAndParentOfficeAndRefRegionId((short)193, (short)divisionId, (short)regionId);
		
		return l.stream().map(e->{
			return new KeyValue(e.getId().toString(), e.getOfficeName());
		}).collect(Collectors.toList());
	}
}
