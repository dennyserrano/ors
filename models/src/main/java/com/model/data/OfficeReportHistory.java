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
@Table(name = "office_report_history", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"office_id", "ref_report_history_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OfficeReportHistory.findAll", query = "SELECT o FROM OfficeReportHistory o")})
public class OfficeReportHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "ref_report_history_id")
    private Short refReportHistoryId;
    @Basic(optional = false)
    @Column(name = "office_id", nullable = false)
    private int officeId;
    @Basic(optional = false)
    @Column(name = "report_status", nullable = false)
    private short reportStatus;
    @Column(name = "validated_by")
    private Integer validatedBy;
    @Column(name = "validation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validationDate;
    @Column(name = "revalidation_request_by")
    private Integer revalidationRequestBy;
    @Column(name = "revalidation_request_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date revalidationRequestDate;
    @Column(name = "revalidated_by")
    private Integer revalidatedBy;
    @Column(name = "revalidated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date revalidatedDate;
    @Column(name = "finalized_by")
    private Integer finalizedBy;
    @Column(name = "finalized_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalizedDate;
    @Column(name = "submitted_by")
    private Integer submittedBy;
    @Column(name = "submitted_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submittedDate;
    @Column(name = "resubmitted_by")
    private Integer resubmittedBy;
    @Column(name = "resubmitted_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resubmittedDate;

    public OfficeReportHistory() {
    }

    public OfficeReportHistory(Integer id) {
        this.id = id;
    }

    public OfficeReportHistory(Integer id, int officeId, short reportStatus) {
        this.id = id;
        this.officeId = officeId;
        this.reportStatus = reportStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getRefReportHistoryId() {
        return refReportHistoryId;
    }

    public void setRefReportHistoryId(Short refReportHistoryId) {
        this.refReportHistoryId = refReportHistoryId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public short getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(short reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Integer getValidatedBy() {
        return validatedBy;
    }

    public void setValidatedBy(Integer validatedBy) {
        this.validatedBy = validatedBy;
    }

    public Date getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(Date validationDate) {
        this.validationDate = validationDate;
    }

    public Integer getRevalidationRequestBy() {
        return revalidationRequestBy;
    }

    public void setRevalidationRequestBy(Integer revalidationRequestBy) {
        this.revalidationRequestBy = revalidationRequestBy;
    }

    public Date getRevalidationRequestDate() {
        return revalidationRequestDate;
    }

    public void setRevalidationRequestDate(Date revalidationRequestDate) {
        this.revalidationRequestDate = revalidationRequestDate;
    }

    public Integer getRevalidatedBy() {
        return revalidatedBy;
    }

    public void setRevalidatedBy(Integer revalidatedBy) {
        this.revalidatedBy = revalidatedBy;
    }

    public Date getRevalidatedDate() {
        return revalidatedDate;
    }

    public void setRevalidatedDate(Date revalidatedDate) {
        this.revalidatedDate = revalidatedDate;
    }

    public Integer getFinalizedBy() {
        return finalizedBy;
    }

    public void setFinalizedBy(Integer finalizedBy) {
        this.finalizedBy = finalizedBy;
    }

    public Date getFinalizedDate() {
        return finalizedDate;
    }

    public void setFinalizedDate(Date finalizedDate) {
        this.finalizedDate = finalizedDate;
    }

    public Integer getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(Integer submittedBy) {
        this.submittedBy = submittedBy;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public Integer getResubmittedBy() {
        return resubmittedBy;
    }

    public void setResubmittedBy(Integer resubmittedBy) {
        this.resubmittedBy = resubmittedBy;
    }

    public Date getResubmittedDate() {
        return resubmittedDate;
    }

    public void setResubmittedDate(Date resubmittedDate) {
        this.resubmittedDate = resubmittedDate;
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
        if (!(object instanceof OfficeReportHistory)) {
            return false;
        }
        OfficeReportHistory other = (OfficeReportHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.OfficeReportHistory[ id=" + id + " ]";
    }
    
}
