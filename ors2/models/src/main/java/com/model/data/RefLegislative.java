/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "ref_legislative", catalog = "orsdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefLegislative.findAll", query = "SELECT r FROM RefLegislative r")})
public class RefLegislative implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short id;
    @ManyToOne
    private RefProvince refProvince;
    
    @Column(name = "district_no")
    private Short districtNo;
    @Column(name = "date_established")
    @Temporal(TemporalType.DATE)
    private Date dateEstablished;
    @Column(name = "date_defunc")
    @Temporal(TemporalType.DATE)
    private Date dateDefunc;
    @JoinColumn(name = "district_label", referencedColumnName = "id")
    @ManyToOne
    private RefCodeSetting districtLabel;
    @OneToMany(mappedBy = "refLegislativeId")
    private List<RefMunicipalityHistory> refMunicipalityHistoryList;
    @OneToMany(mappedBy = "refLegislativeId")
    private List<School> schoolList;
    @OneToMany(mappedBy = "refLegislativeId")
    private List<RefMunicipality> refMunicipalityList;

    public RefLegislative() {
    }

    public RefLegislative(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public RefProvince getRefProvince() {
		return refProvince;
	}

	public void setRefProvince(RefProvince refProvince) {
		this.refProvince = refProvince;
	}

	public Short getDistrictNo() {
        return districtNo;
    }

    public void setDistrictNo(Short districtNo) {
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

    public RefCodeSetting getDistrictLabel() {
        return districtLabel;
    }

    public void setDistrictLabel(RefCodeSetting districtLabel) {
        this.districtLabel = districtLabel;
    }

    @XmlTransient
    public List<RefMunicipalityHistory> getRefMunicipalityHistoryList() {
        return refMunicipalityHistoryList;
    }

    public void setRefMunicipalityHistoryList(List<RefMunicipalityHistory> refMunicipalityHistoryList) {
        this.refMunicipalityHistoryList = refMunicipalityHistoryList;
    }

    @XmlTransient
    public List<School> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
    }

    @XmlTransient
    public List<RefMunicipality> getRefMunicipalityList() {
        return refMunicipalityList;
    }

    public void setRefMunicipalityList(List<RefMunicipality> refMunicipalityList) {
        this.refMunicipalityList = refMunicipalityList;
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
        if (!(object instanceof RefLegislative)) {
            return false;
        }
        RefLegislative other = (RefLegislative) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.LisRefLegislative[ id=" + id + " ]";
    }
    
}
