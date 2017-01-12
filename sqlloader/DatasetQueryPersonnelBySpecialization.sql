-- 2010 to 2014
INSERT INTO `orsdb`.`personnel_byspecialization`
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

IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 460 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)),0) as 'English Teacher Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 460 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)),0) as 'English Teacher Not Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 460 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)),0) as 'English Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 461 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)),0) as 'Math Teacher Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 461 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)),0) as 'Math Teacher Not Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 461 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)),0) as 'Math Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 462 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)),0) as 'Filipino Teacher Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 462 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)),0) as 'Filipino Teacher Not Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 462 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)),0) as 'Filipino Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 464 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)),0) as 'General Science Teacher Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 464 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)),0) as 'General Science Teacher Not Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 464 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)),0) as 'General Science Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 465 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)),0) as 'Biology Teacher Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 465 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)),0) as 'Biology Teacher Not Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 465 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)),0) as 'Biology Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 466 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)),0) as 'Chemistry Teacher Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 466 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)),0) as 'Chemistry Teacher Not Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 466 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)),0) as 'Chemistry Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 467 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)),0) as 'Physics Teacher Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 467 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)),0) as 'Physics Teacher Not Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 467 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)),0) as 'Physics Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 469 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)),0) as 'Araling Panlipunan Teacher Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 469 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)),0) as 'Araling Panlipunan Teacher Not Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 469 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)),0) as 'Araling Panlipunan Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 470 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)),0) as 'TLE Teacher Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 470 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)),0) as 'TLE Teacher Not Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 470 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)),0) as 'TLE Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 237 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)),0) as 'Values Educ Teacher Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 237 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)),0) as 'Values Educ Teacher Not Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 237 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)),0) as 'Values Educ Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 480 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)),0) as 'Music and Arts Teacher Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 480 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)),0) as 'Music and Arts Teacher Not Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 480 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)),0) as 'Music and Arts Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 481 and pps.category_level_id = 4301 and pps.level_id = 490 and pps.report_history_id = rh.id)),0) as 'PE and Health Teacher Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 481 and pps.category_level_id= 4301 and pps.level_id = 491 and pps.report_history_id = rh.id)),0) as 'PE and Health Teacher Not Major/MinorTeacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.quantity,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 481 and pps.category_level_id= 4301 and pps.level_id in (490,491) and pps.report_history_id = rh.id)),0) as 'PE and Health Total Teacher'

FROM ebeisdb.school_profile_history sph
LEFT JOIN ebeisdb.ref_reports reports on (reports.co_genclass_id=sph.co_gen_class 
 and reports.general_classification_id=sph.general_classification_id 
 AND reports.ref_report_generics_id = if(sph.sy_from between 2016 and 2016, 2, 1))
LEFT JOIN ebeisdb.ref_report_history rrh on (reports.id=rrh.report_id and rrh.sy_from = CAST(sph.sy_from AS CHAR))
LEFT JOIN ebeisdb.report_history rh on (rh.ref_report_history_id = rrh.id and rh.school_id=sph.school_id 
 and rh.report_status IN (301,302))

WHERE sph.SY_FROM = 2016 AND sph.general_classification_id = 7 AND sph.co_gen_class in (434) AND sph.take_part_id in (1,2,3) 
 AND sph.date_closed is null
GROUP BY sph.sy_from, sph.SCHOOL_ID
ORDER BY sph.sy_from, sph.SCHOOL_ID ASC;

Commit;
