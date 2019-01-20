package com.bits.sql;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by PSY on 2014/10/04.
 */
public class TimestampValueMapper implements SqlValueMapper<Timestamp> {

    private static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public Timestamp apply(Serializable serializable) {
        if (serializable == null) {
            return null;
        }
        if (serializable instanceof Number) {
            return new Timestamp(((Number) serializable).longValue());
        }
        SimpleDateFormat format = new SimpleDateFormat(TIMESTAMP_FORMAT);
        try {
            return new Timestamp(format.parse(String.valueOf(serializable)).getTime());
        }
        catch (ParseException ex) {
            throw new RuntimeException(String.format("Unable to parse value as Timestamp [%s}.", serializable), ex);
        }
    }
}
