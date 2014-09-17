/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "ref_region", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"region_name"}),
    @UniqueConstraint(columnNames = {"short_name"}),
    @UniqueConstraint(columnNames = {"nscb_code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefRegion.findAll", query = "SELECT r FROM RefRegion r")})
public class RefRegion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short id;
    private Short rank;
    @Basic(optional = false)
    @Column(name = "short_name", nullable = false, length = 12)
    private String shortName;
    @Basic(optional = false)
    @Column(name = "region_name", nullable = false, length = 60)
    private String regionName;
    @Basic(optional = false)
    @Column(name = "nscb_code", nullable = false, length = 2)
    private String nscbCode;
    @Column(name = "old_regid", length = 2)
    private String oldRegid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regionId")
    private List<School> schoolList;
    @OneToMany(mappedBy = "regionId")
    private List<SchoolProfileHistory> schoolProfileHistoryList;

    public RefRegion() {
    }

    public RefRegion(Short id) {
        this.id = id;
    }

    public RefRegion(Short id, String shortName, String regionName, String nscbCode) {
        this.id = id;
        this.shortName = shortName;
        this.regionName = regionName;
        this.nscbCode = nscbCode;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Short getRank() {
        return rank;
    }

    public void setRank(Short rank) {
        this.rank = rank;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getNscbCode() {
        return nscbCode;
    }

    public void setNscbCode(String nscbCode) {
        this.nscbCode = nscbCode;
    }

    public String getOldRegid() {
        return oldRegid;
    }

    public void setOldRegid(String oldRegid) {
        this.oldRegid = oldRegid;
    }

    @XmlTransient
    public List<School> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
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
        if (!(object instanceof RefRegion)) {
            return false;
        }
        RefRegion other = (RefRegion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.LisRefRegion[ id=" + id + " ]";
    }
    
}
