/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "sf_guard_user", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SfGuardUser.findAll", query = "SELECT s FROM SfGuardUser s")})
public class SfGuardUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 128)
    private String username;
    @Basic(optional = false)
    @Column(nullable = false, length = 128)
    private String algorithm;
    @Basic(optional = false)
    @Column(nullable = false, length = 128)
    private String salt;
    @Basic(optional = false)
    @Column(nullable = false, length = 128)
    private String password;
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Basic(optional = false)
    @Column(name = "is_active", nullable = false)
    private short isActive;
    @Basic(optional = false)
    @Column(name = "is_super_admin", nullable = false)
    private short isSuperAdmin;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "created_by", nullable = false)
    private int createdBy;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "updated_by", nullable = false)
    private int updatedBy;
    @JoinTable(name = "sf_guard_user_permission", joinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "permission_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<SfGuardPermission> sfGuardPermissionList;
    @JoinTable(name = "sf_guard_user_group", joinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<SfGuardGroup> sfGuardGroupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sfGuardUser")
    private List<SfGuardRememberKey> sfGuardRememberKeyList;
    @OneToMany(mappedBy = "sfGuardUserId")
    private List<SfGuardUserProfile> sfGuardUserProfileList;

    public SfGuardUser() {
    }

    public SfGuardUser(Integer id) {
        this.id = id;
    }

    public SfGuardUser(Integer id, String username, String algorithm, String salt, String password, short isActive, short isSuperAdmin, int createdBy, Date updatedAt, int updatedBy) {
        this.id = id;
        this.username = username;
        this.algorithm = algorithm;
        this.salt = salt;
        this.password = password;
        this.isActive = isActive;
        this.isSuperAdmin = isSuperAdmin;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    public short getIsSuperAdmin() {
        return isSuperAdmin;
    }

    public void setIsSuperAdmin(short isSuperAdmin) {
        this.isSuperAdmin = isSuperAdmin;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    @XmlTransient
    public List<SfGuardPermission> getSfGuardPermissionList() {
        return sfGuardPermissionList;
    }

    public void setSfGuardPermissionList(List<SfGuardPermission> sfGuardPermissionList) {
        this.sfGuardPermissionList = sfGuardPermissionList;
    }

    @XmlTransient
    public List<SfGuardGroup> getSfGuardGroupList() {
        return sfGuardGroupList;
    }

    public void setSfGuardGroupList(List<SfGuardGroup> sfGuardGroupList) {
        this.sfGuardGroupList = sfGuardGroupList;
    }

    @XmlTransient
    public List<SfGuardRememberKey> getSfGuardRememberKeyList() {
        return sfGuardRememberKeyList;
    }

    public void setSfGuardRememberKeyList(List<SfGuardRememberKey> sfGuardRememberKeyList) {
        this.sfGuardRememberKeyList = sfGuardRememberKeyList;
    }

    @XmlTransient
    public List<SfGuardUserProfile> getSfGuardUserProfileList() {
        return sfGuardUserProfileList;
    }

    public void setSfGuardUserProfileList(List<SfGuardUserProfile> sfGuardUserProfileList) {
        this.sfGuardUserProfileList = sfGuardUserProfileList;
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
        if (!(object instanceof SfGuardUser)) {
            return false;
        }
        SfGuardUser other = (SfGuardUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.LisSfGuardUser[ id=" + id + " ]";
    }
    
}
