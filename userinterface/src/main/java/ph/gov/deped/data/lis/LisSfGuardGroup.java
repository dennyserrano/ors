/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "sf_guard_group", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LisSfGuardGroup.findAll", query = "SELECT s FROM LisSfGuardGroup s")})
public class LisSfGuardGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String name;
    @Lob
    @Column(length = 65535)
    private String description;
    @Column(name = "system_id")
    private Integer systemId;
    @JoinTable(name = "sf_guard_group_permission", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "permission_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<LisSfGuardPermission> lisSfGuardPermissionList;
    @ManyToMany(mappedBy = "lisSfGuardGroupList")
    private List<LisSfGuardUser> lisSfGuardUserList;

    public LisSfGuardGroup() {
    }

    public LisSfGuardGroup(Integer id) {
        this.id = id;
    }

    public LisSfGuardGroup(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @XmlTransient
    public List<LisSfGuardPermission> getLisSfGuardPermissionList() {
        return lisSfGuardPermissionList;
    }

    public void setLisSfGuardPermissionList(List<LisSfGuardPermission> lisSfGuardPermissionList) {
        this.lisSfGuardPermissionList = lisSfGuardPermissionList;
    }

    @XmlTransient
    public List<LisSfGuardUser> getLisSfGuardUserList() {
        return lisSfGuardUserList;
    }

    public void setLisSfGuardUserList(List<LisSfGuardUser> lisSfGuardUserList) {
        this.lisSfGuardUserList = lisSfGuardUserList;
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
        if (!(object instanceof LisSfGuardGroup)) {
            return false;
        }
        LisSfGuardGroup other = (LisSfGuardGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.LisSfGuardGroup[ id=" + id + " ]";
    }
    
}
