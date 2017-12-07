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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "enrolment_journal", catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnrolmentJournal.findAll", query = "SELECT e FROM EnrolmentJournal e")})
public class EnrolmentJournal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "tran_type_id", nullable = false)
    private short tranTypeId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "enrolment_id", nullable = false)
    private int enrolmentId;
    @Column(name = "learner_registry_id")
    private Integer learnerRegistryId;
    @Column(name = "class_adviser_id")
    private Integer classAdviserId;
    @Basic(optional = false)
    @Column(nullable = false)
    private short sy;
    @Basic(optional = false)
    @Column(nullable = false)
    private long lrn;
    private Integer regid;
    private Integer divid;
    private Integer schid;
    @Column(name = "ref_grade_id")
    private Short refGradeId;
    @Column(length = 50)
    private String section;
    @Basic(optional = false)
    @Column(name = "enrol_type", nullable = false)
    private short enrolType;
    @Column(length = 100)
    private String lcMunicipality;
    @Column(length = 100)
    private String lcBarangay;
    @Column(length = 100)
    private String lcFacilitator;
    private Integer highestEducation;
    private Integer alsProgid;
    private Integer alsDeliveryid;
    @Column(name = "status_id")
    private Integer statusId;
    @Column(name = "als_facilitator_id")
    private Integer alsFacilitatorId;
    @Column(name = "als_clc_type_id")
    private Short alsClcTypeId;
    @Column(name = "created_at")
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
    @Column(name = "learner_registry_id1")
    private Integer learnerRegistryId1;
    @Column(name = "clc_facilitator_sp_id")
    private Integer clcFacilitatorSpId;
    @Basic(optional = false)
    @Column(name = "school_class_id", nullable = false)
    private int schoolClassId;
    @Basic(optional = false)
    @Column(name = "first_login_dt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstLoginDt;
    @Column(name = "AE_Test_Registrant")
    private Boolean aETestRegistrant;
    @Column(name = "AE_Test_Level_Taken")
    private Boolean aETestLevelTaken;
    @Column(name = "AE_Test_Result")
    private Boolean aETestResult;
    @Column(name = "ACL")
    private Boolean acl;
    @Column(name = "ACL_Number", length = 30)
    private String aCLNumber;
    @Column(name = "ACL_Date")
    @Temporal(TemporalType.DATE)
    private Date aCLDate;
    @Column(name = "CCT_recepient")
    private Boolean cCTrecepient;
    @Column(name = "trans_out")
    private Boolean transOut;
    @Column(name = "trans_in")
    private Boolean transIn;
    @Column(name = "trans_out_date")
    @Temporal(TemporalType.DATE)
    private Date transOutDate;
    @Column(name = "trans_in_date")
    @Temporal(TemporalType.DATE)
    private Date transInDate;
    private Boolean dropped;
    @Column(name = "dropped_date")
    @Temporal(TemporalType.DATE)
    private Date droppedDate;
    @Column(name = "enrol_date")
    @Temporal(TemporalType.DATE)
    private Date enrolDate;
    @Column(name = "dropped_reason_id")
    private Short droppedReasonId;
    @Basic(optional = false)
    @Column(name = "tran_by", nullable = false)
    private int tranBy;
    @Basic(optional = false)
    @Column(name = "tran_dt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tranDt;

    public EnrolmentJournal() {
    }

    public EnrolmentJournal(Integer id) {
        this.id = id;
    }

    public EnrolmentJournal(Integer id, short tranTypeId, int enrolmentId, short sy, long lrn, short enrolType, Date updatedAt, int schoolClassId, Date firstLoginDt, int tranBy, Date tranDt) {
        this.id = id;
        this.tranTypeId = tranTypeId;
        this.enrolmentId = enrolmentId;
        this.sy = sy;
        this.lrn = lrn;
        this.enrolType = enrolType;
        this.updatedAt = updatedAt;
        this.schoolClassId = schoolClassId;
        this.firstLoginDt = firstLoginDt;
        this.tranBy = tranBy;
        this.tranDt = tranDt;
    }

    public short getTranTypeId() {
        return tranTypeId;
    }

    public void setTranTypeId(short tranTypeId) {
        this.tranTypeId = tranTypeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEnrolmentId() {
        return enrolmentId;
    }

    public void setEnrolmentId(int enrolmentId) {
        this.enrolmentId = enrolmentId;
    }

    public Integer getLearnerRegistryId() {
        return learnerRegistryId;
    }

    public void setLearnerRegistryId(Integer learnerRegistryId) {
        this.learnerRegistryId = learnerRegistryId;
    }

    public Integer getClassAdviserId() {
        return classAdviserId;
    }

    public void setClassAdviserId(Integer classAdviserId) {
        this.classAdviserId = classAdviserId;
    }

    public short getSy() {
        return sy;
    }

    public void setSy(short sy) {
        this.sy = sy;
    }

    public long getLrn() {
        return lrn;
    }

    public void setLrn(long lrn) {
        this.lrn = lrn;
    }

    public Integer getRegid() {
        return regid;
    }

    public void setRegid(Integer regid) {
        this.regid = regid;
    }

    public Integer getDivid() {
        return divid;
    }

    public void setDivid(Integer divid) {
        this.divid = divid;
    }

    public Integer getSchid() {
        return schid;
    }

    public void setSchid(Integer schid) {
        this.schid = schid;
    }

    public Short getRefGradeId() {
        return refGradeId;
    }

    public void setRefGradeId(Short refGradeId) {
        this.refGradeId = refGradeId;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public short getEnrolType() {
        return enrolType;
    }

    public void setEnrolType(short enrolType) {
        this.enrolType = enrolType;
    }

    public String getLcMunicipality() {
        return lcMunicipality;
    }

    public void setLcMunicipality(String lcMunicipality) {
        this.lcMunicipality = lcMunicipality;
    }

    public String getLcBarangay() {
        return lcBarangay;
    }

    public void setLcBarangay(String lcBarangay) {
        this.lcBarangay = lcBarangay;
    }

    public String getLcFacilitator() {
        return lcFacilitator;
    }

    public void setLcFacilitator(String lcFacilitator) {
        this.lcFacilitator = lcFacilitator;
    }

    public Integer getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(Integer highestEducation) {
        this.highestEducation = highestEducation;
    }

    public Integer getAlsProgid() {
        return alsProgid;
    }

    public void setAlsProgid(Integer alsProgid) {
        this.alsProgid = alsProgid;
    }

    public Integer getAlsDeliveryid() {
        return alsDeliveryid;
    }

    public void setAlsDeliveryid(Integer alsDeliveryid) {
        this.alsDeliveryid = alsDeliveryid;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getAlsFacilitatorId() {
        return alsFacilitatorId;
    }

    public void setAlsFacilitatorId(Integer alsFacilitatorId) {
        this.alsFacilitatorId = alsFacilitatorId;
    }

    public Short getAlsClcTypeId() {
        return alsClcTypeId;
    }

    public void setAlsClcTypeId(Short alsClcTypeId) {
        this.alsClcTypeId = alsClcTypeId;
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

    public Integer getLearnerRegistryId1() {
        return learnerRegistryId1;
    }

    public void setLearnerRegistryId1(Integer learnerRegistryId1) {
        this.learnerRegistryId1 = learnerRegistryId1;
    }

    public Integer getClcFacilitatorSpId() {
        return clcFacilitatorSpId;
    }

    public void setClcFacilitatorSpId(Integer clcFacilitatorSpId) {
        this.clcFacilitatorSpId = clcFacilitatorSpId;
    }

    public int getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(int schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

    public Date getFirstLoginDt() {
        return firstLoginDt;
    }

    public void setFirstLoginDt(Date firstLoginDt) {
        this.firstLoginDt = firstLoginDt;
    }

    public Boolean getAETestRegistrant() {
        return aETestRegistrant;
    }

    public void setAETestRegistrant(Boolean aETestRegistrant) {
        this.aETestRegistrant = aETestRegistrant;
    }

    public Boolean getAETestLevelTaken() {
        return aETestLevelTaken;
    }

    public void setAETestLevelTaken(Boolean aETestLevelTaken) {
        this.aETestLevelTaken = aETestLevelTaken;
    }

    public Boolean getAETestResult() {
        return aETestResult;
    }

    public void setAETestResult(Boolean aETestResult) {
        this.aETestResult = aETestResult;
    }

    public Boolean getAcl() {
        return acl;
    }

    public void setAcl(Boolean acl) {
        this.acl = acl;
    }

    public String getACLNumber() {
        return aCLNumber;
    }

    public void setACLNumber(String aCLNumber) {
        this.aCLNumber = aCLNumber;
    }

    public Date getACLDate() {
        return aCLDate;
    }

    public void setACLDate(Date aCLDate) {
        this.aCLDate = aCLDate;
    }

    public Boolean getCCTrecepient() {
        return cCTrecepient;
    }

    public void setCCTrecepient(Boolean cCTrecepient) {
        this.cCTrecepient = cCTrecepient;
    }

    public Boolean getTransOut() {
        return transOut;
    }

    public void setTransOut(Boolean transOut) {
        this.transOut = transOut;
    }

    public Boolean getTransIn() {
        return transIn;
    }

    public void setTransIn(Boolean transIn) {
        this.transIn = transIn;
    }

    public Date getTransOutDate() {
        return transOutDate;
    }

    public void setTransOutDate(Date transOutDate) {
        this.transOutDate = transOutDate;
    }

    public Date getTransInDate() {
        return transInDate;
    }

    public void setTransInDate(Date transInDate) {
        this.transInDate = transInDate;
    }

    public Boolean getDropped() {
        return dropped;
    }

    public void setDropped(Boolean dropped) {
        this.dropped = dropped;
    }

    public Date getDroppedDate() {
        return droppedDate;
    }

    public void setDroppedDate(Date droppedDate) {
        this.droppedDate = droppedDate;
    }

    public Date getEnrolDate() {
        return enrolDate;
    }

    public void setEnrolDate(Date enrolDate) {
        this.enrolDate = enrolDate;
    }

    public Short getDroppedReasonId() {
        return droppedReasonId;
    }

    public void setDroppedReasonId(Short droppedReasonId) {
        this.droppedReasonId = droppedReasonId;
    }

    public int getTranBy() {
        return tranBy;
    }

    public void setTranBy(int tranBy) {
        this.tranBy = tranBy;
    }

    public Date getTranDt() {
        return tranDt;
    }

    public void setTranDt(Date tranDt) {
        this.tranDt = tranDt;
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
        if (!(object instanceof EnrolmentJournal)) {
            return false;
        }
        EnrolmentJournal other = (EnrolmentJournal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.EnrolmentJournal[ id=" + id + " ]";
    }
    
}
