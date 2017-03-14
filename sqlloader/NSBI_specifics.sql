

SELECT 
SPH.school_id as school_id,
IF(BST.category=1,'Building','Structure') as bldg_struct,
BS.building_no as bldg_struct_num,
BST.id as bldg_struct_type_id ,
BS.building_condition_id as bldg_cond_id,
BS.building_classification_id as bldg_class_id,
BS.number_of_storey as storeys,
BSFS.fund_source_id as fund_src_id,
RSFS.id as specific_fund_src_id,
BS.building_length as bldg_dimnsn_len,
BS.building_width as bldg_dimnsn_wdth,
BR.room_id as rm_number,
BR.room_condition_id as class_cond_id,
BR.repair_last5 as repair_5yrs,
BR.room_length as rm_dimnsn_len,
BR.room_width as rm_dimnsn_wdth,
BR.num_concurrent_usage as concurrent_usage,
SUM(IF(RAU.id=1,1,0)) as kinder_class,
SUM(IF(RAU.id=2,1,0)) as g1_class,
SUM(IF(RAU.id=3,1,0)) as g2_class,
SUM(IF(RAU.id=4,1,0)) as g3_class,
SUM(IF(RAU.id=5,1,0)) as g4_class,
SUM(IF(RAU.id=6,1,0)) as g5_class,
SUM(IF(RAU.id=7,1,0)) as g6_class,
SUM(IF(RAU.id=8,1,0)) as g7_class,
SUM(IF(RAU.id=9,1,0)) as g8_class,
SUM(IF(RAU.id=10,1,0)) as g9_class,
SUM(IF(RAU.id=11,1,0)) as g10_class,
SUM(IF(RAU.id=12,1,0)) as g11_class,
SUM(IF(RAU.id=13,1,0)) as g12_class,
SUM(IF(RAU.id=14,1,0)) as sped_class,
SUM(IF(RAU.id=15,1,0)) as als_rm,
SUM(IF(RAU.id=15,1,0)) as comp_rm,
SUM(IF(RAU.id=18,1,0)) as indus_arts_rm,
SUM(IF(RAU.id=19,1,0)) as home_econ_rm,
SUM(IF(RAU.id=20,1,0)) as sci_lab,
SUM(IF(RAU.id=22,1,0)) as speech_lab,
SUM(IF(RAU.id=21,1,0)) as research_lab,
SUM(IF(RAU.id=16,1,0)) as inst_aud_visual,
SUM(IF(RAU.id=35,1,0)) as inst_not_used,
SUM(IF(RAU.id=24,1,0)) as lib_res_cntr,
SUM(IF(RAU.id=25,1,0)) as canteen,
SUM(IF(RAU.id=26,1,0)) as clinic,
SUM(IF(RAU.id=27,1,0)) as conf_room,
SUM(IF(RAU.id=28,1,0)) as offices,
SUM(IF(RAU.id=29,1,0)) as faclty_rm,
SUM(IF(RAU.id=30,1,0)) as museum,
SUM(IF(RAU.id=31,1,0)) as supply_rm,
SUM(IF(RAU.id=32,1,0)) as datafle_rm,
SUM(IF(RAU.id=33,1,0)) as stud_curr_cntr,
SUM(IF(RAU.id=34,1,0)) as youth_dev,
SUM(IF(RAU.id=35,1,0)) as nonInst_aud_vis,
COUNT(RAU.id not in (24,25,	26,	27,	28,	29,	30,	31,	32,	33,	34,	23)) as others

FROM ebeisdb.school_profile_history SPH
INNER JOIN ebeisdb.report_history RH on (RH.school_id = SPH.school_id and RH.sy_from = SPH.sy_from and RH.report_id = if(SPH.co_gen_class=433, 30,31) and RH.report_status > 300 and SPH.general_classification_id = 7) 
INNER JOIN ebeisdb.building_structure BS ON BS.report_history_id=RH.id
INNER JOIN ebeisdb.building_structure_type BST ON BS.building_type_id=BST.id
INNER JOIN ebeisdb.ref_code_setting RCS_building_condition ON BS.building_condition_id=RCS_building_condition.id
-- INNER JOIN ebeisdb.ref_code_setting RCS_classification ON BS.building_classification_id=RCS_classification.id
INNER JOIN ebeisdb.building_structure_fund_source BSFS ON BSFS.building_structure_id=BS.id
-- INNER JOIN ebeisdb.ref_code_setting RCS_bldg_fund_source ON RCS_bldg_fund_source.id=BSFS.fund_source_id
INNER JOIN ebeisdb.building_structure_specific_fund_source BSSFS ON BSSFS.building_structure_id=BS.id
INNER JOIN ebeisdb.ref_specific_fund_source RSFS ON RSFS.id=BSSFS.ref_specific_fund_source_id
INNER JOIN ebeisdb.building_room BR ON BS.id=BR.building_structure_id
-- INNER JOIN ebeisdb.ref_code_setting RCS_class_cond ON RCS_class_cond.id=BR.room_condition_id
INNER JOIN ebeisdb.building_room_usage BRU ON BR.id=BRU.building_room_id 
INNER JOIN ebeisdb.ref_actual_usages RAU ON RAU.id=BRU.room_usage_id

GROUP BY 
school_id,
bldg_struct, 
bldg_struct_num,
bldg_struct_type,
bldg_cond,
bldg_class,
storeys,
fund_source,
specific_fund_src,
bldg_dimension_len,
bldg_dimension_wdth,
rm_number,
class_cond,
repair_5yrs,
rm_dimnsn_length,
rm_dimnsn_width,
concurrent_usage
