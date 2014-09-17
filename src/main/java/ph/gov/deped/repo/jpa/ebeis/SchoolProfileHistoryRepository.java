package ph.gov.deped.repo.jpa.ebeis;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ph.gov.deped.data.ebeis.SchoolProfileHistory;
import ph.gov.deped.repo.jpa.api.BaseJpaRepository;

import java.util.List;

/**
 * Created by ej on 8/8/14.
 */
@Repository
@RepositoryDefinition(domainClass = SchoolProfileHistory.class, idClass = Integer.class)
public interface SchoolProfileHistoryRepository extends BaseJpaRepository<SchoolProfileHistory, Integer> {

    List<SchoolProfileHistory> findBySyFrom(int syFrom);
}
