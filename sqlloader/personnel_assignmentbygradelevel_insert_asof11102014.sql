-- 2011 to 2014
INSERT INTO `personnel_assignmentbygrade`
(
`sy_from`,
`school_id`,
`english_g5male`,
`english_g5female`,
`english_g5total`,
`math_g5male`,
`math_g5female`,
`math_g5total`,
`filipino_g5male`,
`filipino_g5female`,
`filipino_g5total`,
`science_g5male`,
`science_g5female`,
`science_g5total`,
`sibika_g5male`,
`sibika_g5female`,
`sibika_g5total`,
`heepp_g5male`,
`heepp_g5female`,
`heepp_g5total`,
`ekawp_g5male`,
`ekawp_g5female`,
`ekawp_g5total`,
`msep_g5male`,
`msep_g5female`,
`msep_g5total`,
`english_g6male`,
`english_g6female`,
`english_g6total`,
`math_g6male`,
`math_g6female`,
`math_g6total`,
`filipino_g6male`,
`filipino_g6female`,
`filipino_g6total`,
`science_g6male`,
`science_g6female`,
`science_g6total`,
`sibika_g6male`,
`sibika_g6female`,
`sibika_g6total`,
`heepp_g6male`,
`heepp_g6female`,
`heepp_g6total`,
`ekawp_g6male`,
`ekawp_g6female`,
`ekawp_g6total`,
`msep_g6male`,
`msep_g6female`,
`msep_g6total`)




SELECT
sph.sy_from AS SY_FROM,
sph.school_id AS SCHOOL_ID,
SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 460 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'English Male Teacher in G5',
SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 460 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'English Female Teacher in G5',
SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0)) AS qty FROM teaching_assignment_summary pps WHERE  subject_standard_id = 460 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'English Teachers in G5',
SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 461 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'Math Male Teacher in G5',
SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 461 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'Math Female Teacher in G5',
SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0)) AS qty FROM teaching_assignment_summary pps WHERE  subject_standard_id = 461 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'Math Teachers in G5',
SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 462 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'Filipino Male Teacher in G5',
SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 462 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'Filipino Female Teacher in G5',
SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0)) AS qty FROM teaching_assignment_summary pps WHERE  subject_standard_id = 462 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'Filipino Teachers in G5',
SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 463 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'Science Male Teacher in G5',
SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 463 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'Science Female Teacher in G5',
SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0)) AS qty FROM teaching_assignment_summary pps WHERE  subject_standard_id = 463 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'Science Teachers in G5',
SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 1315 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'Sibika/Hekasi Male Teacher in G5',
SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 1315 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'Sibika/Hekasi Female Teacher in G5',
SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0)) AS qty FROM teaching_assignment_summary pps WHERE  subject_standard_id = 1315 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'Sibika/Hekasi Teachers in G5',
SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 1316 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'HE/EPP Male Teacher in G5',
SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 1316 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'HE/EPP Female Teacher in G5',
SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0)) AS qty FROM teaching_assignment_summary pps WHERE  subject_standard_id = 1316 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'HE/EPP Teachers in G5',
SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 1317 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'EKAWP Male Teacher in G5',
SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 1317 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'EKAWP Female Teacher in G5',
SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0)) AS qty FROM teaching_assignment_summary pps WHERE  subject_standard_id = 1317 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'EKAWP Teachers in G5',
SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 1318 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'MSEP Male Teacher in G5',
SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 1318 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'MESP Female Teacher in G5',
SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0)) AS qty FROM teaching_assignment_summary pps WHERE  subject_standard_id = 1318 and pps.category_level_id = 4300 and pps.level_id = 102 and pps.report_history_id = rh.id)) as 'MSEP Teachers in G5',

SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 460 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'English Male Teacher in G6',
SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 460 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'English Female Teacher in G6',
SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0)) AS qty FROM teaching_assignment_summary pps WHERE  subject_standard_id = 460 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'English Teachers in G6',
SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 461 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'Math Male Teacher in G6',
SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 461 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'Math Female Teacher in G6',
SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0)) AS qty FROM teaching_assignment_summary pps WHERE  subject_standard_id = 461 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'Math Teachers in G6',
SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 462 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'Filipino Male Teacher in G6',
SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 462 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'Filipino Female Teacher in G6',
SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0)) AS qty FROM teaching_assignment_summary pps WHERE  subject_standard_id = 462 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'Filipino Teachers in G6',
SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 463 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'Science Male Teacher in G6',
SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 463 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'Science Female Teacher in G6',
SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0)) AS qty FROM teaching_assignment_summary pps WHERE  subject_standard_id = 463 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'Science Teachers in G6',
SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 1315 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'Sibika/Hekasi Male Teacher in G6',
SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 1315 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'Sibika/Hekasi Female Teacher in G6',
SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0)) AS qty FROM teaching_assignment_summary pps WHERE  subject_standard_id = 1315 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'Sibika/Hekasi Teachers in G6',
SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 1316 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'HE/EPP Male Teacher in G6',
SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 1316 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'HE/EPP Female Teacher in G6',
SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0)) AS qty FROM teaching_assignment_summary pps WHERE  subject_standard_id = 1316 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'HE/EPP Teachers in G6',
SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 1317 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'EKAWP Male Teacher in G6',
SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 1317 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'EKAWP Female Teacher in G6',
SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0)) AS qty FROM teaching_assignment_summary pps WHERE  subject_standard_id = 1317 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'EKAWP Teachers in G6',
SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 1318 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'MSEP Male Teacher in G6',
SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 1318 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'MESP Female Teacher in G6',
SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0)) AS qty FROM teaching_assignment_summary pps WHERE  subject_standard_id = 1318 and pps.category_level_id = 4300 and pps.level_id = 103 and pps.report_history_id = rh.id)) as 'MSEP Teachers in G6'

FROM school_profile_history sph
LEFT JOIN ref_reports reports on (reports.co_genclass_id=sph.co_gen_class and reports.general_classification_id=sph.general_classification_id 
AND reports.ref_report_generics_id in (1))
-- 2011 to 2013  AND reports.ref_report_generics_id in (2))
LEFT JOIN ref_report_history rrh on (reports.id=rrh.report_id and rrh.sy_from = CAST(2016 AS CHAR))
LEFT JOIN report_history rh on (rh.ref_report_history_id = rrh.id and rh.school_id=sph.school_id and rh.report_status IN (301,302))

WHERE sph.SY_FROM = 2016 AND sph.general_classification_id = 7 AND sph.co_gen_class in (433) 
-- 2011 to 2013  AND sph.take_part_id in (2,3)
AND sph.take_part_id in (1,3)
AND sph.date_closed is null
GROUP BY sph.SCHOOL_ID
ORDER BY sph.SCHOOL_ID ASC
;
