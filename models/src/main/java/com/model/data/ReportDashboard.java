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
@Table(name = "report_dashboard", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportDashboard.findAll", query = "SELECT r FROM ReportDashboard r")})
public class ReportDashboard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short id;
    @Column(name = "dashboard_id")
    private Short dashboardId;
    @Column(name = "dimension_id")
    private Short dimensionId;
    @Column(name = "category_id")
    private Short categoryId;
    @Column(name = "repository_uri", length = 255)
    private String repositoryUri;
    @Column(name = "extra_param", length = 32)
    private String extraParam;
    @Lob
    @Column(length = 65535)
    private String assumption;

    public ReportDashboard() {
    }

    public ReportDashboard(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Short getDashboardId() {
        return dashboardId;
    }

    public void setDashboardId(Short dashboardId) {
        this.dashboardId = dashboardId;
    }

    public Short getDimensionId() {
        return dimensionId;
    }

    public void setDimensionId(Short dimensionId) {
        this.dimensionId = dimensionId;
    }

    public Short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Short categoryId) {
        this.categoryId = categoryId;
    }

    public String getRepositoryUri() {
        return repositoryUri;
    }

    public void setRepositoryUri(String repositoryUri) {
        this.repositoryUri = repositoryUri;
    }

    public String getExtraParam() {
        return extraParam;
    }

    public void setExtraParam(String extraParam) {
        this.extraParam = extraParam;
    }

    public String getAssumption() {
        return assumption;
    }

    public void setAssumption(String assumption) {
        this.assumption = assumption;
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
        if (!(object instanceof ReportDashboard)) {
            return false;
        }
        ReportDashboard other = (ReportDashboard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.ReportDashboard[ id=" + id + " ]";
    }
    
}
