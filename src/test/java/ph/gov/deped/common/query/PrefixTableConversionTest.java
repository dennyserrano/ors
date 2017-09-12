package ph.gov.deped.common.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ph.gov.deped.common.util.builders.impl.ColumnElement;
import ph.gov.deped.common.util.builders.impl.JoinProperty;
import ph.gov.deped.common.util.builders.impl.JoinPropertyBuilder;
import ph.gov.deped.common.util.builders.impl.PrefixTable;
import ph.gov.deped.config.TestAppConfig;
import ph.gov.deped.data.ors.ds.DatasetCorrelation;
import ph.gov.deped.data.ors.ds.DatasetCorrelationDtl;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroup;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroupDtl;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.data.ors.meta.ColumnMetadata;
import ph.gov.deped.data.ors.meta.TableMetadata;
import ph.gov.deped.service.data.api.ServiceQueryBuilder;
import ph.gov.deped.service.data.impl.ServiceQueryBuilderImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
        TestAppConfig.class
})
public class PrefixTableConversionTest
{
	
//	static StarSchemaChainImpl tableBuilder=new StarSchemaChainImpl(new HashMap<DatasetHead, Set<DatasetElement>>(),null,null);
//	static ServiceQueryBuilder sqb=new ServiceQueryBuilderImpl();
	
	
	//check if transformation of prefix table is intact
	@Test
	public void a()
	{
//		PrefixTable pt=tableBuilder.chain(getRootTable(), Arrays.asList(getNsbiTableOneTableJoin()), new ArrayList<>());
//		String referenceString="SELECT "
//				+ "school_prof_history.school_id AS 'school_id', "
//				+ "t2.col1 AS 'col1', t1.col2 AS 'col2', "
//				+ "t1.col3 AS 'col3' "
//				+ "FROM school_prof_history AS sp "
//				+ "LEFT JOIN nsbi_spec AS t1 ON sp.sy_from = t1.sy_from "
//				+ "LEFT JOIN table2 AS t2 ON t1.c1 = t2.c2";
//		System.out.println(sqb.getQuery(pt));
//		System.out.println(referenceString);
//		Assert.assertEquals(referenceString, sqb.getQuery(pt));
	}
	
	
	@Test
	public void b()
	{
		String referenceString="SELECT "
				+ "school_prof_history.school_id AS 'school_id', "
				+ "t2.col1 AS 'col1', t1.col2 AS 'col2', "
				+ "t1.col3 AS 'col3' "
				+ "FROM school_prof_history AS sp "
				+ "LEFT JOIN nsbi_spec AS t1 ON sp.sy_from = t1.sy_from "
				+ "LEFT JOIN table2 AS t2 ON t1.c1 = t2.c2";
//		PrefixTable pt=tableBuilder.chain(getRootTable(), Arrays.asList(getNsbiTableOneTableJoin()), new ArrayList<>());
//		Assert.assertEquals(referenceString, sqb.getQuery(pt));
	}
	
	private static DatasetHead getNsbiTableTwoTableJoin()
	{
		DatasetHead dh=buildDh(1l,"nsbi_specifics", "nsbi_spec");
		DatasetElement de= build("col1","col1");
		de.setDatasetCorrelationGroup(
				new PrefixTableConversionTest().new DatasetGroupBuilder().setName("group1")
				.getGroupDetailBuilder()
				.add( 
						new PrefixTableConversionTest().new DatasetCorrelationBuilder()
						.set("t1", buildDh(1, "table1", "table1"), "t2", buildDh(2,"table2","table2"))
						.getDtlBuilder()
						.add(build("c1", "c1"), build("c2","c2"))
						.build()
						.build()
						)
				.add(
						new PrefixTableConversionTest().new DatasetCorrelationBuilder()
						.set("t2", buildDh(2, "table2", "table2"), "t3", buildDh(3,"table3","table3"))
						.getDtlBuilder()
						.add(build("c1", "c1"), build("c2","c2"))
						.build()
						.build()
						)
				.build()
				.build()
				);
		dh.getDatasetElements().add(de);
		dh.getDatasetElements().add(build("col2","col2"));
		dh.getDatasetElements().add(build("col3","col3"));
		return dh;
	}
	
	private static DatasetHead getNsbiTableOneTableJoin()
	{
		DatasetHead dh=buildDh(1l,"nsbi_specifics", "nsbi_spec");
		DatasetElement de= build("col1","col1");
		de.setDatasetCorrelationGroup(
				new PrefixTableConversionTest().new DatasetGroupBuilder().setName("group1")
				.getGroupDetailBuilder()
				.add( 
						new PrefixTableConversionTest().new DatasetCorrelationBuilder()
						.set("t1", buildDh(1, "table1", "table1"), "t2", buildDh(2,"table2","table2"))
						.getDtlBuilder()
						.add(build("c1", "c1"), build("c2","c2"))
						.build()
						.build()
						)
				.build()
				.build()
				);
		dh.getDatasetElements().add(de);
		dh.getDatasetElements().add(build("col2","col2"));
		dh.getDatasetElements().add(build("col3","col3"));
		return dh;
	}
	
	private static DatasetHead getRootTable()
	{
		DatasetHead dh=buildDh(8l,"school_prof_history", "school_prof_history");
		dh.setDatasetElements(new HashSet<DatasetElement>());
		dh.getDatasetElements().add(build("sy_from", "sy_from"));
		dh.getDatasetElements().add(build("school_id", "school_id"));
		return dh;
	}
	
	
	private static DatasetElement build(String name,String colname)
	{
		DatasetElement de= new DatasetElement();
		de.setId(1L);
		de.setColumnId(1);
		de.setName(name);
		de.setColumnMetaData(new ColumnMetadata(1, colname, "", false, 0, 1L, false));
		de.setDatasetHead(buildDh(2L,"dummy","tableDummy"));
		return de;
	}
	
	private static DatasetCorrelationGroupDtl getGroupDtl(DatasetHead left,DatasetHead right,int chainType)
	{
		DatasetCorrelationGroupDtl dtl= new DatasetCorrelationGroupDtl();
		DatasetCorrelation dc= new DatasetCorrelation();
		dc.setLeftDataset(left);
		dc.setRightDataset(right);
		
		return dtl;
	}
	
	
	private static DatasetCorrelationDtl getCorDtl(DatasetElement left,DatasetElement right)
	{
		DatasetCorrelationDtl dtl1=new DatasetCorrelationDtl();
		dtl1.setLeftElement(left);
		dtl1.setRightElement(right);
		return dtl1;
	}
	
	private static DatasetHead buildDh(long datasetId,String name,String tableName)
	{
		DatasetHead dh= new DatasetHead(datasetId, name, 0);
		dh.setDatasetElements(new HashSet<DatasetElement>());
		dh.setTableMetaData(new TableMetadata(1,1, "", tableName, "", ""));
		dh.setParentDatasetHead(1L);
		dh.setRanking(1);
		
		return dh;
	}
	
	
	class DatasetGroupBuilder
	{
		
		private DatasetGroupDetailBuilder detailBuilder;
		private DatasetCorrelationGroup group;
		public DatasetGroupBuilder()
		{
			detailBuilder=new DatasetGroupDetailBuilder(this);
			group=new DatasetCorrelationGroup();
		}
		
		public DatasetGroupBuilder setName(String name)
		{
			group.setName(name);
			return this;
		}
		
		public DatasetGroupDetailBuilder getGroupDetailBuilder()
		{
			return detailBuilder;
		}
		
		public DatasetCorrelationGroup build()
		{
			group.setGroupDetails(detailBuilder.getList());
			return group;
		}
	}
	
	class DatasetGroupDetailBuilder
	{
		private Set<DatasetCorrelationGroupDtl> list;
		private DatasetGroupBuilder parent;
		public DatasetGroupDetailBuilder(DatasetGroupBuilder parent)
		{
			list=new HashSet<DatasetCorrelationGroupDtl>();
			this.parent=parent;
		}
		
		public DatasetGroupDetailBuilder add(DatasetCorrelationGroupDtl dtl)
		{
			list.add(dtl);
		
			return this;
		}
		
		public DatasetGroupDetailBuilder add(DatasetCorrelation dc)
		{
			DatasetCorrelationGroupDtl dtl=new DatasetCorrelationGroupDtl();
			dtl.setDatasetCorrelation(dc);
//			dtl.setChainType(chainType);
			list.add(dtl);
			return this;
		}

		public Set<DatasetCorrelationGroupDtl> getList() {
			return list;
		}
		
		public DatasetGroupBuilder build()
		{
			return parent;
		}
		
	}
	
	class DatasetCorrelationBuilder
	{
		private DatasetCorrelation dc;
		private DatasetCorrelationDtlBuilder dtlBuilder;
		public DatasetCorrelationBuilder()
		{
			dc=new DatasetCorrelation();
			dtlBuilder=new DatasetCorrelationDtlBuilder(this);
			
		}
		
		public DatasetCorrelationBuilder set(String leftPrefix,DatasetHead left,String rightPrefix,DatasetHead right)
		{
			dc.setLeftDataset(left);
			dc.setLeftTablePrefix(leftPrefix);
			dc.setRightDataset(right);
			dc.setRightTablePrefix(rightPrefix);
			return this;
		}
		
		public DatasetCorrelationDtlBuilder getDtlBuilder()
		{
			return dtlBuilder;
		}
		
		public DatasetCorrelation build()
		{
			dc.setDetails(dtlBuilder.getSet());
			return dc;
		}
		
	}
	
	class DatasetCorrelationDtlBuilder
	{
		private HashSet<DatasetCorrelationDtl> set;
		private DatasetCorrelationBuilder pb;
		public DatasetCorrelationDtlBuilder(DatasetCorrelationBuilder pb) {
			set=new HashSet<DatasetCorrelationDtl>();
			this.pb=pb;
		}
		
		public DatasetCorrelationDtlBuilder add(DatasetElement left,DatasetElement right)
		{
			set.add(getCorDtl(left, right));
			return this;
		}
		
		public HashSet<DatasetCorrelationDtl> getSet()
		{
			return set;
		}
		
		public DatasetCorrelationBuilder build()
		{
			return pb;
		}
		
	}
	
}
