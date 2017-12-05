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
@Table(name = "enrollment_pupil_summary", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"report_history_id", "grade_level_id", "pupil_data_indicator"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnrollmentPupilSummary.findAll", query = "SELECT e FROM EnrollmentPupilSummary e")})
public class EnrollmentPupilSummary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "report_history_id")
    private Integer reportHistoryId;
    @Column(name = "grade_level_id")
    private Short gradeLevelId;
    @Column(name = "pupil_data_indicator")
    private Short pupilDataIndicator;
    private Short male;
    private Short female;
    @Column(name = "level_total")
    private Short levelTotal;
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

    public EnrollmentPupilSummary() {
    }

    public EnrollmentPupilSummary(Integer id) {
        this.id = id;
    }

    public EnrollmentPupilSummary(Integer id, Date createdAt, Date updatedAt) {
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

    public Short getPupilDataIndicator() {
        return pupilDataIndicator;
    }

    public void setPupilDataIndicator(Short pupilDataIndicator) {
        this.pupilDataIndicator = pupilDataIndicator;
    }

    public Short getMale() {
        return male;
    }

    public void setMale(Short male) {
        this.male = male;
    }

    public Short getFemale() {
        return female;
    }

    public void setFemale(Short female) {
        this.female = female;
    }

    public Short getLevelTotal() {
        return levelTotal;
    }

    public void setLevelTotal(Short levelTotal) {
        this.levelTotal = levelTotal;
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
        if (!(object instanceof EnrollmentPupilSummary)) {
            return false;
        }
        EnrollmentPupilSummary other = (EnrollmentPupilSummary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.EnrollmentPupilSummary[ id=" + id + " ]";
    }
    
}
