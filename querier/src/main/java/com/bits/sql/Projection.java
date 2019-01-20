package com.bits.sql;

import static com.bits.sql.Expressions.string;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static com.bits.sql.Keywords.AS;

/**
 * Created by ej on 9/2/14.
 */
public class Projection extends ColumnExpression {

    private final String alias;

    public Projection(String tablePrefix, String columnName, String alias) {
        super(tablePrefix, columnName);
        this.alias = alias;
    }

    public Projection(String tablePrefix, String columnName) {
        super(tablePrefix, columnName);
        this.alias = "";
    }
    
    public Projection(String columnName) {
        super(columnName);
        this.alias = "";
    }

    public String getAlias() {
        return alias;
    }

    public @Override String get() {
        return isBlank(getAlias()) ? super.get() : super.get() + AS.get() + string(getAlias()).get();
    }
}
