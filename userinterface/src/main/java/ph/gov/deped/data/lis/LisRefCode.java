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
import javax.persistence.Id;
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
@Table(name = "ref_code", catalog = "lis2db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"}),
    @UniqueConstraint(columnNames = {"title"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LisRefCode.findAll", query = "SELECT r FROM LisRefCode r")})
public class LisRefCode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Short id;
    @Basic(optional = false)
    @Column(nullable = false, length = 15)
    private String code;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String title;
    @Column(length = 500)
    private String description;
    private Short tmpid;
    @Column(name = "org_id")
    private Short orgId;

    public LisRefCode() {
    }

    public LisRefCode(Short id) {
        this.id = id;
    }

    public LisRefCode(Short id, String code, String title) {
        this.id = id;
        this.code = code;
        this.title = title;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getTmpid() {
        return tmpid;
    }

    public void setTmpid(Short tmpid) {
        this.tmpid = tmpid;
    }

    public Short getOrgId() {
        return orgId;
    }

    public void setOrgId(Short orgId) {
        this.orgId = orgId;
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
        if (!(object instanceof LisRefCode)) {
            return false;
        }
        LisRefCode other = (LisRefCode) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.LisRefCode[ id=" + id + " ]";
    }
    
}
