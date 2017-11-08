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
@Table(name = "other_school_data", catalog = "sisdb", schema = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"report_history_id"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "OtherSchoolData.findAll", query = "SELECT o FROM OtherSchoolData o")})
public class OtherSchoolData implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "report_history_id", nullable = false)
    private int reportHistoryId;

    @Column(name = "water_supply_maynilad")
    private Short waterSupplyMaynilad;

    @Column(name = "water_supply_manila")
    private Short waterSupplyManila;

    @Column(name = "water_supply_local")
    private Short waterSupplyLocal;

    @Column(name = "water_supply_coop")
    private Short waterSupplyCoop;

    @Column(name = "water_supply_other", length = 100)
    private String waterSupplyOther;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "water_monthly_cost", precision = 12)
    private Float waterMonthlyCost;

    @Column(name = "water_fund_sch")
    private Short waterFundSch;

    @Column(name = "water_fund_lgu")
    private Short waterFundLgu;

    @Column(name = "water_fund_pta")
    private Short waterFundPta;

    @Column(name = "water_fund_canteen")
    private Short waterFundCanteen;

    @Column(name = "water_fund_private")
    private Short waterFundPrivate;

    @Column(name = "water_fund_porkbarrel")
    private Short waterFundPorkbarrel;

    @Column(name = "water_fund_others", length = 100)
    private String waterFundOthers;

    @Column(name = "grid_supply_meralco")
    private Short gridSupplyMeralco;

    @Column(name = "grid_supply_local")
    private Short gridSupplyLocal;

    @Column(name = "grid_supply_others", length = 100)
    private String gridSupplyOthers;

    @Column(name = "grid_monthly_cost", precision = 12)
    private Float gridMonthlyCost;

    @Column(name = "grid_fund_sch")
    private Short gridFundSch;

    @Column(name = "grid_fund_lgu")
    private Short gridFundLgu;

    @Column(name = "grid_fund_pta")
    private Short gridFundPta;

    @Column(name = "grid_fund_canteen")
    private Short gridFundCanteen;

    @Column(name = "grid_fund_private")
    private Short gridFundPrivate;

    @Column(name = "grid_fund_porkbarrel")
    private Short gridFundPorkbarrel;

    @Column(name = "grid_fund_others", length = 100)
    private String gridFundOthers;

    @Column(name = "teacher_outside_brgy")
    private Short teacherOutsideBrgy;

    @Column(name = "teacher_outside_citymun")
    private Short teacherOutsideCitymun;

    @Column(name = "isp_smart")
    private Short ispSmart;

    @Column(name = "isp_globe")
    private Short ispGlobe;

    @Column(name = "isp_bayantel")
    private Short ispBayantel;

    @Column(name = "isp_digitel")
    private Short ispDigitel;

    @Column(name = "isp_pldt")
    private Short ispPldt;

    @Column(name = "isp_others", length = 100)
    private String ispOthers;

    @Column(name = "isp_use_division")
    private Short ispUseDivision;

    @Column(name = "isp_use_district")
    private Short ispUseDistrict;

    @Column(name = "isp_use_cafe")
    private Short ispUseCafe;

    @Column(name = "isp_use_home")
    private Short ispUseHome;

    @Column(name = "isp_use_other_sch")
    private Short ispUseOtherSch;

    @Column(name = "isp_sun")
    private Short ispSun;

    @Column(name = "isp_wit")
    private Short ispWit;

    @Column(name = "isp_use_other", length = 100)
    private String ispUseOther;

    @Column(name = "available_net_smart")
    private Short availableNetSmart;

    @Column(name = "available_net_globe")
    private Short availableNetGlobe;

    @Column(name = "available_net_sun")
    private Short availableNetSun;

    @Column(name = "available_net_talkntext")
    private Short availableNetTalkntext;

    @Column(name = "available_net_touch")
    private Short availableNetTouch;

    @Column(name = "available_net_red")
    private Short availableNetRed;

    @Column(name = "available_net_other", length = 100)
    private String availableNetOther;

    @Column(name = "disruptn_cause_nat_calamities")
    private Short disruptnCauseNatCalamities;

    @Column(name = "disruptn_cause_celebration")
    private Short disruptnCauseCelebration;

    @Column(name = "disruptn_cause_others", length = 100)
    private String disruptnCauseOthers;

    @Column(name = "actual_no_of_class_days")
    private Short actualNoOfClassDays;

    @Column(name = "feeding_prog")
    private Short feedingProg;

    @Column(name = "feeding_prog_fund_sch")
    private Short feedingProgFundSch;

    @Column(name = "feeding_prog_fund_lgu")
    private Short feedingProgFundLgu;

    @Column(name = "feeding_prog_fund_pta")
    private Short feedingProgFundPta;

    @Column(name = "feeding_prog_fund_brgy")
    private Short feedingProgFundBrgy;

    @Column(name = "feeding_prog_fund_canteen")
    private Short feedingProgFundCanteen;

    @Column(name = "feeding_prog_fund_private")
    private Short feedingProgFundPrivate;

    @Column(name = "feeding_prog_fund_porkbarrel")
    private Short feedingProgFundPorkbarrel;

    @Column(name = "feeding_prog_fund_sch_vg")
    private Short feedingProgFundSchVg;

    @Column(name = "feeding_prog_fund_others", length = 100)
    private String feedingProgFundOthers;

    @Column(name = "room_7x9")
    private Short room7x9;

    @Column(name = "disruptn_cause_man_made")
    private Short disruptnCauseManMade;

    @Column(name = "teacher_inside_brgy")
    private Short teacherInsideBrgy;

    @Column(name = "teacher_inside_citymun")
    private Short teacherInsideCitymun;

    @Column(name = "teacher_within_brgy")
    private Short teacherWithinBrgy;

    @Column(name = "teacher_within_citymun")
    private Short teacherWithinCitymun;

    @Column(name = "mtbmle_others", length = 50)
    private String mtbmleOthers;

    @Column(name = "mtbmle_chabacano")
    private Short mtbmleChabacano;

    @Column(name = "mtbmle_maranao")
    private Short mtbmleMaranao;

    @Column(name = "mtbmle_magiundanaon")
    private Short mtbmleMagiundanaon;

    @Column(name = "mtbmle_tausug")
    private Short mtbmleTausug;

    @Column(name = "mtbmle_waray")
    private Short mtbmleWaray;

    @Column(name = "mtbmle_hiligaynon")
    private Short mtbmleHiligaynon;

    @Column(name = "mtbmle_cebuano")
    private Short mtbmleCebuano;

    @Column(name = "mtbmle_bikol")
    private Short mtbmleBikol;

    @Column(name = "mtbmle_iloko")
    private Short mtbmleIloko;

    @Column(name = "mtbmle_pangasinense")
    private Short mtbmlePangasinense;

    @Column(name = "mtbmle_kapampangan")
    private Short mtbmleKapampangan;

    @Column(name = "mtbmle_tagalog")
    private Short mtbmleTagalog;

    @Column(name = "mtbmle_ibanag")
    private Short mtbmleIbanag;

    @Column(name = "mtbmle_ivatan")
    private Short mtbmleIvatan;

    @Column(name = "mtbmle_sambal")
    private Short mtbmleSambal;

    @Column(name = "mtbmle_akianon")
    private Short mtbmleAkianon;

    @Column(name = "mtbmle_kinaraya")
    private Short mtbmleKinaraya;

    @Column(name = "mtbmle_surigaonon")
    private Short mtbmleSurigaonon;

    @Column(name = "mtbmle_yakan")
    private Short mtbmleYakan;

    @Column(name = "yr_donation")
    private Short yrDonation;

    @Column(name = "yr_purchase")
    private Short yrPurchase;

    @Column(name = "yr_usufruct")
    private Short yrUsufruct;

    @Column(name = "yr_expropriation")
    private Short yrExpropriation;

    @Column(name = "yr_exchange")
    private Short yrExchange;

    @Column(name = "yr_ppsp")
    private Short yrPpsp;

    @Column(name = "yr_other_year")
    private Short yrOtherYear;

    @Column(name = "yr_others", length = 50)
    private String yrOthers;

    @Column(name = "proof_title")
    private Short proofTitle;

    @Column(name = "proof_tax")
    private Short proofTax;

    @Column(name = "proof_sale")
    private Short proofSale;

    @Column(name = "proof_donation")
    private Short proofDonation;

    @Column(name = "proof_ppsp")
    private Short proofPpsp;

    @Column(name = "proof_usufruct")
    private Short proofUsufruct;

    @Column(name = "proof_moa")
    private Short proofMoa;

    @Column(name = "proof_others", length = 50)
    private String proofOthers;

    @Column(name = "legal_adverse")
    private Short legalAdverse;

    @Column(name = "legal_encroach")
    private Short legalEncroach;

    @Column(name = "legal_others", length = 50)
    private String legalOthers;

    @Column(name = "topography_flat")
    private Short topographyFlat;

    @Column(name = "topography_rolling")
    private Short topographyRolling;

    @Column(name = "topography_hilly")
    private Short topographyHilly;

    @Column(name = "topography_others", length = 50)
    private String topographyOthers;

    @Column(name = "land_area", precision = 12)
    private Float landArea;

    @Column(name = "buildable_space")
    private Short buildableSpace;

    @Column(name = "internet_area")
    private Boolean internetArea;

    @Column(name = "internet_smart")
    private Boolean internetSmart;

    @Column(name = "internet_globe")
    private Boolean internetGlobe;

    @Column(name = "internet_bayantel")
    private Boolean internetBayantel;

    @Column(name = "internet_digitel")
    private Boolean internetDigitel;

    @Column(name = "internet_pldt")
    private Boolean internetPldt;

    @Column(name = "internet_sun")
    private Boolean internetSun;

    @Column(name = "internet_wit")
    private Boolean internetWit;

    @Column(name = "internet_others", length = 100)
    private String internetOthers;

    @Column(length = 100)
    private String vulnerabilities03;

    @Column(length = 100)
    private String vulnerabilities02;

    @Column(length = 100)
    private String vulnerabilities01;

    @Column(name = "resource_livestock")
    private Short resourceLivestock;

    @Column(name = "resource_fishpond")
    private Short resourceFishpond;

    @Column(name = "resource_agriculture")
    private Short resourceAgriculture;

    @Column(name = "resource_garden")
    private Short resourceGarden;

    @Column(name = "resource_others", length = 100)
    private String resourceOthers;

    @Column(name = "resource_none")
    private Short resourceNone;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "shifting_schedule")
    private Short shiftingSchedule;

    @Column(name = "other_shifting", length = 128)
    private String otherShifting;

    @Column(name = "double_shift")
    private Short doubleShift;

    @Column(name = "triple_shift")
    private Short tripleShift;

    @Column(name = "quadruple_shift")
    private Short quadrupleShift;

    @Column(name = "sped_wo_sped_class")
    private Short spedWoSpedClass;

    @Column(name = "agrifish_prog")
    private Short agrifishProg;

    @Column(name = "agrifish_prog_fund_sch")
    private Short agrifishProgFundSch;

    @Column(name = "agrifish_prog_fund_lgu")
    private Short agrifishProgFundLgu;

    @Column(name = "agrifish_prog_fund_pta")
    private Short agrifishProgFundPta;

    @Column(name = "agrifish_prog_fund_brgy")
    private Short agrifishProgFundBrgy;

    @Column(name = "agrifish_prog_fund_canteen")
    private Short agrifishProgFundCanteen;

    @Column(name = "agrifish_prog_fund_private")
    private Short agrifishProgFundPrivate;

    @Column(name = "agrifish_prog_fund_others", length = 100)
    private String agrifishProgFundOthers;

    @Column(name = "offgrid_supply_solar")
    private Short offgridSupplySolar;

    @Column(name = "offgrid_supply_generator")
    private Short offgridSupplyGenerator;

    @Column(name = "offgrid_supply_others", length = 100)
    private String offgridSupplyOthers;

    public OtherSchoolData() {
    }

    public OtherSchoolData(Integer id) {
        this.id = id;
    }

    public OtherSchoolData(Integer id, int reportHistoryId) {
        this.id = id;
        this.reportHistoryId = reportHistoryId;
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

    public Short getWaterSupplyMaynilad() {
        return waterSupplyMaynilad;
    }

    public void setWaterSupplyMaynilad(Short waterSupplyMaynilad) {
        this.waterSupplyMaynilad = waterSupplyMaynilad;
    }

    public Short getWaterSupplyManila() {
        return waterSupplyManila;
    }

    public void setWaterSupplyManila(Short waterSupplyManila) {
        this.waterSupplyManila = waterSupplyManila;
    }

    public Short getWaterSupplyLocal() {
        return waterSupplyLocal;
    }

    public void setWaterSupplyLocal(Short waterSupplyLocal) {
        this.waterSupplyLocal = waterSupplyLocal;
    }

    public Short getWaterSupplyCoop() {
        return waterSupplyCoop;
    }

    public void setWaterSupplyCoop(Short waterSupplyCoop) {
        this.waterSupplyCoop = waterSupplyCoop;
    }

    public String getWaterSupplyOther() {
        return waterSupplyOther;
    }

    public void setWaterSupplyOther(String waterSupplyOther) {
        this.waterSupplyOther = waterSupplyOther;
    }

    public Float getWaterMonthlyCost() {
        return waterMonthlyCost;
    }

    public void setWaterMonthlyCost(Float waterMonthlyCost) {
        this.waterMonthlyCost = waterMonthlyCost;
    }

    public Short getWaterFundSch() {
        return waterFundSch;
    }

    public void setWaterFundSch(Short waterFundSch) {
        this.waterFundSch = waterFundSch;
    }

    public Short getWaterFundLgu() {
        return waterFundLgu;
    }

    public void setWaterFundLgu(Short waterFundLgu) {
        this.waterFundLgu = waterFundLgu;
    }

    public Short getWaterFundPta() {
        return waterFundPta;
    }

    public void setWaterFundPta(Short waterFundPta) {
        this.waterFundPta = waterFundPta;
    }

    public Short getWaterFundCanteen() {
        return waterFundCanteen;
    }

    public void setWaterFundCanteen(Short waterFundCanteen) {
        this.waterFundCanteen = waterFundCanteen;
    }

    public Short getWaterFundPrivate() {
        return waterFundPrivate;
    }

    public void setWaterFundPrivate(Short waterFundPrivate) {
        this.waterFundPrivate = waterFundPrivate;
    }

    public Short getWaterFundPorkbarrel() {
        return waterFundPorkbarrel;
    }

    public void setWaterFundPorkbarrel(Short waterFundPorkbarrel) {
        this.waterFundPorkbarrel = waterFundPorkbarrel;
    }

    public String getWaterFundOthers() {
        return waterFundOthers;
    }

    public void setWaterFundOthers(String waterFundOthers) {
        this.waterFundOthers = waterFundOthers;
    }

    public Short getGridSupplyMeralco() {
        return gridSupplyMeralco;
    }

    public void setGridSupplyMeralco(Short gridSupplyMeralco) {
        this.gridSupplyMeralco = gridSupplyMeralco;
    }

    public Short getGridSupplyLocal() {
        return gridSupplyLocal;
    }

    public void setGridSupplyLocal(Short gridSupplyLocal) {
        this.gridSupplyLocal = gridSupplyLocal;
    }

    public String getGridSupplyOthers() {
        return gridSupplyOthers;
    }

    public void setGridSupplyOthers(String gridSupplyOthers) {
        this.gridSupplyOthers = gridSupplyOthers;
    }

    public Float getGridMonthlyCost() {
        return gridMonthlyCost;
    }

    public void setGridMonthlyCost(Float gridMonthlyCost) {
        this.gridMonthlyCost = gridMonthlyCost;
    }

    public Short getGridFundSch() {
        return gridFundSch;
    }

    public void setGridFundSch(Short gridFundSch) {
        this.gridFundSch = gridFundSch;
    }

    public Short getGridFundLgu() {
        return gridFundLgu;
    }

    public void setGridFundLgu(Short gridFundLgu) {
        this.gridFundLgu = gridFundLgu;
    }

    public Short getGridFundPta() {
        return gridFundPta;
    }

    public void setGridFundPta(Short gridFundPta) {
        this.gridFundPta = gridFundPta;
    }

    public Short getGridFundCanteen() {
        return gridFundCanteen;
    }

    public void setGridFundCanteen(Short gridFundCanteen) {
        this.gridFundCanteen = gridFundCanteen;
    }

    public Short getGridFundPrivate() {
        return gridFundPrivate;
    }

    public void setGridFundPrivate(Short gridFundPrivate) {
        this.gridFundPrivate = gridFundPrivate;
    }

    public Short getGridFundPorkbarrel() {
        return gridFundPorkbarrel;
    }

    public void setGridFundPorkbarrel(Short gridFundPorkbarrel) {
        this.gridFundPorkbarrel = gridFundPorkbarrel;
    }

    public String getGridFundOthers() {
        return gridFundOthers;
    }

    public void setGridFundOthers(String gridFundOthers) {
        this.gridFundOthers = gridFundOthers;
    }

    public Short getTeacherOutsideBrgy() {
        return teacherOutsideBrgy;
    }

    public void setTeacherOutsideBrgy(Short teacherOutsideBrgy) {
        this.teacherOutsideBrgy = teacherOutsideBrgy;
    }

    public Short getTeacherOutsideCitymun() {
        return teacherOutsideCitymun;
    }

    public void setTeacherOutsideCitymun(Short teacherOutsideCitymun) {
        this.teacherOutsideCitymun = teacherOutsideCitymun;
    }

    public Short getIspSmart() {
        return ispSmart;
    }

    public void setIspSmart(Short ispSmart) {
        this.ispSmart = ispSmart;
    }

    public Short getIspGlobe() {
        return ispGlobe;
    }

    public void setIspGlobe(Short ispGlobe) {
        this.ispGlobe = ispGlobe;
    }

    public Short getIspBayantel() {
        return ispBayantel;
    }

    public void setIspBayantel(Short ispBayantel) {
        this.ispBayantel = ispBayantel;
    }

    public Short getIspDigitel() {
        return ispDigitel;
    }

    public void setIspDigitel(Short ispDigitel) {
        this.ispDigitel = ispDigitel;
    }

    public Short getIspPldt() {
        return ispPldt;
    }

    public void setIspPldt(Short ispPldt) {
        this.ispPldt = ispPldt;
    }

    public String getIspOthers() {
        return ispOthers;
    }

    public void setIspOthers(String ispOthers) {
        this.ispOthers = ispOthers;
    }

    public Short getIspUseDivision() {
        return ispUseDivision;
    }

    public void setIspUseDivision(Short ispUseDivision) {
        this.ispUseDivision = ispUseDivision;
    }

    public Short getIspUseDistrict() {
        return ispUseDistrict;
    }

    public void setIspUseDistrict(Short ispUseDistrict) {
        this.ispUseDistrict = ispUseDistrict;
    }

    public Short getIspUseCafe() {
        return ispUseCafe;
    }

    public void setIspUseCafe(Short ispUseCafe) {
        this.ispUseCafe = ispUseCafe;
    }

    public Short getIspUseHome() {
        return ispUseHome;
    }

    public void setIspUseHome(Short ispUseHome) {
        this.ispUseHome = ispUseHome;
    }

    public Short getIspUseOtherSch() {
        return ispUseOtherSch;
    }

    public void setIspUseOtherSch(Short ispUseOtherSch) {
        this.ispUseOtherSch = ispUseOtherSch;
    }

    public Short getIspSun() {
        return ispSun;
    }

    public void setIspSun(Short ispSun) {
        this.ispSun = ispSun;
    }

    public Short getIspWit() {
        return ispWit;
    }

    public void setIspWit(Short ispWit) {
        this.ispWit = ispWit;
    }

    public String getIspUseOther() {
        return ispUseOther;
    }

    public void setIspUseOther(String ispUseOther) {
        this.ispUseOther = ispUseOther;
    }

    public Short getAvailableNetSmart() {
        return availableNetSmart;
    }

    public void setAvailableNetSmart(Short availableNetSmart) {
        this.availableNetSmart = availableNetSmart;
    }

    public Short getAvailableNetGlobe() {
        return availableNetGlobe;
    }

    public void setAvailableNetGlobe(Short availableNetGlobe) {
        this.availableNetGlobe = availableNetGlobe;
    }

    public Short getAvailableNetSun() {
        return availableNetSun;
    }

    public void setAvailableNetSun(Short availableNetSun) {
        this.availableNetSun = availableNetSun;
    }

    public Short getAvailableNetTalkntext() {
        return availableNetTalkntext;
    }

    public void setAvailableNetTalkntext(Short availableNetTalkntext) {
        this.availableNetTalkntext = availableNetTalkntext;
    }

    public Short getAvailableNetTouch() {
        return availableNetTouch;
    }

    public void setAvailableNetTouch(Short availableNetTouch) {
        this.availableNetTouch = availableNetTouch;
    }

    public Short getAvailableNetRed() {
        return availableNetRed;
    }

    public void setAvailableNetRed(Short availableNetRed) {
        this.availableNetRed = availableNetRed;
    }

    public String getAvailableNetOther() {
        return availableNetOther;
    }

    public void setAvailableNetOther(String availableNetOther) {
        this.availableNetOther = availableNetOther;
    }

    public Short getDisruptnCauseNatCalamities() {
        return disruptnCauseNatCalamities;
    }

    public void setDisruptnCauseNatCalamities(Short disruptnCauseNatCalamities) {
        this.disruptnCauseNatCalamities = disruptnCauseNatCalamities;
    }

    public Short getDisruptnCauseCelebration() {
        return disruptnCauseCelebration;
    }

    public void setDisruptnCauseCelebration(Short disruptnCauseCelebration) {
        this.disruptnCauseCelebration = disruptnCauseCelebration;
    }

    public String getDisruptnCauseOthers() {
        return disruptnCauseOthers;
    }

    public void setDisruptnCauseOthers(String disruptnCauseOthers) {
        this.disruptnCauseOthers = disruptnCauseOthers;
    }

    public Short getActualNoOfClassDays() {
        return actualNoOfClassDays;
    }

    public void setActualNoOfClassDays(Short actualNoOfClassDays) {
        this.actualNoOfClassDays = actualNoOfClassDays;
    }

    public Short getFeedingProg() {
        return feedingProg;
    }

    public void setFeedingProg(Short feedingProg) {
        this.feedingProg = feedingProg;
    }

    public Short getFeedingProgFundSch() {
        return feedingProgFundSch;
    }

    public void setFeedingProgFundSch(Short feedingProgFundSch) {
        this.feedingProgFundSch = feedingProgFundSch;
    }

    public Short getFeedingProgFundLgu() {
        return feedingProgFundLgu;
    }

    public void setFeedingProgFundLgu(Short feedingProgFundLgu) {
        this.feedingProgFundLgu = feedingProgFundLgu;
    }

    public Short getFeedingProgFundPta() {
        return feedingProgFundPta;
    }

    public void setFeedingProgFundPta(Short feedingProgFundPta) {
        this.feedingProgFundPta = feedingProgFundPta;
    }

    public Short getFeedingProgFundBrgy() {
        return feedingProgFundBrgy;
    }

    public void setFeedingProgFundBrgy(Short feedingProgFundBrgy) {
        this.feedingProgFundBrgy = feedingProgFundBrgy;
    }

    public Short getFeedingProgFundCanteen() {
        return feedingProgFundCanteen;
    }

    public void setFeedingProgFundCanteen(Short feedingProgFundCanteen) {
        this.feedingProgFundCanteen = feedingProgFundCanteen;
    }

    public Short getFeedingProgFundPrivate() {
        return feedingProgFundPrivate;
    }

    public void setFeedingProgFundPrivate(Short feedingProgFundPrivate) {
        this.feedingProgFundPrivate = feedingProgFundPrivate;
    }

    public Short getFeedingProgFundPorkbarrel() {
        return feedingProgFundPorkbarrel;
    }

    public void setFeedingProgFundPorkbarrel(Short feedingProgFundPorkbarrel) {
        this.feedingProgFundPorkbarrel = feedingProgFundPorkbarrel;
    }

    public Short getFeedingProgFundSchVg() {
        return feedingProgFundSchVg;
    }

    public void setFeedingProgFundSchVg(Short feedingProgFundSchVg) {
        this.feedingProgFundSchVg = feedingProgFundSchVg;
    }

    public String getFeedingProgFundOthers() {
        return feedingProgFundOthers;
    }

    public void setFeedingProgFundOthers(String feedingProgFundOthers) {
        this.feedingProgFundOthers = feedingProgFundOthers;
    }

    public Short getRoom7x9() {
        return room7x9;
    }

    public void setRoom7x9(Short room7x9) {
        this.room7x9 = room7x9;
    }

    public Short getDisruptnCauseManMade() {
        return disruptnCauseManMade;
    }

    public void setDisruptnCauseManMade(Short disruptnCauseManMade) {
        this.disruptnCauseManMade = disruptnCauseManMade;
    }

    public Short getTeacherInsideBrgy() {
        return teacherInsideBrgy;
    }

    public void setTeacherInsideBrgy(Short teacherInsideBrgy) {
        this.teacherInsideBrgy = teacherInsideBrgy;
    }

    public Short getTeacherInsideCitymun() {
        return teacherInsideCitymun;
    }

    public void setTeacherInsideCitymun(Short teacherInsideCitymun) {
        this.teacherInsideCitymun = teacherInsideCitymun;
    }

    public Short getTeacherWithinBrgy() {
        return teacherWithinBrgy;
    }

    public void setTeacherWithinBrgy(Short teacherWithinBrgy) {
        this.teacherWithinBrgy = teacherWithinBrgy;
    }

    public Short getTeacherWithinCitymun() {
        return teacherWithinCitymun;
    }

    public void setTeacherWithinCitymun(Short teacherWithinCitymun) {
        this.teacherWithinCitymun = teacherWithinCitymun;
    }

    public String getMtbmleOthers() {
        return mtbmleOthers;
    }

    public void setMtbmleOthers(String mtbmleOthers) {
        this.mtbmleOthers = mtbmleOthers;
    }

    public Short getMtbmleChabacano() {
        return mtbmleChabacano;
    }

    public void setMtbmleChabacano(Short mtbmleChabacano) {
        this.mtbmleChabacano = mtbmleChabacano;
    }

    public Short getMtbmleMaranao() {
        return mtbmleMaranao;
    }

    public void setMtbmleMaranao(Short mtbmleMaranao) {
        this.mtbmleMaranao = mtbmleMaranao;
    }

    public Short getMtbmleMagiundanaon() {
        return mtbmleMagiundanaon;
    }

    public void setMtbmleMagiundanaon(Short mtbmleMagiundanaon) {
        this.mtbmleMagiundanaon = mtbmleMagiundanaon;
    }

    public Short getMtbmleTausug() {
        return mtbmleTausug;
    }

    public void setMtbmleTausug(Short mtbmleTausug) {
        this.mtbmleTausug = mtbmleTausug;
    }

    public Short getMtbmleWaray() {
        return mtbmleWaray;
    }

    public void setMtbmleWaray(Short mtbmleWaray) {
        this.mtbmleWaray = mtbmleWaray;
    }

    public Short getMtbmleHiligaynon() {
        return mtbmleHiligaynon;
    }

    public void setMtbmleHiligaynon(Short mtbmleHiligaynon) {
        this.mtbmleHiligaynon = mtbmleHiligaynon;
    }

    public Short getMtbmleCebuano() {
        return mtbmleCebuano;
    }

    public void setMtbmleCebuano(Short mtbmleCebuano) {
        this.mtbmleCebuano = mtbmleCebuano;
    }

    public Short getMtbmleBikol() {
        return mtbmleBikol;
    }

    public void setMtbmleBikol(Short mtbmleBikol) {
        this.mtbmleBikol = mtbmleBikol;
    }

    public Short getMtbmleIloko() {
        return mtbmleIloko;
    }

    public void setMtbmleIloko(Short mtbmleIloko) {
        this.mtbmleIloko = mtbmleIloko;
    }

    public Short getMtbmlePangasinense() {
        return mtbmlePangasinense;
    }

    public void setMtbmlePangasinense(Short mtbmlePangasinense) {
        this.mtbmlePangasinense = mtbmlePangasinense;
    }

    public Short getMtbmleKapampangan() {
        return mtbmleKapampangan;
    }

    public void setMtbmleKapampangan(Short mtbmleKapampangan) {
        this.mtbmleKapampangan = mtbmleKapampangan;
    }

    public Short getMtbmleTagalog() {
        return mtbmleTagalog;
    }

    public void setMtbmleTagalog(Short mtbmleTagalog) {
        this.mtbmleTagalog = mtbmleTagalog;
    }

    public Short getMtbmleIbanag() {
        return mtbmleIbanag;
    }

    public void setMtbmleIbanag(Short mtbmleIbanag) {
        this.mtbmleIbanag = mtbmleIbanag;
    }

    public Short getMtbmleIvatan() {
        return mtbmleIvatan;
    }

    public void setMtbmleIvatan(Short mtbmleIvatan) {
        this.mtbmleIvatan = mtbmleIvatan;
    }

    public Short getMtbmleSambal() {
        return mtbmleSambal;
    }

    public void setMtbmleSambal(Short mtbmleSambal) {
        this.mtbmleSambal = mtbmleSambal;
    }

    public Short getMtbmleAkianon() {
        return mtbmleAkianon;
    }

    public void setMtbmleAkianon(Short mtbmleAkianon) {
        this.mtbmleAkianon = mtbmleAkianon;
    }

    public Short getMtbmleKinaraya() {
        return mtbmleKinaraya;
    }

    public void setMtbmleKinaraya(Short mtbmleKinaraya) {
        this.mtbmleKinaraya = mtbmleKinaraya;
    }

    public Short getMtbmleSurigaonon() {
        return mtbmleSurigaonon;
    }

    public void setMtbmleSurigaonon(Short mtbmleSurigaonon) {
        this.mtbmleSurigaonon = mtbmleSurigaonon;
    }

    public Short getMtbmleYakan() {
        return mtbmleYakan;
    }

    public void setMtbmleYakan(Short mtbmleYakan) {
        this.mtbmleYakan = mtbmleYakan;
    }

    public Short getYrDonation() {
        return yrDonation;
    }

    public void setYrDonation(Short yrDonation) {
        this.yrDonation = yrDonation;
    }

    public Short getYrPurchase() {
        return yrPurchase;
    }

    public void setYrPurchase(Short yrPurchase) {
        this.yrPurchase = yrPurchase;
    }

    public Short getYrUsufruct() {
        return yrUsufruct;
    }

    public void setYrUsufruct(Short yrUsufruct) {
        this.yrUsufruct = yrUsufruct;
    }

    public Short getYrExpropriation() {
        return yrExpropriation;
    }

    public void setYrExpropriation(Short yrExpropriation) {
        this.yrExpropriation = yrExpropriation;
    }

    public Short getYrExchange() {
        return yrExchange;
    }

    public void setYrExchange(Short yrExchange) {
        this.yrExchange = yrExchange;
    }

    public Short getYrPpsp() {
        return yrPpsp;
    }

    public void setYrPpsp(Short yrPpsp) {
        this.yrPpsp = yrPpsp;
    }

    public Short getYrOtherYear() {
        return yrOtherYear;
    }

    public void setYrOtherYear(Short yrOtherYear) {
        this.yrOtherYear = yrOtherYear;
    }

    public String getYrOthers() {
        return yrOthers;
    }

    public void setYrOthers(String yrOthers) {
        this.yrOthers = yrOthers;
    }

    public Short getProofTitle() {
        return proofTitle;
    }

    public void setProofTitle(Short proofTitle) {
        this.proofTitle = proofTitle;
    }

    public Short getProofTax() {
        return proofTax;
    }

    public void setProofTax(Short proofTax) {
        this.proofTax = proofTax;
    }

    public Short getProofSale() {
        return proofSale;
    }

    public void setProofSale(Short proofSale) {
        this.proofSale = proofSale;
    }

    public Short getProofDonation() {
        return proofDonation;
    }

    public void setProofDonation(Short proofDonation) {
        this.proofDonation = proofDonation;
    }

    public Short getProofPpsp() {
        return proofPpsp;
    }

    public void setProofPpsp(Short proofPpsp) {
        this.proofPpsp = proofPpsp;
    }

    public Short getProofUsufruct() {
        return proofUsufruct;
    }

    public void setProofUsufruct(Short proofUsufruct) {
        this.proofUsufruct = proofUsufruct;
    }

    public Short getProofMoa() {
        return proofMoa;
    }

    public void setProofMoa(Short proofMoa) {
        this.proofMoa = proofMoa;
    }

    public String getProofOthers() {
        return proofOthers;
    }

    public void setProofOthers(String proofOthers) {
        this.proofOthers = proofOthers;
    }

    public Short getLegalAdverse() {
        return legalAdverse;
    }

    public void setLegalAdverse(Short legalAdverse) {
        this.legalAdverse = legalAdverse;
    }

    public Short getLegalEncroach() {
        return legalEncroach;
    }

    public void setLegalEncroach(Short legalEncroach) {
        this.legalEncroach = legalEncroach;
    }

    public String getLegalOthers() {
        return legalOthers;
    }

    public void setLegalOthers(String legalOthers) {
        this.legalOthers = legalOthers;
    }

    public Short getTopographyFlat() {
        return topographyFlat;
    }

    public void setTopographyFlat(Short topographyFlat) {
        this.topographyFlat = topographyFlat;
    }

    public Short getTopographyRolling() {
        return topographyRolling;
    }

    public void setTopographyRolling(Short topographyRolling) {
        this.topographyRolling = topographyRolling;
    }

    public Short getTopographyHilly() {
        return topographyHilly;
    }

    public void setTopographyHilly(Short topographyHilly) {
        this.topographyHilly = topographyHilly;
    }

    public String getTopographyOthers() {
        return topographyOthers;
    }

    public void setTopographyOthers(String topographyOthers) {
        this.topographyOthers = topographyOthers;
    }

    public Float getLandArea() {
        return landArea;
    }

    public void setLandArea(Float landArea) {
        this.landArea = landArea;
    }

    public Short getBuildableSpace() {
        return buildableSpace;
    }

    public void setBuildableSpace(Short buildableSpace) {
        this.buildableSpace = buildableSpace;
    }

    public Boolean getInternetArea() {
        return internetArea;
    }

    public void setInternetArea(Boolean internetArea) {
        this.internetArea = internetArea;
    }

    public Boolean getInternetSmart() {
        return internetSmart;
    }

    public void setInternetSmart(Boolean internetSmart) {
        this.internetSmart = internetSmart;
    }

    public Boolean getInternetGlobe() {
        return internetGlobe;
    }

    public void setInternetGlobe(Boolean internetGlobe) {
        this.internetGlobe = internetGlobe;
    }

    public Boolean getInternetBayantel() {
        return internetBayantel;
    }

    public void setInternetBayantel(Boolean internetBayantel) {
        this.internetBayantel = internetBayantel;
    }

    public Boolean getInternetDigitel() {
        return internetDigitel;
    }

    public void setInternetDigitel(Boolean internetDigitel) {
        this.internetDigitel = internetDigitel;
    }

    public Boolean getInternetPldt() {
        return internetPldt;
    }

    public void setInternetPldt(Boolean internetPldt) {
        this.internetPldt = internetPldt;
    }

    public Boolean getInternetSun() {
        return internetSun;
    }

    public void setInternetSun(Boolean internetSun) {
        this.internetSun = internetSun;
    }

    public Boolean getInternetWit() {
        return internetWit;
    }

    public void setInternetWit(Boolean internetWit) {
        this.internetWit = internetWit;
    }

    public String getInternetOthers() {
        return internetOthers;
    }

    public void setInternetOthers(String internetOthers) {
        this.internetOthers = internetOthers;
    }

    public String getVulnerabilities03() {
        return vulnerabilities03;
    }

    public void setVulnerabilities03(String vulnerabilities03) {
        this.vulnerabilities03 = vulnerabilities03;
    }

    public String getVulnerabilities02() {
        return vulnerabilities02;
    }

    public void setVulnerabilities02(String vulnerabilities02) {
        this.vulnerabilities02 = vulnerabilities02;
    }

    public String getVulnerabilities01() {
        return vulnerabilities01;
    }

    public void setVulnerabilities01(String vulnerabilities01) {
        this.vulnerabilities01 = vulnerabilities01;
    }

    public Short getResourceLivestock() {
        return resourceLivestock;
    }

    public void setResourceLivestock(Short resourceLivestock) {
        this.resourceLivestock = resourceLivestock;
    }

    public Short getResourceFishpond() {
        return resourceFishpond;
    }

    public void setResourceFishpond(Short resourceFishpond) {
        this.resourceFishpond = resourceFishpond;
    }

    public Short getResourceAgriculture() {
        return resourceAgriculture;
    }

    public void setResourceAgriculture(Short resourceAgriculture) {
        this.resourceAgriculture = resourceAgriculture;
    }

    public Short getResourceGarden() {
        return resourceGarden;
    }

    public void setResourceGarden(Short resourceGarden) {
        this.resourceGarden = resourceGarden;
    }

    public String getResourceOthers() {
        return resourceOthers;
    }

    public void setResourceOthers(String resourceOthers) {
        this.resourceOthers = resourceOthers;
    }

    public Short getResourceNone() {
        return resourceNone;
    }

    public void setResourceNone(Short resourceNone) {
        this.resourceNone = resourceNone;
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

    public Short getShiftingSchedule() {
        return shiftingSchedule;
    }

    public void setShiftingSchedule(Short shiftingSchedule) {
        this.shiftingSchedule = shiftingSchedule;
    }

    public String getOtherShifting() {
        return otherShifting;
    }

    public void setOtherShifting(String otherShifting) {
        this.otherShifting = otherShifting;
    }

    public Short getDoubleShift() {
        return doubleShift;
    }

    public void setDoubleShift(Short doubleShift) {
        this.doubleShift = doubleShift;
    }

    public Short getTripleShift() {
        return tripleShift;
    }

    public void setTripleShift(Short tripleShift) {
        this.tripleShift = tripleShift;
    }

    public Short getQuadrupleShift() {
        return quadrupleShift;
    }

    public void setQuadrupleShift(Short quadrupleShift) {
        this.quadrupleShift = quadrupleShift;
    }

    public Short getSpedWoSpedClass() {
        return spedWoSpedClass;
    }

    public void setSpedWoSpedClass(Short spedWoSpedClass) {
        this.spedWoSpedClass = spedWoSpedClass;
    }

    public Short getAgrifishProg() {
        return agrifishProg;
    }

    public void setAgrifishProg(Short agrifishProg) {
        this.agrifishProg = agrifishProg;
    }

    public Short getAgrifishProgFundSch() {
        return agrifishProgFundSch;
    }

    public void setAgrifishProgFundSch(Short agrifishProgFundSch) {
        this.agrifishProgFundSch = agrifishProgFundSch;
    }

    public Short getAgrifishProgFundLgu() {
        return agrifishProgFundLgu;
    }

    public void setAgrifishProgFundLgu(Short agrifishProgFundLgu) {
        this.agrifishProgFundLgu = agrifishProgFundLgu;
    }

    public Short getAgrifishProgFundPta() {
        return agrifishProgFundPta;
    }

    public void setAgrifishProgFundPta(Short agrifishProgFundPta) {
        this.agrifishProgFundPta = agrifishProgFundPta;
    }

    public Short getAgrifishProgFundBrgy() {
        return agrifishProgFundBrgy;
    }

    public void setAgrifishProgFundBrgy(Short agrifishProgFundBrgy) {
        this.agrifishProgFundBrgy = agrifishProgFundBrgy;
    }

    public Short getAgrifishProgFundCanteen() {
        return agrifishProgFundCanteen;
    }

    public void setAgrifishProgFundCanteen(Short agrifishProgFundCanteen) {
        this.agrifishProgFundCanteen = agrifishProgFundCanteen;
    }

    public Short getAgrifishProgFundPrivate() {
        return agrifishProgFundPrivate;
    }

    public void setAgrifishProgFundPrivate(Short agrifishProgFundPrivate) {
        this.agrifishProgFundPrivate = agrifishProgFundPrivate;
    }

    public String getAgrifishProgFundOthers() {
        return agrifishProgFundOthers;
    }

    public void setAgrifishProgFundOthers(String agrifishProgFundOthers) {
        this.agrifishProgFundOthers = agrifishProgFundOthers;
    }

    public Short getOffgridSupplySolar() {
        return offgridSupplySolar;
    }

    public void setOffgridSupplySolar(Short offgridSupplySolar) {
        this.offgridSupplySolar = offgridSupplySolar;
    }

    public Short getOffgridSupplyGenerator() {
        return offgridSupplyGenerator;
    }

    public void setOffgridSupplyGenerator(Short offgridSupplyGenerator) {
        this.offgridSupplyGenerator = offgridSupplyGenerator;
    }

    public String getOffgridSupplyOthers() {
        return offgridSupplyOthers;
    }

    public void setOffgridSupplyOthers(String offgridSupplyOthers) {
        this.offgridSupplyOthers = offgridSupplyOthers;
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
        if (!(object instanceof OtherSchoolData)) {
            return false;
        }
        OtherSchoolData other = (OtherSchoolData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.OtherSchoolData[ id=" + id + " ]";
    }

}
