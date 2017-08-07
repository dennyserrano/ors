package ph.gov.deped.common.query;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.config.TestAppConfig;
import ph.gov.deped.data.ebeis.RefLegislative;
import ph.gov.deped.data.ebeis.RefMunicipality;
import ph.gov.deped.data.ebeis.RefOffice;
import ph.gov.deped.repo.jpa.ors.ds.RefLegislativeRepository;
import ph.gov.deped.repo.jpa.ors.ds.RefMunicipalityRepository;
import ph.gov.deped.repo.jpa.ors.ds.RefOfficeRepository;
import ph.gov.deped.repo.jpa.ors.ds.RefProvinceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
        TestAppConfig.class
})
public class QueryTest 
{
	
	@Autowired
	RefOfficeRepository repo;
	
	@Autowired
	RefMunicipalityRepository repoMunicipality;
	
	@Autowired
	RefLegislativeRepository repoLegis;
	
	@Autowired
	RefOfficeRepository repoOffice;
	
	@Test
	public void test()
	{
//		List<RefLegislative> l=repoOffice.findByOfficeTypeAndParentOfficeAndRefRegionId(officeType, parentOffice, regionId)
//		System.out.println(l.size());
	}
}
