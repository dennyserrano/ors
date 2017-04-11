package ph.gov.deped.common.util;

import java.util.List;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.PrefixTable;

import com.bits.sql.CriteriaChainBuilder;
import com.bits.sql.CriteriaFilterBuilder;
import com.bits.sql.FromClauseBuilder;
import com.bits.sql.JoinOrWhereClauseBuilder;
import com.bits.sql.Projection;
import com.bits.sql.ProjectionBuilder;

import static com.bits.sql.QueryBuilders.read;

public class ServiceQueryBuilder
{
	private ProjectionBuilder projectionBuilder;
	private FromClauseBuilder fromClauseBuilder;
	private JoinOrWhereClauseBuilder joinBuilder;
	private CriteriaFilterBuilder whereBuilder;
	
	public ServiceQueryBuilder() 
	{
		projectionBuilder=read();
	}
	
	public ServiceQueryBuilder select(List<ColumnElement> columnElements)
	{
		for(ColumnElement ce:columnElements)
			projectionBuilder.select(new Projection(ce.getTablePrefix(),ce.getColumnName(),ce.getElementName()));
		
		return this;
	};
	
	public ServiceQueryBuilder from (PrefixTable prefixTable)
	{
		joinBuilder=fromClauseBuilder.from(prefixTable.getTableName(), prefixTable.getTablePrefix());
		return this;
	};
	
	public ServiceQueryBuilder where(ServiceQueryFilter filters) 
	{

		ServiceQueryFilter leftFilter=filters;
		ServiceQueryFilter rightFilter=filters.getNextFilter();
		
		CriteriaFilterBuilder criteriaFilterBuilder=joinBuilder.where(leftFilter.getTablePrefix(), leftFilter.getColumnName());
		
		
		return this;
	};
	
	
	private CriteriaChainBuilder doExtendedWhere(ServiceQueryFilter rightFilter,CriteriaFilterBuilder criteriaFilterBuilder,CriteriaChainBuilder chainBuilder)
	{
		ServiceQueryFilter leftFilter=rightFilter;
		rightFilter=leftFilter.getNextFilter();
		
		if(rightFilter==null)
			return chainBuilder;
		
		if(leftFilter.getOperator().equals("EQ"))
		{
			chainBuilder=criteriaFilterBuilder.eq("");
			doExtendedWhere(rightFilter, criteriaFilterBuilder, chainBuilder);
		}else if(leftFilter.getOperator().equals("AND"))
		{
			criteriaFilterBuilder=chainBuilder.and(leftFilter.getTablePrefix(), leftFilter.getColumnName());
			doExtendedWhere(rightFilter, criteriaFilterBuilder, chainBuilder);
		}
		else
			return chainBuilder;
		
		return chainBuilder;
	}
	
	public ServiceQueryBuilder orderBy(){return this;};
	
	public String build()
	{
		return null;
	}
	
	
	
}
