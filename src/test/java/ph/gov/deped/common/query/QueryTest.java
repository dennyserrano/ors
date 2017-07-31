package ph.gov.deped.common.query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.config.TestAppConfig;
import ph.gov.deped.data.ebeis.RefOffice;
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
	
	@Test
	public void test()
	{
		repoMunicipality.listBy((short)129, provinceId)
	}
}
