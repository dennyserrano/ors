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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "ancillary_service", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"school_id", "ref_code_setting_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AncillaryService.findAll", query = "SELECT a FROM AncillaryService a")})
public class AncillaryService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "ref_code_setting_id")
    private Short refCodeSettingId;
    private Short functional;
    @Column(length = 255)
    private String remarks;
    @JoinColumn(name = "school_id", referencedColumnName = "id")
    @ManyToOne
    private School schoolId;

    public AncillaryService() {
    }

    public AncillaryService(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getRefCodeSettingId() {
        return refCodeSettingId;
    }

    public void setRefCodeSettingId(Short refCodeSettingId) {
        this.refCodeSettingId = refCodeSettingId;
    }

    public Short getFunctional() {
        return functional;
    }

    public void setFunctional(Short functional) {
        this.functional = functional;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public School getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(School schoolId) {
        this.schoolId = schoolId;
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
        if (!(object instanceof AncillaryService)) {
            return false;
        }
        AncillaryService other = (AncillaryService) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.AncillaryService[ id=" + id + " ]";
    }
    
}
