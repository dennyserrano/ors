/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

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
@Table(name = "ref_legislative", catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LisRefLegislative.findAll", query = "SELECT r FROM LisRefLegislative r")})
public class LisRefLegislative implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short id;
    @Column(name = "ref_province_id")
    private Short refProvinceId;
    @Column(name = "ref_municipality_id")
    private Integer refMunicipalityId;
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
    private LisRefCodeSetting districtLabel;
    @OneToMany(mappedBy = "lisRefLegislativeId")
    private List<LisSchool> lisSchoolList;
    @OneToMany(mappedBy = "lisRefLegislativeId")
    private List<LisRefMunicipality> lisRefMunicipalityList;

    public LisRefLegislative() {
    }

    public LisRefLegislative(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Short getRefProvinceId() {
        return refProvinceId;
    }

    public void setRefProvinceId(Short refProvinceId) {
        this.refProvinceId = refProvinceId;
    }

    public Integer getRefMunicipalityId() {
        return refMunicipalityId;
    }

    public void setRefMunicipalityId(Integer refMunicipalityId) {
        this.refMunicipalityId = refMunicipalityId;
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

    public LisRefCodeSetting getDistrictLabel() {
        return districtLabel;
    }

    public void setDistrictLabel(LisRefCodeSetting districtLabel) {
        this.districtLabel = districtLabel;
    }

    @XmlTransient
    public List<LisSchool> getLisSchoolList() {
        return lisSchoolList;
    }

    public void setLisSchoolList(List<LisSchool> lisSchoolList) {
        this.lisSchoolList = lisSchoolList;
    }

    @XmlTransient
    public List<LisRefMunicipality> getLisRefMunicipalityList() {
        return lisRefMunicipalityList;
    }

    public void setLisRefMunicipalityList(List<LisRefMunicipality> lisRefMunicipalityList) {
        this.lisRefMunicipalityList = lisRefMunicipalityList;
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
        if (!(object instanceof LisRefLegislative)) {
            return false;
        }
        LisRefLegislative other = (LisRefLegislative) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.LisRefLegislative[ id=" + id + " ]";
    }
    
}
