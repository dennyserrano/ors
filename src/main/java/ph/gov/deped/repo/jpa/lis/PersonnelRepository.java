package ph.gov.deped.repo.jpa.lis;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ph.gov.deped.data.lis.LisPersonnelHk;

/**
 * Created by ej on 8/7/14.
 */
@Repository
@RepositoryDefinition(domainClass = LisPersonnelHk.class, idClass = Long.class)
public interface PersonnelRepository extends PagingAndSortingRepository<LisPersonnelHk, Long> {
}
