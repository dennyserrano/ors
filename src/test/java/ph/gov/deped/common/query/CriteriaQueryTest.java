package ph.gov.deped.common.query;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bits.sql.JoinType;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.db.DatasetCriteria;
import com.model.db.DatasetElement;
import com.model.db.DatasetHead;
import com.model.db.TableMetadata;
import com.thoughtworks.xstream.XStream;

import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.common.util.builders.impl.ColumnElement;
import ph.gov.deped.common.util.builders.impl.ColumnExpression;
import ph.gov.deped.common.util.builders.impl.DatasetSourceImpl;
import ph.gov.deped.common.util.builders.impl.FilterWhereBuilderFactory;
import ph.gov.deped.common.util.builders.impl.JoinInfo;
import ph.gov.deped.common.util.builders.impl.JoinInfoBuilder;
import ph.gov.deped.common.util.builders.impl.JoinProperty;
import ph.gov.deped.common.util.builders.impl.PrefixTable;
import ph.gov.deped.common.util.builders.interfaces.FilterWhere;
import ph.gov.deped.common.util.builders.interfaces.PrefixTableBuilder;
import ph.gov.deped.config.ApplicationSpringConfig;
import ph.gov.deped.config.TestAppConfig;
import ph.gov.deped.data.dto.JoinOperator;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.repo.jpa.ors.ds.CriteriaRepository;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;
import ph.gov.deped.service.data.api.DatasetService;
import ph.gov.deped.service.data.impl.ServiceQueryBuilderImpl;
import ph.gov.deped.service.data.impl.SqlToData;
import ph.gov.deped.service.export.ExporterSpringConfig;
import ph.gov.deped.service.meta.api.MetadataService;
import scala.runtime.StringFormat;

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
	
	@Autowired
	CriteriaRepository cr;
	
	@Autowired @Qualifier(AppMetadata.DS)
	private DataSource dataSource;
	
	@Autowired
	SqlToData std;
	
	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException
	{
		DatasetHead parent=dr.findByIds(Arrays.asList(8L)).get(0);
		List<DatasetHead> allDatasets=dr.findAll();
		Dataset parentDS=new Dataset(parent.getId(), "", "", 0L);
		parentDS.setSubDatasets(new ArrayList<Dataset>());
		HashMap<Long,DatasetHead> hm=new HashMap<Long, DatasetHead>();
		
		for(DatasetHead child:allDatasets)
		{
			
			List<DatasetHead> temp=dr.findByIds(Arrays.asList(child.getId()));
			
			if(temp.size()==0)
				continue;
			
			if(temp.get(0).getDatasetElements().size()==0)
				continue;
			
			if(temp.get(0).getParentDatasetHead()==null)
				continue;
			
			mapElems(parentDS, parent);
			hm.put(parent.getId(), parent);
			parentDS.getSubDatasets().add(new Dataset(child.getId(),"","",0L));
			DatasetHead queryChild=temp.get(0);
			
			mapElems(parentDS,queryChild);
			hm.put(queryChild.getId(), queryChild);
			PrefixTable pt=new DatasetSourceImpl(parentDS, hm).build();
			JdbcTemplate template = new JdbcTemplate(dataSource);
			String sql=new ServiceQueryBuilderImpl().getQuery(pt).concat(" LIMIT 1 ");

			
//			if(queryChild.getName().equals("SPED School Profile") || 
//					queryChild.getName().equals("Learners with Learning Disability")||
//					queryChild.getName().equals("Learners with Hearing Impairment") ||
//					queryChild.getName().equals("School Site Data") ||
//					queryChild.getName().equals("Total Enrolment By Area of Exceptionality")||
//					queryChild.getName().equals("Learners with Visual Impairment - Blindness"))
//				continue;
			
			System.out.println(String.format("%s:%s", queryChild.getName(),sql));
			
			try{
				template.query(sql, new ResultSetExtractor(){

					@Override
					public Object extractData(ResultSet arg0) throws SQLException,
							DataAccessException {
						// TODO Auto-generated method stub
						return null;
					}});
			}catch(Exception e)
			{
				System.out.println("=============="+queryChild.getName()+"==============");
			}
//			std.get(new ServiceQueryBuilderImpl().getQuery(pt), collect(new ArrayList<>(pt.getColumns()),pt));
			hm.clear();
			parentDS.getSubDatasets().clear();
			parentDS.getElements().clear();
		}
		
	}
	
	private void mapElems(Dataset ds,DatasetHead dh)
	{
		if(ds.getElements()==null)
			ds.setElements(new ArrayList<Element>());
		
		for(DatasetElement de:dh.getDatasetElements())
			ds.getElements().add(new Element(de.getId(), "", "", "", 0L, true, false));
	}
	
	 private List<ColumnExpression> collect(List<ColumnExpression> l,PrefixTable pt)
		{
			for(ColumnExpression ce:pt.getColumns())
				l.add(ce);
			
			for(PrefixTable subPT:pt.getJoinTables().keySet())
				collect(l,subPT);
			
			return l;
		}
	
	@Test
	@Ignore
	public void t()
	{
		XStream xs=new XStream();
		Dataset ds=(Dataset) xs.fromXML(new File("/home/denny/dataset.xml"));
		
		List<DatasetHead> l=dr.findByIds(Arrays.asList(8L,1002L));
		
		HashMap<Long,DatasetHead> hm=new HashMap<Long, DatasetHead>();
		for(DatasetHead dh:l)
			hm.put(dh.getId(), dh);
		ds.setId(8L);
		
		
		for(Element de:ds.getElements())
			de.setAggregate("SUM");	
				
		PrefixTableBuilder ptb=new DatasetSourceImpl(ds, hm); 
		ptb.where(ds.getFilters());
		ptb.setAlias("sp");
//		ptb.addSpecialColumn(new Element(1L,"count(*)","","",1L,false,false));
//		ptb.where(FilterWhereBuilderFactory.get().where("a", "denny").eq("1").build());
		PrefixTable pt=(PrefixTable) ptb.build();
		System.out.println(new ServiceQueryBuilderImpl().getQuery(pt));
	}
}
