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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "enrollment_shift_summary_journal", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnrollmentShiftSummaryJournal.findAll", query = "SELECT e FROM EnrollmentShiftSummaryJournal e")})
public class EnrollmentShiftSummaryJournal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "original_id", nullable = false)
    private int originalId;
    @Column(name = "report_history_id")
    private Integer reportHistoryId;
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
    @Column(name = "original_created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date originalCreatedAt;
    @Column(name = "original_created_by")
    private Integer originalCreatedBy;
    @Basic(optional = false)
    @Column(name = "original_updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date originalUpdatedAt;
    @Column(name = "original_updated_by")
    private Integer originalUpdatedBy;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "created_by")
    private Integer createdBy;

    public EnrollmentShiftSummaryJournal() {
    }

    public EnrollmentShiftSummaryJournal(Integer id) {
        this.id = id;
    }

    public EnrollmentShiftSummaryJournal(Integer id, int originalId, Date originalCreatedAt, Date originalUpdatedAt, Date createdAt) {
        this.id = id;
        this.originalId = originalId;
        this.originalCreatedAt = originalCreatedAt;
        this.originalUpdatedAt = originalUpdatedAt;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOriginalId() {
        return originalId;
    }

    public void setOriginalId(int originalId) {
        this.originalId = originalId;
    }

    public Integer getReportHistoryId() {
        return reportHistoryId;
    }

    public void setReportHistoryId(Integer reportHistoryId) {
        this.reportHistoryId = reportHistoryId;
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

    public Date getOriginalCreatedAt() {
        return originalCreatedAt;
    }

    public void setOriginalCreatedAt(Date originalCreatedAt) {
        this.originalCreatedAt = originalCreatedAt;
    }

    public Integer getOriginalCreatedBy() {
        return originalCreatedBy;
    }

    public void setOriginalCreatedBy(Integer originalCreatedBy) {
        this.originalCreatedBy = originalCreatedBy;
    }

    public Date getOriginalUpdatedAt() {
        return originalUpdatedAt;
    }

    public void setOriginalUpdatedAt(Date originalUpdatedAt) {
        this.originalUpdatedAt = originalUpdatedAt;
    }

    public Integer getOriginalUpdatedBy() {
        return originalUpdatedBy;
    }

    public void setOriginalUpdatedBy(Integer originalUpdatedBy) {
        this.originalUpdatedBy = originalUpdatedBy;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnrollmentShiftSummaryJournal)) {
            return false;
        }
        EnrollmentShiftSummaryJournal other = (EnrollmentShiftSummaryJournal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.EnrollmentShiftSummaryJournal[ id=" + id + " ]";
    }
    
}
