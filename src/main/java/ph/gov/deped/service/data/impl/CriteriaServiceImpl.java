package ph.gov.deped.service.data.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.data.dto.KeyValue;
import ph.gov.deped.data.dto.ds.Criterion;
import ph.gov.deped.data.ors.ds.DatasetCriteria;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.ors.ds.CriteriaRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;
import ph.gov.deped.service.data.api.CriteriaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

/**
 * Created by PSY on 2014/10/03.
 */
public @Service class CriteriaServiceImpl implements CriteriaService, InitializingBean {

    private DatasetRepository datasetRepository;

    private CriteriaRepository criteriaRepository;

    private final Map<String, Supplier<List<KeyValue>>> filterValueMap = new HashMap<>();

    public @Autowired void setDatasetRepository(DatasetRepository datasetRepository) {
        this.datasetRepository = datasetRepository;
    }

    public @Autowired void setCriteriaRepository(CriteriaRepository criteriaRepository) {
        this.criteriaRepository = criteriaRepository;
    }

    public void afterPropertiesSet() throws Exception {
        // set filter values as constant from now. see CriteriaRepositoryImpl.
        // head id and element name separated by colon (:) to be used as key
        filterValueMap.put("2:school_year", criteriaRepository::getSchoolYears);
        filterValueMap.put("2:school_type", criteriaRepository::getSchoolTypes);
        filterValueMap.put("2:sector_id", criteriaRepository::getGeneralClassifications);
        filterValueMap.put("2:level_of_education_id", criteriaRepository::getGeneralCurricularOfferings);
        filterValueMap.put("2:region_id", criteriaRepository::getRegionsAndDivisions);
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<Criterion> findDatasetHeadCriteria(long headId) {
        DatasetHead datasetHead = datasetRepository.findOne(headId);
        List<DatasetCriteria> criterias = criteriaRepository.findByDatasetHead(datasetHead);

        return criterias.parallelStream()
                .map(c -> new Criterion(c.getId(), c.getFilterName(), c.getLeftElement().getId(), c.getOperator(),
                        filterValueMap.get(c.getDatasetHead().getId() + ":" + c.getLeftElement().getName()).get()))
                .collect(toList());
    }
}
