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
@Table(catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Canlistofen2.findAll", query = "SELECT c FROM Canlistofen2 c")})
public class Canlistofen2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    private int canid;
    @Basic(optional = false)
    @Column(name = "for_SY", nullable = false)
    private short forSY;
    @Basic(optional = false)
    @Column(name = "enrolment_id", nullable = false)
    private int enrolmentId;
    @Basic(optional = false)
    @Column(name = "school_class_id", nullable = false)
    private int schoolClassId;
    @Basic(optional = false)
    @Column(name = "learner_registry_id", nullable = false)
    private int learnerRegistryId;
    @Basic(optional = false)
    @Column(name = "status_id", nullable = false)
    private int statusId;
    @Basic(optional = false)
    @Column(name = "min_grade_id", nullable = false)
    private short minGradeId;
    @Basic(optional = false)
    @Column(name = "max_grade_id", nullable = false)
    private short maxGradeId;
    @Basic(optional = false)
    @Column(name = "school_id", nullable = false)
    private int schoolId;
    @Column(name = "current_enrolemnt_id")
    private Integer currentEnrolemntId;
    @Column(name = "current_en_status_id")
    private Short currentEnStatusId;
    @Basic(optional = false)
    @Column(name = "no_ofen", nullable = false)
    private short noOfen;
    @Column(name = "with_pe")
    private Short withPe;
    @Basic(optional = false)
    @Column(name = "last_enrolment_sy", nullable = false)
    private short lastEnrolmentSy;
    @Basic(optional = false)
    @Column(name = "en_id", nullable = false)
    private int enId;
    @Column(name = "class_adviser_id")
    private Integer classAdviserId;
    @Basic(optional = false)
    @Column(nullable = false)
    private short sy;
    @Basic(optional = false)
    @Column(nullable = false)
    private long lrn;
    @Column(name = "grade_level_id")
    private Short gradeLevelId;
    @Column(length = 50)
    private String section;
    @Basic(optional = false)
    @Column(name = "enrol_type", nullable = false)
    private short enrolType;
    @Column(name = "act_status_id")
    private Integer actStatusId;
    @Basic(optional = false)
    @Column(name = "first_login_dt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstLoginDt;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Canlistofen2() {
    }

    public Canlistofen2(Integer id) {
        this.id = id;
    }

    public Canlistofen2(Integer id, int canid, short forSY, int enrolmentId, int schoolClassId, int learnerRegistryId, int statusId, short minGradeId, short maxGradeId, int schoolId, short noOfen, short lastEnrolmentSy, int enId, short sy, long lrn, short enrolType, Date firstLoginDt, Date updatedAt) {
        this.id = id;
        this.canid = canid;
        this.forSY = forSY;
        this.enrolmentId = enrolmentId;
        this.schoolClassId = schoolClassId;
        this.learnerRegistryId = learnerRegistryId;
        this.statusId = statusId;
        this.minGradeId = minGradeId;
        this.maxGradeId = maxGradeId;
        this.schoolId = schoolId;
        this.noOfen = noOfen;
        this.lastEnrolmentSy = lastEnrolmentSy;
        this.enId = enId;
        this.sy = sy;
        this.lrn = lrn;
        this.enrolType = enrolType;
        this.firstLoginDt = firstLoginDt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCanid() {
        return canid;
    }

    public void setCanid(int canid) {
        this.canid = canid;
    }

    public short getForSY() {
        return forSY;
    }

    public void setForSY(short forSY) {
        this.forSY = forSY;
    }

    public int getEnrolmentId() {
        return enrolmentId;
    }

    public void setEnrolmentId(int enrolmentId) {
        this.enrolmentId = enrolmentId;
    }

    public int getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(int schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

    public int getLearnerRegistryId() {
        return learnerRegistryId;
    }

    public void setLearnerRegistryId(int learnerRegistryId) {
        this.learnerRegistryId = learnerRegistryId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public short getMinGradeId() {
        return minGradeId;
    }

    public void setMinGradeId(short minGradeId) {
        this.minGradeId = minGradeId;
    }

    public short getMaxGradeId() {
        return maxGradeId;
    }

    public void setMaxGradeId(short maxGradeId) {
        this.maxGradeId = maxGradeId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getCurrentEnrolemntId() {
        return currentEnrolemntId;
    }

    public void setCurrentEnrolemntId(Integer currentEnrolemntId) {
        this.currentEnrolemntId = currentEnrolemntId;
    }

    public Short getCurrentEnStatusId() {
        return currentEnStatusId;
    }

    public void setCurrentEnStatusId(Short currentEnStatusId) {
        this.currentEnStatusId = currentEnStatusId;
    }

    public short getNoOfen() {
        return noOfen;
    }

    public void setNoOfen(short noOfen) {
        this.noOfen = noOfen;
    }

    public Short getWithPe() {
        return withPe;
    }

    public void setWithPe(Short withPe) {
        this.withPe = withPe;
    }

    public short getLastEnrolmentSy() {
        return lastEnrolmentSy;
    }

    public void setLastEnrolmentSy(short lastEnrolmentSy) {
        this.lastEnrolmentSy = lastEnrolmentSy;
    }

    public int getEnId() {
        return enId;
    }

    public void setEnId(int enId) {
        this.enId = enId;
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

    public Short getGradeLevelId() {
        return gradeLevelId;
    }

    public void setGradeLevelId(Short gradeLevelId) {
        this.gradeLevelId = gradeLevelId;
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

    public Integer getActStatusId() {
        return actStatusId;
    }

    public void setActStatusId(Integer actStatusId) {
        this.actStatusId = actStatusId;
    }

    public Date getFirstLoginDt() {
        return firstLoginDt;
    }

    public void setFirstLoginDt(Date firstLoginDt) {
        this.firstLoginDt = firstLoginDt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
        if (!(object instanceof Canlistofen2)) {
            return false;
        }
        Canlistofen2 other = (Canlistofen2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.Canlistofen2[ id=" + id + " ]";
    }
    
}
