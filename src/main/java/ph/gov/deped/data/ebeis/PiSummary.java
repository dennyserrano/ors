/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

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
@Table(name = "pi_summary", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"report_month", "indicator_id", "school_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PiSummary.findAll", query = "SELECT p FROM PiSummary p")})
public class PiSummary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "report_month")
    @Temporal(TemporalType.DATE)
    private Date reportMonth;
    private Short boncsy;
    @Column(name = "sy_from")
    private Integer syFrom;
    @Column(name = "indicator_id")
    private Integer indicatorId;
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
    @Column(name = "ref_brgy_id")
    private Integer refBrgyId;
    @Column(name = "ref_legislative_id")
    private Short refLegislativeId;
    @Column(name = "district_id")
    private Integer districtId;
    @Column(name = "division_id")
    private Integer divisionId;
    @Column(name = "depEd_region_id")
    private Integer depEdregionid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gpnMale", precision = 12)
    private Float gpnMale;
    @Column(name = "gpnFemale", precision = 12)
    private Float gpnFemale;
    @Column(name = "gpdMale", precision = 12)
    private Float gpdMale;
    @Column(name = "gpdFemale", precision = 12)
    private Float gpdFemale;
    @Column(name = "g1nMale", precision = 12)
    private Float g1nMale;
    @Column(name = "g1nFemale", precision = 12)
    private Float g1nFemale;
    @Column(name = "g1dMale", precision = 12)
    private Float g1dMale;
    @Column(name = "g1dFemale", precision = 12)
    private Float g1dFemale;
    @Column(name = "g2nMale", precision = 12)
    private Float g2nMale;
    @Column(name = "g2nFemale", precision = 12)
    private Float g2nFemale;
    @Column(name = "g2dMale", precision = 12)
    private Float g2dMale;
    @Column(name = "g2dFemale", precision = 12)
    private Float g2dFemale;
    @Column(name = "g3nMale", precision = 12)
    private Float g3nMale;
    @Column(name = "g3nFemale", precision = 12)
    private Float g3nFemale;
    @Column(name = "g3dMale", precision = 12)
    private Float g3dMale;
    @Column(name = "g3dFemale", precision = 12)
    private Float g3dFemale;
    @Column(name = "g4nMale", precision = 12)
    private Float g4nMale;
    @Column(name = "g4nFemale", precision = 12)
    private Float g4nFemale;
    @Column(name = "g4dMale", precision = 12)
    private Float g4dMale;
    @Column(name = "g4dFemale", precision = 12)
    private Float g4dFemale;
    @Column(name = "g5nMale", precision = 12)
    private Float g5nMale;
    @Column(name = "g5nFemale", precision = 12)
    private Float g5nFemale;
    @Column(name = "g5dMale", precision = 12)
    private Float g5dMale;
    @Column(name = "g5dFemale", precision = 12)
    private Float g5dFemale;
    @Column(name = "g6nMale", precision = 12)
    private Float g6nMale;
    @Column(name = "g6nFemale", precision = 12)
    private Float g6nFemale;
    @Column(name = "g6dMale", precision = 12)
    private Float g6dMale;
    @Column(name = "g6dFemale", precision = 12)
    private Float g6dFemale;
    @Column(name = "ppnMale", precision = 12)
    private Float ppnMale;
    @Column(name = "ppnFemale", precision = 12)
    private Float ppnFemale;
    @Column(name = "ppdMale", precision = 12)
    private Float ppdMale;
    @Column(name = "ppdFemale", precision = 12)
    private Float ppdFemale;
    @Column(name = "p1nMale", precision = 12)
    private Float p1nMale;
    @Column(name = "p1nFemale", precision = 12)
    private Float p1nFemale;
    @Column(name = "p1dMale", precision = 12)
    private Float p1dMale;
    @Column(name = "p1dFemale", precision = 12)
    private Float p1dFemale;
    @Column(name = "p2nMale", precision = 12)
    private Float p2nMale;
    @Column(name = "p2nFemale", precision = 12)
    private Float p2nFemale;
    @Column(name = "p2dMale", precision = 12)
    private Float p2dMale;
    @Column(name = "p2dFemale", precision = 12)
    private Float p2dFemale;
    @Column(name = "p3nMale", precision = 12)
    private Float p3nMale;
    @Column(name = "p3nFemale", precision = 12)
    private Float p3nFemale;
    @Column(name = "p3dMale", precision = 12)
    private Float p3dMale;
    @Column(name = "p3dFemale", precision = 12)
    private Float p3dFemale;
    @Column(name = "p4nMale", precision = 12)
    private Float p4nMale;
    @Column(name = "p4nFemale", precision = 12)
    private Float p4nFemale;
    @Column(name = "p4dMale", precision = 12)
    private Float p4dMale;
    @Column(name = "p4dFemale", precision = 12)
    private Float p4dFemale;
    @Column(name = "p5nMale", precision = 12)
    private Float p5nMale;
    @Column(name = "p5nFemale", precision = 12)
    private Float p5nFemale;
    @Column(name = "p5dMale", precision = 12)
    private Float p5dMale;
    @Column(name = "p5dFemale", precision = 12)
    private Float p5dFemale;
    @Column(name = "p6nMale", precision = 12)
    private Float p6nMale;
    @Column(name = "p6nFemale", precision = 12)
    private Float p6nFemale;
    @Column(name = "p6dMale", precision = 12)
    private Float p6dMale;
    @Column(name = "p6dFemale", precision = 12)
    private Float p6dFemale;
    @Column(name = "sg1nMale", precision = 12)
    private Float sg1nMale;
    @Column(name = "last_generationdt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastGenerationdt;
    private Integer generatedBy;
    @Column(name = "numerator_reportdt")
    private Integer numeratorReportdt;
    @Column(name = "denominator_reportdt")
    private Integer denominatorReportdt;
    @Column(name = "indicator_numerator_id")
    private Integer indicatorNumeratorId;
    @Column(name = "indicator_denominator_id")
    private Integer indicatorDenominatorId;
    @Column(name = "cogenclass_id")
    private Integer cogenclassId;
    @Column(name = "aggregate_level_id")
    private Integer aggregateLevelId;
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
    @Column(name = "report_id")
    private Integer reportId;
    @Column(name = "sg1nFemale", precision = 12)
    private Float sg1nFemale;
    @Column(name = "sg1dMale", precision = 12)
    private Float sg1dMale;
    @Column(name = "sg1dFemale", precision = 12)
    private Float sg1dFemale;
    @Column(name = "sg2nMale", precision = 12)
    private Float sg2nMale;
    @Column(name = "sg2nFemale", precision = 12)
    private Float sg2nFemale;
    @Column(name = "sg2dMale", precision = 12)
    private Float sg2dMale;
    @Column(name = "sg2dFemale", precision = 12)
    private Float sg2dFemale;
    @Column(name = "sg3nMale", precision = 12)
    private Float sg3nMale;
    @Column(name = "sg3nFemale", precision = 12)
    private Float sg3nFemale;
    @Column(name = "sg3dMale", precision = 12)
    private Float sg3dMale;
    @Column(name = "sg3dFemale", precision = 12)
    private Float sg3dFemale;
    @Column(name = "sg4nMale", precision = 12)
    private Float sg4nMale;
    @Column(name = "sg4nFemale", precision = 12)
    private Float sg4nFemale;
    @Column(name = "sg4dMale", precision = 12)
    private Float sg4dMale;
    @Column(name = "sg4dFemale", precision = 12)
    private Float sg4dFemale;
    @Column(name = "sg5nMale", precision = 12)
    private Float sg5nMale;
    @Column(name = "sg5nFemale", precision = 12)
    private Float sg5nFemale;
    @Column(name = "sg5dMale", precision = 12)
    private Float sg5dMale;
    @Column(name = "sg5dFemale", precision = 12)
    private Float sg5dFemale;
    @Column(name = "sg6nMale", precision = 12)
    private Float sg6nMale;
    @Column(name = "sg6nFemale", precision = 12)
    private Float sg6nFemale;
    @Column(name = "sg6dMale", precision = 12)
    private Float sg6dMale;
    @Column(name = "sg6dFemale", precision = 12)
    private Float sg6dFemale;

    public PiSummary() {
    }

    public PiSummary(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReportMonth() {
        return reportMonth;
    }

    public void setReportMonth(Date reportMonth) {
        this.reportMonth = reportMonth;
    }

    public Short getBoncsy() {
        return boncsy;
    }

    public void setBoncsy(Short boncsy) {
        this.boncsy = boncsy;
    }

    public Integer getSyFrom() {
        return syFrom;
    }

    public void setSyFrom(Integer syFrom) {
        this.syFrom = syFrom;
    }

    public Integer getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorId(Integer indicatorId) {
        this.indicatorId = indicatorId;
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

    public Integer getRefBrgyId() {
        return refBrgyId;
    }

    public void setRefBrgyId(Integer refBrgyId) {
        this.refBrgyId = refBrgyId;
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

    public Float getGpnMale() {
        return gpnMale;
    }

    public void setGpnMale(Float gpnMale) {
        this.gpnMale = gpnMale;
    }

    public Float getGpnFemale() {
        return gpnFemale;
    }

    public void setGpnFemale(Float gpnFemale) {
        this.gpnFemale = gpnFemale;
    }

    public Float getGpdMale() {
        return gpdMale;
    }

    public void setGpdMale(Float gpdMale) {
        this.gpdMale = gpdMale;
    }

    public Float getGpdFemale() {
        return gpdFemale;
    }

    public void setGpdFemale(Float gpdFemale) {
        this.gpdFemale = gpdFemale;
    }

    public Float getG1nMale() {
        return g1nMale;
    }

    public void setG1nMale(Float g1nMale) {
        this.g1nMale = g1nMale;
    }

    public Float getG1nFemale() {
        return g1nFemale;
    }

    public void setG1nFemale(Float g1nFemale) {
        this.g1nFemale = g1nFemale;
    }

    public Float getG1dMale() {
        return g1dMale;
    }

    public void setG1dMale(Float g1dMale) {
        this.g1dMale = g1dMale;
    }

    public Float getG1dFemale() {
        return g1dFemale;
    }

    public void setG1dFemale(Float g1dFemale) {
        this.g1dFemale = g1dFemale;
    }

    public Float getG2nMale() {
        return g2nMale;
    }

    public void setG2nMale(Float g2nMale) {
        this.g2nMale = g2nMale;
    }

    public Float getG2nFemale() {
        return g2nFemale;
    }

    public void setG2nFemale(Float g2nFemale) {
        this.g2nFemale = g2nFemale;
    }

    public Float getG2dMale() {
        return g2dMale;
    }

    public void setG2dMale(Float g2dMale) {
        this.g2dMale = g2dMale;
    }

    public Float getG2dFemale() {
        return g2dFemale;
    }

    public void setG2dFemale(Float g2dFemale) {
        this.g2dFemale = g2dFemale;
    }

    public Float getG3nMale() {
        return g3nMale;
    }

    public void setG3nMale(Float g3nMale) {
        this.g3nMale = g3nMale;
    }

    public Float getG3nFemale() {
        return g3nFemale;
    }

    public void setG3nFemale(Float g3nFemale) {
        this.g3nFemale = g3nFemale;
    }

    public Float getG3dMale() {
        return g3dMale;
    }

    public void setG3dMale(Float g3dMale) {
        this.g3dMale = g3dMale;
    }

    public Float getG3dFemale() {
        return g3dFemale;
    }

    public void setG3dFemale(Float g3dFemale) {
        this.g3dFemale = g3dFemale;
    }

    public Float getG4nMale() {
        return g4nMale;
    }

    public void setG4nMale(Float g4nMale) {
        this.g4nMale = g4nMale;
    }

    public Float getG4nFemale() {
        return g4nFemale;
    }

    public void setG4nFemale(Float g4nFemale) {
        this.g4nFemale = g4nFemale;
    }

    public Float getG4dMale() {
        return g4dMale;
    }

    public void setG4dMale(Float g4dMale) {
        this.g4dMale = g4dMale;
    }

    public Float getG4dFemale() {
        return g4dFemale;
    }

    public void setG4dFemale(Float g4dFemale) {
        this.g4dFemale = g4dFemale;
    }

    public Float getG5nMale() {
        return g5nMale;
    }

    public void setG5nMale(Float g5nMale) {
        this.g5nMale = g5nMale;
    }

    public Float getG5nFemale() {
        return g5nFemale;
    }

    public void setG5nFemale(Float g5nFemale) {
        this.g5nFemale = g5nFemale;
    }

    public Float getG5dMale() {
        return g5dMale;
    }

    public void setG5dMale(Float g5dMale) {
        this.g5dMale = g5dMale;
    }

    public Float getG5dFemale() {
        return g5dFemale;
    }

    public void setG5dFemale(Float g5dFemale) {
        this.g5dFemale = g5dFemale;
    }

    public Float getG6nMale() {
        return g6nMale;
    }

    public void setG6nMale(Float g6nMale) {
        this.g6nMale = g6nMale;
    }

    public Float getG6nFemale() {
        return g6nFemale;
    }

    public void setG6nFemale(Float g6nFemale) {
        this.g6nFemale = g6nFemale;
    }

    public Float getG6dMale() {
        return g6dMale;
    }

    public void setG6dMale(Float g6dMale) {
        this.g6dMale = g6dMale;
    }

    public Float getG6dFemale() {
        return g6dFemale;
    }

    public void setG6dFemale(Float g6dFemale) {
        this.g6dFemale = g6dFemale;
    }

    public Float getPpnMale() {
        return ppnMale;
    }

    public void setPpnMale(Float ppnMale) {
        this.ppnMale = ppnMale;
    }

    public Float getPpnFemale() {
        return ppnFemale;
    }

    public void setPpnFemale(Float ppnFemale) {
        this.ppnFemale = ppnFemale;
    }

    public Float getPpdMale() {
        return ppdMale;
    }

    public void setPpdMale(Float ppdMale) {
        this.ppdMale = ppdMale;
    }

    public Float getPpdFemale() {
        return ppdFemale;
    }

    public void setPpdFemale(Float ppdFemale) {
        this.ppdFemale = ppdFemale;
    }

    public Float getP1nMale() {
        return p1nMale;
    }

    public void setP1nMale(Float p1nMale) {
        this.p1nMale = p1nMale;
    }

    public Float getP1nFemale() {
        return p1nFemale;
    }

    public void setP1nFemale(Float p1nFemale) {
        this.p1nFemale = p1nFemale;
    }

    public Float getP1dMale() {
        return p1dMale;
    }

    public void setP1dMale(Float p1dMale) {
        this.p1dMale = p1dMale;
    }

    public Float getP1dFemale() {
        return p1dFemale;
    }

    public void setP1dFemale(Float p1dFemale) {
        this.p1dFemale = p1dFemale;
    }

    public Float getP2nMale() {
        return p2nMale;
    }

    public void setP2nMale(Float p2nMale) {
        this.p2nMale = p2nMale;
    }

    public Float getP2nFemale() {
        return p2nFemale;
    }

    public void setP2nFemale(Float p2nFemale) {
        this.p2nFemale = p2nFemale;
    }

    public Float getP2dMale() {
        return p2dMale;
    }

    public void setP2dMale(Float p2dMale) {
        this.p2dMale = p2dMale;
    }

    public Float getP2dFemale() {
        return p2dFemale;
    }

    public void setP2dFemale(Float p2dFemale) {
        this.p2dFemale = p2dFemale;
    }

    public Float getP3nMale() {
        return p3nMale;
    }

    public void setP3nMale(Float p3nMale) {
        this.p3nMale = p3nMale;
    }

    public Float getP3nFemale() {
        return p3nFemale;
    }

    public void setP3nFemale(Float p3nFemale) {
        this.p3nFemale = p3nFemale;
    }

    public Float getP3dMale() {
        return p3dMale;
    }

    public void setP3dMale(Float p3dMale) {
        this.p3dMale = p3dMale;
    }

    public Float getP3dFemale() {
        return p3dFemale;
    }

    public void setP3dFemale(Float p3dFemale) {
        this.p3dFemale = p3dFemale;
    }

    public Float getP4nMale() {
        return p4nMale;
    }

    public void setP4nMale(Float p4nMale) {
        this.p4nMale = p4nMale;
    }

    public Float getP4nFemale() {
        return p4nFemale;
    }

    public void setP4nFemale(Float p4nFemale) {
        this.p4nFemale = p4nFemale;
    }

    public Float getP4dMale() {
        return p4dMale;
    }

    public void setP4dMale(Float p4dMale) {
        this.p4dMale = p4dMale;
    }

    public Float getP4dFemale() {
        return p4dFemale;
    }

    public void setP4dFemale(Float p4dFemale) {
        this.p4dFemale = p4dFemale;
    }

    public Float getP5nMale() {
        return p5nMale;
    }

    public void setP5nMale(Float p5nMale) {
        this.p5nMale = p5nMale;
    }

    public Float getP5nFemale() {
        return p5nFemale;
    }

    public void setP5nFemale(Float p5nFemale) {
        this.p5nFemale = p5nFemale;
    }

    public Float getP5dMale() {
        return p5dMale;
    }

    public void setP5dMale(Float p5dMale) {
        this.p5dMale = p5dMale;
    }

    public Float getP5dFemale() {
        return p5dFemale;
    }

    public void setP5dFemale(Float p5dFemale) {
        this.p5dFemale = p5dFemale;
    }

    public Float getP6nMale() {
        return p6nMale;
    }

    public void setP6nMale(Float p6nMale) {
        this.p6nMale = p6nMale;
    }

    public Float getP6nFemale() {
        return p6nFemale;
    }

    public void setP6nFemale(Float p6nFemale) {
        this.p6nFemale = p6nFemale;
    }

    public Float getP6dMale() {
        return p6dMale;
    }

    public void setP6dMale(Float p6dMale) {
        this.p6dMale = p6dMale;
    }

    public Float getP6dFemale() {
        return p6dFemale;
    }

    public void setP6dFemale(Float p6dFemale) {
        this.p6dFemale = p6dFemale;
    }

    public Float getSg1nMale() {
        return sg1nMale;
    }

    public void setSg1nMale(Float sg1nMale) {
        this.sg1nMale = sg1nMale;
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

    public Integer getNumeratorReportdt() {
        return numeratorReportdt;
    }

    public void setNumeratorReportdt(Integer numeratorReportdt) {
        this.numeratorReportdt = numeratorReportdt;
    }

    public Integer getDenominatorReportdt() {
        return denominatorReportdt;
    }

    public void setDenominatorReportdt(Integer denominatorReportdt) {
        this.denominatorReportdt = denominatorReportdt;
    }

    public Integer getIndicatorNumeratorId() {
        return indicatorNumeratorId;
    }

    public void setIndicatorNumeratorId(Integer indicatorNumeratorId) {
        this.indicatorNumeratorId = indicatorNumeratorId;
    }

    public Integer getIndicatorDenominatorId() {
        return indicatorDenominatorId;
    }

    public void setIndicatorDenominatorId(Integer indicatorDenominatorId) {
        this.indicatorDenominatorId = indicatorDenominatorId;
    }

    public Integer getCogenclassId() {
        return cogenclassId;
    }

    public void setCogenclassId(Integer cogenclassId) {
        this.cogenclassId = cogenclassId;
    }

    public Integer getAggregateLevelId() {
        return aggregateLevelId;
    }

    public void setAggregateLevelId(Integer aggregateLevelId) {
        this.aggregateLevelId = aggregateLevelId;
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

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Float getSg1nFemale() {
        return sg1nFemale;
    }

    public void setSg1nFemale(Float sg1nFemale) {
        this.sg1nFemale = sg1nFemale;
    }

    public Float getSg1dMale() {
        return sg1dMale;
    }

    public void setSg1dMale(Float sg1dMale) {
        this.sg1dMale = sg1dMale;
    }

    public Float getSg1dFemale() {
        return sg1dFemale;
    }

    public void setSg1dFemale(Float sg1dFemale) {
        this.sg1dFemale = sg1dFemale;
    }

    public Float getSg2nMale() {
        return sg2nMale;
    }

    public void setSg2nMale(Float sg2nMale) {
        this.sg2nMale = sg2nMale;
    }

    public Float getSg2nFemale() {
        return sg2nFemale;
    }

    public void setSg2nFemale(Float sg2nFemale) {
        this.sg2nFemale = sg2nFemale;
    }

    public Float getSg2dMale() {
        return sg2dMale;
    }

    public void setSg2dMale(Float sg2dMale) {
        this.sg2dMale = sg2dMale;
    }

    public Float getSg2dFemale() {
        return sg2dFemale;
    }

    public void setSg2dFemale(Float sg2dFemale) {
        this.sg2dFemale = sg2dFemale;
    }

    public Float getSg3nMale() {
        return sg3nMale;
    }

    public void setSg3nMale(Float sg3nMale) {
        this.sg3nMale = sg3nMale;
    }

    public Float getSg3nFemale() {
        return sg3nFemale;
    }

    public void setSg3nFemale(Float sg3nFemale) {
        this.sg3nFemale = sg3nFemale;
    }

    public Float getSg3dMale() {
        return sg3dMale;
    }

    public void setSg3dMale(Float sg3dMale) {
        this.sg3dMale = sg3dMale;
    }

    public Float getSg3dFemale() {
        return sg3dFemale;
    }

    public void setSg3dFemale(Float sg3dFemale) {
        this.sg3dFemale = sg3dFemale;
    }

    public Float getSg4nMale() {
        return sg4nMale;
    }

    public void setSg4nMale(Float sg4nMale) {
        this.sg4nMale = sg4nMale;
    }

    public Float getSg4nFemale() {
        return sg4nFemale;
    }

    public void setSg4nFemale(Float sg4nFemale) {
        this.sg4nFemale = sg4nFemale;
    }

    public Float getSg4dMale() {
        return sg4dMale;
    }

    public void setSg4dMale(Float sg4dMale) {
        this.sg4dMale = sg4dMale;
    }

    public Float getSg4dFemale() {
        return sg4dFemale;
    }

    public void setSg4dFemale(Float sg4dFemale) {
        this.sg4dFemale = sg4dFemale;
    }

    public Float getSg5nMale() {
        return sg5nMale;
    }

    public void setSg5nMale(Float sg5nMale) {
        this.sg5nMale = sg5nMale;
    }

    public Float getSg5nFemale() {
        return sg5nFemale;
    }

    public void setSg5nFemale(Float sg5nFemale) {
        this.sg5nFemale = sg5nFemale;
    }

    public Float getSg5dMale() {
        return sg5dMale;
    }

    public void setSg5dMale(Float sg5dMale) {
        this.sg5dMale = sg5dMale;
    }

    public Float getSg5dFemale() {
        return sg5dFemale;
    }

    public void setSg5dFemale(Float sg5dFemale) {
        this.sg5dFemale = sg5dFemale;
    }

    public Float getSg6nMale() {
        return sg6nMale;
    }

    public void setSg6nMale(Float sg6nMale) {
        this.sg6nMale = sg6nMale;
    }

    public Float getSg6nFemale() {
        return sg6nFemale;
    }

    public void setSg6nFemale(Float sg6nFemale) {
        this.sg6nFemale = sg6nFemale;
    }

    public Float getSg6dMale() {
        return sg6dMale;
    }

    public void setSg6dMale(Float sg6dMale) {
        this.sg6dMale = sg6dMale;
    }

    public Float getSg6dFemale() {
        return sg6dFemale;
    }

    public void setSg6dFemale(Float sg6dFemale) {
        this.sg6dFemale = sg6dFemale;
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
        if (!(object instanceof PiSummary)) {
            return false;
        }
        PiSummary other = (PiSummary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.PiSummary[ id=" + id + " ]";
    }
    
}
