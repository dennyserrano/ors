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
@Table(name = "beis_validation_log", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BeisValidationLog.findAll", query = "SELECT b FROM BeisValidationLog b")})
public class BeisValidationLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
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
    @Column(name = "created_by")
    private Integer createdBy;
    @Basic(optional = false)
    @Column(name = "created_dt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDt;
    @Column(name = "updated_by")
    private Integer updatedBy;
    @Column(name = "updated_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDt;

    public BeisValidationLog() {
    }

    public BeisValidationLog(Integer id) {
        this.id = id;
    }

    public BeisValidationLog(Integer id, short msgId, short entryNo, Date createdDt) {
        this.id = id;
        this.msgId = msgId;
        this.entryNo = entryNo;
        this.createdDt = createdDt;
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

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(Date updatedDt) {
        this.updatedDt = updatedDt;
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
        if (!(object instanceof BeisValidationLog)) {
            return false;
        }
        BeisValidationLog other = (BeisValidationLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.BeisValidationLog[ id=" + id + " ]";
    }
    
}
