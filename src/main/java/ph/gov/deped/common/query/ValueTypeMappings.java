package ph.gov.deped.common.query;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by ej on 8/29/14.
 */
public abstract class ValueTypeMappings {

    private static final ConcurrentMap<Class<? extends Serializable>, ValueTypes> map = new ConcurrentHashMap<>();

    static {
        map.put(String.class, ValueTypes.STRING);
        map.put(Character.class, ValueTypes.CHAR);
        map.put(Boolean.class, ValueTypes.BOOLEAN);
        map.put(Long.class, ValueTypes.LONG);
        map.put(Integer.class, ValueTypes.INTEGER);
        map.put(Short.class, ValueTypes.SHORT);
        map.put(Byte.class, ValueTypes.BYTE);
        map.put(Double.class, ValueTypes.DOUBLE);
        map.put(Float.class, ValueTypes.FLOAT);
        map.put(BigInteger.class, ValueTypes.LONG);
        map.put(BigDecimal.class, ValueTypes.BIGDECIMAL);
        map.put(Date.class, ValueTypes.DATE);
        map.put(Timestamp.class, ValueTypes.TIMESTAMP);
        map.put(char.class, ValueTypes.CHAR);
        map.put(boolean.class, ValueTypes.BOOLEAN);
        map.put(long.class, ValueTypes.LONG);
        map.put(int.class, ValueTypes.INTEGER);
        map.put(short.class, ValueTypes.SHORT);
        map.put(byte.class, ValueTypes.BYTE);
        map.put(double.class, ValueTypes.DOUBLE);
        map.put(float.class, ValueTypes.FLOAT);
    }

    public static ValueTypes getValueType(Class<? extends Serializable> type) {
        return map.get(type);
    }

    public static Class<? extends Serializable> getJavaType(int sqlType) {
        ValueTypes foundType = null;
        for (ValueTypes type : ValueTypes.values()) {
            if (sqlType == type.getSqlType()) {
                foundType = type;
                break;
            }
        }
        ValueTypes type = foundType;
        return map.entrySet().stream()
                .filter(e -> e.getValue().equals(type))
                .findFirst()
                .get().getKey();
    }
}
