package ph.gov.deped.common.query;

import static java.util.Arrays.asList;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public abstract class JdbcTypes {
    
    private static final List<Integer> numericTypes = new ArrayList<>(asList(
            Types.BIGINT, Types.DECIMAL, Types.DOUBLE, Types.FLOAT,
            Types.INTEGER, Types.SMALLINT, Types.TINYINT, Types.REAL
    ));

    private static final List<JdbcType> types = new ArrayList<>();

    static {
        types.add(new JdbcType("bigint", Types.BIGINT, BigInteger.class));
        types.add(new JdbcType("blob", Types.BLOB, byte[].class));
        types.add(new JdbcType("char", Types.CHAR, Character.class));
        types.add(new JdbcType("date", Types.DATE, Date.class));
        types.add(new JdbcType("datetime", Types.TIMESTAMP, Timestamp.class));
        types.add(new JdbcType("decimal", Types.DECIMAL, BigDecimal.class));
        types.add(new JdbcType("double", Types.DOUBLE, Double.class));
        types.add(new JdbcType("float", Types.FLOAT, Float.class));
        types.add(new JdbcType("int", Types.INTEGER, Integer.class));
        types.add(new JdbcType("longblob", Types.LONGVARBINARY, byte[].class));
        types.add(new JdbcType("longtext", Types.LONGVARCHAR, String.class));
        types.add(new JdbcType("mediumint", Types.INTEGER, Integer.class));
        types.add(new JdbcType("smallint", Types.SMALLINT, Short.class));
        types.add(new JdbcType("text", Types.VARCHAR, String.class));
        types.add(new JdbcType("timestamp", Types.TIMESTAMP, Timestamp.class));
        types.add(new JdbcType("tinyint", Types.TINYINT, Short.class));
        types.add(new JdbcType("varbinary", Types.VARCHAR, String.class));
        types.add(new JdbcType("varchar", Types.VARCHAR, String.class));
        types.add(new JdbcType("year", Types.SMALLINT, Short.class));
    }
    
    public static boolean isNumeric(int sqlType) {
        return numericTypes.contains(sqlType);
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
    
    public static Class<? extends Serializable> getJavaType(int sqlType) {
        Optional<JdbcType> jdbcType = types.stream()
                .filter(j -> j.sqlType == sqlType)
                .findFirst();
        if (!jdbcType.isPresent()) {
            throw new MissingJdbcDataTypeMapping("SQL Type: " + sqlType);
        }
        JdbcType j = jdbcType.get();
        return j.javaType;
    }
}
