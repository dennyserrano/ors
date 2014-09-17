/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "sf_guard_remember_key", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SfGuardRememberKey.findAll", query = "SELECT s FROM SfGuardRememberKey s")})
public class SfGuardRememberKey implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private SfGuardRememberKeyPK sfGuardRememberKeyPK;
    @Column(name = "remember_key", length = 32)
    private String rememberKey;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SfGuardUser sfGuardUser;

    public SfGuardRememberKey() {
    }

    public SfGuardRememberKey(SfGuardRememberKeyPK sfGuardRememberKeyPK) {
        this.sfGuardRememberKeyPK = sfGuardRememberKeyPK;
    }

    public SfGuardRememberKey(int userId, String ipAddress) {
        this.sfGuardRememberKeyPK = new SfGuardRememberKeyPK(userId, ipAddress);
    }

    public SfGuardRememberKeyPK getSfGuardRememberKeyPK() {
        return sfGuardRememberKeyPK;
    }

    public void setSfGuardRememberKeyPK(SfGuardRememberKeyPK sfGuardRememberKeyPK) {
        this.sfGuardRememberKeyPK = sfGuardRememberKeyPK;
    }

    public String getRememberKey() {
        return rememberKey;
    }

    public void setRememberKey(String rememberKey) {
        this.rememberKey = rememberKey;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public SfGuardUser getSfGuardUser() {
        return sfGuardUser;
    }

    public void setSfGuardUser(SfGuardUser sfGuardUser) {
        this.sfGuardUser = sfGuardUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sfGuardRememberKeyPK != null ? sfGuardRememberKeyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SfGuardRememberKey)) {
            return false;
        }
        SfGuardRememberKey other = (SfGuardRememberKey) object;
        if ((this.sfGuardRememberKeyPK == null && other.sfGuardRememberKeyPK != null) || (this.sfGuardRememberKeyPK != null && !this.sfGuardRememberKeyPK.equals(other.sfGuardRememberKeyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.LisSfGuardRememberKey[ sfGuardRememberKeyPK=" + sfGuardRememberKeyPK + " ]";
    }
    
}
