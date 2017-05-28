package ph.gov.deped.common.query;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ph.gov.deped.common.util.builders.StarSchemaChainImpl;
import ph.gov.deped.common.util.builders.TableChainer;
import ph.gov.deped.config.TestAppConfig;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.ors.ds.DatasetCorrelationDtl;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroupDtl;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;
import ph.gov.deped.service.data.api.DatasetService;
import ph.gov.deped.service.data.api.ServiceQueryBuilder;
import ph.gov.deped.service.data.impl.ServiceQueryBuilderImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
        TestAppConfig.class
})
public class QueryDirectionTest 
{
	@Autowired
	private DatasetRepository datasetRepo;
	
	private TableChainer tableChainer=new StarSchemaChainImpl();
	
	@Test
	public void test()
	{
		DatasetHead parent=datasetRepo.findByIds(Arrays.asList(8L)).get(0);
		
    	List<DatasetHead> children=datasetRepo.findByIds(Arrays.asList(9015L,9016L));
    	PrefixTable pt=tableChainer.chain(parent, children);
    	ServiceQueryBuilder sq=new ServiceQueryBuilderImpl();
    	System.out.println(sq.getQuery(pt));
	}
	
}
