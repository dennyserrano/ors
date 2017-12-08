/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "genen_2013", catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genen2013.findAll", query = "SELECT g FROM Genen2013 g")})
public class Genen2013 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    private BigInteger kmale;
    private BigInteger kfemale;
    private BigInteger g1male;
    private BigInteger g1female;
    private BigInteger g2male;
    private BigInteger g2female;
    private BigInteger g3male;
    private BigInteger g3female;
    private BigInteger g4male;
    private BigInteger g4female;
    private BigInteger g5male;
    private BigInteger g5female;
    private BigInteger g6male;
    private BigInteger g6female;
    private BigInteger ngmale;
    private BigInteger ngfemale;
    @Column(name = "data_flag")
    private Short dataFlag;
    private Short finalized;
    @Column(name = "sy_from")
    private Short syFrom;

    public Genen2013() {
    }

    public Genen2013(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getKmale() {
        return kmale;
    }

    public void setKmale(BigInteger kmale) {
        this.kmale = kmale;
    }

    public BigInteger getKfemale() {
        return kfemale;
    }

    public void setKfemale(BigInteger kfemale) {
        this.kfemale = kfemale;
    }

    public BigInteger getG1male() {
        return g1male;
    }

    public void setG1male(BigInteger g1male) {
        this.g1male = g1male;
    }

    public BigInteger getG1female() {
        return g1female;
    }

    public void setG1female(BigInteger g1female) {
        this.g1female = g1female;
    }

    public BigInteger getG2male() {
        return g2male;
    }

    public void setG2male(BigInteger g2male) {
        this.g2male = g2male;
    }

    public BigInteger getG2female() {
        return g2female;
    }

    public void setG2female(BigInteger g2female) {
        this.g2female = g2female;
    }

    public BigInteger getG3male() {
        return g3male;
    }

    public void setG3male(BigInteger g3male) {
        this.g3male = g3male;
    }

    public BigInteger getG3female() {
        return g3female;
    }

    public void setG3female(BigInteger g3female) {
        this.g3female = g3female;
    }

    public BigInteger getG4male() {
        return g4male;
    }

    public void setG4male(BigInteger g4male) {
        this.g4male = g4male;
    }

    public BigInteger getG4female() {
        return g4female;
    }

    public void setG4female(BigInteger g4female) {
        this.g4female = g4female;
    }

    public BigInteger getG5male() {
        return g5male;
    }

    public void setG5male(BigInteger g5male) {
        this.g5male = g5male;
    }

    public BigInteger getG5female() {
        return g5female;
    }

    public void setG5female(BigInteger g5female) {
        this.g5female = g5female;
    }

    public BigInteger getG6male() {
        return g6male;
    }

    public void setG6male(BigInteger g6male) {
        this.g6male = g6male;
    }

    public BigInteger getG6female() {
        return g6female;
    }

    public void setG6female(BigInteger g6female) {
        this.g6female = g6female;
    }

    public BigInteger getNgmale() {
        return ngmale;
    }

    public void setNgmale(BigInteger ngmale) {
        this.ngmale = ngmale;
    }

    public BigInteger getNgfemale() {
        return ngfemale;
    }

    public void setNgfemale(BigInteger ngfemale) {
        this.ngfemale = ngfemale;
    }

    public Short getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(Short dataFlag) {
        this.dataFlag = dataFlag;
    }

    public Short getFinalized() {
        return finalized;
    }

    public void setFinalized(Short finalized) {
        this.finalized = finalized;
    }

    public Short getSyFrom() {
        return syFrom;
    }

    public void setSyFrom(Short syFrom) {
        this.syFrom = syFrom;
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
        if (!(object instanceof Genen2013)) {
            return false;
        }
        Genen2013 other = (Genen2013) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.Genen2013[ id=" + id + " ]";
    }
    
}
