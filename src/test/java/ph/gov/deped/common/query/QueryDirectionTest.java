package ph.gov.deped.common.query;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ph.gov.deped.config.TestAppConfig;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
        TestAppConfig.class
})
public class QueryDirectionTest 
{
	@Autowired
	private DatasetRepository datasetRepo;
	
	@Test
	public void test()
	{
		
		List<DatasetHead> l=datasetRepo.findByIds(Arrays.asList(8L));
		DatasetHead dh=l.get(0);
		for(DatasetElement de:dh.getDatasetElements())
		{
			System.out.println();
		}
		System.out.println();
	}
	
}
