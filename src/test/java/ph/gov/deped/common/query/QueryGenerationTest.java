package ph.gov.deped.common.query;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bits.sql.AggregateTypes;
import com.bits.sql.JdbcTypes;
import com.thoughtworks.xstream.XStream;

import ph.gov.deped.common.util.builders.impl.ColumnElement;
import ph.gov.deped.common.util.builders.impl.PrefixTable;
import ph.gov.deped.config.TestAppConfig;
import ph.gov.deped.data.dto.ds.Aggregate;
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
public class QueryGenerationTest 
{
	@Autowired
	private DatasetRepository datasetRepo;
	
//	private TableChainer tableChainer=null;//new StarSchemaChainImpl();
	@Autowired
	DatasetService datasetService;
	
	@Autowired
	MetadataService metadataService;
	
	public static final String[] aggregateOptions=new String[]{"Region","Division","District","Province","Municipality","Legislative"};
	
	//check root table if correct
	//using all the filters available
	@Test
	@Ignore
	public void a()
	{
		XStream xs=new XStream();
		Dataset ds=(Dataset) xs.fromXML(new File("/home/denny/dataset.xml"));
		DatasetHead parent= datasetRepo.findByIds(Arrays.asList(8L)).get(0);
		ds.setElements(new ArrayList<>());
//		PrefixTable parentPT= tableChainer.chain(parent, new ArrayList<DatasetHead>(), ds.getFilters());
		ServiceQueryBuilder sq=new ServiceQueryBuilderImpl();
		String reference="SELECT "
				+ "brgy_mun.municipality_name AS 'municipality_name', "
				+ "sp.division_name AS 'division_name', "
				+ "sp.school_name AS 'school_name', "
				+ "sp.sy_from AS 'sy_from', "
				+ "sp.school_id AS 'school_id', "
				+ "schl_ref_region.region_name AS 'region_name', "
				+ "sp.region_shortname AS 'region_shortname' "
				+ "FROM school_profile_history AS sp "
				+ "LEFT JOIN ref_region AS schl_ref_region ON sp.region_id = schl_ref_region.id "
				+ "LEFT JOIN ref_baranggay AS sch_brgy ON sp.branggay_id = sch_brgy.id "
				+ "LEFT JOIN ref_municipality AS brgy_mun ON sch_brgy.ref_municipality_id = brgy_mun.id "
				+ "WHERE sp.region_id = 7 "
				+ "AND sp.division_id = 20 "
				+ "AND sp.school_type_id = 292 "
				+ "AND sp.sector_id = 7 "
				+ "AND sp.school_classification_id IN (11,12,13,14,15,986) "
				+ "AND sp.level_of_education_id = 433 "
				+ "AND sp.coc_id IN (19,20,22,207,208,210,454,958,959,963,964,967,968,969) AND sp.sy_from = 2016";
//		String output=sq.getQuery(parentPT);
//		System.out.println("Generated Query: "+output);
//		Assert.assertEquals(reference, output);
	}

	//root table with join
	//complete filters
	@Test
	@Ignore
	public void b()
	{
		XStream xs=new XStream();
		Dataset ds=(Dataset) xs.fromXML(new File("/home/denny/dataset.xml"));
		DatasetHead parent= datasetRepo.findByIds(Arrays.asList(8L)).get(0);
		List<DatasetHead> children=datasetRepo.findByIds(Arrays.asList(1002L));
//		ds.setElements(new ArrayList<>());
		PrefixTable parentPT= null;//tableChainer.chain(parent, children, ds.getFilters());
		ServiceQueryBuilder sq=new ServiceQueryBuilderImpl();
		String reference="SELECT "
				+ "brgy_mun.municipality_name AS 'municipality_name', "
				+ "sp.division_name AS 'division_name', "
				+ "sp.school_name AS 'school_name', "
				+ "sp.sy_from AS 'sy_from', "
				+ "sp.school_id AS 'school_id', "
				+ "schl_ref_region.region_name AS 'region_name', "
				+ "sp.region_shortname AS 'region_shortname', "
				+ "enrolment_age.gtotAge15 AS 'gtotAge15', "
				+ "enrolment_age.gtotmaleAge5 AS 'gtotmaleAge5', "
				+ "enrolment_age.gtotfemaleAge10 AS 'gtotfemaleAge10', "
				+ "enrolment_age.gtotAge10 AS 'gtotAge10', "
				+ "enrolment_age.gtotmaleAge15 AS 'gtotmaleAge15', "
				+ "enrolment_age.gtotfemaleAge15 AS 'gtotfemaleAge15', "
				+ "enrolment_age.gtotmaleAge16 AS 'gtotmaleAge16', "
				+ "enrolment_age.gtotfemaleAge16 AS 'gtotfemaleAge16', "
				+ "enrolment_age.gtotmaleAge11 AS 'gtotmaleAge11', "
				+ "enrolment_age.gtotAge16 AS 'gtotAge16', "
				+ "enrolment_age.gtotmaleAge8 AS 'gtotmaleAge8', "
				+ "enrolment_age.gtotfemaleAge11 AS 'gtotfemaleAge11', "
				+ "enrolment_age.gtotfemaleAge5 AS 'gtotfemaleAge5', "
				+ "enrolment_age.gtotAge5 AS 'gtotAge5', "
				+ "enrolment_age.gtotmaleAge13Above AS 'gtotmaleAge13Above', enrolment_age.gtotfemaleAge13Above AS 'gtotfemaleAge13Above', enrolment_age.gtotAge13Above AS 'gtotAge13Above', enrolment_age.gtotmaleAge19Above AS 'gtotmaleAge19Above', enrolment_age.gtotmaleAge4 AS 'gtotmaleAge4', enrolment_age.gtotfemaleAge8 AS 'gtotfemaleAge8', enrolment_age.gtotAge11 AS 'gtotAge11', enrolment_age.gtotAge8 AS 'gtotAge8', enrolment_age.gtotmaleAge6 AS 'gtotmaleAge6', enrolment_age.gtotfemaleAge19Above AS 'gtotfemaleAge19Above', enrolment_age.gtotfemaleAge4 AS 'gtotfemaleAge4', enrolment_age.gtotAge19Above AS 'gtotAge19Above', enrolment_age.gtotmaleAge12 AS 'gtotmaleAge12', enrolment_age.gtotAge4 AS 'gtotAge4', enrolment_age.gtotfemaleAge12 AS 'gtotfemaleAge12', enrolment_age.gtotAge12 AS 'gtotAge12', enrolment_age.gtotmaleAge16to18 AS 'gtotmaleAge16to18', enrolment_age.gtotfemaleAge16to18 AS 'gtotfemaleAge16to18', enrolment_age.gtotAge16to18 AS 'gtotAge16to18', enrolment_age.gtotmaleAge9 AS 'gtotmaleAge9', enrolment_age.gtotfemaleAge6 AS 'gtotfemaleAge6', enrolment_age.gtotAge6 AS 'gtotAge6', enrolment_age.gtotmaleAge13to15 AS 'gtotmaleAge13to15', enrolment_age.gtotfemaleAge13to15 AS 'gtotfemaleAge13to15', enrolment_age.gtotAge13to15 AS 'gtotAge13to15', enrolment_age.gtotmaleAge4_5 AS 'gtotmaleAge4_5', enrolment_age.gtotfemaleAge9 AS 'gtotfemaleAge9', enrolment_age.gtotAge9 AS 'gtotAge9', enrolment_age.gtotmaleAge14 AS 'gtotmaleAge14', enrolment_age.gtotmaleAge7 AS 'gtotmaleAge7', enrolment_age.gtotmaleAge17 AS 'gtotmaleAge17', enrolment_age.gtotfemaleAge4_5 AS 'gtotfemaleAge4_5', enrolment_age.gtotfemaleAge17 AS 'gtotfemaleAge17', enrolment_age.gtotAge4_5 AS 'gtotAge4_5', enrolment_age.gtotmaleAge12Above AS 'gtotmaleAge12Above', enrolment_age.gtotAge17 AS 'gtotAge17', enrolment_age.gtotfemaleAge12Above AS 'gtotfemaleAge12Above', enrolment_age.gtotAge12Above AS 'gtotAge12Above', enrolment_age.gtotfemaleAge18 AS 'gtotfemaleAge18', enrolment_age.gtotmaleAge13 AS 'gtotmaleAge13', enrolment_age.gtotAge18 AS 'gtotAge18', enrolment_age.gtotfemaleAge13 AS 'gtotfemaleAge13', enrolment_age.gtotAge13 AS 'gtotAge13', enrolment_age.gtotmaleAge10 AS 'gtotmaleAge10', enrolment_age.gtotfemaleAge14 AS 'gtotfemaleAge14', enrolment_age.gtotfemaleAge7 AS 'gtotfemaleAge7', enrolment_age.gtotAge14 AS 'gtotAge14', enrolment_age.gtotAge7 AS 'gtotAge7', enrolment_age.gtotmaleAge18 AS 'gtotmaleAge18' "
				+ "FROM school_profile_history AS sp "
				+ "LEFT JOIN ref_region AS schl_ref_region ON sp.region_id = schl_ref_region.id "
				+ "LEFT JOIN ref_baranggay AS sch_brgy ON sp.branggay_id = sch_brgy.id "
				+ "LEFT JOIN ref_municipality AS brgy_mun ON sch_brgy.ref_municipality_id = brgy_mun.id "
				+ "LEFT JOIN enrolment_age AS enrolment_age ON sp.sy_from = enrolment_age.sy_from "
				+ "WHERE sp.region_id = 7 AND sp.division_id = 20 AND sp.school_type_id = 292 AND sp.sector_id = 7 AND sp.school_classification_id IN (11,12,13,14,15,986) AND sp.level_of_education_id = 433 AND sp.coc_id IN (19,20,22,207,208,210,454,958,959,963,964,967,968,969) AND sp.sy_from = 2016";
		String output=sq.getQuery(parentPT);
		System.out.println("Generated Query: "+output);
		Assert.assertEquals(reference, output);
	}
	
	@Test
	@Ignore
	public void c()
	{
		XStream xs=new XStream();
		Dataset dataset=(Dataset) xs.fromXML(new File("/home/denny/dataset.xml"));
		ArrayList<Element> list=new ArrayList<Element>();
		for(Element e:dataset.getElements())		
		{
			Element e1=new Element(e.getId(),e.getName(),e.getDescription(),e.getMeaning(),e.getDatasetId(),true,true);
			e1.setAggregate("SUM");
			list.add(e1);
		}
		
		dataset.setElements(list);
		
		datasetService.getData(dataset, true);
		
	}
	
	//test if generating SQL statement if ok..
	@Test
	@Ignore
	public void d()
	{
		XStream xs=new XStream();
		Dataset ds=(Dataset) xs.fromXML(new File("/home/denny/dataset.xml"));
		List<DatasetHead> children= datasetRepo.findAll();
		DatasetHead parent= datasetRepo.findByIds(Arrays.asList(8L)).get(0);
		ServiceQueryBuilder sq=new ServiceQueryBuilderImpl();
		for(DatasetHead child:children)
		{
			List<DatasetHead> tempChildren=datasetRepo.findByIds(Arrays.asList(child.getId()));
			if(tempChildren.size()!=0)
				child=tempChildren.get(0);
			else
				continue;
			PrefixTable parentPT= null;//tableChainer.chain(parent,new ArrayList<DatasetHead>(Arrays.asList(child)) , ds.getFilters());
			String output=sq.getQuery(parentPT);
			System.out.println("Generated Query: "+output);
		}
		
	}
	
	@Test
	@Ignore
	public void e()
	{
		XStream xs=new XStream();
		Dataset ds=(Dataset) xs.fromXML(new File("/home/denny/dataset.xml"));
		List<DatasetHead> children= datasetRepo.findAll();
		for(DatasetHead child:children)
		{
			
			List<DatasetHead> al=datasetRepo.findByIds(Arrays.asList(child.getId()));
			if(al.size()==0)
				continue;
			
			if(!al.get(0).isVisible())
				continue;
			
			if(al.get(0).getParentDatasetHead()==null)
				continue;
			
			if(al.get(0).getParentDatasetHead()==0)
				continue;
			
			child=al.get(0);
			Dataset sub=new Dataset();
			sub.setId(child.getId());
			ArrayList<Element> elementCol=new ArrayList<Element>();
			for(DatasetElement de:child.getDatasetElements())
				elementCol.add(toElement(de));
			
//			sub.setElements(elementCol);
			
			ds.setElements(elementCol);
			ds.setSubDatasets(Arrays.asList(sub));
			try
			{
				datasetService.getData(ds, true);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
	//aggregations check
	@Test
	public void f()
	{
		XStream xs=new XStream();
		Dataset ds=(Dataset) xs.fromXML(new File("/home/denny/dataset.xml"));
		List<DatasetHead> children= datasetRepo.findAll();
		for(DatasetHead child:children)
		{
			
			for(String aggregate:aggregateOptions)
			{
				Aggregate aggObj=getAggregate(aggregate);
				List<DatasetHead> al=datasetRepo.findByIds(Arrays.asList(child.getId()));
				if(al.size()==0)
					continue;
				
				if(!al.get(0).isVisible())
					continue;
				
				if(al.get(0).getParentDatasetHead()==null)
					continue;
				
				if(al.get(0).getParentDatasetHead()==0)
					continue;
				
				child=al.get(0);
				Dataset sub=new Dataset();
				sub.setId(child.getId());
				ArrayList<Element> elementCol=new ArrayList<Element>();
				elementCol.addAll(aggObj.getElements());
				for(DatasetElement de:child.getDatasetElements())
					{
					
						if(JdbcTypes.isNumeric(de.getColumnMetaData().getDataType()))
						{
							de.setAggregate(AggregateTypes.SUM);
							elementCol.add(toElement(de));
						}else if(JdbcTypes.isStringType(de.getColumnMetaData().getDataType()))
						{
							de.setAggregate(AggregateTypes.GROUP);
							elementCol.add(toElement(de));
							aggObj.getElements().add(toElement(de));
						}
					}
				
				
				ds.setElements(elementCol);
				ds.setSubDatasets(Arrays.asList(sub));
				ds.setAggregateBy(aggObj);
				
			}
			
			try
			{
				datasetService.getData(ds, true);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	private Aggregate getAggregate(String aggregateName)
	{
		Aggregate a=new Aggregate();
		a.setElements(new ArrayList<Element>());
		if(aggregateName.equals("Region"))
			a.getElements().add(new Element(281, "", null, "", 0L, false, true));
		else if(aggregateName.equals("Division"))
		{
			a.getElements().add(new Element(281, "", null, "", 0L, false, true));
			a.getElements().add(new Element(285, "", null, "", 0L, false, true));
		}
		else if(aggregateName.equals("District"))
		{
			a.getElements().add(new Element(281, "", null, "", 0L, false, true));
			a.getElements().add(new Element(285, "", null, "", 0L, false, true));
			a.getElements().add(new Element(286, "", null, "", 0L, false, true));
		}
		else if(aggregateName.equals("Province"))
		{
			a.getElements().add(new Element(281, "", null, "", 0L, false, true));
			a.getElements().add(new Element(285, "", null, "", 0L, false, true));
			a.getElements().add(new Element(286, "", null, "", 0L, false, true));
			a.getElements().add(new Element(282, "", null, "", 0L, false, true));
		}
		else if(aggregateName.equals("Municipality"))
		{
			a.getElements().add(new Element(281, "", null, "", 0L, false, true));
			a.getElements().add(new Element(285, "", null, "", 0L, false, true));
			a.getElements().add(new Element(286, "", null, "", 0L, false, true));
			a.getElements().add(new Element(282, "", null, "", 0L, false, true));
			a.getElements().add(new Element(283, "", null, "", 0L, false, true));
		}
		else if(aggregateName.equals("Legislative"))
		{
			a.getElements().add(new Element(281, "", null, "", 0L, false, true));
			a.getElements().add(new Element(285, "", null, "", 0L, false, true));
			a.getElements().add(new Element(286, "", null, "", 0L, false, true));
			a.getElements().add(new Element(282, "", null, "", 0L, false, true));
			a.getElements().add(new Element(283, "", null, "", 0L, false, true));
			a.getElements().add(new Element(284, "", null, "", 0L, false, true));
		}
		a.setCountIncluded(true);
		
		
		for(Element e:a.getElements())
			e.setAggregate(AggregateTypes.GROUP.getAggregate());
		return a;
	}
	
	private Element toElement(DatasetElement de)
	{
		Element e=new Element(de.getId(), de.getName(), "", "", de.getDatasetHead().getId(), false, true);
//		e.setAggregate(de.getAggregate()==null?null:de.getAggregate().getAggregate());
		return e;
	}
//	DatasetHead parent=datasetRepo.findByIds(Arrays.asList(8L)).get(0);
//	List<DatasetHead> children=datasetRepo.findByIds(Arrays.asList(childrenDH.getId()));
//	PrefixTable pt=tableChainer.chain(parent, children,filters);
//	ServiceQueryBuilder sq=new ServiceQueryBuilderImpl();
//	System.out.println("=============================================="+sq.getQuery(pt));
}
