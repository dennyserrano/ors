/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

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
@Table(name = "internet_connection", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"report_history_id", "connection_type", "provider_id", "funding_source"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InternetConnection.findAll", query = "SELECT i FROM InternetConnection i")})
public class InternetConnection implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "report_history_id", nullable = false)
    private int reportHistoryId;
    @Basic(optional = false)
    @Column(name = "connection_type", nullable = false)
    private short connectionType;
    @Basic(optional = false)
    @Column(name = "provider_id", nullable = false)
    private short providerId;
    @Basic(optional = false)
    @Column(name = "ave_monthly_cost", nullable = false)
    private float aveMonthlyCost;
    @Basic(optional = false)
    @Column(name = "funding_source", nullable = false)
    private short fundingSource;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "created_by")
    private Integer createdBy;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "updated_by")
    private Integer updatedBy;

    public InternetConnection() {
    }

    public InternetConnection(Integer id) {
        this.id = id;
    }

    public InternetConnection(Integer id, int reportHistoryId, short connectionType, short providerId, float aveMonthlyCost, short fundingSource, Date createdAt, Date updatedAt) {
        this.id = id;
        this.reportHistoryId = reportHistoryId;
        this.connectionType = connectionType;
        this.providerId = providerId;
        this.aveMonthlyCost = aveMonthlyCost;
        this.fundingSource = fundingSource;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getReportHistoryId() {
        return reportHistoryId;
    }

    public void setReportHistoryId(int reportHistoryId) {
        this.reportHistoryId = reportHistoryId;
    }

    public short getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(short connectionType) {
        this.connectionType = connectionType;
    }

    public short getProviderId() {
        return providerId;
    }

    public void setProviderId(short providerId) {
        this.providerId = providerId;
    }

    public float getAveMonthlyCost() {
        return aveMonthlyCost;
    }

    public void setAveMonthlyCost(float aveMonthlyCost) {
        this.aveMonthlyCost = aveMonthlyCost;
    }

    public short getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(short fundingSource) {
        this.fundingSource = fundingSource;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
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
        if (!(object instanceof InternetConnection)) {
            return false;
        }
        InternetConnection other = (InternetConnection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.InternetConnection[ id=" + id + " ]";
    }
    
}
