/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "educ_train_background", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"creator_id", "personnel_id", "education_training_type", "etb_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EducTrainBackground.findAll", query = "SELECT e FROM EducTrainBackground e")})
public class EducTrainBackground implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "creator_id", nullable = false)
    private short creatorId;
    @Basic(optional = false)
    @Column(name = "personnel_id", nullable = false)
    private short personnelId;
    @Basic(optional = false)
    @Column(name = "etb_id", nullable = false)
    private short etbId;
    @Column(name = "education_training_type")
    private Short educationTrainingType;
    @Column(name = "school_name_provider", length = 128)
    private String schoolNameProvider;
    @Basic(optional = false)
    @Column(nullable = false)
    private short completed;
    @Basic(optional = false)
    @Column(name = "from_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Basic(optional = false)
    @Column(name = "to_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @Basic(optional = false)
    @Column(nullable = false, length = 128)
    private String description;
    @Basic(optional = false)
    @Column(name = "location_conducted", nullable = false, length = 128)
    private String locationConducted;
    @Column(name = "no_of_hours")
    private Short noOfHours;
    private Short country;

    public EducTrainBackground() {
    }

    public EducTrainBackground(Integer id) {
        this.id = id;
    }

    public EducTrainBackground(Integer id, short creatorId, short personnelId, short etbId, short completed, Date fromDate, Date toDate, String description, String locationConducted) {
        this.id = id;
        this.creatorId = creatorId;
        this.personnelId = personnelId;
        this.etbId = etbId;
        this.completed = completed;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.description = description;
        this.locationConducted = locationConducted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(short creatorId) {
        this.creatorId = creatorId;
    }

    public short getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(short personnelId) {
        this.personnelId = personnelId;
    }

    public short getEtbId() {
        return etbId;
    }

    public void setEtbId(short etbId) {
        this.etbId = etbId;
    }

    public Short getEducationTrainingType() {
        return educationTrainingType;
    }

    public void setEducationTrainingType(Short educationTrainingType) {
        this.educationTrainingType = educationTrainingType;
    }

    public String getSchoolNameProvider() {
        return schoolNameProvider;
    }

    public void setSchoolNameProvider(String schoolNameProvider) {
        this.schoolNameProvider = schoolNameProvider;
    }

    public short getCompleted() {
        return completed;
    }

    public void setCompleted(short completed) {
        this.completed = completed;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocationConducted() {
        return locationConducted;
    }

    public void setLocationConducted(String locationConducted) {
        this.locationConducted = locationConducted;
    }

    public Short getNoOfHours() {
        return noOfHours;
    }

    public void setNoOfHours(Short noOfHours) {
        this.noOfHours = noOfHours;
    }

    public Short getCountry() {
        return country;
    }

    public void setCountry(Short country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EducTrainBackground)) {
            return false;
        }
        EducTrainBackground other = (EducTrainBackground) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.EducTrainBackground[ id=" + id + " ]";
    }
    
}
