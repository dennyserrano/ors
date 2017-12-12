/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "sf_group_tmp", catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SfGroupTmp.findAll", query = "SELECT s FROM SfGroupTmp s")})
public class SfGroupTmp implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private SfGroupTmpPK sfGroupTmpPK;

    public SfGroupTmp() {
    }

    public SfGroupTmp(SfGroupTmpPK sfGroupTmpPK) {
        this.sfGroupTmpPK = sfGroupTmpPK;
    }

    public SfGroupTmp(int userId, int groupId) {
        this.sfGroupTmpPK = new SfGroupTmpPK(userId, groupId);
    }

    public SfGroupTmpPK getSfGroupTmpPK() {
        return sfGroupTmpPK;
    }

    public void setSfGroupTmpPK(SfGroupTmpPK sfGroupTmpPK) {
        this.sfGroupTmpPK = sfGroupTmpPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sfGroupTmpPK != null ? sfGroupTmpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SfGroupTmp)) {
            return false;
        }
        SfGroupTmp other = (SfGroupTmp) object;
        if ((this.sfGroupTmpPK == null && other.sfGroupTmpPK != null) || (this.sfGroupTmpPK != null && !this.sfGroupTmpPK.equals(other.sfGroupTmpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.SfGroupTmp[ sfGroupTmpPK=" + sfGroupTmpPK + " ]";
    }
    
}
