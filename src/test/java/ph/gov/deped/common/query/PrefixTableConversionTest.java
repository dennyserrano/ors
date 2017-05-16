package ph.gov.deped.common.query;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

import ph.gov.deped.common.util.builders.JoinProperty;
import ph.gov.deped.common.util.builders.PrefixTableBuilder;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.PrefixTable;
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

public class PrefixTableConversionTest
{
	
	static PrefixTableBuilder tableBuilder=new PrefixTableBuilder();
	static ServiceQueryBuilder sqb=new ServiceQueryBuilderImpl();
	public static void main(String[] args) {
		
		DatasetHead dh=buildDh(1l,"main", "mainTable");
		DatasetElement de= build("col1","col1");
		de.setDatasetCorrelationGroup(getGroup("group1"));
		dh.getDatasetElements().add(de);
		dh.getDatasetElements().add(build("col2","col2"));
		dh.getDatasetElements().add(build("col3","col3"));
		PrefixTable resPt=tableBuilder.build(dh);
		resPt.setTablePrefix("tr1");
		
		System.out.println(sqb.getQuery(resPt));
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
	
	private static DatasetCorrelationGroup getGroup(String name)
	{
		DatasetGroupBuilder groupBuilder=new PrefixTableConversionTest() .new DatasetGroupBuilder();
		
		groupBuilder.getGroupDetailBuilder()
		.add(
				new PrefixTableConversionTest().new DatasetCorrelationBuilder()
				.set("tr1",buildDh(1, "tabl1", "table1"), "tr2",buildDh(2,"tabl2","table2"))
				.getDtlBuilder()
				.add(build("c1", "c1"), build("c2","c2"))
				.build()
				.build()
				
				, 1)
		.add(
				new PrefixTableConversionTest().new DatasetCorrelationBuilder().set("t3",buildDh(3, "t3", "t3"), "t2",buildDh(4,"t4","t4"))
				.getDtlBuilder().add(build("c3", "c3"), build("c4","c4"))
				.build()
				.build()
				
				, 1);
//		.add(dc, chainType)
		
		groupBuilder.setName(name);
		
//		.add(null);
		DatasetCorrelationGroup g=groupBuilder.build();
		
		
		return g;
	}
	
	private static DatasetCorrelationGroupDtl getGroupDtl(DatasetHead left,DatasetHead right,int chainType)
	{
		DatasetCorrelationGroupDtl dtl= new DatasetCorrelationGroupDtl();
		DatasetCorrelation dc= new DatasetCorrelation();
		dc.setLeftDataset(left);
		dc.setRightDataset(right);
		
		return dtl;
	}
	
	
	private static DatasetCorrelation getCor(DatasetHead left,DatasetHead right)
	{
		DatasetCorrelation dc= new DatasetCorrelation();
		dc.setLeftDataset(left);
		dc.setRightDataset(right);
		return dc;
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
			detailBuilder=new DatasetGroupDetailBuilder();
			group=new DatasetCorrelationGroup();
		}
		
		public void setName(String name)
		{
			group.setName(name);
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
		private List<DatasetCorrelationGroupDtl> list;
		
		public DatasetGroupDetailBuilder()
		{
			list=new ArrayList<DatasetCorrelationGroupDtl>();
		}
		
		public DatasetGroupDetailBuilder add(DatasetCorrelationGroupDtl dtl)
		{
			list.add(dtl);
		
			return this;
		}
		
		public DatasetGroupDetailBuilder add(DatasetCorrelation dc,int chainType)
		{
			DatasetCorrelationGroupDtl dtl=new DatasetCorrelationGroupDtl();
			dtl.setDatasetCorrelation(dc);
			dtl.setChainType(chainType);
			list.add(dtl);
			return this;
		}

		public List<DatasetCorrelationGroupDtl> getList() {
			return list;
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
