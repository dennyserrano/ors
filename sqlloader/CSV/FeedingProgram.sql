SELECT sph.sy_from, sph.school_id

-- Feeding Program
  ,IFNULL(osd.feeding_prog,0) AS sch_with_feeding
  ,IFNULL(osd.feeding_prog_fund_sch,0) AS feeding_school_mooe
  ,IFNULL(osd.feeding_prog_fund_lgu,0) AS feeding_lgu_sef
  ,IFNULL(osd.feeding_prog_fund_pta,0) AS feeding_pta
  ,IFNULL(osd.feeding_prog_fund_brgy,0) AS feeding_barangay
  ,IFNULL(osd.feeding_prog_fund_canteen,0) AS feeding_canteen
  ,IFNULL(osd.feeding_prog_fund_private,0) AS feeding_priv_sect
  ,IFNULL(osd.feeding_prog_fund_porkbarrel,0) AS feeding_pork_barrel
  ,IFNULL(osd.feeding_prog_fund_sch_vg,0) AS feeding_school_veg_garden
  ,IFNULL(osd.feeding_prog_fund_others,"") AS feeding_others

-- Harvest
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=163 and oyd.item_id=531 and oyd.sy_from=2016)),0) as feeding_veg_2009
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=163 and oyd.item_id=532 and oyd.sy_from=2016)),0) as feeding_fishpond_2009
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=163 and oyd.item_id=533 and oyd.sy_from=2016)),0) as feeding_livestock_2009
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=163 and oyd.item_id=531 and oyd.sy_from=2016)),0) as feeding_veg_2010
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=163 and oyd.item_id=532 and oyd.sy_from=2016)),0) as feeding_fishpond_2010
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=163 and oyd.item_id=533 and oyd.sy_from=2016)),0) as feeding_livestock_2010
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=163 and oyd.item_id=531 and oyd.sy_from=2016)),0) as feeding_veg_2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=163 and oyd.item_id=532 and oyd.sy_from=2016)),0) as feeding_fishpond_2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=163 and oyd.item_id=533 and oyd.sy_from=2016)),0) as feeding_livestock_2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=163 and oyd.item_id=531 and oyd.sy_from=sph.sy_from)),0) as feeding_veg
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=163 and oyd.item_id=532 and oyd.sy_from=sph.sy_from)),0) as feeding_fishpond
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=163 and oyd.item_id=533 and oyd.sy_from=sph.sy_from)),0) as feeding_livestock

-- Agriculture & Fishery Resources
  ,IFNULL(osd.resource_livestock,0) AS agrifish_livestock
  ,IFNULL(osd.resource_fishpond,0) AS agrifish_fishpond
  ,IFNULL(osd.resource_agriculture,0) AS agrifish_agricrops
  ,IFNULL(osd.resource_garden,0) AS agrifish_veg_garden
  ,IFNULL(osd.resource_others,"") AS agrifish_others
  ,IFNULL(osd.resource_none,0) AS agrifish_none

-- School with Agriculture & Fishery
  ,IFNULL(osd.agrifish_prog,0) AS sch_with_agrifish

-- Agriculture & Fishery Funding
  ,IFNULL(osd.agrifish_prog_fund_sch,0) AS agri_school_mooe
  ,IFNULL(osd.agrifish_prog_fund_lgu,0) AS agri_lgu_sef
  ,IFNULL(osd.agrifish_prog_fund_pta,0) AS agri_pta
  ,IFNULL(osd.agrifish_prog_fund_brgy,0) AS agri_barangay
  ,IFNULL(osd.agrifish_prog_fund_canteen,0) AS agri_canteen
  ,IFNULL(osd.agrifish_prog_fund_private,0) AS agri_priv_sect
  ,IFNULL(osd.agrifish_prog_fund_others,"") AS agri_others

-- Causes of Class Disruption
,IFNULL(osd.disruptn_cause_nat_calamities,0) as disruptn_natural 
,IFNULL(osd.disruptn_cause_man_made,0) as disruptn_man_made 
,IFNULL(osd.disruptn_cause_celebration,0) as disruptn_celebration 
,IFNULL(osd.disruptn_cause_others,"") as disruptn_others 

-- Number of Class Days
,IFNULL(osd.actual_no_of_class_days,0) as class_days

-- Monitoring Visits
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=515 and oyd.sy_from=2016)),0) as mv_physicalfacilities_2009
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=516 and oyd.sy_from=2016)),0) as mv_district_2009
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=517 and oyd.sy_from=2016)),0) as mv_division_2009
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=518 and oyd.sy_from=2016)),0) as mv_region_2009
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=519 and oyd.sy_from=2016)),0) as mv_central_2009
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=515 and oyd.sy_from=2016)),0) as mv_physicalfacilities_2010
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=516 and oyd.sy_from=2016)),0) as mv_district_2010
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=517 and oyd.sy_from=2016)),0) as mv_division_2010
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=518 and oyd.sy_from=2016)),0) as mv_region_2010
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=519 and oyd.sy_from=2016)),0) as mv_central_2010
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=515 and oyd.sy_from=2016)),0) as mv_physicalfacilities_2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=516 and oyd.sy_from=2016)),0) as mv_district_2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=517 and oyd.sy_from=2016)),0) as mv_division_2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=518 and oyd.sy_from=2016)),0) as mv_region_2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=519 and oyd.sy_from=2016)),0) as mv_central_2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=515 and oyd.sy_from=sph.sy_from)),0) as mv_physicalfacilities
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=516 and oyd.sy_from=sph.sy_from)),0) as mv_district
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=517 and oyd.sy_from=sph.sy_from)),0) as mv_division
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=518 and oyd.sy_from=sph.sy_from)),0) as mv_region
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=148 and oyd.item_id=519 and oyd.sy_from=sph.sy_from)),0) as mv_central
  
-- Served as Evacuation Center
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=147 and oyd.item_id=530 and oyd.sy_from=2016)),0) as sch_evac_center_2009
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=147 and oyd.item_id=530 and oyd.sy_from=2016)),0) as sch_evac_center_2010
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=147 and oyd.item_id=530 and oyd.sy_from=2016)),0) as sch_evac_center_2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=147 and oyd.item_id=530 and oyd.sy_from=sph.sy_from)),0) as sch_evac_center

-- Disaster/Calamities - Natural
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=520 and oyd.sy_from=2016)),0) as dc_typhoon_2009
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=521 and oyd.sy_from=2016)),0) as dc_flood_2009
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=522 and oyd.sy_from=2016)),0) as dc_earthquake_2009
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=523 and oyd.sy_from=2016)),0) as dc_landslide_2009
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=524 and oyd.sy_from=2016)),0) as dc_tsunami_2009
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=525 and oyd.sy_from=2016)),0) as dc_volcanic_2009
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=520 and oyd.sy_from=2016)),0) as dc_typhoon_2010
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=521 and oyd.sy_from=2016)),0) as dc_flood_2010
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=522 and oyd.sy_from=2016)),0) as dc_earthquake_2010
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=523 and oyd.sy_from=2016)),0) as dc_landslide_2010
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=524 and oyd.sy_from=2016)),0) as dc_tsunami_2010
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=525 and oyd.sy_from=2016)),0) as dc_volcanic_2010
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=520 and oyd.sy_from=2016)),0) as dc_typhoon_2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=521 and oyd.sy_from=2016)),0) as dc_flood_2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=522 and oyd.sy_from=2016)),0) as dc_earthquake_2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=523 and oyd.sy_from=2016)),0) as dc_landslide_2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=524 and oyd.sy_from=2016)),0) as dc_tsunami_2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=525 and oyd.sy_from=2016)),0) as dc_volcanic_2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=520 and oyd.sy_from=sph.sy_from)),0) as dc_typhoon
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=521 and oyd.sy_from=sph.sy_from)),0) as dc_flood
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=522 and oyd.sy_from=sph.sy_from)),0) as dc_earthquake
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=523 and oyd.sy_from=sph.sy_from)),0) as dc_landslide
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=524 and oyd.sy_from=sph.sy_from)),0) as dc_tsunami
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=525 and oyd.sy_from=sph.sy_from)),0) as dc_volcanic

-- Disaster/Calamities - Man-made
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=527 and oyd.sy_from=2016)),0) as dc_armedconflict_2009
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=528 and oyd.sy_from=2016)),0) as dc_fire_2009
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=529 and oyd.sy_from=2016)),0) as dc_others_2009
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=527 and oyd.sy_from=2016)),0) as dc_armedconflict_2010
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=528 and oyd.sy_from=2016)),0) as dc_fire_2010
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=529 and oyd.sy_from=2016)),0) as dc_others_2010
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=527 and oyd.sy_from=2016)),0) as dc_armedconflict_2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=528 and oyd.sy_from=2016)),0) as dc_fire_2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=529 and oyd.sy_from=2016)),0) as dc_others_2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=527 and oyd.sy_from=sph.sy_from)),0) as dc_armedconflict
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=528 and oyd.sy_from=sph.sy_from)),0) as dc_fire
  ,IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id=rh.id AND oyd.category_id=152 and oyd.item_id=529 and oyd.sy_from=sph.sy_from)),0) as dc_others

FROM ebeisdb.school_profile_history sph
INNER JOIN ebeisdb.ref_reports reports on (reports.co_genclass_id=sph.co_gen_class 
 and reports.general_classification_id=sph.general_classification_id and reports.ref_report_generics_id=if(sph.sy_from=2016,2,1))
INNER JOIN ebeisdb.ref_report_history rrh on (reports.id=rrh.report_id and rrh.sy_from=CAST(sph.sy_from AS CHAR))
LEFT JOIN ebeisdb.report_history rh on (rh.ref_report_history_id=rrh.id and rh.school_id=sph.school_id 
 and rh.report_status IN (301,302))
LEFT JOIN ebeisdb.other_school_data osd on (osd.report_history_id = rh.id)
WHERE sph.general_classification_id=7 and sph.take_part_id in (1,2,3) and sph.sy_from =2016
 GROUP BY sph.sy_from, sph.school_id
 ORDER BY sph.sy_from, sph.school_id

INTO OUTFILE '/var/tmp/feedingprogram.csv'
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n';
