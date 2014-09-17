/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "report_history", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ref_report_history_id", "school_id", "report_id", "sy_from"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportHistory.findAll", query = "SELECT r FROM ReportHistory r")})
public class ReportHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
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
    @Column(name = "school_deadline")
    @Temporal(TemporalType.DATE)
    private Date schoolDeadline;
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
    @Column(name = "division_validation_deadline")
    @Temporal(TemporalType.DATE)
    private Date divisionValidationDeadline;
    @Column(name = "validated_by")
    private Integer validatedBy;
    @Column(name = "verified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date verifiedDate;
    @Column(name = "validation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validationDate;
    @Column(name = "validation_deadline_reverted")
    @Temporal(TemporalType.DATE)
    private Date validationDeadlineReverted;
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
    @Column(name = "sh_validated_by")
    private Short shValidatedBy;
    @Column(name = "sh_validated_date")
    @Temporal(TemporalType.DATE)
    private Date shValidatedDate;
    @Column(name = "school_profile_history_id")
    private Integer schoolProfileHistoryId;
    @Column(name = "reason_rooms", length = 500)
    private String reasonRooms;
    @Column(name = "reason_furnitures", length = 500)
    private String reasonFurnitures;
    @Column(name = "reason_nonteaching", length = 500)
    private String reasonNonteaching;
    @Column(name = "reason_teaching", length = 500)
    private String reasonTeaching;
    @Column(name = "reason_locallyfunded", length = 500)
    private String reasonLocallyfunded;
    @Column(name = "reason_eosy_enrollment", length = 500)
    private String reasonEosyEnrollment;
    @Column(name = "issue_flag")
    private Integer issueFlag;
    @OneToMany(mappedBy = "reportHistoryId")
    private List<SummerProgramSummary> summerProgramSummaryList;
    @OneToMany(mappedBy = "reportHistoryId")
    private List<EnrollmentAgeSummary> enrollmentAgeSummaryList;
    @OneToMany(mappedBy = "reportHistoryId")
    private List<EnrollmentProgramSummary> enrollmentProgramSummaryList;
    @OneToMany(mappedBy = "reportHistoryId")
    private List<PersonnelLocalfundSummary> personnelLocalfundSummaryList;
    @OneToMany(mappedBy = "reportHistoryId")
    private List<DisasterCalamities> disasterCalamitiesList;

    public ReportHistory() {
    }

    public ReportHistory(Integer id) {
        this.id = id;
    }

    public ReportHistory(Integer id, int schoolId, short reportId, Date reportDate, short reportStatus, int preparedBy) {
        this.id = id;
        this.schoolId = schoolId;
        this.reportId = reportId;
        this.reportDate = reportDate;
        this.reportStatus = reportStatus;
        this.preparedBy = preparedBy;
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

    public Date getSchoolDeadline() {
        return schoolDeadline;
    }

    public void setSchoolDeadline(Date schoolDeadline) {
        this.schoolDeadline = schoolDeadline;
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

    public Date getDivisionValidationDeadline() {
        return divisionValidationDeadline;
    }

    public void setDivisionValidationDeadline(Date divisionValidationDeadline) {
        this.divisionValidationDeadline = divisionValidationDeadline;
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

    public Date getValidationDeadlineReverted() {
        return validationDeadlineReverted;
    }

    public void setValidationDeadlineReverted(Date validationDeadlineReverted) {
        this.validationDeadlineReverted = validationDeadlineReverted;
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

    public Short getShValidatedBy() {
        return shValidatedBy;
    }

    public void setShValidatedBy(Short shValidatedBy) {
        this.shValidatedBy = shValidatedBy;
    }

    public Date getShValidatedDate() {
        return shValidatedDate;
    }

    public void setShValidatedDate(Date shValidatedDate) {
        this.shValidatedDate = shValidatedDate;
    }

    public Integer getSchoolProfileHistoryId() {
        return schoolProfileHistoryId;
    }

    public void setSchoolProfileHistoryId(Integer schoolProfileHistoryId) {
        this.schoolProfileHistoryId = schoolProfileHistoryId;
    }

    public String getReasonRooms() {
        return reasonRooms;
    }

    public void setReasonRooms(String reasonRooms) {
        this.reasonRooms = reasonRooms;
    }

    public String getReasonFurnitures() {
        return reasonFurnitures;
    }

    public void setReasonFurnitures(String reasonFurnitures) {
        this.reasonFurnitures = reasonFurnitures;
    }

    public String getReasonNonteaching() {
        return reasonNonteaching;
    }

    public void setReasonNonteaching(String reasonNonteaching) {
        this.reasonNonteaching = reasonNonteaching;
    }

    public String getReasonTeaching() {
        return reasonTeaching;
    }

    public void setReasonTeaching(String reasonTeaching) {
        this.reasonTeaching = reasonTeaching;
    }

    public String getReasonLocallyfunded() {
        return reasonLocallyfunded;
    }

    public void setReasonLocallyfunded(String reasonLocallyfunded) {
        this.reasonLocallyfunded = reasonLocallyfunded;
    }

    public String getReasonEosyEnrollment() {
        return reasonEosyEnrollment;
    }

    public void setReasonEosyEnrollment(String reasonEosyEnrollment) {
        this.reasonEosyEnrollment = reasonEosyEnrollment;
    }

    public Integer getIssueFlag() {
        return issueFlag;
    }

    public void setIssueFlag(Integer issueFlag) {
        this.issueFlag = issueFlag;
    }

    @XmlTransient
    public List<SummerProgramSummary> getSummerProgramSummaryList() {
        return summerProgramSummaryList;
    }

    public void setSummerProgramSummaryList(List<SummerProgramSummary> summerProgramSummaryList) {
        this.summerProgramSummaryList = summerProgramSummaryList;
    }

    @XmlTransient
    public List<EnrollmentAgeSummary> getEnrollmentAgeSummaryList() {
        return enrollmentAgeSummaryList;
    }

    public void setEnrollmentAgeSummaryList(List<EnrollmentAgeSummary> enrollmentAgeSummaryList) {
        this.enrollmentAgeSummaryList = enrollmentAgeSummaryList;
    }

    @XmlTransient
    public List<EnrollmentProgramSummary> getEnrollmentProgramSummaryList() {
        return enrollmentProgramSummaryList;
    }

    public void setEnrollmentProgramSummaryList(List<EnrollmentProgramSummary> enrollmentProgramSummaryList) {
        this.enrollmentProgramSummaryList = enrollmentProgramSummaryList;
    }

    @XmlTransient
    public List<PersonnelLocalfundSummary> getPersonnelLocalfundSummaryList() {
        return personnelLocalfundSummaryList;
    }

    public void setPersonnelLocalfundSummaryList(List<PersonnelLocalfundSummary> personnelLocalfundSummaryList) {
        this.personnelLocalfundSummaryList = personnelLocalfundSummaryList;
    }

    @XmlTransient
    public List<DisasterCalamities> getDisasterCalamitiesList() {
        return disasterCalamitiesList;
    }

    public void setDisasterCalamitiesList(List<DisasterCalamities> disasterCalamitiesList) {
        this.disasterCalamitiesList = disasterCalamitiesList;
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
        if (!(object instanceof ReportHistory)) {
            return false;
        }
        ReportHistory other = (ReportHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.ReportHistory[ id=" + id + " ]";
    }
    
}
