package ph.gov.deped.common.query;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ph.gov.deped.config.ApplicationSpringConfig;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.data.ors.meta.TableMetadata;
import ph.gov.deped.repo.jpa.ors.ds.CriteriaRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;
import ph.gov.deped.service.export.ExporterSpringConfig;
import ph.gov.deped.service.meta.api.MetadataService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
        ApplicationSpringConfig.class,
        ExporterSpringConfig.class
})
public class CriteriaQueryTest 
{
	
	@Autowired
	CriteriaRepository rep;
	
	@Autowired
	MetadataService mds;
	
	@Autowired
	DatasetRepository dr;
	
	@Test
	public void test()
	{
		long l=9015L;
//		DatasetHead dh=dr.findOne(3L);
		DatasetHead dh=dr.findOne(3L);
//		
//		for(DatasetHead idh:dh)
//		{
//			for(DatasetElement de:idh.getDatasetElements())
//				{
//					System.out.println(de.getName()+" "+de.getColumnMetaData().getColumnName());
//					
//				}
//		}
//		System.out.println(dh.getDatasetElements().size());
		System.out.println();
//		TableMetadata tm=dh.getTableMetadata();
//		System.out.println();
	}
}
