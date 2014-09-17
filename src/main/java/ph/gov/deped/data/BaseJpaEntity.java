package ph.gov.deped.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;

/**
 * Created by ej on 8/15/14.
 */
@MappedSuperclass
public abstract class BaseJpaEntity<ID extends Serializable> implements JpaEntity<ID>, Auditable<String, ID> {

    public static final String COL_DATE_CREATED = "date_created";

    public static final String COL_CREATED_BY = "created_by";

    public static final String COL_DATE_UPDATED = "date_updated";

    public static final String COL_UPDATED_BY = "updated_by";

    public static final String DATE_CREATED = "dateCreated";

    public static final String CREATED_BY = "createdBy";

    public static final String DATE_UPDATED = "dateUpdated";

    public static final String UPDATED_BY = "updatedBy";

    public static final String LAST_MODIFIED_BY = "lastModifiedBy";

    public static final String LAST_MODIFIED_DATE = "lastModifiedDate";

    private static final long serialVersionUID = 438634957986545968L;

    private @Column(nullable = false) @Temporal(TemporalType.TIMESTAMP) Date dateCreated;

    private @Column(length = 50, nullable = false) String createdBy;

    private @Temporal(TemporalType.TIMESTAMP) Date dateUpdated;

    private @Column(length = 50) String updatedBy;

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public DateTime getCreatedDate() {
        return new DateTime(getDateCreated());
    }

    public void setCreatedDate(DateTime creationDate) {
        setDateCreated(creationDate.toDate());
    }

    public String getLastModifiedBy() {
        return getUpdatedBy();
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        setUpdatedBy(lastModifiedBy);
    }

    public DateTime getLastModifiedDate() {
        return new DateTime(getDateUpdated());
    }

    public void setLastModifiedDate(DateTime lastModifiedDate) {
        setDateUpdated(lastModifiedDate.toDate());
    }

    public @Override String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("createdBy", createdBy)
                .append("dateCreated", dateCreated)
                .append("updatedBy", updatedBy)
                .append("dateUpdated", dateUpdated)
                .build();
    }
}
