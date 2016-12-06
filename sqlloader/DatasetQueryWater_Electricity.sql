insert into orsdb.water_electricity(school_year,school_id,water_source_localpiped,water_source_deepwell,water_source_rainwater,
water_source_natural,without_water_supply,water_supply_maynilad,water_supply_manila,water_supply_local,water_supply_coop,
water_supply_others,water_monthly_cost,water_fund_mooe,water_fund_lgu,water_fund_pta,water_fund_canteen,water_fund_private,
water_fund_pdaf,water_fund_others,electric_source_grid,electric_source_offgrid,offgrid_source_solar,offgrid_source_generator,
offgrid_supply_others,no_source_electricity,grid_supply_meralco,grid_supply_localcoop,grid_supply_others,grid_monthly_cost,
grid_fund_mooe,grid_fund_lgu,grid_fund_pta,grid_fund_canteen,grid_fund_private,grid_fund_pdaf,grid_fund_others)

select sph.sy_from, sph.school_id

-- Water Supply Source
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class and y.item_type_id=3900 and y.item_id=390)),0) as water_source_localpiped 
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class and y.item_type_id=3900 and y.item_id=391)),0) as water_source_deepwell 
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class and y.item_type_id=3900 and y.item_id=392)),0) as water_source_rainwater 
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class and y.item_type_id=3900 and y.item_id=393)),0) as water_source_natural 
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class and y.item_type_id=3900 and y.item_id=394)),0) as without_water_supply 

-- Water Supply Provider
	,IFNULL(osd.water_supply_maynilad,0) as water_supply_maynilad
	,IFNULL(osd.water_supply_manila,0) as water_supply_manila
	,IFNULL(osd.water_supply_local,0) as water_supply_local
	,IFNULL(osd.water_supply_coop,0) as water_supply_coop 
	,IFNULL(osd.water_supply_other,NULL) as water_supply_others

-- Water Monthly Cost
	,IFNULL(osd.water_monthly_cost,0) as water_monthly_cost

-- Water Fund Source
	,IFNULL(osd.water_fund_sch,0) as water_fund_mooe
	,IFNULL(osd.water_fund_lgu,0) as water_fund_lgu
	,IFNULL(osd.water_fund_pta,0) as water_fund_pta
	,IFNULL(osd.water_fund_canteen,0) as water_fund_canteen
	,IFNULL(osd.water_fund_private,0) as water_fund_private
	,IFNULL(osd.water_fund_porkbarrel,0) as water_fund_pdaf
	,IFNULL(osd.water_fund_others,NULL) as water_fund_others

-- Electrical Supply Source
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=if(sph.sy_from=2016,3930,sph.co_gen_class) and y.item_type_id=3930 and y.item_id=395)),0) as electric_source_grid 
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=3930 and y.item_type_id=3930 and y.item_id=704)),0) as electric_source_offgrid 
  ,IFNULL(if(sph.sy_from=2016,osd.offgrid_supply_solar,SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class and y.item_type_id=3930 and y.item_id=397))),0) as offgrid_source_solar   
  ,IFNULL(if(sph.sy_from=2016,osd.offgrid_supply_generator,SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class and y.item_type_id=3930 and y.item_id=396))),0) as offgrid_source_generator 
	,IFNULL(osd.offgrid_supply_others,NULL) as offgrid_supply_others
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=if(sph.sy_from=2016,3930,sph.co_gen_class) and y.item_type_id=3930 and y.item_id=398)),0) as no_source_electricity 

-- Electrical Supply Provider
	,IFNULL(osd.grid_supply_meralco,0) as grid_supply_meralco
	,IFNULL(osd.grid_supply_local,0) as grid_supply_localcoop
	,IFNULL(osd.grid_supply_others,NULL) as grid_supply_others

-- Electrical Monthly Cost
	,IFNULL(osd.grid_monthly_cost,0) as grid_monthly_cost 

-- Electrical Fund Source
	,IFNULL(osd.grid_fund_sch,0) as grid_fund_mooe
	,IFNULL(osd.grid_fund_lgu,0) as grid_fund_lgu
	,IFNULL(osd.grid_fund_pta,0) as grid_fund_pta
	,IFNULL(osd.grid_fund_canteen,0) as grid_fund_canteen
	,IFNULL(osd.grid_fund_private,0) as grid_fund_private
	,IFNULL(osd.grid_fund_porkbarrel,0) as grid_fund_pdaf 
	,IFNULL(osd.grid_fund_others,'') as grid_fund_others

FROM ebeisdb.school_profile_history sph
LEFT JOIN ref_region rr on (rr.id = sph.region_id)
LEFT JOIN (ebeisdb.report_history rh 
	      inner join ebeisdb.ref_report_history rrh on rh.ref_report_history_id = rrh.id
	      inner join ebeisdb.ref_reports rrs on rrs.id  = rrh.report_id
	      inner join ebeisdb.ref_report_generics rrg on rrg.id = rrs.ref_report_generics_id and rrg.id=if(rh.sy_from =2016,1,2)
	 ) on rh.school_id = sph.school_id and rh.sy_from= sph.sy_from and rh.report_status > 300 -- cast( sph.sy_from as unsigned)
LEFT JOIN ebeisdb.other_school_data osd on (osd.report_history_id = rh.id)
WHERE sph.take_part_id IN (1,2,3) and sph.general_classification_id = 7 and sph.sy_from =2016 
GROUP BY rh.sy_from, sph.SCHOOL_ID 
ORDER BY sph.SY_FROM, rr.RANK ASC, sph.SCHOOL_ID ASC;

COMMIT;
