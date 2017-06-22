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
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
//import ph.gov.deped.common.util.builders.StarSchemaChainImpl;
//import ph.gov.deped.common.util.builders.TableChainer;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
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
	
	private TableChainer tableChainer=new StarSchemaChainImpl();
	
	private ServiceQueryBuilder serviceQueryBuilder=new ServiceQueryBuilderImpl();
	
	@Autowired @Qualifier(AppMetadata.DS)
	private DataSource dataSource;
	
	@Override
	public List<List<ColumnElement>> getData(Dataset dataset,boolean previewOnly) {
		
		
		List<Long> ids=getIds(dataset.getSubDatasets());
		ids.add(PARENT_ID);
    	
    	List<DatasetHead> children= datasetRepository.findByIds(ids);

    	DatasetHead parent=children.stream().filter(e->e.getId().intValue()==PARENT_ID).findFirst().get();
    	
    	children.remove(parent);
    	if(ids.size()==0)
    		throw new RuntimeException("No datasets retrieved out of the given ids");
    	
    	ArrayList<DatasetHead> datasetHeads=new ArrayList<DatasetHead>();
    	datasetHeads.add(parent);
    	datasetHeads.addAll(children);
    	HashMap<Long,DatasetElement> hm= collectColumns(datasetHeads);
    	
    	setAggregates(dataset.getElements(),hm);
    	
    	PrefixTable finalTable=tableChainer.chain(parent, children, dataset.getFilters());
    	
    	
    	LinkedList<ColumnElement> sortedColumns=new LinkedList<>();
    	
    	collectColumns(sortedColumns, finalTable);
    	
    	String sql=serviceQueryBuilder.getQuery(finalTable);
    	sql=new StringBuilder(sql).append(" LIMIT 20").toString();
    	log.debug("Generated SQL [{}]", sql);
    	
    	
    	JdbcTemplate template = new JdbcTemplate(dataSource);
    	List<List<ColumnElement>> data = template.query(sql.toString(), (rs, rowNum) -> {
            List<ColumnElement> row = new LinkedList<>();
            sortedColumns.forEach(ce -> {
                try {
                    ColumnElement columnElementWithValue = ce.clone(); 
                    Serializable value = JdbcTypes.getValue(rs, ce.getElementName(), ce.getDataType());
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
        
        LinkedList<ColumnElement> headers = sortedColumns.stream()
                .map(ColumnElement::clone) // copy the original user selected column elements
                .map(ce -> {
                    ce.setValue(ce.getElementName()); // set the value as the element description
                    return ce;
                })
                .collect(toCollection(LinkedList::new));
        data.add(0, headers);
    	
		return data;
	}

	private void collectColumns(LinkedList<ColumnElement> columns,PrefixTable head)
	{
		for(PrefixTable pt:head.getJoinTables().keySet())
		{
			for(TableColumn tc:pt.getColumns())
				columns.add((ColumnElement) tc);
			collectColumns(columns,pt);
		}
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
		return template.query(sql, (rs, rowNum)->{return null;}).size();
	}

	@Override
	public String getGeneratedSQL(Dataset dataset,LinkedList<PrefixTable> prefixTables) {
		
		
		List<Long> ids=getIds(dataset.getSubDatasets());
		ids.add(PARENT_ID);
    	
    	List<DatasetHead> children= datasetRepository.findByIds(ids);

    	DatasetHead parent=children.stream().filter(e->e.getId().intValue()==PARENT_ID).findFirst().get();
    	
    	children.remove(parent);
    	if(ids.size()==0)
    		throw new RuntimeException("No datasets retrieved out of the given ids");
    	
    	ArrayList<DatasetHead> datasetHeads=new ArrayList<DatasetHead>();
    	datasetHeads.add(parent);
    	datasetHeads.addAll(children);
    	HashMap<Long,DatasetElement> hm= collectColumns(datasetHeads);
    	
    	setAggregates(dataset.getElements(),hm);
    	
    	PrefixTable finalTable=tableChainer.chain(parent, children, dataset.getFilters());
    	
    	
    	LinkedList<ColumnElement> sortedColumns=new LinkedList<>();
    	
    	collectColumns(sortedColumns, finalTable);
    	
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
                  Serializable value = JdbcTypes.getValue(rs, ce.getElementName(), ce.getDataType());
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
		
		LinkedList<PrefixTable> ll=new LinkedList<PrefixTable>();
		List<Long> ids=getIds(dataset.getSubDatasets());
		ids.add(PARENT_ID);
    	
    	List<DatasetHead> children= datasetRepository.findByIds(ids);

    	DatasetHead parent=children.stream().filter(e->e.getId().intValue()==PARENT_ID).findFirst().get();
    	
    	children.remove(parent);
    	if(ids.size()==0)
    		throw new RuntimeException("No datasets retrieved out of the given ids");
    	
    	ArrayList<DatasetHead> datasetHeads=new ArrayList<DatasetHead>();
    	datasetHeads.add(parent);
    	datasetHeads.addAll(children);
    	HashMap<Long,DatasetElement> hm= collectColumns(datasetHeads);
    	
    	setAggregates(dataset.getElements(),hm);
    	
    	PrefixTable finalTable=tableChainer.chain(parent, children, dataset.getFilters());
    	
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
            ces = new ArrayList<>(pt.getColumns());
            for (int j = 0; j < pt.getColumns().size(); j++) {
                columnElement = (ColumnElement) ces.get(j);
                sortedColumns.add(columnElement);
            }
        }
		
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
	

}
