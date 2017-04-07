package ph.gov.deped.common.query;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;

import ph.gov.deped.common.util.PrefixTableMapBuilder;
import ph.gov.deped.config.ApplicationSpringConfig;
import ph.gov.deped.config.TestAppConfig;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.data.ors.meta.TableMetadata;
import ph.gov.deped.repo.jpa.ors.ds.CriteriaRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;
import ph.gov.deped.service.data.api.DatasetService;
import ph.gov.deped.service.export.ExporterSpringConfig;
import ph.gov.deped.service.meta.api.MetadataService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
        TestAppConfig.class
})
public class CriteriaQueryTest 
{
	
	@Autowired
	CriteriaRepository rep;
	
	@Autowired
	MetadataService mds;
	
	@Autowired
	DatasetRepository dr;
	
	@Autowired
	DatasetService datasetService;
	
	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException
	{
		
		XStream xs=new XStream();
		Dataset ds=(Dataset) xs.fromXML(new File("/home/denny/dataset.xml"));
//		
//		long[] ids = new long[ds.getSubDatasets().size()];
//		
//		for(int x=0;x<ds.getSubDatasets().size();x++)
//			{
//				Dataset localDataset=ds.getSubDatasets().get(x);
//				ids[x]=localDataset.getId();
//			}
//		List<DatasetHead> list=dr.findByIds(ids);
//
//		System.out.println();
		
		datasetService.getData(ds, false);

	}
}
