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
@Table(name = "batch_report_validation_log", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BatchReportValidationLog.findAll", query = "SELECT b FROM BatchReportValidationLog b")})
public class BatchReportValidationLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "ref_report_history_id")
    private Integer refReportHistoryId;
    @Column(name = "ref_office_id")
    private Short refOfficeId;
    @Column(name = "no_of_reports_validated")
    private Integer noOfReportsValidated;
    @Basic(optional = false)
    @Column(name = "validated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date validatedAt;
    @Column(name = "validated_by")
    private Integer validatedBy;
    @Column(length = 2000)
    private String remarks;

    public BatchReportValidationLog() {
    }

    public BatchReportValidationLog(Integer id) {
        this.id = id;
    }

    public BatchReportValidationLog(Integer id, Date validatedAt) {
        this.id = id;
        this.validatedAt = validatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRefReportHistoryId() {
        return refReportHistoryId;
    }

    public void setRefReportHistoryId(Integer refReportHistoryId) {
        this.refReportHistoryId = refReportHistoryId;
    }

    public Short getRefOfficeId() {
        return refOfficeId;
    }

    public void setRefOfficeId(Short refOfficeId) {
        this.refOfficeId = refOfficeId;
    }

    public Integer getNoOfReportsValidated() {
        return noOfReportsValidated;
    }

    public void setNoOfReportsValidated(Integer noOfReportsValidated) {
        this.noOfReportsValidated = noOfReportsValidated;
    }

    public Date getValidatedAt() {
        return validatedAt;
    }

    public void setValidatedAt(Date validatedAt) {
        this.validatedAt = validatedAt;
    }

    public Integer getValidatedBy() {
        return validatedBy;
    }

    public void setValidatedBy(Integer validatedBy) {
        this.validatedBy = validatedBy;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
        if (!(object instanceof BatchReportValidationLog)) {
            return false;
        }
        BatchReportValidationLog other = (BatchReportValidationLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.BatchReportValidationLog[ id=" + id + " ]";
    }
    
}
