package com.bits.sql;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static java.lang.String.format;
import static java.util.Arrays.asList;

@SuppressWarnings({"unchecked"})
public abstract class JdbcTypes {
    
    private static final List<String> numericTypes = new ArrayList<>(asList(
            "bigint", "decimal", "double", "float", "int", "smallint", "tinyint","mediumint"
    ));
    
    private static final List<String> decimalNumberTypes = new ArrayList<>(asList(
            "decimal", "double", "float"
    ));
    
    private static final List<String> wholeNumberTypes = new ArrayList<>(asList(
            "bigint", "int", "smallint", "tinyint", "long","mediumint"
    ));

    private static final List<String> stringTypes = new ArrayList<>(asList(
            "longtext", "varchar"
    ));
    
    private static final List<String> calendarTypes = new ArrayList<>(asList(
            "date", "time", "datetime", "timestamp"
    ));
    
    public static final Predicate<String> numericPredicate = numericTypes::contains;

    public static final Predicate<String> decimalNumberPredicate = decimalNumberTypes::contains;

    public static final Predicate<String> wholeNumberPredicate = wholeNumberTypes::contains;

    public static final Predicate<String> stringPredicate = stringTypes::contains;
    
    public static final Predicate<String> calendarPredicate = calendarTypes::contains;

    private static final List<JdbcType> types = new ArrayList<>();

    static {
        types.add(new JdbcType("bigint",    Types.BIGINT,           BigInteger.class,   new BigIntValueMapper(), (rs, colName) -> rs.getBigDecimal(colName).toBigInteger()));
        types.add(new JdbcType("blob",      Types.BLOB,             byte[].class,       new ByteArrayValueMapper(), (rs, colName) -> {
            Blob blob = rs.getBlob(colName);
            int length = (int) blob.length();
            return blob.getBytes(0, length);
        }));
        types.add(new JdbcType("char",      Types.CHAR,             Character.class,    new CharValueMapper(), (rs, colName) -> rs.getString(colName).charAt(0)));
        types.add(new JdbcType("date",      Types.DATE,             Date.class,         new DateValueMapper(), (rs, colName) -> rs.getDate(colName)));
        types.add(new JdbcType("datetime",  Types.TIMESTAMP,        Timestamp.class,    new TimestampValueMapper(), (rs, colName) -> rs.getTimestamp(colName)));
        types.add(new JdbcType("decimal",   Types.DECIMAL,          BigDecimal.class,   new BigDecimalValueMapper(), (rs, colName) -> rs.getBigDecimal(colName)));
        types.add(new JdbcType("double",    Types.DOUBLE,           Double.class,       new DoubleValueMapper(), (rs, colName) -> rs.getDouble(colName)));
        types.add(new JdbcType("float",     Types.FLOAT,            Float.class,        new FloatValueMapper(), (rs, colName) -> rs.getFloat(colName)));
        types.add(new JdbcType("int",       Types.INTEGER,          Integer.class,      new IntegerValueMapper(), (rs, colName) -> rs.getInt(colName)));
        types.add(new JdbcType("longblob",  Types.LONGVARBINARY,    byte[].class,       new ByteArrayValueMapper(), (rs, colName) -> {
            Blob blob = rs.getBlob(colName);
            int length = (int) blob.length();
            return blob.getBytes(0, length);
        }));
        types.add(new JdbcType("longtext",  Types.LONGVARCHAR,      String.class,       new StringValueMapper(), (rs, colName) -> rs.getString(colName)));
        types.add(new JdbcType("mediumint", Types.INTEGER,          Integer.class,      new IntegerValueMapper(), (rs, colName) -> rs.getInt(colName)));
        types.add(new JdbcType("mediumtext",Types.LONGNVARCHAR,     String.class,       new StringValueMapper(), (rs, colName) -> rs.getString(colName)));
        types.add(new JdbcType("smallint",  Types.SMALLINT,         Short.class,        new ShortValueMapper(), (rs, colName) -> rs.getShort(colName)));
        types.add(new JdbcType("text",      Types.VARCHAR,          String.class,       new StringValueMapper(), (rs, colName) -> rs.getString(colName)));
        types.add(new JdbcType("timestamp", Types.TIMESTAMP,        Timestamp.class,    new TimestampValueMapper(), (rs, colName) -> rs.getTimestamp(colName)));
        types.add(new JdbcType("tinyint",   Types.TINYINT,          Short.class,        new ShortValueMapper(), (rs, colName) -> rs.getShort(colName)));
        types.add(new JdbcType("varbinary", Types.VARCHAR,          String.class,       new StringValueMapper(), (rs, colName) -> rs.getString(colName)));
        types.add(new JdbcType("varchar",   Types.VARCHAR,          String.class,       new StringValueMapper(), (rs, colName) -> rs.getString(colName)));
        types.add(new JdbcType("string",   Types.VARCHAR,          String.class,       new StringValueMapper(), (rs, colName) -> rs.getString(colName)));
        types.add(new JdbcType("year",      Types.SMALLINT,         Short.class,        new ShortValueMapper(), (rs, colName) -> rs.getShort(colName)));
    }
    
    public static boolean isNumeric(String dataType) {
        return numericPredicate.test(dataType);
    }

    public static boolean isStringType(String dataType) {
        return stringPredicate.test(dataType);
    }

    public static boolean isBoolean(String dataType, Long precision) {
        return "smallint".equals(dataType) && precision != null && precision < 3;
    }
    
    public static boolean isDecimalType(String dataType) {
        return decimalNumberPredicate.test(dataType);
    }
    
    public static boolean isWholeType(String dataType) {
        return wholeNumberPredicate.test(dataType);
    }
    
    public static boolean isCalendarType(String dataType) {
        return calendarPredicate.test(dataType);
    }
    
    public static boolean isDateType(String dataType) {
        return "date".equals(dataType);
    }

    public static int getSqlType(String colType) {
        Optional<JdbcType> jdbcType = types.stream()
                .filter(j -> j.dataType.equals(colType))
                .findFirst();
        if (!jdbcType.isPresent()) {
            throw new MissingJdbcDataTypeMapping(colType);
        }
        JdbcType j = jdbcType.get();
        return j.sqlType;
    }
    
    public static Class<? extends Serializable> getJavaType(String sqlType) {
        Optional<JdbcType> jdbcType = types.stream()
                .filter(j -> j.dataType.equals(sqlType))
                .findFirst();
        if (!jdbcType.isPresent()) {
            throw new MissingJdbcDataTypeMapping("SQL Type: " + sqlType);
        }
        JdbcType j = jdbcType.get();
        return j.javaType;
    }

    @SuppressWarnings({"unchecked"})
    public static <O extends Serializable> SqlValueMapper<O> getValueMapper(String dataType) {
        return (SqlValueMapper<O>) types.stream()
                .filter(j -> j.dataType.equals(dataType))
                .findFirst()
                .get().sqlValueMapper;
    }
    
    public static <O extends Serializable> O getValue(ResultSet rs, String columnName, String dataType) throws SQLException {
        
    	Optional<JdbcType> optional = types.stream()
                .filter(j -> j.dataType.equals(dataType))
                .findFirst();
        if (!optional.isPresent()) {
            throw new UnsupportedOperationException(format("Unable to retrieve value of data type [%s] from ResultSet.", dataType));
        
        }
        
        return (O) optional.get().retrieve(rs, columnName);
    }
    
    public static Double getDoubleValue(Serializable value) {
        return new DoubleValueMapper().apply(value);
    }
    
    public static String getStringValue(Serializable value) {
        return new StringValueMapper().apply(value);
    }
    
    public static Boolean getBooleanValue(Serializable value) {
        return new BooleanValueMapper().apply(value);
    }
    
    public static Date getDateValue(Serializable value) {
        return new DateValueMapper().apply(value);
    }
    
    public static Timestamp getTimestampValue(Serializable value) {
        return new TimestampValueMapper().apply(value);
    }
}
