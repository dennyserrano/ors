package ph.gov.deped.common.query;

import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.meta.ColumnMetadata;
import ph.gov.deped.data.ors.meta.TableMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static ph.gov.deped.common.query.Expressions.bool;
import static ph.gov.deped.common.query.Expressions.character;
import static ph.gov.deped.common.query.Expressions.number;
import static ph.gov.deped.common.query.Expressions.string;
import static ph.gov.deped.common.query.Keywords.AS;
import static ph.gov.deped.common.query.Keywords.FROM;
import static ph.gov.deped.common.query.Keywords.NULL;
import static ph.gov.deped.common.query.Keywords.ORDER_BY;
import static ph.gov.deped.common.query.Keywords.SELECT;
import static ph.gov.deped.common.query.Keywords.WHERE;

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
public class SelectQueryBuilder implements ProjectionBuilder, FromClauseBuilder, JoinOrWhereClauseBuilder, JoinClauseBuilder, OnClauseBuilder,
        JoinCriteriaBuilder, JoinCriteriaChainBuilder, WhereClauseBuilder, CriteriaFilterBuilder, CriteriaChainBuilder, OrderByClauseBuilder {

    private final List<Projection> projections = new ArrayList<>();

    private final List<JoinTable> joinTables = new ArrayList<>();

    private final List<OrderByClause> orderByClauses = new ArrayList<>();

    private QueryTable fromTable;

    private QueryTable joinTable;

    private JoinType joinType;

    private int tableNo = 0;

    private Criterion criterion;

    private CriterionExpression criterionExpression;

    private Operator criterionOperator;

    private SqlExpression leftExp;

    private StringBuilder sql;

    public FromClauseBuilder selectAsterisk() {
        assert tableNo == 0;
        projections.add(new WildcardProjection());
        return this;
    }

    public FromClauseBuilder selectAsterisk(String tablePrefix) {
        assert tableNo == 0;
        projections.add(new WildcardProjection(tablePrefix));
        return this;
    }

    public FromClauseBuilder select(DatasetElement... elements) {
        assert tableNo == 0;
        if (elements != null && elements.length > 0) {
            asList(elements).stream()
                    .map(e -> new Projection(e, e.getAlias()))
                    .forEach(projections::add);
        }
        return this;
    }

    public FromClauseBuilder select(Projection... projections) {
        assert tableNo == 0;
        if (projections != null && projections.length > 0) {
            asList(projections).forEach(this::appendSelect);
        }
        return this;
    }

    @SuppressWarnings("unchecked")
    public FromClauseBuilder select(Supplier<? extends Projection>... projections) {
        assert tableNo == 0;
        if (projections != null && projections.length > 0) {
            asList(projections).forEach(s -> appendSelect(s.get()));
        }
        return this;
    }

    private void appendSelect(Projection projection) {
        projections.add(tableNo, projection);
    }

    public JoinOrWhereClauseBuilder from(String tableName) {
        return from(tableName, "");
    }

    public JoinOrWhereClauseBuilder from(String tableName, String tablePrefix) {
        fromTable = new QueryTable(tablePrefix, tableName);
        return this;
    }

    public JoinOrWhereClauseBuilder from(TableMetadata tableMetadata, String tablePrefix) {
        return from(tableMetadata.getTableName(), tablePrefix);
    }

    public OnClauseBuilder leftJoin(TableMetadata tableMetadata, String tablePrefix) {
        return leftJoin(tableMetadata.getTableName(), tablePrefix);
    }

    public OnClauseBuilder leftJoin(String tableName, String tablePrefix) {
        this.joinTable = new QueryTable(tablePrefix, tableName);
        this.joinType = JoinType.LEFT_JOIN;
        return this;
    }

    public OnClauseBuilder innerJoin(TableMetadata tableMetadata, String tablePrefix) {
        return innerJoin(tableMetadata.getTableName(), tablePrefix);
    }

    public OnClauseBuilder innerJoin(String tableName, String tablePrefix) {
        this.joinTable = new QueryTable(tablePrefix, tableName);
        this.joinType = JoinType.INNER_JOIN;
        return this;
    }

    public OnClauseBuilder crossJoin(TableMetadata tableMetadata, String tablePrefix) {
        return crossJoin(tableMetadata.getTableName(), tablePrefix);
    }

    public OnClauseBuilder crossJoin(String tableName, String tablePrefix) {
        this.joinTable = new QueryTable(tableName, tablePrefix);
        this.joinType = JoinType.CROSS_JOIN;
        return this;
    }

    public JoinCriteriaBuilder on(String tablePrefix, ColumnMetadata col) {
        return on(tablePrefix, col.getColumnName());
    }

    public JoinCriteriaBuilder on(String tablePrefix, String columnName) {
        return on(new ColumnExpression(tablePrefix, columnName));
    }

    public JoinCriteriaBuilder on(ColumnExpression columnExpression) {
        this.leftExp = columnExpression;
        return this;
    }

    public JoinOrWhereClauseBuilder eq(String tablePrefix, String columnName) {
        return eq(new ColumnExpression(tablePrefix, columnName));
    }

    public JoinOrWhereClauseBuilder eq(SqlExpression expression) {
        joinTables.add(new JoinTable(this.joinType, this.joinTable, new Criterion(this.leftExp, Operators.Logical.EQ, expression)));
        this.leftExp = null;
        return this;
    }

    public JoinOrWhereClauseBuilder and(String tablePrefix, ColumnMetadata columnMetadata) {
        return null;
    }

    public CriteriaFilterBuilder where(ColumnMetadata columnMetadata) {
        this.leftExp = new ColumnExpression(columnMetadata);
        return this;
    }

    public CriteriaFilterBuilder where(String columnName) {
        this.leftExp = new ColumnExpression("", columnName);
        return this;
    }

    public CriteriaFilterBuilder where(String tablePrefix, String columnName) {
        return where(new ColumnExpression(tablePrefix, columnName));
    }

    public CriteriaFilterBuilder where(ColumnExpression columnExpression) {
        this.leftExp = columnExpression;
        return this;
    }

    public CriteriaChainBuilder eq(String value) {
        criterion(Operators.Logical.EQ, string(value));
        return this;
    }

    public CriteriaChainBuilder eq(Number value) {
        criterion(Operators.Logical.EQ, number(value));
        return this;
    }

    public CriteriaChainBuilder eq(Character value) {
        criterion(Operators.Logical.EQ, character(value));
        return this;
    }

    public CriteriaChainBuilder is(Boolean value) {
        criterion(Operators.Special.IS, bool(value));
        return this;
    }

    public CriteriaChainBuilder isNotNull() {
        criterion(Operators.Special.IS_NOT, NULL);
        return this;
    }

    public CriteriaChainBuilder isNull() {
        criterion(Operators.Special.IS, NULL);
        return this;
    }

    private void criterion(Operator expressionOperator, SqlExpression rightExp) {
        this.criterion = new Criterion(this.leftExp, expressionOperator, rightExp);
        if (this.criterionExpression != null) {
            this.criterion = new Criterion(
                    this.criterionExpression,
                    this.criterionOperator,
                    new CriterionExpression(this.criterion)
            );
            this.criterionExpression = null;
            this.criterionOperator = null;
        }
        this.leftExp = null;
    }

    public CriteriaFilterBuilder and(ColumnMetadata columnMetadata) {
        return and(columnMetadata.getColumnName());
    }

    public CriteriaFilterBuilder and(String column) {
        return and("", column);
    }

    public CriteriaFilterBuilder and(String tablePrefix, String columnName) {
        return and(new ColumnExpression(tablePrefix, columnName));
    }

    public CriteriaFilterBuilder and(ColumnExpression columnExpression) {
        this.criterionExpression = new CriterionExpression(this.criterion);
        this.criterionOperator = Operators.Logical.AND;
        this.leftExp = columnExpression;
        return this;
    }

    public CriteriaFilterBuilder or(ColumnMetadata columnMetadata) {
        // TODO Implement this builder
        return this;
    }

    public CriteriaFilterBuilder or(String column) {
        // TODO Implement this builder
        return this;
    }

    public SqlBuilder orderBy(ColumnMetadata columnMetadata, boolean asc) {
        return orderBy(columnMetadata.getColumnName(), asc);
    }

    public SqlBuilder orderBy(String columnName, boolean asc) {
        return orderBy("", columnName, asc);
    }
    
    public SqlBuilder orderBy(String... columnNames) {
        if (columnNames != null && columnNames.length > 0) {
            for (String columnName : columnNames) {
                orderBy(columnName, true);
            }
        }
        return this;
    }

    public SqlBuilder orderBy(String tablePrefix, String columnName, boolean asc) {
        orderByClauses.add(new OrderByClause(new ColumnExpression(tablePrefix, columnName), asc));
        return this;
    }

    public StringBuilder build() {
        sql = new StringBuilder();

        // SELECT Clause
        append(SELECT);
        append(projections.stream().map(Projection::get).collect(Collectors.joining(", ")));

        // FROM Clause
        append(FROM);
        append(fromTable.getTableName());
        if (!isBlank(fromTable.getPrefix())) {
            append(AS);
            append(fromTable.getPrefix());
        }

        // JOINS Clause [optional]
        int tableCount = joinTables.size();
        if (tableCount > 0) {
            JoinTable joinTable;
            for (int i = 0; i < tableCount; i++) {
                joinTable = joinTables.get(i);
                append(joinTable.get());
            }
        }

        // WHERE Clause [optional]
        if (this.criterion != null) {
            append(WHERE);
            append(new CriterionExpression(this.criterion).get());
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

    SelectQueryBuilder() {}
}
