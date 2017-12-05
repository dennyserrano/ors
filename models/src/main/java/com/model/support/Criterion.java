package com.model.support;

import com.bits.sql.FilterType;
import com.bits.sql.Operator;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 * Created by PSY on 2014/10/01.
 */
public class Criterion implements Serializable {

    private static final long serialVersionUID = 207475894294537201L;

    private final long filterId;

    private final String filterName;
    
    private final FilterType filterType;

    private final long elementId;

    private final Operator operator;
    
    private final int inputType;

    private final List<KeyValue> selection;
    
    private final String label;

    @JsonCreator
    public Criterion(@JsonProperty("filterId") long filterId,
                     @JsonProperty("filterName") String filterName,
                     @JsonProperty("filterType") FilterType filterType, 
                     @JsonProperty("elementId") long elementId,
                     @JsonProperty("operator") Operator operator,
                     @JsonProperty("inputType") int inputType,
                     @JsonProperty("label") String label,
                     @JsonProperty("selection") List<KeyValue> selection) {
        this.filterId = filterId;
        this.filterName = filterName;
        this.filterType = filterType;
        this.elementId = elementId;
        this.operator = operator;
        this.inputType = inputType;
        this.selection = selection;
        this.label = label;
    }

    public long getFilterId() {
        return filterId;
    }

    public String getFilterName() {
        return filterName;
    }

    public FilterType getFilterType() {
        return filterType;
    }

    public long getElementId() {
        return elementId;
    }

    public Operator getOperator() {
        return operator;
    }

    public int getInputType() {
        return inputType;
    }

    public String getLabel() {
        return label;
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
                .append(this.filterType, rhs.filterType)
                .append(this.elementId, rhs.elementId)
                .append(this.operator, rhs.operator)
                .append(this.selection, rhs.selection)
                .append(this.inputType, rhs.inputType)
                .append(this.label, rhs.label)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(filterId)
                .append(filterName)
                .append(filterType)
                .append(elementId)
                .append(operator)
                .append(selection)
                .append(inputType)
                .append(label)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("filterId", filterId)
                .append("filterName", filterName)
                .append("filterType", filterType)
                .append("elementId", elementId)
                .append("operator", operator)
                .append("selection", selection)
                .append("inputType", inputType)
                .append("label", label)
                .toString();
    }
}
