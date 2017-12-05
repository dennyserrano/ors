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
@Table(name = "ref_report_history", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"report_id", "sy_from"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefReportHistory.findAll", query = "SELECT r FROM RefReportHistory r")})
public class RefReportHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "report_id", nullable = false)
    private short reportId;
    @Column(length = 500)
    private String remarks;
    @Basic(optional = false)
    @Column(name = "report_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date reportDate;
    @Column(name = "sy_from", length = 4)
    private String syFrom;
    @Column(name = "sy_to", length = 4)
    private String syTo;
    @Basic(optional = false)
    @Column(name = "report_status", nullable = false)
    private short reportStatus;
    @Basic(optional = false)
    @Column(name = "cutoff_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date cutoffDate;
    @Column(name = "start_encoding_date")
    @Temporal(TemporalType.DATE)
    private Date startEncodingDate;
    @Basic(optional = false)
    @Column(name = "school_deadline", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date schoolDeadline;
    @Basic(optional = false)
    @Column(name = "division_validation_deadline", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date divisionValidationDeadline;
    @Column(name = "division_validation_extended")
    @Temporal(TemporalType.DATE)
    private Date divisionValidationExtended;
    @Basic(optional = false)
    @Column(name = "created_by", nullable = false)
    private int createdBy;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "updated_by")
    private Integer updatedBy;

    public RefReportHistory() {
    }

    public RefReportHistory(Integer id) {
        this.id = id;
    }

    public RefReportHistory(Integer id, short reportId, Date reportDate, short reportStatus, Date cutoffDate, Date schoolDeadline, Date divisionValidationDeadline, int createdBy, Date createdAt, Date updatedAt) {
        this.id = id;
        this.reportId = reportId;
        this.reportDate = reportDate;
        this.reportStatus = reportStatus;
        this.cutoffDate = cutoffDate;
        this.schoolDeadline = schoolDeadline;
        this.divisionValidationDeadline = divisionValidationDeadline;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getReportId() {
        return reportId;
    }

    public void setReportId(short reportId) {
        this.reportId = reportId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getSyFrom() {
        return syFrom;
    }

    public void setSyFrom(String syFrom) {
        this.syFrom = syFrom;
    }

    public String getSyTo() {
        return syTo;
    }

    public void setSyTo(String syTo) {
        this.syTo = syTo;
    }

    public short getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(short reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Date getCutoffDate() {
        return cutoffDate;
    }

    public void setCutoffDate(Date cutoffDate) {
        this.cutoffDate = cutoffDate;
    }

    public Date getStartEncodingDate() {
        return startEncodingDate;
    }

    public void setStartEncodingDate(Date startEncodingDate) {
        this.startEncodingDate = startEncodingDate;
    }

    public Date getSchoolDeadline() {
        return schoolDeadline;
    }

    public void setSchoolDeadline(Date schoolDeadline) {
        this.schoolDeadline = schoolDeadline;
    }

    public Date getDivisionValidationDeadline() {
        return divisionValidationDeadline;
    }

    public void setDivisionValidationDeadline(Date divisionValidationDeadline) {
        this.divisionValidationDeadline = divisionValidationDeadline;
    }

    public Date getDivisionValidationExtended() {
        return divisionValidationExtended;
    }

    public void setDivisionValidationExtended(Date divisionValidationExtended) {
        this.divisionValidationExtended = divisionValidationExtended;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
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
        if (!(object instanceof RefReportHistory)) {
            return false;
        }
        RefReportHistory other = (RefReportHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.RefReportHistory[ id=" + id + " ]";
    }
    
}
