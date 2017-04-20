INSERT INTO orsdb.nsbi_specifics(
sy_from,
school_id,
bldg_struct,
bldg_struct_num,
bldg_struct_type_id,
bldg_cond_id,
bldg_class_id,
storeys,
fund_src_id,
fund_src,
specific_fund_src_id,
specific_fund_src,
bldg_dimnsn_len,
bldg_dimnsn_wdth,
rm_number,
class_cond_id,
repair_5yrs,
rm_dimnsn_len,
rm_dimnsn_wdth,
concurrent_usage,
kinder_class,
g1_class,
g2_class,
g3_class,
g4_class,
g5_class,
g6_class,
g7_class,
g8_class,
g9_class,
g10_class,
g11_class,
g12_class,
sped_class,
als_rm,
comp_rm,
indus_arts_rm,
home_econ_rm,
sci_lab,
speech_lab,
research_lab,
inst_aud_visual,
inst_not_used,
lib_res_cntr,
canteen,
clinic,
conf_room,
offices,
faclty_rm,
museum,
supply_rm,
datafle_rm,
stud_curr_cntr,
youth_dev,
nonInst_aud_vis,
nonInst_notUsed,
others,
purely_instructional,
purely_non_instructional,
shared_instructional
)

SELECT 
SPH.sy_from,
SPH.school_id as school_id,
IF(BST.category=1,'Building','Structure') as bldg_struct,
BS.building_no as bldg_struct_num,
BST.id as bldg_struct_type_id ,
BS.building_condition_id as bldg_cond_id,
BS.building_classification_id as bldg_class_id,
BS.number_of_storey as storeys,
0 as fund_src_id, -- temporarily not included
(
	SELECT group_concat(B.description separator ',')
    FROM ebeisdb.building_structure_fund_source A
    INNER JOIN ebeisdb.ref_code_setting B ON B.id=A.fund_source_id
	WHERE A.building_structure_id=BS.id
) as fund_src, -- temporarily included
0 as specific_fund_src_id, -- temporarily not included,
(
	SELECT group_concat(B.description separator ',')
    FROM ebeisdb.building_structure_specific_fund_source A
    INNER JOIN ebeisdb.ref_specific_fund_source B ON B.id=A.ref_specific_fund_source_id
	WHERE A.building_structure_id=BS.id
) as specific_fund_src,
BS.building_length as bldg_dimnsn_len,
BS.building_width as bldg_dimnsn_wdth,
BR.room_id as rm_number,
BR.room_condition_id as class_cond_id,
BR.repair_last5 as repair_5yrs,
BR.room_length as rm_dimnsn_len,
BR.room_width as rm_dimnsn_wdth,
BR.num_concurrent_usage as concurrent_usage,
(
	SELECT SUM(IF(B.id=1,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as kinder_class,
(
	SELECT SUM(IF(B.id=2,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as g1_class,
(
	SELECT SUM(IF(B.id=3,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as g2_class,
(
	SELECT SUM(IF(B.id=4,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as g3_class,
(
	SELECT SUM(IF(B.id=5,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as g4_class,
(
	SELECT SUM(IF(B.id=6,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as g5_class,
(
	SELECT SUM(IF(B.id=7,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as g6_class,
(
	SELECT SUM(IF(B.id=8,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as g7_class,
(
	SELECT SUM(IF(B.id=9,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as g8_class,
(
	SELECT SUM(IF(B.id=10,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as g9_class,
(
	SELECT SUM(IF(B.id=11,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as g10_class,
(
	SELECT SUM(IF(B.id=12,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as g11_class,
(
	SELECT SUM(IF(B.id=13,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as g12_class,
(
	SELECT SUM(IF(B.id=14,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as sped_class,
(
	SELECT SUM(IF(B.id=15,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as als_rm,
(
	SELECT SUM(IF(B.id=17,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as comp_rm,
(
	SELECT SUM(IF(B.id=18,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as indus_arts_rm,
(
	SELECT SUM(IF(B.id=19,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as home_econ_rm,
(
	SELECT SUM(IF(B.id=20,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as sci_lab,
(
	SELECT SUM(IF(B.id=22,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as speech_lab,
(
	SELECT SUM(IF(B.id=21,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as research_lab,
(
	SELECT SUM(IF(B.id=16,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as inst_aud_visual,
(
	SELECT SUM(IF(B.id=35,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as inst_not_used,
(
	SELECT SUM(IF(B.id=24,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as lib_res_cntr,
(
	SELECT SUM(IF(B.id=25,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as canteen,
(
	SELECT SUM(IF(B.id=26,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as clinic,
(
	SELECT SUM(IF(B.id=27,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as conf_room,
(
	SELECT SUM(IF(B.id=28,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as offices,
(
	SELECT SUM(IF(B.id=29,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as faclty_rm,
(
	SELECT SUM(IF(B.id=30,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as museum,
(
	SELECT SUM(IF(B.id=31,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as supply_rm,
(
	SELECT SUM(IF(B.id=32,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as datafle_rm,
(
	SELECT SUM(IF(B.id=33,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as stud_curr_cntr,
(
	SELECT SUM(IF(B.id=34,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as youth_dev,
(
	SELECT SUM(IF(B.id=23,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as nonInst_notUsed,
(
	SELECT SUM(IF(B.id=35,1,0))
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
) as nonInst_aud_vis,
(
	SELECT group_concat(B.description separator ',')
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE A.building_room_id=BR.id
    AND B.id not in (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25, 26,
	27, 28,
	29, 30,
	31, 32,
	33, 34,
	35)
) as others,
(
	SELECT IF(COUNT(*)=1,1,0)
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE 
    A.building_room_id=BR.id
    AND B.category=1 
    AND 
    (
			SELECT 
			(
				IF
				(
					(
						SELECT COUNT(*)
						FROM ebeisdb.building_room_usage A1
						INNER JOIN ebeisdb.ref_actual_usages B1 ON A1.room_usage_id=B1.id
						WHERE 
						A1.building_room_id=BR.id
						AND B1.category=2
					)>0,1,0
				)
				+
				IF
				(
					(
						SELECT COUNT(*)
						FROM ebeisdb.building_room_usage A1 
						INNER JOIN ebeisdb.ref_actual_usages B1 ON A1.room_usage_id=B1.id
						WHERE 
						A1.building_room_id=BR.id
						AND B1.category=1
					)>0,1,0
				)
			) as a
    ) <> 2
    
) as purely_instructional,
(
	SELECT IF(COUNT(B.category)>0,1,0)
    FROM ebeisdb.building_room_usage A 
    INNER JOIN ebeisdb.ref_actual_usages B ON A.room_usage_id=B.id
    WHERE 
    A.building_room_id=BR.id
    AND B.category=2
    AND 
    (
			SELECT 
			(
				IF
				(
					(
						SELECT COUNT(B1.category)
						FROM ebeisdb.building_room_usage A1 
						INNER JOIN ebeisdb.ref_actual_usages B1 ON A1.room_usage_id=B1.id
						WHERE 
						A1.building_room_id=BR.id
						AND B1.category=2
					)>0,1,0
				)
				+
				IF
				(
					(
						SELECT COUNT(B1.category)
						FROM ebeisdb.building_room_usage A1 
						INNER JOIN ebeisdb.ref_actual_usages B1 ON A1.room_usage_id=B1.id
						WHERE 
						A1.building_room_id=BR.id
						AND B1.category=1
					)>0,1,0
				)
			) as a
    ) <> 2

) as purely_non_instructional,
(
		SELECT 
		(
				
				IF
                (
					(	
							IF
							(
								(
									SELECT COUNT(B1.category)
									FROM ebeisdb.building_room_usage A1 
									INNER JOIN ebeisdb.ref_actual_usages B1 ON A1.room_usage_id=B1.id
									WHERE 
									A1.building_room_id=BR.id
									AND B1.category=2
								)>0,1,0
							)
							+
							IF
							(
							
								(
									SELECT COUNT(B1.category)
									FROM ebeisdb.building_room_usage A1 
									INNER JOIN ebeisdb.ref_actual_usages B1 ON A1.room_usage_id=B1.id
									WHERE 
									A1.building_room_id=BR.id
									AND B1.category=1
								)>0,1,0
							)
					)=2,1,0
				)
                
		) as a
 
  
) as shared_instructional

FROM ebeisdb.school_profile_history SPH
INNER JOIN ebeisdb.report_history RH on (RH.school_id = SPH.school_id and RH.sy_from = SPH.sy_from and RH.report_id = if(SPH.co_gen_class=433, 30,31) and RH.report_status >= 300 and SPH.general_classification_id = 7) 
INNER JOIN ebeisdb.building_structure BS ON BS.report_history_id=RH.id
INNER JOIN ebeisdb.building_structure_type BST ON BS.building_type_id=BST.id
LEFT JOIN ebeisdb.building_room BR ON BS.id=BR.building_structure_id


WHERE SPH.sy_from = 2016 
AND SPH.school_subclassification_id IN (11,13,14)
AND SPH.general_classification_id = 7


order by school_id, bldg_struct_num, rm_number
;
