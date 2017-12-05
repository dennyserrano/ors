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
@Table(name = "school_distribution_ratio", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"school_id", "sy_from", "distribution_set"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolDistributionRatio.findAll", query = "SELECT s FROM SchoolDistributionRatio s")})
public class SchoolDistributionRatio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "school_id", nullable = false)
    private int schoolId;
    @Basic(optional = false)
    @Column(name = "sy_from", nullable = false)
    private short syFrom;
    @Basic(optional = false)
    @Column(name = "distribution_set", nullable = false)
    private short distributionSet;
    @Basic(optional = false)
    @Column(name = "total_enrolments", nullable = false)
    private int totalEnrolments;
    @Column(name = "total_g1g4enrolments")
    private Integer totalG1g4enrolments;
    @Column(name = "total_g5g6enrolments")
    private Integer totalG5g6enrolments;
    @Basic(optional = false)
    @Column(name = "total_enrolled_sped", nullable = false)
    private int totalEnrolledSped;
    @Basic(optional = false)
    @Column(name = "total_enrolled_preschool", nullable = false)
    private int totalEnrolledPreschool;
    @Basic(optional = false)
    @Column(name = "total_classrooms", nullable = false)
    private short totalClassrooms;
    @Basic(optional = false)
    @Column(name = "total_academic_use", nullable = false)
    private short totalAcademicUse;
    @Basic(optional = false)
    @Column(name = "total_sped_classrooms", nullable = false)
    private short totalSpedClassrooms;
    @Basic(optional = false)
    @Column(name = "total_preschoool_classrooms", nullable = false)
    private short totalPreschooolClassrooms;
    @Basic(optional = false)
    @Column(name = "total_desks", nullable = false)
    private short totalDesks;
    @Basic(optional = false)
    @Column(name = "total_chairtables", nullable = false)
    private short totalChairtables;
    @Basic(optional = false)
    @Column(name = "total_natl_teaching_personnel", nullable = false)
    private short totalNatlTeachingPersonnel;
    @Column(name = "total_natl_teaching_sped")
    private Short totalNatlTeachingSped;
    @Column(name = "total_natl_teaching_preschool")
    private Short totalNatlTeachingPreschool;
    @Basic(optional = false)
    @Column(name = "std_ptr", nullable = false)
    private float stdPtr;
    @Basic(optional = false)
    @Column(name = "std_pfr", nullable = false)
    private float stdPfr;
    @Basic(optional = false)
    @Column(name = "std_pcr", nullable = false)
    private float stdPcr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "std_pcr_academic", precision = 12)
    private Float stdPcrAcademic;
    @Basic(optional = false)
    @Column(name = "std_pcr_academic_rainbow_spectrum_id", nullable = false)
    private short stdPcrAcademicRainbowSpectrumId;
    @Column(name = "created_by")
    private Integer createdBy;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "updated_by")
    private Integer updatedBy;
    @Column(name = "wa_total_enrolments")
    private Integer waTotalEnrolments;
    @Column(name = "wa_total_g1g4enrolments")
    private Integer waTotalG1g4enrolments;
    @Column(name = "wa_total_g5g6enrolments")
    private Integer waTotalG5g6enrolments;
    @Column(name = "wa_total_enrolled_sped")
    private Integer waTotalEnrolledSped;
    @Column(name = "wa_total_enrolled_preschool")
    private Integer waTotalEnrolledPreschool;
    @Column(name = "wa_total_classrooms")
    private Integer waTotalClassrooms;
    @Column(name = "wa_total_academic_use")
    private Integer waTotalAcademicUse;
    @Column(name = "wa_total_sped_classrooms")
    private Integer waTotalSpedClassrooms;
    @Column(name = "wa_total_preschoool_classrooms")
    private Integer waTotalPreschooolClassrooms;
    @Column(name = "wa_total_desks")
    private Integer waTotalDesks;
    @Column(name = "wa_total_chairtablesint")
    private Integer waTotalChairtablesint;
    @Column(name = "wa_total_natl_teaching_personnel")
    private Integer waTotalNatlTeachingPersonnel;
    @Column(name = "wa_total_natl_teaching_sped")
    private Integer waTotalNatlTeachingSped;
    @Column(name = "wa_total_natl_teaching_preschool")
    private Integer waTotalNatlTeachingPreschool;
    @Column(name = "wa_std_ptr_rainbow_spectrum_id")
    private Short waStdPtrRainbowSpectrumId;
    @Column(name = "wa_std_ptr", precision = 12)
    private Float waStdPtr;
    @Column(name = "wa_std_pfr_rainbow_spectrum_id")
    private Short waStdPfrRainbowSpectrumId;
    @Column(name = "wa_std_pfr", precision = 12)
    private Float waStdPfr;
    @Column(name = "wa_std_pcr_rainbow_spectrum_id")
    private Short waStdPcrRainbowSpectrumId;
    @Column(name = "wa_std_pcr_academic_rainbow_spectrum_id")
    private Short waStdPcrAcademicRainbowSpectrumId;
    @Column(name = "wa_std_pcr_academic", precision = 12)
    private Float waStdPcrAcademic;
    @Column(name = "wa_std_pcr", precision = 12)
    private Float waStdPcr;
    @JoinColumn(name = "std_pcr_rainbow_spectrum_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RainbowSpectrum stdPcrRainbowSpectrumId;
    @JoinColumn(name = "std_pfr_rainbow_spectrum_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RainbowSpectrum stdPfrRainbowSpectrumId;
    @JoinColumn(name = "std_ptr_rainbow_spectrum_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RainbowSpectrum stdPtrRainbowSpectrumId;

    public SchoolDistributionRatio() {
    }

    public SchoolDistributionRatio(Integer id) {
        this.id = id;
    }

    public SchoolDistributionRatio(Integer id, int schoolId, short syFrom, short distributionSet, int totalEnrolments, int totalEnrolledSped, int totalEnrolledPreschool, short totalClassrooms, short totalAcademicUse, short totalSpedClassrooms, short totalPreschooolClassrooms, short totalDesks, short totalChairtables, short totalNatlTeachingPersonnel, float stdPtr, float stdPfr, float stdPcr, short stdPcrAcademicRainbowSpectrumId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.schoolId = schoolId;
        this.syFrom = syFrom;
        this.distributionSet = distributionSet;
        this.totalEnrolments = totalEnrolments;
        this.totalEnrolledSped = totalEnrolledSped;
        this.totalEnrolledPreschool = totalEnrolledPreschool;
        this.totalClassrooms = totalClassrooms;
        this.totalAcademicUse = totalAcademicUse;
        this.totalSpedClassrooms = totalSpedClassrooms;
        this.totalPreschooolClassrooms = totalPreschooolClassrooms;
        this.totalDesks = totalDesks;
        this.totalChairtables = totalChairtables;
        this.totalNatlTeachingPersonnel = totalNatlTeachingPersonnel;
        this.stdPtr = stdPtr;
        this.stdPfr = stdPfr;
        this.stdPcr = stdPcr;
        this.stdPcrAcademicRainbowSpectrumId = stdPcrAcademicRainbowSpectrumId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public short getSyFrom() {
        return syFrom;
    }

    public void setSyFrom(short syFrom) {
        this.syFrom = syFrom;
    }

    public short getDistributionSet() {
        return distributionSet;
    }

    public void setDistributionSet(short distributionSet) {
        this.distributionSet = distributionSet;
    }

    public int getTotalEnrolments() {
        return totalEnrolments;
    }

    public void setTotalEnrolments(int totalEnrolments) {
        this.totalEnrolments = totalEnrolments;
    }

    public Integer getTotalG1g4enrolments() {
        return totalG1g4enrolments;
    }

    public void setTotalG1g4enrolments(Integer totalG1g4enrolments) {
        this.totalG1g4enrolments = totalG1g4enrolments;
    }

    public Integer getTotalG5g6enrolments() {
        return totalG5g6enrolments;
    }

    public void setTotalG5g6enrolments(Integer totalG5g6enrolments) {
        this.totalG5g6enrolments = totalG5g6enrolments;
    }

    public int getTotalEnrolledSped() {
        return totalEnrolledSped;
    }

    public void setTotalEnrolledSped(int totalEnrolledSped) {
        this.totalEnrolledSped = totalEnrolledSped;
    }

    public int getTotalEnrolledPreschool() {
        return totalEnrolledPreschool;
    }

    public void setTotalEnrolledPreschool(int totalEnrolledPreschool) {
        this.totalEnrolledPreschool = totalEnrolledPreschool;
    }

    public short getTotalClassrooms() {
        return totalClassrooms;
    }

    public void setTotalClassrooms(short totalClassrooms) {
        this.totalClassrooms = totalClassrooms;
    }

    public short getTotalAcademicUse() {
        return totalAcademicUse;
    }

    public void setTotalAcademicUse(short totalAcademicUse) {
        this.totalAcademicUse = totalAcademicUse;
    }

    public short getTotalSpedClassrooms() {
        return totalSpedClassrooms;
    }

    public void setTotalSpedClassrooms(short totalSpedClassrooms) {
        this.totalSpedClassrooms = totalSpedClassrooms;
    }

    public short getTotalPreschooolClassrooms() {
        return totalPreschooolClassrooms;
    }

    public void setTotalPreschooolClassrooms(short totalPreschooolClassrooms) {
        this.totalPreschooolClassrooms = totalPreschooolClassrooms;
    }

    public short getTotalDesks() {
        return totalDesks;
    }

    public void setTotalDesks(short totalDesks) {
        this.totalDesks = totalDesks;
    }

    public short getTotalChairtables() {
        return totalChairtables;
    }

    public void setTotalChairtables(short totalChairtables) {
        this.totalChairtables = totalChairtables;
    }

    public short getTotalNatlTeachingPersonnel() {
        return totalNatlTeachingPersonnel;
    }

    public void setTotalNatlTeachingPersonnel(short totalNatlTeachingPersonnel) {
        this.totalNatlTeachingPersonnel = totalNatlTeachingPersonnel;
    }

    public Short getTotalNatlTeachingSped() {
        return totalNatlTeachingSped;
    }

    public void setTotalNatlTeachingSped(Short totalNatlTeachingSped) {
        this.totalNatlTeachingSped = totalNatlTeachingSped;
    }

    public Short getTotalNatlTeachingPreschool() {
        return totalNatlTeachingPreschool;
    }

    public void setTotalNatlTeachingPreschool(Short totalNatlTeachingPreschool) {
        this.totalNatlTeachingPreschool = totalNatlTeachingPreschool;
    }

    public float getStdPtr() {
        return stdPtr;
    }

    public void setStdPtr(float stdPtr) {
        this.stdPtr = stdPtr;
    }

    public float getStdPfr() {
        return stdPfr;
    }

    public void setStdPfr(float stdPfr) {
        this.stdPfr = stdPfr;
    }

    public float getStdPcr() {
        return stdPcr;
    }

    public void setStdPcr(float stdPcr) {
        this.stdPcr = stdPcr;
    }

    public Float getStdPcrAcademic() {
        return stdPcrAcademic;
    }

    public void setStdPcrAcademic(Float stdPcrAcademic) {
        this.stdPcrAcademic = stdPcrAcademic;
    }

    public short getStdPcrAcademicRainbowSpectrumId() {
        return stdPcrAcademicRainbowSpectrumId;
    }

    public void setStdPcrAcademicRainbowSpectrumId(short stdPcrAcademicRainbowSpectrumId) {
        this.stdPcrAcademicRainbowSpectrumId = stdPcrAcademicRainbowSpectrumId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
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

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getWaTotalEnrolments() {
        return waTotalEnrolments;
    }

    public void setWaTotalEnrolments(Integer waTotalEnrolments) {
        this.waTotalEnrolments = waTotalEnrolments;
    }

    public Integer getWaTotalG1g4enrolments() {
        return waTotalG1g4enrolments;
    }

    public void setWaTotalG1g4enrolments(Integer waTotalG1g4enrolments) {
        this.waTotalG1g4enrolments = waTotalG1g4enrolments;
    }

    public Integer getWaTotalG5g6enrolments() {
        return waTotalG5g6enrolments;
    }

    public void setWaTotalG5g6enrolments(Integer waTotalG5g6enrolments) {
        this.waTotalG5g6enrolments = waTotalG5g6enrolments;
    }

    public Integer getWaTotalEnrolledSped() {
        return waTotalEnrolledSped;
    }

    public void setWaTotalEnrolledSped(Integer waTotalEnrolledSped) {
        this.waTotalEnrolledSped = waTotalEnrolledSped;
    }

    public Integer getWaTotalEnrolledPreschool() {
        return waTotalEnrolledPreschool;
    }

    public void setWaTotalEnrolledPreschool(Integer waTotalEnrolledPreschool) {
        this.waTotalEnrolledPreschool = waTotalEnrolledPreschool;
    }

    public Integer getWaTotalClassrooms() {
        return waTotalClassrooms;
    }

    public void setWaTotalClassrooms(Integer waTotalClassrooms) {
        this.waTotalClassrooms = waTotalClassrooms;
    }

    public Integer getWaTotalAcademicUse() {
        return waTotalAcademicUse;
    }

    public void setWaTotalAcademicUse(Integer waTotalAcademicUse) {
        this.waTotalAcademicUse = waTotalAcademicUse;
    }

    public Integer getWaTotalSpedClassrooms() {
        return waTotalSpedClassrooms;
    }

    public void setWaTotalSpedClassrooms(Integer waTotalSpedClassrooms) {
        this.waTotalSpedClassrooms = waTotalSpedClassrooms;
    }

    public Integer getWaTotalPreschooolClassrooms() {
        return waTotalPreschooolClassrooms;
    }

    public void setWaTotalPreschooolClassrooms(Integer waTotalPreschooolClassrooms) {
        this.waTotalPreschooolClassrooms = waTotalPreschooolClassrooms;
    }

    public Integer getWaTotalDesks() {
        return waTotalDesks;
    }

    public void setWaTotalDesks(Integer waTotalDesks) {
        this.waTotalDesks = waTotalDesks;
    }

    public Integer getWaTotalChairtablesint() {
        return waTotalChairtablesint;
    }

    public void setWaTotalChairtablesint(Integer waTotalChairtablesint) {
        this.waTotalChairtablesint = waTotalChairtablesint;
    }

    public Integer getWaTotalNatlTeachingPersonnel() {
        return waTotalNatlTeachingPersonnel;
    }

    public void setWaTotalNatlTeachingPersonnel(Integer waTotalNatlTeachingPersonnel) {
        this.waTotalNatlTeachingPersonnel = waTotalNatlTeachingPersonnel;
    }

    public Integer getWaTotalNatlTeachingSped() {
        return waTotalNatlTeachingSped;
    }

    public void setWaTotalNatlTeachingSped(Integer waTotalNatlTeachingSped) {
        this.waTotalNatlTeachingSped = waTotalNatlTeachingSped;
    }

    public Integer getWaTotalNatlTeachingPreschool() {
        return waTotalNatlTeachingPreschool;
    }

    public void setWaTotalNatlTeachingPreschool(Integer waTotalNatlTeachingPreschool) {
        this.waTotalNatlTeachingPreschool = waTotalNatlTeachingPreschool;
    }

    public Short getWaStdPtrRainbowSpectrumId() {
        return waStdPtrRainbowSpectrumId;
    }

    public void setWaStdPtrRainbowSpectrumId(Short waStdPtrRainbowSpectrumId) {
        this.waStdPtrRainbowSpectrumId = waStdPtrRainbowSpectrumId;
    }

    public Float getWaStdPtr() {
        return waStdPtr;
    }

    public void setWaStdPtr(Float waStdPtr) {
        this.waStdPtr = waStdPtr;
    }

    public Short getWaStdPfrRainbowSpectrumId() {
        return waStdPfrRainbowSpectrumId;
    }

    public void setWaStdPfrRainbowSpectrumId(Short waStdPfrRainbowSpectrumId) {
        this.waStdPfrRainbowSpectrumId = waStdPfrRainbowSpectrumId;
    }

    public Float getWaStdPfr() {
        return waStdPfr;
    }

    public void setWaStdPfr(Float waStdPfr) {
        this.waStdPfr = waStdPfr;
    }

    public Short getWaStdPcrRainbowSpectrumId() {
        return waStdPcrRainbowSpectrumId;
    }

    public void setWaStdPcrRainbowSpectrumId(Short waStdPcrRainbowSpectrumId) {
        this.waStdPcrRainbowSpectrumId = waStdPcrRainbowSpectrumId;
    }

    public Short getWaStdPcrAcademicRainbowSpectrumId() {
        return waStdPcrAcademicRainbowSpectrumId;
    }

    public void setWaStdPcrAcademicRainbowSpectrumId(Short waStdPcrAcademicRainbowSpectrumId) {
        this.waStdPcrAcademicRainbowSpectrumId = waStdPcrAcademicRainbowSpectrumId;
    }

    public Float getWaStdPcrAcademic() {
        return waStdPcrAcademic;
    }

    public void setWaStdPcrAcademic(Float waStdPcrAcademic) {
        this.waStdPcrAcademic = waStdPcrAcademic;
    }

    public Float getWaStdPcr() {
        return waStdPcr;
    }

    public void setWaStdPcr(Float waStdPcr) {
        this.waStdPcr = waStdPcr;
    }

    public RainbowSpectrum getStdPcrRainbowSpectrumId() {
        return stdPcrRainbowSpectrumId;
    }

    public void setStdPcrRainbowSpectrumId(RainbowSpectrum stdPcrRainbowSpectrumId) {
        this.stdPcrRainbowSpectrumId = stdPcrRainbowSpectrumId;
    }

    public RainbowSpectrum getStdPfrRainbowSpectrumId() {
        return stdPfrRainbowSpectrumId;
    }

    public void setStdPfrRainbowSpectrumId(RainbowSpectrum stdPfrRainbowSpectrumId) {
        this.stdPfrRainbowSpectrumId = stdPfrRainbowSpectrumId;
    }

    public RainbowSpectrum getStdPtrRainbowSpectrumId() {
        return stdPtrRainbowSpectrumId;
    }

    public void setStdPtrRainbowSpectrumId(RainbowSpectrum stdPtrRainbowSpectrumId) {
        this.stdPtrRainbowSpectrumId = stdPtrRainbowSpectrumId;
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
        if (!(object instanceof SchoolDistributionRatio)) {
            return false;
        }
        SchoolDistributionRatio other = (SchoolDistributionRatio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.SchoolDistributionRatio[ id=" + id + " ]";
    }
    
}
