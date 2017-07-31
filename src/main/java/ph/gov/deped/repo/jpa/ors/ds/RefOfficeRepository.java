package ph.gov.deped.repo.jpa.ors.ds;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import ph.gov.deped.data.ebeis.RefOffice;

@Repository
@RepositoryDefinition(domainClass = RefOffice.class, idClass = Short.class)
public interface RefOfficeRepository {
	public List<RefOffice> findByOfficeTypeAndParentOffice(short officeTyp, int parentOffice);
}
