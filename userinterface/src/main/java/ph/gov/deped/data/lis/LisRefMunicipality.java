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
import javax.persistence.CascadeType;
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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "ref_municipality", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nscb_code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LisRefMunicipality.findAll", query = "SELECT r FROM LisRefMunicipality r")})
public class LisRefMunicipality implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "municipality_name", nullable = false, length = 40)
    private String municipalityName;
    @Basic(optional = false)
    @Column(name = "nscb_code", nullable = false, length = 6)
    private String nscbCode;
    @Basic(optional = false)
    @Column(name = "district_no", nullable = false)
    private short districtNo;
    private Short incomeClass;
    private Short cityClass;
    @Column(name = "URP")
    private Short urp;
    @Column(name = "effective_sy")
    private Short effectiveSy;
    @Column(name = "created_by")
    private Integer createdBy;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "ref_legislative_id_orig")
    private Short refLegislativeIdOrig;
    @Column(name = "district_no_orig")
    private Short districtNoOrig;
    @JoinColumn(name = "ref_legislative_id", referencedColumnName = "id")
    @ManyToOne
    private LisRefLegislative lisRefLegislativeId;
    @JoinColumn(name = "ref_province_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private LisRefProvince lisRefProvinceId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lisRefMunicipalityId")
    private List<LisRefBaranggay> lisRefBaranggayList;

    public LisRefMunicipality() {
    }

    public LisRefMunicipality(Integer id) {
        this.id = id;
    }

    public LisRefMunicipality(Integer id, String municipalityName, String nscbCode, short districtNo, Date createdAt) {
        this.id = id;
        this.municipalityName = municipalityName;
        this.nscbCode = nscbCode;
        this.districtNo = districtNo;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
    }

    public String getNscbCode() {
        return nscbCode;
    }

    public void setNscbCode(String nscbCode) {
        this.nscbCode = nscbCode;
    }

    public short getDistrictNo() {
        return districtNo;
    }

    public void setDistrictNo(short districtNo) {
        this.districtNo = districtNo;
    }

    public Short getIncomeClass() {
        return incomeClass;
    }

    public void setIncomeClass(Short incomeClass) {
        this.incomeClass = incomeClass;
    }

    public Short getCityClass() {
        return cityClass;
    }

    public void setCityClass(Short cityClass) {
        this.cityClass = cityClass;
    }

    public Short getUrp() {
        return urp;
    }

    public void setUrp(Short urp) {
        this.urp = urp;
    }

    public Short getEffectiveSy() {
        return effectiveSy;
    }

    public void setEffectiveSy(Short effectiveSy) {
        this.effectiveSy = effectiveSy;
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

    public Short getRefLegislativeIdOrig() {
        return refLegislativeIdOrig;
    }

    public void setRefLegislativeIdOrig(Short refLegislativeIdOrig) {
        this.refLegislativeIdOrig = refLegislativeIdOrig;
    }

    public Short getDistrictNoOrig() {
        return districtNoOrig;
    }

    public void setDistrictNoOrig(Short districtNoOrig) {
        this.districtNoOrig = districtNoOrig;
    }

    public LisRefLegislative getLisRefLegislativeId() {
        return lisRefLegislativeId;
    }

    public void setLisRefLegislativeId(LisRefLegislative lisRefLegislativeId) {
        this.lisRefLegislativeId = lisRefLegislativeId;
    }

    public LisRefProvince getLisRefProvinceId() {
        return lisRefProvinceId;
    }

    public void setLisRefProvinceId(LisRefProvince lisRefProvinceId) {
        this.lisRefProvinceId = lisRefProvinceId;
    }

    @XmlTransient
    public List<LisRefBaranggay> getLisRefBaranggayList() {
        return lisRefBaranggayList;
    }

    public void setLisRefBaranggayList(List<LisRefBaranggay> lisRefBaranggayList) {
        this.lisRefBaranggayList = lisRefBaranggayList;
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
        if (!(object instanceof LisRefMunicipality)) {
            return false;
        }
        LisRefMunicipality other = (LisRefMunicipality) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.LisRefMunicipality[ id=" + id + " ]";
    }
    
}
