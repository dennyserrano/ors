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
@Table(name = "learner_snapshot", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"type_id", "sy_from", "learner_registry_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LearnerSnapshot.findAll", query = "SELECT l FROM LearnerSnapshot l")})
public class LearnerSnapshot implements Serializable {
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
    @Column(name = "sy_from", nullable = false)
    private short syFrom;
    @Basic(optional = false)
    @Column(name = "school_class_snapshot_id", nullable = false)
    private int schoolClassSnapshotId;
    @Basic(optional = false)
    @Column(name = "learner_registry_id", nullable = false)
    private int learnerRegistryId;
    @Basic(optional = false)
    @Column(nullable = false)
    private short gender;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Column(name = "religion_id")
    private Short religionId;
    @Column(name = "ethnicity_id")
    private Short ethnicityId;
    @Column(name = "ethnicity_id2")
    private Short ethnicityId2;
    @Column(name = "ethnicity_id3")
    private Short ethnicityId3;
    @Basic(optional = false)
    @Column(name = "status_id", nullable = false)
    private int statusId;
    @Basic(optional = false)
    @Column(name = "enrol_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date enrolDate;
    @Basic(optional = false)
    @Column(nullable = false)
    private short repeater;
    @Basic(optional = false)
    @Column(name = "balik_aral", nullable = false)
    private short balikAral;
    @Column(name = "trans_in")
    private Short transIn;
    private Short cCT4Ps;
    @Basic(optional = false)
    @Column(nullable = false)
    private short alive;
    @Basic(optional = false)
    @Column(name = "grade1_ecd", nullable = false)
    private short grade1Ecd;
    private Short override;
    @Basic(optional = false)
    @Column(nullable = false)
    private short age;
    @Basic(optional = false)
    @Column(nullable = false)
    private short dropped;
    @Column(name = "dropped_date")
    @Temporal(TemporalType.DATE)
    private Date droppedDate;
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

    public LearnerSnapshot() {
    }

    public LearnerSnapshot(Integer id) {
        this.id = id;
    }

    public LearnerSnapshot(Integer id, short typeId, short syFrom, int schoolClassSnapshotId, int learnerRegistryId, short gender, Date birthdate, int statusId, Date enrolDate, short repeater, short balikAral, short alive, short grade1Ecd, short age, short dropped, Date createdAt, int createdBy, Date updatedAt, int updatedBy) {
        this.id = id;
        this.typeId = typeId;
        this.syFrom = syFrom;
        this.schoolClassSnapshotId = schoolClassSnapshotId;
        this.learnerRegistryId = learnerRegistryId;
        this.gender = gender;
        this.birthdate = birthdate;
        this.statusId = statusId;
        this.enrolDate = enrolDate;
        this.repeater = repeater;
        this.balikAral = balikAral;
        this.alive = alive;
        this.grade1Ecd = grade1Ecd;
        this.age = age;
        this.dropped = dropped;
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

    public short getSyFrom() {
        return syFrom;
    }

    public void setSyFrom(short syFrom) {
        this.syFrom = syFrom;
    }

    public int getSchoolClassSnapshotId() {
        return schoolClassSnapshotId;
    }

    public void setSchoolClassSnapshotId(int schoolClassSnapshotId) {
        this.schoolClassSnapshotId = schoolClassSnapshotId;
    }

    public int getLearnerRegistryId() {
        return learnerRegistryId;
    }

    public void setLearnerRegistryId(int learnerRegistryId) {
        this.learnerRegistryId = learnerRegistryId;
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

    public Short getReligionId() {
        return religionId;
    }

    public void setReligionId(Short religionId) {
        this.religionId = religionId;
    }

    public Short getEthnicityId() {
        return ethnicityId;
    }

    public void setEthnicityId(Short ethnicityId) {
        this.ethnicityId = ethnicityId;
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public Date getEnrolDate() {
        return enrolDate;
    }

    public void setEnrolDate(Date enrolDate) {
        this.enrolDate = enrolDate;
    }

    public short getRepeater() {
        return repeater;
    }

    public void setRepeater(short repeater) {
        this.repeater = repeater;
    }

    public short getBalikAral() {
        return balikAral;
    }

    public void setBalikAral(short balikAral) {
        this.balikAral = balikAral;
    }

    public Short getTransIn() {
        return transIn;
    }

    public void setTransIn(Short transIn) {
        this.transIn = transIn;
    }

    public Short getCCT4Ps() {
        return cCT4Ps;
    }

    public void setCCT4Ps(Short cCT4Ps) {
        this.cCT4Ps = cCT4Ps;
    }

    public short getAlive() {
        return alive;
    }

    public void setAlive(short alive) {
        this.alive = alive;
    }

    public short getGrade1Ecd() {
        return grade1Ecd;
    }

    public void setGrade1Ecd(short grade1Ecd) {
        this.grade1Ecd = grade1Ecd;
    }

    public Short getOverride() {
        return override;
    }

    public void setOverride(Short override) {
        this.override = override;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public short getDropped() {
        return dropped;
    }

    public void setDropped(short dropped) {
        this.dropped = dropped;
    }

    public Date getDroppedDate() {
        return droppedDate;
    }

    public void setDroppedDate(Date droppedDate) {
        this.droppedDate = droppedDate;
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
        if (!(object instanceof LearnerSnapshot)) {
            return false;
        }
        LearnerSnapshot other = (LearnerSnapshot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.LearnerSnapshot[ id=" + id + " ]";
    }
    
}
