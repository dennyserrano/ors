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
@Table(name = "ref_municipality_history", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sy_from", "nscb_code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefMunicipalityHistory.findAll", query = "SELECT r FROM RefMunicipalityHistory r")})
public class RefMunicipalityHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ref_municipality_id", nullable = false)
    private int refMunicipalityId;
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
    @Basic(optional = false)
    @Column(name = "sy_from", nullable = false)
    private short syFrom;
    @Basic(optional = false)
    @Column(name = "sy_to", nullable = false)
    private short syTo;
    @Basic(optional = false)
    @Column(name = "created_by", nullable = false)
    private int createdBy;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "ref_legislative_id", referencedColumnName = "id")
    @ManyToOne
    private RefLegislative refLegislativeId;
    @JoinColumn(name = "ref_province_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefProvince refProvinceId;

    public RefMunicipalityHistory() {
    }

    public RefMunicipalityHistory(Integer id) {
        this.id = id;
    }

    public RefMunicipalityHistory(Integer id, int refMunicipalityId, String municipalityName, String nscbCode, short districtNo, short syFrom, short syTo, int createdBy, Date createdAt) {
        this.id = id;
        this.refMunicipalityId = refMunicipalityId;
        this.municipalityName = municipalityName;
        this.nscbCode = nscbCode;
        this.districtNo = districtNo;
        this.syFrom = syFrom;
        this.syTo = syTo;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRefMunicipalityId() {
        return refMunicipalityId;
    }

    public void setRefMunicipalityId(int refMunicipalityId) {
        this.refMunicipalityId = refMunicipalityId;
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

    public short getSyFrom() {
        return syFrom;
    }

    public void setSyFrom(short syFrom) {
        this.syFrom = syFrom;
    }

    public short getSyTo() {
        return syTo;
    }

    public void setSyTo(short syTo) {
        this.syTo = syTo;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public RefLegislative getRefLegislativeId() {
        return refLegislativeId;
    }

    public void setRefLegislativeId(RefLegislative refLegislativeId) {
        this.refLegislativeId = refLegislativeId;
    }

    public RefProvince getRefProvinceId() {
        return refProvinceId;
    }

    public void setRefProvinceId(RefProvince refProvinceId) {
        this.refProvinceId = refProvinceId;
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
        if (!(object instanceof RefMunicipalityHistory)) {
            return false;
        }
        RefMunicipalityHistory other = (RefMunicipalityHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.RefMunicipalityHistory[ id=" + id + " ]";
    }
    
}
