package com.repo.meta;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import com.model.db.DatasetCorrelation;
import com.model.db.DatasetHead;
import com.repo.base.BaseJpaRepository;

import java.util.List;

/**
 * Created by PSY on 2014/09/30.
 */
@Repository
@RepositoryDefinition(domainClass = DatasetCorrelation.class, idClass = Long.class)
public interface CorrelationRepository {//extends BaseJpaRepository<DatasetCorrelation, Long> {

    DatasetCorrelation findByLeftDatasetAndRightDataset(DatasetHead leftDataset, DatasetHead rightDataset);

    List<DatasetCorrelation> findByLeftDataset(DatasetHead datasetHead);

    DatasetCorrelation findByLeftDatasetIdAndRightDatasetId(long leftDatasetId, long rightDatasetId);
}
