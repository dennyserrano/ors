/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

import java.io.Serializable;
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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "fos_oauth_client", catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FosOauthClient.findAll", query = "SELECT f FROM FosOauthClient f")})
public class FosOauthClient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "random_id", nullable = false, length = 255)
    private String randomId;
    @Basic(optional = false)
    @Lob
    @Column(name = "redirect_uris", nullable = false, length = 2147483647)
    private String redirectUris;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String secret;
    @Basic(optional = false)
    @Lob
    @Column(name = "allowed_grant_types", nullable = false, length = 2147483647)
    private String allowedGrantTypes;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String homepage;
    @JoinTable(name = "fos_oauth_user_client", joinColumns = {
        @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<LisSfGuardUser> lisSfGuardUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private List<FosOauthRefreshToken> fosOauthRefreshTokenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private List<FosOauthAuthCode> fosOauthAuthCodeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private List<FosOauthAccessToken> fosOauthAccessTokenList;

    public FosOauthClient() {
    }

    public FosOauthClient(Integer id) {
        this.id = id;
    }

    public FosOauthClient(Integer id, String randomId, String redirectUris, String secret, String allowedGrantTypes, String name, String homepage) {
        this.id = id;
        this.randomId = randomId;
        this.redirectUris = redirectUris;
        this.secret = secret;
        this.allowedGrantTypes = allowedGrantTypes;
        this.name = name;
        this.homepage = homepage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRandomId() {
        return randomId;
    }

    public void setRandomId(String randomId) {
        this.randomId = randomId;
    }

    public String getRedirectUris() {
        return redirectUris;
    }

    public void setRedirectUris(String redirectUris) {
        this.redirectUris = redirectUris;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getAllowedGrantTypes() {
        return allowedGrantTypes;
    }

    public void setAllowedGrantTypes(String allowedGrantTypes) {
        this.allowedGrantTypes = allowedGrantTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @XmlTransient
    public List<LisSfGuardUser> getLisSfGuardUserList() {
        return lisSfGuardUserList;
    }

    public void setLisSfGuardUserList(List<LisSfGuardUser> lisSfGuardUserList) {
        this.lisSfGuardUserList = lisSfGuardUserList;
    }

    @XmlTransient
    public List<FosOauthRefreshToken> getFosOauthRefreshTokenList() {
        return fosOauthRefreshTokenList;
    }

    public void setFosOauthRefreshTokenList(List<FosOauthRefreshToken> fosOauthRefreshTokenList) {
        this.fosOauthRefreshTokenList = fosOauthRefreshTokenList;
    }

    @XmlTransient
    public List<FosOauthAuthCode> getFosOauthAuthCodeList() {
        return fosOauthAuthCodeList;
    }

    public void setFosOauthAuthCodeList(List<FosOauthAuthCode> fosOauthAuthCodeList) {
        this.fosOauthAuthCodeList = fosOauthAuthCodeList;
    }

    @XmlTransient
    public List<FosOauthAccessToken> getFosOauthAccessTokenList() {
        return fosOauthAccessTokenList;
    }

    public void setFosOauthAccessTokenList(List<FosOauthAccessToken> fosOauthAccessTokenList) {
        this.fosOauthAccessTokenList = fosOauthAccessTokenList;
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
        if (!(object instanceof FosOauthClient)) {
            return false;
        }
        FosOauthClient other = (FosOauthClient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.FosOauthClient[ id=" + id + " ]";
    }
    
}
