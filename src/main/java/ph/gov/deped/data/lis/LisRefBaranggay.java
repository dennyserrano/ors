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
@Table(name = "ref_baranggay", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nscb_code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LisRefBaranggay.findAll", query = "SELECT r FROM LisRefBaranggay r")})
public class LisRefBaranggay implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nscb_code", nullable = false, length = 9)
    private String nscbCode;
    @Basic(optional = false)
    @Column(name = "brgy_name", nullable = false, length = 40)
    private String brgyName;
    @Column(name = "effective_sy")
    private Short effectiveSy;
    @Column(name = "created_by")
    private Integer createdBy;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @OneToMany(mappedBy = "branggayId")
    private List<LisSchool> lisSchoolList;
    @OneToMany(mappedBy = "branggayId")
    private List<LisSchoolProfileHistory> lisSchoolProfileHistoryList;
    @JoinColumn(name = "ref_municipality_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private LisRefMunicipality lisRefMunicipalityId;

    public LisRefBaranggay() {
    }

    public LisRefBaranggay(Integer id) {
        this.id = id;
    }

    public LisRefBaranggay(Integer id, String nscbCode, String brgyName, Date createdAt) {
        this.id = id;
        this.nscbCode = nscbCode;
        this.brgyName = brgyName;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNscbCode() {
        return nscbCode;
    }

    public void setNscbCode(String nscbCode) {
        this.nscbCode = nscbCode;
    }

    public String getBrgyName() {
        return brgyName;
    }

    public void setBrgyName(String brgyName) {
        this.brgyName = brgyName;
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
    public List<LisSchoolProfileHistory> getLisSchoolProfileHistoryList() {
        return lisSchoolProfileHistoryList;
    }

    public void setLisSchoolProfileHistoryList(List<LisSchoolProfileHistory> lisSchoolProfileHistoryList) {
        this.lisSchoolProfileHistoryList = lisSchoolProfileHistoryList;
    }

    public LisRefMunicipality getLisRefMunicipalityId() {
        return lisRefMunicipalityId;
    }

    public void setLisRefMunicipalityId(LisRefMunicipality lisRefMunicipalityId) {
        this.lisRefMunicipalityId = lisRefMunicipalityId;
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
        if (!(object instanceof LisRefBaranggay)) {
            return false;
        }
        LisRefBaranggay other = (LisRefBaranggay) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.LisRefBaranggay[ id=" + id + " ]";
    }
    
}
