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
@Table(name = "sf_guard_permission", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LisSfGuardPermission.findAll", query = "SELECT s FROM LisSfGuardPermission s")})
public class LisSfGuardPermission implements Serializable {
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
    @ManyToMany(mappedBy = "lisSfGuardPermissionList")
    private List<LisSfGuardGroup> lisSfGuardGroupList;
    @ManyToMany(mappedBy = "lisSfGuardPermissionList")
    private List<LisSfGuardUser> lisSfGuardUserList;

    public LisSfGuardPermission() {
    }

    public LisSfGuardPermission(Integer id) {
        this.id = id;
    }

    public LisSfGuardPermission(Integer id, String name) {
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

    @XmlTransient
    public List<LisSfGuardGroup> getLisSfGuardGroupList() {
        return lisSfGuardGroupList;
    }

    public void setLisSfGuardGroupList(List<LisSfGuardGroup> lisSfGuardGroupList) {
        this.lisSfGuardGroupList = lisSfGuardGroupList;
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
        if (!(object instanceof LisSfGuardPermission)) {
            return false;
        }
        LisSfGuardPermission other = (LisSfGuardPermission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.LisSfGuardPermission[ id=" + id + " ]";
    }
    
}
