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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "school_enrolment_summary", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"school_term_id", "schid", "grade_level_id", "section"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolEnrolmentSummary.findAll", query = "SELECT s FROM SchoolEnrolmentSummary s")})
public class SchoolEnrolmentSummary implements Serializable {
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
    @Column(name = "4_Male")
    private BigInteger male1;
    @Column(name = "4_Female")
    private BigInteger female1;
    @Column(name = "5_Male")
    private BigInteger male2;
    @Column(name = "5_Female")
    private BigInteger female2;
    @Column(name = "6_Male")
    private BigInteger male3;
    @Column(name = "6_Female")
    private BigInteger female3;
    @Column(name = "7_Male")
    private BigInteger male4;
    @Column(name = "7_Female")
    private BigInteger female4;
    @Column(name = "8_Male")
    private BigInteger male5;
    @Column(name = "8_Female")
    private BigInteger female5;
    @Column(name = "9_Male")
    private BigInteger male6;
    @Column(name = "9_Female")
    private BigInteger female6;
    @Column(name = "10_Male")
    private BigInteger male7;
    @Column(name = "10_Female")
    private BigInteger female7;
    @Column(name = "11_Male")
    private BigInteger male8;
    @Column(name = "11_Female")
    private BigInteger female8;
    @Column(name = "12_Male")
    private BigInteger male9;
    @Column(name = "12_Female")
    private BigInteger female9;
    @Column(name = "13_Male")
    private BigInteger male10;
    @Column(name = "13_Female")
    private BigInteger female10;
    @Column(name = "14_Male")
    private BigInteger male11;
    @Column(name = "14_Female")
    private BigInteger female11;
    @Column(name = "15_Male")
    private BigInteger male12;
    @Column(name = "15_Female")
    private BigInteger female12;
    @Column(name = "16_Male")
    private BigInteger male13;
    @Column(name = "16_Female")
    private BigInteger female13;
    @Column(name = "17_Male")
    private BigInteger male14;
    @Column(name = "17_Female")
    private BigInteger female14;
    @Column(name = "18_Male")
    private BigInteger male15;
    @Column(name = "18_Female")
    private BigInteger female15;
    @Column(name = "19_Up_Male")
    private BigInteger upMale;
    @Column(name = "19_Up_Female")
    private BigInteger upFemale;

    public SchoolEnrolmentSummary() {
    }

    public SchoolEnrolmentSummary(Integer id) {
        this.id = id;
    }

    public SchoolEnrolmentSummary(Integer id, int schoolTermId, int schid, short gradeLevelId, String section) {
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

    public BigInteger getMale1() {
        return male1;
    }

    public void setMale1(BigInteger male1) {
        this.male1 = male1;
    }

    public BigInteger getFemale1() {
        return female1;
    }

    public void setFemale1(BigInteger female1) {
        this.female1 = female1;
    }

    public BigInteger getMale2() {
        return male2;
    }

    public void setMale2(BigInteger male2) {
        this.male2 = male2;
    }

    public BigInteger getFemale2() {
        return female2;
    }

    public void setFemale2(BigInteger female2) {
        this.female2 = female2;
    }

    public BigInteger getMale3() {
        return male3;
    }

    public void setMale3(BigInteger male3) {
        this.male3 = male3;
    }

    public BigInteger getFemale3() {
        return female3;
    }

    public void setFemale3(BigInteger female3) {
        this.female3 = female3;
    }

    public BigInteger getMale4() {
        return male4;
    }

    public void setMale4(BigInteger male4) {
        this.male4 = male4;
    }

    public BigInteger getFemale4() {
        return female4;
    }

    public void setFemale4(BigInteger female4) {
        this.female4 = female4;
    }

    public BigInteger getMale5() {
        return male5;
    }

    public void setMale5(BigInteger male5) {
        this.male5 = male5;
    }

    public BigInteger getFemale5() {
        return female5;
    }

    public void setFemale5(BigInteger female5) {
        this.female5 = female5;
    }

    public BigInteger getMale6() {
        return male6;
    }

    public void setMale6(BigInteger male6) {
        this.male6 = male6;
    }

    public BigInteger getFemale6() {
        return female6;
    }

    public void setFemale6(BigInteger female6) {
        this.female6 = female6;
    }

    public BigInteger getMale7() {
        return male7;
    }

    public void setMale7(BigInteger male7) {
        this.male7 = male7;
    }

    public BigInteger getFemale7() {
        return female7;
    }

    public void setFemale7(BigInteger female7) {
        this.female7 = female7;
    }

    public BigInteger getMale8() {
        return male8;
    }

    public void setMale8(BigInteger male8) {
        this.male8 = male8;
    }

    public BigInteger getFemale8() {
        return female8;
    }

    public void setFemale8(BigInteger female8) {
        this.female8 = female8;
    }

    public BigInteger getMale9() {
        return male9;
    }

    public void setMale9(BigInteger male9) {
        this.male9 = male9;
    }

    public BigInteger getFemale9() {
        return female9;
    }

    public void setFemale9(BigInteger female9) {
        this.female9 = female9;
    }

    public BigInteger getMale10() {
        return male10;
    }

    public void setMale10(BigInteger male10) {
        this.male10 = male10;
    }

    public BigInteger getFemale10() {
        return female10;
    }

    public void setFemale10(BigInteger female10) {
        this.female10 = female10;
    }

    public BigInteger getMale11() {
        return male11;
    }

    public void setMale11(BigInteger male11) {
        this.male11 = male11;
    }

    public BigInteger getFemale11() {
        return female11;
    }

    public void setFemale11(BigInteger female11) {
        this.female11 = female11;
    }

    public BigInteger getMale12() {
        return male12;
    }

    public void setMale12(BigInteger male12) {
        this.male12 = male12;
    }

    public BigInteger getFemale12() {
        return female12;
    }

    public void setFemale12(BigInteger female12) {
        this.female12 = female12;
    }

    public BigInteger getMale13() {
        return male13;
    }

    public void setMale13(BigInteger male13) {
        this.male13 = male13;
    }

    public BigInteger getFemale13() {
        return female13;
    }

    public void setFemale13(BigInteger female13) {
        this.female13 = female13;
    }

    public BigInteger getMale14() {
        return male14;
    }

    public void setMale14(BigInteger male14) {
        this.male14 = male14;
    }

    public BigInteger getFemale14() {
        return female14;
    }

    public void setFemale14(BigInteger female14) {
        this.female14 = female14;
    }

    public BigInteger getMale15() {
        return male15;
    }

    public void setMale15(BigInteger male15) {
        this.male15 = male15;
    }

    public BigInteger getFemale15() {
        return female15;
    }

    public void setFemale15(BigInteger female15) {
        this.female15 = female15;
    }

    public BigInteger getUpMale() {
        return upMale;
    }

    public void setUpMale(BigInteger upMale) {
        this.upMale = upMale;
    }

    public BigInteger getUpFemale() {
        return upFemale;
    }

    public void setUpFemale(BigInteger upFemale) {
        this.upFemale = upFemale;
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
        if (!(object instanceof SchoolEnrolmentSummary)) {
            return false;
        }
        SchoolEnrolmentSummary other = (SchoolEnrolmentSummary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.SchoolEnrolmentSummary[ id=" + id + " ]";
    }
    
}
