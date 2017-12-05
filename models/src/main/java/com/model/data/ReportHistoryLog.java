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
@Table(name = "report_history_log", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportHistoryLog.findAll", query = "SELECT r FROM ReportHistoryLog r")})
public class ReportHistoryLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "report_history_id")
    private Integer reportHistoryId;
    @Column(name = "old_report_status")
    private Short oldReportStatus;
    @Column(name = "new_report_status")
    private Short newReportStatus;
    @Column(name = "conn_id")
    private Integer connId;
    @Basic(optional = false)
    @Column(name = "time_stamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    public ReportHistoryLog() {
    }

    public ReportHistoryLog(Integer id) {
        this.id = id;
    }

    public ReportHistoryLog(Integer id, Date timeStamp) {
        this.id = id;
        this.timeStamp = timeStamp;
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

    public Short getOldReportStatus() {
        return oldReportStatus;
    }

    public void setOldReportStatus(Short oldReportStatus) {
        this.oldReportStatus = oldReportStatus;
    }

    public Short getNewReportStatus() {
        return newReportStatus;
    }

    public void setNewReportStatus(Short newReportStatus) {
        this.newReportStatus = newReportStatus;
    }

    public Integer getConnId() {
        return connId;
    }

    public void setConnId(Integer connId) {
        this.connId = connId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
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
        if (!(object instanceof ReportHistoryLog)) {
            return false;
        }
        ReportHistoryLog other = (ReportHistoryLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.ReportHistoryLog[ id=" + id + " ]";
    }
    
}
