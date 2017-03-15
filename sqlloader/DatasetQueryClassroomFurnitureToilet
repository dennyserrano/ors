insert into orsdb.classroom_furniture(school_year,school_id,aca_class,sci_lab,he_room,ia_work,pc_room,pre_schl,sped_class,ins_not_used,total_ins_room,
com_aca_class,com_sci_lab,com_he_room,com_ia_work,com_pc_room,com_pre_schl,com_sped_class,com_ins_not_used,total_com_ins_room,
inc_aca_class,inc_sci_lab,inc_he_room,inc_ia_work,inc_pc_room,inc_pre_schl,inc_sped_class,ins_inc_not_used,total_inc_ins_room,
non_stan_aca_class,non_stan_sci_lab,non_stan_he_room,non_stan_ia_work,non_stan_pc_room,non_stan_pre_schl,non_stan_sped_class,
non_stan_ins_not_used,total_non_stan_ins_room,
std_aca_class,std_sci_lab,std_he_room,std_ia_work,std_pc_room,std_pre_schl,std_sped_class,std_inc_not_used,total_std_ins_room,
tot_aca_class,tot_sci_lab,tot_he_room,tot_ia_work,tot_pc_room,tot_pre_schl,tot_sped_class,tot_ins_not_used,tot_ins_room,
non_inst_lib,non_inst_cli,non_inst_can,non_inst_ofc,non_inst_oth,non_inst_not_used,total_non_inst_room,
com_lib,com_cli,com_can,com_ofc,com_oth,com_non_ins_not_used,total_com_non_ins_room,
inc_lib,inc_cli,inc_can,inc_ofc,inc_oth,inc_non_ins_not_used,total_inc_non_ins_room,
tot_lib,tot_cli,tot_can,tot_ofc,tot_oth,tot_non_ins_not_used,tot_non_ins_room,
ins_depedbudget,ins_depedfunds,ins_lgusef,ins_ft4,ins_congress,ins_frgfund,ins_othgov,ins_privsect,ins_raff4,total_ins_funds,
oth_ins_depedbudget,oth_ins_depedfunds,oth_ins_lgusef,oth_ins_ft4,oth_ins_congress,oth_ins_frgfund,oth_ins_othgov,oth_ins_privsect,
oth_ins_raff4,total_oth_ins_funds,
non_depedbudget,non_depedfunds,non_lgusef,non_ft4,non_congress,non_frgfund,non_othgov,non_privsect,non_raff4,total_non_ins_funds,
tot_depedbudget,tot_depedfunds,tot_lgusef,tot_ft4,tot_congress,tot_frgfund,tot_othgov,tot_privsect,tot_raff4,total_rooms_funds,
ogc_ins_depedbudget,ogc_ins_depedfunds,ogc_ins_lgusef,ogc_ins_ft4,ogc_ins_congress,ogc_ins_frgfund,ogc_ins_othgov,ogc_ins_privsect,
ogc_ins_raff4,total_ogc_ins_funds,ogc_non_depedbudget,
ogc_non_depedfunds,ogc_non_lgusef,ogc_non_ft4,ogc_non_congress,ogc_non_frgfund,ogc_non_othgov,ogc_non_privsect,ogc_non_raff4,
total_ogc_non_ins_funds,
tot_ogc_depedbudget,tot_ogc_depedfunds,tot_ogc_lgusef,tot_ogc_ft4,tot_ogc_congress,tot_ogc_frgfund,tot_ogc_othgov,tot_ogc_privsect,
tot_ogc_raff4,total_ogc_funds,rep_kinder_major,
rep_kinder_minor,total_kinder_rep,rep_major,rep_minor,total_rep,rep_ins_major,rep_ins_minor,total_rep_ins,
rep_non_ins_major,rep_non_ins_minor,total_rep_non_ins,total_need_rep,
buildable_space,storey1,storey2,storey3,storey4,
makshift,condemned,condemnable,
k_desk,k_chair_achair,desk,set_chair_tbl,armchair,chair_achair,
girl_toilet,boy_toilet,toilet_shared,boy_uri_ind,boy_uri_tro,pup_male_toilet,pup_female_toilet,pup_common_toilet,pup_toilet,
per_male_toilet,per_female_toilet,per_common_toilet,per_toilet,total_toilet,
pup_uri_ind,pup_uri_tro,per_uri_ind,per_uri_tro)

select sph.sy_from, sph.school_id

-- Instructional Room 
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=350 AND y.education_level_id=sph.co_gen_class)),0) as aca_class
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=351 AND y.education_level_id=sph.co_gen_class)),0) as sci_lab 
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=352 AND y.education_level_id=sph.co_gen_class)),0) as he_room 
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=353 AND y.education_level_id=sph.co_gen_class)),0) as ia_work 
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=354 AND y.education_level_id=sph.co_gen_class)),0) as pc_room 
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=355 AND y.education_level_id=sph.co_gen_class)),0) as pre_schl
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=356 AND y.education_level_id=sph.co_gen_class)),0) as sped_class
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=357 AND y.education_level_id=sph.co_gen_class)),0) as ins_not_used
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id IN (350,351,352,353,354,355,356,357) AND y.education_level_id=sph.co_gen_class)),0) as total_ins_room

-- Instructional Room 2011 - Complete
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=350 AND y.education_level_id=1290)),0) as com_aca_class
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=351 AND y.education_level_id=1290)),0) as com_sci_lab
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=352 AND y.education_level_id=1290)),0) as com_he_room
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=353 AND y.education_level_id=1290)),0) as com_ia_work
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=354 AND y.education_level_id=1290)),0) as com_pc_room
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=355 AND y.education_level_id=1290)),0) as com_pre_schl
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=356 AND y.education_level_id=1290)),0) as com_sped_class
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=357 AND y.education_level_id=1290)),0) as ins_com_not_used
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id IN (350,351,352,353,354,355,356,357) AND y.education_level_id=1290)),0) as total_com_ins_room

-- Instructional Room 2011 - Incomplete
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=350 AND y.education_level_id=1291)),0) as inc_aca_class
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=351 AND y.education_level_id=1291)),0) as inc_sci_lab
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=352 AND y.education_level_id=1291)),0) as inc_he_room
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=353 AND y.education_level_id=1291)),0) as inc_ia_work
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=354 AND y.education_level_id=1291)),0) as inc_pc_room
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=355 AND y.education_level_id=1291)),0) as inc_pre_schl
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=356 AND y.education_level_id=1291)),0) as inc_sped_class
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=357 AND y.education_level_id=1291)),0) as ins_inc_not_used
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id IN (350,351,352,353,354,355,356,357) AND y.education_level_id=1291)),0) as total_inc_ins_room

-- Instructional Rooms - Non-standard/Makeshift
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=350 AND y.education_level_id=589)),0) as non_stan_aca_class
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=351 AND y.education_level_id=589)),0) as non_stan_sci_lab
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=352 AND y.education_level_id=589)),0) as non_stan_he_room
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=353 AND y.education_level_id=589)),0) as non_stan_ia_work
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=354 AND y.education_level_id=589)),0) as non_stan_pc_room
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=355 AND y.education_level_id=589)),0) as non_stan_pre_schl
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=356 AND y.education_level_id=589)),0) as non_stan_sped_class
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=357 AND y.education_level_id=589)),0) as non_stan_ins_not_used
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id IN (350,351,352,353,354,355,356,357) AND y.education_level_id=589)),0) as total_non_stan_ins_room
    
-- Instructional Room Total Standard
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=350 AND y.education_level_id in (1290,1291))),0) as std_aca_class
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=351 AND y.education_level_id in (1290,1291))),0) as std_sci_lab
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=352 AND y.education_level_id in (1290,1291))),0) as std_he_room
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=353 AND y.education_level_id in (1290,1291))),0) as std_ia_work
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=354 AND y.education_level_id in (1290,1291))),0) as std_pc_room
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=355 AND y.education_level_id in (1290,1291))),0) as std_pre_schl
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=356 AND y.education_level_id in (1290,1291))),0) as std_sped_class
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=357 AND y.education_level_id in (1290,1291))),0) as std_inc_not_used
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id IN (350,351,352,353,354,355,356,357) AND y.education_level_id in (1290,1291))),0) as total_std_ins_room

-- Total Instructional Room
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=350)),0) as tot_aca_class
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=351)),0) as tot_sci_lab
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=352)),0) as tot_he_room
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=353)),0) as tot_ia_work
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=354)),0) as tot_pc_room
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=355)),0) as tot_pre_schl
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=356)),0) as tot_sped_class
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=357)),0) as tot_ins_not_used
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id IN (350,351,352,353,354,355,356,357))),0) as tot_ins_room

-- Non-instructional Room
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=358 AND y.education_level_id=sph.co_gen_class)),0) as non_inst_lib
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=359 AND y.education_level_id=sph.co_gen_class)),0) as non_inst_cli
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=360 AND y.education_level_id=sph.co_gen_class)),0) as non_inst_can
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=361 AND y.education_level_id=sph.co_gen_class)),0) as non_inst_ofc
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=362 AND y.education_level_id=sph.co_gen_class)),0) as non_inst_oth
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=363 AND y.education_level_id=sph.co_gen_class)),0) as non_inst_not_used
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id IN (358,359,360,361,362,363) AND y.education_level_id=sph.co_gen_class)),0) as total_non_inst_room

-- Non-instructional Room - Complete
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=358 AND y.education_level_id=1290)),0) as com_lib
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=359 AND y.education_level_id=1290)),0) as com_cli
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=360 AND y.education_level_id=1290)),0) as com_can
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=361 AND y.education_level_id=1290)),0) as com_ofc
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=362 AND y.education_level_id=1290)),0) as com_oth
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=363 AND y.education_level_id=1290)),0) as com_non_ins_not_used
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id IN (358,359,360,361,362,363) AND y.education_level_id=1290)),0) as total_com_non_ins_room

-- Non-instructional Room - Incomplete
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=358 AND y.education_level_id=1291)),0) as inc_lib
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=359 AND y.education_level_id=1291)),0) as inc_cli
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=360 AND y.education_level_id=1291)),0) as inc_can
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=361 AND y.education_level_id=1291)),0) as inc_ofc
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=362 AND y.education_level_id=1291)),0) as inc_oth
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=363 AND y.education_level_id=1291)),0) as inc_non_ins_not_used
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id IN (358,359,360,361,362,363) AND y.education_level_id=1291)),0) as total_inc_non_ins_room

-- Total Non-instructional Room
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=358)),0) as tot_lib
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=359)),0) as tot_cli
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=360)),0) as tot_can
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=361)),0) as tot_ofc
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=362)),0) as tot_oth
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=363)),0) as tot_non_ins_not_used
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id IN (358,359,360,361,362,363))),0) as tot_non_ins_room

-- Rooms By Fund Source - Instructional Rooms 
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=338 and yf.fund_source_id=825)),0) as ins_depedbudget
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=338 and yf.fund_source_id=830)),0) as ins_depedfunds
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=338 and yf.fund_source_id=835)),0) as ins_lgusef
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=338 and yf.fund_source_id=840)),0) as ins_ft4
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=338 and yf.fund_source_id=845)),0) as ins_congress
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=338 and yf.fund_source_id=850)),0) as ins_frgfund
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=338 and yf.fund_source_id=853)),0) as ins_othgov
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=338 and yf.fund_source_id=855)),0) as ins_privsect
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=338 and yf.fund_source_id=860)),0) as ins_raff4
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=338)),0) as total_ins_funds

-- Rooms By Fund Source - Other Instructional Rooms
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=340 and yf.fund_source_id=825)),0) as oth_ins_depedbudget
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=340 and yf.fund_source_id=830)),0) as oth_ins_depedfunds
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=340 and yf.fund_source_id=835)),0) as oth_ins_lgusef
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=340 and yf.fund_source_id=840)),0) as oth_ins_ft4
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=340 and yf.fund_source_id=845)),0) as oth_ins_congress
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=340 and yf.fund_source_id=850)),0) as oth_ins_frgfund
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=340 and yf.fund_source_id=853)),0) as oth_ins_othgov
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=340 and yf.fund_source_id=855)),0) as oth_ins_privsect
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=340 and yf.fund_source_id=860)),0) as oth_ins_raff4
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=340)),0) as total_oth_ins_funds

-- Rooms By Fund Source - Non-instructional Rooms
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=339 and yf.fund_source_id=825)),0) as non_depedbudget
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=339 and yf.fund_source_id=830)),0) as non_depedfunds
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=339 and yf.fund_source_id=835)),0) as non_lgusef
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=339 and yf.fund_source_id=840)),0) as non_ft4
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=339 and yf.fund_source_id=845)),0) as non_congress
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=339 and yf.fund_source_id=850)),0) as non_frgfund
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=339 and yf.fund_source_id=853)),0) as non_othgov
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=339 and yf.fund_source_id=855)),0) as non_privsect
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=339 and yf.fund_source_id=860)),0) as non_raff4
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=339)),0) as total_non_ins_funds

-- Rooms By Fund Source - Total
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (338,340,339) and yf.fund_source_id=825)),0) as tot_depedbudget
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (338,340,339) and yf.fund_source_id=830)),0) as tot_depedfunds
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (338,340,339) and yf.fund_source_id=835)),0) as tot_lgusef
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (338,340,339) and yf.fund_source_id=840)),0) as tot_ft4
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (338,340,339) and yf.fund_source_id=845)),0) as tot_congress
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (338,340,339) and yf.fund_source_id=850)),0) as tot_frgfund
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (338,340,339) and yf.fund_source_id=853)),0) as tot_othgov
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (338,340,339) and yf.fund_source_id=855)),0) as tot_privsect
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (338,340,339) and yf.fund_source_id=860)),0) as tot_raff4
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (338,339,340))),0) as total_rooms_funds

-- On-going Construction By Fund Source - Instructional
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1295 and yf.fund_source_id=825)),0) as ogc_ins_depedbudget
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1295 and yf.fund_source_id=830)),0) as ogc_ins_depedfunds
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1295 and yf.fund_source_id=835)),0) as ogc_ins_lgusef
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1295 and yf.fund_source_id=840)),0) as ogc_ins_ft4
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1295 and yf.fund_source_id=845)),0) as ogc_ins_congress
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1295 and yf.fund_source_id=850)),0) as ogc_ins_frgfund
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1295 and yf.fund_source_id=853)),0) as ogc_ins_othgov
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1295 and yf.fund_source_id=855)),0) as ogc_ins_privsect
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1295 and yf.fund_source_id=860)),0) as ogc_ins_raff4
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1295)),0) as total_ogc_ins_funds

-- On-going Construction By Fund Source - Non-Instructional
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1296 and yf.fund_source_id=825)),0) as ogc_non_depedbudget
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1296 and yf.fund_source_id=830)),0) as ogc_non_depedfunds
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1296 and yf.fund_source_id=835)),0) as ogc_non_lgusef
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1296 and yf.fund_source_id=840)),0) as ogc_non_ft4
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1296 and yf.fund_source_id=845)),0) as ogc_non_congress
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1296 and yf.fund_source_id=850)),0) as ogc_non_frgfund
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1296 and yf.fund_source_id=853)),0) as ogc_non_othgov
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1296 and yf.fund_source_id=855)),0) as ogc_non_privsect
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1296 and yf.fund_source_id=860)),0) as ogc_non_raff4
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id=1296)),0) as total_ogc_non_ins_funds

-- On-going Construction By Fund Source - Total
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (1295,1296) and yf.fund_source_id=825)),0) as tot_ogc_depedbudget
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (1295,1296) and yf.fund_source_id=830)),0) as tot_ogc_depedfunds
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (1295,1296) and yf.fund_source_id=835)),0) as tot_ogc_lgusef
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (1295,1296) and yf.fund_source_id=840)),0) as tot_ogc_ft4
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (1295,1296) and yf.fund_source_id=845)),0) as tot_ogc_congress
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (1295,1296) and yf.fund_source_id=850)),0) as tot_ogc_frgfund
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (1295,1296) and yf.fund_source_id=853)),0) as tot_ogc_othgov
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (1295,1296) and yf.fund_source_id=855)),0) as tot_ogc_privsect
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (1295,1296) and yf.fund_source_id=860)),0) as tot_ogc_raff4
  ,IFNULL(SUM((SELECT SUM(IFNULL(yf.qty,0)) FROM ebeisdb.inventory_fund_source yf WHERE yf.report_history_id=rh.id AND yf.type_of_usage_id in (1296,1295))),0) as total_ogc_funds

-- Instructional Rooms Needing Repair
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=435 and y.item_id=491)),0) as rep_kinder_major
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=435 and y.item_id=490)),0) as rep_kinder_minor
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=435 and y.item_id in (490,491))),0) as total_kinder_rep
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class and y.item_id=491)),0) as rep_major
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class and y.item_id=490)),0) as rep_minor
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class and y.item_id in (490,491))),0) as total_rep

-- Rooms Needing Repair
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=1295 and y.item_id=491)),0) as rep_ins_major
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=1295 and y.item_id=490)),0) as rep_ins_minor
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=1295 and y.item_id in (490,491))),0) as total_rep_ins
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=1296 and y.item_id=491)),0) as rep_non_ins_major
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=1296 and y.item_id=490)),0) as rep_non_ins_minor
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=1296 and y.item_id in (490,491))),0) as total_rep_non_ins
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id in (1295,1296) AND y.item_id in (490,491))),0) as total_need_rep

-- Buildable Space
  ,IFNULL(SUM((SELECT SUM(IFNULL(o.buildable_space,0)) FROM ebeisdb.other_school_data o WHERE o.report_history_id=rh.id)),0) as buildable_space  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=1331)),0) as storey1
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=1332)),0) as storey2
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=1333)),0) as storey3
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=1334)),0) as storey4

-- Condemned/Condemnable
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=1300)),0) as makshift
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=1301)),0) as condemned
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.item_id=1302)),0) as condemnable

-- Furniture
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=435 AND y.item_id=370)),0) as k_desk
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=435 AND y.item_id=930)),0) as k_chair_achair
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class AND y.item_id=370)),0) as desk
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class AND y.item_id=371)),0) as set_chair_tbl
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class AND y.item_id=372)),0) as armchair
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class AND y.item_id=930)),0) as chair_achair
  
-- Toilet
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class AND y.item_id=380)),0) as girl_toilet
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class AND y.item_id=383)),0) as boy_toilet
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class AND y.item_id=384)),0) as toilet_shared
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class AND y.item_id=381)),0) as boy_uri_ind
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=sph.co_gen_class AND y.item_id=382)),0) as boy_uri_tro
  
-- Toilet 2011  
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=1305 AND y.item_id=383)),0) as pup_male_toilet
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=1305 AND y.item_id=380)),0) as pup_female_toilet
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=1305 AND y.item_id=384)),0) as pup_common_toilet
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=1305 AND y.item_id in (383,380,384))),0) as pup_toilet
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=1306 AND y.item_id=383)),0) as per_male_toilet
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=1306 AND y.item_id=380)),0) as per_female_toilet
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=1306 AND y.item_id=384)),0) as per_common_toilet
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=1306 AND y.item_id in (383,380,384))),0) as per_toilet
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id in (1305,1306) AND y.item_id in (383,380,384))),0) as total_toilet

-- Urinal 2011
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=1305 AND y.item_id=381)),0) as pup_uri_ind
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=1305 AND y.item_id=382)),0) as pup_uri_tro
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=1306 AND y.item_id=381)),0) as per_uri_ind
  ,IFNULL(SUM((SELECT SUM(IFNULL(y.quantity,0)) FROM ebeisdb.inventory_summary y WHERE y.report_history_id=rh.id AND y.education_level_id=1306 AND y.item_id=382)),0) as per_uri_tro

FROM ebeisdb.school_profile_history sph
INNER JOIN ebeisdb.ref_reports reports on (reports.co_genclass_id=sph.co_gen_class 
 and reports.general_classification_id=sph.general_classification_id and reports.ref_report_generics_id=if(sph.sy_from=2016,1,2))
INNER JOIN ebeisdb.ref_report_history rrh on (reports.id=rrh.report_id and rrh.sy_from=CAST(sph.sy_from AS CHAR))
LEFT JOIN ebeisdb.report_history rh on (rh.ref_report_history_id=rrh.id and rh.school_id=sph.school_id 
 and rh.report_status IN (301,302))
WHERE sph.general_classification_id=7 and sph.take_part_id in (1,2,3)
 GROUP BY sph.sy_from, sph.school_id
 ORDER BY sph.sy_from, sph.school_id;

commit;

