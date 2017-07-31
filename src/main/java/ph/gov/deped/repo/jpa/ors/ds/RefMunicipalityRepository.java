package ph.gov.deped.repo.jpa.ors.ds;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import ph.gov.deped.data.ebeis.RefMunicipality;
import ph.gov.deped.data.ebeis.RefOffice;



@Repository
@RepositoryDefinition(domainClass = RefOffice.class, idClass = Long.class)
public interface RefMunicipalityRepository {

	
	@Query("from RefProvince rp "
		 + "left join rp.refMunicipalityList "
		 + "where refRegionId=1? and "
		 + "refProvinceId=2?")
	public List<RefMunicipality> listBy(short regionId,short provinceId);
	
}
