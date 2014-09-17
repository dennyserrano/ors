/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

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
@Table(name = "ref_baranggay", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nscb_code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefBaranggay.findAll", query = "SELECT r FROM RefBaranggay r")})
public class RefBaranggay implements Serializable {
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
    @JoinColumn(name = "ref_municipality_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefMunicipality refMunicipalityId;
    @OneToMany(mappedBy = "branggayId")
    private List<School> schoolList;
    @OneToMany(mappedBy = "companyBarangay")
    private List<WorkExperience> workExperienceList;
    @OneToMany(mappedBy = "branggayId")
    private List<SchoolProfileHistory> schoolProfileHistoryList;

    public RefBaranggay() {
    }

    public RefBaranggay(Integer id) {
        this.id = id;
    }

    public RefBaranggay(Integer id, String nscbCode, String brgyName, Date createdAt) {
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

    public RefMunicipality getRefMunicipalityId() {
        return refMunicipalityId;
    }

    public void setRefMunicipalityId(RefMunicipality refMunicipalityId) {
        this.refMunicipalityId = refMunicipalityId;
    }

    @XmlTransient
    public List<School> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
    }

    @XmlTransient
    public List<WorkExperience> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    @XmlTransient
    public List<SchoolProfileHistory> getSchoolProfileHistoryList() {
        return schoolProfileHistoryList;
    }

    public void setSchoolProfileHistoryList(List<SchoolProfileHistory> schoolProfileHistoryList) {
        this.schoolProfileHistoryList = schoolProfileHistoryList;
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
        if (!(object instanceof RefBaranggay)) {
            return false;
        }
        RefBaranggay other = (RefBaranggay) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.LisRefBaranggay[ id=" + id + " ]";
    }
    
}
