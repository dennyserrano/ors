package com.bits.sql;

import java.io.Serializable;

/**
 * Created by PSY on 2014/10/04.
 */
public class StringValueMapper implements SqlValueMapper<String> {

    public String apply(Serializable serializable) {
        return serializable == null ? "[NULL]" : String.valueOf(serializable);
    }
}
