package com.bits.sql;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ej on 10/17/14.
 */
@FunctionalInterface
public interface ResultSetValueRetriever<O extends Serializable> {
    
    O retrieve(ResultSet rs, String columnName) throws SQLException;
}
