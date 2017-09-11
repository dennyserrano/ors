package ph.gov.deped.repo.jpa.ors.ds;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ph.gov.deped.data.ors.ds.DatasetCriteria;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.api.BaseJpaRepository;

import java.util.List;

/**
 * Created by ej on 8/19/14.
 */
@Repository
@RepositoryDefinition(domainClass = DatasetCriteria.class, idClass = Long.class)
public interface CriteriaRepository extends BaseJpaRepository<DatasetCriteria, Long>, DefaultCriteriaRepository {

    List<DatasetCriteria> findByDatasetHead(DatasetHead datasetHead);
    
    List<DatasetCriteria> findByDatasetHeadId(long datasetHeadId);
    
    List<DatasetCriteria> findByDatasetHeadAndVisible(DatasetHead datasetHead, boolean visible);

    List<DatasetCriteria> findByLeftElement(DatasetElement leftElement);

    List<DatasetCriteria> findByDatasetHeadAndLeftElement(DatasetHead datsetHead, DatasetElement leftElement);

    List<DatasetCriteria> findByDatasetHeadIdAndLeftElementId(long datasetHeadId, long leftElementId);
}
