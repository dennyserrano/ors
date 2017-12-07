package ph.gov.deped.common.query;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bits.sql.JoinType;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.repo.meta.CriteriaRepository;
import com.repo.meta.DatasetRepository;
import com.thoughtworks.xstream.XStream;

import ph.gov.deped.config.ApplicationSpringConfig;
import ph.gov.deped.config.TestAppConfig;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.ds.Dataset;
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
	
//	@Autowired
//	DatasetService datasetService;
	
	@Autowired
	CriteriaRepository cr;
	@Test
//	@Ignore
	public void test() throws JsonParseException, JsonMappingException, IOException
	{
		dr.countByParentDatasetHead(8L);
//		XStream xs=new XStream();
//		Dataset ds=(Dataset) xs.fromXML(new File("/home/denny/dataset.xml"));
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
		
//		datasetService.getData(ds, false);
//		DatasetCriteria dc=cr.findOne(8L);
//		System.out.println();
	}
	
	public void t()
	{
		
//		JoinOperator op1=new JoinOperator();
//		JoinInfo ji1= new JoinInfoBuilder().build(new ColumnElement(null, null), new ColumnElement(null, null));
//		op1.setJoinInfo(ji1);
////		JoinProperty jp1=new JoinProperty(JoinType.LEFT_JOIN,ji1);
//		
//		
//		JoinOperator op2=new JoinOperator();
//		JoinInfo ji2=new JoinInfoBuilder().build(new ColumnElement(null, null), new ColumnElement(null, null));
//		op2.setJoinInfo(ji2);
//		ji1.setNext(op2);
//		
//		
//		JoinOperator op3=new JoinOperator();
//		JoinInfo ji3=new JoinInfoBuilder().build(new ColumnElement(null, null), new ColumnElement(null, null));
//		op3.setJoinInfo(ji3);
//		
//		ji2.setNext(op3);
		
		
		
		
		
//		PrefixTable pt=new PrefixTable(null,null,null);
		
		
		
		
		
//		pt.setJoinColumns(new ArrayList<>());
//		pt.getJoinColumns().add(new JoinInfo<>());
	}
}
