package ph.gov.deped.data.dto.ds;

import com.bits.sql.Operator;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import ph.gov.deped.data.dto.KeyValue;

import java.io.Serializable;
import java.util.List;

/**
 * Created by PSY on 2014/10/01.
 */
public class Criterion implements Serializable {

    private static final long serialVersionUID = 207475894294537201L;

    private final long filterId;

    private final String filterName;

    private final long elementId;

    private final Operator operator;

    private final List<KeyValue> selection;

    @JsonCreator
    public Criterion(@JsonProperty("filterId") long filterId,
                     @JsonProperty("filterName") String filterName,
                     @JsonProperty("elementId") long elementId,
                     @JsonProperty("operator") Operator operator,
                     @JsonProperty("selection") List<KeyValue> selection) {
        this.filterId = filterId;
        this.filterName = filterName;
        this.elementId = elementId;
        this.operator = operator;
        this.selection = selection;
    }

    public long getFilterId() {
        return filterId;
    }

    public String getFilterName() {
        return filterName;
    }

    public long getElementId() {
        return elementId;
    }

    public Operator getOperator() {
        return operator;
    }

    public List<KeyValue> getSelection() {
        return selection;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Criterion)) {
            return false;
        }
        Criterion rhs = (Criterion) obj;
        return new EqualsBuilder()
                .append(this.filterId, rhs.filterId)
                .append(this.filterName, rhs.filterName)
                .append(this.elementId, rhs.elementId)
                .append(this.operator, rhs.operator)
                .append(this.selection, rhs.selection)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(filterId)
                .append(filterName)
                .append(elementId)
                .append(operator)
                .append(selection)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("filterId", filterId)
                .append("filterName", filterName)
                .append("elementId", elementId)
                .append("operator", operator)
                .append("selection", selection)
                .toString();
    }
}
