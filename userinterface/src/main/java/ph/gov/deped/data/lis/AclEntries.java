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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "acl_entries", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"class_id", "object_identity_id", "field_name", "ace_order"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AclEntries.findAll", query = "SELECT a FROM AclEntries a")})
public class AclEntries implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "field_name", length = 50)
    private String fieldName;
    @Basic(optional = false)
    @Column(name = "ace_order", nullable = false)
    private short aceOrder;
    @Basic(optional = false)
    @Column(nullable = false)
    private int mask;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean granting;
    @Basic(optional = false)
    @Column(name = "granting_strategy", nullable = false, length = 30)
    private String grantingStrategy;
    @Basic(optional = false)
    @Column(name = "audit_success", nullable = false)
    private boolean auditSuccess;
    @Basic(optional = false)
    @Column(name = "audit_failure", nullable = false)
    private boolean auditFailure;
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
    @JoinColumn(name = "object_identity_id", referencedColumnName = "id")
    @ManyToOne
    private AclObjectIdentities objectIdentityId;
    @JoinColumn(name = "security_identity_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private AclSecurityIdentities securityIdentityId;
    @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private AclClasses classId;

    public AclEntries() {
    }

    public AclEntries(Integer id) {
        this.id = id;
    }

    public AclEntries(Integer id, short aceOrder, int mask, boolean granting, String grantingStrategy, boolean auditSuccess, boolean auditFailure, Date createdDt) {
        this.id = id;
        this.aceOrder = aceOrder;
        this.mask = mask;
        this.granting = granting;
        this.grantingStrategy = grantingStrategy;
        this.auditSuccess = auditSuccess;
        this.auditFailure = auditFailure;
        this.createdDt = createdDt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public short getAceOrder() {
        return aceOrder;
    }

    public void setAceOrder(short aceOrder) {
        this.aceOrder = aceOrder;
    }

    public int getMask() {
        return mask;
    }

    public void setMask(int mask) {
        this.mask = mask;
    }

    public boolean getGranting() {
        return granting;
    }

    public void setGranting(boolean granting) {
        this.granting = granting;
    }

    public String getGrantingStrategy() {
        return grantingStrategy;
    }

    public void setGrantingStrategy(String grantingStrategy) {
        this.grantingStrategy = grantingStrategy;
    }

    public boolean getAuditSuccess() {
        return auditSuccess;
    }

    public void setAuditSuccess(boolean auditSuccess) {
        this.auditSuccess = auditSuccess;
    }

    public boolean getAuditFailure() {
        return auditFailure;
    }

    public void setAuditFailure(boolean auditFailure) {
        this.auditFailure = auditFailure;
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

    public AclObjectIdentities getObjectIdentityId() {
        return objectIdentityId;
    }

    public void setObjectIdentityId(AclObjectIdentities objectIdentityId) {
        this.objectIdentityId = objectIdentityId;
    }

    public AclSecurityIdentities getSecurityIdentityId() {
        return securityIdentityId;
    }

    public void setSecurityIdentityId(AclSecurityIdentities securityIdentityId) {
        this.securityIdentityId = securityIdentityId;
    }

    public AclClasses getClassId() {
        return classId;
    }

    public void setClassId(AclClasses classId) {
        this.classId = classId;
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
        if (!(object instanceof AclEntries)) {
            return false;
        }
        AclEntries other = (AclEntries) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.AclEntries[ id=" + id + " ]";
    }
    
}
