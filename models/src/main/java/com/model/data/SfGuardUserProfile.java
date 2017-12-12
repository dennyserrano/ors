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
 *
 * @author ej
 */
@Entity
@Table(name = "sf_guard_user_profile", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SfGuardUserProfile.findAll", query = "SELECT s FROM SfGuardUserProfile s")})
public class SfGuardUserProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "school_employee_id", length = 10)
    private String schoolEmployeeId;
    @Column(name = "last_name", length = 20)
    private String lastName;
    @Basic(optional = false)
    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;
    @Column(name = "middle_name", length = 20)
    private String middleName;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "created_by", nullable = false)
    private int createdBy;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "updated_by", nullable = false)
    private int updatedBy;
    @Column(name = "acl_flag")
    private Short aclFlag;
    @JoinColumn(name = "ref_office_id", referencedColumnName = "id")
    @ManyToOne
    private RefOffice refOfficeId;
    @JoinColumn(name = "school_id", referencedColumnName = "id")
    @ManyToOne
    private School schoolId;
    @JoinColumn(name = "gender", referencedColumnName = "id")
    @ManyToOne
    private RefCodeSetting gender;
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    @ManyToOne
    private RefPosition positionId;
    @JoinColumn(name = "sf_guard_user_id", referencedColumnName = "id")
    @ManyToOne
    private SfGuardUser sfGuardUserId;

    public SfGuardUserProfile() {
    }

    public SfGuardUserProfile(Integer id) {
        this.id = id;
    }

    public SfGuardUserProfile(Integer id, String firstName, int createdBy, Date updatedAt, int updatedBy) {
        this.id = id;
        this.firstName = firstName;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolEmployeeId() {
        return schoolEmployeeId;
    }

    public void setSchoolEmployeeId(String schoolEmployeeId) {
        this.schoolEmployeeId = schoolEmployeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Short getAclFlag() {
        return aclFlag;
    }

    public void setAclFlag(Short aclFlag) {
        this.aclFlag = aclFlag;
    }

    public RefOffice getRefOfficeId() {
        return refOfficeId;
    }

    public void setRefOfficeId(RefOffice refOfficeId) {
        this.refOfficeId = refOfficeId;
    }

    public School getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(School schoolId) {
        this.schoolId = schoolId;
    }

    public RefCodeSetting getGender() {
        return gender;
    }

    public void setGender(RefCodeSetting gender) {
        this.gender = gender;
    }

    public RefPosition getPositionId() {
        return positionId;
    }

    public void setPositionId(RefPosition positionId) {
        this.positionId = positionId;
    }

    public SfGuardUser getSfGuardUserId() {
        return sfGuardUserId;
    }

    public void setSfGuardUserId(SfGuardUser sfGuardUserId) {
        this.sfGuardUserId = sfGuardUserId;
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
        if (!(object instanceof SfGuardUserProfile)) {
            return false;
        }
        SfGuardUserProfile other = (SfGuardUserProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.LisSfGuardUserProfile[ id=" + id + " ]";
    }
    
}
