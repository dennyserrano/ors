package ph.gov.deped.repo.jpa.ors.ds;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import ph.gov.deped.data.ebeis.RefLegislative;
import ph.gov.deped.data.ebeis.RefMunicipality;
import ph.gov.deped.data.ebeis.RefOffice;
import ph.gov.deped.data.ebeis.RefProvince;
import ph.gov.deped.data.ebeis.RefRegion;



@Repository
@RepositoryDefinition(domainClass = RefProvince.class, idClass = Short.class)
public interface RefProvinceRepository {

	public List<RefProvince> findByRefRegionId(short regionId);
}
