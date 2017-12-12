/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.lis;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "schdata", catalog = "lis2db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schdata.findAll", query = "SELECT s FROM Schdata s")})
public class Schdata implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "beis_school_id")
    private Integer beisSchoolId;
    @Basic(optional = false)
    @Column(name = "general_classification_id", nullable = false)
    private short generalClassificationId;
    @Column(name = "school_subclassification_id")
    private Short schoolSubclassificationId;
    @Basic(optional = false)
    @Column(name = "co_gen_class", nullable = false)
    private short coGenClass;
    @Column(name = "cointegrated_id")
    private Integer cointegratedId;
    @Column(name = "mother_school_id")
    private Integer motherSchoolId;
    @Column(name = "school_type_id")
    private Integer schoolTypeId;
    @Basic(optional = false)
    @Column(name = "division_id", nullable = false)
    private int divisionId;
    @Basic(optional = false)
    @Column(name = "district_id", nullable = false)
    private int districtId;
    @Basic(optional = false)
    @Column(name = "ref_municipality_id", nullable = false)
    private int refMunicipalityId;
    @Column(name = "ref_legislative_id")
    private Short refLegislativeId;
    @Basic(optional = false)
    @Column(name = "region_id", nullable = false)
    private short regionId;
    @Column(name = "bosy_enrolment")
    private BigInteger bosyEnrolment;

    public Schdata() {
    }

    public Schdata(Integer id) {
        this.id = id;
    }

    public Schdata(Integer id, short generalClassificationId, short coGenClass, int divisionId, int districtId, int refMunicipalityId, short regionId) {
        this.id = id;
        this.generalClassificationId = generalClassificationId;
        this.coGenClass = coGenClass;
        this.divisionId = divisionId;
        this.districtId = districtId;
        this.refMunicipalityId = refMunicipalityId;
        this.regionId = regionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBeisSchoolId() {
        return beisSchoolId;
    }

    public void setBeisSchoolId(Integer beisSchoolId) {
        this.beisSchoolId = beisSchoolId;
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

    public short getCoGenClass() {
        return coGenClass;
    }

    public void setCoGenClass(short coGenClass) {
        this.coGenClass = coGenClass;
    }

    public Integer getCointegratedId() {
        return cointegratedId;
    }

    public void setCointegratedId(Integer cointegratedId) {
        this.cointegratedId = cointegratedId;
    }

    public Integer getMotherSchoolId() {
        return motherSchoolId;
    }

    public void setMotherSchoolId(Integer motherSchoolId) {
        this.motherSchoolId = motherSchoolId;
    }

    public Integer getSchoolTypeId() {
        return schoolTypeId;
    }

    public void setSchoolTypeId(Integer schoolTypeId) {
        this.schoolTypeId = schoolTypeId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getRefMunicipalityId() {
        return refMunicipalityId;
    }

    public void setRefMunicipalityId(int refMunicipalityId) {
        this.refMunicipalityId = refMunicipalityId;
    }

    public Short getRefLegislativeId() {
        return refLegislativeId;
    }

    public void setRefLegislativeId(Short refLegislativeId) {
        this.refLegislativeId = refLegislativeId;
    }

    public short getRegionId() {
        return regionId;
    }

    public void setRegionId(short regionId) {
        this.regionId = regionId;
    }

    public BigInteger getBosyEnrolment() {
        return bosyEnrolment;
    }

    public void setBosyEnrolment(BigInteger bosyEnrolment) {
        this.bosyEnrolment = bosyEnrolment;
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
        if (!(object instanceof Schdata)) {
            return false;
        }
        Schdata other = (Schdata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.lis.Schdata[ id=" + id + " ]";
    }
    
}
