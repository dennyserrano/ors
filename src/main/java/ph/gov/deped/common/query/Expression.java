package ph.gov.deped.common.query;

import java.util.function.Supplier;

/**
 * Created by ej on 9/2/14.
 */
public interface Expression<T> extends Supplier<T> {

    default String toSql() {
        return String.valueOf(get() == null ? "NULL" : get());
    }
}