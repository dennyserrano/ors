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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "acl_object_identities", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"object_identifier", "class_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AclObjectIdentities.findAll", query = "SELECT a FROM AclObjectIdentities a")})
public class AclObjectIdentities implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "class_id", nullable = false)
    private int classId;
    @Basic(optional = false)
    @Column(name = "object_identifier", nullable = false, length = 100)
    private String objectIdentifier;
    @Basic(optional = false)
    @Column(name = "entries_inheriting", nullable = false)
    private boolean entriesInheriting;
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
    @OneToMany(mappedBy = "parentObjectIdentityId")
    private List<AclObjectIdentities> aclObjectIdentitiesList;
    @JoinColumn(name = "parent_object_identity_id", referencedColumnName = "id")
    @ManyToOne
    private AclObjectIdentities parentObjectIdentityId;
    @OneToMany(mappedBy = "objectIdentityId")
    private List<AclEntries> aclEntriesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aclObjectIdentities")
    private List<AclObjectIdentityAncestors> aclObjectIdentityAncestorsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aclObjectIdentities1")
    private List<AclObjectIdentityAncestors> aclObjectIdentityAncestorsList1;

    public AclObjectIdentities() {
    }

    public AclObjectIdentities(Integer id) {
        this.id = id;
    }

    public AclObjectIdentities(Integer id, int classId, String objectIdentifier, boolean entriesInheriting, Date createdDt) {
        this.id = id;
        this.classId = classId;
        this.objectIdentifier = objectIdentifier;
        this.entriesInheriting = entriesInheriting;
        this.createdDt = createdDt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getObjectIdentifier() {
        return objectIdentifier;
    }

    public void setObjectIdentifier(String objectIdentifier) {
        this.objectIdentifier = objectIdentifier;
    }

    public boolean getEntriesInheriting() {
        return entriesInheriting;
    }

    public void setEntriesInheriting(boolean entriesInheriting) {
        this.entriesInheriting = entriesInheriting;
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

    @XmlTransient
    public List<AclObjectIdentities> getAclObjectIdentitiesList() {
        return aclObjectIdentitiesList;
    }

    public void setAclObjectIdentitiesList(List<AclObjectIdentities> aclObjectIdentitiesList) {
        this.aclObjectIdentitiesList = aclObjectIdentitiesList;
    }

    public AclObjectIdentities getParentObjectIdentityId() {
        return parentObjectIdentityId;
    }

    public void setParentObjectIdentityId(AclObjectIdentities parentObjectIdentityId) {
        this.parentObjectIdentityId = parentObjectIdentityId;
    }

    @XmlTransient
    public List<AclEntries> getAclEntriesList() {
        return aclEntriesList;
    }

    public void setAclEntriesList(List<AclEntries> aclEntriesList) {
        this.aclEntriesList = aclEntriesList;
    }

    @XmlTransient
    public List<AclObjectIdentityAncestors> getAclObjectIdentityAncestorsList() {
        return aclObjectIdentityAncestorsList;
    }

    public void setAclObjectIdentityAncestorsList(List<AclObjectIdentityAncestors> aclObjectIdentityAncestorsList) {
        this.aclObjectIdentityAncestorsList = aclObjectIdentityAncestorsList;
    }

    @XmlTransient
    public List<AclObjectIdentityAncestors> getAclObjectIdentityAncestorsList1() {
        return aclObjectIdentityAncestorsList1;
    }

    public void setAclObjectIdentityAncestorsList1(List<AclObjectIdentityAncestors> aclObjectIdentityAncestorsList1) {
        this.aclObjectIdentityAncestorsList1 = aclObjectIdentityAncestorsList1;
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
        if (!(object instanceof AclObjectIdentities)) {
            return false;
        }
        AclObjectIdentities other = (AclObjectIdentities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.AclObjectIdentities[ id=" + id + " ]";
    }
    
}
