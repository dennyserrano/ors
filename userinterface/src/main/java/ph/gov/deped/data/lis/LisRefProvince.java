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
@Table(name = "ref_province", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nscb_code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LisRefProvince.findAll", query = "SELECT r FROM LisRefProvince r")})
public class LisRefProvince implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short id;
    @Column(name = "province_name", length = 30)
    private String provinceName;
    @Column(name = "nscb_code", length = 4)
    private String nscbCode;
    @Basic(optional = false)
    @Column(name = "ref_region_id", nullable = false)
    private short refRegionId;
    @Column(name = "effective_sy")
    private Short effectiveSy;
    @Column(name = "created_by")
    private Integer createdBy;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @OneToMany(mappedBy = "provinceId")
    private List<LisSchool> lisSchoolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lisRefProvinceId")
    private List<LisRefMunicipality> lisRefMunicipalityList;
    @OneToMany(mappedBy = "provinceId")
    private List<LisSchoolProfileHistory> lisSchoolProfileHistoryList;

    public LisRefProvince() {
    }

    public LisRefProvince(Short id) {
        this.id = id;
    }

    public LisRefProvince(Short id, short refRegionId, Date createdAt) {
        this.id = id;
        this.refRegionId = refRegionId;
        this.createdAt = createdAt;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getNscbCode() {
        return nscbCode;
    }

    public void setNscbCode(String nscbCode) {
        this.nscbCode = nscbCode;
    }

    public short getRefRegionId() {
        return refRegionId;
    }

    public void setRefRegionId(short refRegionId) {
        this.refRegionId = refRegionId;
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

    @XmlTransient
    public List<LisSchoolProfileHistory> getLisSchoolProfileHistoryList() {
        return lisSchoolProfileHistoryList;
    }

    public void setLisSchoolProfileHistoryList(List<LisSchoolProfileHistory> lisSchoolProfileHistoryList) {
        this.lisSchoolProfileHistoryList = lisSchoolProfileHistoryList;
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
        if (!(object instanceof LisRefProvince)) {
            return false;
        }
        LisRefProvince other = (LisRefProvince) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.LisRefProvince[ id=" + id + " ]";
    }
    
}
