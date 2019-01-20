package com.bits.sql;

import java.io.Serializable;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by PSY on 2014/10/04.
 */
public class BooleanValueMapper implements SqlValueMapper<Boolean> {

    public Boolean apply(Serializable serializable) {
        Boolean result = null;
        if (serializable == null) {
            result = Boolean.FALSE;
        }
        else if (serializable instanceof Number) {
            Number num = (Number) serializable;
            if (num.intValue() <= 0) {
                result = Boolean.FALSE;
            }
            else {
                result = Boolean.TRUE;
            }
        }
        else if (serializable instanceof Character) {
            Character character = (Character) serializable;
            if (character == null || character.charValue() == '\u0000') {
                result = Boolean.FALSE;
            }
            else if (character == 'n' || character == 'N' || character == '0') {
                result = Boolean.FALSE;
            }
            else {
                result = Boolean.TRUE;
            }
        }
        else {
            String str = (String) serializable;
            if (isBlank(str) || "no".equalsIgnoreCase(str)) {
                result = Boolean.FALSE;
            }
            else if ("yes".equalsIgnoreCase(str)) {
                result = Boolean.TRUE;
            }
            else {
                result = Boolean.parseBoolean(serializable.toString());
            }
        }
        return result;
    }
}
