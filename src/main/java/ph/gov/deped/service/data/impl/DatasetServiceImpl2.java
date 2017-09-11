package ph.gov.deped.service.data.impl;

import static java.lang.String.format;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bits.sql.AggregateTypes;
import com.bits.sql.JdbcTypes;

import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.common.util.ConvertUtil;
import ph.gov.deped.common.util.builders.PrefixTableMapBuilder;
import ph.gov.deped.common.util.builders.StarSchemaChainImpl;
import ph.gov.deped.common.util.builders.TableChainer;
import ph.gov.deped.common.util.builders2.impl.DatasetSourceImpl;
import ph.gov.deped.common.util.builders2.impl.WhereBuilderImpl;
import ph.gov.deped.common.util.builders2.interfaces.FilterComparator;
import ph.gov.deped.common.util.builders2.interfaces.FilterConjunctor;
import ph.gov.deped.common.util.builders2.interfaces.FilterWhere;
import ph.gov.deped.common.util.builders2.interfaces.PrefixTableBuilder;
import ph.gov.deped.common.util.builders2.interfaces.WhereBuilder;
import ph.gov.deped.data.Where;
//import ph.gov.deped.common.util.builders.StarSchemaChainImpl;
//import ph.gov.deped.common.util.builders.TableChainer;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.KeyValue;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.dto.ds.Filter;
import ph.gov.deped.data.dto.interfaces.Aggregatable;
import ph.gov.deped.data.dto.interfaces.TableColumn;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroup;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroupDtl;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;
import ph.gov.deped.service.data.api.DatasetService;
import ph.gov.deped.service.data.api.ServiceQueryBuilder;
import ph.gov.deped.data.ors.ds.DatasetCorrelation;
import ph.gov.deped.data.ors.meta.ColumnMetadata;

import javax.sql.DataSource;

@Service
public class DatasetServiceImpl2 implements DatasetService
{

	private static final Logger log = LogManager.getLogger(DatasetServiceImpl2.class);
	
	private static final long PARENT_ID=8L;
	
	@Autowired
	private DatasetRepository datasetRepository;
	
	private TableChainer tableChainer;
	
	private static final String[] JOINING_ELEMENTS=new String[]{"sy_from","school_id"};
	
	private static final long[] MANDATORY_IDS=new long[]{266,267,268,281,285,286,282,283,284};
	
	private static final String COUNT_DATASET_HEAD_NAME="CountDatasetHead"; // temporary
	
	@Autowired @Qualifier(AppMetadata.DS)
	private DataSource dataSource;
	
	@Override
	public List<List<ColumnElement>> getData(Dataset dataset,boolean previewOnly) {

		dataset.setId(8L);
		ServiceQueryBuilder serviceQueryBuilder=new ServiceQueryBuilderImpl();
		
		ArrayList<Long> ids=toList(dataset);
		
		List<DatasetHead> l=datasetRepository.findByIds(ids);
		
    	PrefixTableBuilder ptb=new DatasetSourceImpl(dataset, toMap(l));
    	ptb.where(toWhere(dataset.getFilters()));
    	System.out.println(serviceQueryBuilder.getQuery((PrefixTable) ptb.build()));
		return new ArrayList<List<ColumnElement>>();
	}

	
	
	private Where toWhere(List<Filter> filters)
	{
		FilterBuilder fb=new FilterBuilder();
		for(Filter f:filters)
		{
			fb.add(f);
		}
		return fb.build();
	}
	
	class FilterBuilder
	{
		FilterWhere fw;
		FilterComparator fc;
		FilterConjunctor fcj;
		public FilterBuilder()
		{
			fw=new WhereBuilderImpl();
			
		}
		
		public FilterBuilder add(Filter f)
		{
			if(fc==null)
			{
				KeyValue kv1=f.getSelectedOptions().get(0);
				fc=fw.where("", kv1.getKey());
				fcj=fc.eq(kv1.getValue());
				f.getSelectedOptions().remove(kv1);
				for(KeyValue kv:f.getSelectedOptions())
				{
					fc=fcj.and("", kv.getKey());
					fcj=fc.eq(kv.getValue());
				}
			}else
				for(KeyValue kv:f.getSelectedOptions())
				{
					fc=fcj.and("", kv.getKey());
					fcj=fc.eq(kv.getValue());
				}
			
			return this;
		}
		
		public Where build()
		{
			return fcj.build();
		}
		
	}
	
	private ArrayList<Long> toList(Dataset dataset)
	{
		ArrayList<Long> al=new ArrayList<Long>();
		
		al.add(dataset.getId());
		
		
		for(Dataset subDataset:dataset.getSubDatasets())
			al.add(subDataset.getId());
		return al;
	}
	
	private HashMap<Long,DatasetHead> toMap(List<DatasetHead> l)
	{
		HashMap<Long,DatasetHead> hm=new HashMap<Long, DatasetHead>();
		for(DatasetHead dh:l)
			hm.put(dh.getId(), dh);
		return hm;
	}
	private void arrangeWithMandatories(LinkedList<ColumnElement> sortedColumns,long[] mandatoryIds)
	{
		List<ColumnElement> l= findMandatories(sortedColumns, mandatoryIds);
		sortedColumns.removeAll(l);
		sortedColumns.parallelStream().sorted(new Comparator<ColumnElement>() {

			@Override
			public int compare(ColumnElement o1, ColumnElement o2) {
				return new Long(o1.getElementId()).compareTo(o2.getElementId());
			}
		});
		if(l.size()!=0)
			for(ColumnElement ce:l)
				sortedColumns.push(ce);
		
	}
	
	private Map<DatasetHead,Set<DatasetElement>> selectedColumns(List<DatasetHead> children,List<Element> uiElements)
	{
		HashMap<DatasetHead,Set<DatasetElement>> hm=new HashMap<DatasetHead, Set<DatasetElement>>();
		for(DatasetHead dh:children)
		{
			for(DatasetElement de:dh.getDatasetElements())
				for(Element e:uiElements)
					if(e.getId()==de.getId())
					{
						if(hm.get(dh)==null)
						{
							HashSet<DatasetElement> hs=new HashSet<DatasetElement>();
							hs.add(de);
							hm.put(dh, hs);
						}
						else
						{
							hm.get(dh).add(de);
						}
						
					}
		}
		
		//TODO improve
		Optional<Element> countAllOption=uiElements.stream().filter(
				e->{
					if(e.getAggregate()==null)
						return false;
					else
						return e.getAggregate().equals(AggregateTypes.COUNT_ALL.getAggregate());
			}).findFirst();
		
		if(countAllOption.isPresent())
			hm.put(new DatasetHead(0L,COUNT_DATASET_HEAD_NAME,0), new HashSet<DatasetElement>(Arrays.asList(ConvertUtil.toDatasetElement(countAllOption.get()))));
		
		return hm;
	}
	
	private void collectColumns(LinkedList<ColumnElement> columns,PrefixTable head)
	{
		List<TableColumn> tempList=null;//head.getColumns().stream().sorted().collect(Collectors.toList());
		for(TableColumn tc:tempList)
			columns.add((ColumnElement) tc);
		
		for(PrefixTable pt:head.getJoinTables().keySet())
			collectColumns(columns,pt);
		
	}
	
	//TODO improve
	private List<ColumnElement> findMandatories(List<ColumnElement> sortedColumns,long[] mandatoryFieldIds)
	{
		ArrayList<ColumnElement> al=new ArrayList<ColumnElement>();
		
		long[] tempIds=new long[mandatoryFieldIds.length];
		
		for(int x=mandatoryFieldIds.length-1,y=0;x>=0;x--,y++)
			tempIds[y]=mandatoryFieldIds[x];
		
		
		for(long id:tempIds)
		{
			for(ColumnElement ce:sortedColumns)
			{
				if(ce.getElementId()==id)
					al.add(ce);
			}
		}
			
		
		return al;
	}
	
	private HashMap<Long,DatasetElement> collectColumns(List<DatasetHead> heads)
	{
		HashMap<Long,DatasetElement> hm=new HashMap<Long, DatasetElement>();
		for(DatasetHead dh:heads)
			for(DatasetElement de:dh.getDatasetElements())
				hm.put(de.getId(), de);
		
		return hm;
	}
	
	private void setAggregates(List<Element> elements,HashMap<Long,DatasetElement> elementMap)
	{

		for(Element e:elements)
		{
			DatasetElement de=elementMap.get(e.getId());
			
			//TODO improve
			if(e.getAggregate()!=null)
			if(e.getAggregate().equals(AggregateTypes.COUNT_ALL.getAggregate()))
				continue;
			
			if(de==null)
				throw new RuntimeException("No mapping provided while preparing aggregate");
			
			Aggregatable aggregatableDatasetElement=de;
			if(e.getAggregate()!=null)
				aggregatableDatasetElement.setAggregate(AggregateTypes.valueOf(e.getAggregate()));
			
		}
	}
	
	@Override
	public long getDataSize(String sql) {
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		Object o= template.query(sql, (rs, rowNum)->{return rs.getLong("COUNT(*)");}).get(0);
		return (long) o;
	}

	@Override
	public String getGeneratedSQL(Dataset dataset,LinkedList<PrefixTable> prefixTables) {
		
		ServiceQueryBuilder serviceQueryBuilder=new ServiceQueryBuilderImpl();
		
		PrefixTable finalTable=toParentPrefix(dataset);
    	
    	String sql=serviceQueryBuilder.getQuery(finalTable);
		
		return sql;
	}

	@Override
	public List<List<ColumnElement>> getData(String sql,
			LinkedList<PrefixTable> prefixTables,
			LinkedList<ColumnElement> sortedColumns) {
		
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		List<List<ColumnElement>> data = template.query(sql, (rs, rowNum) -> {
          List<ColumnElement> row = new LinkedList<>();
          
          sortedColumns.forEach(ce -> {
              try {
                  ColumnElement columnElementWithValue = ce.clone(); 
                  //TODO getColumnName has a problem if the field has alias..
                  Serializable value=null;
                  try{
                	value= JdbcTypes.getValue(rs, ce.getColumnName(), ce.getDataType());  
                  }catch(Exception ex){}
                   
                  if(value==null)
                	  value= JdbcTypes.getValue(rs, ce.getElementName(), ce.getDataType());
                  
                  columnElementWithValue.setValue(value);
                  
                  row.add(columnElementWithValue);
              }
              catch (SQLException ex) {
                  log.catching(ex);
                  throw log.throwing(new RuntimeException(format("SQL Error while getting value of element [%s].", ce.getElementName()), ex));
              }
          });
          return row;
      });
		
		 
		
		return data;
	}

	@Override
	public List<List<ColumnElement>> getData(String sql,
			LinkedList<PrefixTable> prefixTables,
			LinkedList<ColumnElement> sortedColumns,
			LinkedList<ColumnElement> headers) {
		
		List<List<ColumnElement>> data=getData(sql, prefixTables, sortedColumns);
		data.add(0, headers);
		return data;
	}

	@Override
	public LinkedList<PrefixTable> getPrefixTables(Dataset dataset) {
		
		
		PrefixTable finalTable=toParentPrefix(dataset);

    	
    	LinkedList<PrefixTable> ll=new LinkedList<PrefixTable>();
    	dig(ll,finalTable);
    	
        return ll;
	}

	private void dig(List<PrefixTable> list,PrefixTable pt)
	{
		list.add(pt);
		for(PrefixTable p:pt.getJoinTables().keySet())
			dig(list,p);
	}
	
	@Override
	public LinkedList<ColumnElement> getSortedColumns(LinkedList<PrefixTable> prefixTables) {
		LinkedList<ColumnElement> sortedColumns = new LinkedList<>();
		List<TableColumn> ces;
		ColumnElement columnElement;
		for (int i = 0; i < prefixTables.size(); i++) {
			PrefixTable pt = prefixTables.get(i);
            collectColumns(sortedColumns, pt);
        }
		arrangeWithMandatories(sortedColumns, MANDATORY_IDS); //by reference column which is bad
		return sortedColumns;
	}

	@Override
	public LinkedList<ColumnElement> getHeaders(
			LinkedList<ColumnElement> sortedColumns) {
		LinkedList<ColumnElement> headers = sortedColumns.stream()
                .map(ColumnElement::clone) // copy the original user selected column elements
                .map(ce -> {
                    ce.setValue(ce.getElementName()); // set the value as the element description
                    return ce;
                })
                .collect(toCollection(LinkedList::new));
		return headers;
	}
    
    private List<Long> getIds(List<Dataset> subDataset)
    {
    	
    	if(subDataset==null || subDataset.size()==0)
    		return new ArrayList<Long>();
    	else
    	{
    		ArrayList<Long> retList=new ArrayList<Long>();
    		subDataset.forEach(e->{retList.add(e.getId());});
    		return retList;
    	}
    	
    }
    
    private PrefixTable toParentPrefix(Dataset dataset)
    {
    	
		List<Long> ids=getIds(dataset.getSubDatasets());
		ArrayList<Element> orderList=new ArrayList<Element>();
		ids.remove(PARENT_ID);
		List<DatasetHead> children;
		if(!ids.isEmpty())
			children= datasetRepository.findByIds(ids);
		else
			children=new ArrayList<DatasetHead>();
		
    	DatasetHead parent=datasetRepository.findByIds(Arrays.asList(PARENT_ID)).get(0);
    	ArrayList<DatasetHead> forColumnList=new ArrayList<>();
    	forColumnList.add(parent);
    	forColumnList.addAll(children);
    	
    	
    	if(dataset.getAggregateBy()==null)
		{
			ArrayList<Element> tempList=new ArrayList<Element>(dataset.getElements());
    		for(DatasetElement de:parent.getDatasetElements())
    			for(long mandatoryId:MANDATORY_IDS)
    				{
    					if(de.getId()==mandatoryId)
    						tempList.add(ConvertUtil.toElement(de));
    				}
    		dataset.setElements(tempList);
    		
		}else
		{
			if(dataset.getAggregateBy().isCountIncluded())
			{
				orderList.addAll(dataset.getAggregateBy().getElements());
				ArrayList<Element> tempList=new ArrayList<Element>(dataset.getElements());
				tempList.add(ConvertUtil.countAll());
				dataset.setElements(tempList);
			}else
				orderList.addAll(dataset.getAggregateBy().getElements());
			
		}
    	
    	tableChainer=new StarSchemaChainImpl(selectedColumns(forColumnList, dataset.getElements()),JOINING_ELEMENTS,orderList);
    	
    	ArrayList<DatasetHead> datasetHeads=new ArrayList<DatasetHead>();
    	datasetHeads.add(parent);
    	datasetHeads.addAll(children);
    	HashMap<Long,DatasetElement> hm= collectColumns(datasetHeads);
    	
    	setAggregates(dataset.getElements(),hm);
    	
    	PrefixTable finalTable=tableChainer.chain(parent, children, dataset.getFilters());
    	return finalTable;
    }
	

}
