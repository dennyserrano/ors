insert into orsdb.sped(
sy_from,
school_id,
g7male_dh,
g7female_dh,
g7total_dh,
g8male_dh,
g8female_dh,
g8total_dh,
g9male_dh,
g9female_dh,
g9total_dh,
g10male_dh,
g10female_dh,
g10total_dh,
g11male_dh,
g11female_dh,
g11total_dh,
g12male_dh,
g12female_dh,
g12total_dh,
ngmale_dh,
ngfemale_dh,
ngtotal_dh,
totmale_dh,
totfemale_dh,
total_dh
)

select sph.sy_from, sph.school_id,

IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 641)),0) as g7male_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 641)),0) as g7female_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 641)),0) as g7total_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 641)),0) as g8male_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 641)),0) as g8female_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 641)),0) as g8total_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 641)),0) as g9male_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 641)),0) as g9female_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 641)),0) as g9total_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 641)),0) as g10male_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 641)),0) as g10female_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 641)),0) as g10total_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 641)),0) as g11male_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 641)),0) as g11female_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 641)),0) as g11total_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 641)),0) as g12male_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 641)),0) as g12female_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 641)),0) as g12total_dh


, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 641)),0) as ngmale_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 641)),0) as ngfemale_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 641)),0) as ngtotal_dh


, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 641)),0) as totmale_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 641)),0) as totfemale_dh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 641)),0) as total_dh




FROM ebeisdb.school_profile_history sph
   LEFT JOIN ebeisdb.ref_region rr on (rr.id = sph.region_id)
   LEFT JOIN (ebeisdb.report_history rh 
	      inner join ebeisdb.ref_report_history rrh on rh.ref_report_history_id = rrh.id
	      inner join ebeisdb.ref_reports rrs on rrs.id  = rrh.report_id
	      inner join ebeisdb.ref_report_generics rrg on rrg.id = rrs.ref_report_generics_id and rrg.id=1
	 ) on rh.school_id = sph.school_id and rh.sy_from= sph.sy_from and rh.report_status > 300 -- cast( sph.sy_from as unsigned)
   LEFT JOIN ebeisdb.other_school_data osd on (osd.report_history_id = rh.id)
   WHERE  sph.take_part_id IN (1,2,3) and sph.sy_from = 2016 and sph.co_gen_class=434
   GROUP BY sph.SCHOOL_ID 
   ORDER BY sph.SY_FROM, rr.RANK ASC, sph.SCHOOL_ID ASC


ON DUPLICATE KEY UPDATE
g7male_dh=g7male_dh,
g7female_dh=g7female_dh,
g7total_dh=g7total_dh,
g8male_dh=g8male_dh,
g8female_dh=g8female_dh,
g8total_dh=g8total_dh,
g9male_dh=g9male_dh,
g9female_dh=g9female_dh,
g9total_dh=g9total_dh,
g10male_dh=g10male_dh,
g10female_dh=g10female_dh,
g10total_dh=g10total_dh,
g11male_dh=g11male_dh,
g11female_dh=g11female_dh,
g11total_dh=g11total_dh,
g12male_dh=g12male_dh,
g12female_dh=g12female_dh,
g12total_dh=g12total_dh,
ngmale_dh=ngmale_dh,
ngfemale_dh=ngfemale_dh,
ngtotal_dh=ngtotal_dh,
totmale_dh=totmale_dh,
totfemale_dh=totfemale_dh,
total_dh=total_dh;


Commit;

