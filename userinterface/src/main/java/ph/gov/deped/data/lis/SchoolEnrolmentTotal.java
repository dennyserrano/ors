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
@Table(name = "school_enrolment_total", catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolEnrolmentTotal.findAll", query = "SELECT s FROM SchoolEnrolmentTotal s")})
public class SchoolEnrolmentTotal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "school_term_id", nullable = false)
    private int schoolTermId;
    @Basic(optional = false)
    @Column(nullable = false)
    private int schid;
    @Basic(optional = false)
    @Column(name = "grade_level_id", nullable = false)
    private short gradeLevelId;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String section;
    private Short sped;
    private Short multigrade;
    private Short shift;
    @Column(name = "tot_enroll")
    private BigInteger totEnroll;
    private BigInteger male;
    private BigInteger female;
    @Column(name = "alive_enrolled")
    private BigInteger aliveEnrolled;
    private BigInteger muslim;
    @Column(name = "balik_aral")
    private BigInteger balikAral;
    private BigInteger repeater;
    @Column(name = "gifted_talented")
    private BigInteger giftedTalented;
    @Column(name = "CCT_recepient")
    private BigInteger cCTrecepient;
    @Column(name = "grade1_ecd")
    private BigInteger grade1Ecd;
    @Column(name = "enrol_date")
    @Temporal(TemporalType.DATE)
    private Date enrolDate;
    @Column(name = "lis_finalized")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lisFinalized;
    @Column(name = "Kinder_Male")
    private BigInteger kinderMale;
    @Column(name = "Kinder_Female")
    private BigInteger kinderFemale;
    @Column(name = "Grade1_Male")
    private BigInteger grade1Male;
    @Column(name = "Grade1_Female")
    private BigInteger grade1Female;
    @Column(name = "Grade2_Male")
    private BigInteger grade2Male;
    @Column(name = "Grade2_Female")
    private BigInteger grade2Female;
    @Column(name = "Grade3_Male")
    private BigInteger grade3Male;
    @Column(name = "Grade3_Female")
    private BigInteger grade3Female;
    @Column(name = "Grade4_Male")
    private BigInteger grade4Male;
    @Column(name = "Grade4_Female")
    private BigInteger grade4Female;
    @Column(name = "Grade5_Male")
    private BigInteger grade5Male;
    @Column(name = "Grade5_Female")
    private BigInteger grade5Female;
    @Column(name = "Grade6_Male")
    private BigInteger grade6Male;
    @Column(name = "Grade6_Female")
    private BigInteger grade6Female;
    @Column(name = "Grade7_Male")
    private BigInteger grade7Male;
    @Column(name = "Grade7_Female")
    private BigInteger grade7Female;
    @Column(name = "Grade8_Male")
    private BigInteger grade8Male;
    @Column(name = "Grade8_Female")
    private BigInteger grade8Female;
    @Column(name = "Grade9_Male")
    private BigInteger grade9Male;
    @Column(name = "Grade9_Female")
    private BigInteger grade9Female;
    @Column(name = "Grade10_Male")
    private BigInteger grade10Male;
    @Column(name = "Grade10_Female")
    private BigInteger grade10Female;
    @Column(name = "Grade11_Male")
    private BigInteger grade11Male;
    @Column(name = "Grade11_Female")
    private BigInteger grade11Female;
    @Column(name = "Grade12_Male")
    private BigInteger grade12Male;
    @Column(name = "Grade12_Female")
    private BigInteger grade12Female;
    @Column(name = "NonGraded_Male")
    private BigInteger nonGradedMale;
    @Column(name = "NonGraded_Female")
    private BigInteger nonGradedFemale;
    @Column(name = "Shift1_total")
    private BigInteger shift1total;
    @Column(name = "Shift1_Male")
    private BigInteger shift1Male;
    @Column(name = "Shift1_Female")
    private BigInteger shift1Female;
    @Column(name = "Shift2_total")
    private BigInteger shift2total;
    @Column(name = "Shift2_Male")
    private BigInteger shift2Male;
    @Column(name = "Shift2_Female")
    private BigInteger shift2Female;

    public SchoolEnrolmentTotal() {
    }

    public SchoolEnrolmentTotal(Integer id) {
        this.id = id;
    }

    public SchoolEnrolmentTotal(Integer id, int schoolTermId, int schid, short gradeLevelId, String section) {
        this.id = id;
        this.schoolTermId = schoolTermId;
        this.schid = schid;
        this.gradeLevelId = gradeLevelId;
        this.section = section;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSchoolTermId() {
        return schoolTermId;
    }

    public void setSchoolTermId(int schoolTermId) {
        this.schoolTermId = schoolTermId;
    }

    public int getSchid() {
        return schid;
    }

    public void setSchid(int schid) {
        this.schid = schid;
    }

    public short getGradeLevelId() {
        return gradeLevelId;
    }

    public void setGradeLevelId(short gradeLevelId) {
        this.gradeLevelId = gradeLevelId;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Short getSped() {
        return sped;
    }

    public void setSped(Short sped) {
        this.sped = sped;
    }

    public Short getMultigrade() {
        return multigrade;
    }

    public void setMultigrade(Short multigrade) {
        this.multigrade = multigrade;
    }

    public Short getShift() {
        return shift;
    }

    public void setShift(Short shift) {
        this.shift = shift;
    }

    public BigInteger getTotEnroll() {
        return totEnroll;
    }

    public void setTotEnroll(BigInteger totEnroll) {
        this.totEnroll = totEnroll;
    }

    public BigInteger getMale() {
        return male;
    }

    public void setMale(BigInteger male) {
        this.male = male;
    }

    public BigInteger getFemale() {
        return female;
    }

    public void setFemale(BigInteger female) {
        this.female = female;
    }

    public BigInteger getAliveEnrolled() {
        return aliveEnrolled;
    }

    public void setAliveEnrolled(BigInteger aliveEnrolled) {
        this.aliveEnrolled = aliveEnrolled;
    }

    public BigInteger getMuslim() {
        return muslim;
    }

    public void setMuslim(BigInteger muslim) {
        this.muslim = muslim;
    }

    public BigInteger getBalikAral() {
        return balikAral;
    }

    public void setBalikAral(BigInteger balikAral) {
        this.balikAral = balikAral;
    }

    public BigInteger getRepeater() {
        return repeater;
    }

    public void setRepeater(BigInteger repeater) {
        this.repeater = repeater;
    }

    public BigInteger getGiftedTalented() {
        return giftedTalented;
    }

    public void setGiftedTalented(BigInteger giftedTalented) {
        this.giftedTalented = giftedTalented;
    }

    public BigInteger getCCTrecepient() {
        return cCTrecepient;
    }

    public void setCCTrecepient(BigInteger cCTrecepient) {
        this.cCTrecepient = cCTrecepient;
    }

    public BigInteger getGrade1Ecd() {
        return grade1Ecd;
    }

    public void setGrade1Ecd(BigInteger grade1Ecd) {
        this.grade1Ecd = grade1Ecd;
    }

    public Date getEnrolDate() {
        return enrolDate;
    }

    public void setEnrolDate(Date enrolDate) {
        this.enrolDate = enrolDate;
    }

    public Date getLisFinalized() {
        return lisFinalized;
    }

    public void setLisFinalized(Date lisFinalized) {
        this.lisFinalized = lisFinalized;
    }

    public BigInteger getKinderMale() {
        return kinderMale;
    }

    public void setKinderMale(BigInteger kinderMale) {
        this.kinderMale = kinderMale;
    }

    public BigInteger getKinderFemale() {
        return kinderFemale;
    }

    public void setKinderFemale(BigInteger kinderFemale) {
        this.kinderFemale = kinderFemale;
    }

    public BigInteger getGrade1Male() {
        return grade1Male;
    }

    public void setGrade1Male(BigInteger grade1Male) {
        this.grade1Male = grade1Male;
    }

    public BigInteger getGrade1Female() {
        return grade1Female;
    }

    public void setGrade1Female(BigInteger grade1Female) {
        this.grade1Female = grade1Female;
    }

    public BigInteger getGrade2Male() {
        return grade2Male;
    }

    public void setGrade2Male(BigInteger grade2Male) {
        this.grade2Male = grade2Male;
    }

    public BigInteger getGrade2Female() {
        return grade2Female;
    }

    public void setGrade2Female(BigInteger grade2Female) {
        this.grade2Female = grade2Female;
    }

    public BigInteger getGrade3Male() {
        return grade3Male;
    }

    public void setGrade3Male(BigInteger grade3Male) {
        this.grade3Male = grade3Male;
    }

    public BigInteger getGrade3Female() {
        return grade3Female;
    }

    public void setGrade3Female(BigInteger grade3Female) {
        this.grade3Female = grade3Female;
    }

    public BigInteger getGrade4Male() {
        return grade4Male;
    }

    public void setGrade4Male(BigInteger grade4Male) {
        this.grade4Male = grade4Male;
    }

    public BigInteger getGrade4Female() {
        return grade4Female;
    }

    public void setGrade4Female(BigInteger grade4Female) {
        this.grade4Female = grade4Female;
    }

    public BigInteger getGrade5Male() {
        return grade5Male;
    }

    public void setGrade5Male(BigInteger grade5Male) {
        this.grade5Male = grade5Male;
    }

    public BigInteger getGrade5Female() {
        return grade5Female;
    }

    public void setGrade5Female(BigInteger grade5Female) {
        this.grade5Female = grade5Female;
    }

    public BigInteger getGrade6Male() {
        return grade6Male;
    }

    public void setGrade6Male(BigInteger grade6Male) {
        this.grade6Male = grade6Male;
    }

    public BigInteger getGrade6Female() {
        return grade6Female;
    }

    public void setGrade6Female(BigInteger grade6Female) {
        this.grade6Female = grade6Female;
    }

    public BigInteger getGrade7Male() {
        return grade7Male;
    }

    public void setGrade7Male(BigInteger grade7Male) {
        this.grade7Male = grade7Male;
    }

    public BigInteger getGrade7Female() {
        return grade7Female;
    }

    public void setGrade7Female(BigInteger grade7Female) {
        this.grade7Female = grade7Female;
    }

    public BigInteger getGrade8Male() {
        return grade8Male;
    }

    public void setGrade8Male(BigInteger grade8Male) {
        this.grade8Male = grade8Male;
    }

    public BigInteger getGrade8Female() {
        return grade8Female;
    }

    public void setGrade8Female(BigInteger grade8Female) {
        this.grade8Female = grade8Female;
    }

    public BigInteger getGrade9Male() {
        return grade9Male;
    }

    public void setGrade9Male(BigInteger grade9Male) {
        this.grade9Male = grade9Male;
    }

    public BigInteger getGrade9Female() {
        return grade9Female;
    }

    public void setGrade9Female(BigInteger grade9Female) {
        this.grade9Female = grade9Female;
    }

    public BigInteger getGrade10Male() {
        return grade10Male;
    }

    public void setGrade10Male(BigInteger grade10Male) {
        this.grade10Male = grade10Male;
    }

    public BigInteger getGrade10Female() {
        return grade10Female;
    }

    public void setGrade10Female(BigInteger grade10Female) {
        this.grade10Female = grade10Female;
    }

    public BigInteger getGrade11Male() {
        return grade11Male;
    }

    public void setGrade11Male(BigInteger grade11Male) {
        this.grade11Male = grade11Male;
    }

    public BigInteger getGrade11Female() {
        return grade11Female;
    }

    public void setGrade11Female(BigInteger grade11Female) {
        this.grade11Female = grade11Female;
    }

    public BigInteger getGrade12Male() {
        return grade12Male;
    }

    public void setGrade12Male(BigInteger grade12Male) {
        this.grade12Male = grade12Male;
    }

    public BigInteger getGrade12Female() {
        return grade12Female;
    }

    public void setGrade12Female(BigInteger grade12Female) {
        this.grade12Female = grade12Female;
    }

    public BigInteger getNonGradedMale() {
        return nonGradedMale;
    }

    public void setNonGradedMale(BigInteger nonGradedMale) {
        this.nonGradedMale = nonGradedMale;
    }

    public BigInteger getNonGradedFemale() {
        return nonGradedFemale;
    }

    public void setNonGradedFemale(BigInteger nonGradedFemale) {
        this.nonGradedFemale = nonGradedFemale;
    }

    public BigInteger getShift1total() {
        return shift1total;
    }

    public void setShift1total(BigInteger shift1total) {
        this.shift1total = shift1total;
    }

    public BigInteger getShift1Male() {
        return shift1Male;
    }

    public void setShift1Male(BigInteger shift1Male) {
        this.shift1Male = shift1Male;
    }

    public BigInteger getShift1Female() {
        return shift1Female;
    }

    public void setShift1Female(BigInteger shift1Female) {
        this.shift1Female = shift1Female;
    }

    public BigInteger getShift2total() {
        return shift2total;
    }

    public void setShift2total(BigInteger shift2total) {
        this.shift2total = shift2total;
    }

    public BigInteger getShift2Male() {
        return shift2Male;
    }

    public void setShift2Male(BigInteger shift2Male) {
        this.shift2Male = shift2Male;
    }

    public BigInteger getShift2Female() {
        return shift2Female;
    }

    public void setShift2Female(BigInteger shift2Female) {
        this.shift2Female = shift2Female;
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
        if (!(object instanceof SchoolEnrolmentTotal)) {
            return false;
        }
        SchoolEnrolmentTotal other = (SchoolEnrolmentTotal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.SchoolEnrolmentTotal[ id=" + id + " ]";
    }
    
}
