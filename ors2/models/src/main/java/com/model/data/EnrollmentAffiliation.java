/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model.data;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "enrollment_affiliation", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnrollmentAffiliation.findAll", query = "SELECT e FROM EnrollmentAffiliation e")})
public class EnrollmentAffiliation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ethnic_code_id", nullable = false)
    private long ethnicCodeId;
    @Basic(optional = false)
    @Column(name = "report_year", nullable = false)
    private int reportYear;
    @Basic(optional = false)
    @Column(name = "enrolled_male", nullable = false)
    private int enrolledMale;
    @Basic(optional = false)
    @Column(name = "enrolled_female", nullable = false)
    private int enrolledFemale;
    @JoinColumn(name = "school_id", referencedColumnName = "id")
    @ManyToOne
    private School schoolId;
    @JoinColumn(name = "level_id", referencedColumnName = "id")
    @ManyToOne
    private Level levelId;

    public EnrollmentAffiliation() {
    }

    public EnrollmentAffiliation(Integer id) {
        this.id = id;
    }

    public EnrollmentAffiliation(Integer id, long ethnicCodeId, int reportYear, int enrolledMale, int enrolledFemale) {
        this.id = id;
        this.ethnicCodeId = ethnicCodeId;
        this.reportYear = reportYear;
        this.enrolledMale = enrolledMale;
        this.enrolledFemale = enrolledFemale;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getEthnicCodeId() {
        return ethnicCodeId;
    }

    public void setEthnicCodeId(long ethnicCodeId) {
        this.ethnicCodeId = ethnicCodeId;
    }

    public int getReportYear() {
        return reportYear;
    }

    public void setReportYear(int reportYear) {
        this.reportYear = reportYear;
    }

    public int getEnrolledMale() {
        return enrolledMale;
    }

    public void setEnrolledMale(int enrolledMale) {
        this.enrolledMale = enrolledMale;
    }

    public int getEnrolledFemale() {
        return enrolledFemale;
    }

    public void setEnrolledFemale(int enrolledFemale) {
        this.enrolledFemale = enrolledFemale;
    }

    public School getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(School schoolId) {
        this.schoolId = schoolId;
    }

    public Level getLevelId() {
        return levelId;
    }

    public void setLevelId(Level levelId) {
        this.levelId = levelId;
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
        if (!(object instanceof EnrollmentAffiliation)) {
            return false;
        }
        EnrollmentAffiliation other = (EnrollmentAffiliation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.EnrollmentAffiliation[ id=" + id + " ]";
    }
    
}
