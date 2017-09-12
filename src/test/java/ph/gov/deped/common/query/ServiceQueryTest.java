package ph.gov.deped.common.query;

import java.util.HashSet;

import ph.gov.deped.common.util.builders.impl.ColumnElement;
import ph.gov.deped.common.util.builders.impl.JoinInfo;
import ph.gov.deped.common.util.builders.impl.JoinProperty;
import ph.gov.deped.common.util.builders.impl.JoinPropertyBuilder;
import ph.gov.deped.common.util.builders.impl.PrefixTable;
import ph.gov.deped.data.dto.ConditionalOperatorType;
import ph.gov.deped.data.dto.JoinOperator;
import ph.gov.deped.data.ors.ds.DatasetCorrelation;
import ph.gov.deped.data.ors.ds.DatasetCorrelationDtl;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroupDtl;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.data.ors.meta.ColumnMetadata;
import ph.gov.deped.data.ors.meta.TableMetadata;
import ph.gov.deped.service.data.impl.ServiceQueryBuilderImpl;

public class ServiceQueryTest 
{
	public static void main(String[] args) {
		ServiceQueryBuilderImpl s=new ServiceQueryBuilderImpl();
		NestedElement[] elems=new NestedElement[2];
		elems[0]=new ServiceQueryTest().new NestedElement("col1", "col1");
		elems[1]=new ServiceQueryTest().new NestedElement("col2", "col2");
		
		
		PrefixTable table1=getPrefixTable("table1", "tb1");
		PrefixTable table2=getPrefixTable("table2", "tb2");
		PrefixTable table3=getPrefixTable("table3", "tb3");
		
		table1.addColumn(getColElement("field1",1));
		table1.addColumn(getColElement("field2",2));
		table2.addColumn(getColElement("fiel3",3));
		table2.addColumn(getColElement("field4",4));
		table3.addColumn(getColElement("field5", 5));
		
		table1.addJoin(table2, getJoinProps(table1.getTableName(),table1.getTablePrefix(), table2.getTableName(),table2.getTablePrefix(),elems));
		table1.addJoin(table3, getJoinProps(table1.getTableName(),table2.getTablePrefix(), table3.getTableName(),table3.getTablePrefix(),elems));
		System.out.println(s.getQuery(table1));
		
	}
	
	public static ColumnElement getColElement(String name,int colid)
	{
		DatasetElement de1=new DatasetElement();
		de1.setId(0L);
		de1.setDatasetHead(new DatasetHead(0L,"",0));
		
		ColumnElement c1=new ColumnElement(de1, new ColumnMetadata(colid, name,null, false, 0, 0L, false));
		
		return c1;
	}
	
	public static PrefixTable getPrefixTable(String name,String prefix)
	{
		DatasetHead d=new DatasetHead(0L, "", 0);
		d.setParentDatasetHead(0L);
		d.setRanking(0);
		PrefixTable pt=new PrefixTable(d, new TableMetadata(0, 0, "", name, "",""));
		pt.setTablePrefix(prefix);

		return pt;
	}
	
	public static JoinProperty getJoinProps(String left,String leftPrefix,String right,String rightPrefix,NestedElement[] nestedElems)
	{
		DatasetCorrelationGroupDtl groupDtl=new DatasetCorrelationGroupDtl();
		DatasetCorrelation dc=new DatasetCorrelation();
		dc.setLeftDataset(new DatasetHead(0L, left, 0));
		dc.setRightDataset(new DatasetHead(0L, right, 0));
		dc.setLeftTablePrefix(leftPrefix);
		dc.setRightTablePrefix(rightPrefix);
		dc.setDetails(new HashSet<DatasetCorrelationDtl>());
		
		for(NestedElement ne:nestedElems)
		{
			DatasetCorrelationDtl dtl1=new DatasetCorrelationDtl();
			DatasetElement de1=new DatasetElement();
			de1.setId(1L);
			de1.setName(ne.getLeftName());
			de1.setColumnMetaData(new ColumnMetadata(1, "", "", true, 0, 0L, true));
			de1.setDatasetHead(new DatasetHead(1L, "name", 0));
			DatasetElement de2=new DatasetElement();
			de2.setId(2L);
			de2.setColumnMetaData(new ColumnMetadata(2, "", "", true, 0, 0L, true));
			de2.setName(ne.getRightName());
			de2.setDatasetHead(new DatasetHead(1L, "", 0));
			dtl1.setLeftElement(de1);
			dtl1.setRightElement(de2);
			dc.getDetails().add(dtl1);
		}
		
		
		
		groupDtl.setDatasetCorrelation(dc);
		
		return new JoinPropertyBuilder().build(groupDtl);
	}
	
	public static JoinInfo<ColumnElement,ColumnElement> getJoinInfo(String leftField,int leftFieldId,String rightField,int rightFieldId)
	{
		return new JoinInfo<ColumnElement, ColumnElement>(getColElement(leftField, leftFieldId), getColElement(rightField, rightFieldId),null);
	}
	
	public static JoinOperator getJoinOp(String fieldLeft,int leftId,String fieldRight,int rightId,ConditionalOperatorType op)
	{
		return new JoinOperator(getJoinInfo(fieldLeft,leftId,fieldRight,rightId),op);
	}
	
	class NestedElement
	{
		private String leftName;
		private String rightName;
		
		
		
		public NestedElement(String leftName, String rightName) {
			super();
			this.leftName = leftName;
			this.rightName = rightName;
		}
		public String getLeftName() {
			return leftName;
		}
		public void setLeftName(String leftName) {
			this.leftName = leftName;
		}
		public String getRightName() {
			return rightName;
		}
		public void setRightName(String rightName) {
			this.rightName = rightName;
		}
		
		
		
	}
}
