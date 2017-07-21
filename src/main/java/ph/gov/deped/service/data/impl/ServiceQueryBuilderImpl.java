package ph.gov.deped.service.data.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.bits.sql.CriteriaChainBuilder;
import com.bits.sql.CriteriaFilterBuilder;
import com.bits.sql.FromClauseBuilder;
import com.bits.sql.GroupByBuilder;
import com.bits.sql.JdbcTypes;
import com.bits.sql.JoinOrWhereClauseBuilder;
import com.bits.sql.JoinType;
import com.bits.sql.OnClauseBuilder;
import com.bits.sql.OrderByClauseBuilder;
import com.bits.sql.Projection;
import com.bits.sql.ProjectionBuilder;
import com.bits.sql.Projections;
import com.bits.sql.SqlBuilder;
import com.bits.sql.SqlValueMapper;
import com.bits.sql.ValueExpression;
import com.jayway.jsonpath.Criteria;

import static com.bits.sql.Expressions.number;
import static com.bits.sql.Expressions.string;
import static com.bits.sql.JdbcTypes.getValueMapper;
import static com.bits.sql.JdbcTypes.isNumeric;
import static com.bits.sql.QueryBuilders.read;
import static java.util.stream.Collectors.toList;
import ph.gov.deped.common.util.builders.JoinInfo;
import ph.gov.deped.common.util.builders.JoinProperty;
import ph.gov.deped.common.util.builders.JoinPropertyBuilder;
import ph.gov.deped.data.Conjunctive;
import ph.gov.deped.data.Operational;
import ph.gov.deped.data.Where;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.ConditionalOperatorType;
import ph.gov.deped.data.dto.JoinOperator;
import ph.gov.deped.data.dto.KeyValue;
import ph.gov.deped.data.dto.Order;
import ph.gov.deped.data.dto.PrefixTable;
import ph.gov.deped.data.dto.interfaces.Aggregatable;
import ph.gov.deped.data.dto.interfaces.TableColumn;
import ph.gov.deped.data.ors.ds.DatasetCorrelation;
import ph.gov.deped.data.ors.ds.DatasetCorrelationDtl;
import ph.gov.deped.data.ors.ds.DatasetCorrelationGroupDtl;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.data.ors.meta.ColumnMetadata;
import ph.gov.deped.data.ors.meta.TableMetadata;
import ph.gov.deped.service.data.api.ServiceQueryBuilder;

public class ServiceQueryBuilderImpl implements ServiceQueryBuilder {

	
	private ProjectionBuilder projectionBuilder;
	
	public ServiceQueryBuilderImpl() {
		projectionBuilder=read();
	}
	
	@Override
	public String getQuery(PrefixTable pt) 
	{
		
		FromClauseBuilder fromClauseBuilder=constructSelect(pt);
		JoinOrWhereClauseBuilder joinOrWhereClauseBuilder=constructFrom(pt,fromClauseBuilder);
		joinOrWhereClauseBuilder=constructJoins(pt, joinOrWhereClauseBuilder);
		CriteriaChainBuilder chainBuilder=constructWhere(pt.getWhere(), joinOrWhereClauseBuilder);
		
		if(chainBuilder==null)
			return joinOrWhereClauseBuilder.build().toString();
			
		SqlBuilder sb= constructGroupBy(chainBuilder,pt.getGroupBy());
		
		if(sb!=null)
			return sb.build().toString();
		
		sb=constructOrderBy((CriteriaChainBuilder) sb, pt.getOrder());
		
		if(sb!=null)
			return sb.build().toString();
		
		
		if(chainBuilder!=null)
			return chainBuilder.build().toString();
		else
			return joinOrWhereClauseBuilder.build().toString();
	}

	private FromClauseBuilder constructSelect(PrefixTable pt)
	{
		FromClauseBuilder fromClauseBuilder = null;
		for(TableColumn tc:pt.getColumns())
		{
			ColumnElement ce=(ColumnElement)tc;
			
			if(ce.getAggregate()==null)
				fromClauseBuilder=projectionBuilder.select(new Projection(ce.getTablePrefix()!=null?ce.getTablePrefix():pt.getTablePrefix(), ce.getColumnName(), ce.getElementName()));
			else
				fromClauseBuilder=projectionBuilder.select(Projections.column(ce.getAggregate(), ce.getTablePrefix(), ce.getColumnName(),ce.getElementName()));
		}
		
		for(PrefixTable nextTable:pt.getJoinTables().keySet())
			constructSelect(nextTable);
		
		return fromClauseBuilder;
		
	}
	
	private JoinOrWhereClauseBuilder constructJoins(PrefixTable pt,JoinOrWhereClauseBuilder joinOrWhereClauseBuilder)
	{
		Map<PrefixTable,JoinProperty> joinMap= pt.getJoinTables();
		JoinOrWhereClauseBuilder joinWhere = null;
		
		for(Entry<PrefixTable, JoinProperty> joinInfo:joinMap.entrySet())
		{
			PrefixTable joinTable=joinInfo.getKey();
			JoinProperty joinProp=joinInfo.getValue();
			
			if(joinProp==null)
				throw new RuntimeException(String.format("Table %s has no join property",joinTable.getTableName()));
			OnClauseBuilder onClauseBuilder=getOnClause(pt, joinTable, joinProp.getJoinType(), joinOrWhereClauseBuilder);
			joinWhere=constructOn(joinProp.getJoinInfo(), onClauseBuilder);
			
			if(joinTable.getJoinTables().size()!=0)
				constructJoins(joinTable,joinOrWhereClauseBuilder);
		}
		
		if(joinWhere==null)
			joinWhere=joinOrWhereClauseBuilder;
		
		return joinWhere;
	}
	
	private OnClauseBuilder getOnClause(PrefixTable leftTable,PrefixTable rightTable,JoinType jt,JoinOrWhereClauseBuilder joinOrWhereClauseBuilder)
	{
		if(JoinType.INNER_JOIN.equals(jt))
			return joinOrWhereClauseBuilder.innerJoin(rightTable.getTableName(), rightTable.getTablePrefix());
		else if(JoinType.LEFT_JOIN.equals(jt))
			return joinOrWhereClauseBuilder.leftJoin(rightTable.getTableName(), rightTable.getTablePrefix());
	
		throw new RuntimeException("No corresponding clause for join type: "+ jt.name());
	}
	
	private JoinOrWhereClauseBuilder constructOn(JoinInfo<ColumnElement,ColumnElement> ji,OnClauseBuilder onClauseBuilder)
	{
		JoinOrWhereClauseBuilder jowc=onClauseBuilder
		.on(ji.getLeft().getTablePrefix(),ji.getLeft().getColumnName())
		.eq(ji.getRight().getTablePrefix(), ji.getRight().getColumnName());
		
		JoinOperator jo=ji.getNext();
		if(jo!=null)
			constructOn(jo.getJoinInfo(), onClauseBuilder);
		
		return jowc;
	}
	private JoinOrWhereClauseBuilder constructFrom(PrefixTable pt,FromClauseBuilder fromClauseBuilder)
	{
		return fromClauseBuilder.from(pt.getTableName(),pt.getTablePrefix());
	}
	
	private CriteriaChainBuilder constructWhere(Where where,JoinOrWhereClauseBuilder whereBuilder)
	{
		if(where.getOperational()!=null)
			return dig(where.getOperational(),whereBuilder.where(where.getTablePrefix(),where.getFieldName()));
		else
			return null;
	}
	
	private SqlBuilder constructGroupBy(CriteriaChainBuilder criteriaChain,Set<ColumnElement> groupByList)
	{
		OrderByClauseBuilder gbb = null;
		if(groupByList.size()==0)
			return criteriaChain;
		else
			for(ColumnElement ce:groupByList)
				gbb=criteriaChain.groupBy(ce.getTablePrefix(), ce.getColumnName());
		
		return gbb;
	}
	
	private SqlBuilder constructOrderBy(CriteriaChainBuilder criteriaChain,Order order)
	{
		SqlBuilder obc = null;
		if(order.getOrderBy().size()==0)
			return criteriaChain;
		else
			for(ColumnElement ce:order.getOrderBy())
				obc=criteriaChain.orderBy(ce.getTablePrefix(),ce.getColumnName(), true);
		
		return obc;
	}
	
	private CriteriaChainBuilder dig(Operational op,CriteriaFilterBuilder filterBuilder)
	{
		if(op.getConjunctive()!=null)
		{
			CriteriaChainBuilder chainBuilder = null;
			if(op.getOperator().equals(Operational.EQUALS))
			{
				
				chainBuilder=filterBuilder.eq(Long.parseLong(op.getValues().get(0).getKey().toString()));
				dig(op.getConjunctive(),chainBuilder);
			}else if(op.getOperator().equals(Operational.IN))
			{
				List<ValueExpression> values = op.getValues().stream()
		                .map(k->{
		                	String dataType=k.getValue();
		                	if (isNumeric(dataType)) {
		                        SqlValueMapper<Number> mapper = getValueMapper(dataType);
		                        return number(mapper.apply(k.getKey()));
		                    }
		                    else { // String based
		                        SqlValueMapper<String> mapper = getValueMapper(dataType);
		                        return string(mapper.apply(k.getKey()));
		                    }
		                })
		                .collect(toList());
				if(values.size()!=0)
					chainBuilder=filterBuilder.in(values.toArray(new ValueExpression[values.size()]));
				
				dig(op.getConjunctive(),chainBuilder);
			}
			return chainBuilder;
		}else
			return null;
	}
	
	private void dig(Conjunctive con,CriteriaChainBuilder chainBuilder)
	{
		if(con.getOperational()!=null)
			{
				CriteriaFilterBuilder filterBuilder=chainBuilder.and(con.getTablePrefix(),con.getFieldName());
				dig(con.getOperational(),filterBuilder);
			}
		
	}
	
}
