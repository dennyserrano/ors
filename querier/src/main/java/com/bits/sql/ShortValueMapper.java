package com.bits.sql;

import java.io.Serializable;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by PSY on 2014/10/04.
 */
public class ShortValueMapper implements NumericValueMapper<Short> {

    public Short apply(Serializable serializable) {
        String str = String.valueOf(serializable);
        return isBlank(str) ? null : new Short(str);
    }
}
