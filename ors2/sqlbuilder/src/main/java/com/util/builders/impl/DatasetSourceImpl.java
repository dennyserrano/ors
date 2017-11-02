package com.util.builders.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import com.model.db.DatasetElement;
import com.model.db.DatasetHead;

import ph.gov.deped.common.util.ConvertUtil;
import ph.gov.deped.common.util.builders.interfaces.ColumnBuilder;
import ph.gov.deped.common.util.builders.interfaces.GroupByBuilder;
import ph.gov.deped.common.util.builders.interfaces.JoinBuilder;
import ph.gov.deped.common.util.builders.interfaces.OrderBuilder;
import ph.gov.deped.common.util.builders.interfaces.PrefixTableBuilder;
import ph.gov.deped.common.util.builders.interfaces.WhereBuilder;
import ph.gov.deped.data.dto.GenericKeyValue;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.dto.ds.Filter;

//mapRef is a reference conversion from Dataset to DatasetHead. a dataset could get via id to get its DatasetHead counterpart.
//note that Dataset is the parent and contains all the elements that the user chose. the subdatasets is just a tag on what are the tables involved in the join.

public class DatasetSourceImpl implements PrefixTableBuilder {

	private String alias;
	private Map<Long,DatasetHead> mapRef;
	private Dataset dataset;
	private List<Filter> filters;
	private List<Element> groupBy;
	private List<Element> orderBy;
	private List<Element> specialColumns;
	
	public DatasetSourceImpl(Dataset dataset, Map<Long,DatasetHead> mapRef)
	{
		this.dataset=dataset;
		this.mapRef=mapRef;
		groupBy=new ArrayList<Element>();
		orderBy=new ArrayList<Element>();
		specialColumns=new ArrayList<Element>();
	}
	
	@Override
	public void addColumn(Element element) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addSpecialColumn(Element element) {
		//TODO what if duplicate?
		specialColumns.add(element);
	}
	
	@Override
	public void addJoin(Dataset dataset) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void where(List<Filter> where) {
		filters=where;
	}

	@Override
	public void addGroupBy(Element group) {
		groupBy.add(group);
	}

	@Override
	public void addOrderBy(Element order) {
		// TODO Auto-generated method stub
		
	}

	
	
	@Override
	public PrefixTable build() {
		
		Dataset parentDataset=map(dataset, mapRef);
		ArrayList<Element> parentElementList=new ArrayList<>(parentDataset.getElements());
		parentDataset.getElements().clear();
		PrefixTable parentPT=ConvertUtil.toPrefixTable(parentDataset.getDatasetHead());
		parentPT.getColumns().clear();
		parentPT.setTablePrefix(getAlias(parentPT));
		
		for(Element e:specialColumns)
			parentPT.addColumn(ColumnBuilderFactory.get(e, "").build());
		
		for(Element e:parentElementList)
		{
			JoinBuilder jb=JoinBuilderFactory.get(e,e.getDatasetElement().getName());
			List<GenericKeyValue<PrefixTable, JoinProperty>> gvList=jb.build();
			if(gvList.size()!=0)
			{
				for(GenericKeyValue<PrefixTable, JoinProperty> gv:gvList)
				{
					parentPT.addJoin(gv.getKey(), gv.getValue());
					parentPT.addColumn(ColumnBuilderFactory.get(e, getPrefix(gv)).build());
				}
			}else
				parentPT.addColumn(ColumnBuilderFactory.get(e, getAlias(parentPT)).build());
			
			
			
			
		}
		
		
		for(Dataset child:parentDataset.getSubDatasets())
		{
			JoinBuilder jb=JoinBuilderFactory.interim(parentPT.getTablePrefix(),parentDataset,child.getDatasetHead().getTableMetaData().getTableName(),child); //joins statically by school_id and sy_from
			List<GenericKeyValue<PrefixTable, JoinProperty>> gvList=jb.build();
			for(GenericKeyValue<PrefixTable, JoinProperty> gv:gvList)
				parentPT.addJoin(gv.getKey(), gv.getValue());
			
			for(Element e:child.getElements())
			{
				jb=JoinBuilderFactory.get(e,e.getDatasetElement().getName());
				gvList=jb.build();
				if(gvList.size()!=0)
				{
					for(GenericKeyValue<PrefixTable, JoinProperty> gv:gvList)
					{
						parentPT.addJoin(gv.getKey(), gv.getValue());
						parentPT.addColumn(ColumnBuilderFactory.get(e, getPrefix(gv)).build());
					}
				}else
					parentPT.addColumn(ColumnBuilderFactory.get(e, child.getDatasetHead().getTableMetaData().getTableName()).build());
			}
			
		}
		
		
		DatasetCriteriaWhereBuilder wb=new DatasetCriteriaWhereBuilder(new WhereBuilderImpl(), mapRef,getAlias(parentPT));

		wb.addAll(getFilters());
		parentPT.setWhere(wb.build());
//		parentPT.setGroupBy(getGroupBy(new HashSet<ColumnElement>(), parentPT));
		
		//TODO Improve this
		for(Element e:groupBy)
			for(ColumnExpression cex:parentPT.getColumns())
			{
				if(cex instanceof ColumnElement)
				{
					ColumnElement ce=(ColumnElement) cex;
					if(e.getName().equals(ce.getElementName()))
						parentPT.getGroupBy().add(ce);
				}
				
			}
					
		return parentPT;
	}

	@Override
	public void setAlias(String alias) {
		this.alias=alias;
		
	}

	private GenericKeyValue<PrefixTable, JoinProperty> findTableInJoinList(List<GenericKeyValue<PrefixTable, JoinProperty>> list,long id)
	{
		for(GenericKeyValue<PrefixTable, JoinProperty> gv:list)
			if(gv.getKey().getDatasetId()==id)
				return gv;
		return null;
	}
	private String getAlias(PrefixTable pt)
	{
//		if(alias==null)
//			return pt.getTableName();
//		else
//			return alias;
		return "sp";
	}
	
	private String getPrefix(GenericKeyValue<PrefixTable, JoinProperty> gk)
	{
		return new TableWrapper(gk.getKey()).findTail().getTablePrefix();
	}
	
	private DatasetHead getFromRef(long id)
	{
		DatasetHead dh=mapRef.get(id);
		if(dh==null)
			throw new RuntimeException(); //establish a more specific error return
		
		return dh;
	}
	
	private Map<Long,DatasetElement> generateDatasetElementMap()
	{
		HashMap<Long,DatasetElement> hm=new HashMap<Long, DatasetElement>();
		for(DatasetHead dh:mapRef.values())
			for(DatasetElement de:dh.getDatasetElements())
				hm.put(de.getId(), de);
		
		return hm;
	}
	
	private Dataset map(Dataset parent,Map<Long,DatasetHead> mapRef)
	{
		parent.setDatasetHead(getFromRef(parent.getId()));
		
		HashMap<Long,Dataset> hm=new HashMap<>();
		hm.put(parent.getId(),parent);
		for(Dataset child:parent.getSubDatasets())
			{
				child.setElements(new ArrayList<Element>());
				hm.put(child.getId(), child);
			}
		
		Map<Long,DatasetElement> datasetElementMap=generateDatasetElementMap();
		ArrayList<Element> parentElements=new ArrayList<Element>();
		parentElements.addAll(parent.getElements());
		parent.setElements(new ArrayList<Element>());
		
		for(Element e:parentElements)
		{
			DatasetElement elem=datasetElementMap.get(e.getId());
			
			if(e.getName()==null)
				e.setName(elem.getName());
			
			Dataset ds=hm.get(elem.getDatasetHead().getId());
			ds.getElements().add(e);
		}
		
		for(Element e:parent.getElements())
			e.setDatasetElement(datasetElementMap.get(e.getId()));
		
		
		for(Dataset childDS:parent.getSubDatasets())
		{
			childDS.setDatasetHead(getFromRef(childDS.getId()));
			for(Element e:childDS.getElements())
				e.setDatasetElement(datasetElementMap.get(e.getId()));
		}
		
		return parent;
		
	}

	
	
	//TODO improve this, temporary
	private HashSet<ColumnElement> getGroupBy(HashSet<ColumnElement> hs,PrefixTable pt)
	{
		for(ColumnExpression ce:pt.getColumns())
			if(ce instanceof NestableColumnElement)
				hs.add(
							((AggregateColumn)((NestableColumnElement)ce).getInnerColumnElement()).getColumnElement()
							
						);
		
		
		for(PrefixTable childPT:pt.getJoinTables().keySet())
			getGroupBy(hs, childPT);
		
		return hs;
	}
	
	private List<Filter> getFilters()
	{
		if(filters==null)
			return new ArrayList<Filter>();
		else
			return filters;
	}
	
}
