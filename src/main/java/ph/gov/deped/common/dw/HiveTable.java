package ph.gov.deped.common.dw;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by ej on 8/13/14.
 */
@Target(TYPE)
@Retention(RUNTIME)
@Documented
public @interface HiveTable {

    String name() default "";

    /**
     * @return The HDFS location path.
     */
    String location() default "/user/deped";

    /**
     * @see org.kitesdk.data.Formats
     * @return The format name of this table.
     */
    String format() default "csv";

    DbType type() default DbType.DWRHS;

    DbPurpose purpose() default DbPurpose.OPEN_REPORTS;

    String schema() default "";
}
