package ph.gov.deped.common.util.builders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.bits.sql.FilterType;
import com.bits.sql.Operator;

import ph.gov.deped.common.util.builders2.interfaces.FilterComparator;
import ph.gov.deped.common.util.builders2.interfaces.FilterConjunctor;
import ph.gov.deped.common.util.builders2.interfaces.FilterWhere;
import ph.gov.deped.common.util.builders2.interfaces.WhereBuilder;
import ph.gov.deped.data.Where;
import ph.gov.deped.data.dto.ds.Filter;
import ph.gov.deped.data.ors.ds.DatasetCriteria;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;

public class DatasetCriteriaWhereBuilder implements WhereBuilder {

	
	private static final Map<Long,DatasetCriteria> CRITERIA; //this should be placed in a property file and not in a table
	private FilterWhere filterWhere;
	private List<Filter> filters;
	private Map<Long,DatasetHead> mapRef;
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
		CRITERIA.put(19L, new DatasetCriteria(16L,null,FilterType.VALUES,new DatasetElement(11237L),new Operator() {public String get() {return null;}public String getName() {return "EQ";}},false,""));
		CRITERIA.put(22L, new DatasetCriteria(16L,null,FilterType.VALUES,new DatasetElement(11238L),new Operator() {public String get() {return null;}public String getName() {return "EQ";}},false,""));
		CRITERIA.put(23L, new DatasetCriteria(16L,null,FilterType.VALUES,new DatasetElement(11236L),new Operator() {public String get() {return null;}public String getName() {return "EQ";}},false,""));
		CRITERIA.put(24L, new DatasetCriteria(16L,null,FilterType.VALUES,new DatasetElement(11239L),new Operator() {public String get() {return null;}public String getName() {return "EQ";}},false,""));
	}
	
	
	public DatasetCriteriaWhereBuilder(FilterWhere whereBuilder,Map<Long,DatasetHead> mapRef){
		filters=new ArrayList<Filter>();
		this.filterWhere=whereBuilder;
		this.mapRef=mapRef;
	}
	
	public void addAll(List<Filter> f)
	{
		filters.addAll(f);
	}
	
	@Override
	public Where build() {
		
		
		HashMap<DatasetCriteria,Filter> map=new HashMap<DatasetCriteria,Filter>();
		
		for(Filter f:filters)
		{
			
			if(f.getSelectedOptions().get(0).getKey().equals(""))
				continue;
			
			DatasetCriteria dc= CRITERIA.get(f.getCriterion());
			
			DatasetElement leftElement=find(dc.getLeftElement().getId(),mapRef);
			
			if(leftElement==null)
				throw new RuntimeException("Unable to find a criteria out of a given reference");
			
			dc.setLeftElement(leftElement);
			map.put(dc, f);
		}
		
		FilterComparator fc=null;
		FilterConjunctor fcj=null;
		for(Entry<DatasetCriteria, Filter> es:map.entrySet())
		{
			if(fc==null)
			{
				fcj=filterWhere.where("", es.getKey().getLeftElement().getName()).eq(es.getValue().getSelectedOptions().get(0).getKey());
				continue;
			}
			//Filter type?
			fcj.and("", es.getKey().getLeftElement().getName()).eq(es.getValue().getSelectedOptions().get(0).getKey());
			
			
		}
		
		return null;
	}

	
	private DatasetElement find(long id,Map<Long,DatasetHead> mapRef)
	{
		for(DatasetHead dh:mapRef.values())
			for(DatasetElement de:dh.getDatasetElements())
				if(id==de.getId())
					return de;
		return null;
	}
	
}
