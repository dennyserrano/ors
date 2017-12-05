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
@Table(name = "ref_province_history", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sy_from", "nscb_code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefProvinceHistory.findAll", query = "SELECT r FROM RefProvinceHistory r")})
public class RefProvinceHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short id;
    @Basic(optional = false)
    @Column(name = "ref_province_id", nullable = false)
    private short refProvinceId;
    @Column(name = "province_name", length = 30)
    private String provinceName;
    @Column(name = "nscb_code", length = 4)
    private String nscbCode;
    @Basic(optional = false)
    @Column(name = "ref_region_id", nullable = false)
    private short refRegionId;
    @Basic(optional = false)
    @Column(name = "sy_from", nullable = false)
    private short syFrom;
    @Basic(optional = false)
    @Column(name = "sy_to", nullable = false)
    private short syTo;
    @Basic(optional = false)
    @Column(name = "created_by", nullable = false)
    private int createdBy;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public RefProvinceHistory() {
    }

    public RefProvinceHistory(Short id) {
        this.id = id;
    }

    public RefProvinceHistory(Short id, short refProvinceId, short refRegionId, short syFrom, short syTo, int createdBy, Date createdAt) {
        this.id = id;
        this.refProvinceId = refProvinceId;
        this.refRegionId = refRegionId;
        this.syFrom = syFrom;
        this.syTo = syTo;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public short getRefProvinceId() {
        return refProvinceId;
    }

    public void setRefProvinceId(short refProvinceId) {
        this.refProvinceId = refProvinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getNscbCode() {
        return nscbCode;
    }

    public void setNscbCode(String nscbCode) {
        this.nscbCode = nscbCode;
    }

    public short getRefRegionId() {
        return refRegionId;
    }

    public void setRefRegionId(short refRegionId) {
        this.refRegionId = refRegionId;
    }

    public short getSyFrom() {
        return syFrom;
    }

    public void setSyFrom(short syFrom) {
        this.syFrom = syFrom;
    }

    public short getSyTo() {
        return syTo;
    }

    public void setSyTo(short syTo) {
        this.syTo = syTo;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
        if (!(object instanceof RefProvinceHistory)) {
            return false;
        }
        RefProvinceHistory other = (RefProvinceHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.RefProvinceHistory[ id=" + id + " ]";
    }
    
}
