/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "assessment_types_rubrics", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AssessmentTypesRubrics.findAll", query = "SELECT a FROM AssessmentTypesRubrics a")})
public class AssessmentTypesRubrics implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short id;
    @Basic(optional = false)
    @Column(name = "school_year", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date schoolYear;
    @Basic(optional = false)
    @Column(name = "low_performing_floor", nullable = false)
    private float lowPerformingFloor;
    @Basic(optional = false)
    @Column(name = "low_performing_ceiling", nullable = false)
    private float lowPerformingCeiling;
    @Basic(optional = false)
    @Column(name = "average_performing_floor", nullable = false)
    private float averagePerformingFloor;
    @Basic(optional = false)
    @Column(name = "average_performing_ceiling", nullable = false)
    private float averagePerformingCeiling;
    @Basic(optional = false)
    @Column(name = "high_performing_floor", nullable = false)
    private float highPerformingFloor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "high_performing_ceiling", precision = 12)
    private Float highPerformingCeiling;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "assessment_type_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private AssessmentTypes assessmentTypeId;

    public AssessmentTypesRubrics() {
    }

    public AssessmentTypesRubrics(Short id) {
        this.id = id;
    }

    public AssessmentTypesRubrics(Short id, Date schoolYear, float lowPerformingFloor, float lowPerformingCeiling, float averagePerformingFloor, float averagePerformingCeiling, float highPerformingFloor, Date createdAt) {
        this.id = id;
        this.schoolYear = schoolYear;
        this.lowPerformingFloor = lowPerformingFloor;
        this.lowPerformingCeiling = lowPerformingCeiling;
        this.averagePerformingFloor = averagePerformingFloor;
        this.averagePerformingCeiling = averagePerformingCeiling;
        this.highPerformingFloor = highPerformingFloor;
        this.createdAt = createdAt;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Date getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(Date schoolYear) {
        this.schoolYear = schoolYear;
    }

    public float getLowPerformingFloor() {
        return lowPerformingFloor;
    }

    public void setLowPerformingFloor(float lowPerformingFloor) {
        this.lowPerformingFloor = lowPerformingFloor;
    }

    public float getLowPerformingCeiling() {
        return lowPerformingCeiling;
    }

    public void setLowPerformingCeiling(float lowPerformingCeiling) {
        this.lowPerformingCeiling = lowPerformingCeiling;
    }

    public float getAveragePerformingFloor() {
        return averagePerformingFloor;
    }

    public void setAveragePerformingFloor(float averagePerformingFloor) {
        this.averagePerformingFloor = averagePerformingFloor;
    }

    public float getAveragePerformingCeiling() {
        return averagePerformingCeiling;
    }

    public void setAveragePerformingCeiling(float averagePerformingCeiling) {
        this.averagePerformingCeiling = averagePerformingCeiling;
    }

    public float getHighPerformingFloor() {
        return highPerformingFloor;
    }

    public void setHighPerformingFloor(float highPerformingFloor) {
        this.highPerformingFloor = highPerformingFloor;
    }

    public Float getHighPerformingCeiling() {
        return highPerformingCeiling;
    }

    public void setHighPerformingCeiling(Float highPerformingCeiling) {
        this.highPerformingCeiling = highPerformingCeiling;
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

    public AssessmentTypes getAssessmentTypeId() {
        return assessmentTypeId;
    }

    public void setAssessmentTypeId(AssessmentTypes assessmentTypeId) {
        this.assessmentTypeId = assessmentTypeId;
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
        if (!(object instanceof AssessmentTypesRubrics)) {
            return false;
        }
        AssessmentTypesRubrics other = (AssessmentTypesRubrics) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.AssessmentTypesRubrics[ id=" + id + " ]";
    }
    
}
