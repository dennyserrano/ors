package ph.gov.deped.data.dto.ds;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Created by PSY on 2014/10/03.
 */
public class Filter implements Serializable {

    private static final long serialVersionUID = 3942585762530779329L;

    private final long criterion;

    private final long element;

    private final Serializable selectedValue;

    @JsonCreator
    public Filter(@JsonProperty("criterion") long criterion, @JsonProperty("element") long element, @JsonProperty("selectedValue") Object selectedValue) {
        this.criterion = criterion;
        this.element = element;
        this.selectedValue = (Serializable) selectedValue;
    }

    public long getCriterion() {
        return criterion;
    }

    public long getElement() {
        return element;
    }

    public Serializable getSelectedValue() {
        return selectedValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Filter)) {
            return false;
        }
        Filter rhs = (Filter) obj;
        return new EqualsBuilder()
                .append(this.criterion, rhs.criterion)
                .append(this.element, rhs.element)
                .append(this.selectedValue, rhs.selectedValue)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(criterion)
                .append(element)
                .append(selectedValue)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("criterion", criterion)
                .append("element", element)
                .append("selectedValue", selectedValue)
                .toString();
    }
}
