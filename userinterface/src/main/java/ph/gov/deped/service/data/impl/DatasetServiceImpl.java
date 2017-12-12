package ph.gov.deped.service.data.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.gov.deped.service.data.api.DataService;

import com.generate.core.SqlToData;
import com.model.support.Dataset;
import com.util.builders.api.ServiceQueryBuilderImpl;
import com.util.builders.api.TableService;
import com.util.builders.impl.ColumnElement;
import com.util.builders.impl.ColumnExpression;
import com.util.builders.impl.PrefixTable;

@Service
public class DatasetServiceImpl implements DataService {

	@Autowired
	private SqlToData std;
	
	@Autowired
	private TableService ts;

	@Override
	public List<List<ColumnElement>> getPreviewData(Dataset ds) {
		
		PrefixTable pt= ts.generateTable(ds);
    	List<ColumnExpression> al=new ArrayList<ColumnExpression>();
    	al=collect(al,pt);
    	
    	String sql=new ServiceQueryBuilderImpl().getQuery(pt);
    	
		return std.get(new StringBuilder(sql).append(" LIMIT 20").toString(), al);
	}
	
	private List<ColumnExpression> collect(List<ColumnExpression> l,PrefixTable pt)
	{
		for(ColumnExpression ce:pt.getColumns())
			l.add(ce);
		
		for(PrefixTable subPT:pt.getJoinTables().keySet())
			collect(l,subPT);
		
		return l;
	}
	
}
