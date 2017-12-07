/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "learner_registry_hk", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"lrn"}),
    @UniqueConstraint(columnNames = {"first_name", "middle_name", "last_name", "gender", "birthdate", "duplicate_arbiter"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LearnerRegistryHk.findAll", query = "SELECT l FROM LearnerRegistryHk l")})
public class LearnerRegistryHk implements Serializable {
    private static final long serialVersionUID = 1L;
    private BigInteger lrn;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;
    @Column(name = "middle_name", length = 100)
    private String middleName;
    @Column(name = "last_name", length = 100)
    private String lastName;
    @Column(name = "extension_name", length = 20)
    private String extensionName;
    @Column(length = 500)
    private String remarks;
    @Basic(optional = false)
    @Column(nullable = false)
    private short gender;
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(length = 250)
    private String nobirthdateReason;
    @Column(name = "street_address", length = 255)
    private String streetAddress;
    @Column(length = 100)
    private String residenceBarangay;
    @Column(name = "ref_barangay_id")
    private Integer refBarangayId;
    @Column(length = 100)
    private String residenceMunicipality;
    @Column(name = "ref_municipality_id")
    private Integer refMunicipalityId;
    @Column(length = 100)
    private String guardian;
    @Column(name = "guardian_first_name", length = 50)
    private String guardianFirstName;
    @Column(name = "guardian_last_name", length = 50)
    private String guardianLastName;
    @Column(name = "guardian_middle_name", length = 50)
    private String guardianMiddleName;
    @Column(name = "guardian_relationship", length = 100)
    private String guardianRelationship;
    @Column(name = "guardian_relation_id")
    private Short guardianRelationId;
    @Column(name = "mother_maiden_name", length = 50)
    private String motherMaidenName;
    @Column(name = "ethnicity_id")
    private Short ethnicityId;
    @Column(name = "dialect_id")
    private Short dialectId;
    @Column(name = "religion_id")
    private Short religionId;
    @Column(name = "father_first_name", length = 50)
    private String fatherFirstName;
    @Column(name = "father_middle_name", length = 50)
    private String fatherMiddleName;
    @Column(name = "father_last_name", length = 50)
    private String fatherLastName;
    @Column(name = "father_extension_name", length = 20)
    private String fatherExtensionName;
    private Short deactivated;
    @Column(name = "created_by")
    private Integer createdBy;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_by")
    private Integer updatedBy;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Temporal(TemporalType.DATE)
    private Date birhtdate2;
    @Column(name = "dialect_id2")
    private Short dialectId2;
    @Column(name = "dialect_id3")
    private Short dialectId3;
    @Column(name = "ethnicity_id2")
    private Short ethnicityId2;
    @Column(name = "ethnicity_id3")
    private Short ethnicityId3;
    @Column(name = "duplicate_arbiter")
    private Short duplicateArbiter;
    @OneToMany(mappedBy = "learnerRegistryId")
    private List<Enold> enoldList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lrn")
    private List<Enold> enoldList1;
    @OneToMany(mappedBy = "learnerRegistryId")
    private List<Enrolment> enrolmentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lrn")
    private List<Enrolment> enrolmentList1;

    public LearnerRegistryHk() {
    }

    public LearnerRegistryHk(Integer id) {
        this.id = id;
    }

    public LearnerRegistryHk(Integer id, String firstName, short gender, Date createdAt, Date updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.gender = gender;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public BigInteger getLrn() {
        return lrn;
    }

    public void setLrn(BigInteger lrn) {
        this.lrn = lrn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExtensionName() {
        return extensionName;
    }

    public void setExtensionName(String extensionName) {
        this.extensionName = extensionName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public short getGender() {
        return gender;
    }

    public void setGender(short gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getNobirthdateReason() {
        return nobirthdateReason;
    }

    public void setNobirthdateReason(String nobirthdateReason) {
        this.nobirthdateReason = nobirthdateReason;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getResidenceBarangay() {
        return residenceBarangay;
    }

    public void setResidenceBarangay(String residenceBarangay) {
        this.residenceBarangay = residenceBarangay;
    }

    public Integer getRefBarangayId() {
        return refBarangayId;
    }

    public void setRefBarangayId(Integer refBarangayId) {
        this.refBarangayId = refBarangayId;
    }

    public String getResidenceMunicipality() {
        return residenceMunicipality;
    }

    public void setResidenceMunicipality(String residenceMunicipality) {
        this.residenceMunicipality = residenceMunicipality;
    }

    public Integer getRefMunicipalityId() {
        return refMunicipalityId;
    }

    public void setRefMunicipalityId(Integer refMunicipalityId) {
        this.refMunicipalityId = refMunicipalityId;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    public String getGuardianFirstName() {
        return guardianFirstName;
    }

    public void setGuardianFirstName(String guardianFirstName) {
        this.guardianFirstName = guardianFirstName;
    }

    public String getGuardianLastName() {
        return guardianLastName;
    }

    public void setGuardianLastName(String guardianLastName) {
        this.guardianLastName = guardianLastName;
    }

    public String getGuardianMiddleName() {
        return guardianMiddleName;
    }

    public void setGuardianMiddleName(String guardianMiddleName) {
        this.guardianMiddleName = guardianMiddleName;
    }

    public String getGuardianRelationship() {
        return guardianRelationship;
    }

    public void setGuardianRelationship(String guardianRelationship) {
        this.guardianRelationship = guardianRelationship;
    }

    public Short getGuardianRelationId() {
        return guardianRelationId;
    }

    public void setGuardianRelationId(Short guardianRelationId) {
        this.guardianRelationId = guardianRelationId;
    }

    public String getMotherMaidenName() {
        return motherMaidenName;
    }

    public void setMotherMaidenName(String motherMaidenName) {
        this.motherMaidenName = motherMaidenName;
    }

    public Short getEthnicityId() {
        return ethnicityId;
    }

    public void setEthnicityId(Short ethnicityId) {
        this.ethnicityId = ethnicityId;
    }

    public Short getDialectId() {
        return dialectId;
    }

    public void setDialectId(Short dialectId) {
        this.dialectId = dialectId;
    }

    public Short getReligionId() {
        return religionId;
    }

    public void setReligionId(Short religionId) {
        this.religionId = religionId;
    }

    public String getFatherFirstName() {
        return fatherFirstName;
    }

    public void setFatherFirstName(String fatherFirstName) {
        this.fatherFirstName = fatherFirstName;
    }

    public String getFatherMiddleName() {
        return fatherMiddleName;
    }

    public void setFatherMiddleName(String fatherMiddleName) {
        this.fatherMiddleName = fatherMiddleName;
    }

    public String getFatherLastName() {
        return fatherLastName;
    }

    public void setFatherLastName(String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }

    public String getFatherExtensionName() {
        return fatherExtensionName;
    }

    public void setFatherExtensionName(String fatherExtensionName) {
        this.fatherExtensionName = fatherExtensionName;
    }

    public Short getDeactivated() {
        return deactivated;
    }

    public void setDeactivated(Short deactivated) {
        this.deactivated = deactivated;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getBirhtdate2() {
        return birhtdate2;
    }

    public void setBirhtdate2(Date birhtdate2) {
        this.birhtdate2 = birhtdate2;
    }

    public Short getDialectId2() {
        return dialectId2;
    }

    public void setDialectId2(Short dialectId2) {
        this.dialectId2 = dialectId2;
    }

    public Short getDialectId3() {
        return dialectId3;
    }

    public void setDialectId3(Short dialectId3) {
        this.dialectId3 = dialectId3;
    }

    public Short getEthnicityId2() {
        return ethnicityId2;
    }

    public void setEthnicityId2(Short ethnicityId2) {
        this.ethnicityId2 = ethnicityId2;
    }

    public Short getEthnicityId3() {
        return ethnicityId3;
    }

    public void setEthnicityId3(Short ethnicityId3) {
        this.ethnicityId3 = ethnicityId3;
    }

    public Short getDuplicateArbiter() {
        return duplicateArbiter;
    }

    public void setDuplicateArbiter(Short duplicateArbiter) {
        this.duplicateArbiter = duplicateArbiter;
    }

    @XmlTransient
    public List<Enold> getEnoldList() {
        return enoldList;
    }

    public void setEnoldList(List<Enold> enoldList) {
        this.enoldList = enoldList;
    }

    @XmlTransient
    public List<Enold> getEnoldList1() {
        return enoldList1;
    }

    public void setEnoldList1(List<Enold> enoldList1) {
        this.enoldList1 = enoldList1;
    }

    @XmlTransient
    public List<Enrolment> getEnrolmentList() {
        return enrolmentList;
    }

    public void setEnrolmentList(List<Enrolment> enrolmentList) {
        this.enrolmentList = enrolmentList;
    }

    @XmlTransient
    public List<Enrolment> getEnrolmentList1() {
        return enrolmentList1;
    }

    public void setEnrolmentList1(List<Enrolment> enrolmentList1) {
        this.enrolmentList1 = enrolmentList1;
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
        if (!(object instanceof LearnerRegistryHk)) {
            return false;
        }
        LearnerRegistryHk other = (LearnerRegistryHk) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.LearnerRegistryHk[ id=" + id + " ]";
    }
    
}
