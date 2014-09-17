/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ej
 */
@Embeddable
public class Genen2014PK implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 4225819515120204461L;
    @Basic(optional = false)
    @Column(nullable = false)
    private int id;
    @Basic(optional = false)
    @Column(name = "sy_from", nullable = false)
    private short syFrom;

    public Genen2014PK() {
    }

    public Genen2014PK(int id, short syFrom) {
        this.id = id;
        this.syFrom = syFrom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public short getSyFrom() {
        return syFrom;
    }

    public void setSyFrom(short syFrom) {
        this.syFrom = syFrom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) syFrom;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genen2014PK)) {
            return false;
        }
        Genen2014PK other = (Genen2014PK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.syFrom != other.syFrom) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.Genen2014PK[ id=" + id + ", syFrom=" + syFrom + " ]";
    }
    
}
