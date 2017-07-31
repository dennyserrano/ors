package ph.gov.deped.common.query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.config.TestAppConfig;
import ph.gov.deped.data.ebeis.RefOffice;
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
	
	@Test
	public void test()
	{
		RefOffice o=new RefOffice();
		o.setOfficeType((short)191);
		System.out.println(repo.findByOfficeTypeAndParentOffice((short)193, 870).size());
		
		
	}
}
