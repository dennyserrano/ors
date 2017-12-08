/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "ref_baranggay_unofficial", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"municipality_id", "name"}),
    @UniqueConstraint(columnNames = {"nscb_code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefBaranggayUnofficial.findAll", query = "SELECT r FROM RefBaranggayUnofficial r")})
public class RefBaranggayUnofficial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String name;
    @Basic(optional = false)
    @Column(name = "municipality_id", nullable = false)
    private int municipalityId;
    @Basic(optional = false)
    @Column(name = "nscb_code", nullable = false, length = 40)
    private String nscbCode;

    public RefBaranggayUnofficial() {
    }

    public RefBaranggayUnofficial(Integer id) {
        this.id = id;
    }

    public RefBaranggayUnofficial(Integer id, String name, int municipalityId, String nscbCode) {
        this.id = id;
        this.name = name;
        this.municipalityId = municipalityId;
        this.nscbCode = nscbCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(int municipalityId) {
        this.municipalityId = municipalityId;
    }

    public String getNscbCode() {
        return nscbCode;
    }

    public void setNscbCode(String nscbCode) {
        this.nscbCode = nscbCode;
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
        if (!(object instanceof RefBaranggayUnofficial)) {
            return false;
        }
        RefBaranggayUnofficial other = (RefBaranggayUnofficial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.RefBaranggayUnofficial[ id=" + id + " ]";
    }
    
}
