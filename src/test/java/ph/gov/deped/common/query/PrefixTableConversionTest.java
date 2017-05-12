package ph.gov.deped.common.query;

import java.util.ArrayList;
import java.util.HashSet;
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
		de.setDatasetCorrelationGroup(getGroup());
		dh.getDatasetElements().add(de);
		dh.getDatasetElements().add(build("col2","col2"));
		dh.getDatasetElements().add(build("col3","col3"));
		PrefixTable resPt=tableBuilder.build(dh);
		
		
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
	
	private static DatasetCorrelationGroup getGroup()
	{
		DatasetCorrelationGroup g= new DatasetCorrelationGroup();
		g.setGroupDetails(new ArrayList<DatasetCorrelationGroupDtl>());
		g.getGroupDetails().add(getGroupDtl(buildDh(1L,"dataset1","table1"), buildDh(4L,"dataset2","table2"), 1));
		return g;
	}
	
	private static DatasetCorrelationGroupDtl getGroupDtl(DatasetHead left,DatasetHead right,int chainType)
	{
		DatasetCorrelationGroupDtl dtl= new DatasetCorrelationGroupDtl();
		DatasetCorrelation dc= new DatasetCorrelation();
		dc.setLeftDataset(left);
		dc.setRightDataset(right);
		
		DatasetCorrelationDtl dtl1=new DatasetCorrelationDtl();
		dtl1.setLeftElement(build("c1","c1"));
		dtl1.setRightElement(build("c2","c2"));
		
		
		dc.setDetails(new HashSet<DatasetCorrelationDtl>());
		dc.getDetails().add(dtl1);
		
		dtl.setChainType(chainType);
		dtl.setDatasetCorrelation(dc);
		
		return dtl;
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
	
}
