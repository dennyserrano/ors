package ph.gov.deped.common.util.builders2.impl;

import java.util.Map;

import ph.gov.deped.common.util.builders2.interfaces.ColumnBuilder;
import ph.gov.deped.common.util.builders2.interfaces.GroupByBuilder;
import ph.gov.deped.common.util.builders2.interfaces.JoinBuilder;
import ph.gov.deped.common.util.builders2.interfaces.OrderBuilder;
import ph.gov.deped.common.util.builders2.interfaces.PrefixTableBuilder;
import ph.gov.deped.common.util.builders2.interfaces.WhereBuilder;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.dto.ds.Filter;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;

public class DatasetSourceImpl implements PrefixTableBuilder<Dataset, Element, Filter, Element, Element> {

	private ColumnBuilder columnBuilder;
	private OrderBuilder orderBuilder;
	private JoinBuilder joinBuilder;
	private WhereBuilder whereBuilder;
	private GroupByBuilder groupBuilder;
	private PrefixTableBuilder<DatasetHead, DatasetElement,Filter,DatasetElement,DatasetElement> parentTransformer;
	private String alias;
	
	public DatasetSourceImpl(Dataset dataset, Map<Long,DatasetHead> mapRef)
	{
		joinBuilder=JoinBuilderFactory.get(null, null);
		joinBuilder.build();
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
		
		return null;
	}

	@Override
	public void setAlias(String alias) {
		this.alias=alias;
		
	}

}
