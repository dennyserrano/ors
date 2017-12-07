package ph.gov.deped.data.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.model.support.Dataset;

import java.io.Serializable;

/**
 * @author ej
 * @since Nov 26, 2014 15:43
 */
public class DatasetStore implements Serializable {
    
    private static final long serialVersionUID = 3612917249198147994L;
    
    private String sessionId;
    
    private int step;
    
    private Dataset dataset;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DatasetStore)) {
            return false;
        }
        DatasetStore rhs = (DatasetStore) obj;
        return new EqualsBuilder()
                .append(this.sessionId, rhs.sessionId)
                .append(this.step, rhs.step)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(sessionId)
                .append(step)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("sessionId", sessionId)
                .append("step", step)
                .append("dataset", dataset)
                .toString();
    }
}
