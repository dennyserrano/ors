/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "nso_projected_pop", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sy_from", "age", "ref_legislative_id", "division_id", "district_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NsoProjectedPop.findAll", query = "SELECT n FROM NsoProjectedPop n")})
public class NsoProjectedPop implements Serializable {
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
    @Column(nullable = false)
    private short age;
    private Integer male;
    private Integer female;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "male_orgvalue", precision = 22)
    private Double maleOrgvalue;
    @Basic(optional = false)
    @Column(name = "ref_region_id", nullable = false)
    private short refRegionId;
    @Column(name = "ref_province_id")
    private Short refProvinceId;
    @Column(name = "ref_municipality_id")
    private Integer refMunicipalityId;
    @Column(name = "ref_legislative_id")
    private Short refLegislativeId;
    @Column(name = "division_id")
    private Short divisionId;
    @Column(name = "district_id")
    private Short districtId;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "female_orgvalue", precision = 22)
    private Double femaleOrgvalue;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public NsoProjectedPop() {
    }

    public NsoProjectedPop(Integer id) {
        this.id = id;
    }

    public NsoProjectedPop(Integer id, short syFrom, short age, short refRegionId, Date updatedAt) {
        this.id = id;
        this.syFrom = syFrom;
        this.age = age;
        this.refRegionId = refRegionId;
        this.updatedAt = updatedAt;
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

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public Integer getMale() {
        return male;
    }

    public void setMale(Integer male) {
        this.male = male;
    }

    public Integer getFemale() {
        return female;
    }

    public void setFemale(Integer female) {
        this.female = female;
    }

    public Double getMaleOrgvalue() {
        return maleOrgvalue;
    }

    public void setMaleOrgvalue(Double maleOrgvalue) {
        this.maleOrgvalue = maleOrgvalue;
    }

    public short getRefRegionId() {
        return refRegionId;
    }

    public void setRefRegionId(short refRegionId) {
        this.refRegionId = refRegionId;
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

    public Short getRefLegislativeId() {
        return refLegislativeId;
    }

    public void setRefLegislativeId(Short refLegislativeId) {
        this.refLegislativeId = refLegislativeId;
    }

    public Short getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Short divisionId) {
        this.divisionId = divisionId;
    }

    public Short getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Short districtId) {
        this.districtId = districtId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Double getFemaleOrgvalue() {
        return femaleOrgvalue;
    }

    public void setFemaleOrgvalue(Double femaleOrgvalue) {
        this.femaleOrgvalue = femaleOrgvalue;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
        if (!(object instanceof NsoProjectedPop)) {
            return false;
        }
        NsoProjectedPop other = (NsoProjectedPop) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.NsoProjectedPop[ id=" + id + " ]";
    }
    
}
