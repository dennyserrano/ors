package ph.gov.deped.repo.jpa.ors.ds;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ph.gov.deped.data.ors.ds.DatasetCriteria;
import ph.gov.deped.repo.jpa.api.BaseJpaRepository;

/**
 * Created by ej on 8/19/14.
 */
@Repository
@RepositoryDefinition(domainClass = DatasetCriteria.class, idClass = Long.class)
public interface CriteriaRepository extends BaseJpaRepository<DatasetCriteria, Long> {
}
