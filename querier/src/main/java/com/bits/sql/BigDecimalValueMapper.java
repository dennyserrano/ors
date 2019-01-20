package com.bits.sql;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by PSY on 2014/10/04.
 */
public class BigDecimalValueMapper implements NumericValueMapper<BigDecimal> {

    public BigDecimal apply(Serializable serializable) {
        String str = String.valueOf(serializable);
        return isBlank(str) ? null : new BigDecimal(str);
    }
}
