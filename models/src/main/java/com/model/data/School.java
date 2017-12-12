/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *LisRefPosition
 * @author ej
 */
@Entity
@Table(name = "school", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "School.findAll", query = "SELECT s FROM School s")})
public class School implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "school_name", nullable = false, length = 128)
    private String schoolName;
    @Column(name = "school_short_name", length = 15)
    private String schoolShortName;
    @Column(name = "short_name", length = 255)
    private String shortName;
    @Column(name = "previous_name", length = 128)
    private String previousName;
    @Column(name = "school_head")
    private Integer schoolHead;
    @Column(name = "school_head_position")
    private Integer schoolHeadPosition;
    private Integer registrar;
    @Column(name = "registrar_position")
    private Integer registrarPosition;
    @Basic(optional = false)
    @Column(name = "street_address", nullable = false, length = 60)
    private String streetAddress;
    @Column(name = "zip_cd", length = 10)
    private String zipCd;
    @Column(name = "telephone_no", length = 35)
    private String telephoneNo;
    @Column(name = "fax_no", length = 30)
    private String faxNo;
    @Column(name = "mobile_no", length = 100)
    private String mobileNo;
    @Column(name = "school_contact_id")
    private Integer schoolContactId;
    @Column(name = "email_address", length = 60)
    private String emailAddress;
    @Column(name = "web_address", length = 60)
    private String webAddress;
    @Column(name = "mother_school_id")
    private Integer motherSchoolId;
    @Basic(optional = false)
    @Column(name = "date_established", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateEstablished;
    @Column(name = "secondary_co_subclass_id")
    private Short secondaryCoSubclassId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "land_area", precision = 12)
    private Float landArea;
    @Column(name = "funding_type")
    private Short fundingType;
    @Column(name = "school_id")
    private Integer schoolId;
    @Column(name = "secondary_school_id")
    private Integer secondarySchoolId;
    @Column(name = "school_head_name", length = 60)
    private String schoolHeadName;
    @Column(name = "school_head_position_name", length = 100)
    private String schoolHeadPositionName;
    @Column(name = "registrar_name", length = 60)
    private String registrarName;
    @Column(name = "curricular_offering_class_id")
    private Integer curricularOfferingClassId;
    @Column(name = "sub_school_class_id")
    private Integer subSchoolClassId;
    @Column(name = "school_type_id")
    private Short schoolTypeId;
    @Column(name = "aso_id")
    private Integer asoId;
    @Column(name = "secondary_sub_type_id")
    private Integer secondarySubTypeId;
    @Column(name = "accreditation_number")
    private Integer accreditationNumber;
    @Column(name = "curr_class", length = 200)
    private String currClass;
    @Basic(optional = false)
    @Column(name = "co_gen_class", nullable = false)
    private short coGenClass;
    @Column(name = "date_closed")
    @Temporal(TemporalType.DATE)
    private Date dateClosed;
    @Column(name = "elementary_class_id")
    private Integer elementaryClassId;
    @Column(name = "cointegrated_id")
    private Integer cointegratedId;
    @Column(name = "to_dist_kms", precision = 5, scale = 2)
    private BigDecimal toDistKms;
    @Column(name = "to_dist_means", length = 300)
    private String toDistMeans;
    @Column(name = "to_dist_cost", precision = 6, scale = 2)
    private BigDecimal toDistCost;
    @Column(name = "to_dist_min")
    private Integer toDistMin;
    @Column(name = "to_div_kms", precision = 5, scale = 2)
    private BigDecimal toDivKms;
    @Column(name = "to_div_means", length = 300)
    private String toDivMeans;
    @Column(name = "to_div_cost", precision = 6, scale = 2)
    private BigDecimal toDivCost;
    @Column(name = "to_div_min")
    private Integer toDivMin;
    @Column(name = "no_isp")
    private Short noIsp;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "created_by")
    private Integer createdBy;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "updated_by")
    private Integer updatedBy;
    @Column(name = "ref_legislative_id_orig")
    private Short refLegislativeIdOrig;
    @Column(name = "ref_municipality_id_orig")
    private Integer refMunicipalityIdOrig;
    @Column(name = "permit_no", length = 60)
    private String permitNo;
    @Column(name = "permit_no_kinder", length = 60)
    private String permitNoKinder;
    @Column(name = "permit_no_secondary", length = 60)
    private String permitNoSecondary;
    @Column(name = "recognition_no", length = 60)
    private String recognitionNo;
    @Column(name = "recognition_no_kinder", length = 60)
    private String recognitionNoKinder;
    @Column(name = "recognition_no_secondary", length = 60)
    private String recognitionNoSecondary;
    @Column(name = "prmtappdt_submttd")
    @Temporal(TemporalType.DATE)
    private Date prmtappdtSubmttd;
    @Column(name = "prmtappdt_submttd_kinder")
    @Temporal(TemporalType.DATE)
    private Date prmtappdtSubmttdKinder;
    @Column(name = "prmtappdt_submttd_secondary")
    @Temporal(TemporalType.DATE)
    private Date prmtappdtSubmttdSecondary;
    @Column(name = "close_reason", length = 250)
    private String closeReason;
    @Column(name = "reopen_date")
    @Temporal(TemporalType.DATE)
    private Date reopenDate;
    @Column(name = "sph_status")
    private Boolean sphStatus;
    @Column(name = "nearest_ges", length = 128)
    private String nearestGes;
    @Column(name = "to_nearest_ges_kms", precision = 5, scale = 2)
    private BigDecimal toNearestGesKms;
    @Column(name = "to_nearest_ges_means", length = 300)
    private String toNearestGesMeans;
    @Column(name = "to_nearest_ges_cost", precision = 6, scale = 2)
    private BigDecimal toNearestGesCost;
    @Column(name = "to_nearest_ges_min")
    private Integer toNearestGesMin;
    @Column(name = "nearest_gss", length = 128)
    private String nearestGss;
    @Column(name = "to_nearest_gss_kms", precision = 5, scale = 2)
    private BigDecimal toNearestGssKms;
    @Column(name = "to_nearest_gss_means", length = 300)
    private String toNearestGssMeans;
    @Column(name = "to_nearest_gss_cost", precision = 6, scale = 2)
    private BigDecimal toNearestGssCost;
    @Column(name = "to_nearest_gss_min")
    private Integer toNearestGssMin;
    @Column(name = "nearest_pes", length = 128)
    private String nearestPes;
    @Column(name = "to_nearest_pes_kms", precision = 5, scale = 2)
    private BigDecimal toNearestPesKms;
    @Column(name = "to_nearest_pes_means", length = 300)
    private String toNearestPesMeans;
    @Column(name = "to_nearest_pes_cost", precision = 6, scale = 2)
    private BigDecimal toNearestPesCost;
    @Column(name = "to_nearest_pes_min")
    private Integer toNearestPesMin;
    @Column(name = "nearest_pss", length = 128)
    private String nearestPss;
    @Column(name = "to_nearest_pss_kms", precision = 5, scale = 2)
    private BigDecimal toNearestPssKms;
    @Column(name = "to_nearest_pss_means", length = 300)
    private String toNearestPssMeans;
    @Column(name = "to_nearest_pss_cost", precision = 6, scale = 2)
    private BigDecimal toNearestPssCost;
    @Column(name = "to_nearest_pss_min")
    private Integer toNearestPssMin;
    @Column(name = "night_school")
    private Short nightSchool;
    @Column(name = "registrar_position_name", length = 100)
    private String registrarPositionName;
    @Column(name = "beis_school_id")
    private Integer beisSchoolId;
    @Column(name = "attached_totertiary")
    private Boolean attachedTotertiary;
    @Column(precision = 12)
    private Float latitude;
    @Column(name = "date_ofoperation")
    @Temporal(TemporalType.DATE)
    private Date dateOfoperation;
    @Column(precision = 12)
    private Float longtitude;
    @Column(name = "implementing_unit")
    private Short implementingUnit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolId")
    private List<ProgramsOffered> programsOfferedList;
    @OneToMany(mappedBy = "schoolId")
    private List<SbmSchoolPractice> sbmSchoolPracticeList;
    @OneToMany(mappedBy = "schoolId")
    private List<SbmSchoolResult> sbmSchoolResultList;
    @OneToMany(mappedBy = "schoolId")
    private List<AncillaryService> ancillaryServiceList;
    @OneToMany(mappedBy = "schoolId")
    private List<EnrollmentAffiliation> enrollmentAffiliationList;
    @OneToMany(mappedBy = "schoolId")
    private List<SfGuardUserProfile> sfGuardUserProfileList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolId")
    private List<LearningOutcomesScores> learningOutcomesScoresList;
    @JoinColumn(name = "ref_legislative_id", referencedColumnName = "id")
    @ManyToOne
    private RefLegislative refLegislativeId;
    @JoinColumn(name = "division_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefOffice divisionId;
    @JoinColumn(name = "branggay_id", referencedColumnName = "id")
    @ManyToOne
    private RefBaranggay branggayId;
    @JoinColumn(name = "site_ownership_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefCodeSetting siteOwnershipId;
    @JoinColumn(name = "region_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefRegion regionId;
    @JoinColumn(name = "class_organization_id", referencedColumnName = "id")
    @ManyToOne
    private RefCodeSetting classOrganizationId;
    @JoinColumn(name = "proof_of_ownership_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefCodeSetting proofOfOwnershipId;
    @JoinColumn(name = "ownership_issue_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefCodeSetting ownershipIssueId;
    @JoinColumn(name = "curricular_class_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefCodeSetting curricularClassId;
    @JoinColumn(name = "general_classification_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefCodeSetting generalClassificationId;
    @JoinColumn(name = "school_subclassification_id", referencedColumnName = "id")
    @ManyToOne
    private RefCodeSetting schoolSubclassificationId;
    @JoinColumn(name = "topography_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefCodeSetting topographyId;
    @JoinColumn(name = "ref_municipality_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefMunicipality refMunicipalityId;
    @JoinColumn(name = "district_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RefOffice districtId;
    @JoinColumn(name = "province_id", referencedColumnName = "id")
    @ManyToOne
    private RefProvince provinceId;
    @JoinColumn(name = "curricular_subclass_id", referencedColumnName = "id")
    @ManyToOne
    private RefCodeSetting curricularSubclassId;

    public School() {
    }

    public School(Integer id) {
        this.id = id;
    }

    public School(Integer id, String schoolName, String streetAddress, Date dateEstablished, short coGenClass, Date createdAt, Date updatedAt) {
        this.id = id;
        this.schoolName = schoolName;
        this.streetAddress = streetAddress;
        this.dateEstablished = dateEstablished;
        this.coGenClass = coGenClass;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolShortName() {
        return schoolShortName;
    }

    public void setSchoolShortName(String schoolShortName) {
        this.schoolShortName = schoolShortName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getPreviousName() {
        return previousName;
    }

    public void setPreviousName(String previousName) {
        this.previousName = previousName;
    }

    public Integer getSchoolHead() {
        return schoolHead;
    }

    public void setSchoolHead(Integer schoolHead) {
        this.schoolHead = schoolHead;
    }

    public Integer getSchoolHeadPosition() {
        return schoolHeadPosition;
    }

    public void setSchoolHeadPosition(Integer schoolHeadPosition) {
        this.schoolHeadPosition = schoolHeadPosition;
    }

    public Integer getRegistrar() {
        return registrar;
    }

    public void setRegistrar(Integer registrar) {
        this.registrar = registrar;
    }

    public Integer getRegistrarPosition() {
        return registrarPosition;
    }

    public void setRegistrarPosition(Integer registrarPosition) {
        this.registrarPosition = registrarPosition;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipCd() {
        return zipCd;
    }

    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Integer getSchoolContactId() {
        return schoolContactId;
    }

    public void setSchoolContactId(Integer schoolContactId) {
        this.schoolContactId = schoolContactId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public Integer getMotherSchoolId() {
        return motherSchoolId;
    }

    public void setMotherSchoolId(Integer motherSchoolId) {
        this.motherSchoolId = motherSchoolId;
    }

    public Date getDateEstablished() {
        return dateEstablished;
    }

    public void setDateEstablished(Date dateEstablished) {
        this.dateEstablished = dateEstablished;
    }

    public Short getSecondaryCoSubclassId() {
        return secondaryCoSubclassId;
    }

    public void setSecondaryCoSubclassId(Short secondaryCoSubclassId) {
        this.secondaryCoSubclassId = secondaryCoSubclassId;
    }

    public Float getLandArea() {
        return landArea;
    }

    public void setLandArea(Float landArea) {
        this.landArea = landArea;
    }

    public Short getFundingType() {
        return fundingType;
    }

    public void setFundingType(Short fundingType) {
        this.fundingType = fundingType;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getSecondarySchoolId() {
        return secondarySchoolId;
    }

    public void setSecondarySchoolId(Integer secondarySchoolId) {
        this.secondarySchoolId = secondarySchoolId;
    }

    public String getSchoolHeadName() {
        return schoolHeadName;
    }

    public void setSchoolHeadName(String schoolHeadName) {
        this.schoolHeadName = schoolHeadName;
    }

    public String getSchoolHeadPositionName() {
        return schoolHeadPositionName;
    }

    public void setSchoolHeadPositionName(String schoolHeadPositionName) {
        this.schoolHeadPositionName = schoolHeadPositionName;
    }

    public String getRegistrarName() {
        return registrarName;
    }

    public void setRegistrarName(String registrarName) {
        this.registrarName = registrarName;
    }

    public Integer getCurricularOfferingClassId() {
        return curricularOfferingClassId;
    }

    public void setCurricularOfferingClassId(Integer curricularOfferingClassId) {
        this.curricularOfferingClassId = curricularOfferingClassId;
    }

    public Integer getSubSchoolClassId() {
        return subSchoolClassId;
    }

    public void setSubSchoolClassId(Integer subSchoolClassId) {
        this.subSchoolClassId = subSchoolClassId;
    }

    public Short getSchoolTypeId() {
        return schoolTypeId;
    }

    public void setSchoolTypeId(Short schoolTypeId) {
        this.schoolTypeId = schoolTypeId;
    }

    public Integer getAsoId() {
        return asoId;
    }

    public void setAsoId(Integer asoId) {
        this.asoId = asoId;
    }

    public Integer getSecondarySubTypeId() {
        return secondarySubTypeId;
    }

    public void setSecondarySubTypeId(Integer secondarySubTypeId) {
        this.secondarySubTypeId = secondarySubTypeId;
    }

    public Integer getAccreditationNumber() {
        return accreditationNumber;
    }

    public void setAccreditationNumber(Integer accreditationNumber) {
        this.accreditationNumber = accreditationNumber;
    }

    public String getCurrClass() {
        return currClass;
    }

    public void setCurrClass(String currClass) {
        this.currClass = currClass;
    }

    public short getCoGenClass() {
        return coGenClass;
    }

    public void setCoGenClass(short coGenClass) {
        this.coGenClass = coGenClass;
    }

    public Date getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(Date dateClosed) {
        this.dateClosed = dateClosed;
    }

    public Integer getElementaryClassId() {
        return elementaryClassId;
    }

    public void setElementaryClassId(Integer elementaryClassId) {
        this.elementaryClassId = elementaryClassId;
    }

    public Integer getCointegratedId() {
        return cointegratedId;
    }

    public void setCointegratedId(Integer cointegratedId) {
        this.cointegratedId = cointegratedId;
    }

    public BigDecimal getToDistKms() {
        return toDistKms;
    }

    public void setToDistKms(BigDecimal toDistKms) {
        this.toDistKms = toDistKms;
    }

    public String getToDistMeans() {
        return toDistMeans;
    }

    public void setToDistMeans(String toDistMeans) {
        this.toDistMeans = toDistMeans;
    }

    public BigDecimal getToDistCost() {
        return toDistCost;
    }

    public void setToDistCost(BigDecimal toDistCost) {
        this.toDistCost = toDistCost;
    }

    public Integer getToDistMin() {
        return toDistMin;
    }

    public void setToDistMin(Integer toDistMin) {
        this.toDistMin = toDistMin;
    }

    public BigDecimal getToDivKms() {
        return toDivKms;
    }

    public void setToDivKms(BigDecimal toDivKms) {
        this.toDivKms = toDivKms;
    }

    public String getToDivMeans() {
        return toDivMeans;
    }

    public void setToDivMeans(String toDivMeans) {
        this.toDivMeans = toDivMeans;
    }

    public BigDecimal getToDivCost() {
        return toDivCost;
    }

    public void setToDivCost(BigDecimal toDivCost) {
        this.toDivCost = toDivCost;
    }

    public Integer getToDivMin() {
        return toDivMin;
    }

    public void setToDivMin(Integer toDivMin) {
        this.toDivMin = toDivMin;
    }

    public Short getNoIsp() {
        return noIsp;
    }

    public void setNoIsp(Short noIsp) {
        this.noIsp = noIsp;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Short getRefLegislativeIdOrig() {
        return refLegislativeIdOrig;
    }

    public void setRefLegislativeIdOrig(Short refLegislativeIdOrig) {
        this.refLegislativeIdOrig = refLegislativeIdOrig;
    }

    public Integer getRefMunicipalityIdOrig() {
        return refMunicipalityIdOrig;
    }

    public void setRefMunicipalityIdOrig(Integer refMunicipalityIdOrig) {
        this.refMunicipalityIdOrig = refMunicipalityIdOrig;
    }

    public String getPermitNo() {
        return permitNo;
    }

    public void setPermitNo(String permitNo) {
        this.permitNo = permitNo;
    }

    public String getPermitNoKinder() {
        return permitNoKinder;
    }

    public void setPermitNoKinder(String permitNoKinder) {
        this.permitNoKinder = permitNoKinder;
    }

    public String getPermitNoSecondary() {
        return permitNoSecondary;
    }

    public void setPermitNoSecondary(String permitNoSecondary) {
        this.permitNoSecondary = permitNoSecondary;
    }

    public String getRecognitionNo() {
        return recognitionNo;
    }

    public void setRecognitionNo(String recognitionNo) {
        this.recognitionNo = recognitionNo;
    }

    public String getRecognitionNoKinder() {
        return recognitionNoKinder;
    }

    public void setRecognitionNoKinder(String recognitionNoKinder) {
        this.recognitionNoKinder = recognitionNoKinder;
    }

    public String getRecognitionNoSecondary() {
        return recognitionNoSecondary;
    }

    public void setRecognitionNoSecondary(String recognitionNoSecondary) {
        this.recognitionNoSecondary = recognitionNoSecondary;
    }

    public Date getPrmtappdtSubmttd() {
        return prmtappdtSubmttd;
    }

    public void setPrmtappdtSubmttd(Date prmtappdtSubmttd) {
        this.prmtappdtSubmttd = prmtappdtSubmttd;
    }

    public Date getPrmtappdtSubmttdKinder() {
        return prmtappdtSubmttdKinder;
    }

    public void setPrmtappdtSubmttdKinder(Date prmtappdtSubmttdKinder) {
        this.prmtappdtSubmttdKinder = prmtappdtSubmttdKinder;
    }

    public Date getPrmtappdtSubmttdSecondary() {
        return prmtappdtSubmttdSecondary;
    }

    public void setPrmtappdtSubmttdSecondary(Date prmtappdtSubmttdSecondary) {
        this.prmtappdtSubmttdSecondary = prmtappdtSubmttdSecondary;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public Date getReopenDate() {
        return reopenDate;
    }

    public void setReopenDate(Date reopenDate) {
        this.reopenDate = reopenDate;
    }

    public Boolean getSphStatus() {
        return sphStatus;
    }

    public void setSphStatus(Boolean sphStatus) {
        this.sphStatus = sphStatus;
    }

    public String getNearestGes() {
        return nearestGes;
    }

    public void setNearestGes(String nearestGes) {
        this.nearestGes = nearestGes;
    }

    public BigDecimal getToNearestGesKms() {
        return toNearestGesKms;
    }

    public void setToNearestGesKms(BigDecimal toNearestGesKms) {
        this.toNearestGesKms = toNearestGesKms;
    }

    public String getToNearestGesMeans() {
        return toNearestGesMeans;
    }

    public void setToNearestGesMeans(String toNearestGesMeans) {
        this.toNearestGesMeans = toNearestGesMeans;
    }

    public BigDecimal getToNearestGesCost() {
        return toNearestGesCost;
    }

    public void setToNearestGesCost(BigDecimal toNearestGesCost) {
        this.toNearestGesCost = toNearestGesCost;
    }

    public Integer getToNearestGesMin() {
        return toNearestGesMin;
    }

    public void setToNearestGesMin(Integer toNearestGesMin) {
        this.toNearestGesMin = toNearestGesMin;
    }

    public String getNearestGss() {
        return nearestGss;
    }

    public void setNearestGss(String nearestGss) {
        this.nearestGss = nearestGss;
    }

    public BigDecimal getToNearestGssKms() {
        return toNearestGssKms;
    }

    public void setToNearestGssKms(BigDecimal toNearestGssKms) {
        this.toNearestGssKms = toNearestGssKms;
    }

    public String getToNearestGssMeans() {
        return toNearestGssMeans;
    }

    public void setToNearestGssMeans(String toNearestGssMeans) {
        this.toNearestGssMeans = toNearestGssMeans;
    }

    public BigDecimal getToNearestGssCost() {
        return toNearestGssCost;
    }

    public void setToNearestGssCost(BigDecimal toNearestGssCost) {
        this.toNearestGssCost = toNearestGssCost;
    }

    public Integer getToNearestGssMin() {
        return toNearestGssMin;
    }

    public void setToNearestGssMin(Integer toNearestGssMin) {
        this.toNearestGssMin = toNearestGssMin;
    }

    public String getNearestPes() {
        return nearestPes;
    }

    public void setNearestPes(String nearestPes) {
        this.nearestPes = nearestPes;
    }

    public BigDecimal getToNearestPesKms() {
        return toNearestPesKms;
    }

    public void setToNearestPesKms(BigDecimal toNearestPesKms) {
        this.toNearestPesKms = toNearestPesKms;
    }

    public String getToNearestPesMeans() {
        return toNearestPesMeans;
    }

    public void setToNearestPesMeans(String toNearestPesMeans) {
        this.toNearestPesMeans = toNearestPesMeans;
    }

    public BigDecimal getToNearestPesCost() {
        return toNearestPesCost;
    }

    public void setToNearestPesCost(BigDecimal toNearestPesCost) {
        this.toNearestPesCost = toNearestPesCost;
    }

    public Integer getToNearestPesMin() {
        return toNearestPesMin;
    }

    public void setToNearestPesMin(Integer toNearestPesMin) {
        this.toNearestPesMin = toNearestPesMin;
    }

    public String getNearestPss() {
        return nearestPss;
    }

    public void setNearestPss(String nearestPss) {
        this.nearestPss = nearestPss;
    }

    public BigDecimal getToNearestPssKms() {
        return toNearestPssKms;
    }

    public void setToNearestPssKms(BigDecimal toNearestPssKms) {
        this.toNearestPssKms = toNearestPssKms;
    }

    public String getToNearestPssMeans() {
        return toNearestPssMeans;
    }

    public void setToNearestPssMeans(String toNearestPssMeans) {
        this.toNearestPssMeans = toNearestPssMeans;
    }

    public BigDecimal getToNearestPssCost() {
        return toNearestPssCost;
    }

    public void setToNearestPssCost(BigDecimal toNearestPssCost) {
        this.toNearestPssCost = toNearestPssCost;
    }

    public Integer getToNearestPssMin() {
        return toNearestPssMin;
    }

    public void setToNearestPssMin(Integer toNearestPssMin) {
        this.toNearestPssMin = toNearestPssMin;
    }

    public Short getNightSchool() {
        return nightSchool;
    }

    public void setNightSchool(Short nightSchool) {
        this.nightSchool = nightSchool;
    }

    public String getRegistrarPositionName() {
        return registrarPositionName;
    }

    public void setRegistrarPositionName(String registrarPositionName) {
        this.registrarPositionName = registrarPositionName;
    }

    public Integer getBeisSchoolId() {
        return beisSchoolId;
    }

    public void setBeisSchoolId(Integer beisSchoolId) {
        this.beisSchoolId = beisSchoolId;
    }

    public Boolean getAttachedTotertiary() {
        return attachedTotertiary;
    }

    public void setAttachedTotertiary(Boolean attachedTotertiary) {
        this.attachedTotertiary = attachedTotertiary;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Date getDateOfoperation() {
        return dateOfoperation;
    }

    public void setDateOfoperation(Date dateOfoperation) {
        this.dateOfoperation = dateOfoperation;
    }

    public Float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Float longtitude) {
        this.longtitude = longtitude;
    }

    public Short getImplementingUnit() {
        return implementingUnit;
    }

    public void setImplementingUnit(Short implementingUnit) {
        this.implementingUnit = implementingUnit;
    }

    @XmlTransient
    public List<ProgramsOffered> getProgramsOfferedList() {
        return programsOfferedList;
    }

    public void setProgramsOfferedList(List<ProgramsOffered> programsOfferedList) {
        this.programsOfferedList = programsOfferedList;
    }

    @XmlTransient
    public List<SbmSchoolPractice> getSbmSchoolPracticeList() {
        return sbmSchoolPracticeList;
    }

    public void setSbmSchoolPracticeList(List<SbmSchoolPractice> sbmSchoolPracticeList) {
        this.sbmSchoolPracticeList = sbmSchoolPracticeList;
    }

    @XmlTransient
    public List<SbmSchoolResult> getSbmSchoolResultList() {
        return sbmSchoolResultList;
    }

    public void setSbmSchoolResultList(List<SbmSchoolResult> sbmSchoolResultList) {
        this.sbmSchoolResultList = sbmSchoolResultList;
    }

    @XmlTransient
    public List<AncillaryService> getAncillaryServiceList() {
        return ancillaryServiceList;
    }

    public void setAncillaryServiceList(List<AncillaryService> ancillaryServiceList) {
        this.ancillaryServiceList = ancillaryServiceList;
    }

    @XmlTransient
    public List<EnrollmentAffiliation> getEnrollmentAffiliationList() {
        return enrollmentAffiliationList;
    }

    public void setEnrollmentAffiliationList(List<EnrollmentAffiliation> enrollmentAffiliationList) {
        this.enrollmentAffiliationList = enrollmentAffiliationList;
    }

    @XmlTransient
    public List<SfGuardUserProfile> getSfGuardUserProfileList() {
        return sfGuardUserProfileList;
    }

    public void setSfGuardUserProfileList(List<SfGuardUserProfile> sfGuardUserProfileList) {
        this.sfGuardUserProfileList = sfGuardUserProfileList;
    }

    @XmlTransient
    public List<LearningOutcomesScores> getLearningOutcomesScoresList() {
        return learningOutcomesScoresList;
    }

    public void setLearningOutcomesScoresList(List<LearningOutcomesScores> learningOutcomesScoresList) {
        this.learningOutcomesScoresList = learningOutcomesScoresList;
    }

    public RefLegislative getRefLegislativeId() {
        return refLegislativeId;
    }

    public void setRefLegislativeId(RefLegislative refLegislativeId) {
        this.refLegislativeId = refLegislativeId;
    }

    public RefOffice getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(RefOffice divisionId) {
        this.divisionId = divisionId;
    }

    public RefBaranggay getBranggayId() {
        return branggayId;
    }

    public void setBranggayId(RefBaranggay branggayId) {
        this.branggayId = branggayId;
    }

    public RefCodeSetting getSiteOwnershipId() {
        return siteOwnershipId;
    }

    public void setSiteOwnershipId(RefCodeSetting siteOwnershipId) {
        this.siteOwnershipId = siteOwnershipId;
    }

    public RefRegion getRegionId() {
        return regionId;
    }

    public void setRegionId(RefRegion regionId) {
        this.regionId = regionId;
    }

    public RefCodeSetting getClassOrganizationId() {
        return classOrganizationId;
    }

    public void setClassOrganizationId(RefCodeSetting classOrganizationId) {
        this.classOrganizationId = classOrganizationId;
    }

    public RefCodeSetting getProofOfOwnershipId() {
        return proofOfOwnershipId;
    }

    public void setProofOfOwnershipId(RefCodeSetting proofOfOwnershipId) {
        this.proofOfOwnershipId = proofOfOwnershipId;
    }

    public RefCodeSetting getOwnershipIssueId() {
        return ownershipIssueId;
    }

    public void setOwnershipIssueId(RefCodeSetting ownershipIssueId) {
        this.ownershipIssueId = ownershipIssueId;
    }

    public RefCodeSetting getCurricularClassId() {
        return curricularClassId;
    }

    public void setCurricularClassId(RefCodeSetting curricularClassId) {
        this.curricularClassId = curricularClassId;
    }

    public RefCodeSetting getGeneralClassificationId() {
        return generalClassificationId;
    }

    public void setGeneralClassificationId(RefCodeSetting generalClassificationId) {
        this.generalClassificationId = generalClassificationId;
    }

    public RefCodeSetting getSchoolSubclassificationId() {
        return schoolSubclassificationId;
    }

    public void setSchoolSubclassificationId(RefCodeSetting schoolSubclassificationId) {
        this.schoolSubclassificationId = schoolSubclassificationId;
    }

    public RefCodeSetting getTopographyId() {
        return topographyId;
    }

    public void setTopographyId(RefCodeSetting topographyId) {
        this.topographyId = topographyId;
    }

    public RefMunicipality getRefMunicipalityId() {
        return refMunicipalityId;
    }

    public void setRefMunicipalityId(RefMunicipality refMunicipalityId) {
        this.refMunicipalityId = refMunicipalityId;
    }

    public RefOffice getDistrictId() {
        return districtId;
    }

    public void setDistrictId(RefOffice districtId) {
        this.districtId = districtId;
    }

    public RefProvince getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(RefProvince provinceId) {
        this.provinceId = provinceId;
    }

    public RefCodeSetting getCurricularSubclassId() {
        return curricularSubclassId;
    }

    public void setCurricularSubclassId(RefCodeSetting curricularSubclassId) {
        this.curricularSubclassId = curricularSubclassId;
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
        if (!(object instanceof School)) {
            return false;
        }
        School other = (School) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.LisSchool[ id=" + id + " ]";
    }
    
}
