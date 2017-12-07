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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "school_class_snapshot", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"type_id", "school_term_id", "school_class_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolClassSnapshot.findAll", query = "SELECT s FROM SchoolClassSnapshot s")})
public class SchoolClassSnapshot implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "type_id", nullable = false)
    private short typeId;
    @Basic(optional = false)
    @Column(name = "school_class_id", nullable = false)
    private int schoolClassId;
    @Basic(optional = false)
    @Column(name = "school_term_id", nullable = false)
    private int schoolTermId;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String section;
    @Basic(optional = false)
    @Column(name = "personnel_id", nullable = false)
    private int personnelId;
    @Column(name = "school_id")
    private Integer schoolId;
    @Column(name = "grade_level_id")
    private Short gradeLevelId;
    private Short sped;
    @Basic(optional = false)
    @Column(nullable = false)
    private short multigrade;
    @Column(name = "co_multi_grade_id")
    private Short coMultiGradeId;
    @Column(name = "lis_finalized")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lisFinalized;
    private Short shift;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "created_by", nullable = false)
    private int createdBy;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "updated_by", nullable = false)
    private int updatedBy;

    public SchoolClassSnapshot() {
    }

    public SchoolClassSnapshot(Integer id) {
        this.id = id;
    }

    public SchoolClassSnapshot(Integer id, short typeId, int schoolClassId, int schoolTermId, String section, int personnelId, short multigrade, Date createdAt, int createdBy, Date updatedAt, int updatedBy) {
        this.id = id;
        this.typeId = typeId;
        this.schoolClassId = schoolClassId;
        this.schoolTermId = schoolTermId;
        this.section = section;
        this.personnelId = personnelId;
        this.multigrade = multigrade;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getTypeId() {
        return typeId;
    }

    public void setTypeId(short typeId) {
        this.typeId = typeId;
    }

    public int getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(int schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

    public int getSchoolTermId() {
        return schoolTermId;
    }

    public void setSchoolTermId(int schoolTermId) {
        this.schoolTermId = schoolTermId;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(int personnelId) {
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

    public short getMultigrade() {
        return multigrade;
    }

    public void setMultigrade(short multigrade) {
        this.multigrade = multigrade;
    }

    public Short getCoMultiGradeId() {
        return coMultiGradeId;
    }

    public void setCoMultiGradeId(Short coMultiGradeId) {
        this.coMultiGradeId = coMultiGradeId;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
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
        if (!(object instanceof SchoolClassSnapshot)) {
            return false;
        }
        SchoolClassSnapshot other = (SchoolClassSnapshot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.SchoolClassSnapshot[ id=" + id + " ]";
    }
    
}
