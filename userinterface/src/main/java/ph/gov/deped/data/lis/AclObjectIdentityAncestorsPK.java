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
public class AclObjectIdentityAncestorsPK implements Serializable {
    private static final long serialVersionUID = 6884349218520483108L;
    @Basic(optional = false)
    @Column(name = "object_identity_id", nullable = false)
    private int objectIdentityId;
    @Basic(optional = false)
    @Column(name = "ancestor_id", nullable = false)
    private int ancestorId;

    public AclObjectIdentityAncestorsPK() {
    }

    public AclObjectIdentityAncestorsPK(int objectIdentityId, int ancestorId) {
        this.objectIdentityId = objectIdentityId;
        this.ancestorId = ancestorId;
    }

    public int getObjectIdentityId() {
        return objectIdentityId;
    }

    public void setObjectIdentityId(int objectIdentityId) {
        this.objectIdentityId = objectIdentityId;
    }

    public int getAncestorId() {
        return ancestorId;
    }

    public void setAncestorId(int ancestorId) {
        this.ancestorId = ancestorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) objectIdentityId;
        hash += (int) ancestorId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AclObjectIdentityAncestorsPK)) {
            return false;
        }
        AclObjectIdentityAncestorsPK other = (AclObjectIdentityAncestorsPK) object;
        if (this.objectIdentityId != other.objectIdentityId) {
            return false;
        }
        if (this.ancestorId != other.ancestorId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.AclObjectIdentityAncestorsPK[ objectIdentityId=" + objectIdentityId + ", ancestorId=" + ancestorId + " ]";
    }
    
}
