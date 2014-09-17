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
@Table(name = "sf_guard_user_journal", catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SfGuardUserJournal.findAll", query = "SELECT s FROM SfGuardUserJournal s")})
public class SfGuardUserJournal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sf_guard_user_id", nullable = false)
    private int sfGuardUserId;
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
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Basic(optional = false)
    @Column(name = "is_active", nullable = false)
    private short isActive;
    @Basic(optional = false)
    @Column(name = "is_super_admin", nullable = false)
    private short isSuperAdmin;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "created_by", nullable = false)
    private int createdBy;
    @Basic(optional = false)
    @Column(name = "updated_by", nullable = false)
    private int updatedBy;

    public SfGuardUserJournal() {
    }

    public SfGuardUserJournal(Integer id) {
        this.id = id;
    }

    public SfGuardUserJournal(Integer id, int sfGuardUserId, String username, String algorithm, String salt, String password, Date createdAt, short isActive, short isSuperAdmin, Date updatedAt, int createdBy, int updatedBy) {
        this.id = id;
        this.sfGuardUserId = sfGuardUserId;
        this.username = username;
        this.algorithm = algorithm;
        this.salt = salt;
        this.password = password;
        this.createdAt = createdAt;
        this.isActive = isActive;
        this.isSuperAdmin = isSuperAdmin;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSfGuardUserId() {
        return sfGuardUserId;
    }

    public void setSfGuardUserId(int sfGuardUserId) {
        this.sfGuardUserId = sfGuardUserId;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
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
        if (!(object instanceof SfGuardUserJournal)) {
            return false;
        }
        SfGuardUserJournal other = (SfGuardUserJournal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.SfGuardUserJournal[ id=" + id + " ]";
    }
    
}
