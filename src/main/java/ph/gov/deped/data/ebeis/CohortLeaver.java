/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "cohort_leaver", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"report_year", "indicator_id", "aggregation_level", "ref_region_id", "ref_province_id", "ref_municipality_id", "ref_legislative_id", "district_id", "division_id", "cogenclass_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CohortLeaver.findAll", query = "SELECT c FROM CohortLeaver c")})
public class CohortLeaver implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "report_year")
    @Temporal(TemporalType.DATE)
    private Date reportYear;
    @Column(name = "report_id")
    private Integer reportId;
    @Column(name = "indicator_id")
    private Integer indicatorId;
    @Column(name = "aggregation_level")
    private Integer aggregationLevel;
    @Column(name = "school_id")
    private Integer schoolId;
    @Column(name = "ref_region_id")
    private Short refRegionId;
    @Column(name = "ref_province_id")
    private Short refProvinceId;
    @Column(name = "ref_municipality_id")
    private Integer refMunicipalityId;
    @Column(name = "district_no")
    private Short districtNo;
    @Column(name = "ref_legislative_id")
    private Short refLegislativeId;
    @Column(name = "district_id")
    private Integer districtId;
    @Column(name = "division_id")
    private Integer divisionId;
    @Column(name = "depEd_region_id")
    private Integer depEdregionid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double g1Male;
    @Column(precision = 22)
    private Double g1Female;
    @Column(precision = 22)
    private Double g1Total;
    @Column(precision = 22)
    private Double g2Male;
    @Column(precision = 22)
    private Double g2Female;
    @Column(precision = 22)
    private Double g2Total;
    @Column(precision = 22)
    private Double g3Male;
    @Column(precision = 22)
    private Double g3Female;
    @Column(precision = 22)
    private Double g3Total;
    @Column(precision = 22)
    private Double g4Male;
    @Column(precision = 22)
    private Double g4Female;
    @Column(precision = 22)
    private Double g4Total;
    @Column(precision = 22)
    private Double g5Male;
    @Column(precision = 22)
    private Double g5Female;
    @Column(precision = 22)
    private Double g5Total;
    @Column(precision = 22)
    private Double g6Male;
    @Column(precision = 22)
    private Double g6Female;
    @Column(precision = 22)
    private Double g6Total;
    @Column(precision = 22)
    private Double gcompletionMale;
    @Column(precision = 22)
    private Double gcompletionFemale;
    @Column(precision = 22)
    private Double gcompletionTotal;
    @Column(precision = 22)
    private Double gcoeMale;
    @Column(precision = 22)
    private Double gcoeFemale;
    @Column(precision = 22)
    private Double gcoeTotal;
    @Column(precision = 22)
    private Double gyrsInputMale;
    @Column(precision = 22)
    private Double gyrsInputFemale;
    @Column(precision = 22)
    private Double gyrsInputTotal;
    @Column(precision = 22)
    private Double p1Male;
    @Column(precision = 22)
    private Double p1Female;
    @Column(precision = 22)
    private Double p1Total;
    @Column(precision = 22)
    private Double p2Male;
    @Column(precision = 22)
    private Double p2Female;
    @Column(precision = 22)
    private Double p2Total;
    @Column(precision = 22)
    private Double p3Male;
    @Column(precision = 22)
    private Double p3Female;
    @Column(precision = 22)
    private Double p3Total;
    @Column(precision = 22)
    private Double p4Male;
    @Column(precision = 22)
    private Double p4Female;
    @Column(precision = 22)
    private Double p4Total;
    @Column(precision = 22)
    private Double p5Male;
    @Column(precision = 22)
    private Double p5Female;
    @Column(precision = 22)
    private Double p5Total;
    @Column(precision = 22)
    private Double p6Male;
    @Column(precision = 22)
    private Double p6Female;
    @Column(precision = 22)
    private Double p6Total;
    @Column(precision = 22)
    private Double pcompletionMale;
    @Column(precision = 22)
    private Double pcompletionFemale;
    @Column(precision = 22)
    private Double pcompletionTotal;
    @Column(precision = 22)
    private Double pcoeMale;
    @Column(precision = 22)
    private Double pcoeFemale;
    @Column(precision = 22)
    private Double pcoeTotal;
    @Column(precision = 22)
    private Double pyrsInputMale;
    @Column(precision = 22)
    private Double pyrsInputFemale;
    @Column(precision = 22)
    private Double pyrsInputTotal;
    @Column(precision = 22)
    private Double t1Male;
    @Column(precision = 22)
    private Double t1Female;
    @Column(precision = 22)
    private Double t1Total;
    @Column(precision = 22)
    private Double t2Male;
    @Column(precision = 22)
    private Double t2Female;
    @Column(precision = 22)
    private Double t2Total;
    @Column(precision = 22)
    private Double t3Male;
    @Column(precision = 22)
    private Double t3Female;
    @Column(precision = 22)
    private Double t3Total;
    @Column(precision = 22)
    private Double t4Male;
    @Column(precision = 22)
    private Double t4Female;
    @Column(precision = 22)
    private Double t4Total;
    @Column(precision = 22)
    private Double t5Male;
    @Column(precision = 22)
    private Double t5Female;
    @Column(precision = 22)
    private Double t5Total;
    @Column(precision = 22)
    private Double t6Male;
    @Column(precision = 22)
    private Double t6Female;
    @Column(precision = 22)
    private Double t6Total;
    @Column(precision = 22)
    private Double tcompletionMale;
    @Column(precision = 22)
    private Double tcompletionFemale;
    @Column(precision = 22)
    private Double tcompletionTotal;
    @Column(precision = 22)
    private Double tcoeMale;
    @Column(precision = 22)
    private Double tcoeFemale;
    @Column(precision = 22)
    private Double tcoeTotal;
    @Column(precision = 22)
    private Double tyrsInputMale;
    @Column(precision = 22)
    private Double tyrsInputFemale;
    @Column(precision = 22)
    private Double tyrsInputTotal;
    @Column(name = "last_generationdt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastGenerationdt;
    private Integer generatedBy;
    @Column(name = "cogenclass_id")
    private Integer cogenclassId;
    @Column(name = "old_district_id")
    private Integer oldDistrictId;
    @Column(name = "old_ref_province_id")
    private Short oldRefProvinceId;
    @Column(name = "old_ref_region_id")
    private Short oldRefRegionId;
    @Column(name = "old_ref_municipality_id")
    private Integer oldRefMunicipalityId;
    @Column(name = "old_division_id")
    private Integer oldDivisionId;
    @Column(name = "old_district_no")
    private Short oldDistrictNo;
    @Column(name = "submission_complete")
    private Short submissionComplete;
    @Column(name = "validation_complete")
    private Short validationComplete;
    @OneToMany(mappedBy = "cohortLeaverId")
    private List<CohortLeaverDetails> cohortLeaverDetailsList;

    public CohortLeaver() {
    }

    public CohortLeaver(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReportYear() {
        return reportYear;
    }

    public void setReportYear(Date reportYear) {
        this.reportYear = reportYear;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorId(Integer indicatorId) {
        this.indicatorId = indicatorId;
    }

    public Integer getAggregationLevel() {
        return aggregationLevel;
    }

    public void setAggregationLevel(Integer aggregationLevel) {
        this.aggregationLevel = aggregationLevel;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Short getRefRegionId() {
        return refRegionId;
    }

    public void setRefRegionId(Short refRegionId) {
        this.refRegionId = refRegionId;
    }

    public Short getRefProvinceId() {
        return refProvinceId;
    }

    public void setRefProvinceId(Short refProvinceId) {
        this.refProvinceId = refProvinceId;
    }

    public Integer getRefMunicipalityId() {
        return refMunicipalityId;
    }

    public void setRefMunicipalityId(Integer refMunicipalityId) {
        this.refMunicipalityId = refMunicipalityId;
    }

    public Short getDistrictNo() {
        return districtNo;
    }

    public void setDistrictNo(Short districtNo) {
        this.districtNo = districtNo;
    }

    public Short getRefLegislativeId() {
        return refLegislativeId;
    }

    public void setRefLegislativeId(Short refLegislativeId) {
        this.refLegislativeId = refLegislativeId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public Integer getDepEdregionid() {
        return depEdregionid;
    }

    public void setDepEdregionid(Integer depEdregionid) {
        this.depEdregionid = depEdregionid;
    }

    public Double getG1Male() {
        return g1Male;
    }

    public void setG1Male(Double g1Male) {
        this.g1Male = g1Male;
    }

    public Double getG1Female() {
        return g1Female;
    }

    public void setG1Female(Double g1Female) {
        this.g1Female = g1Female;
    }

    public Double getG1Total() {
        return g1Total;
    }

    public void setG1Total(Double g1Total) {
        this.g1Total = g1Total;
    }

    public Double getG2Male() {
        return g2Male;
    }

    public void setG2Male(Double g2Male) {
        this.g2Male = g2Male;
    }

    public Double getG2Female() {
        return g2Female;
    }

    public void setG2Female(Double g2Female) {
        this.g2Female = g2Female;
    }

    public Double getG2Total() {
        return g2Total;
    }

    public void setG2Total(Double g2Total) {
        this.g2Total = g2Total;
    }

    public Double getG3Male() {
        return g3Male;
    }

    public void setG3Male(Double g3Male) {
        this.g3Male = g3Male;
    }

    public Double getG3Female() {
        return g3Female;
    }

    public void setG3Female(Double g3Female) {
        this.g3Female = g3Female;
    }

    public Double getG3Total() {
        return g3Total;
    }

    public void setG3Total(Double g3Total) {
        this.g3Total = g3Total;
    }

    public Double getG4Male() {
        return g4Male;
    }

    public void setG4Male(Double g4Male) {
        this.g4Male = g4Male;
    }

    public Double getG4Female() {
        return g4Female;
    }

    public void setG4Female(Double g4Female) {
        this.g4Female = g4Female;
    }

    public Double getG4Total() {
        return g4Total;
    }

    public void setG4Total(Double g4Total) {
        this.g4Total = g4Total;
    }

    public Double getG5Male() {
        return g5Male;
    }

    public void setG5Male(Double g5Male) {
        this.g5Male = g5Male;
    }

    public Double getG5Female() {
        return g5Female;
    }

    public void setG5Female(Double g5Female) {
        this.g5Female = g5Female;
    }

    public Double getG5Total() {
        return g5Total;
    }

    public void setG5Total(Double g5Total) {
        this.g5Total = g5Total;
    }

    public Double getG6Male() {
        return g6Male;
    }

    public void setG6Male(Double g6Male) {
        this.g6Male = g6Male;
    }

    public Double getG6Female() {
        return g6Female;
    }

    public void setG6Female(Double g6Female) {
        this.g6Female = g6Female;
    }

    public Double getG6Total() {
        return g6Total;
    }

    public void setG6Total(Double g6Total) {
        this.g6Total = g6Total;
    }

    public Double getGcompletionMale() {
        return gcompletionMale;
    }

    public void setGcompletionMale(Double gcompletionMale) {
        this.gcompletionMale = gcompletionMale;
    }

    public Double getGcompletionFemale() {
        return gcompletionFemale;
    }

    public void setGcompletionFemale(Double gcompletionFemale) {
        this.gcompletionFemale = gcompletionFemale;
    }

    public Double getGcompletionTotal() {
        return gcompletionTotal;
    }

    public void setGcompletionTotal(Double gcompletionTotal) {
        this.gcompletionTotal = gcompletionTotal;
    }

    public Double getGcoeMale() {
        return gcoeMale;
    }

    public void setGcoeMale(Double gcoeMale) {
        this.gcoeMale = gcoeMale;
    }

    public Double getGcoeFemale() {
        return gcoeFemale;
    }

    public void setGcoeFemale(Double gcoeFemale) {
        this.gcoeFemale = gcoeFemale;
    }

    public Double getGcoeTotal() {
        return gcoeTotal;
    }

    public void setGcoeTotal(Double gcoeTotal) {
        this.gcoeTotal = gcoeTotal;
    }

    public Double getGyrsInputMale() {
        return gyrsInputMale;
    }

    public void setGyrsInputMale(Double gyrsInputMale) {
        this.gyrsInputMale = gyrsInputMale;
    }

    public Double getGyrsInputFemale() {
        return gyrsInputFemale;
    }

    public void setGyrsInputFemale(Double gyrsInputFemale) {
        this.gyrsInputFemale = gyrsInputFemale;
    }

    public Double getGyrsInputTotal() {
        return gyrsInputTotal;
    }

    public void setGyrsInputTotal(Double gyrsInputTotal) {
        this.gyrsInputTotal = gyrsInputTotal;
    }

    public Double getP1Male() {
        return p1Male;
    }

    public void setP1Male(Double p1Male) {
        this.p1Male = p1Male;
    }

    public Double getP1Female() {
        return p1Female;
    }

    public void setP1Female(Double p1Female) {
        this.p1Female = p1Female;
    }

    public Double getP1Total() {
        return p1Total;
    }

    public void setP1Total(Double p1Total) {
        this.p1Total = p1Total;
    }

    public Double getP2Male() {
        return p2Male;
    }

    public void setP2Male(Double p2Male) {
        this.p2Male = p2Male;
    }

    public Double getP2Female() {
        return p2Female;
    }

    public void setP2Female(Double p2Female) {
        this.p2Female = p2Female;
    }

    public Double getP2Total() {
        return p2Total;
    }

    public void setP2Total(Double p2Total) {
        this.p2Total = p2Total;
    }

    public Double getP3Male() {
        return p3Male;
    }

    public void setP3Male(Double p3Male) {
        this.p3Male = p3Male;
    }

    public Double getP3Female() {
        return p3Female;
    }

    public void setP3Female(Double p3Female) {
        this.p3Female = p3Female;
    }

    public Double getP3Total() {
        return p3Total;
    }

    public void setP3Total(Double p3Total) {
        this.p3Total = p3Total;
    }

    public Double getP4Male() {
        return p4Male;
    }

    public void setP4Male(Double p4Male) {
        this.p4Male = p4Male;
    }

    public Double getP4Female() {
        return p4Female;
    }

    public void setP4Female(Double p4Female) {
        this.p4Female = p4Female;
    }

    public Double getP4Total() {
        return p4Total;
    }

    public void setP4Total(Double p4Total) {
        this.p4Total = p4Total;
    }

    public Double getP5Male() {
        return p5Male;
    }

    public void setP5Male(Double p5Male) {
        this.p5Male = p5Male;
    }

    public Double getP5Female() {
        return p5Female;
    }

    public void setP5Female(Double p5Female) {
        this.p5Female = p5Female;
    }

    public Double getP5Total() {
        return p5Total;
    }

    public void setP5Total(Double p5Total) {
        this.p5Total = p5Total;
    }

    public Double getP6Male() {
        return p6Male;
    }

    public void setP6Male(Double p6Male) {
        this.p6Male = p6Male;
    }

    public Double getP6Female() {
        return p6Female;
    }

    public void setP6Female(Double p6Female) {
        this.p6Female = p6Female;
    }

    public Double getP6Total() {
        return p6Total;
    }

    public void setP6Total(Double p6Total) {
        this.p6Total = p6Total;
    }

    public Double getPcompletionMale() {
        return pcompletionMale;
    }

    public void setPcompletionMale(Double pcompletionMale) {
        this.pcompletionMale = pcompletionMale;
    }

    public Double getPcompletionFemale() {
        return pcompletionFemale;
    }

    public void setPcompletionFemale(Double pcompletionFemale) {
        this.pcompletionFemale = pcompletionFemale;
    }

    public Double getPcompletionTotal() {
        return pcompletionTotal;
    }

    public void setPcompletionTotal(Double pcompletionTotal) {
        this.pcompletionTotal = pcompletionTotal;
    }

    public Double getPcoeMale() {
        return pcoeMale;
    }

    public void setPcoeMale(Double pcoeMale) {
        this.pcoeMale = pcoeMale;
    }

    public Double getPcoeFemale() {
        return pcoeFemale;
    }

    public void setPcoeFemale(Double pcoeFemale) {
        this.pcoeFemale = pcoeFemale;
    }

    public Double getPcoeTotal() {
        return pcoeTotal;
    }

    public void setPcoeTotal(Double pcoeTotal) {
        this.pcoeTotal = pcoeTotal;
    }

    public Double getPyrsInputMale() {
        return pyrsInputMale;
    }

    public void setPyrsInputMale(Double pyrsInputMale) {
        this.pyrsInputMale = pyrsInputMale;
    }

    public Double getPyrsInputFemale() {
        return pyrsInputFemale;
    }

    public void setPyrsInputFemale(Double pyrsInputFemale) {
        this.pyrsInputFemale = pyrsInputFemale;
    }

    public Double getPyrsInputTotal() {
        return pyrsInputTotal;
    }

    public void setPyrsInputTotal(Double pyrsInputTotal) {
        this.pyrsInputTotal = pyrsInputTotal;
    }

    public Double getT1Male() {
        return t1Male;
    }

    public void setT1Male(Double t1Male) {
        this.t1Male = t1Male;
    }

    public Double getT1Female() {
        return t1Female;
    }

    public void setT1Female(Double t1Female) {
        this.t1Female = t1Female;
    }

    public Double getT1Total() {
        return t1Total;
    }

    public void setT1Total(Double t1Total) {
        this.t1Total = t1Total;
    }

    public Double getT2Male() {
        return t2Male;
    }

    public void setT2Male(Double t2Male) {
        this.t2Male = t2Male;
    }

    public Double getT2Female() {
        return t2Female;
    }

    public void setT2Female(Double t2Female) {
        this.t2Female = t2Female;
    }

    public Double getT2Total() {
        return t2Total;
    }

    public void setT2Total(Double t2Total) {
        this.t2Total = t2Total;
    }

    public Double getT3Male() {
        return t3Male;
    }

    public void setT3Male(Double t3Male) {
        this.t3Male = t3Male;
    }

    public Double getT3Female() {
        return t3Female;
    }

    public void setT3Female(Double t3Female) {
        this.t3Female = t3Female;
    }

    public Double getT3Total() {
        return t3Total;
    }

    public void setT3Total(Double t3Total) {
        this.t3Total = t3Total;
    }

    public Double getT4Male() {
        return t4Male;
    }

    public void setT4Male(Double t4Male) {
        this.t4Male = t4Male;
    }

    public Double getT4Female() {
        return t4Female;
    }

    public void setT4Female(Double t4Female) {
        this.t4Female = t4Female;
    }

    public Double getT4Total() {
        return t4Total;
    }

    public void setT4Total(Double t4Total) {
        this.t4Total = t4Total;
    }

    public Double getT5Male() {
        return t5Male;
    }

    public void setT5Male(Double t5Male) {
        this.t5Male = t5Male;
    }

    public Double getT5Female() {
        return t5Female;
    }

    public void setT5Female(Double t5Female) {
        this.t5Female = t5Female;
    }

    public Double getT5Total() {
        return t5Total;
    }

    public void setT5Total(Double t5Total) {
        this.t5Total = t5Total;
    }

    public Double getT6Male() {
        return t6Male;
    }

    public void setT6Male(Double t6Male) {
        this.t6Male = t6Male;
    }

    public Double getT6Female() {
        return t6Female;
    }

    public void setT6Female(Double t6Female) {
        this.t6Female = t6Female;
    }

    public Double getT6Total() {
        return t6Total;
    }

    public void setT6Total(Double t6Total) {
        this.t6Total = t6Total;
    }

    public Double getTcompletionMale() {
        return tcompletionMale;
    }

    public void setTcompletionMale(Double tcompletionMale) {
        this.tcompletionMale = tcompletionMale;
    }

    public Double getTcompletionFemale() {
        return tcompletionFemale;
    }

    public void setTcompletionFemale(Double tcompletionFemale) {
        this.tcompletionFemale = tcompletionFemale;
    }

    public Double getTcompletionTotal() {
        return tcompletionTotal;
    }

    public void setTcompletionTotal(Double tcompletionTotal) {
        this.tcompletionTotal = tcompletionTotal;
    }

    public Double getTcoeMale() {
        return tcoeMale;
    }

    public void setTcoeMale(Double tcoeMale) {
        this.tcoeMale = tcoeMale;
    }

    public Double getTcoeFemale() {
        return tcoeFemale;
    }

    public void setTcoeFemale(Double tcoeFemale) {
        this.tcoeFemale = tcoeFemale;
    }

    public Double getTcoeTotal() {
        return tcoeTotal;
    }

    public void setTcoeTotal(Double tcoeTotal) {
        this.tcoeTotal = tcoeTotal;
    }

    public Double getTyrsInputMale() {
        return tyrsInputMale;
    }

    public void setTyrsInputMale(Double tyrsInputMale) {
        this.tyrsInputMale = tyrsInputMale;
    }

    public Double getTyrsInputFemale() {
        return tyrsInputFemale;
    }

    public void setTyrsInputFemale(Double tyrsInputFemale) {
        this.tyrsInputFemale = tyrsInputFemale;
    }

    public Double getTyrsInputTotal() {
        return tyrsInputTotal;
    }

    public void setTyrsInputTotal(Double tyrsInputTotal) {
        this.tyrsInputTotal = tyrsInputTotal;
    }

    public Date getLastGenerationdt() {
        return lastGenerationdt;
    }

    public void setLastGenerationdt(Date lastGenerationdt) {
        this.lastGenerationdt = lastGenerationdt;
    }

    public Integer getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Integer generatedBy) {
        this.generatedBy = generatedBy;
    }

    public Integer getCogenclassId() {
        return cogenclassId;
    }

    public void setCogenclassId(Integer cogenclassId) {
        this.cogenclassId = cogenclassId;
    }

    public Integer getOldDistrictId() {
        return oldDistrictId;
    }

    public void setOldDistrictId(Integer oldDistrictId) {
        this.oldDistrictId = oldDistrictId;
    }

    public Short getOldRefProvinceId() {
        return oldRefProvinceId;
    }

    public void setOldRefProvinceId(Short oldRefProvinceId) {
        this.oldRefProvinceId = oldRefProvinceId;
    }

    public Short getOldRefRegionId() {
        return oldRefRegionId;
    }

    public void setOldRefRegionId(Short oldRefRegionId) {
        this.oldRefRegionId = oldRefRegionId;
    }

    public Integer getOldRefMunicipalityId() {
        return oldRefMunicipalityId;
    }

    public void setOldRefMunicipalityId(Integer oldRefMunicipalityId) {
        this.oldRefMunicipalityId = oldRefMunicipalityId;
    }

    public Integer getOldDivisionId() {
        return oldDivisionId;
    }

    public void setOldDivisionId(Integer oldDivisionId) {
        this.oldDivisionId = oldDivisionId;
    }

    public Short getOldDistrictNo() {
        return oldDistrictNo;
    }

    public void setOldDistrictNo(Short oldDistrictNo) {
        this.oldDistrictNo = oldDistrictNo;
    }

    public Short getSubmissionComplete() {
        return submissionComplete;
    }

    public void setSubmissionComplete(Short submissionComplete) {
        this.submissionComplete = submissionComplete;
    }

    public Short getValidationComplete() {
        return validationComplete;
    }

    public void setValidationComplete(Short validationComplete) {
        this.validationComplete = validationComplete;
    }

    @XmlTransient
    public List<CohortLeaverDetails> getCohortLeaverDetailsList() {
        return cohortLeaverDetailsList;
    }

    public void setCohortLeaverDetailsList(List<CohortLeaverDetails> cohortLeaverDetailsList) {
        this.cohortLeaverDetailsList = cohortLeaverDetailsList;
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
        if (!(object instanceof CohortLeaver)) {
            return false;
        }
        CohortLeaver other = (CohortLeaver) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.CohortLeaver[ id=" + id + " ]";
    }
    
}
