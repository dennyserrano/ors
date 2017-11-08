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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "request_revert_details", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestRevertDetails.findAll", query = "SELECT r FROM RequestRevertDetails r")})
public class RequestRevertDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "request_revert_id", nullable = false)
    private int requestRevertId;
    @Basic(optional = false)
    @Column(name = "report_history_id", nullable = false)
    private int reportHistoryId;
    @Basic(optional = false)
    @Column(name = "status_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date statusDate;
    @Basic(optional = false)
    @Column(name = "status_commited_by", nullable = false)
    private int statusCommitedBy;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "created_by", nullable = false)
    private int createdBy;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "updated_by", nullable = false)
    private int updatedBy;

    public RequestRevertDetails() {
    }

    public RequestRevertDetails(Integer id) {
        this.id = id;
    }

    public RequestRevertDetails(Integer id, int requestRevertId, int reportHistoryId, Date statusDate, int statusCommitedBy, int createdBy, int updatedBy) {
        this.id = id;
        this.requestRevertId = requestRevertId;
        this.reportHistoryId = reportHistoryId;
        this.statusDate = statusDate;
        this.statusCommitedBy = statusCommitedBy;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRequestRevertId() {
        return requestRevertId;
    }

    public void setRequestRevertId(int requestRevertId) {
        this.requestRevertId = requestRevertId;
    }

    public int getReportHistoryId() {
        return reportHistoryId;
    }

    public void setReportHistoryId(int reportHistoryId) {
        this.reportHistoryId = reportHistoryId;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public int getStatusCommitedBy() {
        return statusCommitedBy;
    }

    public void setStatusCommitedBy(int statusCommitedBy) {
        this.statusCommitedBy = statusCommitedBy;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequestRevertDetails)) {
            return false;
        }
        RequestRevertDetails other = (RequestRevertDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.RequestRevertDetails[ id=" + id + " ]";
    }
    
}
