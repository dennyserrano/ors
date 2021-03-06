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
@Table(name = "personnel_position_summary", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"report_history_id", "position_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonnelPositionSummary.findAll", query = "SELECT p FROM PersonnelPositionSummary p")})
public class PersonnelPositionSummary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "report_history_id", nullable = false)
    private int reportHistoryId;
    @Column(name = "tot_plantilla_items")
    private Integer totPlantillaItems;
    @Column(name = "actual_male")
    private Integer actualMale;
    @Column(name = "actual_female")
    private Integer actualFemale;
    @Column(name = "on_leave_male")
    private Integer onLeaveMale;
    @Column(name = "on_leave_female")
    private Integer onLeaveFemale;
    @Column(name = "tot_onleave")
    private Integer totOnleave;
    @Column(name = "detailed_male")
    private Integer detailedMale;
    @Column(name = "detailed_female")
    private Integer detailedFemale;
    @Column(name = "detailed_admin_teachers")
    private Integer detailedAdminTeachers;
    @Column(name = "ft_teaching")
    private Integer ftTeaching;
    @Column(name = "ft_part_ancillary")
    private Integer ftPartAncillary;
    @Column(name = "pt_200_more")
    private Integer pt200More;
    @Column(name = "pt_less_200")
    private Integer ptLess200;
    @Column(name = "ft_ancillary")
    private Integer ftAncillary;
    @Column(name = "in_school_male")
    private Integer inSchoolMale;
    @Column(name = "in_school_female")
    private Integer inSchoolFemale;
    @Column(name = "tot_plantilla_vacant")
    private Integer totPlantillaVacant;
    @Column(name = "borrowed_male_admin_teacher")
    private Integer borrowedMaleAdminTeacher;
    @Column(name = "borrowed_female_admin_teacher")
    private Integer borrowedFemaleAdminTeacher;
    @Column(name = "detailed_within_office")
    private Integer detailedWithinOffice;
    @Column(name = "detailed_outside_office")
    private Integer detailedOutsideOffice;
    @Column(name = "detailed_school")
    private Integer detailedSchool;
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
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    @ManyToOne
    private RefPosition positionId;

    public PersonnelPositionSummary() {
    }

    public PersonnelPositionSummary(Integer id) {
        this.id = id;
    }

    public PersonnelPositionSummary(Integer id, int reportHistoryId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.reportHistoryId = reportHistoryId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getReportHistoryId() {
        return reportHistoryId;
    }

    public void setReportHistoryId(int reportHistoryId) {
        this.reportHistoryId = reportHistoryId;
    }

    public Integer getTotPlantillaItems() {
        return totPlantillaItems;
    }

    public void setTotPlantillaItems(Integer totPlantillaItems) {
        this.totPlantillaItems = totPlantillaItems;
    }

    public Integer getActualMale() {
        return actualMale;
    }

    public void setActualMale(Integer actualMale) {
        this.actualMale = actualMale;
    }

    public Integer getActualFemale() {
        return actualFemale;
    }

    public void setActualFemale(Integer actualFemale) {
        this.actualFemale = actualFemale;
    }

    public Integer getOnLeaveMale() {
        return onLeaveMale;
    }

    public void setOnLeaveMale(Integer onLeaveMale) {
        this.onLeaveMale = onLeaveMale;
    }

    public Integer getOnLeaveFemale() {
        return onLeaveFemale;
    }

    public void setOnLeaveFemale(Integer onLeaveFemale) {
        this.onLeaveFemale = onLeaveFemale;
    }

    public Integer getTotOnleave() {
        return totOnleave;
    }

    public void setTotOnleave(Integer totOnleave) {
        this.totOnleave = totOnleave;
    }

    public Integer getDetailedMale() {
        return detailedMale;
    }

    public void setDetailedMale(Integer detailedMale) {
        this.detailedMale = detailedMale;
    }

    public Integer getDetailedFemale() {
        return detailedFemale;
    }

    public void setDetailedFemale(Integer detailedFemale) {
        this.detailedFemale = detailedFemale;
    }

    public Integer getDetailedAdminTeachers() {
        return detailedAdminTeachers;
    }

    public void setDetailedAdminTeachers(Integer detailedAdminTeachers) {
        this.detailedAdminTeachers = detailedAdminTeachers;
    }

    public Integer getFtTeaching() {
        return ftTeaching;
    }

    public void setFtTeaching(Integer ftTeaching) {
        this.ftTeaching = ftTeaching;
    }

    public Integer getFtPartAncillary() {
        return ftPartAncillary;
    }

    public void setFtPartAncillary(Integer ftPartAncillary) {
        this.ftPartAncillary = ftPartAncillary;
    }

    public Integer getPt200More() {
        return pt200More;
    }

    public void setPt200More(Integer pt200More) {
        this.pt200More = pt200More;
    }

    public Integer getPtLess200() {
        return ptLess200;
    }

    public void setPtLess200(Integer ptLess200) {
        this.ptLess200 = ptLess200;
    }

    public Integer getFtAncillary() {
        return ftAncillary;
    }

    public void setFtAncillary(Integer ftAncillary) {
        this.ftAncillary = ftAncillary;
    }

    public Integer getInSchoolMale() {
        return inSchoolMale;
    }

    public void setInSchoolMale(Integer inSchoolMale) {
        this.inSchoolMale = inSchoolMale;
    }

    public Integer getInSchoolFemale() {
        return inSchoolFemale;
    }

    public void setInSchoolFemale(Integer inSchoolFemale) {
        this.inSchoolFemale = inSchoolFemale;
    }

    public Integer getTotPlantillaVacant() {
        return totPlantillaVacant;
    }

    public void setTotPlantillaVacant(Integer totPlantillaVacant) {
        this.totPlantillaVacant = totPlantillaVacant;
    }

    public Integer getBorrowedMaleAdminTeacher() {
        return borrowedMaleAdminTeacher;
    }

    public void setBorrowedMaleAdminTeacher(Integer borrowedMaleAdminTeacher) {
        this.borrowedMaleAdminTeacher = borrowedMaleAdminTeacher;
    }

    public Integer getBorrowedFemaleAdminTeacher() {
        return borrowedFemaleAdminTeacher;
    }

    public void setBorrowedFemaleAdminTeacher(Integer borrowedFemaleAdminTeacher) {
        this.borrowedFemaleAdminTeacher = borrowedFemaleAdminTeacher;
    }

    public Integer getDetailedWithinOffice() {
        return detailedWithinOffice;
    }

    public void setDetailedWithinOffice(Integer detailedWithinOffice) {
        this.detailedWithinOffice = detailedWithinOffice;
    }

    public Integer getDetailedOutsideOffice() {
        return detailedOutsideOffice;
    }

    public void setDetailedOutsideOffice(Integer detailedOutsideOffice) {
        this.detailedOutsideOffice = detailedOutsideOffice;
    }

    public Integer getDetailedSchool() {
        return detailedSchool;
    }

    public void setDetailedSchool(Integer detailedSchool) {
        this.detailedSchool = detailedSchool;
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

    public RefPosition getPositionId() {
        return positionId;
    }

    public void setPositionId(RefPosition positionId) {
        this.positionId = positionId;
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
        if (!(object instanceof PersonnelPositionSummary)) {
            return false;
        }
        PersonnelPositionSummary other = (PersonnelPositionSummary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.PersonnelPositionSummary[ id=" + id + " ]";
    }
    
}
