package ph.gov.deped.data.dto.ds;

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

    private final Criterion criterion;

    private final Element element;

    private final Serializable selectedValue;

    public Filter(Criterion criterion, Element element, Serializable selectedValue) {
        this.criterion = criterion;
        this.element = element;
        this.selectedValue = selectedValue;
    }

    public Criterion getCriterion() {
        return criterion;
    }

    public Element getElement() {
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
