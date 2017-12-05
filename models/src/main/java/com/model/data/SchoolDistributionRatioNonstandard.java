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
@Table(name = "school_distribution_ratio_nonstandard", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolDistributionRatioNonstandard.findAll", query = "SELECT s FROM SchoolDistributionRatioNonstandard s")})
public class SchoolDistributionRatioNonstandard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "session_id", nullable = false)
    private int sessionId;
    @Basic(optional = false)
    @Column(name = "school_distribution_ratio_id", nullable = false)
    private int schoolDistributionRatioId;
    @Basic(optional = false)
    @Column(name = "std_ptr", nullable = false)
    private float stdPtr;
    @Basic(optional = false)
    @Column(name = "std_ptr_rainbow_spectrum_id", nullable = false)
    private short stdPtrRainbowSpectrumId;
    @Basic(optional = false)
    @Column(name = "std_pfr", nullable = false)
    private float stdPfr;
    @Basic(optional = false)
    @Column(name = "std_pfr_rainbow_spectrum_id", nullable = false)
    private short stdPfrRainbowSpectrumId;
    @Basic(optional = false)
    @Column(name = "std_pcr", nullable = false)
    private float stdPcr;
    @Basic(optional = false)
    @Column(name = "std_pcr_rainbow_spectrum_id", nullable = false)
    private short stdPcrRainbowSpectrumId;
    @Column(name = "created_by")
    private Integer createdBy;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public SchoolDistributionRatioNonstandard() {
    }

    public SchoolDistributionRatioNonstandard(Integer id) {
        this.id = id;
    }

    public SchoolDistributionRatioNonstandard(Integer id, int sessionId, int schoolDistributionRatioId, float stdPtr, short stdPtrRainbowSpectrumId, float stdPfr, short stdPfrRainbowSpectrumId, float stdPcr, short stdPcrRainbowSpectrumId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.sessionId = sessionId;
        this.schoolDistributionRatioId = schoolDistributionRatioId;
        this.stdPtr = stdPtr;
        this.stdPtrRainbowSpectrumId = stdPtrRainbowSpectrumId;
        this.stdPfr = stdPfr;
        this.stdPfrRainbowSpectrumId = stdPfrRainbowSpectrumId;
        this.stdPcr = stdPcr;
        this.stdPcrRainbowSpectrumId = stdPcrRainbowSpectrumId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getSchoolDistributionRatioId() {
        return schoolDistributionRatioId;
    }

    public void setSchoolDistributionRatioId(int schoolDistributionRatioId) {
        this.schoolDistributionRatioId = schoolDistributionRatioId;
    }

    public float getStdPtr() {
        return stdPtr;
    }

    public void setStdPtr(float stdPtr) {
        this.stdPtr = stdPtr;
    }

    public short getStdPtrRainbowSpectrumId() {
        return stdPtrRainbowSpectrumId;
    }

    public void setStdPtrRainbowSpectrumId(short stdPtrRainbowSpectrumId) {
        this.stdPtrRainbowSpectrumId = stdPtrRainbowSpectrumId;
    }

    public float getStdPfr() {
        return stdPfr;
    }

    public void setStdPfr(float stdPfr) {
        this.stdPfr = stdPfr;
    }

    public short getStdPfrRainbowSpectrumId() {
        return stdPfrRainbowSpectrumId;
    }

    public void setStdPfrRainbowSpectrumId(short stdPfrRainbowSpectrumId) {
        this.stdPfrRainbowSpectrumId = stdPfrRainbowSpectrumId;
    }

    public float getStdPcr() {
        return stdPcr;
    }

    public void setStdPcr(float stdPcr) {
        this.stdPcr = stdPcr;
    }

    public short getStdPcrRainbowSpectrumId() {
        return stdPcrRainbowSpectrumId;
    }

    public void setStdPcrRainbowSpectrumId(short stdPcrRainbowSpectrumId) {
        this.stdPcrRainbowSpectrumId = stdPcrRainbowSpectrumId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
        if (!(object instanceof SchoolDistributionRatioNonstandard)) {
            return false;
        }
        SchoolDistributionRatioNonstandard other = (SchoolDistributionRatioNonstandard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.SchoolDistributionRatioNonstandard[ id=" + id + " ]";
    }
    
}
