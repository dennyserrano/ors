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
 * @author ej
 */
@Entity
@Table(name = "learning_outcomes_scores_division", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "LearningOutcomesScoresDivision.findAll", query = "SELECT l FROM LearningOutcomesScoresDivision l")})
public class LearningOutcomesScoresDivision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    private float score;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "division_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefOffice divisionId;
    @JoinColumn(name = "learning_outcome_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private LearningOutcomes learningOutcomeId;
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    @ManyToOne
    private RefCodeSetting subjectId;

    public LearningOutcomesScoresDivision() {
    }

    public LearningOutcomesScoresDivision(Integer id) {
        this.id = id;
    }

    public LearningOutcomesScoresDivision(Integer id, float score, Date createdAt) {
        this.id = id;
        this.score = score;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
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

    public RefOffice getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(RefOffice divisionId) {
        this.divisionId = divisionId;
    }

    public LearningOutcomes getLearningOutcomeId() {
        return learningOutcomeId;
    }

    public void setLearningOutcomeId(LearningOutcomes learningOutcomeId) {
        this.learningOutcomeId = learningOutcomeId;
    }

    public RefCodeSetting getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(RefCodeSetting subjectId) {
        this.subjectId = subjectId;
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
        if (!(object instanceof LearningOutcomesScoresDivision)) {
            return false;
        }
        LearningOutcomesScoresDivision other = (LearningOutcomesScoresDivision) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.LearningOutcomesScoresDivision[ id=" + id + " ]";
    }

}
