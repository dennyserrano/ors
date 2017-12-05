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
@Table(name = "pi_schofcloc", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"base_sy_from", "school_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PiSchofcloc.findAll", query = "SELECT p FROM PiSchofcloc p")})
public class PiSchofcloc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "base_sy_from", nullable = false)
    private short baseSyFrom;
    @Basic(optional = false)
    @Column(name = "school_id", nullable = false)
    private int schoolId;
    @Basic(optional = false)
    @Column(name = "beis_school_id", nullable = false)
    private int beisSchoolId;
    @Basic(optional = false)
    @Column(name = "from_sy", nullable = false)
    private int fromSy;
    @Basic(optional = false)
    @Column(name = "ref_region_id", nullable = false)
    private short refRegionId;
    @Basic(optional = false)
    @Column(name = "ref_province_id", nullable = false)
    private short refProvinceId;
    @Basic(optional = false)
    @Column(name = "ref_municipality_id", nullable = false)
    private int refMunicipalityId;
    @Column(name = "ref_baranggay_id")
    private Integer refBaranggayId;
    @Basic(optional = false)
    @Column(name = "ref_legislative_id", nullable = false)
    private short refLegislativeId;
    @Column(name = "district_no")
    private Short districtNo;
    @Basic(optional = false)
    @Column(name = "division_id", nullable = false)
    private short divisionId;
    @Basic(optional = false)
    @Column(name = "district_id", nullable = false)
    private short districtId;
    @Basic(optional = false)
    @Column(name = "co_gen_class", nullable = false)
    private short coGenClass;
    @Basic(optional = false)
    @Column(name = "general_classification_id", nullable = false)
    private short generalClassificationId;
    @Column(name = "school_subclassification_id")
    private Short schoolSubclassificationId;
    @Column(name = "school_type_id")
    private Short schoolTypeId;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "mother_school_id")
    private Integer motherSchoolId;

    public PiSchofcloc() {
    }

    public PiSchofcloc(Integer id) {
        this.id = id;
    }

    public PiSchofcloc(Integer id, short baseSyFrom, int schoolId, int beisSchoolId, int fromSy, short refRegionId, short refProvinceId, int refMunicipalityId, short refLegislativeId, short divisionId, short districtId, short coGenClass, short generalClassificationId, Date createdAt) {
        this.id = id;
        this.baseSyFrom = baseSyFrom;
        this.schoolId = schoolId;
        this.beisSchoolId = beisSchoolId;
        this.fromSy = fromSy;
        this.refRegionId = refRegionId;
        this.refProvinceId = refProvinceId;
        this.refMunicipalityId = refMunicipalityId;
        this.refLegislativeId = refLegislativeId;
        this.divisionId = divisionId;
        this.districtId = districtId;
        this.coGenClass = coGenClass;
        this.generalClassificationId = generalClassificationId;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getBaseSyFrom() {
        return baseSyFrom;
    }

    public void setBaseSyFrom(short baseSyFrom) {
        this.baseSyFrom = baseSyFrom;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public int getBeisSchoolId() {
        return beisSchoolId;
    }

    public void setBeisSchoolId(int beisSchoolId) {
        this.beisSchoolId = beisSchoolId;
    }

    public int getFromSy() {
        return fromSy;
    }

    public void setFromSy(int fromSy) {
        this.fromSy = fromSy;
    }

    public short getRefRegionId() {
        return refRegionId;
    }

    public void setRefRegionId(short refRegionId) {
        this.refRegionId = refRegionId;
    }

    public short getRefProvinceId() {
        return refProvinceId;
    }

    public void setRefProvinceId(short refProvinceId) {
        this.refProvinceId = refProvinceId;
    }

    public int getRefMunicipalityId() {
        return refMunicipalityId;
    }

    public void setRefMunicipalityId(int refMunicipalityId) {
        this.refMunicipalityId = refMunicipalityId;
    }

    public Integer getRefBaranggayId() {
        return refBaranggayId;
    }

    public void setRefBaranggayId(Integer refBaranggayId) {
        this.refBaranggayId = refBaranggayId;
    }

    public short getRefLegislativeId() {
        return refLegislativeId;
    }

    public void setRefLegislativeId(short refLegislativeId) {
        this.refLegislativeId = refLegislativeId;
    }

    public Short getDistrictNo() {
        return districtNo;
    }

    public void setDistrictNo(Short districtNo) {
        this.districtNo = districtNo;
    }

    public short getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(short divisionId) {
        this.divisionId = divisionId;
    }

    public short getDistrictId() {
        return districtId;
    }

    public void setDistrictId(short districtId) {
        this.districtId = districtId;
    }

    public short getCoGenClass() {
        return coGenClass;
    }

    public void setCoGenClass(short coGenClass) {
        this.coGenClass = coGenClass;
    }

    public short getGeneralClassificationId() {
        return generalClassificationId;
    }

    public void setGeneralClassificationId(short generalClassificationId) {
        this.generalClassificationId = generalClassificationId;
    }

    public Short getSchoolSubclassificationId() {
        return schoolSubclassificationId;
    }

    public void setSchoolSubclassificationId(Short schoolSubclassificationId) {
        this.schoolSubclassificationId = schoolSubclassificationId;
    }

    public Short getSchoolTypeId() {
        return schoolTypeId;
    }

    public void setSchoolTypeId(Short schoolTypeId) {
        this.schoolTypeId = schoolTypeId;
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

    public Integer getMotherSchoolId() {
        return motherSchoolId;
    }

    public void setMotherSchoolId(Integer motherSchoolId) {
        this.motherSchoolId = motherSchoolId;
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
        if (!(object instanceof PiSchofcloc)) {
            return false;
        }
        PiSchofcloc other = (PiSchofcloc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.PiSchofcloc[ id=" + id + " ]";
    }
    
}
