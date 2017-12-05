/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model.data;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "learning_outcomes", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LearningOutcomes.findAll", query = "SELECT l FROM LearningOutcomes l")})
public class LearningOutcomes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "file_name", nullable = false, length = 255)
    private String fileName;
    @Basic(optional = false)
    @Column(name = "school_year", nullable = false, length = 50)
    private String schoolYear;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinTable(name = "learning_outcomes_subjects", joinColumns = {
        @JoinColumn(name = "learning_outcome_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "subject_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<RefCodeSetting> refCodeSettingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "learningOutcomeId")
    private List<LearningOutcomesScoresRegion> learningOutcomesScoresRegionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "learningOutcomeId")
    private List<LearningOutcomesScores> learningOutcomesScoresList;
    @JoinColumn(name = "assessment_type_id", referencedColumnName = "id")
    @ManyToOne
    private AssessmentTypes assessmentTypeId;
    @JoinColumn(name = "assessment_level_id", referencedColumnName = "id")
    @ManyToOne
    private AssessmentLevels assessmentLevelId;
    @JoinColumn(name = "level_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Level levelId;
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    @ManyToOne
    private RefOffice regionId;
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    @ManyToOne
    private RefOffice divisionId;
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    @ManyToOne
    private RefOffice districtId;

    public LearningOutcomes() {
    }

    public LearningOutcomes(Integer id) {
        this.id = id;
    }

    public LearningOutcomes(Integer id, String fileName, String schoolYear, Date createdAt) {
        this.id = id;
        this.fileName = fileName;
        this.schoolYear = schoolYear;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
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

    @XmlTransient
    public List<RefCodeSetting> getRefCodeSettingList() {
        return refCodeSettingList;
    }

    public void setRefCodeSettingList(List<RefCodeSetting> refCodeSettingList) {
        this.refCodeSettingList = refCodeSettingList;
    }

    @XmlTransient
    public List<LearningOutcomesScoresRegion> getLearningOutcomesScoresRegionList() {
        return learningOutcomesScoresRegionList;
    }

    public void setLearningOutcomesScoresRegionList(List<LearningOutcomesScoresRegion> learningOutcomesScoresRegionList) {
        this.learningOutcomesScoresRegionList = learningOutcomesScoresRegionList;
    }

    @XmlTransient
    public List<LearningOutcomesScores> getLearningOutcomesScoresList() {
        return learningOutcomesScoresList;
    }

    public void setLearningOutcomesScoresList(List<LearningOutcomesScores> learningOutcomesScoresList) {
        this.learningOutcomesScoresList = learningOutcomesScoresList;
    }

    public AssessmentTypes getAssessmentTypeId() {
        return assessmentTypeId;
    }

    public void setAssessmentTypeId(AssessmentTypes assessmentTypeId) {
        this.assessmentTypeId = assessmentTypeId;
    }

    public AssessmentLevels getAssessmentLevelId() {
        return assessmentLevelId;
    }

    public void setAssessmentLevelId(AssessmentLevels assessmentLevelId) {
        this.assessmentLevelId = assessmentLevelId;
    }

    public Level getLevelId() {
        return levelId;
    }

    public void setLevelId(Level levelId) {
        this.levelId = levelId;
    }

    public RefOffice getRegionId() {
        return regionId;
    }

    public void setRegionId(RefOffice regionId) {
        this.regionId = regionId;
    }

    public RefOffice getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(RefOffice divisionId) {
        this.divisionId = divisionId;
    }

    public RefOffice getDistrictId() {
        return districtId;
    }

    public void setDistrictId(RefOffice districtId) {
        this.districtId = districtId;
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
        if (!(object instanceof LearningOutcomes)) {
            return false;
        }
        LearningOutcomes other = (LearningOutcomes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.LearningOutcomes[ id=" + id + " ]";
    }
    
}
