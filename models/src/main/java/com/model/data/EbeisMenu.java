/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "ebeis_menu", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EbeisMenu.findAll", query = "SELECT e FROM EbeisMenu e")})
public class EbeisMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "parent_id")
    private Integer parentId;
    @Column(length = 32)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String title;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String url;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String params;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String attrs;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String roles;
    @Basic(optional = false)
    @Column(nullable = false)
    private int lft;
    @Basic(optional = false)
    @Column(nullable = false)
    private int rgt;
    @Basic(optional = false)
    @Column(nullable = false)
    private int lvl;
    private Integer root;

    public EbeisMenu() {
    }

    public EbeisMenu(Integer id) {
        this.id = id;
    }

    public EbeisMenu(Integer id, String title, String url, String params, String attrs, String roles, int lft, int rgt, int lvl) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.params = params;
        this.attrs = attrs;
        this.roles = roles;
        this.lft = lft;
        this.rgt = rgt;
        this.lvl = lvl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getAttrs() {
        return attrs;
    }

    public void setAttrs(String attrs) {
        this.attrs = attrs;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getLft() {
        return lft;
    }

    public void setLft(int lft) {
        this.lft = lft;
    }

    public int getRgt() {
        return rgt;
    }

    public void setRgt(int rgt) {
        this.rgt = rgt;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public Integer getRoot() {
        return root;
    }

    public void setRoot(Integer root) {
        this.root = root;
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
        if (!(object instanceof EbeisMenu)) {
            return false;
        }
        EbeisMenu other = (EbeisMenu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.EbeisMenu[ id=" + id + " ]";
    }
    
}
