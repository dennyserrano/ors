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

    private final boolean visible;
    
    private final boolean aggregatable;
    
    private String aggregate;
    
    @JsonCreator
    public Element(@JsonProperty("id") long id, @JsonProperty("name") String name,
                   @JsonProperty("description") String description,
                   @JsonProperty("meaning") String meaning,
                   @JsonProperty("datasetId") long datasetId,
                   @JsonProperty("visible") boolean visible,
                   @JsonProperty("aggregatable") boolean aggregatable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.meaning = meaning;
        this.datasetId = datasetId;
        this.visible=visible;
        this.aggregatable=aggregatable;
        
    }

//    @JsonCreator
//    public Element(@JsonProperty("id") long id, @JsonProperty("name") String name,
//                   @JsonProperty("description") String description,
//                   @JsonProperty("meaning") String meaning,
//                   @JsonProperty("datasetId") long datasetId,
//                   @JsonProperty("visible") boolean visible) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.meaning = meaning;
//        this.datasetId = datasetId;
//        this.visible=visible;
//        this.aggregatable=false;
//        aggregate="";
//    }
    
    public String getAggregate() {
		return aggregate;
	}



	public void setAggregate(String aggregate) {
		this.aggregate = aggregate;
	}


	public boolean isAggregatable() {
		return aggregatable;
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

    
    public boolean isVisible() {
		return visible;
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
