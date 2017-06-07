package ph.gov.deped.common.util.builders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.bits.sql.FilterType;
import com.bits.sql.JoinType;
import com.bits.sql.Operator;

import ph.gov.deped.common.OperatorUserType;
import ph.gov.deped.common.util.ConvertUtil;
import ph.gov.deped.common.util.builders.JoinPropertyBuilder.JoinPropertyManualBuilder;
import ph.gov.deped.data.Conjunctive;
import ph.gov.deped.data.Operational;
import ph.gov.deped.data.Where;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.GenericKeyValue;
import ph.gov.deped.data.dto.KeyValue;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.ds.Filter;
import ph.gov.deped.data.dto.interfaces.TableColumn;
import ph.gov.deped.data.ors.ds.DatasetCriteria;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;

//This defines the formation of star schema.
//the given heads are the children that to be joined into the parent table
//the parent table (i.e school_profile_history) is fixed currently.

public class StarSchemaChainImpl implements TableChainer {

	private PrefixTableBuilder tableBuilder;
	private static final String[] MANDATORY_FIELDS=new String[]{"sy_from","region_shortname","division_name","school_id","school_name"};
	private static final String[] JOINING_ELEMENTS=new String[]{"sy_from"};
	
	private static final Map<Long,DatasetCriteria> CRITERIA; //this should be placed in a property file and not in a table
	
	static
	{	
		CRITERIA=new HashMap<Long, DatasetCriteria>();
		CRITERIA.put(8L, new DatasetCriteria(8L,null,FilterType.VALUE,new DatasetElement(308L),new Operator() {public String get() {return null;}public String getName() {return "EQ";}},false,""));
		CRITERIA.put(9L, new DatasetCriteria(9L,null,FilterType.VALUE,new DatasetElement(309L),new Operator() {public String get() {return null;}public String getName() {return "EQ";}},false,""));
		CRITERIA.put(10L, new DatasetCriteria(10L,null,FilterType.VALUE,new DatasetElement(310L),new Operator() {public String get() {return null;}public String getName() {return "EQ";}},false,""));
		CRITERIA.put(11L, new DatasetCriteria(11L,null,FilterType.VALUE,new DatasetElement(311L),new Operator() {public String get() {return null;}public String getName() {return "EQ";}},false,""));
		CRITERIA.put(12L, new DatasetCriteria(12L,null,FilterType.VALUE,new DatasetElement(312L),new Operator() {public String get() {return null;}public String getName() {return "EQ";}},false,""));
		CRITERIA.put(15L, new DatasetCriteria(13L,null,FilterType.VALUE,new DatasetElement(266L),new Operator() {public String get() {return null;}public String getName() {return "EQ";}},false,""));
		CRITERIA.put(16L, new DatasetCriteria(14L,null,FilterType.VALUE,new DatasetElement(267L),new Operator() {public String get() {return null;}public String getName() {return "EQ";}},false,""));
		CRITERIA.put(17L, new DatasetCriteria(15L,null,FilterType.VALUES,new DatasetElement(10936L),new Operator() {public String get() {return null;}public String getName() {return "IN";}},false,""));
		CRITERIA.put(18L, new DatasetCriteria(16L,null,FilterType.VALUES,new DatasetElement(10937L),new Operator() {public String get() {return null;}public String getName() {return "IN";}},false,""));
	}
	
	public StarSchemaChainImpl()
	{
		tableBuilder=new PrefixTableBuilder();
	}
	
	
	public PrefixTable chain(DatasetHead parent, List<DatasetHead> children, List<Filter> transactionFilters)
	{
		
		HashSet<DatasetElement> mandatoryFieldList=new HashSet<>();
		HashSet<DatasetElement> joinElementList=new HashSet<>();
		
		for(DatasetElement de:parent.getDatasetElements())
			{
				for(String mandatoryName:MANDATORY_FIELDS)
					if(de.getName().equals(mandatoryName))
						mandatoryFieldList.add(de);
				
				for(String joinElement:JOINING_ELEMENTS)
					if(de.getName().equals(joinElement))
						joinElementList.add(de);
			}
		
		
		
		PrefixTable parentPT=convertParent(parent);
		
		ArrayList<PrefixTable> childrenPrefixList=new ArrayList<PrefixTable>();
		ArrayList<GenericKeyValue<PrefixTable, JoinPropertyManualBuilder>> childConvertedList=new ArrayList<GenericKeyValue<PrefixTable,JoinPropertyManualBuilder>>();
		
		for(DatasetHead child:children)
		{
			GenericKeyValue<PrefixTable, JoinPropertyManualBuilder> gkv=convertChild(parentPT, child, joinElementList);
			childConvertedList.add(gkv);
			childrenPrefixList.add(gkv.getKey());
		}
		
		ArrayList<PrefixTable> combined=new ArrayList<PrefixTable>();
		combined.add(parentPT);
		combined.addAll(childrenPrefixList);
		
		Map<Long,ColumnElement> elementMap=findElementsRelatedToCriteria(combined, CRITERIA);
		
		combined.clear();
		WhereBuilder whereBuilder=new WhereBuilder();
		//TODO: Improve this code....
		Filter firstFilter=null;
		
		List<Filter> filters=transactionFilters.stream().filter(e->{
			boolean valid=false;
			for(KeyValue kv:e.getSelectedOptions())
				valid |=!kv.getKey().isEmpty();
			return valid;
			
			}).collect(Collectors.toList());
		
		
		for(Filter filter:filters)
		{
			if(!CRITERIA.containsKey(filter.getCriterion()))
				throw new RuntimeException(String.format("No criteria defined for filter id %s",filter.getCriterion()));
			
			DatasetCriteria criteria=CRITERIA.get(filter.getCriterion());
			ColumnElement columnElement=elementMap.get(criteria.getLeftElement().getId());
			
				
			
			if(firstFilter==null)
			{
				whereBuilder.where(columnElement.getTablePrefix(),columnElement.getColumnName(), filter.getSelectedOptions().get(0).getKey(), criteria.getOperator().getName());
				firstFilter=filter;
				continue;
			}
			if(criteria.getOperator().getName().equals("EQ"))
				whereBuilder.addCriteria(columnElement.getTablePrefix(),columnElement.getColumnName(), filter.getSelectedOptions().get(0).getKey(),criteria.getOperator().getName());
			else if(criteria.getOperator().getName().equals("IN"))
				whereBuilder.addCriteria(columnElement.getTablePrefix(),columnElement.getColumnName(), toArray(filter.getSelectedOptions(),columnElement.getDataType()));
			else
				throw new RuntimeException(String.format("No Available operator for %s in StarSchemaImp while trying to chain with filters",criteria.getOperator().getName()));
		}
		parentPT.getColumns().clear();
		for(DatasetElement de:mandatoryFieldList)
			parentPT.getColumns().add(ConvertUtil.toColumnElement(de));
		
		//joining of children
		for(GenericKeyValue<PrefixTable, JoinPropertyManualBuilder> gkv:childConvertedList)
			parentPT.addJoin(gkv.getKey(), gkv.getValue().build());
		
		for(TableColumn tc:parentPT.getColumns())
		{
			ColumnElement ce=(ColumnElement) tc;
			if(ce.getTablePrefix()==null)
				ce.setTablePrefix(parentPT.getTablePrefix());
		}
		
		parentPT.setWhere(whereBuilder.getWhere());
		return parentPT;
	}
	
	
	private PrefixTable convertParent(DatasetHead parent)
	{
		PrefixTable parentPT=ConvertUtil.toPrefixTable(parent);
		parentPT.setTablePrefix("sph");
		for(TableColumn tc:parentPT.getColumns())
		{
			ColumnElement ce=(ColumnElement)tc;
			ce.setTablePrefix(parentPT.getTablePrefix());
		}
			
		
		return parentPT;
	}
	
	private GenericKeyValue<PrefixTable, JoinPropertyManualBuilder> convertChild(PrefixTable parentPT,DatasetHead child,HashSet<DatasetElement> joinElementList)
	{
		JoinPropertyManualBuilder jpBuilder=new JoinPropertyBuilder().getManualBuilder();
		PrefixTable childPrefixTable= tableBuilder.build(child);
		for(DatasetElement joinElement:joinElementList)
		{
			jpBuilder.add(parentPT.getTablePrefix(), joinElement.getName(), childPrefixTable.getTablePrefix(), joinElement.getName());
			jpBuilder.set(JoinType.LEFT_JOIN);
		}
		
		return new GenericKeyValue<PrefixTable, JoinPropertyBuilder.JoinPropertyManualBuilder>(childPrefixTable, jpBuilder);
	}
	
	private Map<Long,ColumnElement> findElementsRelatedToCriteria(List<PrefixTable> prefixTables,Map<Long,DatasetCriteria> criteriaList)
	{
		HashMap<Long,ColumnElement> hm=new HashMap<Long, ColumnElement>();
		for(DatasetCriteria criteria:criteriaList.values())
			for(PrefixTable dh:prefixTables)
			{
				boolean childFound = false;
				for(TableColumn tc:dh.getColumns())
				{
					ColumnElement ce=(ColumnElement) tc;
					if(ce.getElementId()==criteria.getLeftElement().getId().longValue())
					{
						hm.put(ce.getElementId(), ce);
						childFound=true;
						break;
					}
				}
				
				if(childFound)
					break;
			}		
		
		return hm;
	}

	
	private ArrayList<GenericKeyValue<Serializable, String>> toArray(List<KeyValue> kv,String dataType)
	{
		ArrayList<GenericKeyValue<Serializable, String>> list=new ArrayList<GenericKeyValue<Serializable, String>>();
		for(int x=0;x<kv.size();x++)
				list.add(new GenericKeyValue<Serializable, String>(kv.get(x).getKey(),dataType));
			
		return list;
	}
	
	class WhereBuilder
	{
		private Where where;
		private Conjunctive conjunctive;
		
		WhereBuilder()
		{
			where=new Where();
		}
		
		public WhereBuilder addCriteria(String tablePrefix,String fieldName,Object value,String operator)
		{
			if(where.getFieldName()==null)
				throw new RuntimeException("where() needs to be invoke first");
			
			
			if(value==null || value.toString().equals(""))
				return this;
			
			Operational operational=conjunctive.and( tablePrefix,fieldName);
			if(operator.equals("EQ"))
				conjunctive=operational.eq(value.toString());
			
			return this;
		}
		
		public WhereBuilder addCriteria(String tablePrefix,String fieldName,List<GenericKeyValue<Serializable, String>> list)
		{
			if(where.getFieldName()==null)
				throw new RuntimeException("where() needs to be invoke first");
			
			Operational operational=conjunctive.and(tablePrefix,fieldName);
			conjunctive=operational.in(list);
			
			return this;
		}
		
		public WhereBuilder where(String tablePrefix,String fieldName,Object value,String operator)
		{
			conjunctive=where.where(fieldName,tablePrefix).eq(value.toString());
			return this;
		}
		
		public Where getWhere()
		{
			return where;
		}
	}
	

	
	
}
