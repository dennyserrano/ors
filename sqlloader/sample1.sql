SELECT sph.sy_from, sph.school_id
-- Age 4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 225))),0) as gkmaleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 225))),0) as gkfemaleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 225))),0) as gktotAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 225))),0) as g1ecdmaleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 225))),0) as g1ecdfemaleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 225))),0) as g1ecdtotAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 225))),0) as g1maleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 225))),0) as g1femaleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 225))),0) as g1totAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 225))),0) as g2maleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 225))),0) as g2femaleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 225))),0) as g2totAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 225))),0) as g3maleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 225))),0) as g3femaleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 225))),0) as g3totAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 225))),0) as g4maleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 225))),0) as g4femaleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 225))),0) as g4totAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 225))),0) as g5maleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 225))),0) as g5femaleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 225))),0) as g5totAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 225))),0) as g6maleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 225))),0) as g6femaleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 225))),0) as g6totAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 225))),0) as gp7maleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 225))),0) as gp7femaleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 225))),0) as gp7totAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 225))),0) as gtotmaleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 225))),0) as gtotfemaleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 225))),0) as gtotAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 225))),0) as ngmaleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 225))),0) as ngfemaleAge4
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 225))),0) as ngtotAge4

-- Age 4 1/2
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 592))),0) as gkmaleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 592))),0) as gkfemaleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 592))),0) as gktotAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 592))),0) as g1ecdmaleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 592))),0) as g1ecdfemaleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 592))),0) as g1ecdtotAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 592))),0) as g1maleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 592))),0) as g1femaleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 592))),0) as g1totAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 592))),0) as g2maleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 592))),0) as g2femaleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 592))),0) as g2totAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 592))),0) as g3maleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 592))),0) as g3femaleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 592))),0) as g3totAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 592))),0) as g4maleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 592))),0) as g4femaleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 592))),0) as g4totAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 592))),0) as g5maleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 592))),0) as g5femaleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 592))),0) as g5totAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 592))),0) as g6maleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 592))),0) as g6femaleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 592))),0) as g6totAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 592))),0) as gp7maleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 592))),0) as gp7femaleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 592))),0) as gp7totAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 592))),0) as gtotmaleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 592))),0) as gtotfemaleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 592))),0) as gtotAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 592))),0) as ngmaleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 592))),0) as ngfemaleAge4_5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 592))),0) as ngtotAge4_5

-- Age 5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 226))),0) as gkmaleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 226))),0) as gkfemaleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 226))),0) as gktotAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 226))),0) as g1ecdmaleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 226))),0) as g1ecdfemaleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 226))),0) as g1ecdtotAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 226))),0) as g1maleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 226))),0) as g1femaleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 226))),0) as g1totAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 226))),0) as g2maleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 226))),0) as g2femaleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 226))),0) as g2totAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 226))),0) as g3maleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 226))),0) as g3femaleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 226))),0) as g3totAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 226))),0) as g4maleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 226))),0) as g4femaleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 226))),0) as g4totAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 226))),0) as g5maleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 226))),0) as g5femaleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 226))),0) as g5totAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 226))),0) as g6maleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 226))),0) as g6femaleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 226))),0) as g6totAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 226))),0) as gp7maleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 226))),0) as gp7femaleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 226))),0) as gp7totAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 226))),0) as gtotmaleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 226))),0) as gtotfemaleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 226))),0) as gtotAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 226))),0) as ngmaleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 226))),0) as ngfemaleAge5
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 226))),0) as ngtotAge5

-- Age 6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 227))),0) as gkmaleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 227))),0) as gkfemaleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 227))),0) as gktotAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 227))),0) as g1ecdmaleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 227))),0) as g1ecdfemaleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 227))),0) as g1ecdtotAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 227))),0) as g1maleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 227))),0) as g1femaleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 227))),0) as g1totAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 227))),0) as g2maleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 227))),0) as g2femaleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 227))),0) as g2totAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 227))),0) as g3maleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 227))),0) as g3femaleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 227))),0) as g3totAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 227))),0) as g4maleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 227))),0) as g4femaleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 227))),0) as g4totAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 227))),0) as g5maleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 227))),0) as g5femaleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 227))),0) as g5totAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 227))),0) as g6maleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 227))),0) as g6femaleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 227))),0) as g6totAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 227))),0) as gp7maleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 227))),0) as gp7femaleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 227))),0) as gp7totAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 227))),0) as gtotmaleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 227))),0) as gtotfemaleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 227))),0) as gtotAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 227))),0) as ngmaleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 227))),0) as ngfemaleAge6
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 227))),0) as ngtotAge6

-- Age 7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 228))),0) as gkmaleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 228))),0) as gkfemaleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 228))),0) as gktotAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 228))),0) as g1ecdmaleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 228))),0) as g1ecdfemaleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 228))),0) as g1ecdtotAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 228))),0) as g1maleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 228))),0) as g1femaleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 228))),0) as g1totAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 228))),0) as g2maleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 228))),0) as g2femaleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 228))),0) as g2totAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 228))),0) as g3maleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 228))),0) as g3femaleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 228))),0) as g3totAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 228))),0) as g4maleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 228))),0) as g4femaleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 228))),0) as g4totAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 228))),0) as g5maleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 228))),0) as g5femaleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 228))),0) as g5totAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 228))),0) as g6maleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 228))),0) as g6femaleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 228))),0) as g6totAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 228))),0) as gp7maleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 228))),0) as gp7femaleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 228))),0) as gp7totAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 228))),0) as gtotmaleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 228))),0) as gtotfemaleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 228))),0) as gtotAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 228))),0) as ngmaleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 228))),0) as ngfemaleAge7
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 228))),0) as ngtotAge7

-- Age 8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 229))),0) as gkmaleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 229))),0) as gkfemaleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 229))),0) as gktotAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 229))),0) as g1ecdmaleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 229))),0) as g1ecdfemaleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 229))),0) as g1ecdtotAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 229))),0) as g1maleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 229))),0) as g1femaleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 229))),0) as g1totAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 229))),0) as g2maleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 229))),0) as g2femaleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 229))),0) as g2totAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 229))),0) as g3maleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 229))),0) as g3femaleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 229))),0) as g3totAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 229))),0) as g4maleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 229))),0) as g4femaleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 229))),0) as g4totAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 229))),0) as g5maleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 229))),0) as g5femaleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 229))),0) as g5totAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 229))),0) as g6maleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 229))),0) as g6femaleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 229))),0) as g6totAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 229))),0) as gp7maleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 229))),0) as gp7femaleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 229))),0) as gp7totAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 229))),0) as gtotmaleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 229))),0) as gtotfemaleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 229))),0) as gtotAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 229))),0) as ngmaleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 229))),0) as ngfemaleAge8
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 229))),0) as ngtotAge8

-- Age 9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 230))),0) as gkmaleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 230))),0) as gkfemaleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 230))),0) as gktotAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 230))),0) as g1ecdmaleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 230))),0) as g1ecdfemaleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 230))),0) as g1ecdtotAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 230))),0) as g1maleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 230))),0) as g1femaleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 230))),0) as g1totAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 230))),0) as g2maleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 230))),0) as g2femaleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 230))),0) as g2totAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 230))),0) as g3maleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 230))),0) as g3femaleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 230))),0) as g3totAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 230))),0) as g4maleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 230))),0) as g4femaleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 230))),0) as g4totAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 230))),0) as g5maleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 230))),0) as g5femaleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 230))),0) as g5totAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 230))),0) as g6maleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 230))),0) as g6femaleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 230))),0) as g6totAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 230))),0) as gp7maleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 230))),0) as gp7femaleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 230))),0) as gp7totAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 230))),0) as gtotmaleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 230))),0) as gtotfemaleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 230))),0) as gtotAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 230))),0) as ngmaleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 230))),0) as ngfemaleAge9
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 230))),0) as ngtotAge9

-- Age 10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 231))),0) as gkmaleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 231))),0) as gkfemaleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 231))),0) as gktotAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 231))),0) as g1ecdmaleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 231))),0) as g1ecdfemaleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 231))),0) as g1ecdtotAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 231))),0) as g1maleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 231))),0) as g1femaleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 231))),0) as g1totAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 231))),0) as g2maleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 231))),0) as g2femaleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 231))),0) as g2totAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 231))),0) as g3maleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 231))),0) as g3femaleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 231))),0) as g3totAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 231))),0) as g4maleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 231))),0) as g4femaleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 231))),0) as g4totAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 231))),0) as g5maleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 231))),0) as g5femaleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 231))),0) as g5totAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 231))),0) as g6maleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 231))),0) as g6femaleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 231))),0) as g6totAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 231))),0) as gp7maleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 231))),0) as gp7femaleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 231))),0) as gp7totAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 231))),0) as gtotmaleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 231))),0) as gtotfemaleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 231))),0) as gtotAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 231))),0) as ngmaleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 231))),0) as ngfemaleAge10
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 231))),0) as ngtotAge10

-- Age 10 Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 240))),0) as g7maleAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 240))),0) as g7femaleAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 105 AND en.age_category_id in ( 240))),0) as g7totAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 240))),0) as g8maleAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 240))),0) as g8femaleAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 106 AND en.age_category_id in ( 240))),0) as g8totAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 240))),0) as g9maleAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 240))),0) as g9femaleAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 107 AND en.age_category_id in ( 240))),0) as g9totAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 240))),0) as g10maleAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 240))),0) as g10femaleAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 108 AND en.age_category_id in ( 240))),0) as g10totAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 240))),0) as g11maleAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 240))),0) as g11femaleAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 497 AND en.age_category_id in ( 240))),0) as g11totAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 240))),0) as g12maleAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 240))),0) as g12femaleAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 595 AND en.age_category_id in ( 240))),0) as g12totAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 240))),0) as gtotmaleAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 240))),0) as gtotfemaleAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389) 
   AND en.age_category_id in ( 240))),0) as gtotAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 240))),0) as ngtotmaleAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 240))),0) as ngtotfemaleAge10Below
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 240))),0) as ngtotAge10Below

-- Age 11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 232))),0) as gkmaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 232))),0) as gkfemaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 232))),0) as gktotAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 232))),0) as g1ecdmaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 232))),0) as g1ecdfemaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 232))),0) as g1ecdtotAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 232))),0) as g1maleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 232))),0) as g1femaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 232))),0) as g1totAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 232))),0) as g2maleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 232))),0) as g2femaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 232))),0) as g2totAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 232))),0) as g3maleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 232))),0) as g3femaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 232))),0) as g3totAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 232))),0) as g4maleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 232))),0) as g4femaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 232))),0) as g4totAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 232))),0) as g5maleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 232))),0) as g5femaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 232))),0) as g5totAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 232))),0) as g6maleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 232))),0) as g6femaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 232))),0) as g6totAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 232))),0) as gp7maleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 232))),0) as gp7femaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 232))),0) as gp7totAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 241))),0) as g7maleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 241))),0) as g7femaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 105 AND en.age_category_id in ( 241))),0) as g7totAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 241))),0) as g8maleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 241))),0) as g8femaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 106 AND en.age_category_id in ( 241))),0) as g8totAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 241))),0) as g9maleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 241))),0) as g9femaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 107 AND en.age_category_id in ( 241))),0) as g9totAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 241))),0) as g10maleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 241))),0) as g10femaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 108 AND en.age_category_id in ( 241))),0) as g10totAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 241))),0) as g11maleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 241))),0) as g11femaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 497 AND en.age_category_id in ( 241))),0) as g11totAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 241))),0) as g12maleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 241))),0) as g12femaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 595 AND en.age_category_id in ( 241))),0) as g12totAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 232), en.age_category_id in ( 241)))),0) as gtotmaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 232), en.age_category_id in ( 241)))),0) as gtotfemaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 232), en.age_category_id in ( 241)))),0) as gtotAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 232), en.age_category_id in ( 241)))),0) as ngtotmaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 232), en.age_category_id in ( 241)))),0) as ngtotfemaleAge11
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 232), en.age_category_id in ( 241)))),0) as ngtotAge11

-- Age 12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 233))),0) as gkmaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 233))),0) as gkfemaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 233))),0) as gktotAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 233))),0) as g1ecdmaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 233))),0) as g1ecdfemaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 233))),0) as g1ecdtotAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 233))),0) as g1maleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 233))),0) as g1femaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 233))),0) as g1totAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 233))),0) as g2maleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 233))),0) as g2femaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 233))),0) as g2totAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 233))),0) as g3maleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 233))),0) as g3femaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 233))),0) as g3totAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 233))),0) as g4maleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 233))),0) as g4femaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 233))),0) as g4totAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 233))),0) as g5maleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 233))),0) as g5femaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 233))),0) as g5totAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 233))),0) as g6maleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 233))),0) as g6femaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 233))),0) as g6totAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 233))),0) as gp7maleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 233))),0) as gp7femaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 233))),0) as gp7totAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 242))),0) as g7maleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 242))),0) as g7femaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 105 AND en.age_category_id in ( 242))),0) as g7totAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 242))),0) as g8maleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 242))),0) as g8femaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 106 AND en.age_category_id in ( 242))),0) as g8totAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 242))),0) as g9maleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 242))),0) as g9femaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 107 AND en.age_category_id in ( 242))),0) as g9totAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 242))),0) as g10maleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 242))),0) as g10femaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 108 AND en.age_category_id in ( 242))),0) as g10totAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 242))),0) as g11maleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 242))),0) as g11femaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 497 AND en.age_category_id in ( 242))),0) as g11totAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 242))),0) as g12maleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 242))),0) as g12femaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 595 AND en.age_category_id in ( 242))),0) as g12totAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 233), en.age_category_id in ( 242)))),0) as gtotmaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 233), en.age_category_id in ( 242)))),0) as gtotfemaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 233), en.age_category_id in ( 242)))),0) as gtotAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 233), en.age_category_id in ( 242)))),0) as ngtotmaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 233), en.age_category_id in ( 242)))),0) as ngtotfemaleAge12
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 233), en.age_category_id in ( 242)))),0) as ngtotAge12

-- Age 12 & Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 385))),0) as gkmaleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 385))),0) as gkfemaleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 385))),0) as gktotAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 385))),0) as g1ecdmaleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 385))),0) as g1ecdfemaleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 385))),0) as g1ecdtotAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 385))),0) as g1maleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 385))),0) as g1femaleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 385))),0) as g1totAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 385))),0) as g2maleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 385))),0) as g2femaleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 385))),0) as g2totAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 385))),0) as g3maleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 385))),0) as g3femaleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 385))),0) as g3totAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 385))),0) as g4maleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 385))),0) as g4femaleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 385))),0) as g4totAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 385))),0) as g5maleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 385))),0) as g5femaleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 385))),0) as g5totAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 385))),0) as g6maleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 385))),0) as g6femaleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 385))),0) as g6totAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 385))),0) as gp7maleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 385))),0) as gp7femaleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 385))),0) as gp7totAgeAbove
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 385)  
   AND en.age_category_id in ( 385))),0) as gtotmaleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 385)  
   AND en.age_category_id in ( 385))),0) as gtotfemaleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 385)  
   AND en.age_category_id in ( 385))),0) as gtotAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 385))),0) as ngmaleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 385))),0) as ngfemaleAge12Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 385))),0) as ngtotAge12Above

-- Age 13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 189))),0) as gkmaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 189))),0) as gkfemaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 189))),0) as gktotAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 189))),0) as g1ecdmaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 189))),0) as g1ecdfemaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 189))),0) as g1ecdtotAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 189))),0) as g1maleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 189))),0) as g1femaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 189))),0) as g1totAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 189))),0) as g2maleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 189))),0) as g2femaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 189))),0) as g2totAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 189))),0) as g3maleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 189))),0) as g3femaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 189))),0) as g3totAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 189))),0) as g4maleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 189))),0) as g4femaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 189))),0) as g4totAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 189))),0) as g5maleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 189))),0) as g5femaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 189))),0) as g5totAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 189))),0) as g6maleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 189))),0) as g6femaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 189))),0) as g6totAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 189))),0) as gp7maleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 189))),0) as gp7femaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 189))),0) as gp7totAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 243))),0) as g7maleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 243))),0) as g7femaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 105 AND en.age_category_id in ( 243))),0) as g7totAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 243))),0) as g8maleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 243))),0) as g8femaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 106 AND en.age_category_id in ( 243))),0) as g8totAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 243))),0) as g9maleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 243))),0) as g9femaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 107 AND en.age_category_id in ( 243))),0) as g9totAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 243))),0) as g10maleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 243))),0) as g10femaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 108 AND en.age_category_id in ( 243))),0) as g10totAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 243))),0) as g11maleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 243))),0) as g11femaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 497 AND en.age_category_id in ( 243))),0) as g11totAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 243))),0) as g12maleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 243))),0) as g12femaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 595 AND en.age_category_id in ( 243))),0) as g12totAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 189), en.age_category_id in ( 243)))),0) as gtotmaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 189), en.age_category_id in ( 243)))),0) as gtotfemaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 189), en.age_category_id in ( 243)))),0) as gtotAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 189), en.age_category_id in ( 243)))),0) as ngtotmaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 189), en.age_category_id in ( 243)))),0) as ngtotfemaleAge13
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 189), en.age_category_id in ( 243)))),0) as ngtotAge13

-- Age 13 & Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 234))),0) as gkmaleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 234))),0) as gkfemaleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 234))),0) as gktotAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 234))),0) as g1ecdmaleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 234))),0) as g1ecdfemaleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 234))),0) as g1ecdtotAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 234))),0) as g1maleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 234))),0) as g1femaleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 234))),0) as g1totAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 234))),0) as g2maleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 234))),0) as g2femaleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 234))),0) as g2totAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 234))),0) as g3maleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 234))),0) as g3femaleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 234))),0) as g3totAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 234))),0) as g4maleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 234))),0) as g4femaleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 234))),0) as g4totAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 234))),0) as g5maleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 234))),0) as g5femaleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 234))),0) as g5totAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 234))),0) as g6maleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 234))),0) as g6femaleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 234))),0) as g6totAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 234))),0) as gp7maleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 234))),0) as gp7femaleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 234))),0) as gp7totAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 234))),0) as gtotmaleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 234))),0) as gtotfemaleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 234))),0) as gtotAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 234))),0) as ngmaleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 234))),0) as ngfemaleAge13Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 234))),0) as ngtotAge13Above

-- Age 13 to 15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 345))),0) as gkmaleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 345))),0) as gkfemaleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 345))),0) as gktotAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 345))),0) as g1ecdmaleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 345))),0) as g1ecdfemaleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 345))),0) as g1ecdtotAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 345))),0) as g1maleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 345))),0) as g1femaleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 345))),0) as g1totAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 345))),0) as g2maleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 345))),0) as g2femaleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 345))),0) as g2totAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 345))),0) as g3maleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 345))),0) as g3femaleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 345))),0) as g3totAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 345))),0) as g4maleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 345))),0) as g4femaleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 345))),0) as g4totAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 345))),0) as g5maleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 345))),0) as g5femaleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 345))),0) as g5totAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 345))),0) as g6maleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 345))),0) as g6femaleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 345))),0) as g6totAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 345))),0) as gp7maleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 345))),0) as gp7femaleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 345))),0) as gp7totAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 345))),0) as gtotmaleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 345))),0) as gtotfemaleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 345))),0) as gtotAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 345))),0) as ngmaleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 345))),0) as ngfemaleAge13to15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 345))),0) as ngtotAge13to15

-- Age 14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 205))),0) as gkmaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 205))),0) as gkfemaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 205))),0) as gktotAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 205))),0) as g1ecdmaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 205))),0) as g1ecdfemaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 205))),0) as g1ecdtotAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 205))),0) as g1maleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 205))),0) as g1femaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 205))),0) as g1totAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 205))),0) as g2maleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 205))),0) as g2femaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 205))),0) as g2totAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 205))),0) as g3maleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 205))),0) as g3femaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 205))),0) as g3totAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 205))),0) as g4maleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 205))),0) as g4femaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 205))),0) as g4totAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 205))),0) as g5maleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 205))),0) as g5femaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 205))),0) as g5totAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 205))),0) as g6maleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 205))),0) as g6femaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 205))),0) as g6totAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 205))),0) as gp7maleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 205))),0) as gp7femaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 205))),0) as gp7totAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 244))),0) as g7maleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 244))),0) as g7femaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 105 AND en.age_category_id in ( 244))),0) as g7totAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 244))),0) as g8maleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 244))),0) as g8femaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 106 AND en.age_category_id in ( 244))),0) as g8totAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 244))),0) as g9maleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 244))),0) as g9femaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 107 AND en.age_category_id in ( 244))),0) as g9totAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 244))),0) as g10maleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 244))),0) as g10femaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 108 AND en.age_category_id in ( 244))),0) as g10totAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 244))),0) as g11maleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 244))),0) as g11femaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 497 AND en.age_category_id in ( 244))),0) as g11totAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 244))),0) as g12maleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 244))),0) as g12femaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 595 AND en.age_category_id in ( 244))),0) as g12totAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 205), en.age_category_id in ( 244)))),0) as gtotmaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 205), en.age_category_id in ( 244)))),0) as gtotfemaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 205), en.age_category_id in ( 244)))),0) as gtotAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 205), en.age_category_id in ( 244)))),0) as ngtotmaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 205), en.age_category_id in ( 244)))),0) as ngtotfemaleAge14
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 205), en.age_category_id in ( 244)))),0) as ngtotAge14

-- Age 15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 206))),0) as gkmaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 206))),0) as gkfemaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 206))),0) as gktotAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 206))),0) as g1ecdmaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 206))),0) as g1ecdfemaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 206))),0) as g1ecdtotAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 206))),0) as g1maleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 206))),0) as g1femaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 206))),0) as g1totAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 206))),0) as g2maleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 206))),0) as g2femaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 206))),0) as g2totAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 206))),0) as g3maleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 206))),0) as g3femaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 206))),0) as g3totAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 206))),0) as g4maleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 206))),0) as g4femaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 206))),0) as g4totAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 206))),0) as g5maleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 206))),0) as g5femaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 206))),0) as g5totAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 206))),0) as g6maleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 206))),0) as g6femaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 206))),0) as g6totAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 206))),0) as gp7maleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 206))),0) as gp7femaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 206))),0) as gp7totAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 245))),0) as g7maleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 245))),0) as g7femaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 105 AND en.age_category_id in ( 245))),0) as g7totAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 245))),0) as g8maleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 245))),0) as g8femaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 106 AND en.age_category_id in ( 245))),0) as g8totAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 245))),0) as g9maleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 245))),0) as g9femaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 107 AND en.age_category_id in ( 245))),0) as g9totAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 245))),0) as g10maleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 245))),0) as g10femaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 108 AND en.age_category_id in ( 245))),0) as g10totAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 245))),0) as g11maleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 245))),0) as g11femaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 497 AND en.age_category_id in ( 245))),0) as g11totAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 245))),0) as g12maleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 245))),0) as g12femaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 595 AND en.age_category_id in ( 245))),0) as g12totAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 206), en.age_category_id in ( 245)))),0) as gtotmaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 206), en.age_category_id in ( 245)))),0) as gtotfemaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 206), en.age_category_id in ( 245)))),0) as gtotAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 206), en.age_category_id in ( 245)))),0) as ngtotmaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 206), en.age_category_id in ( 245)))),0) as ngtotfemaleAge15
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 206), en.age_category_id in ( 245)))),0) as ngtotAge15

-- Age 16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 439))),0) as gkmaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 439))),0) as gkfemaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 439))),0) as gktotAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 439))),0) as g1ecdmaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 439))),0) as g1ecdfemaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 439))),0) as g1ecdtotAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 439))),0) as g1maleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 439))),0) as g1femaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 439))),0) as g1totAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 439))),0) as g2maleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 439))),0) as g2femaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 439))),0) as g2totAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 439))),0) as g3maleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 439))),0) as g3femaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 439))),0) as g3totAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 439))),0) as g4maleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 439))),0) as g4femaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 439))),0) as g4totAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 439))),0) as g5maleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 439))),0) as g5femaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 439))),0) as g5totAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 439))),0) as g6maleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 439))),0) as g6femaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 439))),0) as g6totAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 439))),0) as gp7maleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 439))),0) as gp7femaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 439))),0) as gp7totAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 246))),0) as g7maleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 246))),0) as g7femaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 105 AND en.age_category_id in ( 246))),0) as g7totAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 246))),0) as g8maleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 246))),0) as g8femaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 106 AND en.age_category_id in ( 246))),0) as g8totAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 246))),0) as g9maleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 246))),0) as g9femaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 107 AND en.age_category_id in ( 246))),0) as g9totAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 246))),0) as g10maleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 246))),0) as g10femaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 108 AND en.age_category_id in ( 246))),0) as g10totAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 246))),0) as g11maleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 246))),0) as g11femaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 497 AND en.age_category_id in ( 246))),0) as g11totAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 246))),0) as g12maleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 246))),0) as g12femaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 595 AND en.age_category_id in ( 246))),0) as g12totAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 439), en.age_category_id in ( 246)))),0) as gtotmaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 439), en.age_category_id in ( 246)))),0) as gtotfemaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 439), en.age_category_id in ( 246)))),0) as gtotAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 439), en.age_category_id in ( 246)))),0) as ngtotmaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 439), en.age_category_id in ( 246)))),0) as ngtotfemaleAge16
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 439), en.age_category_id in ( 246)))),0) as ngtotAge16

-- Age 16 to 18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 308))),0) as gkmaleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 308))),0) as gkfemaleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 308))),0) as gktotAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 308))),0) as g1ecdmaleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 308))),0) as g1ecdfemaleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 308))),0) as g1ecdtotAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 308))),0) as g1maleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 308))),0) as g1femaleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 308))),0) as g1totAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 308))),0) as g2maleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 308))),0) as g2femaleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 308))),0) as g2totAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 308))),0) as g3maleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 308))),0) as g3femaleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 308))),0) as g3totAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 308))),0) as g4maleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 308))),0) as g4femaleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 308))),0) as g4totAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 308))),0) as g5maleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 308))),0) as g5femaleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 308))),0) as g5totAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 308))),0) as g6maleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 308))),0) as g6femaleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 308))),0) as g6totAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 308))),0) as gp7maleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 308))),0) as gp7femaleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 308))),0) as gp7totAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 308))),0) as gtotmaleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 308))),0) as gtotfemaleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 308))),0) as gtotAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 308))),0) as ngmaleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 308))),0) as ngfemaleAge16to18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 308))),0) as ngtotAge16to18

-- Age 17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 484))),0) as gkmaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 484))),0) as gkfemaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 484))),0) as gktotAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 484))),0) as g1ecdmaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 484))),0) as g1ecdfemaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 484))),0) as g1ecdtotAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 484))),0) as g1maleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 484))),0) as g1femaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 484))),0) as g1totAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 484))),0) as g2maleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 484))),0) as g2femaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 484))),0) as g2totAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 484))),0) as g3maleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 484))),0) as g3femaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 484))),0) as g3totAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 484))),0) as g4maleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 484))),0) as g4femaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 484))),0) as g4totAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 484))),0) as g5maleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 484))),0) as g5femaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 484))),0) as g5totAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 484))),0) as g6maleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 484))),0) as g6femaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 484))),0) as g6totAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 484))),0) as gp7maleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 484))),0) as gp7femaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 484))),0) as gp7totAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 247))),0) as g7maleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 247))),0) as g7femaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 105 AND en.age_category_id in ( 247))),0) as g7totAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 247))),0) as g8maleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 247))),0) as g8femaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 106 AND en.age_category_id in ( 247))),0) as g8totAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 247))),0) as g9maleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 247))),0) as g9femaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 107 AND en.age_category_id in ( 247))),0) as g9totAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 247))),0) as g10maleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 247))),0) as g10femaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 108 AND en.age_category_id in ( 247))),0) as g10totAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 247))),0) as g11maleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 247))),0) as g11femaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 497 AND en.age_category_id in ( 247))),0) as g11totAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 247))),0) as g12maleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 247))),0) as g12femaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 595 AND en.age_category_id in ( 247))),0) as g12totAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 484), en.age_category_id in ( 247)))),0) as gtotmaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 484), en.age_category_id in ( 247)))),0) as gtotfemaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 484), en.age_category_id in ( 247)))),0) as gtotAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 484), en.age_category_id in ( 247)))),0) as ngtotmaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 484), en.age_category_id in ( 247)))),0) as ngtotfemaleAge17
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 484), en.age_category_id in ( 247)))),0) as ngtotAge17

-- Age 18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 489))),0) as gkmaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 489))),0) as gkfemaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 489))),0) as gktotAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 489))),0) as g1ecdmaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 489))),0) as g1ecdfemaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 489))),0) as g1ecdtotAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 489))),0) as g1maleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 489))),0) as g1femaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 489))),0) as g1totAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 489))),0) as g2maleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 489))),0) as g2femaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 489))),0) as g2totAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 489))),0) as g3maleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 489))),0) as g3femaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 489))),0) as g3totAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 489))),0) as g4maleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 489))),0) as g4femaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 489))),0) as g4totAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 489))),0) as g5maleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 489))),0) as g5femaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 489))),0) as g5totAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 489))),0) as g6maleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 489))),0) as g6femaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 489))),0) as g6totAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 489))),0) as gp7maleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 489))),0) as gp7femaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 489))),0) as gp7totAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 248))),0) as g7maleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 248))),0) as g7femaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 105 AND en.age_category_id in ( 248))),0) as g7totAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 248))),0) as g8maleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 248))),0) as g8femaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 106 AND en.age_category_id in ( 248))),0) as g8totAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 248))),0) as g9maleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 248))),0) as g9femaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 107 AND en.age_category_id in ( 248))),0) as g9totAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 248))),0) as g10maleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 248))),0) as g10femaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 108 AND en.age_category_id in ( 248))),0) as g10totAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 248))),0) as g11maleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 248))),0) as g11femaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 497 AND en.age_category_id in ( 248))),0) as g11totAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 248))),0) as g12maleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 248))),0) as g12femaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 595 AND en.age_category_id in ( 248))),0) as g12totAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 489), en.age_category_id in ( 248)))),0) as gtotmaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 489), en.age_category_id in ( 248)))),0) as gtotfemaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 489), en.age_category_id in ( 248)))),0) as gtotAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 489), en.age_category_id in ( 248)))),0) as ngtotmaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 489), en.age_category_id in ( 248)))),0) as ngtotfemaleAge18
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND if(sph.co_gen_class=433, en.age_category_id in ( 489), en.age_category_id in ( 248)))),0) as ngtotAge18

-- Age 19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 249))),0) as g7maleAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 249))),0) as g7femaleAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 105 AND en.age_category_id in ( 249))),0) as g7totAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 249))),0) as g8maleAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 249))),0) as g8femaleAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 106 AND en.age_category_id in ( 249))),0) as g8totAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 249))),0) as g9maleAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 249))),0) as g9femaleAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 107 AND en.age_category_id in ( 249))),0) as g9totAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 249))),0) as g10maleAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 249))),0) as g10femaleAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 108 AND en.age_category_id in ( 249))),0) as g10totAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 249))),0) as g11maleAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 249))),0) as g11femaleAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 497 AND en.age_category_id in ( 249))),0) as g11totAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 249))),0) as g12maleAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 249))),0) as g12femaleAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 595 AND en.age_category_id in ( 249))),0) as g12totAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 249))),0) as gtotmaleAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 249))),0) as gtotfemaleAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389) 
   AND en.age_category_id in ( 249))),0) as gtotAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 249))),0) as ngtotmaleAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 249))),0) as ngtotfemaleAge19
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 249))),0) as ngtotAge19

-- Age 19 & Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 309))),0) as gkmaleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 405 AND en.age_category_id in ( 309))),0) as gkfemaleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.age_category_id in ( 309))),0) as gktotAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 309))),0) as g1ecdmaleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 195 AND en.age_category_id in ( 309))),0) as g1ecdfemaleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 195 AND en.age_category_id in ( 309))),0) as g1ecdtotAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 309))),0) as g1maleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 98 AND en.age_category_id in ( 309))),0) as g1femaleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.age_category_id in ( 309))),0) as g1totAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 309))),0) as g2maleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 99 AND en.age_category_id in ( 309))),0) as g2femaleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.age_category_id in ( 309))),0) as g2totAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 309))),0) as g3maleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 100 AND en.age_category_id in ( 309))),0) as g3femaleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.age_category_id in ( 309))),0) as g3totAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 309))),0) as g4maleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 101 AND en.age_category_id in ( 309))),0) as g4femaleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.age_category_id in ( 309))),0) as g4totAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 309))),0) as g5maleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 102 AND en.age_category_id in ( 309))),0) as g5femaleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.age_category_id in ( 309))),0) as g5totAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 309))),0) as g6maleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 103 AND en.age_category_id in ( 309))),0) as g6femaleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.age_category_id in ( 309))),0) as g6totAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 309))),0) as gp7maleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 104 AND en.age_category_id in ( 309))),0) as gp7femaleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.age_category_id in ( 309))),0) as gp7totAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 309))),0) as gtotmaleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 309))),0) as gtotfemaleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 309))),0) as gtotAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 309))),0) as ngmaleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 309))),0) as ngfemaleAge19Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.sy_from = 2016, 598, 197)  AND en.age_category_id in ( 309))),0) as ngtotAge19Above

-- Age 20 & Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 250))),0) as g7maleAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 105 AND en.age_category_id in ( 250))),0) as g7femaleAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 105 AND en.age_category_id in ( 250))),0) as g7totAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 250))),0) as g8maleAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 106 AND en.age_category_id in ( 250))),0) as g8femaleAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 106 AND en.age_category_id in ( 250))),0) as g8totAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 250))),0) as g9maleAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 107 AND en.age_category_id in ( 250))),0) as g9femaleAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 107 AND en.age_category_id in ( 250))),0) as g9totAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 250))),0) as g10maleAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 108 AND en.age_category_id in ( 250))),0) as g10femaleAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 108 AND en.age_category_id in ( 250))),0) as g10totAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 250))),0) as g11maleAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 497 AND en.age_category_id in ( 250))),0) as g11femaleAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 497 AND en.age_category_id in ( 250))),0) as g11totAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 250))),0) as g12maleAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = 595 AND en.age_category_id in ( 250))),0) as g12femaleAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = 595 AND en.age_category_id in ( 250))),0) as g12totAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 250))),0) as gtotmaleAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 250))),0) as gtotfemaleAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389) 
   AND en.age_category_id in ( 250))),0) as gtotAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 250))),0) as ngtotmaleAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en WHERE en.report_history_id = rh.id 
   AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 250))),0) as ngtotfemaleAge20Above
, IFNULL(SUM((SELECT SUM(IFNULL(en.enroll_male, 0)+ifnull(en.enroll_female,0)) AS sum_en FROM ebeisdb.enrollment_age_summary en 
   WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.co_gen_class=433, if(sph.sy_from = 2016, 598, 197), 389)  
   AND en.age_category_id in ( 250))),0) as ngtotAge20Above

FROM ebeisdb.school_profile_history sph
   LEFT JOIN ref_region rr on (rr.id = sph.region_id)
   LEFT JOIN (ebeisdb.report_history rh 
	      inner join ebeisdb.ref_report_history rrh on rh.ref_report_history_id = rrh.id
	      inner join ebeisdb.ref_reports rrs on rrs.id  = rrh.report_id
	      inner join ebeisdb.ref_report_generics rrg on rrg.id = rrs.ref_report_generics_id and rrg.id=1
	 ) on rh.school_id = sph.school_id and rh.sy_from= sph.sy_from and rh.report_status > 300 -- cast( sph.sy_from as unsigned)
   WHERE  sph.take_part_id IN (1,2,3)
