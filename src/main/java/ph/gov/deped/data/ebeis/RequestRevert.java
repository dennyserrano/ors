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
@Table(name = "request_revert", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestRevert.findAll", query = "SELECT r FROM RequestRevert r")})
public class RequestRevert implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "requested_by", nullable = false)
    private int requestedBy;
    @Basic(optional = false)
    @Column(name = "date_requested", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRequested;
    @Column(name = "requesting_office_id")
    private Integer requestingOfficeId;
    @Column(name = "requesting_school_id")
    private Integer requestingSchoolId;
    @Basic(optional = false)
    @Column(name = "reason_id", nullable = false)
    private int reasonId;
    @Column(length = 2000)
    private String explanation;
    @Basic(optional = false)
    @Column(name = "ref_report_history_id", nullable = false)
    private int refReportHistoryId;
    @Basic(optional = false)
    @Column(name = "area_to_revert", nullable = false)
    private int areaToRevert;
    @Basic(optional = false)
    @Column(name = "district_id", nullable = false)
    private int districtId;
    @Basic(optional = false)
    @Column(name = "from_status", nullable = false)
    private int fromStatus;
    @Basic(optional = false)
    @Column(name = "to_status", nullable = false)
    private int toStatus;
    private Short approved;
    @Column(name = "approved_by")
    private Integer approvedBy;
    @Column(name = "date_approved")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateApproved;
    @Column(name = "approval_comment", length = 2000)
    private String approvalComment;
    @Column(name = "approving_office")
    private Integer approvingOffice;
    @Column(name = "emailed_to", length = 2000)
    private String emailedTo;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "created_by", nullable = false)
    private int createdBy;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "updated_by", nullable = false)
    private int updatedBy;

    public RequestRevert() {
    }

    public RequestRevert(Integer id) {
        this.id = id;
    }

    public RequestRevert(Integer id, int requestedBy, Date dateRequested, int reasonId, int refReportHistoryId, int areaToRevert, int districtId, int fromStatus, int toStatus, int createdBy, int updatedBy) {
        this.id = id;
        this.requestedBy = requestedBy;
        this.dateRequested = dateRequested;
        this.reasonId = reasonId;
        this.refReportHistoryId = refReportHistoryId;
        this.areaToRevert = areaToRevert;
        this.districtId = districtId;
        this.fromStatus = fromStatus;
        this.toStatus = toStatus;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(int requestedBy) {
        this.requestedBy = requestedBy;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }

    public Integer getRequestingOfficeId() {
        return requestingOfficeId;
    }

    public void setRequestingOfficeId(Integer requestingOfficeId) {
        this.requestingOfficeId = requestingOfficeId;
    }

    public Integer getRequestingSchoolId() {
        return requestingSchoolId;
    }

    public void setRequestingSchoolId(Integer requestingSchoolId) {
        this.requestingSchoolId = requestingSchoolId;
    }

    public int getReasonId() {
        return reasonId;
    }

    public void setReasonId(int reasonId) {
        this.reasonId = reasonId;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getRefReportHistoryId() {
        return refReportHistoryId;
    }

    public void setRefReportHistoryId(int refReportHistoryId) {
        this.refReportHistoryId = refReportHistoryId;
    }

    public int getAreaToRevert() {
        return areaToRevert;
    }

    public void setAreaToRevert(int areaToRevert) {
        this.areaToRevert = areaToRevert;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getFromStatus() {
        return fromStatus;
    }

    public void setFromStatus(int fromStatus) {
        this.fromStatus = fromStatus;
    }

    public int getToStatus() {
        return toStatus;
    }

    public void setToStatus(int toStatus) {
        this.toStatus = toStatus;
    }

    public Short getApproved() {
        return approved;
    }

    public void setApproved(Short approved) {
        this.approved = approved;
    }

    public Integer getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Integer approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }

    public String getApprovalComment() {
        return approvalComment;
    }

    public void setApprovalComment(String approvalComment) {
        this.approvalComment = approvalComment;
    }

    public Integer getApprovingOffice() {
        return approvingOffice;
    }

    public void setApprovingOffice(Integer approvingOffice) {
        this.approvingOffice = approvingOffice;
    }

    public String getEmailedTo() {
        return emailedTo;
    }

    public void setEmailedTo(String emailedTo) {
        this.emailedTo = emailedTo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
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
        if (!(object instanceof RequestRevert)) {
            return false;
        }
        RequestRevert other = (RequestRevert) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.RequestRevert[ id=" + id + " ]";
    }
    
}
