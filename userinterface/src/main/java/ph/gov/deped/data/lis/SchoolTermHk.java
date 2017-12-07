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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "school_term_hk", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sy_from"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolTermHk.findAll", query = "SELECT s FROM SchoolTermHk s")})
public class SchoolTermHk implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sy_from", nullable = false)
    private short syFrom;
    @Column(name = "sy_to")
    private Short syTo;
    @Basic(optional = false)
    @Column(nullable = false)
    private short formal;
    @Column(name = "class_start_date")
    @Temporal(TemporalType.DATE)
    private Date classStartDate;
    @Column(name = "class_end_date")
    @Temporal(TemporalType.DATE)
    private Date classEndDate;
    @Column(name = "enrolment_start_date")
    @Temporal(TemporalType.DATE)
    private Date enrolmentStartDate;
    @Column(name = "enrolment_last_date")
    @Temporal(TemporalType.DATE)
    private Date enrolmentLastDate;
    @Column(name = "lis_start_date")
    @Temporal(TemporalType.DATE)
    private Date lisStartDate;
    @Column(name = "lis_end_date")
    @Temporal(TemporalType.DATE)
    private Date lisEndDate;
    @Column(name = "eosy_start")
    @Temporal(TemporalType.DATE)
    private Date eosyStart;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "updated_by")
    private Integer updatedBy;
    @Column(name = "eosy_end")
    @Temporal(TemporalType.DATE)
    private Date eosyEnd;
    @Column(name = "bosy_cutoff")
    @Temporal(TemporalType.DATE)
    private Date bosyCutoff;
    @Column(name = "bosy_deadline")
    @Temporal(TemporalType.DATE)
    private Date bosyDeadline;

    public SchoolTermHk() {
    }

    public SchoolTermHk(Integer id) {
        this.id = id;
    }

    public SchoolTermHk(Integer id, short syFrom, short formal, Date createdAt) {
        this.id = id;
        this.syFrom = syFrom;
        this.formal = formal;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getSyFrom() {
        return syFrom;
    }

    public void setSyFrom(short syFrom) {
        this.syFrom = syFrom;
    }

    public Short getSyTo() {
        return syTo;
    }

    public void setSyTo(Short syTo) {
        this.syTo = syTo;
    }

    public short getFormal() {
        return formal;
    }

    public void setFormal(short formal) {
        this.formal = formal;
    }

    public Date getClassStartDate() {
        return classStartDate;
    }

    public void setClassStartDate(Date classStartDate) {
        this.classStartDate = classStartDate;
    }

    public Date getClassEndDate() {
        return classEndDate;
    }

    public void setClassEndDate(Date classEndDate) {
        this.classEndDate = classEndDate;
    }

    public Date getEnrolmentStartDate() {
        return enrolmentStartDate;
    }

    public void setEnrolmentStartDate(Date enrolmentStartDate) {
        this.enrolmentStartDate = enrolmentStartDate;
    }

    public Date getEnrolmentLastDate() {
        return enrolmentLastDate;
    }

    public void setEnrolmentLastDate(Date enrolmentLastDate) {
        this.enrolmentLastDate = enrolmentLastDate;
    }

    public Date getLisStartDate() {
        return lisStartDate;
    }

    public void setLisStartDate(Date lisStartDate) {
        this.lisStartDate = lisStartDate;
    }

    public Date getLisEndDate() {
        return lisEndDate;
    }

    public void setLisEndDate(Date lisEndDate) {
        this.lisEndDate = lisEndDate;
    }

    public Date getEosyStart() {
        return eosyStart;
    }

    public void setEosyStart(Date eosyStart) {
        this.eosyStart = eosyStart;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
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

    public Date getEosyEnd() {
        return eosyEnd;
    }

    public void setEosyEnd(Date eosyEnd) {
        this.eosyEnd = eosyEnd;
    }

    public Date getBosyCutoff() {
        return bosyCutoff;
    }

    public void setBosyCutoff(Date bosyCutoff) {
        this.bosyCutoff = bosyCutoff;
    }

    public Date getBosyDeadline() {
        return bosyDeadline;
    }

    public void setBosyDeadline(Date bosyDeadline) {
        this.bosyDeadline = bosyDeadline;
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
        if (!(object instanceof SchoolTermHk)) {
            return false;
        }
        SchoolTermHk other = (SchoolTermHk) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.SchoolTermHk[ id=" + id + " ]";
    }
    
}
