package com.bits.sql;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by PSY on 2014/10/04.
 */
public class DateValueMapper implements SqlValueMapper<Date> {
    
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    
    private String dateFormat = DATE_FORMAT;

    public Date apply(Serializable serializable) {
        if (serializable == null) {
            return null;
        }
        if (Number.class.isAssignableFrom(serializable.getClass())) {
            return new Date(((Number) serializable).longValue());
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            return sdf.parse(String.valueOf(serializable));
        } catch (ParseException ex) {
            throw new RuntimeException(String.format("Unable to convert [%s] to Date.", String.valueOf(serializable)), ex);
        }
    }
}
