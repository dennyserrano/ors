insert into orsdb.sped(
sy_from,
school_id,
g7male_ds,
g7female_ds,
g7total_ds,
g8male_ds,
g8female_ds,
g8total_ds,
g9male_ds,
g9female_ds,
g9total_ds,
g10male_ds,
g10female_ds,
g10total_ds,
g11male_ds,
g11female_ds,
g11total_ds,
g12male_ds,
g12female_ds,
g12total_ds,
ngmale_ds,
ngfemale_ds,
ngtotal_ds,
totmale_ds,
totfemale_ds,
total_ds
)

select sph.sy_from, sph.school_id,

IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 639)),0) as g7male_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 639)),0) as g7female_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 639)),0) as g7total_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 639)),0) as g8male_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 639)),0) as g8female_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 639)),0) as g8total_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 639)),0) as g9male_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 639)),0) as g9female_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 639)),0) as g9total_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 639)),0) as g10male_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 639)),0) as g10female_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 639)),0) as g10total_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 639)),0) as g11male_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 639)),0) as g11female_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 639)),0) as g11total_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 639)),0) as g12male_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 639)),0) as g12female_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 639)),0) as g12total_ds


, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 639)),0) as ngmale_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 639)),0) as ngfemale_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 639)),0) as ngtotal_ds


, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 639)),0) as totmale_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 639)),0) as totfemale_ds
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 639)),0) as total_ds




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
g7male_ds=g7male_ds,
g7female_ds=g7female_ds,
g7total_ds=g7total_ds,
g8male_ds=g8male_ds,
g8female_ds=g8female_ds,
g8total_ds=g8total_ds,
g9male_ds=g9male_ds,
g9female_ds=g9female_ds,
g9total_ds=g9total_ds,
g10male_ds=g10male_ds,
g10female_ds=g10female_ds,
g10total_ds=g10total_ds,
g11male_ds=g11male_ds,
g11female_ds=g11female_ds,
g11total_ds=g11total_ds,
g12male_ds=g12male_ds,
g12female_ds=g12female_ds,
g12total_ds=g12total_ds,
ngmale_ds=ngmale_ds,
ngfemale_ds=ngfemale_ds,
ngtotal_ds=ngtotal_ds,
totmale_ds=totmale_ds,
totfemale_ds=totfemale_ds,
total_ds=total_ds;


Commit;

