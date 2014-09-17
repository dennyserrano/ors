/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ej
 */
@Embeddable
public class SfGuardRememberKeyPK implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 2617259745779544180L;
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic(optional = false)
    @Column(name = "ip_address", nullable = false, length = 50)
    private String ipAddress;

    public SfGuardRememberKeyPK() {
    }

    public SfGuardRememberKeyPK(int userId, String ipAddress) {
        this.userId = userId;
        this.ipAddress = ipAddress;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (ipAddress != null ? ipAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SfGuardRememberKeyPK)) {
            return false;
        }
        SfGuardRememberKeyPK other = (SfGuardRememberKeyPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if ((this.ipAddress == null && other.ipAddress != null) || (this.ipAddress != null && !this.ipAddress.equals(other.ipAddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.SfGuardRememberKeyPK[ userId=" + userId + ", ipAddress=" + ipAddress + " ]";
    }
    
}
