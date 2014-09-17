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
@Table(name = "report_history_journal", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportHistoryJournal.findAll", query = "SELECT r FROM ReportHistoryJournal r")})
public class ReportHistoryJournal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "original_id", nullable = false)
    private int originalId;
    @Column(name = "ref_report_history_id")
    private Short refReportHistoryId;
    @Basic(optional = false)
    @Column(name = "school_id", nullable = false)
    private int schoolId;
    @Basic(optional = false)
    @Column(name = "report_id", nullable = false)
    private short reportId;
    @Column(name = "division_id")
    private Short divisionId;
    @Column(name = "region_id")
    private Short regionId;
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
    @Column(name = "prepared_by", nullable = false)
    private int preparedBy;
    @Column(name = "prepared_date")
    @Temporal(TemporalType.DATE)
    private Date preparedDate;
    @Column(name = "certified_by")
    private Integer certifiedBy;
    @Column(name = "certified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date certifiedDate;
    @Column(name = "checked_by")
    private Integer checkedBy;
    @Column(name = "checked_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkedDate;
    @Column(name = "verified_by")
    private Integer verifiedBy;
    @Column(name = "submitted_by")
    private Integer submittedBy;
    @Column(name = "submitted_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submittedDate;
    @Column(name = "validated_by")
    private Integer validatedBy;
    @Column(name = "verified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date verifiedDate;
    @Column(name = "validation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validationDate;
    @Column(name = "revalidated_by")
    private Integer revalidatedBy;
    @Column(name = "revalidated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date revalidatedDate;
    @Column(name = "revalidation_request_by")
    private Integer revalidationRequestBy;
    @Column(name = "revalidation_request_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date revalidationRequestDate;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "created_by")
    private Integer createdBy;

    public ReportHistoryJournal() {
    }

    public ReportHistoryJournal(Integer id) {
        this.id = id;
    }

    public ReportHistoryJournal(Integer id, int originalId, int schoolId, short reportId, Date reportDate, short reportStatus, int preparedBy, Date createdAt) {
        this.id = id;
        this.originalId = originalId;
        this.schoolId = schoolId;
        this.reportId = reportId;
        this.reportDate = reportDate;
        this.reportStatus = reportStatus;
        this.preparedBy = preparedBy;
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

    public Short getRefReportHistoryId() {
        return refReportHistoryId;
    }

    public void setRefReportHistoryId(Short refReportHistoryId) {
        this.refReportHistoryId = refReportHistoryId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public short getReportId() {
        return reportId;
    }

    public void setReportId(short reportId) {
        this.reportId = reportId;
    }

    public Short getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Short divisionId) {
        this.divisionId = divisionId;
    }

    public Short getRegionId() {
        return regionId;
    }

    public void setRegionId(Short regionId) {
        this.regionId = regionId;
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

    public int getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(int preparedBy) {
        this.preparedBy = preparedBy;
    }

    public Date getPreparedDate() {
        return preparedDate;
    }

    public void setPreparedDate(Date preparedDate) {
        this.preparedDate = preparedDate;
    }

    public Integer getCertifiedBy() {
        return certifiedBy;
    }

    public void setCertifiedBy(Integer certifiedBy) {
        this.certifiedBy = certifiedBy;
    }

    public Date getCertifiedDate() {
        return certifiedDate;
    }

    public void setCertifiedDate(Date certifiedDate) {
        this.certifiedDate = certifiedDate;
    }

    public Integer getCheckedBy() {
        return checkedBy;
    }

    public void setCheckedBy(Integer checkedBy) {
        this.checkedBy = checkedBy;
    }

    public Date getCheckedDate() {
        return checkedDate;
    }

    public void setCheckedDate(Date checkedDate) {
        this.checkedDate = checkedDate;
    }

    public Integer getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(Integer verifiedBy) {
        this.verifiedBy = verifiedBy;
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

    public Integer getValidatedBy() {
        return validatedBy;
    }

    public void setValidatedBy(Integer validatedBy) {
        this.validatedBy = validatedBy;
    }

    public Date getVerifiedDate() {
        return verifiedDate;
    }

    public void setVerifiedDate(Date verifiedDate) {
        this.verifiedDate = verifiedDate;
    }

    public Date getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(Date validationDate) {
        this.validationDate = validationDate;
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
        if (!(object instanceof ReportHistoryJournal)) {
            return false;
        }
        ReportHistoryJournal other = (ReportHistoryJournal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.ReportHistoryJournal[ id=" + id + " ]";
    }
    
}
