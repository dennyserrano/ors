package ph.gov.deped.common.query;

import org.hibernate.type.BigDecimalType;
import org.hibernate.type.BigIntegerType;
import org.hibernate.type.BooleanType;
import org.hibernate.type.ByteType;
import org.hibernate.type.CharacterType;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.ShortType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimeType;
import org.hibernate.type.TimestampType;
import org.hibernate.type.Type;

import java.sql.Types;
import java.util.function.Supplier;

/**
 * Created by ej on 8/19/14.
 */
public enum ValueTypes implements ValueType {

    STRING(Types.VARCHAR, StringType::new),
    LONG(Types.BIGINT, BigIntegerType::new),
    INTEGER(Types.INTEGER, IntegerType::new),
    SHORT(Types.SMALLINT, ShortType::new),
    BYTE(Types.TINYINT, ByteType::new),
    BOOLEAN(Types.BIT, BooleanType::new),
    DOUBLE(Types.DOUBLE, DoubleType::new),
    FLOAT(Types.FLOAT, FloatType::new),
    BIGDECIMAL(Types.DECIMAL, BigDecimalType::new),
    DATE(Types.DATE, DateType::new),
    TIMESTAMP(Types.TIMESTAMP, TimestampType::new),
    TIME(Types.TIME, TimeType::new),
    CHAR(Types.CHAR, CharacterType::new),

    ;

    int sqlType;

    Supplier<Type> typeMapper;

    ValueTypes(int _sqlType, Supplier<Type> _typeMapper) {
        sqlType = _sqlType;
        typeMapper = _typeMapper;
    }

    public Type getTypeMapper() {
        return typeMapper.get();
    }

    public int getSqlType() {
        return sqlType;
    }
}
