package ph.gov.deped.repo.jpa.ors.ds;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ph.gov.deped.data.ors.ds.DatasetCorrelation;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.api.BaseJpaRepository;

/**
 * Created by PSY on 2014/09/30.
 */
@Repository
@RepositoryDefinition(domainClass = DatasetCorrelation.class, idClass = Long.class)
public interface DatasetCorrelationRepository extends BaseJpaRepository<DatasetCorrelation, Long> {

    DatasetCorrelation findByLeftDatasetAndRightDataset(DatasetHead leftDataset, DatasetHead rightDataset);
}
