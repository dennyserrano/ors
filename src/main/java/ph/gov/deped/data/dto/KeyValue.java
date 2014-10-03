package ph.gov.deped.data.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 * Created by PSY on 2014/10/03.
 */
public class KeyValue implements Serializable {

    private static final long serialVersionUID = 294717025525624184L;

    private final String key;

    private final String value;

    private List<KeyValue> childKeyValues;

    public KeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public List<KeyValue> getChildKeyValues() {
        return childKeyValues;
    }

    public void setChildKeyValues(List<KeyValue> childKeyValues) {
        this.childKeyValues = childKeyValues;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof KeyValue)) {
            return false;
        }
        KeyValue rhs = (KeyValue) obj;
        return new EqualsBuilder()
                .append(this.key, rhs.key)
                .append(this.value, rhs.value)
                .append(this.childKeyValues, rhs.childKeyValues)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(key)
                .append(value)
                .append(childKeyValues)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("key", key)
                .append("value", value)
                .append("childKeyValues", childKeyValues)
                .toString();
    }
}
