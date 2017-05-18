package ph.gov.deped.common.util.builders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import ph.gov.deped.common.util.ConvertUtil;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.interfaces.TableColumn;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroup;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;

class AutoJoinFinder 
{
	
	
	private CorrelationGroupBuilder correlationGroupBuilder;
	
	public AutoJoinFinder(CorrelationGroupBuilder cgb)
	{
		correlationGroupBuilder=cgb;
	}
	
	AutoJoinTableResult find(DatasetHead dh)
	{
		HashMap<PrefixTable,JoinProperty> map=new HashMap<PrefixTable, JoinProperty>();
		Map<DatasetCorrelationGroup, List<DatasetElement>> correlationMap=mergeColElementGroup(dh.getDatasetElements());
		
		//assignment of the parent table prefix is done via reference
		//so upon invocation of correlationGroupBuilder.build(), the head.tablePrefix is filled with the parent prefix
		//which is via DatasetCorrelation
		PrefixTable head=ConvertUtil.toPrefixTable(dh);
		for(Entry<DatasetCorrelationGroup, List<DatasetElement>> entrySet:correlationMap.entrySet())
		{
			Map<PrefixTable, JoinProperty> corResult=correlationGroupBuilder.build(head,entrySet.getKey());
			TableWrapper tw=new TableWrapper(getFirst(corResult));
			PrefixTable tail=tw.findTail();
			for(DatasetElement targetElement:entrySet.getValue())
			{
				Optional<TableColumn> optionalCe=head.getColumns().stream().filter(e->{
					if(e instanceof ColumnElement)						
						return ((ColumnElement) e).getColumnName().equals(targetElement.getName());
					else 
						return false;
				}).findFirst();
				ColumnElement ce=(ColumnElement) optionalCe.get();
				ce.setTablePrefix(tail.getTablePrefix());
			}
			map.putAll(corResult);
		}
			
		
		
		return new AutoJoinTableResult(head, map);
	}
	
	
	private PrefixTable getFirst(Map<PrefixTable, JoinProperty> m)
	{
		return new LinkedList<>(m.keySet()).getFirst();
	}
	
	protected class AutoJoinTableResult
	{
		private PrefixTable head;
		private Map<PrefixTable, JoinProperty> map;
		public AutoJoinTableResult(PrefixTable head, Map map) {
			super();
			this.head = head;
			this.map = map;
		}
		public PrefixTable getHeadPrefix() {
			return head;
		}
		public Map<PrefixTable, JoinProperty> getMap() {
			return map;
		}
		
		
	}

	
	private Map<DatasetCorrelationGroup,List<DatasetElement>> mergeColElementGroup(Set<DatasetElement> ce)
	{
		
		HashMap<DatasetCorrelationGroup, List<DatasetElement>> hm=new HashMap<DatasetCorrelationGroup, List<DatasetElement>>();
		
		for(DatasetElement element:ce)
		{
			DatasetCorrelationGroup corGroup= element.getDatasetCorrelationGroup();
			if(corGroup!=null)
				if(hm.containsKey(corGroup))				
					hm.get(corGroup).add(element);
				else
				{
					ArrayList<DatasetElement> list=new ArrayList<DatasetElement>();
					list.add(element);
					hm.put(corGroup, list);
				}
				
		}
		return hm;
	}
	
}
