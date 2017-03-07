select sph.sy_from, sph.school_id,

-- TOTAL STRUCTURE
(SELECT COUNT(BST.id) FROM ebeisdb.building_structure BS 
	inner join ebeisdb.building_structure_type BST on BS.building_type_id=BST.id
	WHERE BST.category=2 and BS.report_history_id=rh.id
) as total_struct,


-- STRUCTURE PERMANENT 
(SELECT COUNT(BS.id) FROM ebeisdb.building_structure BS 
	inner join ebeisdb.ref_code_setting RCS on BS.building_classification_id=RCS.id
    inner join ebeisdb.building_structure_type BST on BS.building_type_id=BST.id
	WHERE BS.id=1154 and BS.report_history_id=rh.id AND BST.category=2
) as struc_perm,

-- STRUCTURE SEMI-PERMANENT
(
SELECT COUNT(BS.id) FROM ebeisdb.building_structure BS 
	inner join ebeisdb.ref_code_setting RCS on BS.building_classification_id=RCS.id
    inner join ebeisdb.building_structure_type BST on BS.building_type_id=BST.id
	WHERE RCS.id=1155 and BS.report_history_id=rh.id AND BST.category=2
) as struc_semiPerm,

-- STRUCTURE MAKE-SHIFT 
(
SELECT COUNT(BS.id) FROM ebeisdb.building_structure BS 
	inner join ebeisdb.ref_code_setting RCS on BS.building_classification_id=RCS.id
    inner join ebeisdb.building_structure_type BST on BS.building_type_id=BST.id
	WHERE RCS.id=1156 and BS.report_history_id=rh.id AND BST.category=2
) as struc_makeShift,

-- TOTAL BUILDINGS 
(SELECT COUNT(BST.id) FROM ebeisdb.building_structure BS 
	inner join ebeisdb.building_structure_type BST on BS.building_type_id=BST.id
	WHERE BST.category=1 and BS.report_history_id=rh.id
) as total_bldgs,

-- BUILDING PERMANENT
(SELECT COUNT(BS.id) FROM ebeisdb.building_structure BS 
	inner join ebeisdb.ref_code_setting RCS on BS.building_classification_id=RCS.id
    inner join ebeisdb.building_structure_type BST on BS.building_type_id=BST.id
	WHERE RCS.id=1154 and BS.report_history_id=rh.id AND BST.category=1
) as bldg_perm,

-- BUILDING SEMI-PERMANENT 

(
SELECT COUNT(BS.id) FROM ebeisdb.building_structure BS 
	inner join ebeisdb.ref_code_setting RCS on BS.building_classification_id=RCS.id
    inner join ebeisdb.building_structure_type BST on BS.building_type_id=BST.id
	WHERE RCS.id=1155 and BS.report_history_id=rh.id AND BST.category=1
) as bldg_semi_perm,

-- BLDG MAKE-SHIFT 

(
SELECT COUNT(BS.id) FROM ebeisdb.building_structure BS 
	inner join ebeisdb.ref_code_setting RCS on BS.building_classification_id=RCS.id
    inner join ebeisdb.building_structure_type BST on BS.building_type_id=BST.id
	WHERE RCS.id=1156 and BS.report_history_id=rh.id AND BST.category=1
) as bldg_make_shift,

-- TOTAL ROOMS

(SELECT IFNULL(SUM(BS.number_of_rooms),0) FROM ebeisdb.building_structure BS 
	WHERE BS.report_history_id=rh.id 
) as tot_rm,

-- ROOM GOOD CONDITION

(SELECT IFNULL(SUM(BS.number_of_rooms),0) FROM ebeisdb.building_room BR
	inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
    inner join ebeisdb.ref_code_setting RCS on BR.room_condition_id=RCS.id
WHERE RCS.id=767 and BS.report_history_id=rh.id
) as rm_cond_good,

-- MINOR REPAIR

(SELECT  COUNT( BR.room_condition_id) FROM ebeisdb.building_room BR
inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
  --  inner join ebeisdb.ref_code_setting RCS on BR.room_condition_id=RCS.id
WHERE BR.room_condition_id =768 and BS.report_history_id=rh.id 
) as rm_cond_minRep,


-- MAJOR REPAIR

(SELECT IFNULL(SUM(BS.number_of_rooms),0) FROM ebeisdb.building_room BR
	inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
    inner join ebeisdb.ref_code_setting RCS on BR.room_condition_id=RCS.id
WHERE RCS.id=769 and BS.report_history_id=rh.id
) as rm_cond_majRep,

-- ONGOING CONSTRUCTION

(SELECT IFNULL(SUM(BS.number_of_rooms),0) FROM ebeisdb.building_room BR
	inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
    inner join ebeisdb.ref_code_setting RCS on BR.room_condition_id=RCS.id
WHERE RCS.id=1186 and BS.report_history_id=rh.id
) as rm_cond_ongoing_const,

-- FOR COMPLETION

(SELECT IFNULL(SUM(BS.number_of_rooms),0) FROM ebeisdb.building_room BR
	inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
    inner join ebeisdb.ref_code_setting RCS on BR.room_condition_id=RCS.id
WHERE RCS.id=1187 and BS.report_history_id=rh.id
) as rm_cond_forComp,

-- FOR CONDEMNATION

(SELECT IFNULL(SUM(BS.number_of_rooms),0) FROM ebeisdb.building_room BR
	inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
    inner join ebeisdb.ref_code_setting RCS on BR.room_condition_id=RCS.id
WHERE RCS.id=1188 and BS.report_history_id=rh.id
) as rm_cond_forCondemn,

-- CONDEMNED

(SELECT IFNULL(SUM(BS.number_of_rooms),0) FROM ebeisdb.building_room BR
	inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
    inner join ebeisdb.ref_code_setting RCS on BR.room_condition_id=RCS.id
WHERE RCS.id=771 and BS.report_history_id=rh.id
) as rm_cond_condemn,


-- UNDERGONE REPAIR UNDER 5 YRS

(SELECT IFNULL(SUM(BR.repair_last5),0) FROM ebeisdb.building_structure BS 
	inner join ebeisdb.building_room BR on BS.id=BR.building_structure_id
	WHERE BS.report_history_id=rh.id 
) as tot_roomsRepUnder5Yrs,

(SELECT IFNULL(SUM(BWS.toilet_bowl_male),0) FROM ebeisdb.building_structure BS
		 inner join ebeisdb.building_water_sanitation BWS on BS.id=BWS.building_structure_id
         WHERE BS.report_history_id=rh.id) as male,

(SELECT IFNULL(SUM(BWS.toilet_bowl_female),0) FROM ebeisdb.building_structure BS
		 inner join ebeisdb.building_water_sanitation BWS on BS.id=BWS.building_structure_id
         WHERE BS.report_history_id=rh.id) as female,
         
(SELECT IFNULL(SUM(BWS.toilet_bowl_pwd),0) FROM ebeisdb.building_structure BS
		 inner join ebeisdb.building_water_sanitation BWS on BS.id=BWS.building_structure_id
		 WHERE BS.report_history_id=rh.id) as pwd,
        
(SELECT IFNULL(SUM(BWS.toilet_bowl_shared),0) FROM ebeisdb.building_structure BS
 		 inner join ebeisdb.building_water_sanitation BWS on BS.id=BWS.building_structure_id
         WHERE BS.report_history_id=rh.id) as shared,

(SELECT IFNULL(SUM(BWS.non_functional_bowl),0) FROM ebeisdb.building_structure BS
		 inner join ebeisdb.building_water_sanitation BWS on BS.id=BWS.building_structure_id
		 WHERE BS.report_history_id=rh.id
) as non_function_bowls,
         
(SELECT IFNULL(SUM(BWS.number_of_sink),0) FROM ebeisdb.building_structure BS
		inner join ebeisdb.building_water_sanitation BWS on BS.id=BWS.building_structure_id
		WHERE BS.report_history_id=rh.id
) as sink_washbn,

(SELECT IFNULL(SUM(BWS.number_of_urinals),0) FROM ebeisdb.building_structure BS
		inner join ebeisdb.building_water_sanitation BWS on BS.id=BWS.building_structure_id
		WHERE BS.report_history_id=rh.id
) as urinals,

(SELECT IFNULL(SUM(BWS.number_of_trough),0) FROM ebeisdb.building_structure BS
		inner join ebeisdb.building_water_sanitation BWS on BS.id=BWS.building_structure_id
		WHERE BS.report_history_id=rh.id
) as urinal_trough,

(SELECT IFNULL(SUM(BWS.with_septictank),0) FROM ebeisdb.building_structure BS
		inner join ebeisdb.building_water_sanitation BWS on BS.id=BWS.building_structure_id
        WHERE BS.report_history_id=rh.id
) as septic_tank,

(SELECT IFNULL(SUM(BWS.faucet_with_water),0) FROM ebeisdb.building_structure BS
		inner join ebeisdb.building_water_sanitation BWS on BS.id=BWS.building_structure_id
        WHERE BS.report_history_id=rh.id
) as with_faucet,

(SELECT IFNULL(SUM(BWS.faucet_without_water),0) FROM ebeisdb.building_structure BS
		inner join ebeisdb.building_water_sanitation BWS on BS.id=BWS.building_structure_id
        WHERE BS.report_history_id=rh.id
) as without_faucet,

(SELECT IFNULL(SUM(BF.kinder_modular),0) FROM ebeisdb.building_structure BS
		inner join ebeisdb.building_furnitures BF on BS.id=BF.building_structure_id
		WHERE BS.report_history_id=rh.id
) as kinder_mod_table,

(SELECT IFNULL(SUM(BF.kinder_chair),0) FROM ebeisdb.building_structure BS
		inner join ebeisdb.building_furnitures BF on BS.id=BF.building_structure_id
		WHERE BS.report_history_id=rh.id
) as kinder_chair,

(SELECT IFNULL(SUM(BF.arm_chair),0) FROM ebeisdb.building_structure BS
		 inner join ebeisdb.building_furnitures BF on BS.id=BF.building_structure_id
         WHERE BS.report_history_id=rh.id
) as arm_chr,

(SELECT IFNULL(SUM(BF.school_desk),0) FROM ebeisdb.building_structure BS
		 inner join ebeisdb.building_furnitures BF on BS.id=BF.building_structure_id
         WHERE BS.report_history_id=rh.id
) as school_desk,
          
(SELECT IFNULL(SUM(BF.science_laboratory),0) FROM ebeisdb.building_structure BS
		 inner join ebeisdb.building_furnitures BF on BS.id=BF.building_structure_id
		 WHERE BS.report_history_id=rh.id
) as sci_lbtble,
        
(SELECT IFNULL(SUM(BF.science_laboratory_stool),0) FROM ebeisdb.building_structure BS
		inner join ebeisdb.building_furnitures BF on BS.id=BF.building_structure_id
		WHERE BS.report_history_id=rh.id
) as sci_lbstool,

(SELECT IFNULL(SUM(BF.workshop_table),0) FROM ebeisdb.building_structure BS
		inner join ebeisdb.building_furnitures BF on BS.id=BF.building_structure_id
		WHERE BS.report_history_id=rh.id
) as wrkshp_tbl,

(SELECT IFNULL(SUM(BF.monobloc_chair),0) FROM ebeisdb.building_structure BS
		inner join ebeisdb.building_furnitures BF on BS.id=BF.building_structure_id
		WHERE BS.report_history_id=rh.id
) as mono_bloc_chr,

(SELECT IFNULL(SUM(BF.monobloc_stool),0) FROM ebeisdb.building_structure BS
		inner join ebeisdb.building_furnitures BF on BS.id=BF.building_structure_id
		WHERE BS.report_history_id=rh.id
) as mono_bloc_stl,

(SELECT IFNULL(SUM(BF.classroom_table),0) FROM ebeisdb.building_structure BS
		 inner join ebeisdb.building_furnitures BF on BS.id=BF.building_structure_id
         WHERE BS.report_history_id=rh.id
) as clasrm_tbl,

(SELECT IFNULL(SUM(BF.classroom_chair),0) FROM ebeisdb.building_structure BS
		 inner join ebeisdb.building_furnitures BF on BS.id=BF.building_structure_id
         WHERE BS.report_history_id=rh.id
) as clasrm_chr,

(SELECT IFNULL(SUM(BF.behavioral_chair),0) FROM ebeisdb.building_structure BS
		 inner join ebeisdb.building_furnitures BF on BS.id=BF.building_structure_id
		WHERE BS.report_history_id=rh.id
) as behvr_chr,

(SELECT IFNULL(SUM(BF.teacher_table),0) FROM ebeisdb.building_structure BS
		 inner join ebeisdb.building_furnitures BF on BS.id=BF.building_structure_id
         WHERE BS.report_history_id=rh.id
) as teachr_tbl,


(SELECT IFNULL(SUM(BF.teacher_chair),0) FROM ebeisdb.building_structure BS
		 inner join ebeisdb.building_furnitures BF on BS.id=BF.building_structure_id
         WHERE BS.report_history_id=rh.id
) as teachr_chr,

(SELECT SF.quantity FROM ebeisdb.school_facilities SF
		inner join ebeisdb.ref_code_setting RCS on SF.facilities_id=RCS.id
		WHERE SF.report_history_id=rh.id and RCS.id=773
) as conc_quad,


(SELECT COUNT(SF.id) FROM ebeisdb.school_facilities SF
		inner join ebeisdb.ref_code_setting RCS on SF.facilities_id=RCS.id
		WHERE SF.report_history_id=rh.id and RCS.id=776
) as entr_gate,

(SELECT COUNT(SF.id) FROM ebeisdb.school_facilities SF
		inner join ebeisdb.ref_code_setting RCS on SF.facilities_id=RCS.id
		WHERE SF.report_history_id=rh.id and RCS.id=779
) as perim_fence,

(SELECT COUNT(SF.id) FROM ebeisdb.school_facilities SF
		inner join ebeisdb.ref_code_setting RCS on SF.facilities_id=RCS.id
		WHERE SF.report_history_id=rh.id and RCS.id=780
) as playground,

(SELECT COUNT(SF.id) FROM ebeisdb.school_facilities SF
		inner join ebeisdb.ref_code_setting RCS on SF.facilities_id=RCS.id
		WHERE SF.report_history_id=rh.id and RCS.id=781
) as schl_grdn,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=1 and BS.report_history_id=rh.id
) as kinder_class,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=2 and BS.report_history_id=rh.id
) as g1_class,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=3 and BS.report_history_id=rh.id
) as g2_class,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=4 and BS.report_history_id=rh.id
) as g3_class,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=5 and BS.report_history_id=rh.id
) as g4_class,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=6 and BS.report_history_id=rh.id
) as g5_class,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=7 and BS.report_history_id=rh.id
) as g6_class,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=8 and BS.report_history_id=rh.id
) as g7_class,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=9 and BS.report_history_id=rh.id
) as g8_class,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=10 and BS.report_history_id=rh.id
) as g9_class,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=11 and BS.report_history_id=rh.id
) as g10_class,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=12 and BS.report_history_id=rh.id
) as g11_class,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=13 and BS.report_history_id=rh.id
) as g12_class,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=14 and BS.report_history_id=rh.id
) as sped_class,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=15 and BS.report_history_id=rh.id
) as als_rm,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=17 and BS.report_history_id=rh.id
) as comp_room,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=18 and BS.report_history_id=rh.id
) as indus_arts_rm,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=19 and BS.report_history_id=rh.id
) as home_econ_rm,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=20 and BS.report_history_id=rh.id
) as sci_lab,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=22 and BS.report_history_id=rh.id
) as speech_lab,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=21 and BS.report_history_id=rh.id
) as researchLab,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=16 and BS.report_history_id=rh.id
) as inst_aud_visual,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=35 and BS.report_history_id=rh.id and RAU.category=1
) as inst_not_used ,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=24 and BS.report_history_id=rh.id
) as lib_res_cntr,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=25 and BS.report_history_id=rh.id
) as canteen,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=26 and BS.report_history_id=rh.id
) as clinic,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=27 and BS.report_history_id=rh.id
) as conf_room,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=28 and BS.report_history_id=rh.id
) as offices,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=29 and BS.report_history_id=rh.id
) as faclty_rm,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=30 and BS.report_history_id=rh.id
) as museum,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=31 and BS.report_history_id=rh.id
) as supply_rm,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=32 and BS.report_history_id=rh.id
) as datafle_rm,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=33 and BS.report_history_id=rh.id
) as stud_curr_cntr,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=34 and BS.report_history_id=rh.id
) as yout_dev,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=23 and BS.report_history_id=rh.id
) as nonInst_aud_vis,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id=35 and BS.report_history_id=rh.id and RAU.category=1
) as nonInst_notUsed,

(SELECT COUNT(BR.id) FROM ebeisdb.building_room BR
		inner join ebeisdb.building_structure BS on BR.building_structure_id=BS.id
        inner join ebeisdb.building_room_usage BRU on BR.id=BRU.building_room_id
		inner join ebeisdb.ref_actual_usages RAU on RAU.id=BRU.room_usage_id
WHERE RAU.id not in (24,25,	26,	27,	28,	29,	30,	31,	32,	33,	34,	23) and BS.report_history_id=rh.id and RAU.category=2
) as others

from ebeisdb.school_profile_history sph
LEFT JOIN ebeisdb.ref_region rg on (rg.id = sph.region_id)
LEFT JOIN ebeisdb.report_history rh on (rh.school_id = sph.school_id and rh.sy_from = sph.sy_from 
		  and rh.report_id = if(sph.co_gen_class=433, 30,31) and rh.report_status > 300 and sph.general_classification_id = 7)
where sph.sy_from = 2016 and sph.take_part_id in (1,2,3)
GROUP BY sph.sy_from, sph.school_id
ORDER BY sph.sy_from, rg.rank ASC, sph.school_id ASC
LIMIT 5;
