/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "geocodes", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Geocodes.findAll", query = "SELECT g FROM Geocodes g")})
public class Geocodes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "island_group", nullable = false, length = 12)
    private String islandGroup;
    @Column(length = 9)
    private String region;
    @Column(length = 9)
    private String province;
    @Column(length = 9)
    private String municipality;
    @Column(length = 9)
    private String barangay;
    @Basic(optional = false)
    @Column(nullable = false, length = 5)
    private String ur;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String text;
    @Basic(optional = false)
    @Column(name = "is_sia", nullable = false)
    private boolean isSia;

    public Geocodes() {
    }

    public Geocodes(Integer id) {
        this.id = id;
    }

    public Geocodes(Integer id, String islandGroup, String ur, String text, boolean isSia) {
        this.id = id;
        this.islandGroup = islandGroup;
        this.ur = ur;
        this.text = text;
        this.isSia = isSia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIslandGroup() {
        return islandGroup;
    }

    public void setIslandGroup(String islandGroup) {
        this.islandGroup = islandGroup;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getUr() {
        return ur;
    }

    public void setUr(String ur) {
        this.ur = ur;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getIsSia() {
        return isSia;
    }

    public void setIsSia(boolean isSia) {
        this.isSia = isSia;
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
        if (!(object instanceof Geocodes)) {
            return false;
        }
        Geocodes other = (Geocodes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.Geocodes[ id=" + id + " ]";
    }
    
}
