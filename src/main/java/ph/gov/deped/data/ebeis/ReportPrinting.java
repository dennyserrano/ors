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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "report_printing", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportPrinting.findAll", query = "SELECT r FROM ReportPrinting r")})
public class ReportPrinting implements Serializable {
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
    @Column(name = "report_status", nullable = false)
    private int reportStatus;
    @Basic(optional = false)
    @Column(name = "report_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportDate;
    @Column(length = 32)
    private String tab;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String path;
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String checksum;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "created_by", nullable = false)
    private int createdBy;

    public ReportPrinting() {
    }

    public ReportPrinting(Integer id) {
        this.id = id;
    }

    public ReportPrinting(Integer id, int reportHistoryId, int reportStatus, Date reportDate, String path, String checksum, Date createdAt, int createdBy) {
        this.id = id;
        this.reportHistoryId = reportHistoryId;
        this.reportStatus = reportStatus;
        this.reportDate = reportDate;
        this.path = path;
        this.checksum = checksum;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
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

    public int getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(int reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportPrinting)) {
            return false;
        }
        ReportPrinting other = (ReportPrinting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.ReportPrinting[ id=" + id + " ]";
    }
    
}
