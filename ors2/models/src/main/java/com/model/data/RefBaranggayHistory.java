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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ref_baranggay_history", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nscb_code", "sy_from"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefBaranggayHistory.findAll", query = "SELECT r FROM RefBaranggayHistory r")})
public class RefBaranggayHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ref_baranggay_id", nullable = false)
    private int refBaranggayId;
    @Basic(optional = false)
    @Column(name = "nscb_code", nullable = false, length = 9)
    private String nscbCode;
    @Basic(optional = false)
    @Column(name = "brgy_name", nullable = false, length = 40)
    private String brgyName;
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
    @JoinColumn(name = "ref_municipality_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefMunicipality refMunicipalityId;

    public RefBaranggayHistory() {
    }

    public RefBaranggayHistory(Integer id) {
        this.id = id;
    }

    public RefBaranggayHistory(Integer id, int refBaranggayId, String nscbCode, String brgyName, short syFrom, short syTo, int createdBy, Date createdAt) {
        this.id = id;
        this.refBaranggayId = refBaranggayId;
        this.nscbCode = nscbCode;
        this.brgyName = brgyName;
        this.syFrom = syFrom;
        this.syTo = syTo;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRefBaranggayId() {
        return refBaranggayId;
    }

    public void setRefBaranggayId(int refBaranggayId) {
        this.refBaranggayId = refBaranggayId;
    }

    public String getNscbCode() {
        return nscbCode;
    }

    public void setNscbCode(String nscbCode) {
        this.nscbCode = nscbCode;
    }

    public String getBrgyName() {
        return brgyName;
    }

    public void setBrgyName(String brgyName) {
        this.brgyName = brgyName;
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

    public RefMunicipality getRefMunicipalityId() {
        return refMunicipalityId;
    }

    public void setRefMunicipalityId(RefMunicipality refMunicipalityId) {
        this.refMunicipalityId = refMunicipalityId;
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
        if (!(object instanceof RefBaranggayHistory)) {
            return false;
        }
        RefBaranggayHistory other = (RefBaranggayHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.RefBaranggayHistory[ id=" + id + " ]";
    }
    
}
