package com.bits.sql;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.Serializable;

/**
 * Created by PSY on 2014/10/04.
 */
public class FloatValueMapper implements NumericValueMapper<Float> {

    public Float apply(Serializable serializable) {
        String str = String.valueOf(serializable);
        return isBlank(str) ? null : new Float(str);
    }
}
