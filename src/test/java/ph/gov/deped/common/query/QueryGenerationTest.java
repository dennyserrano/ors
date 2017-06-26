package ph.gov.deped.common.query;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thoughtworks.xstream.XStream;

import ph.gov.deped.common.util.builders.StarSchemaChainImpl;
import ph.gov.deped.common.util.builders.TableChainer;
import ph.gov.deped.config.TestAppConfig;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.dto.ds.Filter;
import ph.gov.deped.data.dto.interfaces.TableColumn;
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
	
	private TableChainer tableChainer=new StarSchemaChainImpl(new String[]{"sy_from","region_shortname","division_name","school_id","school_name","region_short_name","municipality_name"});
	@Autowired
	DatasetService datasetService;
	
	@Autowired
	MetadataService metadataService;
	
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
		PrefixTable parentPT= tableChainer.chain(parent, new ArrayList<DatasetHead>(), ds.getFilters());
		ServiceQueryBuilder sq=new ServiceQueryBuilderImpl();
		String reference="SELECT "
				+ "schl_ref_region.short_name AS 'region_short_name', "
				+ "sp.division_name AS 'division_name', "
				+ "sp.school_name AS 'school_name', "
				+ "sp.sy_from AS 'sy_from', "
				+ "sp.school_id AS 'school_id', "
				+ "brgy_mun.municipality_name AS 'municipality_name', "
				+ "sp.region_shortname AS 'region_shortname' "
				+ "FROM school_profile_history AS sp "
				+ "LEFT JOIN ref_baranggay AS sch_brgy ON sp.branggay_id = sch_brgy.id "
				+ "LEFT JOIN ref_municipality AS brgy_mun ON sch_brgy.ref_municipality_id = brgy_mun.id "
				+ "LEFT JOIN ref_region AS schl_ref_region ON sp.region_id = schl_ref_region.id "
				+ "WHERE sp.region_id = 7 "
				+ "AND sp.division_id = 20 "
				+ "AND sp.school_type_id = 292 "
				+ "AND sp.sector_id = 7 "
				+ "AND sp.school_classification_id IN (11,12,13,14,15,986) "
				+ "AND sp.level_of_education_id = 433 "
				+ "AND sp.coc_id IN (19,20,22,207,208,210,454,958,959,963,964,967,968,969) AND sp.sy_from = 2016";
		String output=sq.getQuery(parentPT);
		System.out.println("Generated Query: "+output);
		Assert.assertEquals(reference, output);
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
		PrefixTable parentPT= tableChainer.chain(parent, children, ds.getFilters());
		ServiceQueryBuilder sq=new ServiceQueryBuilderImpl();
		String reference="SELECT "
				+ "schl_ref_region.short_name AS 'region_short_name', "
				+ "sp.division_name AS 'division_name', "
				+ "sp.school_name AS 'school_name', "
				+ "sp.sy_from AS 'sy_from', "
				+ "sp.school_id AS 'school_id', "
				+ "brgy_mun.municipality_name AS 'municipality_name', "
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
				+ "LEFT JOIN ref_baranggay AS sch_brgy ON sp.branggay_id = sch_brgy.id "
				+ "LEFT JOIN ref_municipality AS brgy_mun ON sch_brgy.ref_municipality_id = brgy_mun.id "
				+ "LEFT JOIN ref_region AS schl_ref_region ON sp.region_id = schl_ref_region.id "
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
			PrefixTable parentPT= tableChainer.chain(parent,new ArrayList<DatasetHead>(Arrays.asList(child)) , ds.getFilters());
			String output=sq.getQuery(parentPT);
			System.out.println("Generated Query: "+output);
		}
		
	}
	
//	DatasetHead parent=datasetRepo.findByIds(Arrays.asList(8L)).get(0);
//	List<DatasetHead> children=datasetRepo.findByIds(Arrays.asList(childrenDH.getId()));
//	PrefixTable pt=tableChainer.chain(parent, children,filters);
//	ServiceQueryBuilder sq=new ServiceQueryBuilderImpl();
//	System.out.println("=============================================="+sq.getQuery(pt));
}
