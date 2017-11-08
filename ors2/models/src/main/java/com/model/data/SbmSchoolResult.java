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
@Table(name = "sbm_school_result", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SbmSchoolResult.findAll", query = "SELECT s FROM SbmSchoolResult s")})
public class SbmSchoolResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "assessment_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date assessmentDate;
    @Column(name = "sbm_mov_id")
    private Integer sbmMovId;
    @Column(name = "sbm_indicator_id")
    private Integer sbmIndicatorId;
    @Column(name = "sbm_assessment_id")
    private Integer sbmAssessmentId;
    @Column(name = "sbm_dimension_id")
    private Integer sbmDimensionId;
    private Integer level;
    @Basic(optional = false)
    @Column(nullable = false)
    private int result;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "school_id", referencedColumnName = "id")
    @ManyToOne
    private School schoolId;

    public SbmSchoolResult() {
    }

    public SbmSchoolResult(Integer id) {
        this.id = id;
    }

    public SbmSchoolResult(Integer id, Date assessmentDate, int result, Date createdAt, Date updatedAt) {
        this.id = id;
        this.assessmentDate = assessmentDate;
        this.result = result;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(Date assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public Integer getSbmMovId() {
        return sbmMovId;
    }

    public void setSbmMovId(Integer sbmMovId) {
        this.sbmMovId = sbmMovId;
    }

    public Integer getSbmIndicatorId() {
        return sbmIndicatorId;
    }

    public void setSbmIndicatorId(Integer sbmIndicatorId) {
        this.sbmIndicatorId = sbmIndicatorId;
    }

    public Integer getSbmAssessmentId() {
        return sbmAssessmentId;
    }

    public void setSbmAssessmentId(Integer sbmAssessmentId) {
        this.sbmAssessmentId = sbmAssessmentId;
    }

    public Integer getSbmDimensionId() {
        return sbmDimensionId;
    }

    public void setSbmDimensionId(Integer sbmDimensionId) {
        this.sbmDimensionId = sbmDimensionId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
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

    public School getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(School schoolId) {
        this.schoolId = schoolId;
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
        if (!(object instanceof SbmSchoolResult)) {
            return false;
        }
        SbmSchoolResult other = (SbmSchoolResult) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.SbmSchoolResult[ id=" + id + " ]";
    }
    
}
