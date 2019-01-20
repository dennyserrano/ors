package com.bits.sql;

import java.io.Serializable;

/**
 * Created by PSY on 2014/10/04.
 */
public class CharValueMapper implements SqlValueMapper<Character> {

    public Character apply(Serializable serializable) {
        return String.valueOf(serializable).charAt(0);
    }
}
