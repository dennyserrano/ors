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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "enrollment_age_summary", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"report_history_id", "grade_level_id", "age_category_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnrollmentAgeSummary.findAll", query = "SELECT e FROM EnrollmentAgeSummary e")})
public class EnrollmentAgeSummary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "grade_level_id")
    private Short gradeLevelId;
    @Column(name = "age_category_id")
    private Short ageCategoryId;
    @Column(name = "enroll_male")
    private Short enrollMale;
    @Column(name = "enroll_female")
    private Short enrollFemale;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
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
    @JoinColumn(name = "report_history_id", referencedColumnName = "id")
    @ManyToOne
    private ReportHistory reportHistoryId;

    public EnrollmentAgeSummary() {
    }

    public EnrollmentAgeSummary(Integer id) {
        this.id = id;
    }

    public EnrollmentAgeSummary(Integer id, Date createdAt, Date updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getGradeLevelId() {
        return gradeLevelId;
    }

    public void setGradeLevelId(Short gradeLevelId) {
        this.gradeLevelId = gradeLevelId;
    }

    public Short getAgeCategoryId() {
        return ageCategoryId;
    }

    public void setAgeCategoryId(Short ageCategoryId) {
        this.ageCategoryId = ageCategoryId;
    }

    public Short getEnrollMale() {
        return enrollMale;
    }

    public void setEnrollMale(Short enrollMale) {
        this.enrollMale = enrollMale;
    }

    public Short getEnrollFemale() {
        return enrollFemale;
    }

    public void setEnrollFemale(Short enrollFemale) {
        this.enrollFemale = enrollFemale;
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

    public ReportHistory getReportHistoryId() {
        return reportHistoryId;
    }

    public void setReportHistoryId(ReportHistory reportHistoryId) {
        this.reportHistoryId = reportHistoryId;
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
        if (!(object instanceof EnrollmentAgeSummary)) {
            return false;
        }
        EnrollmentAgeSummary other = (EnrollmentAgeSummary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.EnrollmentAgeSummary[ id=" + id + " ]";
    }
    
}
