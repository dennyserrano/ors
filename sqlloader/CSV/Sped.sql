select sph.sy_from, sph.school_id

-- Learning Disability
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 79)),0) as gkmale_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 79)),0) as gkfemale_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 79)),0) as gktotal_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 79)),0) as g1male_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 79)),0) as g1female_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 79)),0) as g1total_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 79)),0) as g2male_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 79)),0) as g2female_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 79)),0) as g2total_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 79)),0) as g3male_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 79)),0) as g3female_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 79)),0) as g3total_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 79)),0) as g4male_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 79)),0) as g4female_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 79)),0) as g4total_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 79)),0) as g5male_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 79)),0) as g5female_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 79)),0) as g5total_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 79)),0) as g6male_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 79)),0) as g6female_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 79)),0) as g6total_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 79)),0) as ngmale_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 79)),0) as ngfemale_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 79)),0) as ngtotal_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 79)),0) as nssmale_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 79)),0) as nssfemale_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 79)),0) as nsstotal_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 79)),0) as issmale_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 79)),0) as issfemale_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 79)),0) as isstotal_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 79)),0) as totmale_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 79)),0) as totfemale_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_ld FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 79)),0) as total_ld

-- Hearing Impaired
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 80)),0) as gkmale_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 80)),0) as gkfemale_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 80)),0) as gktotal_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 80)),0) as g1male_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 80)),0) as g1female_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 80)),0) as g1total_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 80)),0) as g2male_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 80)),0) as g2female_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 80)),0) as g2total_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 80)),0) as g3male_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 80)),0) as g3female_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 80)),0) as g3total_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 80)),0) as g4male_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 80)),0) as g4female_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 80)),0) as g4total_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 80)),0) as g5male_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 80)),0) as g5female_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 80)),0) as g5total_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 80)),0) as g6male_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 80)),0) as g6female_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 80)),0) as g6total_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 80)),0) as ngmale_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 80)),0) as ngfemale_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 80)),0) as ngtotal_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 80)),0) as nssmale_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 80)),0) as nssfemale_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 80)),0) as nsstotal_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 80)),0) as issmale_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 80)),0) as issfemale_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 80)),0) as isstotal_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 80)),0) as totmale_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 80)),0) as totfemale_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 80)),0) as total_hi

-- Blindness
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 81)),0) as gkmale_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 81)),0) as gkfemale_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 81)),0) as gktotal_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 81)),0) as g1male_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 81)),0) as g1female_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 81)),0) as g1total_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 81)),0) as g2male_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 81)),0) as g2female_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 81)),0) as g2total_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 81)),0) as g3male_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 81)),0) as g3female_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 81)),0) as g3total_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 81)),0) as g4male_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 81)),0) as g4female_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 81)),0) as g4total_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 81)),0) as g5male_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 81)),0) as g5female_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 81)),0) as g5total_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 81)),0) as g6male_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 81)),0) as g6female_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 81)),0) as g6total_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 81)),0) as ngmale_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 81)),0) as ngfemale_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 81)),0) as ngtotal_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 81)),0) as nssmale_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 81)),0) as nssfemale_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 81)),0) as nsstotal_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 81)),0) as issmale_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 81)),0) as issfemale_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 81)),0) as isstotal_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 81)),0) as totmale_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 81)),0) as totfemale_b
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 81)),0) as total_b

-- Low Vision
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 82)),0) as gkmale_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 82)),0) as gkfemale_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 82)),0) as gktotal_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 82)),0) as g1male_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 82)),0) as g1female_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 82)),0) as g1total_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 82)),0) as g2male_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 82)),0) as g2female_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 82)),0) as g2total_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 82)),0) as g3male_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 82)),0) as g3female_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 82)),0) as g3total_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 82)),0) as g4male_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 82)),0) as g4female_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 82)),0) as g4total_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 82)),0) as g5male_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 82)),0) as g5female_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 82)),0) as g5total_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 82)),0) as g6male_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 82)),0) as g6female_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 82)),0) as g6total_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 82)),0) as ngmale_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 82)),0) as ngfemale_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 82)),0) as ngtotal_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 82)),0) as nssmale_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 82)),0) as nssfemale_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 82)),0) as nsstotal_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 82)),0) as issmale_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 82)),0) as issfemale_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 82)),0) as isstotal_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 82)),0) as totmale_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 82)),0) as totfemale_lv
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 82)),0) as total_lv

-- Intelllectual Disability / Mental Retardation
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 83)),0) as gkmale_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 83)),0) as gkfemale_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 83)),0) as gktotal_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 83)),0) as g1male_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 83)),0) as g1female_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 83)),0) as g1total_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 83)),0) as g2male_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 83)),0) as g2female_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 83)),0) as g2total_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 83)),0) as g3male_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 83)),0) as g3female_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 83)),0) as g3total_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 83)),0) as g4male_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 83)),0) as g4female_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 83)),0) as g4total_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 83)),0) as g5male_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 83)),0) as g5female_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 83)),0) as g5total_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 83)),0) as g6male_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 83)),0) as g6female_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 83)),0) as g6total_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 83)),0) as ngmale_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 83)),0) as ngfemale_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 83)),0) as ngtotal_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 83)),0) as nssmale_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 83)),0) as nssfemale_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 83)),0) as nsstotal_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 83)),0) as issmale_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 83)),0) as issfemale_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 83)),0) as isstotal_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 83)),0) as totmale_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 83)),0) as totfemale_idmr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 83)),0) as total_idmr

-- Multiple Handicap
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 85)),0) as gkmale_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 85)),0) as gkfemale_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 85)),0) as gktotal_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 85)),0) as g1male_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 85)),0) as g1female_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 85)),0) as g1total_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 85)),0) as g2male_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 85)),0) as g2female_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 85)),0) as g2total_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 85)),0) as g3male_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 85)),0) as g3female_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 85)),0) as g3total_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 85)),0) as g4male_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 85)),0) as g4female_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 85)),0) as g4total_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 85)),0) as g5male_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 85)),0) as g5female_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 85)),0) as g5total_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 85)),0) as g6male_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 85)),0) as g6female_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 85)),0) as g6total_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 85)),0) as ngmale_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 85)),0) as ngfemale_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 85)),0) as ngtotal_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 85)),0) as nssmale_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 85)),0) as nssfemale_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 85)),0) as nsstotal_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 85)),0) as issmale_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 85)),0) as issfemale_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 85)),0) as isstotal_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 85)),0) as totmale_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 85)),0) as totfemale_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 85)),0) as total_mh

-- Behavioral Problem
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 86)),0) as gkmale_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 86)),0) as gkfemale_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 86)),0) as gktotal_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 86)),0) as g1male_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 86)),0) as g1female_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 86)),0) as g1total_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 86)),0) as g2male_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 86)),0) as g2female_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 86)),0) as g2total_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 86)),0) as g3male_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 86)),0) as g3female_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 86)),0) as g3total_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 86)),0) as g4male_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 86)),0) as g4female_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 86)),0) as g4total_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 86)),0) as g5male_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 86)),0) as g5female_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 86)),0) as g5total_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 86)),0) as g6male_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 86)),0) as g6female_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 86)),0) as g6total_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 86)),0) as ngmale_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 86)),0) as ngfemale_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 86)),0) as ngtotal_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 86)),0) as nssmale_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 86)),0) as nssfemale_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 86)),0) as nsstotal_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 86)),0) as issmale_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 86)),0) as issfemale_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 86)),0) as isstotal_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 86)),0) as totmale_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 86)),0) as totfemale_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 86)),0) as total_bp

-- Orthopedically Handicapped
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 87)),0) as gkmale_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 87)),0) as gkfemale_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 87)),0) as gktotal_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 87)),0) as g1male_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 87)),0) as g1female_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 87)),0) as g1total_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 87)),0) as g2male_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 87)),0) as g2female_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 87)),0) as g2total_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 87)),0) as g3male_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 87)),0) as g3female_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 87)),0) as g3total_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 87)),0) as g4male_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 87)),0) as g4female_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 87)),0) as g4total_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 87)),0) as g5male_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 87)),0) as g5female_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 87)),0) as g5total_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 87)),0) as g6male_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 87)),0) as g6female_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 87)),0) as g6total_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 87)),0) as ngmale_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 87)),0) as ngfemale_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 87)),0) as ngtotal_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 87)),0) as nssmale_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 87)),0) as nssfemale_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 87)),0) as nsstotal_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 87)),0) as issmale_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 87)),0) as issfemale_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 87)),0) as isstotal_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 87)),0) as totmale_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 87)),0) as totfemale_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 87)),0) as total_oh

-- Autism
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 88)),0) as gkmale_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 88)),0) as gkfemale_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 88)),0) as gktotal_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 88)),0) as g1male_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 88)),0) as g1female_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 88)),0) as g1total_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 88)),0) as g2male_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 88)),0) as g2female_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 88)),0) as g2total_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 88)),0) as g3male_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 88)),0) as g3female_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 88)),0) as g3total_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 88)),0) as g4male_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 88)),0) as g4female_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 88)),0) as g4total_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 88)),0) as g5male_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 88)),0) as g5female_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 88)),0) as g5total_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 88)),0) as g6male_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 88)),0) as g6female_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 88)),0) as g6total_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 88)),0) as ngmale_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 88)),0) as ngfemale_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 88)),0) as ngtotal_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 88)),0) as nssmale_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 88)),0) as nssfemale_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 88)),0) as nsstotal_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 88)),0) as issmale_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 88)),0) as issfemale_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 88)),0) as isstotal_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 88)),0) as totmale_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 88)),0) as totfemale_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 88)),0) as total_au

-- Communication Disorder
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 89)),0) as gkmale_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 89)),0) as gkfemale_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 89)),0) as gktotal_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 89)),0) as g1male_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 89)),0) as g1female_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 89)),0) as g1total_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 89)),0) as g2male_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 89)),0) as g2female_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 89)),0) as g2total_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 89)),0) as g3male_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 89)),0) as g3female_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 89)),0) as g3total_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 89)),0) as g4male_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 89)),0) as g4female_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 89)),0) as g4total_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 89)),0) as g5male_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 89)),0) as g5female_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 89)),0) as g5total_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 89)),0) as g6male_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 89)),0) as g6female_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 89)),0) as g6total_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 89)),0) as ngmale_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 89)),0) as ngfemale_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 89)),0) as ngtotal_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 89)),0) as nssmale_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 89)),0) as nssfemale_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 89)),0) as nsstotal_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 89)),0) as issmale_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 89)),0) as issfemale_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 89)),0) as isstotal_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 89)),0) as totmale_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 89)),0) as totfemale_cd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 89)),0) as total_cd

-- Cerebral Palsy
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 90)),0) as gkmale_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 90)),0) as gkfemale_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 90)),0) as gktotal_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 90)),0) as g1male_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 90)),0) as g1female_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 90)),0) as g1total_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 90)),0) as g2male_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 90)),0) as g2female_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 90)),0) as g2total_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 90)),0) as g3male_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 90)),0) as g3female_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 90)),0) as g3total_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 90)),0) as g4male_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 90)),0) as g4female_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 90)),0) as g4total_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 90)),0) as g5male_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 90)),0) as g5female_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 90)),0) as g5total_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 90)),0) as g6male_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 90)),0) as g6female_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 90)),0) as g6total_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 90)),0) as ngmale_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 90)),0) as ngfemale_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 90)),0) as ngtotal_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 90)),0) as nssmale_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 90)),0) as nssfemale_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 90)),0) as nsstotal_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 90)),0) as issmale_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 90)),0) as issfemale_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 90)),0) as isstotal_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 90)),0) as totmale_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 90)),0) as totfemale_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 90)),0) as total_cp

-- Special Health Problem
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 91)),0) as gkmale_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 91)),0) as gkfemale_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 91)),0) as gktotal_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 91)),0) as g1male_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 91)),0) as g1female_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 91)),0) as g1total_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 91)),0) as g2male_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 91)),0) as g2female_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 91)),0) as g2total_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 91)),0) as g3male_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 91)),0) as g3female_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 91)),0) as g3total_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 91)),0) as g4male_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 91)),0) as g4female_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 91)),0) as g4total_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 91)),0) as g5male_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 91)),0) as g5female_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 91)),0) as g5total_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 91)),0) as g6male_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 91)),0) as g6female_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 91)),0) as g6total_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 91)),0) as ngmale_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 91)),0) as ngfemale_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 91)),0) as ngtotal_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 91)),0) as nssmale_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 91)),0) as nssfemale_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 91)),0) as nsstotal_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 91)),0) as issmale_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 91)),0) as issfemale_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 91)),0) as isstotal_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 91)),0) as totmale_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 91)),0) as totfemale_shp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 91)),0) as total_shp

-- Gifted / Fast Learner
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 78)),0) as gkmale_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 78)),0) as gkfemale_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 405 AND sp.sn_id = 78)),0) as gktotal_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 78)),0) as g1male_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 78)),0) as g1female_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 98 AND sp.sn_id = 78)),0) as g1total_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 78)),0) as g2male_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 78)),0) as g2female_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 99 AND sp.sn_id = 78)),0) as g2total_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 78)),0) as g3male_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 78)),0) as g3female_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 100 AND sp.sn_id = 78)),0) as g3total_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 78)),0) as g4male_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 78)),0) as g4female_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 101 AND sp.sn_id = 78)),0) as g4total_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 78)),0) as g5male_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 78)),0) as g5female_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 102 AND sp.sn_id = 78)),0) as g5total_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 78)),0) as g6male_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 78)),0) as g6female_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 103 AND sp.sn_id = 78)),0) as g6total_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 78)),0) as ngmale_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 78)),0) as ngfemale_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 197 AND sp.sn_id = 78)),0) as ngtotal_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 78)),0) as nssmale_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 78)),0) as nssfemale_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 258 AND sp.sn_id = 78)),0) as nsstotal_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 78)),0) as issmale_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 78)),0) as issfemale_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 259 AND sp.sn_id = 78)),0) as isstotal_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 78)),0) as totmale_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 78)),0) as totfemale_gi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.sn_id = 78)),0) as total_gi

-- Gifted / Fast Learner 2012
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 405 AND sp.sn_id = 78)),0) as gkmale_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 405 AND sp.sn_id = 78)),0) as gkfemale_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 405 AND sp.sn_id = 78)),0) as gktotal_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 98 AND sp.sn_id = 78)),0) as g1male_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 98 AND sp.sn_id = 78)),0) as g1female_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 98 AND sp.sn_id = 78)),0) as g1total_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 99 AND sp.sn_id = 78)),0) as g2male_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 99 AND sp.sn_id = 78)),0) as g2female_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 99 AND sp.sn_id = 78)),0) as g2total_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 100 AND sp.sn_id = 78)),0) as g3male_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 100 AND sp.sn_id = 78)),0) as g3female_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 100 AND sp.sn_id = 78)),0) as g3total_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 101 AND sp.sn_id = 78)),0) as g4male_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 101 AND sp.sn_id = 78)),0) as g4female_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 101 AND sp.sn_id = 78)),0) as g4total_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 102 AND sp.sn_id = 78)),0) as g5male_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 102 AND sp.sn_id = 78)),0) as g5female_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 102 AND sp.sn_id = 78)),0) as g5total_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 103 AND sp.sn_id = 78)),0) as g6male_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 103 AND sp.sn_id = 78)),0) as g6female_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 103 AND sp.sn_id = 78)),0) as g6total_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 78)),0) as g7male_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 78)),0) as g7female_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 78)),0) as g7total_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 78)),0) as g8male_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 78)),0) as g8female_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 78)),0) as g8total_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 78)),0) as g9male_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 78)),0) as g9female_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 78)),0) as g9total_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 78)),0) as g10male_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 78)),0) as g10female_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 78)),0) as g10total_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 78)),0) as g11male_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 78)),0) as g11female_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 78)),0) as g11total_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 78)),0) as g12male_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 78)),0) as g12female_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 78)),0) as g12total_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 78)),0) as ngmale_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 78)),0) as ngfemale_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 78)),0) as ngtotal_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 78)),0) as totmale_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 78)),0) as totfemale_fl
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 78)),0) as total_fl

-- Mentally Retarded
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 575)),0) as g7male_mr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 575)),0) as g7female_mr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 575)),0) as g7total_mr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 575)),0) as g8male_mr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 575)),0) as g8female_mr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 575)),0) as g8total_mr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 575)),0) as g9male_mr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 575)),0) as g9female_mr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 575)),0) as g9total_mr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 575)),0) as g10male_mr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 575)),0) as g10female_mr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 575)),0) as g10total_mr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 575)),0) as g11male_mr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 575)),0) as g11female_mr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 575)),0) as g11total_mr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 575)),0) as g12male_mr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 575)),0) as g12female_mr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 575)),0) as g12total_mr
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 575)),0) as ngmale_mr2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 575)),0) as ngfemale_mr2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 575)),0) as ngtotal_mr2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 575)),0) as totmale_mr2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 575)),0) as totfemale_mr2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 575)),0) as total_mr2

-- Visually Impaired
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 571)),0) as g7male_vi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 571)),0) as g7female_vi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 571)),0) as g7total_vi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 571)),0) as g8male_vi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 571)),0) as g8female_vi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 571)),0) as g8total_vi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 571)),0) as g9male_vi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 571)),0) as g9female_vi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 571)),0) as g9total_vi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 571)),0) as g10male_vi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 571)),0) as g10female_vi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 571)),0) as g10total_vi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 571)),0) as g11male_vi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 571)),0) as g11female_vi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 571)),0) as g11total_vi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 571)),0) as g12male_vi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 571)),0) as g12female_vi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 571)),0) as g12total_vi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 571)),0) as ngmale_vi2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 571)),0) as ngfemale_vi2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 571)),0) as ngtotal_vi2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 571)),0) as totmale_vi2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 571)),0) as totfemale_vi2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 571)),0) as total_vi2

-- Hearing Impaired
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 80)),0) as g7male_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 80)),0) as g7female_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 80)),0) as g7total_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 80)),0) as g8male_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 80)),0) as g8female_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 80)),0) as g8total_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 80)),0) as g9male_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 80)),0) as g9female_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 80)),0) as g9total_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 80)),0) as g10male_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 80)),0) as g10female_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 80)),0) as g10total_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 80)),0) as g11male_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 80)),0) as g11female_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 80)),0) as g11total_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 80)),0) as g12male_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 80)),0) as g12female_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 80)),0) as g12total_hi
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 80)),0) as ngmale_hi2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 80)),0) as ngfemale_hi2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 80)),0) as ngtotal_hi2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 80)),0) as totmale_hi2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 80)),0) as totfemale_hi2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 80)),0) as total_hi2

-- Behavior Problem
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 86)),0) as g7male_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 86)),0) as g7female_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 86)),0) as g7total_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 86)),0) as g8male_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 86)),0) as g8female_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 86)),0) as g8total_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 86)),0) as g9male_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 86)),0) as g9female_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 86)),0) as g9total_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 86)),0) as g10male_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 86)),0) as g10female_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 86)),0) as g10total_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 86)),0) as g11male_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 86)),0) as g11female_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 86)),0) as g11total_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 86)),0) as g12male_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 86)),0) as g12female_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 86)),0) as g12total_bp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 86)),0) as ngmale_bp2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 86)),0) as ngfemale_bp2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 86)),0) as ngtotal_bp2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 86)),0) as totmale_bp2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 86)),0) as totfemale_bp2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 86)),0) as total_bp2

-- Orthopedically Handicapped
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 87)),0) as g7male_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 87)),0) as g7female_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 87)),0) as g7total_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 87)),0) as g8male_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 87)),0) as g8female_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 87)),0) as g8total_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 87)),0) as g9male_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 87)),0) as g9female_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 87)),0) as g9total_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 87)),0) as g10male_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 87)),0) as g10female_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 87)),0) as g10total_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 87)),0) as g11male_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 87)),0) as g11female_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 87)),0) as g11total_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 87)),0) as g12male_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 87)),0) as g12female_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 87)),0) as g12total_oh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 87)),0) as ngmale_oh2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 87)),0) as ngfemale_oh2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 87)),0) as ngtotal_oh2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 87)),0) as totmale_oh2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 87)),0) as totfemale_oh2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 87)),0) as total_oh2

-- Multiple Handicapped
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 85)),0) as g7male_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 85)),0) as g7female_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 85)),0) as g7total_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 85)),0) as g8male_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 85)),0) as g8female_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 85)),0) as g8total_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 85)),0) as g9male_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 85)),0) as g9female_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 85)),0) as g9total_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 85)),0) as g10male_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 85)),0) as g10female_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 85)),0) as g10total_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 85)),0) as g11male_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 85)),0) as g11female_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 85)),0) as g11total_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 85)),0) as g12male_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 85)),0) as g12female_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 85)),0) as g12total_mh
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 85)),0) as ngmale_mh2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 85)),0) as ngfemale_mh2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 85)),0) as ngtotal_mh2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 85)),0) as totmale_mh2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 85)),0) as totfemale_mh2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 85)),0) as total_mh2

-- Speech Defective
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 573)),0) as g7male_sd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 573)),0) as g7female_sd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 573)),0) as g7total_sd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 573)),0) as g8male_sd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 573)),0) as g8female_sd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 573)),0) as g8total_sd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 573)),0) as g9male_sd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 573)),0) as g9female_sd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 573)),0) as g9total_sd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 573)),0) as g10male_sd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 573)),0) as g10female_sd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 573)),0) as g10total_sd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 573)),0) as g11male_sd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 573)),0) as g11female_sd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 573)),0) as g11total_sd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 573)),0) as g12male_sd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 573)),0) as g12female_sd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 573)),0) as g12total_sd
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 573)),0) as ngmale_sd2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 573)),0) as ngfemale_sd2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 573)),0) as ngtotal_sd2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 573)),0) as totmale_sd2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 573)),0) as totfemale_sd2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 573)),0) as total_sd2

-- Learning Disabled
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 576)),0) as g7male_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 576)),0) as g7female_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 576)),0) as g7total_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 576)),0) as g8male_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 576)),0) as g8female_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 576)),0) as g8total_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 576)),0) as g9male_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 576)),0) as g9female_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 576)),0) as g9total_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 576)),0) as g10male_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 576)),0) as g10female_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 576)),0) as g10total_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 576)),0) as g11male_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 576)),0) as g11female_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 576)),0) as g11total_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 576)),0) as g12male_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 576)),0) as g12female_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 576)),0) as g12total_ld
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 576)),0) as ngmale_ld2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 576)),0) as ngfemale_ld2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 576)),0) as ngtotal_ld2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 576)),0) as totmale_ld2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 576)),0) as totfemale_ld2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 576)),0) as total_ld2

-- Autism
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 88)),0) as g7male_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 88)),0) as g7female_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 88)),0) as g7total_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 88)),0) as g8male_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 88)),0) as g8female_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 88)),0) as g8total_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 88)),0) as g9male_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 88)),0) as g9female_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 88)),0) as g9total_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 88)),0) as g10male_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 88)),0) as g10female_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 88)),0) as g10total_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 88)),0) as g11male_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 88)),0) as g11female_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 88)),0) as g11total_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 88)),0) as g12male_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 88)),0) as g12female_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 88)),0) as g12total_au
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 88)),0) as ngmale_au2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 88)),0) as ngfemale_au2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 88)),0) as ngtotal_au2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 88)),0) as totmale_au2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 88)),0) as totfemale_au2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 88)),0) as total_au2

-- Cerebral Palsy
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 90)),0) as g7male_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 90)),0) as g7female_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 90)),0) as g7total_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 90)),0) as g8male_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 90)),0) as g8female_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 90)),0) as g8total_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 90)),0) as g9male_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 90)),0) as g9female_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 90)),0) as g9total_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 90)),0) as g10male_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 90)),0) as g10female_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 90)),0) as g10total_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 90)),0) as g11male_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 90)),0) as g11female_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 90)),0) as g11total_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 90)),0) as g12male_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 90)),0) as g12female_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 90)),0) as g12total_cp
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 90)),0) as ngmale_cp2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 90)),0) as ngfemale_cp2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 90)),0) as ngtotal_cp2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 90)),0) as totmale_cp2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 90)),0) as totfemale_cp2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 90)),0) as total_cp2

-- Special Health Problem/Chronic Illness
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 91)),0) as g7male_ci
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 91)),0) as g7female_ci
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 105 AND sp.sn_id = 91)),0) as g7total_ci
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 91)),0) as g8male_ci
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 91)),0) as g8female_ci
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 106 AND sp.sn_id = 91)),0) as g8total_ci
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 91)),0) as g9male_ci
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 91)),0) as g9female_ci
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 107 AND sp.sn_id = 91)),0) as g9total_ci
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 91)),0) as g10male_ci
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 91)),0) as g10female_ci
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 108 AND sp.sn_id = 91)),0) as g10total_ci
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 91)),0) as g11male_ci
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 91)),0) as g11female_ci
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 497 AND sp.sn_id = 91)),0) as g11total_ci
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 91)),0) as g12male_ci
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 91)),0) as g12female_ci
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 595 AND sp.sn_id = 91)),0) as g12total_ci
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 91)),0) as ngmale_ci2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 91)),0) as ngfemale_ci2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.grade_level_id = 389 AND sp.sn_id = 91)),0) as ngtotal_ci2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 91)),0) as totmale_ci2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 91)),0) as totfemale_ci2
, IFNULL(SUM((SELECT SUM(IFNULL(sp.sn_male,0)+IFNULL(sp.sn_female,0)) AS sum_hi FROM ebeisdb.enrollment_sp_summary sp WHERE sp.report_history_id = rh.id AND sp.category_level_id = 78 AND sp.sn_id = 91)),0) as total_ci2

FROM ebeisdb.school_profile_history sph
   LEFT JOIN ebeisdb.ref_region rr on (rr.id = sph.region_id)
   LEFT JOIN (ebeisdb.report_history rh 
	      inner join ebeisdb.ref_report_history rrh on rh.ref_report_history_id = rrh.id
	      inner join ebeisdb.ref_reports rrs on rrs.id  = rrh.report_id
	      inner join ebeisdb.ref_report_generics rrg on rrg.id = rrs.ref_report_generics_id and rrg.id=1
	 ) on rh.school_id = sph.school_id and rh.sy_from= sph.sy_from and rh.report_status > 300 -- cast( sph.sy_from as unsigned)
   LEFT JOIN ebeisdb.other_school_data osd on (osd.report_history_id = rh.id)
   WHERE  sph.take_part_id IN (1) and sph.sy_from = 2016
   GROUP BY sph.SCHOOL_ID 
   ORDER BY sph.SY_FROM, rr.RANK ASC, sph.SCHOOL_ID ASC

INTO OUTFILE '/var/tmp/sped.csv'
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n';

