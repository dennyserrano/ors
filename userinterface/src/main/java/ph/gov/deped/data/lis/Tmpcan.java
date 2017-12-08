/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmpcan.findAll", query = "SELECT t FROM Tmpcan t")})
public class Tmpcan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "learner_registry_id")
    private Integer learnerRegistryId;
    @Column(name = "enrolment_id")
    private Integer enrolmentId;
    @Column(name = "last_enrolment_sy")
    private Short lastEnrolmentSy;
    @Column(name = "school_class_id")
    private Integer schoolClassId;
    @Column(name = "status_id")
    private Short statusId;
    @Column(name = "min_grade_id")
    private Short minGradeId;
    @Column(name = "max_grade_id")
    private Short maxGradeId;
    @Column(name = "school_id")
    private Integer schoolId;
    @Column(name = "with_p")
    private Short withP;

    public Tmpcan() {
    }

    public Tmpcan(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLearnerRegistryId() {
        return learnerRegistryId;
    }

    public void setLearnerRegistryId(Integer learnerRegistryId) {
        this.learnerRegistryId = learnerRegistryId;
    }

    public Integer getEnrolmentId() {
        return enrolmentId;
    }

    public void setEnrolmentId(Integer enrolmentId) {
        this.enrolmentId = enrolmentId;
    }

    public Short getLastEnrolmentSy() {
        return lastEnrolmentSy;
    }

    public void setLastEnrolmentSy(Short lastEnrolmentSy) {
        this.lastEnrolmentSy = lastEnrolmentSy;
    }

    public Integer getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(Integer schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

    public Short getStatusId() {
        return statusId;
    }

    public void setStatusId(Short statusId) {
        this.statusId = statusId;
    }

    public Short getMinGradeId() {
        return minGradeId;
    }

    public void setMinGradeId(Short minGradeId) {
        this.minGradeId = minGradeId;
    }

    public Short getMaxGradeId() {
        return maxGradeId;
    }

    public void setMaxGradeId(Short maxGradeId) {
        this.maxGradeId = maxGradeId;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Short getWithP() {
        return withP;
    }

    public void setWithP(Short withP) {
        this.withP = withP;
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
        if (!(object instanceof Tmpcan)) {
            return false;
        }
        Tmpcan other = (Tmpcan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.Tmpcan[ id=" + id + " ]";
    }
    
}
