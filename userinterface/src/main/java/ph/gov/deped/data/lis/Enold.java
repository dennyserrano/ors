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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enold.findAll", query = "SELECT e FROM Enold e")})
public class Enold implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "class_adviser_id")
    private Integer classAdviserId;
    @Basic(optional = false)
    @Column(nullable = false)
    private short sy;
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
    @Column(name = "clc_facilitator_sp_id")
    private Integer clcFacilitatorSpId;
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
    private Short override;
    @Basic(optional = false)
    @Column(nullable = false)
    private short repeater;
    @Basic(optional = false)
    @Column(name = "grade1_ecd", nullable = false)
    private short grade1Ecd;
    @Basic(optional = false)
    @Column(name = "balik_aral", nullable = false)
    private short balikAral;
    @Basic(optional = false)
    @Column(nullable = false)
    private short muslim;
    @Basic(optional = false)
    @Column(name = "alive_enrolled", nullable = false)
    private short aliveEnrolled;
    @Basic(optional = false)
    @Column(name = "gifted_talented", nullable = false)
    private short giftedTalented;
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
    @Column(name = "duplicate_arbiter")
    private Short duplicateArbiter;
    @JoinColumn(name = "learner_registry_id", referencedColumnName = "id")
    @ManyToOne
    private LearnerRegistryHk learnerRegistryId;
    @JoinColumn(name = "lrn", referencedColumnName = "lrn", nullable = false)
    @ManyToOne(optional = false)
    private LearnerRegistryHk lrn;
    @JoinColumn(name = "school_class_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SchoolClassHk schoolClassId;

    public Enold() {
    }

    public Enold(Integer id) {
        this.id = id;
    }

    public Enold(Integer id, short sy, short enrolType, Date firstLoginDt, short repeater, short grade1Ecd, short balikAral, short muslim, short aliveEnrolled, short giftedTalented, Date updatedAt) {
        this.id = id;
        this.sy = sy;
        this.enrolType = enrolType;
        this.firstLoginDt = firstLoginDt;
        this.repeater = repeater;
        this.grade1Ecd = grade1Ecd;
        this.balikAral = balikAral;
        this.muslim = muslim;
        this.aliveEnrolled = aliveEnrolled;
        this.giftedTalented = giftedTalented;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getClcFacilitatorSpId() {
        return clcFacilitatorSpId;
    }

    public void setClcFacilitatorSpId(Integer clcFacilitatorSpId) {
        this.clcFacilitatorSpId = clcFacilitatorSpId;
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

    public Short getOverride() {
        return override;
    }

    public void setOverride(Short override) {
        this.override = override;
    }

    public short getRepeater() {
        return repeater;
    }

    public void setRepeater(short repeater) {
        this.repeater = repeater;
    }

    public short getGrade1Ecd() {
        return grade1Ecd;
    }

    public void setGrade1Ecd(short grade1Ecd) {
        this.grade1Ecd = grade1Ecd;
    }

    public short getBalikAral() {
        return balikAral;
    }

    public void setBalikAral(short balikAral) {
        this.balikAral = balikAral;
    }

    public short getMuslim() {
        return muslim;
    }

    public void setMuslim(short muslim) {
        this.muslim = muslim;
    }

    public short getAliveEnrolled() {
        return aliveEnrolled;
    }

    public void setAliveEnrolled(short aliveEnrolled) {
        this.aliveEnrolled = aliveEnrolled;
    }

    public short getGiftedTalented() {
        return giftedTalented;
    }

    public void setGiftedTalented(short giftedTalented) {
        this.giftedTalented = giftedTalented;
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

    public Short getDuplicateArbiter() {
        return duplicateArbiter;
    }

    public void setDuplicateArbiter(Short duplicateArbiter) {
        this.duplicateArbiter = duplicateArbiter;
    }

    public LearnerRegistryHk getLearnerRegistryId() {
        return learnerRegistryId;
    }

    public void setLearnerRegistryId(LearnerRegistryHk learnerRegistryId) {
        this.learnerRegistryId = learnerRegistryId;
    }

    public LearnerRegistryHk getLrn() {
        return lrn;
    }

    public void setLrn(LearnerRegistryHk lrn) {
        this.lrn = lrn;
    }

    public SchoolClassHk getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(SchoolClassHk schoolClassId) {
        this.schoolClassId = schoolClassId;
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
        if (!(object instanceof Enold)) {
            return false;
        }
        Enold other = (Enold) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.Enold[ id=" + id + " ]";
    }
    
}
