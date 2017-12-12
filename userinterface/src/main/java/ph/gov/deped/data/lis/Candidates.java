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
@Table(name = "candidates", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"learner_registry_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidates.findAll", query = "SELECT c FROM Candidates c")})
public class Candidates implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "for_sy", nullable = false)
    private short forSy;
    @Basic(optional = false)
    @Column(name = "last_enrolment_sy", nullable = false)
    private short lastEnrolmentSy;
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

    public Candidates() {
    }

    public Candidates(Integer id) {
        this.id = id;
    }

    public Candidates(Integer id, short forSy, short lastEnrolmentSy, int enrolmentId, int schoolClassId, int learnerRegistryId, int statusId, short minGradeId, short maxGradeId, int schoolId, short noOfen, Date updatedAt) {
        this.id = id;
        this.forSy = forSy;
        this.lastEnrolmentSy = lastEnrolmentSy;
        this.enrolmentId = enrolmentId;
        this.schoolClassId = schoolClassId;
        this.learnerRegistryId = learnerRegistryId;
        this.statusId = statusId;
        this.minGradeId = minGradeId;
        this.maxGradeId = maxGradeId;
        this.schoolId = schoolId;
        this.noOfen = noOfen;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getForSy() {
        return forSy;
    }

    public void setForSy(short forSy) {
        this.forSy = forSy;
    }

    public short getLastEnrolmentSy() {
        return lastEnrolmentSy;
    }

    public void setLastEnrolmentSy(short lastEnrolmentSy) {
        this.lastEnrolmentSy = lastEnrolmentSy;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidates)) {
            return false;
        }
        Candidates other = (Candidates) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.Candidates[ id=" + id + " ]";
    }
    
}
