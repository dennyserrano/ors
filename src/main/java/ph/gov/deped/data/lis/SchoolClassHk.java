/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "school_class_hk", catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolClassHk.findAll", query = "SELECT s FROM SchoolClassHk s")})
public class SchoolClassHk implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 50)
    private String section;
    @Column(name = "personnel_id")
    private Integer personnelId;
    @Column(name = "school_id")
    private Integer schoolId;
    @Column(name = "grade_level_id")
    private Short gradeLevelId;
    private Short sped;
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
    @Basic(optional = false)
    @Column(nullable = false)
    private short multigrade;
    @Column(name = "org_grade_id")
    private Short orgGradeId;
    @Column(name = "school_term_id")
    private Integer schoolTermId;
    @Column(name = "lis_finalized")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lisFinalized;
    private Short shift;
    @Column(name = "eosy_end")
    @Temporal(TemporalType.DATE)
    private Date eosyEnd;
    @Column(name = "bosy_cutoff")
    @Temporal(TemporalType.DATE)
    private Date bosyCutoff;
    @Column(name = "bosy_deadline")
    @Temporal(TemporalType.DATE)
    private Date bosyDeadline;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolClassId")
    private List<Enold> enoldList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolClassId")
    private List<Enrolment> enrolmentList;

    public SchoolClassHk() {
    }

    public SchoolClassHk(Integer id) {
        this.id = id;
    }

    public SchoolClassHk(Integer id, Date createdAt, short multigrade) {
        this.id = id;
        this.createdAt = createdAt;
        this.multigrade = multigrade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Integer getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(Integer personnelId) {
        this.personnelId = personnelId;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Short getGradeLevelId() {
        return gradeLevelId;
    }

    public void setGradeLevelId(Short gradeLevelId) {
        this.gradeLevelId = gradeLevelId;
    }

    public Short getSped() {
        return sped;
    }

    public void setSped(Short sped) {
        this.sped = sped;
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

    public short getMultigrade() {
        return multigrade;
    }

    public void setMultigrade(short multigrade) {
        this.multigrade = multigrade;
    }

    public Short getOrgGradeId() {
        return orgGradeId;
    }

    public void setOrgGradeId(Short orgGradeId) {
        this.orgGradeId = orgGradeId;
    }

    public Integer getSchoolTermId() {
        return schoolTermId;
    }

    public void setSchoolTermId(Integer schoolTermId) {
        this.schoolTermId = schoolTermId;
    }

    public Date getLisFinalized() {
        return lisFinalized;
    }

    public void setLisFinalized(Date lisFinalized) {
        this.lisFinalized = lisFinalized;
    }

    public Short getShift() {
        return shift;
    }

    public void setShift(Short shift) {
        this.shift = shift;
    }

    public Date getEosyEnd() {
        return eosyEnd;
    }

    public void setEosyEnd(Date eosyEnd) {
        this.eosyEnd = eosyEnd;
    }

    public Date getBosyCutoff() {
        return bosyCutoff;
    }

    public void setBosyCutoff(Date bosyCutoff) {
        this.bosyCutoff = bosyCutoff;
    }

    public Date getBosyDeadline() {
        return bosyDeadline;
    }

    public void setBosyDeadline(Date bosyDeadline) {
        this.bosyDeadline = bosyDeadline;
    }

    @XmlTransient
    public List<Enold> getEnoldList() {
        return enoldList;
    }

    public void setEnoldList(List<Enold> enoldList) {
        this.enoldList = enoldList;
    }

    @XmlTransient
    public List<Enrolment> getEnrolmentList() {
        return enrolmentList;
    }

    public void setEnrolmentList(List<Enrolment> enrolmentList) {
        this.enrolmentList = enrolmentList;
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
        if (!(object instanceof SchoolClassHk)) {
            return false;
        }
        SchoolClassHk other = (SchoolClassHk) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.SchoolClassHk[ id=" + id + " ]";
    }
    
}
