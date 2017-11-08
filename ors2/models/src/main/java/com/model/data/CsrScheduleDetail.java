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
@Table(name = "csr_schedule_detail", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsrScheduleDetail.findAll", query = "SELECT c FROM CsrScheduleDetail c")})
public class CsrScheduleDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "schedule_id", nullable = false)
    private int scheduleId;
    @Basic(optional = false)
    @Column(name = "aggregation_level_id", nullable = false)
    private int aggregationLevelId;
    @Basic(optional = false)
    @Column(name = "reference_id", nullable = false)
    private int referenceId;
    @Column(name = "date_executed")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateExecuted;
    @Column(name = "date_completed")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCompleted;
    @Basic(optional = false)
    @Column(name = "execution_status_id", nullable = false)
    private int executionStatusId;

    public CsrScheduleDetail() {
    }

    public CsrScheduleDetail(Integer id) {
        this.id = id;
    }

    public CsrScheduleDetail(Integer id, int scheduleId, int aggregationLevelId, int referenceId, int executionStatusId) {
        this.id = id;
        this.scheduleId = scheduleId;
        this.aggregationLevelId = aggregationLevelId;
        this.referenceId = referenceId;
        this.executionStatusId = executionStatusId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getAggregationLevelId() {
        return aggregationLevelId;
    }

    public void setAggregationLevelId(int aggregationLevelId) {
        this.aggregationLevelId = aggregationLevelId;
    }

    public int getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }

    public Date getDateExecuted() {
        return dateExecuted;
    }

    public void setDateExecuted(Date dateExecuted) {
        this.dateExecuted = dateExecuted;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public int getExecutionStatusId() {
        return executionStatusId;
    }

    public void setExecutionStatusId(int executionStatusId) {
        this.executionStatusId = executionStatusId;
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
        if (!(object instanceof CsrScheduleDetail)) {
            return false;
        }
        CsrScheduleDetail other = (CsrScheduleDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.CsrScheduleDetail[ id=" + id + " ]";
    }
    
}
