package com.repo.meta;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import com.model.db.DatasetCriteria;
import com.model.db.DatasetElement;
import com.model.db.DatasetHead;
import com.repo.base.BaseJpaRepository;

import java.util.List;

/**
 * Created by ej on 8/19/14.
 */
@Repository
@RepositoryDefinition(domainClass = DatasetCriteria.class, idClass = Long.class)
public interface CriteriaRepository extends BaseJpaRepository<DatasetCriteria, Long> {//, DefaultCriteriaRepository {

    List<DatasetCriteria> findByDatasetHead(DatasetHead datasetHead);
    
    List<DatasetCriteria> findByDatasetHeadId(long datasetHeadId);
    
    List<DatasetCriteria> findByDatasetHeadAndVisible(DatasetHead datasetHead, boolean visible);

    List<DatasetCriteria> findByLeftElement(DatasetElement leftElement);

    List<DatasetCriteria> findByDatasetHeadAndLeftElement(DatasetHead datsetHead, DatasetElement leftElement);

    List<DatasetCriteria> findByDatasetHeadIdAndLeftElementId(long datasetHeadId, long leftElementId);
}
