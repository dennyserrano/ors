package com.bits.sql;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.bits.sql.Expressions.bool;
import static com.bits.sql.Expressions.character;
import static com.bits.sql.Expressions.number;
import static com.bits.sql.Expressions.string;
import static com.bits.sql.Keywords.AS;
import static com.bits.sql.Keywords.FROM;
import static com.bits.sql.Keywords.NULL;
import static com.bits.sql.Keywords.ON;
import static com.bits.sql.Keywords.ORDER_BY;
import static com.bits.sql.Keywords.SELECT;
import static com.bits.sql.Keywords.WHERE;
import static com.bits.sql.Keywords.GROUP_BY;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * The expected API usage should be something like this:
 * <br/><br/>
 * <code><br/>
 *     query(ds)<br/>
 *       .select(cm1, cm2, cm3)<br/>
 *       .from(tm1)<br/>
 *       .where(cm4).eq("abc")<br/>
 *         .and(cm5).eq(123)<br/>
 *       .orderBy(cm1).asc()<br/>
 *       .build();<br/>
 * </code>
 *
 * Created by ej on 8/29/14.
 */
public class SelectQueryBuilder implements ProjectionBuilder {

    private final LinkedList<Projection> projections = new LinkedList<>();

    private final Map<JoinTable, List<JoinColumn>> joinMap = new LinkedHashMap<>();

    private final List<OrderByClause> orderByClauses = new ArrayList<>();

    private final List<GroupByClause> groupByClauses=new ArrayList<GroupByClause>();
    
    private QueryTable fromTable;

    private JoinTable currentJoinTable;

    private Criterion criterion;

    private CriterionExpression criterionExpression;

    private Operator criterionOperator;

    private SqlExpression leftExp;

    private FromClauseBuilderImpl fromClauseBuilder = new FromClauseBuilderImpl();

    private JoinOrWhereClauseBuilderImpl joinOrWhereClauseBuilder = new JoinOrWhereClauseBuilderImpl();

    private OnClauseBuilderImpl onClauseBuilder = new OnClauseBuilderImpl();

    private JoinCriteriaBuilderImpl joinCriteriaBuilder = new JoinCriteriaBuilderImpl();

    private CriteriaFilterBuilderImpl criteriaFilterBuilder = new CriteriaFilterBuilderImpl();

    private CriteriaChainBuilderImpl criteriaChainBuilder = new CriteriaChainBuilderImpl();
    
    private OrderByClauseBuilderImpl orderByBuilder=new OrderByClauseBuilderImpl();
    
    private GroupByClauseBuilderImpl groupByBuilder=new GroupByClauseBuilderImpl();
    
    private SqlBuilderImpl sqlBuilder = new SqlBuilderImpl();

    public FromClauseBuilder selectAsterisk() {
        projections.add(new WildcardProjection());
        return fromClauseBuilder;
    }

    public FromClauseBuilder selectAsterisk(String tablePrefix) {
        projections.add(new WildcardProjection(tablePrefix));
        return fromClauseBuilder;
    }

    public FromClauseBuilder select(Projection... projections) {
        if (projections != null && projections.length > 0) {
            asList(projections).forEach(this::appendSelect);
        }
        return fromClauseBuilder;
    }

    @SuppressWarnings("unchecked")
    public FromClauseBuilder select(Supplier<? extends Projection>... projections) {
        if (projections != null && projections.length > 0) {
            asList(projections).forEach(s -> appendSelect(s.get()));
        }
        return fromClauseBuilder;
    }

    private void appendSelect(Projection projection) {
        projections.add(projection);
    }

    SelectQueryBuilder() {}

    public class FromClauseBuilderImpl implements FromClauseBuilder {

        public JoinOrWhereClauseBuilder from(String tableName) {
            return from(tableName, "");
        }

        public JoinOrWhereClauseBuilder from(String tableName, String tablePrefix) {
            
        	fromTable = new QueryTable(tablePrefix, tableName);
            return joinOrWhereClauseBuilder;
        }
    }

    public class JoinOrWhereClauseBuilderImpl implements JoinOrWhereClauseBuilder {

        public OnClauseBuilder leftJoin(String tableName, String tablePrefix) {
            joinMap.put(currentJoinTable = new JoinTable(JoinType.LEFT_JOIN, new QueryTable(tablePrefix, tableName)), new ArrayList<>());
            return onClauseBuilder;
        }

        public OnClauseBuilder innerJoin(String tableName, String tablePrefix) {
            joinMap.put(currentJoinTable = new JoinTable(JoinType.INNER_JOIN, new QueryTable(tablePrefix, tableName)), new ArrayList<>());
            return onClauseBuilder;
        }

        public OnClauseBuilder crossJoin(String tableName, String tablePrefix) {
            joinMap.put(currentJoinTable = new JoinTable(JoinType.CROSS_JOIN, new QueryTable(tablePrefix, tableName)), new ArrayList<>());
            return onClauseBuilder;
        }

        public JoinCriteriaBuilder and(String tablePrefix, String columnName) {
            return and(new ColumnExpression(tablePrefix, columnName));
        }

        public JoinCriteriaBuilder and(ColumnExpression columnExpression) {
            leftExp = columnExpression;
            return joinCriteriaBuilder;
        }

        public CriteriaFilterBuilder where(String columnName) {
            leftExp = new ColumnExpression("", columnName);
            return criteriaFilterBuilder;
        }

        public CriteriaFilterBuilder where(String tablePrefix, String columnName) {
            return where(new ColumnExpression(tablePrefix, columnName));
        }

        public CriteriaFilterBuilder where(ColumnExpression columnExpression) {
            leftExp = columnExpression;
            return criteriaFilterBuilder;
        }

        public StringBuilder build() {
            return sqlBuilder.build();
        }


		@Override
		public SqlBuilder orderBy(String tablePrefix, String columnName,
				boolean asc) {
			// TODO Auto-generated method stub
			return orderByBuilder.orderBy(tablePrefix, columnName, asc);
		}

		@Override
		public SqlBuilder orderBy(String columnName, boolean asc) {
			// TODO Auto-generated method stub
			return orderByBuilder.orderBy(columnName, asc);
		}

		@Override
		public SqlBuilder orderBy(String... columnNames) {
			// TODO Auto-generated method stub
			return orderByBuilder.orderBy(columnNames);
		}

		@Override
		public OrderByClauseBuilder groupBy(String tablePrefix,
				String columnName) {
			// TODO Auto-generated method stub
			return groupByBuilder.groupBy(tablePrefix,columnName);
		}

		@Override
		public OrderByClauseBuilder groupBy(String columnName) {
			// TODO Auto-generated method stub
			return groupByBuilder.groupBy(columnName);
		}

		@Override
		public OrderByClauseBuilder groupBy(String... columnNames) {
			// TODO Auto-generated method stub
			return groupByBuilder.groupBy(columnNames);
		}

		

    }
    
    public class OnClauseBuilderImpl implements OnClauseBuilder {

        public JoinCriteriaBuilder on(String tablePrefix, String columnName) {
            return on(new ColumnExpression(tablePrefix, columnName));
        }

        public JoinCriteriaBuilder on(ColumnExpression columnExpression) {
            leftExp = columnExpression;
            return joinCriteriaBuilder;
        }
    }

    public class JoinCriteriaBuilderImpl implements JoinCriteriaBuilder {

        public JoinOrWhereClauseBuilder eq(String tablePrefix, String columnName) {
            return eq(new ColumnExpression(tablePrefix, columnName));
        }

        public JoinOrWhereClauseBuilder eq(SqlExpression rightExpression) {
            List<JoinColumn> joinColumns = joinMap.get(currentJoinTable);
            joinColumns.add(new JoinColumn(new Criterion(leftExp, Operators.Logical.EQ, rightExpression)));
            leftExp = null;
            return joinOrWhereClauseBuilder;
        }
    }

    public class CriteriaFilterBuilderImpl implements CriteriaFilterBuilder {

        public CriteriaChainBuilder eq(String value) {
            criterion(Operators.Logical.EQ, string(value));
            return criteriaChainBuilder;
        }

        public CriteriaChainBuilder eq(Number value) {
            criterion(Operators.Logical.EQ, number(value));
            return criteriaChainBuilder;
        }

        public CriteriaChainBuilder eq(Character value) {
            criterion(Operators.Logical.EQ, character(value));
            return criteriaChainBuilder;
        }

        public CriteriaChainBuilder is(Boolean value) {
            criterion(Operators.Special.IS, bool(value));
            return criteriaChainBuilder;
        }

        public CriteriaChainBuilder isNotNull() {
            criterion(Operators.Special.IS_NOT, NULL);
            return criteriaChainBuilder;
        }

        public CriteriaChainBuilder isNull() {
            criterion(Operators.Special.IS, NULL);
            return criteriaChainBuilder;
        }
        
        public CriteriaBetweenChainBuilder between(Number min) {
            BetweenBuilder b = new BetweenBuilder(criteriaChainBuilder, leftExp);
            b.between(min);
            return b;
        }
        
        public CriteriaChainBuilder in(ValueExpression... values) {
            String csv = asList(values).stream().map(v -> v.toSql()).collect(joining(","));
            criterion(Operators.Multiple.IN, () -> String.format("(%s)", csv));
            return criteriaChainBuilder;
        }

        private void criterion(Operator expressionOperator, SqlExpression rightExp) {
            criterion = new Criterion(leftExp, expressionOperator, rightExp);
            if (criterionExpression != null) {
                criterion = new Criterion(
                        criterionExpression,
                        criterionOperator,
                        new CriterionExpression(criterion)
                );
                criterionExpression = null;
                criterionOperator = null;
            }
            leftExp = null;
        }
        
    public class BetweenBuilder implements CriteriaBetweenBuilder, CriteriaBetweenChainBuilder {
            
            private CriteriaChainBuilder criteriaChainBuilder;
            
            private SqlExpression leftExp;
            
            private String fromValue;
            
            private String toValue;
            
            private SqlExpression rightExp;

            public BetweenBuilder(CriteriaChainBuilder criteriaChainBuilder, SqlExpression leftExp) {
                this.criteriaChainBuilder = criteriaChainBuilder;
                this.leftExp = () -> "(" + leftExp.toSql();
            }

            public CriteriaBetweenChainBuilder between(Number min) {
                fromValue = String.valueOf(min);
                return this;
            }

            public CriteriaChainBuilder and(Number max) {
                toValue = String.valueOf(max);
                this.rightExp = () -> String.format("%s AND %s)", fromValue, toValue);
                criterion = new Criterion(leftExp, Operators.Multiple.RANGE, rightExp);
                if (criterionExpression != null) {
                    criterion = new Criterion(
                            criterionExpression,
                            criterionOperator,
                            new CriterionExpression(criterion)
                    );
                    criterionExpression = null;
                    criterionOperator = null;
                }
                leftExp = null;
                return criteriaChainBuilder;
            }
        }
    }

    public class CriteriaChainBuilderImpl implements CriteriaChainBuilder {

        public CriteriaFilterBuilder and(String column) {
            return and("", column);
        }

        public CriteriaFilterBuilder and(String tablePrefix, String columnName) {
            return and(new ColumnExpression(tablePrefix, columnName));
        }

        public CriteriaFilterBuilder and(ColumnExpression columnExpression) {
            criterionExpression = new CriterionExpression(criterion);
            criterionOperator = Operators.Logical.AND;
            leftExp = columnExpression;
            return criteriaFilterBuilder;
        }

        public CriteriaFilterBuilder or(String column) {
            // TODO Implement this builder
            return criteriaFilterBuilder;
        }

        public SqlBuilder orderBy(String columnName, boolean asc) {
        	orderByBuilder.orderBy(columnName, asc);
        	return sqlBuilder;
        }

        public SqlBuilder orderBy(String... columnNames) {
        	orderByBuilder.orderBy(columnNames);
            return sqlBuilder;
        }

        public SqlBuilder orderBy(String tablePrefix, String columnName, boolean asc) {
        	orderByBuilder.orderBy(tablePrefix, columnName, asc);
            return sqlBuilder;
        }

        @Override
		public OrderByClauseBuilder groupBy(String tablePrefix,
				String columnName) {
			// TODO Auto-generated method stub
			return groupByBuilder.groupBy(tablePrefix, columnName);
		}

		@Override
		public OrderByClauseBuilder groupBy(String columnName) {
			// TODO Auto-generated method stub
			return groupByBuilder.groupBy(columnName);
		}

		@Override
		public OrderByClauseBuilder groupBy(String... columnNames) {
			return groupByBuilder.groupBy(columnNames);
		}
        
        public StringBuilder build() {
            return sqlBuilder.build();
        }

		
    }

    
    public class OrderByClauseBuilderImpl implements OrderByClauseBuilder,SqlBuilder
    {

		@Override
		public StringBuilder build() {
			// TODO Auto-generated method stub
			return sqlBuilder.build();
		}

		@Override
		public SqlBuilder orderBy(String tablePrefix, String columnName,boolean asc) {
			orderByClauses.add(new OrderByClause(new ColumnExpression(tablePrefix, columnName), asc));
			return groupByBuilder;
		}

		@Override
		public SqlBuilder orderBy(String columnName, boolean asc) {
			
			return orderBy("",columnName,asc);
		}

		@Override
		public SqlBuilder orderBy(String... columnNames) {
			 if (columnNames != null && columnNames.length > 0) {
	                for (String columnName : columnNames) {
	                    orderBy(columnName, true);
	                }
	            }
	            return groupByBuilder;
		}
    	
    }
    
    public class GroupByClauseBuilderImpl implements GroupByBuilder, SqlBuilder
    {
    	

    	@Override
    	public OrderByClauseBuilder groupBy(String tablePrefix, String columnName) {
    		groupByClauses.add(new GroupByClause(new ColumnExpression(tablePrefix, columnName)));
    		return orderByBuilder;
    	}

    	@Override
    	public OrderByClauseBuilder groupBy(String columnName) {
    		groupByClauses.add(new GroupByClause(new ColumnExpression("", columnName)));
    		return orderByBuilder;
    	}

    	@Override
    	public OrderByClauseBuilder groupBy(String... columnNames) {
    		if (columnNames != null && columnNames.length > 0) {
                for (String columnName : columnNames) {
                    groupBy(columnName);
                }
            }
    		return orderByBuilder;
    	}
    	
    	@Override
    	public StringBuilder build() {
    		// TODO Auto-generated method stub
    		return sqlBuilder.build();
    	}

    }
    
    public class SqlBuilderImpl implements SqlBuilder {

        private StringBuilder sql;

        public StringBuilder build() {
            sql = new StringBuilder();

            // SELECT Clause
            append(SELECT);
            append(projections.stream().map(Projection::get).collect(joining(", ")));

            // FROM Clause
            append(FROM);
            append(fromTable.getTableName());
            if (!isBlank(fromTable.getPrefix())) {
                append(AS);
                append(fromTable.getPrefix());
            }

            // JOIN Clauses [optional]
            joinMap.entrySet().stream()
                    .forEach(join -> {
                        append(join.getKey());
                        if (!join.getValue().isEmpty()) {
                            append(ON);
                            List<JoinColumn> joinColums = join.getValue();
                            Iterator<JoinColumn> iterator = joinColums.iterator();
                            JoinColumn jc = iterator.next();
                            append(jc);
                            while (iterator.hasNext()) {
                                jc = iterator.next();
                                append(Operators.Logical.AND);
                                append(jc);
                            }
                        }
                    });

            // WHERE Clause [optional]
            if (criterion != null) {
                append(WHERE);
                append(new CriterionExpression(criterion).get());
            }

            
            // GROUP BY Clause [Optional]
            int groupByCount=groupByClauses.size();
            if(groupByCount>0)
            {
            	append(GROUP_BY);
            	GroupByClause clause;
            	for(int y=0;y<groupByCount;y++)
            	{
            		clause = groupByClauses.get(y);
                    append(clause);
                    if (y < groupByCount - 1) 
                        append(", ");
                    
            	}
            }
            
            // ORDER BY Clause [optional]
            int orderByCount = orderByClauses.size();
            if (orderByCount > 0) {
                append(ORDER_BY);
                OrderByClause clause;
                for (int i = 0; i < orderByCount; i++) {
                    clause = orderByClauses.get(i);
                    append(clause);
                    if (i < orderByCount - 1) {
                        append(", ");
                    }
                }
            }

           
            
            return sql;
        }

        private void append(SqlExpression sqlExpression) {
            append(sqlExpression.get());
        }

        private void append(String str) {
            sql.append(str);
        }
    }
}
