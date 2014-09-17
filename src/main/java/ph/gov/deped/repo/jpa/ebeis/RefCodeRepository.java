package ph.gov.deped.repo.jpa.ebeis;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ph.gov.deped.data.ebeis.RefCode;
import ph.gov.deped.repo.jpa.api.BaseJpaRepository;

/**
 * Created by ej on 8/7/14.
 */
@Repository
@RepositoryDefinition(domainClass = RefCode.class, idClass = Short.class)
public interface RefCodeRepository extends BaseJpaRepository<RefCode, Short> {
}
