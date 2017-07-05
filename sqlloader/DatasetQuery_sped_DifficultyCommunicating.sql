insert into orsdb.sped(
sy_from,
school_id,
g7male_dc,
g7female_dc,
g7total_dc,
g8male_dc,
g8female_dc,
g8total_dc,
g9male_dc,
g9female_dc,
g9total_dc,
g10male_dc,
g10female_dc,
g10total_dc,
g11male_dc,
g11female_dc,
g11total_dc,
g12male_dc,
g12female_dc,
g12total_dc,
ngmale_dc,
ngfemale_dc,
ngtotal_dc,
totmale_dc,
totfemale_dc,
total_dc
)

select sph.sy_from, sph.school_id,

IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 644)),0) as g7male_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 644)),0) as g7female_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 644)),0) as g7total_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 644)),0) as g8male_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 644)),0) as g8female_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 644)),0) as g8total_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 644)),0) as g9male_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 644)),0) as g9female_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 644)),0) as g9total_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 644)),0) as g10male_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 644)),0) as g10female_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 644)),0) as g10total_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 644)),0) as g11male_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 644)),0) as g11female_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 644)),0) as g11total_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 644)),0) as g12male_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 644)),0) as g12female_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 644)),0) as g12total_dc


, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 644)),0) as ngmale_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 644)),0) as ngfemale_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 644)),0) as ngtotal_dc


, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 644)),0) as totmale_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 644)),0) as totfemale_dc
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 644)),0) as total_dc




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
g7male_dc=g7male_dc,
g7female_dc=g7female_dc,
g7total_dc=g7total_dc,
g8male_dc=g8male_dc,
g8female_dc=g8female_dc,
g8total_dc=g8total_dc,
g9male_dc=g9male_dc,
g9female_dc=g9female_dc,
g9total_dc=g9total_dc,
g10male_dc=g10male_dc,
g10female_dc=g10female_dc,
g10total_dc=g10total_dc,
g11male_dc=g11male_dc,
g11female_dc=g11female_dc,
g11total_dc=g11total_dc,
g12male_dc=g12male_dc,
g12female_dc=g12female_dc,
g12total_dc=g12total_dc,
ngmale_dc=ngmale_dc,
ngfemale_dc=ngfemale_dc,
ngtotal_dc=ngtotal_dc,
totmale_dc=totmale_dc,
totfemale_dc=totfemale_dc,
total_dc=total_dc;


Commit;

