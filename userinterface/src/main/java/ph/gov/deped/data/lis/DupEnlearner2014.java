/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "dup_enlearner_2014", catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DupEnlearner2014.findAll", query = "SELECT d FROM DupEnlearner2014 d")})
public class DupEnlearner2014 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "school_term_id")
    private Integer schoolTermId;
    private BigInteger lrn;
    @Basic(optional = false)
    @Column(name = "lrnr_id", nullable = false)
    private int lrnrId;
    private Short rank;
    @Column(name = "first_name", length = 100)
    private String firstName;
    @Column(name = "middle_name", length = 100)
    private String middleName;
    @Column(name = "last_name", length = 100)
    private String lastName;
    private Boolean gender;
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Column(name = "mother_maiden_name", length = 50)
    private String motherMaidenName;
    @Column(name = "father_first_name", length = 50)
    private String fatherFirstName;
    @Column(length = 100)
    private String residenceBarangay;
    @Column(name = "street_address", length = 255)
    private String streetAddress;
    @Column(length = 100)
    private String residenceMunicipality;
    @Column(name = "ref_municipality_id")
    private Integer refMunicipalityId;
    @Column(name = "lrn_dt_created")
    @Temporal(TemporalType.DATE)
    private Date lrnDtCreated;
    @Column(name = "school_id")
    private Integer schoolId;
    @Column(name = "school_name", length = 128)
    private String schoolName;
    @Column(name = "co_gen_class")
    private Short coGenClass;
    @Column(name = "enrol_date")
    @Temporal(TemporalType.DATE)
    private Date enrolDate;
    @Basic(optional = false)
    @Column(name = "enrolment_id", nullable = false)
    private int enrolmentId;
    @Column(length = 50)
    private String section;
    @Column(name = "grade_level_id")
    private Short gradeLevelId;
    @Column(length = 50)
    private String grade;
    @Column(name = "region_name", length = 100)
    private String regionName;
    @Column(name = "office_name", length = 100)
    private String officeName;

    public DupEnlearner2014() {
    }

    public DupEnlearner2014(Integer id) {
        this.id = id;
    }

    public DupEnlearner2014(Integer id, int lrnrId, int enrolmentId) {
        this.id = id;
        this.lrnrId = lrnrId;
        this.enrolmentId = enrolmentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSchoolTermId() {
        return schoolTermId;
    }

    public void setSchoolTermId(Integer schoolTermId) {
        this.schoolTermId = schoolTermId;
    }

    public BigInteger getLrn() {
        return lrn;
    }

    public void setLrn(BigInteger lrn) {
        this.lrn = lrn;
    }

    public int getLrnrId() {
        return lrnrId;
    }

    public void setLrnrId(int lrnrId) {
        this.lrnrId = lrnrId;
    }

    public Short getRank() {
        return rank;
    }

    public void setRank(Short rank) {
        this.rank = rank;
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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getMotherMaidenName() {
        return motherMaidenName;
    }

    public void setMotherMaidenName(String motherMaidenName) {
        this.motherMaidenName = motherMaidenName;
    }

    public String getFatherFirstName() {
        return fatherFirstName;
    }

    public void setFatherFirstName(String fatherFirstName) {
        this.fatherFirstName = fatherFirstName;
    }

    public String getResidenceBarangay() {
        return residenceBarangay;
    }

    public void setResidenceBarangay(String residenceBarangay) {
        this.residenceBarangay = residenceBarangay;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
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

    public Date getLrnDtCreated() {
        return lrnDtCreated;
    }

    public void setLrnDtCreated(Date lrnDtCreated) {
        this.lrnDtCreated = lrnDtCreated;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Short getCoGenClass() {
        return coGenClass;
    }

    public void setCoGenClass(Short coGenClass) {
        this.coGenClass = coGenClass;
    }

    public Date getEnrolDate() {
        return enrolDate;
    }

    public void setEnrolDate(Date enrolDate) {
        this.enrolDate = enrolDate;
    }

    public int getEnrolmentId() {
        return enrolmentId;
    }

    public void setEnrolmentId(int enrolmentId) {
        this.enrolmentId = enrolmentId;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Short getGradeLevelId() {
        return gradeLevelId;
    }

    public void setGradeLevelId(Short gradeLevelId) {
        this.gradeLevelId = gradeLevelId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
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
        if (!(object instanceof DupEnlearner2014)) {
            return false;
        }
        DupEnlearner2014 other = (DupEnlearner2014) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.DupEnlearner2014[ id=" + id + " ]";
    }
    
}
