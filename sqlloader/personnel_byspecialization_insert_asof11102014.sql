-- 2010 to 2014
INSERT INTO `sisdbtest`.`personnel_byspecialization`
(
`sy_from`,
`school_id`,
`english_majorminor`,
`english_notmajorminor`,
`english_total`,
`math_majorminor`,
`math_notmajorminor`,
`math_total`,
`filipino_majorminor`,
`filipino_notmajorminor`,
`filipino_total`,
`gensci_majorminor`,
`gensci_notmajorminor`,
`gensci_total`,
`bio_majorminor`,
`bio_notmajorminor`,
`bio_total`,
`chem_majorminor`,
`chem_notmajorminor`,
`chem_total`,
`phys_majorminor`,
`phys_notmajorminor`,
`phys_total`,
`aral_majorminor`,
`aral_notmajorminor`,
`aral_total`,
`tle_majorminor`,
`tle_notmajorminor`,
`tle_total`,
`val_majorminor`,
`val_notmajorminor`,
`val_total`,
`musart_majorminor`,
`musart_notmajorminor`,
`musart_total`,
`pe_majorminor`,
`pe_notmajorminor`,
`pe_total`)
SELECT
sph.sy_from AS SY_FROM,
sph.school_id AS SCHOOL_ID,

SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 460 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)) as 'English Teacher Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 460 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)) as 'English Teacher Not Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 460 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)) as 'English Total Teacher',

SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 461 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)) as 'Math Teacher Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 461 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)) as 'Math Teacher Not Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 461 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)) as 'Math Total Teacher',

SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 462 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)) as 'Filipino Teacher Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 462 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)) as 'Filipino Teacher Not Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 462 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)) as 'Filipino Total Teacher',

SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 464 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)) as 'General Science Teacher Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 464 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)) as 'General Science Teacher Not Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 464 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)) as 'General Science Total Teacher',

SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 465 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)) as 'Biology Teacher Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 465 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)) as 'Biology Teacher Not Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 465 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)) as 'Biology Total Teacher',

SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 466 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)) as 'Chemistry Teacher Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 466 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)) as 'Chemistry Teacher Not Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 466 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)) as 'Chemistry Total Teacher',

SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 467 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)) as 'Physics Teacher Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 467 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)) as 'Physics Teacher Not Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 467 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)) as 'Physics Total Teacher',

SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 469 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)) as 'Araling Panlipunan Teacher Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 469 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)) as 'Araling Panlipunan Teacher Not Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 469 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)) as 'Araling Panlipunan Total Teacher',

SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 470 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)) as 'TLE Teacher Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 470 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)) as 'TLE Teacher Not Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 470 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)) as 'TLE Total Teacher',

SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 237 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)) as 'Values Educ Teacher Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 237 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)) as 'Values Educ Teacher Not Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 237 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)) as 'Values Educ Total Teacher',

SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 480 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)) as 'Music and Arts Teacher Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 480 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)) as 'Music and Arts Teacher Not Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 480 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)) as 'Music and Arts Total Teacher',

SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 481 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)) as 'PE and Health Teacher Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 481 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)) as 'PE and Health Teacher Not Major/MinorTeacher',
SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM teaching_assignment_summary pps WHERE pps.subject_standard_id = 481 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)) as 'PE and Health Total Teacher'

FROM school_profile_history sph
LEFT JOIN ref_reports reports on (reports.co_genclass_id=sph.co_gen_class and reports.general_classification_id=sph.general_classification_id AND reports.ref_report_generics_id in (2))
LEFT JOIN ref_report_history rrh on (reports.id=rrh.report_id and rrh.sy_from = CAST(2016 AS CHAR))
LEFT JOIN report_history rh on (rh.ref_report_history_id = rrh.id and rh.school_id=sph.school_id and rh.report_status IN (301,302))

WHERE sph.SY_FROM = 2016 AND sph.general_classification_id = 7 AND sph.co_gen_class in in (434) 
AND sph.take_part_id in (2,3) 
AND sph.date_closed is null
GROUP BY sph.SCHOOL_ID
ORDER BY sph.SCHOOL_ID ASC

;
