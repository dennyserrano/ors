-- 2010 to 2011
INSERT INTO `orsdb`.`personnel_assignmentbyyear`
(`sy_from`,
`school_id`,
`english_g7total`,
`math_g7total`,
`filipino_g7total`,
`gensci_g7total`,
`bio_g7total`,
`chem_g7total`,
`phys_g7total`,
`aral_g7total`,
`tle_g7total`,
`val_g7total`,
`musart_g7total`,
`pe_g7total`,
`english_g8total`,
`math_g8total`,
`filipino_g8total`,
`gensci_g8total`,
`bio_g8total`,
`chem_g8total`,
`phys_g8total`,
`aral_g8total`,
`tle_g8total`,
`val_g8total`,
`musart_g8total`,
`pe_g8total`,
`english_g9total`,
`math_g9total`,
`filipino_g9total`,
`gensci_g9total`,
`bio_g9total`,
`chem_g9total`,
`phys_g9total`,
`aral_g9total`,
`tle_g9total`,
`val_g9total`,
`musart_g9total`,
`pe_g9total`,
`english_g10total`,
`math_g10total`,
`filipino_g10total`,
`gensci_g10total`,
`bio_g10total`,
`chem_g10total`,
`phys_g10total`,
`aral_g10total`,
`tle_g10total`,
`val_g10total`,
`musart_g10total`,
`pe_g10total`
)
SELECT
sph.sy_from AS SY_FROM,
sph.school_id AS SCHOOL_ID,                                                                                                                                        
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 460 and pps.category_level_id = 4300 and pps.level_id = 105 and pps.report_history_id = rh.id)),0) as 'English Teacher in G7',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 461 and pps.category_level_id = 4300 and pps.level_id = 105 and pps.report_history_id = rh.id)),0) as 'Math Teacher in G7',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 462 and pps.category_level_id = 4300 and pps.level_id = 105 and pps.report_history_id = rh.id)),0) as 'Filipino Teacher in G7',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 464 and pps.category_level_id = 4300 and pps.level_id = 105 and pps.report_history_id = rh.id)),0) as 'General Science Teacher in G7',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 465 and pps.category_level_id = 4300 and pps.level_id = 105 and pps.report_history_id = rh.id)),0) as 'Biology Teacher in G7',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 466 and pps.category_level_id = 4300 and pps.level_id = 105 and pps.report_history_id = rh.id)),0) as 'Chemistry Teacher in G7',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 467 and pps.category_level_id = 4300 and pps.level_id = 105 and pps.report_history_id = rh.id)),0) as 'Physics Teacher in G7',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 469 and pps.category_level_id = 4300 and pps.level_id = 105 and pps.report_history_id = rh.id)),0) as 'Araling Panlipunan Teacher in G7',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 470 and pps.category_level_id = 4300 and pps.level_id = 105 and pps.report_history_id = rh.id)),0) as 'TLE Teacher in G7',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 237 and pps.category_level_id = 4300 and pps.level_id = 105 and pps.report_history_id = rh.id)),0) as 'Values Educ Teacher in G7',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 480 and pps.category_level_id = 4300 and pps.level_id = 105 and pps.report_history_id = rh.id)),0) as 'Music and Arts Teacher in G7',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 481 and pps.category_level_id = 4300 and pps.level_id = 105 and pps.report_history_id = rh.id)),0) as 'PE and Health Teacher in G7',

IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 460 and pps.category_level_id = 4300 and pps.level_id = 106 and pps.report_history_id = rh.id)),0) as 'English Teacher in G8',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 461 and pps.category_level_id = 4300 and pps.level_id = 106 and pps.report_history_id = rh.id)),0) as 'Math Teacher in G8',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 462 and pps.category_level_id = 4300 and pps.level_id = 106 and pps.report_history_id = rh.id)),0) as 'Filipino Teacher in G8',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 464 and pps.category_level_id = 4300 and pps.level_id = 106 and pps.report_history_id = rh.id)),0) as 'General Science Teacher in G8',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 465 and pps.category_level_id = 4300 and pps.level_id = 106 and pps.report_history_id = rh.id)),0) as 'Biology Teacher in G8',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 466 and pps.category_level_id = 4300 and pps.level_id = 106 and pps.report_history_id = rh.id)),0) as 'Chemistry Teacher in G8',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 467 and pps.category_level_id = 4300 and pps.level_id = 106 and pps.report_history_id = rh.id)),0) as 'Physics Teacher in G8',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 469 and pps.category_level_id = 4300 and pps.level_id = 106 and pps.report_history_id = rh.id)),0) as 'Araling Panlipunan Teacher in G8',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 470 and pps.category_level_id = 4300 and pps.level_id = 106 and pps.report_history_id = rh.id)),0) as 'TLE Teacher in G8',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 237 and pps.category_level_id = 4300 and pps.level_id = 106 and pps.report_history_id = rh.id)),0) as 'Values Educ Teacher in G8',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 480 and pps.category_level_id = 4300 and pps.level_id = 106 and pps.report_history_id = rh.id)),0) as 'Music and Arts Teacher in G8',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 481 and pps.category_level_id = 4300 and pps.level_id = 106 and pps.report_history_id = rh.id)),0) as 'PE and Health Teacher in G8',

IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 460 and pps.category_level_id = 4300 and pps.level_id = 107 and pps.report_history_id = rh.id)),0) as 'English Teacher in G9',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 461 and pps.category_level_id = 4300 and pps.level_id = 107 and pps.report_history_id = rh.id)),0) as 'Math Teacher in G9',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 462 and pps.category_level_id = 4300 and pps.level_id = 107 and pps.report_history_id = rh.id)),0) as 'Filipino Teacher in G9',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 464 and pps.category_level_id = 4300 and pps.level_id = 107 and pps.report_history_id = rh.id)),0) as 'General Science Teacher in G9',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 465 and pps.category_level_id = 4300 and pps.level_id = 107 and pps.report_history_id = rh.id)),0) as 'Biology Teacher in G9',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 466 and pps.category_level_id = 4300 and pps.level_id = 107 and pps.report_history_id = rh.id)),0) as 'Chemistry Teacher in G9',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 467 and pps.category_level_id = 4300 and pps.level_id = 107 and pps.report_history_id = rh.id)),0) as 'Physics Teacher in G9',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 469 and pps.category_level_id = 4300 and pps.level_id = 107 and pps.report_history_id = rh.id)),0) as 'Araling Panlipunan Teacher in G9',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 470 and pps.category_level_id = 4300 and pps.level_id = 107 and pps.report_history_id = rh.id)),0) as 'TLE Teacher in G9',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 237 and pps.category_level_id = 4300 and pps.level_id = 107 and pps.report_history_id = rh.id)),0) as 'Values Educ Teacher in G9',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 480 and pps.category_level_id = 4300 and pps.level_id = 107 and pps.report_history_id = rh.id)),0) as 'Music and Arts Teacher in G9',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 481 and pps.category_level_id = 4300 and pps.level_id = 107 and pps.report_history_id = rh.id)),0) as 'PE and Health Teacher in G9',

IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 460 and pps.category_level_id = 4300 and pps.level_id = 108 and pps.report_history_id = rh.id)),0) as 'English Teacher in G10',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 461 and pps.category_level_id = 4300 and pps.level_id = 108 and pps.report_history_id = rh.id)),0) as 'Math Teacher in G10',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 462 and pps.category_level_id = 4300 and pps.level_id = 108 and pps.report_history_id = rh.id)),0) as 'Filipino Teacher in G10',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 464 and pps.category_level_id = 4300 and pps.level_id = 108 and pps.report_history_id = rh.id)),0) as 'General Science Teacher in G10',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 465 and pps.category_level_id = 4300 and pps.level_id = 108 and pps.report_history_id = rh.id)),0) as 'Biology Teacher in G10',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 466 and pps.category_level_id = 4300 and pps.level_id = 108 and pps.report_history_id = rh.id)),0) as 'Chemistry Teacher in G10',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 467 and pps.category_level_id = 4300 and pps.level_id = 108 and pps.report_history_id = rh.id)),0) as 'Physics Teacher in G10',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 469 and pps.category_level_id = 4300 and pps.level_id = 108 and pps.report_history_id = rh.id)),0) as 'Araling Panlipunan Teacher in G10',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 470 and pps.category_level_id = 4300 and pps.level_id = 108 and pps.report_history_id = rh.id)),0) as 'TLE Teacher in G10',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 237 and pps.category_level_id = 4300 and pps.level_id = 108 and pps.report_history_id = rh.id)),0) as 'Values Educ Teacher in G10',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 480 and pps.category_level_id = 4300 and pps.level_id = 108 and pps.report_history_id = rh.id)),0) as 'Music and Arts Teacher in G10',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 481 and pps.category_level_id = 4300 and pps.level_id = 108 and pps.report_history_id = rh.id)),0) as 'PE and Health Teacher in G10'

FROM ebeisdb.school_profile_history sph
LEFT JOIN ebeisdb.ref_reports reports on (reports.co_genclass_id=sph.co_gen_class 
 and reports.general_classification_id=sph.general_classification_id 
 AND reports.ref_report_generics_id = 2)
LEFT JOIN ebeisdb.ref_report_history rrh on (reports.id=rrh.report_id and rrh.sy_from = CAST(sph.sy_from AS CHAR))
LEFT JOIN ebeisdb.report_history rh on (rh.ref_report_history_id = rrh.id and rh.school_id=sph.school_id 
 and rh.report_status IN (301,302))

WHERE sph.SY_FROM between 2016 and 2016 AND sph.general_classification_id = 7 AND sph.co_gen_class in (434) 
 AND sph.take_part_id in (1,2,3) AND sph.date_closed is null
GROUP BY sph.sy_from, sph.SCHOOL_ID
ORDER BY sph.sy_from, sph.SCHOOL_ID ASC;

commit;
