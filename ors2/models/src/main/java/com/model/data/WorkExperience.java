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
@Table(name = "work_experience", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"creator_id", "personnel_id", "work_exp_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkExperience.findAll", query = "SELECT w FROM WorkExperience w")})
public class WorkExperience implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "creator_id", nullable = false)
    private short creatorId;
    @Basic(optional = false)
    @Column(name = "personnel_id", nullable = false)
    private short personnelId;
    @Basic(optional = false)
    @Column(name = "work_exp_id", nullable = false)
    private short workExpId;
    @Basic(optional = false)
    @Column(name = "company_name", nullable = false, length = 100)
    private String companyName;
    @Column(name = "company_address", length = 60)
    private String companyAddress;
    @Column(name = "company_municipality")
    private Short companyMunicipality;
    @Basic(optional = false)
    @Column(name = "emloyment_status", nullable = false)
    private short emloymentStatus;
    @Basic(optional = false)
    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "last_salary", nullable = false)
    private float lastSalary;
    @Basic(optional = false)
    @Column(name = "school_personnel_id", nullable = false)
    private int schoolPersonnelId;
    @JoinColumn(name = "company_barangay", referencedColumnName = "id")
    @ManyToOne
    private RefBaranggay companyBarangay;

    public WorkExperience() {
    }

    public WorkExperience(Integer id) {
        this.id = id;
    }

    public WorkExperience(Integer id, short creatorId, short personnelId, short workExpId, String companyName, short emloymentStatus, Date startDate, Date endDate, float lastSalary, int schoolPersonnelId) {
        this.id = id;
        this.creatorId = creatorId;
        this.personnelId = personnelId;
        this.workExpId = workExpId;
        this.companyName = companyName;
        this.emloymentStatus = emloymentStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lastSalary = lastSalary;
        this.schoolPersonnelId = schoolPersonnelId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(short creatorId) {
        this.creatorId = creatorId;
    }

    public short getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(short personnelId) {
        this.personnelId = personnelId;
    }

    public short getWorkExpId() {
        return workExpId;
    }

    public void setWorkExpId(short workExpId) {
        this.workExpId = workExpId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public Short getCompanyMunicipality() {
        return companyMunicipality;
    }

    public void setCompanyMunicipality(Short companyMunicipality) {
        this.companyMunicipality = companyMunicipality;
    }

    public short getEmloymentStatus() {
        return emloymentStatus;
    }

    public void setEmloymentStatus(short emloymentStatus) {
        this.emloymentStatus = emloymentStatus;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getLastSalary() {
        return lastSalary;
    }

    public void setLastSalary(float lastSalary) {
        this.lastSalary = lastSalary;
    }

    public int getSchoolPersonnelId() {
        return schoolPersonnelId;
    }

    public void setSchoolPersonnelId(int schoolPersonnelId) {
        this.schoolPersonnelId = schoolPersonnelId;
    }

    public RefBaranggay getCompanyBarangay() {
        return companyBarangay;
    }

    public void setCompanyBarangay(RefBaranggay companyBarangay) {
        this.companyBarangay = companyBarangay;
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
        if (!(object instanceof WorkExperience)) {
            return false;
        }
        WorkExperience other = (WorkExperience) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.WorkExperience[ id=" + id + " ]";
    }
    
}
