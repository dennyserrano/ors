package ph.gov.deped.common.util.builders2.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.GenericKeyValue;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.dto.ds.Filter;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;

//mapRef is a reference conversion from Dataset to DatasetHead. a dataset could get via id to get its DatasetHead counterpart.

public class DatasetSourceImpl implements PrefixTableBuilder<Dataset, Element, Filter, Element, Element> {

	private ColumnBuilder columnBuilder;
	private OrderBuilder orderBuilder;
	private JoinBuilder joinBuilder;
	private WhereBuilder whereBuilder;
	private GroupByBuilder groupBuilder;
	private PrefixTableBuilder<DatasetHead, DatasetElement,Filter,DatasetElement,DatasetElement> parentTransformer;
	private String alias;
	private Map<Long,DatasetHead> mapRef;
	private Dataset dataset;
	public DatasetSourceImpl(Dataset dataset, Map<Long,DatasetHead> mapRef)
	{
		this.dataset=dataset;
		this.mapRef=mapRef;
	}
	
	@Override
	public void addColumn(Element element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addJoin(Dataset dataset) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addWhere(Filter filter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGroupBy(Element group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOrderBy(Element order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PrefixTable build() {
		
		
		DatasetHead parentDH=getFromRef(dataset.getId());
		ArrayList<DatasetHead> childrenDH=new ArrayList<DatasetHead>();
		
		for(Dataset subDataset:dataset.getSubDatasets())
			childrenDH.add(getFromRef(subDataset.getId()));
		
		
		PrefixTable parentPT=ConvertUtil.toPrefixTable(parentDH);
		parentPT.getColumns().clear();
		parentPT.setTablePrefix("sp");
		for(DatasetElement de:parentDH.getDatasetElements())
		{
			JoinBuilder jb= JoinBuilderFactory.get(de);
			List<GenericKeyValue<PrefixTable, JoinProperty>> l= jb.build();
			
			for(GenericKeyValue<PrefixTable, JoinProperty> gk:l)
			{
				parentPT.addColumn(new ColumnElement(de.getColumnMetaData().getColumnName(),getPrefix(gk)));
				parentPT.addJoin(gk.getKey(), gk.getValue());
			}
			
			parentPT.addColumn(new ColumnElement(de.getColumnMetaData().getColumnName(),parentPT.getTablePrefix()));
		}
		
		for(DatasetHead child:childrenDH)
		{
			JoinBuilder jb=JoinBuilderFactory.get(parentDH, child);
			List<GenericKeyValue<PrefixTable, JoinProperty>> l= jb.build();
			for(GenericKeyValue<PrefixTable, JoinProperty> gk:l)
			parentPT.addJoin(gk.getKey(), gk.getValue());
		}
		return parentPT;
	}

	@Override
	public void setAlias(String alias) {
		this.alias=alias;
		
	}

	
	private String getPrefix(GenericKeyValue<PrefixTable, JoinProperty> gk)
	{
		return new TableWrapper(gk.getKey()).findTail().getTablePrefix();
	}
	
	private DatasetHead getFromRef(long id)
	{
		DatasetHead dh=mapRef.get(id);
		if(dh==null)
			throw new RuntimeException();
		
		return dh;
	}
	
}
