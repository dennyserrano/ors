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
 * @author ej
 */
@Entity
@Table(name = "other_yearly_data", catalog = "sisdb", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"report_history_id", "category_id", "item_id", "sy_from"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "OtherYearlyData.findAll", query = "SELECT o FROM OtherYearlyData o")})
public class OtherYearlyData implements Serializable {
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
    @Column(name = "category_id", nullable = false)
    private short categoryId;

    @Basic(optional = false)
    @Column(name = "item_id", nullable = false)
    private short itemId;

    @Basic(optional = false)
    @Column(name = "sy_from", nullable = false)
    private short syFrom;

    @Basic(optional = false)
    @Column(nullable = false)
    private float figure;

    @Basic(optional = false)
    @Column(name = "created_by", nullable = false)
    private int createdBy;

    @Basic(optional = false)
    @Column(name = "created_dt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDt;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public OtherYearlyData() {
    }

    public OtherYearlyData(Integer id) {
        this.id = id;
    }

    public OtherYearlyData(Integer id, int reportHistoryId, short categoryId, short itemId, short syFrom, float figure, int createdBy, Date createdDt, Date updatedAt) {
        this.id = id;
        this.reportHistoryId = reportHistoryId;
        this.categoryId = categoryId;
        this.itemId = itemId;
        this.syFrom = syFrom;
        this.figure = figure;
        this.createdBy = createdBy;
        this.createdDt = createdDt;
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

    public short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(short categoryId) {
        this.categoryId = categoryId;
    }

    public short getItemId() {
        return itemId;
    }

    public void setItemId(short itemId) {
        this.itemId = itemId;
    }

    public short getSyFrom() {
        return syFrom;
    }

    public void setSyFrom(short syFrom) {
        this.syFrom = syFrom;
    }

    public float getFigure() {
        return figure;
    }

    public void setFigure(float figure) {
        this.figure = figure;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
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
        if (!(object instanceof OtherYearlyData)) {
            return false;
        }
        OtherYearlyData other = (OtherYearlyData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.OtherYearlyData[ id=" + id + " ]";
    }

}
