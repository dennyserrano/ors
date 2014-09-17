/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "fos_oauth_auth_code", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"token"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FosOauthAuthCode.findAll", query = "SELECT f FROM FosOauthAuthCode f")})
public class FosOauthAuthCode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String token;
    @Basic(optional = false)
    @Lob
    @Column(name = "redirect_uri", nullable = false, length = 2147483647)
    private String redirectUri;
    @Column(name = "expires_at")
    private Integer expiresAt;
    @Column(length = 255)
    private String scope;
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private FosOauthClient clientId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private LisSfGuardUser userId;

    public FosOauthAuthCode() {
    }

    public FosOauthAuthCode(Integer id) {
        this.id = id;
    }

    public FosOauthAuthCode(Integer id, String token, String redirectUri) {
        this.id = id;
        this.token = token;
        this.redirectUri = redirectUri;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public Integer getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Integer expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public FosOauthClient getClientId() {
        return clientId;
    }

    public void setClientId(FosOauthClient clientId) {
        this.clientId = clientId;
    }

    public LisSfGuardUser getUserId() {
        return userId;
    }

    public void setUserId(LisSfGuardUser userId) {
        this.userId = userId;
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
        if (!(object instanceof FosOauthAuthCode)) {
            return false;
        }
        FosOauthAuthCode other = (FosOauthAuthCode) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.FosOauthAuthCode[ id=" + id + " ]";
    }
    
}
