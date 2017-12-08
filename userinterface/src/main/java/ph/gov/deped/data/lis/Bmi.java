/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "bmi", catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bmi.findAll", query = "SELECT b FROM Bmi b")})
public class Bmi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "school_term_id", nullable = false)
    private int schoolTermId;
    @Basic(optional = false)
    @Column(name = "enrolment_id", nullable = false)
    private int enrolmentId;
    @Basic(optional = false)
    @Column(nullable = false)
    private float weight;
    @Basic(optional = false)
    @Column(nullable = false)
    private float height;
    @Basic(optional = false)
    @Column(name = "month_age", nullable = false)
    private short monthAge;
    @Basic(optional = false)
    @Column(nullable = false)
    private short period;
    @Basic(optional = false)
    @Column(name = "ns_code", nullable = false)
    private short nsCode;
    @Basic(optional = false)
    @Column(name = "date_taken", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateTaken;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "updated_by")
    private Integer updatedBy;

    public Bmi() {
    }

    public Bmi(Integer id) {
        this.id = id;
    }

    public Bmi(Integer id, int schoolTermId, int enrolmentId, float weight, float height, short monthAge, short period, short nsCode, Date dateTaken, Date updatedAt) {
        this.id = id;
        this.schoolTermId = schoolTermId;
        this.enrolmentId = enrolmentId;
        this.weight = weight;
        this.height = height;
        this.monthAge = monthAge;
        this.period = period;
        this.nsCode = nsCode;
        this.dateTaken = dateTaken;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSchoolTermId() {
        return schoolTermId;
    }

    public void setSchoolTermId(int schoolTermId) {
        this.schoolTermId = schoolTermId;
    }

    public int getEnrolmentId() {
        return enrolmentId;
    }

    public void setEnrolmentId(int enrolmentId) {
        this.enrolmentId = enrolmentId;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public short getMonthAge() {
        return monthAge;
    }

    public void setMonthAge(short monthAge) {
        this.monthAge = monthAge;
    }

    public short getPeriod() {
        return period;
    }

    public void setPeriod(short period) {
        this.period = period;
    }

    public short getNsCode() {
        return nsCode;
    }

    public void setNsCode(short nsCode) {
        this.nsCode = nsCode;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
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
        if (!(object instanceof Bmi)) {
            return false;
        }
        Bmi other = (Bmi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.Bmi[ id=" + id + " ]";
    }
    
}
