package ph.gov.deped.common.dw;

import java.io.Serializable;

/**
 * Created by ej on 8/13/14.
 */
public @interface HiveColumn {

    String name() default "";

    Class<? extends Serializable> dataType() default Serializable.class;

    boolean nullable() default false;

    int min() default Integer.MIN_VALUE;

    int max() default Integer.MAX_VALUE;
}
