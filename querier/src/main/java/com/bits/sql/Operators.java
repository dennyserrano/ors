package com.bits.sql;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by ej on 8/19/14.
 */
public abstract class Operators {
    
    public static List<Enum<? extends Operator>> getOperators() {
        List<Enum<? extends Operator>> operators = new ArrayList<>();
        operators.addAll(asList(Logical.values()));
        operators.addAll(asList(Special.values()));
        operators.addAll(asList(Math.values()));
        operators.addAll(asList(Multiple.values()));
        operators.addAll(asList(Like.values()));
        return operators;
    }

    public static enum Logical implements Operator {
        AND(() -> " AND "),
        OR(() -> " OR "),
        EQ(() -> " = "),
        GT(() -> " > "),
        LT(() -> " < "),
        GE(() -> " >= "),
        LE(() -> " <= "),
        NE(() -> " <> ")

        ;

        final Supplier<String> operator;

        Logical(Supplier<String> operator) {
            this.operator = operator;
        }

        public String get() {
            return operator.get();
        }

        public String getName() {
            return name();
        }
    }

    public static enum Special implements Operator {
        IS(() -> " IS "),
        IS_NOT(() -> " IS NOT ")

        ;

        final Supplier<String> sql;

        Special(Supplier<String> _sql) {
            this.sql = _sql;
        }

        public String get() {
            return sql.get();
        }

        public String getName() {
            return name();
        }
    }

    public static enum Math implements Operator {
        PLUS(" + "),
        MINUs(" - "),
        TIMES(" * "),
        DIVIDE(" / "),
        MODULO(" % ")

        ;

        String sql;

        Math(String _sql) {
            sql = _sql;
        }

        public String get() {
            return sql;
        }

        public String getName() {
            return name();
        }

        public @Override String toString() {
            return toSql();
        }
    }

    public static enum Multiple implements Operator {
        RANGE(" BETWEEN "),
        IN(" IN ")

        ;

        String sql;

        Multiple(String _sql) {
            sql = _sql;
        }

        public String get() {
            return sql;
        }

        public String getName() {
            return name();
        }

        public @Override String toString() {
            return toSql();
        }
    }
    
    public static enum Like implements Operator {
        PRE(" %s% "),
        POST(" %%s"),
        MID(" %%s% ")
        
        ;
        
        String format;
        String value;
        
        Like(String _format) {
            this.format = _format;
        }
        
        public Like arg(String value) {
            this.value = value;
            return this;
        }
        
        public String get() {
            if (isBlank(value)) {
                throw new RuntimeException("SQL Like - argument is blank.");
            }
            return String.format(format, value);
        }
        
        public String getName() {
            return "LIKE_" + name();
        }
        
        public @Override String toString() {
            return toSql();
        }
    }
}
