package ph.gov.deped.common.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bits.sql.AggregateTypes;
import com.model.db.ColumnMetadata;
import com.model.db.DatasetCorrelation;
import com.model.db.DatasetCorrelationDtl;
import com.model.db.DatasetCorrelationGroup;
import com.model.db.DatasetCorrelationGroupDtl;
import com.model.db.DatasetElement;
import com.model.db.DatasetHead;
import com.model.db.TableMetadata;

import ph.gov.deped.common.util.builders.impl.ColumnElement;
import ph.gov.deped.common.util.builders.impl.DatasetSourceImpl;
import ph.gov.deped.common.util.builders.impl.JoinProperty;
import ph.gov.deped.common.util.builders.impl.JoinPropertyBuilder;
import ph.gov.deped.common.util.builders.impl.PrefixTable;
import ph.gov.deped.common.util.builders.interfaces.PrefixTableBuilder;
import ph.gov.deped.config.TestAppConfig;
import ph.gov.deped.data.dto.KeyValue;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.dto.ds.Filter;
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
	
	
	//simple
	@Test
//	@Ignore
	public void a()
	{
		
		Dataset d=new DatasetBuilder(1).child().create(1).create(2).create(3).build();
		
		HashMap<Long,DatasetHead> mapRef=new HashMap<>();
		mapRef.put(1L, new DatasetHeadBuilder().create(1,"A", "tableA")
				.create(1, "colA", "fieldA")
				.create(2, "colB", "fieldB")
				.create(3, "colC", "fieldC").build());
		
		
		PrefixTableBuilder ptb=new DatasetSourceImpl(d, mapRef);
		ptb.setAlias("sp");
		String res=new ServiceQueryBuilderImpl().getQuery(ptb.build());
		System.out.println(res);
		Assert.assertEquals("SELECT sp.fieldA, sp.fieldB, sp.fieldC FROM tableA AS sp",res);
	}
	
	
	
	//with join. B table has elements A has none.
	@Test
	public void b()
	{
		
		Dataset d=new DatasetBuilder(1).addSubDataset(new DatasetBuilder(2).build()).child().create(1).create(2).build();
		
		HashMap<Long,DatasetHead> mapRef=new HashMap<>();
		mapRef.put(1L, new DatasetHeadBuilder().create(1,"A", "tableA")
				.create(3, "colA1", "fieldA1")
				.create(4, "colB1", "fieldB1")
				.create(5, "colC1", "fieldC1").build());
		mapRef.put(2L, new DatasetHeadBuilder().create(2,"B", "tableB")
				.create(1, "colA2", "fieldA2")
				.create(2, "colB2", "fieldB2").build());
		
		PrefixTableBuilder ptb=new DatasetSourceImpl(d, mapRef);
		ptb.setAlias("sp");
		String res=new ServiceQueryBuilderImpl().getQuery(ptb.build());
		System.out.println(res);
		Assert.assertEquals("SELECT tableB.fieldA2, tableB.fieldB2 FROM tableA AS sp LEFT JOIN tableB AS tableB ON sp.school_id = tableB.school_id AND sp.sy_from = tableB.sy_from",res);
	}
	
	//join table. select a column from child
	@Test
	public void c()
	{
		Dataset d=new DatasetBuilder(1).addSubDataset(new DatasetBuilder(2).build())
										.child().create(3).create(4).create(1).build();
		
		HashMap<Long,DatasetHead> mapRef=new HashMap<>();
		mapRef.put(1L, new DatasetHeadBuilder().create(1,"A", "tableA")
				.create(3, "colA1", "fieldA1")
				.create(4, "colB1", "fieldB1")
				.create(5, "colC1", "fieldC1").build());
		mapRef.put(2L, new DatasetHeadBuilder().create(2,"B", "tableB")
				.create(1, "colA2", "fieldA2")
				.create(2, "colB2", "fieldB2").build());
		
		PrefixTableBuilder ptb=new DatasetSourceImpl(d, mapRef);
		ptb.setAlias("sp");
		String res=new ServiceQueryBuilderImpl().getQuery(ptb.build());
		System.out.println(res);
		Assert.assertEquals("SELECT sp.fieldA1, sp.fieldB1, tableB.fieldA2 FROM tableA AS sp LEFT JOIN tableB AS tableB ON sp.school_id = tableB.school_id AND sp.sy_from = tableB.sy_from",res);
	}
	
	@Test
	public void d()
	{
		
		//308 must be present in DatasetCriteriaWhereBuilder.CRITERIA
		//8 must be present also as criteria key
		
		Dataset d=new DatasetBuilder(1).addSubDataset(new DatasetBuilder(2).build())
				.child().create(3).create(4).create(1).build();
		
		HashMap<Long,DatasetHead> mapRef=new HashMap<>();
		mapRef.put(1L, new DatasetHeadBuilder().create(1,"A", "tableA")
		.create(3, "colA1", "fieldA1")
		.create(4, "colB1", "fieldB1")
		.create(5, "colC1", "fieldC1")
		.create(10936, "colD1", "fieldD1").build());
		mapRef.put(2L, new DatasetHeadBuilder().create(2,"B", "tableB")
		.create(1, "colA2", "fieldA2")
		.create(308, "colB2", "fieldB2").build());
		
		PrefixTableBuilder ptb=new DatasetSourceImpl(d, mapRef);
		ptb.setAlias("sp");
		ptb.where(
					new FilterBuilder().create(8L, 0L, Arrays.asList(new KeyValue("1", "")))
										.create(17L, 0L, Arrays.asList(new KeyValue("1",""),new KeyValue("2", ""))).build()
				);
		String res=new ServiceQueryBuilderImpl().getQuery(ptb.build());
		System.out.println(res);
		Assert.assertEquals("SELECT sp.fieldA1, sp.fieldB1, tableB.fieldA2 FROM tableA AS sp LEFT JOIN tableB AS tableB ON sp.school_id = tableB.school_id AND sp.sy_from = tableB.sy_from WHERE sp.colB2 = '1' AND sp.colD1 IN ('1','2')",res);
	}
	
	//With aggregate and count
	@Test
	public void e()
	{
		Dataset d=new DatasetBuilder(1).child().create(1,AggregateTypes.SUM.getAggregate()).create(2).create(3).build();
		
		HashMap<Long,DatasetHead> mapRef=new HashMap<>();
		mapRef.put(1L, new DatasetHeadBuilder().create(1,"A", "tableA")
				.create(1, "colA", "fieldA")
				.create(2, "colB", "fieldB")
				.create(3, "colC", "fieldC").build());
		
		
		PrefixTableBuilder ptb=new DatasetSourceImpl(d, mapRef);
		ptb.addSpecialColumn(new Element(0L, "count(*)", "", "", 0L, false, false));
		ptb.setAlias("sp");
		String res=new ServiceQueryBuilderImpl().getQuery(ptb.build());
		System.out.println(res);
		Assert.assertEquals("SELECT COUNT(*) as count, (SUM(sp.fieldA)) as colA, sp.fieldB, sp.fieldC FROM tableA AS sp",res);
	}
	
	
	//with column dependency / with group
	@Test
	public void f()
	{
		HashMap<Long,DatasetHead> mapRef=new HashMap<>();
		mapRef.put(1L, new DatasetHeadBuilder().create(1,"A", "tableA")
				.create(1, "colA", "fieldA",
							new DatasetGroupBuilder().setName("g1")
														.getGroupDetailBuilder().add(
																						new DatasetCorrelationBuilder().set("sp",
																																new DatasetHeadBuilder().create(1L, "A", "tableA").build(),
																															"tableZ",
																																new DatasetHeadBuilder().create(100L, "Z", "tableZ").build()
																															)
																																.getDtlBuilder()
																																			.add(
																																					SingleDatasetElementBuilder.create(new DatasetHeadBuilder().create(1L, "A", "tableA").build(), 5, "A", "fieldA"),
																																					SingleDatasetElementBuilder.create(new DatasetHeadBuilder().create(100L, "Z", "tableZ").build(), 5, "Z", "fieldZ")
																																					).build().build()
																					)
																				.add(
																						
																						new DatasetCorrelationBuilder().set("tableZ",
																																new DatasetHeadBuilder().create(100L, "Z", "tableZ").build(),
																															"tableY",
																																new DatasetHeadBuilder().create(200L, "Y", "tableY").build()
																															)
																																.getDtlBuilder()
																																			.add(
																																					SingleDatasetElementBuilder.create(new DatasetHeadBuilder().create(100L, "Z", "tableZ").build(), 5, "Z", "fieldZ"),
																																					SingleDatasetElementBuilder.create(new DatasetHeadBuilder().create(200L, "Y", "tableY").build(), 5, "Y", "fieldY")
																																					).build().build()
																						
																					 )	
																					
																					.build().build()
						)
				.create(2, "colB", "fieldB")
				.create(3, "colC", "fieldC").build());
		
		
		Dataset d=new DatasetBuilder(1).child().create(1).create(2).create(3).build();
		
		PrefixTableBuilder ptb=new DatasetSourceImpl(d, mapRef);
		ptb.setAlias("sp");
		String res=new ServiceQueryBuilderImpl().getQuery(ptb.build());
		System.out.println(res);
		Assert.assertEquals("SELECT tableY.fieldA, sp.fieldB, sp.fieldC FROM tableA AS sp LEFT JOIN tableZ AS tableZ ON sp.fieldA = tableZ.fieldZ LEFT JOIN tableY AS tableY ON tableZ.fieldZ = tableY.fieldY",res);
	}
	
	
	
	private static DatasetCorrelationDtl getCorDtl(DatasetElement left,DatasetElement right)
	{
		DatasetCorrelationDtl dtl1=new DatasetCorrelationDtl();
		dtl1.setLeftElement(left);
		dtl1.setRightElement(right);
		return dtl1;
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
	
	class DatasetBuilder
	{
		ElementBuilder eb;
		Dataset d;
		public DatasetBuilder(long id) {
			d=new Dataset();
			d.setElements(new ArrayList<Element>());
			d.setId(id);
			eb=new ElementBuilder(d);
		}
		
		public ElementBuilder child()
		{
			return eb;
		}
		
		public Dataset build()
		{
			return d;
		}
		
		public DatasetBuilder addSubDataset(Dataset d)
		{
			this.d.getSubDatasets().add(d);
			return this;
		}
	}
	
	class ElementBuilder
	{
		private Dataset parent;
		public ElementBuilder(Dataset parent)
		{
			this.parent=parent;
		}
		
		public ElementBuilder create(long id)
		{
			parent.getElements().add(localCreate(id));
			return this;
		}
		
		public ElementBuilder create(long id,String aggregate)
		{
			parent.getElements().add(localCreate(id, aggregate));
			return this;
		}
		
		private Element localCreate(long id)
		{
			Element e=new Element(id,"","","",1,false,false);
			return e;
		}
		
		private Element localCreate(long id,String aggregate)
		{
			Element e=localCreate(id);
			e.setAggregate(aggregate);
			return e;
		}
		
		public ElementBuilder createAggregate(long id,String aggregate)
		{
			parent.getElements().add(localCreate(id,aggregate));
			return this;
		}
		public Dataset build()
		{
			return parent;
		}
	}
	static class SingleDatasetElementBuilder
	{
		public static DatasetElement create(DatasetHead parent,long id,String alias,String fieldName)
		{
			DatasetElement e= new DatasetElement(id);
			e.setName(alias);
			e.setColumnMetaData(new ColumnMetadata(0, fieldName, "", false, 0, 0L, false));
			e.setDatasetHead(parent);
			return e;
		}
	}
	
	
	class DatasetElementBuilder
	{
		private DatasetHead dh;
		DatasetElementBuilder(DatasetHead parent)
		{
			dh=parent;
			dh.setDatasetElements(new HashSet<DatasetElement>());
			
		}
		public DatasetElementBuilder create(long id,String alias,String fieldName)
		{
			dh.getDatasetElements().add(SingleDatasetElementBuilder.create(dh,id, alias, fieldName));
			return this;
		}
		
		public DatasetElementBuilder create(long id,String alias,String fieldName,DatasetCorrelationGroup group)
		{
			DatasetElement e=SingleDatasetElementBuilder.create(dh,id, alias, fieldName);
			e.setDatasetCorrelationGroup(group);
			dh.getDatasetElements().add(e);
			return this;
		}
		
		public DatasetHead build()
		{
			return dh;
		}
		
	}
	
	class DatasetHeadBuilder
	{
		DatasetElementBuilder deb;

		public DatasetElementBuilder create(long datasetId,String name,String tableName)
		{
			DatasetHead dh= new DatasetHead(datasetId, name, 0);
			dh.setTableMetaData(new TableMetadata(1,1, "", tableName, "", ""));
			dh.setParentDatasetHead(1L);
			dh.setRanking(1);
			deb=new DatasetElementBuilder(dh);
			return deb;
		}
	}
	
	
	class FilterBuilder
	{
		//filter.criterion should be present in DatasetCriteriaWhereBuilder.CRITERIA. 
		ArrayList<Filter> filters=new ArrayList<Filter>();
		public FilterBuilder create(long criterion,long element,List<KeyValue> kvList)
		{
			filters.add(localCreate(criterion, element, kvList));
			return this;
		}
		
		public Filter localCreate(long criterion,long element,List<KeyValue> kvList)
		{
			return new Filter(criterion, element, kvList);
		}
		
		public List<Filter> build()
		{
			return filters;
		}
		
	}
	
}
