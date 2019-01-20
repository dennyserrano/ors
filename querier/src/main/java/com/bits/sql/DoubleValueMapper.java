package com.bits.sql;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.Serializable;

/**
 * Created by PSY on 2014/10/04.
 */
public class DoubleValueMapper implements NumericValueMapper<Double> {

    public Double apply(Serializable serializable) {
        if (Number.class.isAssignableFrom(serializable.getClass())) {
            return new Double(((Number) serializable).doubleValue());
        }
        else {
            String str = String.valueOf(serializable);
            return isBlank(str) ? 0.0 : new Double(str);
        }
    }
}
