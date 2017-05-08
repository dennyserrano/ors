package ph.gov.deped.common.query;

import java.util.ArrayList;
import java.util.HashSet;

import ph.gov.deped.common.util.builders.PrefixTableBuilder;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.ors.ds.DatasetCorrelation;
import ph.gov.deped.data.ors.ds.DatasetCorrelationDtl;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroup;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroupDtl;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.data.ors.meta.ColumnMetadata;
import ph.gov.deped.data.ors.meta.TableMetadata;

public class PrefixTableConversionTest
{
	
	static PrefixTableBuilder tableBuilder=new PrefixTableBuilder();
	public static void main(String[] args) {
		
		DatasetHead dh=new DatasetHead(1L,"main",1);
		dh.setParentDatasetHead(1L);
		dh.setTableMetaData(new TableMetadata(1, 1, "","", "", ""));
		dh.setRanking(1);
		dh.setDatasetElements(new HashSet<DatasetElement>());
		DatasetElement de= build("col1");
		de.setDatasetCorrelationGroup(getGroup());
		dh.getDatasetElements().add(de);
		dh.getDatasetElements().add(build("col2"));
		dh.getDatasetElements().add(build("col3"));
		PrefixTable resPt=tableBuilder.build(dh);
		System.out.println();
	}
	
	private static DatasetElement build(String name)
	{
		DatasetElement de= new DatasetElement();
		de.setId(1L);
		de.setColumnId(1);
		de.setName(name);
		de.setColumnMetaData(new ColumnMetadata(1, "", "", false, 0, 1L, false));
		de.setDatasetHead(buildDh("dummy"));
		return de;
	}
	
	private static DatasetCorrelationGroup getGroup()
	{
		DatasetCorrelationGroup g= new DatasetCorrelationGroup();
		g.setGroupDetails(new ArrayList<DatasetCorrelationGroupDtl>());
		g.getGroupDetails().add(getGroupDtl(buildDh("dataset1"), buildDh("dataset2"), 1));
		return g;
	}
	
	private static DatasetCorrelationGroupDtl getGroupDtl(DatasetHead left,DatasetHead right,int chainType)
	{
		DatasetCorrelationGroupDtl dtl= new DatasetCorrelationGroupDtl();
		DatasetCorrelation dc= new DatasetCorrelation();
		dc.setLeftDataset(left);
		dc.setRightDataset(right);
		
		DatasetCorrelationDtl dtl1=new DatasetCorrelationDtl();
		dtl1.setLeftElement(build("c1"));
		dtl1.setRightElement(build("c2"));
		
		
		dc.setDetails(new HashSet<DatasetCorrelationDtl>());
		dc.getDetails().add(dtl1);
		
		dtl.setChainType(chainType);
		dtl.setDatasetCorrelation(dc);
		
		return dtl;
	}
	
	private static DatasetHead buildDh(String name)
	{
		DatasetHead dh= new DatasetHead(1L, name, 0);
		dh.setTableMetaData(new TableMetadata(1,1, "", "table1", "", ""));
		dh.setParentDatasetHead(1L);
		dh.setRanking(1);
		return dh;
	}
	
}
