package ph.gov.deped.repo.jpa.ebeis;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ph.gov.deped.data.ebeis.RefCodeSetting;
import ph.gov.deped.repo.jpa.api.BaseJpaRepository;

/**
 * Created by ej on 8/13/14.
 */
@Repository
@RepositoryDefinition(domainClass = RefCodeSetting.class, idClass = Short.class)
public interface RefCodeSettingRepository extends BaseJpaRepository<RefCodeSetting, Short> {
}
