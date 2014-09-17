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
@Table(name = "personnel_hk", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonnelHk.findAll", query = "SELECT p FROM PersonnelHk p")})
public class PersonnelHk implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "first_name", nullable = false, length = 60)
    private String firstName;
    @Basic(optional = false)
    @Column(name = "middle_name", nullable = false, length = 60)
    private String middleName;
    @Basic(optional = false)
    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;
    @Column(name = "ext_name", length = 45)
    private String extName;
    private Short gender;
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Column(name = "deped_emal", length = 45)
    private String depedEmal;
    @Column(name = "alternate_email", length = 45)
    private String alternateEmail;
    @Column(name = "gsisbp_no", length = 45)
    private String gsisbpNo;
    @Column(length = 45)
    private String tin;
    @Column(name = "plantilla_item_no", length = 45)
    private String plantillaItemNo;
    @Column(name = "position_id")
    private Short positionId;
    @Column(name = "employment_type")
    private Integer employmentType;
    @Column(name = "office_id")
    private Integer officeId;
    @Column(name = "school_id")
    private Integer schoolId;
    @Column(name = "gogle_verified_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gogleVerifiedDt;
    @Column(name = "pds_verified_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pdsVerifiedDt;
    @Column(name = "school_head_verified_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date schoolHeadVerifiedDt;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "updated_by")
    private Integer updatedBy;
    @Column(name = "sf_guard_user_id")
    private Integer sfGuardUserId;

    public PersonnelHk() {
    }

    public PersonnelHk(Integer id) {
        this.id = id;
    }

    public PersonnelHk(Integer id, String firstName, String middleName, String lastName, Date createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.createdAt = createdAt;
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

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getDepedEmal() {
        return depedEmal;
    }

    public void setDepedEmal(String depedEmal) {
        this.depedEmal = depedEmal;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public String getGsisbpNo() {
        return gsisbpNo;
    }

    public void setGsisbpNo(String gsisbpNo) {
        this.gsisbpNo = gsisbpNo;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getPlantillaItemNo() {
        return plantillaItemNo;
    }

    public void setPlantillaItemNo(String plantillaItemNo) {
        this.plantillaItemNo = plantillaItemNo;
    }

    public Short getPositionId() {
        return positionId;
    }

    public void setPositionId(Short positionId) {
        this.positionId = positionId;
    }

    public Integer getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(Integer employmentType) {
        this.employmentType = employmentType;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Date getGogleVerifiedDt() {
        return gogleVerifiedDt;
    }

    public void setGogleVerifiedDt(Date gogleVerifiedDt) {
        this.gogleVerifiedDt = gogleVerifiedDt;
    }

    public Date getPdsVerifiedDt() {
        return pdsVerifiedDt;
    }

    public void setPdsVerifiedDt(Date pdsVerifiedDt) {
        this.pdsVerifiedDt = pdsVerifiedDt;
    }

    public Date getSchoolHeadVerifiedDt() {
        return schoolHeadVerifiedDt;
    }

    public void setSchoolHeadVerifiedDt(Date schoolHeadVerifiedDt) {
        this.schoolHeadVerifiedDt = schoolHeadVerifiedDt;
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

    public Integer getSfGuardUserId() {
        return sfGuardUserId;
    }

    public void setSfGuardUserId(Integer sfGuardUserId) {
        this.sfGuardUserId = sfGuardUserId;
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
        if (!(object instanceof PersonnelHk)) {
            return false;
        }
        PersonnelHk other = (PersonnelHk) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.LisPersonnelHk[ id=" + id + " ]";
    }
    
}
