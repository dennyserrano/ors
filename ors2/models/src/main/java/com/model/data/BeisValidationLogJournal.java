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
@Table(name = "beis_validation_log_journal", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BeisValidationLogJournal.findAll", query = "SELECT b FROM BeisValidationLogJournal b")})
public class BeisValidationLogJournal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "beis_validation_log_id", nullable = false)
    private int beisValidationLogId;
    @Column(name = "report_history_id")
    private Integer reportHistoryId;
    @Column(name = "ref_beis_datasets_id")
    private Short refBeisDatasetsId;
    @Column(name = "validation_type")
    private Short validationType;
    @Basic(optional = false)
    @Column(name = "msg_id", nullable = false)
    private short msgId;
    @Basic(optional = false)
    @Column(name = "entry_no", nullable = false)
    private short entryNo;
    @Column(length = 255)
    private String message;
    @Column(name = "resolved_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resolvedDate;
    @Column(name = "validation_item_code")
    private Integer validationItemCode;
    @Column(name = "org_created_by")
    private Integer orgCreatedBy;
    @Column(name = "org_created_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orgCreatedDt;
    @Column(name = "org_updated_by")
    private Integer orgUpdatedBy;
    @Column(name = "org_updated_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orgUpdatedDt;
    @Basic(optional = false)
    @Column(name = "journal_dt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date journalDt;

    public BeisValidationLogJournal() {
    }

    public BeisValidationLogJournal(Long id) {
        this.id = id;
    }

    public BeisValidationLogJournal(Long id, int beisValidationLogId, short msgId, short entryNo, Date journalDt) {
        this.id = id;
        this.beisValidationLogId = beisValidationLogId;
        this.msgId = msgId;
        this.entryNo = entryNo;
        this.journalDt = journalDt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBeisValidationLogId() {
        return beisValidationLogId;
    }

    public void setBeisValidationLogId(int beisValidationLogId) {
        this.beisValidationLogId = beisValidationLogId;
    }

    public Integer getReportHistoryId() {
        return reportHistoryId;
    }

    public void setReportHistoryId(Integer reportHistoryId) {
        this.reportHistoryId = reportHistoryId;
    }

    public Short getRefBeisDatasetsId() {
        return refBeisDatasetsId;
    }

    public void setRefBeisDatasetsId(Short refBeisDatasetsId) {
        this.refBeisDatasetsId = refBeisDatasetsId;
    }

    public Short getValidationType() {
        return validationType;
    }

    public void setValidationType(Short validationType) {
        this.validationType = validationType;
    }

    public short getMsgId() {
        return msgId;
    }

    public void setMsgId(short msgId) {
        this.msgId = msgId;
    }

    public short getEntryNo() {
        return entryNo;
    }

    public void setEntryNo(short entryNo) {
        this.entryNo = entryNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(Date resolvedDate) {
        this.resolvedDate = resolvedDate;
    }

    public Integer getValidationItemCode() {
        return validationItemCode;
    }

    public void setValidationItemCode(Integer validationItemCode) {
        this.validationItemCode = validationItemCode;
    }

    public Integer getOrgCreatedBy() {
        return orgCreatedBy;
    }

    public void setOrgCreatedBy(Integer orgCreatedBy) {
        this.orgCreatedBy = orgCreatedBy;
    }

    public Date getOrgCreatedDt() {
        return orgCreatedDt;
    }

    public void setOrgCreatedDt(Date orgCreatedDt) {
        this.orgCreatedDt = orgCreatedDt;
    }

    public Integer getOrgUpdatedBy() {
        return orgUpdatedBy;
    }

    public void setOrgUpdatedBy(Integer orgUpdatedBy) {
        this.orgUpdatedBy = orgUpdatedBy;
    }

    public Date getOrgUpdatedDt() {
        return orgUpdatedDt;
    }

    public void setOrgUpdatedDt(Date orgUpdatedDt) {
        this.orgUpdatedDt = orgUpdatedDt;
    }

    public Date getJournalDt() {
        return journalDt;
    }

    public void setJournalDt(Date journalDt) {
        this.journalDt = journalDt;
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
        if (!(object instanceof BeisValidationLogJournal)) {
            return false;
        }
        BeisValidationLogJournal other = (BeisValidationLogJournal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.BeisValidationLogJournal[ id=" + id + " ]";
    }
    
}
