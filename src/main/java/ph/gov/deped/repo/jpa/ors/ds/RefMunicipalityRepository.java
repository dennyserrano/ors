package ph.gov.deped.repo.jpa.ors.ds;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import ph.gov.deped.data.ebeis.RefOffice;



@Repository
@RepositoryDefinition(domainClass = RefOffice.class, idClass = Long.class)
public interface RefMunicipalityRepository {

}
