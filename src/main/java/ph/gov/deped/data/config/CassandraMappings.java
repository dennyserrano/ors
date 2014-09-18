package ph.gov.deped.data.config;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.apache.cassandra.db.marshal.AbstractType;
import org.apache.cassandra.db.marshal.ListType;
import org.apache.cassandra.db.marshal.MapType;
import org.apache.cassandra.db.marshal.SetType;

import com.datastax.driver.core.DataType;

/**
 * Created by ej on 9/10/14.
 */
public class CassandraMappings {

    public static <T> DataType getCassandraType(Class<T> javaType) {
        for (Basic b : Basic.values()) {
            if (b.getJavaType().equals(javaType)) {
                return b.getDataType();
            }
        }
        return null;
    }

    @SuppressWarnings({"unchecked"})
    public static enum Basic {

        VARCHAR(String.class, DataType.varchar()),
        LONG(Long.class, DataType.bigint()),
        SHORT(Short.class, DataType.cint()),
        BLOB(ByteBuffer.class, DataType.blob()),
        BYTE(Byte.class, DataType.cint()),
        BYTES(byte[].class, DataType.blob()),
        BOOLEAN(Boolean.class, DataType.cboolean()),
        COUNTER(Long.class, DataType.counter()),
        BIGINT(BigInteger.class, DataType.varint()),
        DECIMAL(BigDecimal.class, DataType.decimal()),
        DOUBLE(Double.class, DataType.cdouble()),
        FLOAT(Float.class, DataType.cfloat()),
        INET(InetAddress.class, DataType.inet()),
        INTEGER(Integer.class, DataType.cint()),
        DATE(Date.class, DataType.timestamp()),
        TIMESTAMP(Timestamp.class, DataType.timestamp()),
        TIMEUUID(UUID.class, DataType.timeuuid()),
        UUID(UUID.class, DataType.uuid()),

        P_BYTE(byte.class, DataType.blob()),
        P_SHORT(short.class, DataType.cint()),
        P_INT(int.class, DataType.cint()),
        P_LONG(long.class, DataType.bigint()),
        P_FLOAT(float.class, DataType.cfloat()),
        P_DOUBLE(double.class, DataType.cdouble()),
        P_BOOLEAN(boolean.class, DataType.cboolean()),
        P_CHAR(char.class, DataType.cint())

        ;

        private Class<?> javaType;

        private DataType dataType;

        Basic(Class<?> _javaType, DataType _dataType) {
            javaType = _javaType;
            dataType = _dataType;
        }

        public <T> Class<T> getJavaType() {
            return (Class<T>) javaType;
        }

        public DataType getDataType() {
            return dataType;
        }
    }

    public static class Collection {

        public static <T> ListType<T> listType(AbstractType<T> cassandraType) {
            return ListType.getInstance(cassandraType);
        }

        public static <T> SetType<T> setType(AbstractType<T> cassandraType) {
            return SetType.getInstance(cassandraType);
        }

        public static <K, V> MapType<K, V> mapType(AbstractType<K> keyType, AbstractType<V> valueType) {
            return MapType.getInstance(keyType, valueType);
        }
    }
}
