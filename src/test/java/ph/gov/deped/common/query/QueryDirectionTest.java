package ph.gov.deped.common.query;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thoughtworks.xstream.XStream;

import ph.gov.deped.common.util.builders.StarSchemaChainImpl;
import ph.gov.deped.common.util.builders.TableChainer;
import ph.gov.deped.config.TestAppConfig;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.dto.ds.Filter;
import ph.gov.deped.data.ors.ds.DatasetCorrelationDtl;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroupDtl;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;
import ph.gov.deped.repo.jpa.ors.ds.ElementRepository;
import ph.gov.deped.service.data.api.DatasetService;
import ph.gov.deped.service.data.api.ServiceQueryBuilder;
import ph.gov.deped.service.data.impl.ServiceQueryBuilderImpl;
import ph.gov.deped.service.meta.api.MetadataService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
        TestAppConfig.class
})
public class QueryDirectionTest 
{
	@Autowired
	private DatasetRepository datasetRepo;
	
	private TableChainer tableChainer=new StarSchemaChainImpl();
	@Autowired
	DatasetService datasetService;
	
	@Autowired
	MetadataService metadataService;
	
//	@Test
	public void test()
	{
		XStream xs=new XStream();
		Dataset ds=(Dataset) xs.fromXML(new File("/home/denny/dataset.xml"));
		List<Filter> filters=ds.getFilters();
		
		ds.setSubDatasets(new ArrayList<Dataset>());
		
		
		int x=1;
		long start=System.currentTimeMillis();
		
		for(DatasetHead childrenDH:datasetRepo.findAll())
		{
			if(childrenDH.getParentDatasetHead()==null)
				continue;

			ds.getSubDatasets().add(new Dataset(childrenDH.getId(), null, null, null));
			
			datasetService.getData(ds, true);
			x++;
			if(x==20)
				break;
			
			System.out.println("==================PASSSSSS====================");
		}
		
    	long end=System.currentTimeMillis();
    	System.out.println("HOOOOYYYYY::"+" "+(end-start));
	}
	
	@Test
	public void test2()
	{
		List<Element> list=metadataService.findElements(8L);
		for(Element e:list)
			System.out.println(e.getName()+" "+ e.isAggregatable());
	}
	
//	DatasetHead parent=datasetRepo.findByIds(Arrays.asList(8L)).get(0);
//	List<DatasetHead> children=datasetRepo.findByIds(Arrays.asList(childrenDH.getId()));
//	PrefixTable pt=tableChainer.chain(parent, children,filters);
//	ServiceQueryBuilder sq=new ServiceQueryBuilderImpl();
//	System.out.println("=============================================="+sq.getQuery(pt));
}
