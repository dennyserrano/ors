package ph.gov.deped.common.util.builders2.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import ph.gov.deped.common.util.ConvertUtil;
import ph.gov.deped.common.util.builders.JoinProperty;
import ph.gov.deped.common.util.builders.JoinPropertyBuilder;
import ph.gov.deped.common.util.builders.TableWrapper;
import ph.gov.deped.common.util.builders2.interfaces.ColumnBuilder;
import ph.gov.deped.common.util.builders2.interfaces.GroupByBuilder;
import ph.gov.deped.common.util.builders2.interfaces.JoinBuilder;
import ph.gov.deped.common.util.builders2.interfaces.OrderBuilder;
import ph.gov.deped.common.util.builders2.interfaces.PrefixTableBuilder;
import ph.gov.deped.common.util.builders2.interfaces.WhereBuilder;
import ph.gov.deped.data.Where;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.ColumnExpression;
import ph.gov.deped.data.dto.GenericKeyValue;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.dto.ds.Filter;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;

//mapRef is a reference conversion from Dataset to DatasetHead. a dataset could get via id to get its DatasetHead counterpart.

public class DatasetSourceImpl implements PrefixTableBuilder<Dataset, Element, Where, Element, Element> {

	private PrefixTableBuilder<DatasetHead, DatasetElement,Filter,DatasetElement,DatasetElement> parentTransformer;
	private String alias;
	private Map<Long,DatasetHead> mapRef;
	private Dataset dataset;
	private Where where;
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
	public void where(Where where) {
		this.where=where;
	}

	@Override
	public void addGroupBy(Element group) {
		
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
			for(GenericKeyValue<PrefixTable, JoinProperty> gv:gvList)
			{
				parentPT.addJoin(gv.getKey(), gv.getValue());
				parentPT.addColumn(ColumnBuilderFactory.get(e, getPrefix(gv)).build());
			}
			
		}
		
		
		for(Dataset child:parentDataset.getSubDatasets())
		{
			JoinBuilder jb=JoinBuilderFactory.interim(parentPT.getTablePrefix(),parentDataset,child.getDatasetHead().getTableMetaData().getTableName(),child); //joins statically by school_id and sy_from
			List<GenericKeyValue<PrefixTable, JoinProperty>> gvList=jb.build();
			for(GenericKeyValue<PrefixTable, JoinProperty> gv:gvList)
			{
				parentPT.addJoin(gv.getKey(), gv.getValue());
				for(Element e:child.getElements())
					gv.getKey().addColumn(ColumnBuilderFactory.get(e, child.getDatasetHead().getTableMetaData().getTableName()).build());
			}
		}
		
		parentPT.setWhere(where);
		parentPT.setGroupBy(getGroupBy(new HashSet<ColumnElement>(), parentPT));
		
		
		
		return parentPT;
	}

	@Override
	public void setAlias(String alias) {
		this.alias=alias;
		
	}

	private String getAlias(PrefixTable pt)
	{
		if(alias==null)
			return pt.getTableName();
		else
			return alias;
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
	
}
