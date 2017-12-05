/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "rainbow_spectrum", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"report_type_id", "co_gen_class", "range_from", "range_to"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RainbowSpectrum.findAll", query = "SELECT r FROM RainbowSpectrum r")})
public class RainbowSpectrum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Short id;
    @Column(name = "report_type_id")
    private Short reportTypeId;
    @Column(name = "co_gen_class")
    private Short coGenClass;
    @Column(name = "color_id")
    private Short colorId;
    @Column(name = "color_remarks", length = 100)
    private String colorRemarks;
    @Column(length = 50)
    private String range;
    private Short rank;
    @Column(name = "created_by")
    private Integer createdBy;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_by")
    private Integer updatedBy;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "range_from", nullable = false)
    private float rangeFrom;
    @Basic(optional = false)
    @Column(name = "range_to", nullable = false)
    private float rangeTo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stdPcrRainbowSpectrumId")
    private List<SchoolDistributionRatio> schoolDistributionRatioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stdPfrRainbowSpectrumId")
    private List<SchoolDistributionRatio> schoolDistributionRatioList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stdPtrRainbowSpectrumId")
    private List<SchoolDistributionRatio> schoolDistributionRatioList2;

    public RainbowSpectrum() {
    }

    public RainbowSpectrum(Short id) {
        this.id = id;
    }

    public RainbowSpectrum(Short id, Date createdAt, Date updatedAt, float rangeFrom, float rangeTo) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Short getReportTypeId() {
        return reportTypeId;
    }

    public void setReportTypeId(Short reportTypeId) {
        this.reportTypeId = reportTypeId;
    }

    public Short getCoGenClass() {
        return coGenClass;
    }

    public void setCoGenClass(Short coGenClass) {
        this.coGenClass = coGenClass;
    }

    public Short getColorId() {
        return colorId;
    }

    public void setColorId(Short colorId) {
        this.colorId = colorId;
    }

    public String getColorRemarks() {
        return colorRemarks;
    }

    public void setColorRemarks(String colorRemarks) {
        this.colorRemarks = colorRemarks;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Short getRank() {
        return rank;
    }

    public void setRank(Short rank) {
        this.rank = rank;
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

    public float getRangeFrom() {
        return rangeFrom;
    }

    public void setRangeFrom(float rangeFrom) {
        this.rangeFrom = rangeFrom;
    }

    public float getRangeTo() {
        return rangeTo;
    }

    public void setRangeTo(float rangeTo) {
        this.rangeTo = rangeTo;
    }

    @XmlTransient
    public List<SchoolDistributionRatio> getSchoolDistributionRatioList() {
        return schoolDistributionRatioList;
    }

    public void setSchoolDistributionRatioList(List<SchoolDistributionRatio> schoolDistributionRatioList) {
        this.schoolDistributionRatioList = schoolDistributionRatioList;
    }

    @XmlTransient
    public List<SchoolDistributionRatio> getSchoolDistributionRatioList1() {
        return schoolDistributionRatioList1;
    }

    public void setSchoolDistributionRatioList1(List<SchoolDistributionRatio> schoolDistributionRatioList1) {
        this.schoolDistributionRatioList1 = schoolDistributionRatioList1;
    }

    @XmlTransient
    public List<SchoolDistributionRatio> getSchoolDistributionRatioList2() {
        return schoolDistributionRatioList2;
    }

    public void setSchoolDistributionRatioList2(List<SchoolDistributionRatio> schoolDistributionRatioList2) {
        this.schoolDistributionRatioList2 = schoolDistributionRatioList2;
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
        if (!(object instanceof RainbowSpectrum)) {
            return false;
        }
        RainbowSpectrum other = (RainbowSpectrum) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.RainbowSpectrum[ id=" + id + " ]";
    }
    
}
