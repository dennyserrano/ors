package ph.gov.deped.common.query;

import java.util.function.Supplier;

/**
 * Created by ej on 8/19/14.
 */
public abstract class Operators {

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
}
