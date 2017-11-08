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
@Table(name = "ref_legislative_history", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefLegislativeHistory.findAll", query = "SELECT r FROM RefLegislativeHistory r")})
public class RefLegislativeHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ref_legislative_id", nullable = false)
    private short refLegislativeId;
    @Basic(optional = false)
    @Column(name = "ref_province_id", nullable = false)
    private short refProvinceId;
    @Basic(optional = false)
    @Column(name = "ref_municipality_id", nullable = false)
    private int refMunicipalityId;
    @Basic(optional = false)
    @Column(name = "district_no", nullable = false)
    private short districtNo;
    @Column(name = "date_established")
    @Temporal(TemporalType.DATE)
    private Date dateEstablished;
    @Column(name = "date_defunc")
    @Temporal(TemporalType.DATE)
    private Date dateDefunc;
    @Column(name = "sy_from")
    private Short syFrom;
    @Column(name = "sy_to")
    private Short syTo;
    @JoinColumn(name = "district_label", referencedColumnName = "id")
    @ManyToOne
    private RefCodeSetting districtLabel;

    public RefLegislativeHistory() {
    }

    public RefLegislativeHistory(Integer id) {
        this.id = id;
    }

    public RefLegislativeHistory(Integer id, short refLegislativeId, short refProvinceId, int refMunicipalityId, short districtNo) {
        this.id = id;
        this.refLegislativeId = refLegislativeId;
        this.refProvinceId = refProvinceId;
        this.refMunicipalityId = refMunicipalityId;
        this.districtNo = districtNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getRefLegislativeId() {
        return refLegislativeId;
    }

    public void setRefLegislativeId(short refLegislativeId) {
        this.refLegislativeId = refLegislativeId;
    }

    public short getRefProvinceId() {
        return refProvinceId;
    }

    public void setRefProvinceId(short refProvinceId) {
        this.refProvinceId = refProvinceId;
    }

    public int getRefMunicipalityId() {
        return refMunicipalityId;
    }

    public void setRefMunicipalityId(int refMunicipalityId) {
        this.refMunicipalityId = refMunicipalityId;
    }

    public short getDistrictNo() {
        return districtNo;
    }

    public void setDistrictNo(short districtNo) {
        this.districtNo = districtNo;
    }

    public Date getDateEstablished() {
        return dateEstablished;
    }

    public void setDateEstablished(Date dateEstablished) {
        this.dateEstablished = dateEstablished;
    }

    public Date getDateDefunc() {
        return dateDefunc;
    }

    public void setDateDefunc(Date dateDefunc) {
        this.dateDefunc = dateDefunc;
    }

    public Short getSyFrom() {
        return syFrom;
    }

    public void setSyFrom(Short syFrom) {
        this.syFrom = syFrom;
    }

    public Short getSyTo() {
        return syTo;
    }

    public void setSyTo(Short syTo) {
        this.syTo = syTo;
    }

    public RefCodeSetting getDistrictLabel() {
        return districtLabel;
    }

    public void setDistrictLabel(RefCodeSetting districtLabel) {
        this.districtLabel = districtLabel;
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
        if (!(object instanceof RefLegislativeHistory)) {
            return false;
        }
        RefLegislativeHistory other = (RefLegislativeHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.RefLegislativeHistory[ id=" + id + " ]";
    }
    
}
