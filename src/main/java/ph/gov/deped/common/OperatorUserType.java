package ph.gov.deped.common;

import com.bits.sql.Operator;
import com.bits.sql.Operators;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by ej on 8/19/14.
 */
public class OperatorUserType implements UserType {

    private static final Set<Class<? extends Operator>> operators = new HashSet<>(Arrays.asList(
            Operators.Logical.class,
            Operators.Special.class,
            Operators.Math.class,
            Operators.Multiple.class
    ));

    private List<Operator> enums = new ArrayList<>();

    public OperatorUserType() {
        enums = operators.stream()
                .map(o -> o.getEnumConstants())
                .flatMap(constants -> Arrays.asList(constants).stream())
                .collect(Collectors.toList());
    }

    public int[] sqlTypes() {
        return new int[] { Types.VARCHAR };
    }

    public Class<?> returnedClass() {
        return Operator.class;
    }

    public boolean equals(Object x, Object y) throws HibernateException {
        return ( x == y ) || ( x != null && x.equals( y ) );
    }

    public int hashCode(Object x) throws HibernateException {
        return x == null ? 0 : x.hashCode();
    }

    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
        String value = rs.getString(0);
        for (Operator o : enums) {
            if (o.getName().equals(value)) {
                return o;
            }
        }
        return null;
    }

    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
        String strVal = null;
        if (value instanceof Operator) {
            strVal = ((Operator) value).getName();
        }
        if (isBlank(strVal)) {
            st.setNull(index, Types.VARCHAR);
        }
        else {
            st.setString(index, strVal);
        }
    }

    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    public boolean isMutable() {
        return false;
    }

    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return this.deepCopy(original);
    }
}
