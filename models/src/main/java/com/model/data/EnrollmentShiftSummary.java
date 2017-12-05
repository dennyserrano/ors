/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model.data;

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
@Table(name = "enrollment_shift_summary", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"report_history_id", "particulars_id", "shift_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnrollmentShiftSummary.findAll", query = "SELECT e FROM EnrollmentShiftSummary e")})
public class EnrollmentShiftSummary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "report_history_id")
    private Integer reportHistoryId;
    @Column(name = "particulars_id")
    private Integer particularsId;
    @Column(name = "shift_id")
    private Short shiftId;
    @Column(name = "enrolled_male")
    private Short enrolledMale;
    @Column(name = "enrolled_female")
    private Short enrolledFemale;
    @Column(name = "number_of_classes")
    private Short numberOfClasses;
    @Column(name = "report_year")
    @Temporal(TemporalType.DATE)
    private Date reportYear;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "created_by")
    private Integer createdBy;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "updated_by")
    private Integer updatedBy;

    public EnrollmentShiftSummary() {
    }

    public EnrollmentShiftSummary(Integer id) {
        this.id = id;
    }

    public EnrollmentShiftSummary(Integer id, Date createdAt, Date updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReportHistoryId() {
        return reportHistoryId;
    }

    public void setReportHistoryId(Integer reportHistoryId) {
        this.reportHistoryId = reportHistoryId;
    }

    public Integer getParticularsId() {
        return particularsId;
    }

    public void setParticularsId(Integer particularsId) {
        this.particularsId = particularsId;
    }

    public Short getShiftId() {
        return shiftId;
    }

    public void setShiftId(Short shiftId) {
        this.shiftId = shiftId;
    }

    public Short getEnrolledMale() {
        return enrolledMale;
    }

    public void setEnrolledMale(Short enrolledMale) {
        this.enrolledMale = enrolledMale;
    }

    public Short getEnrolledFemale() {
        return enrolledFemale;
    }

    public void setEnrolledFemale(Short enrolledFemale) {
        this.enrolledFemale = enrolledFemale;
    }

    public Short getNumberOfClasses() {
        return numberOfClasses;
    }

    public void setNumberOfClasses(Short numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    public Date getReportYear() {
        return reportYear;
    }

    public void setReportYear(Date reportYear) {
        this.reportYear = reportYear;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnrollmentShiftSummary)) {
            return false;
        }
        EnrollmentShiftSummary other = (EnrollmentShiftSummary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.EnrollmentShiftSummary[ id=" + id + " ]";
    }
    
}
