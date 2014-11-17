package ph.gov.deped.data.dto.ds;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Created by ej on 8/28/14.
 */
public class Element implements Serializable {

    private static final long serialVersionUID = 5051970119831782659L;

    private final long id;

    private final String name;

    private final String description;

    private final String meaning;

    private final long datasetId;

    @JsonCreator
    public Element(@JsonProperty("id") long id, @JsonProperty("name") String name,
                   @JsonProperty("description") String description,
                   @JsonProperty("meaning") String meaning,
                   @JsonProperty("datasetId") long datasetId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.meaning = meaning;
        this.datasetId = datasetId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getMeaning() {
        return meaning;
    }

    public long getDatasetId() {
        return datasetId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Element)) {
            return false;
        }
        Element rhs = (Element) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("name", name)
                .append("description", description)
                .append("meaning", meaning)
                .append("datasetId", datasetId)
                .toString();
    }
}
