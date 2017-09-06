package ph.gov.deped.common.util.builders2.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import ph.gov.deped.common.util.builders.CorrelationGroupBuilder;
import ph.gov.deped.common.util.builders.JoinProperty;
import ph.gov.deped.common.util.builders.JoinPropertyBuilder;
import ph.gov.deped.common.util.builders2.interfaces.JoinBuilder;
import ph.gov.deped.data.dto.GenericKeyValue;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;

public class JoinBuilderDatasetElementImpl implements JoinBuilder {

	private DatasetElement de;
	private DatasetHead parent;
	private CorrelationGroupBuilder groupBuilder=new CorrelationGroupBuilder();
	protected JoinBuilderDatasetElementImpl(DatasetHead parent,DatasetElement e)
	{
		de=e;
		this.parent=parent;
	}
	
	@Override
	public List<GenericKeyValue<PrefixTable, JoinProperty>> build() {
		PrefixTable pt=groupBuilder.build(parent.getId(), de.getDatasetCorrelationGroup());
		ArrayList<GenericKeyValue<PrefixTable, JoinProperty>> al=new ArrayList<>();
		for(Entry<PrefixTable, JoinProperty> es:pt.getJoinTables().entrySet())
			al.add(new GenericKeyValue<PrefixTable, JoinProperty>(es.getKey(),es.getValue()));
		return al;
	}

}
