package ph.gov.deped.common.query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ph.gov.deped.config.ApplicationSpringConfig;
import ph.gov.deped.data.dto.KeyValue;
import ph.gov.deped.repo.jpa.ors.ds.CriteriaRepository;
import ph.gov.deped.service.export.ExporterSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
        ApplicationSpringConfig.class,
        ExporterSpringConfig.class
})
public class CriteriaTest 
{
	
	
	@Autowired
	CriteriaRepository cr;
	
	@Test
	public void test()
	{
		for (KeyValue kv:cr.getGeneralClassifications())
		{
			System.out.println(kv.getValue());
			
			for(KeyValue kv2:kv.getChildKeyValues())
				System.out.println(kv2.getValue());
		}
	}
}
