package ph.gov.deped.repo.jpa.ors.ds;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import ph.gov.deped.data.ebeis.RefLegislative;

@Repository
@RepositoryDefinition(domainClass = RefLegislative.class, idClass = Short.class)
public interface RefLegislativeRepository {
	
	public List<RefLegislative> listBy(short regionId,short provinceId);
	
}
