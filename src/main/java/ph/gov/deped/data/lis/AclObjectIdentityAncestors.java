/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "acl_object_identity_ancestors", catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AclObjectIdentityAncestors.findAll", query = "SELECT a FROM AclObjectIdentityAncestors a")})
public class AclObjectIdentityAncestors implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private AclObjectIdentityAncestorsPK aclObjectIdentityAncestorsPK;
    @Basic(optional = false)
    @Column(name = "created_dt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDt;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "updated_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDt;
    @Column(name = "updated_by")
    private Integer updatedBy;
    @JoinColumn(name = "object_identity_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AclObjectIdentities aclObjectIdentities;
    @JoinColumn(name = "ancestor_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AclObjectIdentities aclObjectIdentities1;

    public AclObjectIdentityAncestors() {
    }

    public AclObjectIdentityAncestors(AclObjectIdentityAncestorsPK aclObjectIdentityAncestorsPK) {
        this.aclObjectIdentityAncestorsPK = aclObjectIdentityAncestorsPK;
    }

    public AclObjectIdentityAncestors(AclObjectIdentityAncestorsPK aclObjectIdentityAncestorsPK, Date createdDt) {
        this.aclObjectIdentityAncestorsPK = aclObjectIdentityAncestorsPK;
        this.createdDt = createdDt;
    }

    public AclObjectIdentityAncestors(int objectIdentityId, int ancestorId) {
        this.aclObjectIdentityAncestorsPK = new AclObjectIdentityAncestorsPK(objectIdentityId, ancestorId);
    }

    public AclObjectIdentityAncestorsPK getAclObjectIdentityAncestorsPK() {
        return aclObjectIdentityAncestorsPK;
    }

    public void setAclObjectIdentityAncestorsPK(AclObjectIdentityAncestorsPK aclObjectIdentityAncestorsPK) {
        this.aclObjectIdentityAncestorsPK = aclObjectIdentityAncestorsPK;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(Date updatedDt) {
        this.updatedDt = updatedDt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public AclObjectIdentities getAclObjectIdentities() {
        return aclObjectIdentities;
    }

    public void setAclObjectIdentities(AclObjectIdentities aclObjectIdentities) {
        this.aclObjectIdentities = aclObjectIdentities;
    }

    public AclObjectIdentities getAclObjectIdentities1() {
        return aclObjectIdentities1;
    }

    public void setAclObjectIdentities1(AclObjectIdentities aclObjectIdentities1) {
        this.aclObjectIdentities1 = aclObjectIdentities1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aclObjectIdentityAncestorsPK != null ? aclObjectIdentityAncestorsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AclObjectIdentityAncestors)) {
            return false;
        }
        AclObjectIdentityAncestors other = (AclObjectIdentityAncestors) object;
        if ((this.aclObjectIdentityAncestorsPK == null && other.aclObjectIdentityAncestorsPK != null) || (this.aclObjectIdentityAncestorsPK != null && !this.aclObjectIdentityAncestorsPK.equals(other.aclObjectIdentityAncestorsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.AclObjectIdentityAncestors[ aclObjectIdentityAncestorsPK=" + aclObjectIdentityAncestorsPK + " ]";
    }
    
}
