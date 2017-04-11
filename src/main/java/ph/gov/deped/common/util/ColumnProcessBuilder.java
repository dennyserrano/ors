package ph.gov.deped.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.ors.ds.DatasetHead;

public class ColumnProcessBuilder 
{
	private PrefixTableMapBuilder prefixTableBuilder;
	private List<DatasetHead> datasetHeads;
	private List<Element> elements;
	public ColumnProcessBuilder(List<DatasetHead> datasetHeads, List<Element> elements) {
		prefixTableBuilder=new PrefixTableMapBuilder(datasetHeads, elements);
		this.datasetHeads=datasetHeads;
		this.elements=elements;
	}
	
	public List<ColumnElement> build()
	{
		Map<Long,PrefixTable> mapTable= prefixTableBuilder.build();
		ArrayList<ColumnElement> list=new ArrayList<ColumnElement>();
		
		mapTable.forEach((k,v)->{
			list.addAll(v.getColumns());
		});
		
		sort(list,this.elements);
		
		return list;
	}
	
	private List<ColumnElement> sort(List<ColumnElement> columnElements,List<Element> elements)
	{
		ArrayList<ColumnElement> al=new ArrayList<ColumnElement>();
		for(Element e:elements)
			for(ColumnElement ce:columnElements)
				if(e.getName().equals(ce.getColumnName()))
					{
						al.add(ce);
						break;
					}
		return al;
	}
	
}
