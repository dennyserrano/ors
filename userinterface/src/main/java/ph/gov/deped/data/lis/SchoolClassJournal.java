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
@Table(name = "school_class_journal", catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolClassJournal.findAll", query = "SELECT s FROM SchoolClassJournal s")})
public class SchoolClassJournal implements Serializable {
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
    @Column(name = "school_class_id", nullable = false)
    private int schoolClassId;
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
    @Basic(optional = false)
    @Column(name = "tran_dt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tranDt;
    @Basic(optional = false)
    @Column(name = "tran_by", nullable = false)
    private int tranBy;

    public SchoolClassJournal() {
    }

    public SchoolClassJournal(Integer id) {
        this.id = id;
    }

    public SchoolClassJournal(Integer id, short tranTypeId, int schoolClassId, Date createdAt, short multigrade, Date tranDt, int tranBy) {
        this.id = id;
        this.tranTypeId = tranTypeId;
        this.schoolClassId = schoolClassId;
        this.createdAt = createdAt;
        this.multigrade = multigrade;
        this.tranDt = tranDt;
        this.tranBy = tranBy;
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

    public int getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(int schoolClassId) {
        this.schoolClassId = schoolClassId;
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

    public Date getTranDt() {
        return tranDt;
    }

    public void setTranDt(Date tranDt) {
        this.tranDt = tranDt;
    }

    public int getTranBy() {
        return tranBy;
    }

    public void setTranBy(int tranBy) {
        this.tranBy = tranBy;
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
        if (!(object instanceof SchoolClassJournal)) {
            return false;
        }
        SchoolClassJournal other = (SchoolClassJournal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.SchoolClassJournal[ id=" + id + " ]";
    }
    
}
