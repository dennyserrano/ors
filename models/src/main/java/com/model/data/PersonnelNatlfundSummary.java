/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "personnel_natlfund_summary", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonnelNatlfundSummary.findAll", query = "SELECT p FROM PersonnelNatlfundSummary p")})
public class PersonnelNatlfundSummary implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private PersonnelNatlfundSummaryPK personnelNatlfundSummaryPK;
    @Basic(optional = false)
    @Column(name = "report_history_id", nullable = false)
    private short reportHistoryId;
    @Column(name = "position_id")
    private Short positionId;
    @Column(name = "tot_plantilla_items")
    private Short totPlantillaItems;
    @Column(name = "actual_male")
    private Short actualMale;
    @Column(name = "actual_female")
    private Short actualFemale;
    @Column(name = "on_leave_male")
    private Short onLeaveMale;
    @Column(name = "on_leave_female")
    private Short onLeaveFemale;
    @Column(name = "tot_onleave")
    private Short totOnleave;
    @Column(name = "detailed_male")
    private Short detailedMale;
    @Column(name = "detailed_female")
    private Short detailedFemale;
    @Column(name = "ft_teaching")
    private Short ftTeaching;
    @Column(name = "ft_part_ancillary")
    private Short ftPartAncillary;
    @Column(name = "pt_200_more")
    private Short pt200More;
    @Column(name = "pt_less_200")
    private Short ptLess200;
    @Column(name = "ft_ancillary")
    private Short ftAncillary;
    @Column(name = "in_school_male")
    private Short inSchoolMale;
    @Column(name = "in_school_female")
    private Short inSchoolFemale;
    @Column(name = "tot_plantilla_vacant")
    private Short totPlantillaVacant;
    @Column(name = "borrowed_male_admin_teacher")
    private Short borrowedMaleAdminTeacher;
    @Column(name = "borrowed_female_admin_teacher")
    private Short borrowedFemaleAdminTeacher;
    @Column(name = "detailed_admin_teachers")
    private Short detailedAdminTeachers;

    public PersonnelNatlfundSummary() {
    }

    public PersonnelNatlfundSummary(PersonnelNatlfundSummaryPK personnelNatlfundSummaryPK) {
        this.personnelNatlfundSummaryPK = personnelNatlfundSummaryPK;
    }

    public PersonnelNatlfundSummary(PersonnelNatlfundSummaryPK personnelNatlfundSummaryPK, short reportHistoryId) {
        this.personnelNatlfundSummaryPK = personnelNatlfundSummaryPK;
        this.reportHistoryId = reportHistoryId;
    }

    public PersonnelNatlfundSummary(short id, short schoolId) {
        this.personnelNatlfundSummaryPK = new PersonnelNatlfundSummaryPK(id, schoolId);
    }

    public PersonnelNatlfundSummaryPK getPersonnelNatlfundSummaryPK() {
        return personnelNatlfundSummaryPK;
    }

    public void setPersonnelNatlfundSummaryPK(PersonnelNatlfundSummaryPK personnelNatlfundSummaryPK) {
        this.personnelNatlfundSummaryPK = personnelNatlfundSummaryPK;
    }

    public short getReportHistoryId() {
        return reportHistoryId;
    }

    public void setReportHistoryId(short reportHistoryId) {
        this.reportHistoryId = reportHistoryId;
    }

    public Short getPositionId() {
        return positionId;
    }

    public void setPositionId(Short positionId) {
        this.positionId = positionId;
    }

    public Short getTotPlantillaItems() {
        return totPlantillaItems;
    }

    public void setTotPlantillaItems(Short totPlantillaItems) {
        this.totPlantillaItems = totPlantillaItems;
    }

    public Short getActualMale() {
        return actualMale;
    }

    public void setActualMale(Short actualMale) {
        this.actualMale = actualMale;
    }

    public Short getActualFemale() {
        return actualFemale;
    }

    public void setActualFemale(Short actualFemale) {
        this.actualFemale = actualFemale;
    }

    public Short getOnLeaveMale() {
        return onLeaveMale;
    }

    public void setOnLeaveMale(Short onLeaveMale) {
        this.onLeaveMale = onLeaveMale;
    }

    public Short getOnLeaveFemale() {
        return onLeaveFemale;
    }

    public void setOnLeaveFemale(Short onLeaveFemale) {
        this.onLeaveFemale = onLeaveFemale;
    }

    public Short getTotOnleave() {
        return totOnleave;
    }

    public void setTotOnleave(Short totOnleave) {
        this.totOnleave = totOnleave;
    }

    public Short getDetailedMale() {
        return detailedMale;
    }

    public void setDetailedMale(Short detailedMale) {
        this.detailedMale = detailedMale;
    }

    public Short getDetailedFemale() {
        return detailedFemale;
    }

    public void setDetailedFemale(Short detailedFemale) {
        this.detailedFemale = detailedFemale;
    }

    public Short getFtTeaching() {
        return ftTeaching;
    }

    public void setFtTeaching(Short ftTeaching) {
        this.ftTeaching = ftTeaching;
    }

    public Short getFtPartAncillary() {
        return ftPartAncillary;
    }

    public void setFtPartAncillary(Short ftPartAncillary) {
        this.ftPartAncillary = ftPartAncillary;
    }

    public Short getPt200More() {
        return pt200More;
    }

    public void setPt200More(Short pt200More) {
        this.pt200More = pt200More;
    }

    public Short getPtLess200() {
        return ptLess200;
    }

    public void setPtLess200(Short ptLess200) {
        this.ptLess200 = ptLess200;
    }

    public Short getFtAncillary() {
        return ftAncillary;
    }

    public void setFtAncillary(Short ftAncillary) {
        this.ftAncillary = ftAncillary;
    }

    public Short getInSchoolMale() {
        return inSchoolMale;
    }

    public void setInSchoolMale(Short inSchoolMale) {
        this.inSchoolMale = inSchoolMale;
    }

    public Short getInSchoolFemale() {
        return inSchoolFemale;
    }

    public void setInSchoolFemale(Short inSchoolFemale) {
        this.inSchoolFemale = inSchoolFemale;
    }

    public Short getTotPlantillaVacant() {
        return totPlantillaVacant;
    }

    public void setTotPlantillaVacant(Short totPlantillaVacant) {
        this.totPlantillaVacant = totPlantillaVacant;
    }

    public Short getBorrowedMaleAdminTeacher() {
        return borrowedMaleAdminTeacher;
    }

    public void setBorrowedMaleAdminTeacher(Short borrowedMaleAdminTeacher) {
        this.borrowedMaleAdminTeacher = borrowedMaleAdminTeacher;
    }

    public Short getBorrowedFemaleAdminTeacher() {
        return borrowedFemaleAdminTeacher;
    }

    public void setBorrowedFemaleAdminTeacher(Short borrowedFemaleAdminTeacher) {
        this.borrowedFemaleAdminTeacher = borrowedFemaleAdminTeacher;
    }

    public Short getDetailedAdminTeachers() {
        return detailedAdminTeachers;
    }

    public void setDetailedAdminTeachers(Short detailedAdminTeachers) {
        this.detailedAdminTeachers = detailedAdminTeachers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personnelNatlfundSummaryPK != null ? personnelNatlfundSummaryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonnelNatlfundSummary)) {
            return false;
        }
        PersonnelNatlfundSummary other = (PersonnelNatlfundSummary) object;
        if ((this.personnelNatlfundSummaryPK == null && other.personnelNatlfundSummaryPK != null) || (this.personnelNatlfundSummaryPK != null && !this.personnelNatlfundSummaryPK.equals(other.personnelNatlfundSummaryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.PersonnelNatlfundSummary[ personnelNatlfundSummaryPK=" + personnelNatlfundSummaryPK + " ]";
    }
    
}
