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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "ref_divlocation", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sy_from", "division_id", "district_id", "ref_municipality_id", "ref_legislative_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefDivlocation.findAll", query = "SELECT r FROM RefDivlocation r")})
public class RefDivlocation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sy_from", nullable = false)
    private short syFrom;
    @Basic(optional = false)
    @Column(name = "ref_legislative_id", nullable = false)
    private short refLegislativeId;
    @Column(name = "ref_province_id")
    private Short refProvinceId;
    @JoinColumn(name = "district_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefOffice districtId;
    @JoinColumn(name = "division_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefOffice divisionId;
    @JoinColumn(name = "ref_municipality_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefMunicipality refMunicipalityId;

    public RefDivlocation() {
    }

    public RefDivlocation(Integer id) {
        this.id = id;
    }

    public RefDivlocation(Integer id, short syFrom, short refLegislativeId) {
        this.id = id;
        this.syFrom = syFrom;
        this.refLegislativeId = refLegislativeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getSyFrom() {
        return syFrom;
    }

    public void setSyFrom(short syFrom) {
        this.syFrom = syFrom;
    }

    public short getRefLegislativeId() {
        return refLegislativeId;
    }

    public void setRefLegislativeId(short refLegislativeId) {
        this.refLegislativeId = refLegislativeId;
    }

    public Short getRefProvinceId() {
        return refProvinceId;
    }

    public void setRefProvinceId(Short refProvinceId) {
        this.refProvinceId = refProvinceId;
    }

    public RefOffice getDistrictId() {
        return districtId;
    }

    public void setDistrictId(RefOffice districtId) {
        this.districtId = districtId;
    }

    public RefOffice getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(RefOffice divisionId) {
        this.divisionId = divisionId;
    }

    public RefMunicipality getRefMunicipalityId() {
        return refMunicipalityId;
    }

    public void setRefMunicipalityId(RefMunicipality refMunicipalityId) {
        this.refMunicipalityId = refMunicipalityId;
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
        if (!(object instanceof RefDivlocation)) {
            return false;
        }
        RefDivlocation other = (RefDivlocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.RefDivlocation[ id=" + id + " ]";
    }
    
}
