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
@Table(name = "enrollment_age_summary_journal", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"report_history_id", "grade_level_id", "age_category_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnrollmentAgeSummaryJournal.findAll", query = "SELECT e FROM EnrollmentAgeSummaryJournal e")})
public class EnrollmentAgeSummaryJournal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "eas_id", nullable = false)
    private int easId;
    @Column(name = "report_history_id")
    private Integer reportHistoryId;
    @Column(name = "grade_level_id")
    private Short gradeLevelId;
    @Column(name = "age_category_id")
    private Short ageCategoryId;
    @Column(name = "enroll_male")
    private Short enrollMale;
    @Column(name = "enroll_female")
    private Short enrollFemale;
    @Basic(optional = false)
    @Column(name = "eas_created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date easCreatedAt;
    @Column(name = "eas_created_by")
    private Integer easCreatedBy;
    @Basic(optional = false)
    @Column(name = "eas_updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date easUpdatedAt;
    @Column(name = "eas_updated_by")
    private Integer easUpdatedBy;
    @Basic(optional = false)
    @Column(name = "deleted_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    @Column(name = "deleted_by")
    private Integer deletedBy;

    public EnrollmentAgeSummaryJournal() {
    }

    public EnrollmentAgeSummaryJournal(Integer id) {
        this.id = id;
    }

    public EnrollmentAgeSummaryJournal(Integer id, int easId, Date easCreatedAt, Date easUpdatedAt, Date deletedAt) {
        this.id = id;
        this.easId = easId;
        this.easCreatedAt = easCreatedAt;
        this.easUpdatedAt = easUpdatedAt;
        this.deletedAt = deletedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEasId() {
        return easId;
    }

    public void setEasId(int easId) {
        this.easId = easId;
    }

    public Integer getReportHistoryId() {
        return reportHistoryId;
    }

    public void setReportHistoryId(Integer reportHistoryId) {
        this.reportHistoryId = reportHistoryId;
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

    public Date getEasCreatedAt() {
        return easCreatedAt;
    }

    public void setEasCreatedAt(Date easCreatedAt) {
        this.easCreatedAt = easCreatedAt;
    }

    public Integer getEasCreatedBy() {
        return easCreatedBy;
    }

    public void setEasCreatedBy(Integer easCreatedBy) {
        this.easCreatedBy = easCreatedBy;
    }

    public Date getEasUpdatedAt() {
        return easUpdatedAt;
    }

    public void setEasUpdatedAt(Date easUpdatedAt) {
        this.easUpdatedAt = easUpdatedAt;
    }

    public Integer getEasUpdatedBy() {
        return easUpdatedBy;
    }

    public void setEasUpdatedBy(Integer easUpdatedBy) {
        this.easUpdatedBy = easUpdatedBy;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
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
        if (!(object instanceof EnrollmentAgeSummaryJournal)) {
            return false;
        }
        EnrollmentAgeSummaryJournal other = (EnrollmentAgeSummaryJournal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.EnrollmentAgeSummaryJournal[ id=" + id + " ]";
    }
    
}
