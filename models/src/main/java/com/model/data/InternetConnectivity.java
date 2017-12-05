/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model.data;

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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "internet_connectivity", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"report_history_id", "connection_type_id", "connection_profile_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InternetConnectivity.findAll", query = "SELECT i FROM InternetConnectivity i")})
public class InternetConnectivity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "report_history_id")
    private Integer reportHistoryId;
    @Column(name = "connection_type_id")
    private Short connectionTypeId;
    @Column(name = "connection_profile_id")
    private Short connectionProfileId;
    @Column(name = "connection_figure")
    private Short connectionFigure;
    @Column(name = "updated_by")
    private Integer updatedBy;
    @Column(name = "created_by")
    private Integer createdBy;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public InternetConnectivity() {
    }

    public InternetConnectivity(Integer id) {
        this.id = id;
    }

    public InternetConnectivity(Integer id, Date createdAt, Date updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReportHistoryId() {
        return reportHistoryId;
    }

    public void setReportHistoryId(Integer reportHistoryId) {
        this.reportHistoryId = reportHistoryId;
    }

    public Short getConnectionTypeId() {
        return connectionTypeId;
    }

    public void setConnectionTypeId(Short connectionTypeId) {
        this.connectionTypeId = connectionTypeId;
    }

    public Short getConnectionProfileId() {
        return connectionProfileId;
    }

    public void setConnectionProfileId(Short connectionProfileId) {
        this.connectionProfileId = connectionProfileId;
    }

    public Short getConnectionFigure() {
        return connectionFigure;
    }

    public void setConnectionFigure(Short connectionFigure) {
        this.connectionFigure = connectionFigure;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
        if (!(object instanceof InternetConnectivity)) {
            return false;
        }
        InternetConnectivity other = (InternetConnectivity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.InternetConnectivity[ id=" + id + " ]";
    }
    
}
