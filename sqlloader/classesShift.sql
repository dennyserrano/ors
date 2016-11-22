insert into orsdb.classes_shifts(school_year,school_id,gkmono_class,g1mono_class,g2mono_class,g3mono_class,g4mono_class,g5mono_class,
g6mono_class,gp7mono_class,g7mono_class,g8mono_class,g9mono_class,g10mono_class,g11mono_class,g12mono_class,ngmono_class,
totmono_class,totmulti_class,gkalivemono_class,g1alivemono_class,g2alivemono_class,g3alivemono_class,g4alivemono_class,
g5alivemono_class,g6alivemono_class,g7alivemono_class,g8alivemono_class,g9alivemono_class,g10alivemono_class,g11alivemono_class,
g12alivemono_class,ngalivemono_class,totalivemono_class,totalivemulti_class,sh1_male,sh1_female,sh1_total,sh1_no_class,sh2_male,
sh2_female,sh2_total,sh2_no_class,sh3_male,sh3_female,sh3_total,sh3_no_class,sh4_male,sh4_female,sh4_total,sh4_no_class,shtot_male,
shtot_female,sh_total,shtot_no_class,ksh1_male,ksh1_female,ksh1_total,ksh1_no_class,ksh2_male,ksh2_female,ksh2_total,ksh2_no_class,
ksh3_male,ksh3_female,ksh3_total,ksh3_no_class,ksh4_male,ksh4_female,ksh4_total,ksh4_no_class,kshtot_male,kshtot_female,kshtot_total,
kshtot_no_class,essh1_male,essh1_female,essh1_total,essh1_no_class,essh2_male,essh2_female,essh2_total,essh2_no_class,essh3_male,
essh3_female,essh3_total,essh3_no_class,essh4_male,essh4_female,essh4_total,essh4_no_class,esshtot_male,esshtot_female,esshtot_total,
esshtot_no_class,sssh1_male,sssh1_female,sssh1_total,sssh1_no_class,sssh2_male,sssh2_female,sssh2_total,sssh2_no_class,sssh3_male,
sssh3_female,sssh3_total,sssh3_no_class,sssh4_male,sssh4_female,sssh4_total,sssh4_no_class,ssshtot_male,ssshtot_female,ssshtot_total,
ssshtot_no_class,ngsh1_male,ngsh1_female,ngsh1_total,ngsh1_no_class,ngsh2_male,ngsh2_female,ngsh2_total,ngsh2_no_class,ngsh3_male,
ngsh3_female,ngsh3_total,ngsh3_no_class,ngsh4_male,ngsh4_female,ngsh4_total,ngsh4_no_class,ngshtot_male,ngshtot_female,ngshtot_total,
ngshtot_no_class,school_with_shifting,end_on_shift,overlapping_shift,daily_rotation,others,other_shifting,double_shift,triple_shift,
quadruple_shift)

SELECT sph.sy_from, sph.school_id

-- Monograde Classes
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.pupil_data_indicator=25)),0) as gkmono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.pupil_data_indicator=25)),0) as g1mono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.pupil_data_indicator=25)),0) as g2mono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.pupil_data_indicator=25)),0) as g3mono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.pupil_data_indicator=25)),0) as g4mono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.pupil_data_indicator=25)),0) as g5mono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.pupil_data_indicator=25)),0) as g6mono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 104 AND en.pupil_data_indicator=25)),0) as gp7mono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 105 AND en.pupil_data_indicator=25)),0) as g7mono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 106 AND en.pupil_data_indicator=25)),0) as g8mono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 107 AND en.pupil_data_indicator=25)),0) as g9mono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 108 AND en.pupil_data_indicator=25)),0) as g10mono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 497 AND en.pupil_data_indicator=25)),0) as g11mono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 595 AND en.pupil_data_indicator=25)),0) as g12mono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.co_gen_class=433,if(sph.sy_from=2013,598,197),389) AND en.pupil_data_indicator=25)),0) as ngmono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433,if(sph.sy_from=2013,598,197),389) AND en.pupil_data_indicator=25)),0) as totmono_class

-- Multigrade Classes
	, IFNULL(IF(sph.sy_from<2014,SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.pupil_data_indicator=26)),
			(select if(locate('3',CONCAT(mg.kinder,mg.g1,mg.g2,mg.g3,mg.g4,mg.g5,mg.g6))>0,3,if(locate('2',CONCAT(mg.kinder,mg.g1,mg.g2,mg.g3,mg.g4,mg.g5,mg.g6))>0,2,if(locate('1',CONCAT(mg.kinder,mg.g1,mg.g2,mg.g3,mg.g4,mg.g5,mg.g6))>0,1,0)))
			from ebeisdb.multigrade_class mg WHERE mg.report_history_id=rh.id)),0) as totmulti_class

-- ALIVE Monograde Classes
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 405 AND en.pupil_data_indicator=500)),0) as gkalivemono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.pupil_data_indicator=500)),0) as g1alivemono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 99 AND en.pupil_data_indicator=500)),0) as g2alivemono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 100 AND en.pupil_data_indicator=500)),0) as g3alivemono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 101 AND en.pupil_data_indicator=500)),0) as g4alivemono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 102 AND en.pupil_data_indicator=500)),0) as g5alivemono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 103 AND en.pupil_data_indicator=500)),0) as g6alivemono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 105 AND en.pupil_data_indicator=500)),0) as g7alivemono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 106 AND en.pupil_data_indicator=500)),0) as g8alivemono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 107 AND en.pupil_data_indicator=500)),0) as g9alivemono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 108 AND en.pupil_data_indicator=500)),0) as g10alivemono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 497 AND en.pupil_data_indicator=500)),0) as g11alivemono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 595 AND en.pupil_data_indicator=500)),0) as g12alivemono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = if(sph.co_gen_class=433,if(sph.sy_from=2013,598,197),389) AND en.pupil_data_indicator=500)),0) as ngalivemono_class
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id != if(sph.co_gen_class=433,if(sph.sy_from=2013,598,197),389) AND en.pupil_data_indicator=500)),0) as totalivemono_class

-- ALIVE Multigrade Classes
	, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 98 AND en.pupil_data_indicator=500)),0) as totalivemulti_class

-- Enrolment by Shift - Total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3435,320))),0) as sh1_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3435,320))),0) as sh1_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3435,320))),0) as sh1_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3435,320))),0) as sh1_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3440,321))),0) as sh2_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3440,321))),0) as sh2_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3440,321))),0) as sh2_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3440,321))),0) as sh2_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3445,322))),0) as sh3_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3445,322))),0) as sh3_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3445,322))),0) as sh3_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3445,322))),0) as sh3_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3450,323))),0) as sh4_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3450,323))),0) as sh4_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3450,323))),0) as sh4_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3450,323))),0) as sh4_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3435,3440,3445,3450,320,321,322,323))),0) as shtot_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3435,3440,3445,3450,320,321,322,323))),0) as shtot_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3435,3440,3445,3450,320,321,322,323))),0) as sh_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.shift_id in (3435,3440,3445,3450,320,321,322,323))),0) as shtot_no_class

-- Enrolment by Shift - Kinder
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346 AND sh.shift_id = 320)),0) as ksh1_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346 AND sh.shift_id = 320)),0) as ksh1_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346 AND sh.shift_id = 320)),0) as ksh1_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346 AND sh.shift_id = 320)),0) as ksh1_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346 AND sh.shift_id = 321)),0) as ksh2_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346 AND sh.shift_id = 321)),0) as ksh2_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346 AND sh.shift_id = 321)),0) as ksh2_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346 AND sh.shift_id = 321)),0) as ksh2_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346 AND sh.shift_id = 322)),0) as ksh3_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346 AND sh.shift_id = 322)),0) as ksh3_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346 AND sh.shift_id = 322)),0) as ksh3_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346 AND sh.shift_id = 322)),0) as ksh3_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346 AND sh.shift_id = 323)),0) as ksh4_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346 AND sh.shift_id = 323)),0) as ksh4_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346 AND sh.shift_id = 323)),0) as ksh4_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346 AND sh.shift_id = 323)),0) as ksh4_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346)),0) as kshtot_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346)),0) as kshtot_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346)),0) as kshtot_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 346)),0) as kshtot_no_class
	
-- Enrolment by Shift - Elementary
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347 AND sh.shift_id = 320)),0) as essh1_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347 AND sh.shift_id = 320)),0) as essh1_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347 AND sh.shift_id = 320)),0) as essh1_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347 AND sh.shift_id = 320)),0) as essh1_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347 AND sh.shift_id = 321)),0) as essh2_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347 AND sh.shift_id = 321)),0) as essh2_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347 AND sh.shift_id = 321)),0) as essh2_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347 AND sh.shift_id = 321)),0) as essh2_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347 AND sh.shift_id = 322)),0) as essh3_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347 AND sh.shift_id = 322)),0) as essh3_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 344 AND sh.shift_id = 322)),0) as essh3_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347 AND sh.shift_id = 322)),0) as essh3_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347 AND sh.shift_id = 323)),0) as essh4_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347 AND sh.shift_id = 323)),0) as essh4_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347 AND sh.shift_id = 323)),0) as essh4_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347 AND sh.shift_id = 323)),0) as essh4_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347)),0) as esshtot_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347)),0) as esshtot_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347)),0) as esshtot_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 347)),0) as esshtot_no_class

-- Enrolment by Shift - Secondary
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348 AND sh.shift_id = 320)),0) as sssh1_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348 AND sh.shift_id = 320)),0) as sssh1_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348 AND sh.shift_id = 320)),0) as sssh1_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348 AND sh.shift_id = 320)),0) as sssh1_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348 AND sh.shift_id = 321)),0) as sssh2_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348 AND sh.shift_id = 321)),0) as sssh2_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348 AND sh.shift_id = 321)),0) as sssh2_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348 AND sh.shift_id = 321)),0) as sssh2_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348 AND sh.shift_id = 322)),0) as sssh3_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348 AND sh.shift_id = 322)),0) as sssh3_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348 AND sh.shift_id = 322)),0) as sssh3_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348 AND sh.shift_id = 322)),0) as sssh3_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348 AND sh.shift_id = 323)),0) as sssh4_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348 AND sh.shift_id = 323)),0) as sssh4_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348 AND sh.shift_id = 323)),0) as sssh4_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348 AND sh.shift_id = 323)),0) as sssh4_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348)),0) as ssshtot_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348)),0) as ssshtot_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348)),0) as ssshtot_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = 348)),0) as ssshtot_no_class

-- Enrolment by Shift - SPED
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349) AND sh.shift_id = 320)),0) as ngsh1_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349) AND sh.shift_id = 320)),0) as ngsh1_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349) AND sh.shift_id = 320)),0) as ngsh1_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349) AND sh.shift_id = 320)),0) as ngsh1_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349) AND sh.shift_id = 321)),0) as ngsh2_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349) AND sh.shift_id = 321)),0) as ngsh2_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349) AND sh.shift_id = 321)),0) as ngsh2_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349) AND sh.shift_id = 321)),0) as ngsh2_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349) AND sh.shift_id = 322)),0) as ngsh3_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349) AND sh.shift_id = 322)),0) as ngsh3_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349) AND sh.shift_id = 322)),0) as ngsh3_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349) AND sh.shift_id = 322)),0) as ngsh3_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349) AND sh.shift_id = 323)),0) as ngsh4_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349) AND sh.shift_id = 323)),0) as ngsh4_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349) AND sh.shift_id = 323)),0) as ngsh4_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349) AND sh.shift_id = 323)),0) as ngsh4_no_class
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349))),0) as ngshtot_male
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349))),0) as ngshtot_female
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.enrolled_male,0)+IFNULL(sh.enrolled_female,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349))),0) as ngshtot_total
	, IFNULL(SUM((SELECT SUM(IFNULL(sh.number_of_classes,0)) AS sh_en FROM ebeisdb.enrollment_shift_summary sh WHERE sh.report_history_id = rh.id AND sh.particulars_id = if(sph.sy_from=2016,if(sph.co_gen_class=433,599,349),349))),0) as ngshtot_no_class

-- Shifting `schedule`
	, IFNULL(if(osd.shifting_schedule>0,1,0),0) as school_with_shifting
	, IFNULL(if(osd.shifting_schedule in (1,3,5,7,9,11,13,15),1,0),0) as end_on_shift
	, IFNULL(if(osd.shifting_schedule in (2,3,6,7,10,11,14,15),1,0),0) as overlapping_shift
	, IFNULL(if(osd.shifting_schedule in (4,5,6,7,12,13,14,15),1,0),0) as daily_rotation
	, IFNULL(if(osd.shifting_schedule in (8,9,10,11,12,13,14,15),1,0),0) as others
	, IFNULL(osd.other_shifting,"") as other_shifting
	, IFNULL(osd.double_shift,0) as double_shift
	, IFNULL(osd.triple_shift,0) as triple_shift
	, IFNULL(osd.quadruple_shift,0) as quadruple_shift

FROM ebeisdb.school_profile_history sph
   LEFT JOIN ebeisdb.ref_region rr ON (rr.id=sph.region_id)
   LEFT JOIN (ebeisdb.report_history rh 
	      inner join ebeisdb.ref_report_history rrh on rh.ref_report_history_id = rrh.id
	      inner join ebeisdb.ref_reports rrs on rrs.id  = rrh.report_id
	      inner join ebeisdb.ref_report_generics rrg on rrg.id = rrs.ref_report_generics_id and rrg.id=1
	 ) on rh.school_id = sph.school_id and rh.sy_from= sph.sy_from and rh.report_status > 300 -- cast( sph.sy_from as unsigned)
	 LEFT JOIN ebeisdb.other_school_data osd on (osd.report_history_id = rh.id)
   WHERE sph.take_part_id IN (1,2,3)
   GROUP BY rh.sy_from, sph.SCHOOL_ID 
   ORDER BY sph.SY_FROM, rr.RANK ASC, sph.SCHOOL_ID ASC;

commit;

