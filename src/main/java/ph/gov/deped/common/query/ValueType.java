package ph.gov.deped.common.query;

import org.hibernate.type.Type;

/**
 * Created by ej on 8/19/14.
 */
public interface ValueType {

    int getSqlType();

    Type getTypeMapper();
}
