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
@Table(name = "acl_classes", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"class_type"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AclClasses.findAll", query = "SELECT a FROM AclClasses a")})
public class AclClasses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "class_type", nullable = false, length = 200)
    private String classType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
    private List<AclEntries> aclEntriesList;

    public AclClasses() {
    }

    public AclClasses(Integer id) {
        this.id = id;
    }

    public AclClasses(Integer id, String classType, Date createdDt) {
        this.id = id;
        this.classType = classType;
        this.createdDt = createdDt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
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
    public List<AclEntries> getAclEntriesList() {
        return aclEntriesList;
    }

    public void setAclEntriesList(List<AclEntries> aclEntriesList) {
        this.aclEntriesList = aclEntriesList;
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
        if (!(object instanceof AclClasses)) {
            return false;
        }
        AclClasses other = (AclClasses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.AclClasses[ id=" + id + " ]";
    }
    
}
