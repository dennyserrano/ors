package ph.gov.deped.repo.jpa.ors.ds;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import ph.gov.deped.data.ebeis.RefLegislative;

@Repository
@RepositoryDefinition(domainClass = RefLegislative.class, idClass = Short.class)
public interface RefLegislativeRepository {

}
