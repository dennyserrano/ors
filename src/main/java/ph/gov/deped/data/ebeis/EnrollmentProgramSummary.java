/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

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
@Table(name = "enrollment_program_summary", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"report_history_id", "category_id", "grade_level_id", "programs_offered_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnrollmentProgramSummary.findAll", query = "SELECT e FROM EnrollmentProgramSummary e")})
public class EnrollmentProgramSummary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "category_id")
    private Short categoryId;
    @Column(name = "grade_level_id")
    private Short gradeLevelId;
    @Column(name = "programs_offered_id")
    private Integer programsOfferedId;
    @Column(name = "enrolled_male")
    private Integer enrolledMale;
    @Column(name = "enrolled_female")
    private Integer enrolledFemale;
    @Column(name = "program_id")
    private Integer programId;
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

    public EnrollmentProgramSummary() {
    }

    public EnrollmentProgramSummary(Integer id) {
        this.id = id;
    }

    public EnrollmentProgramSummary(Integer id, Date createdAt, Date updatedAt) {
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

    public Short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Short categoryId) {
        this.categoryId = categoryId;
    }

    public Short getGradeLevelId() {
        return gradeLevelId;
    }

    public void setGradeLevelId(Short gradeLevelId) {
        this.gradeLevelId = gradeLevelId;
    }

    public Integer getProgramsOfferedId() {
        return programsOfferedId;
    }

    public void setProgramsOfferedId(Integer programsOfferedId) {
        this.programsOfferedId = programsOfferedId;
    }

    public Integer getEnrolledMale() {
        return enrolledMale;
    }

    public void setEnrolledMale(Integer enrolledMale) {
        this.enrolledMale = enrolledMale;
    }

    public Integer getEnrolledFemale() {
        return enrolledFemale;
    }

    public void setEnrolledFemale(Integer enrolledFemale) {
        this.enrolledFemale = enrolledFemale;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
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
        if (!(object instanceof EnrollmentProgramSummary)) {
            return false;
        }
        EnrollmentProgramSummary other = (EnrollmentProgramSummary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.EnrollmentProgramSummary[ id=" + id + " ]";
    }
    
}
