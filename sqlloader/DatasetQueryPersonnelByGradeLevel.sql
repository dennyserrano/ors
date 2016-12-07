-- 2011 to 2014
INSERT INTO `orsdb`.`personnel_bygradelevel`
(
`sy_from`,
`school_id`,
`kmale_teacher`,
`kfemale_teacher`,
`ktotal_teacher`,
`g1male_teacher`,
`g1female_teacher`,
`g1total_teacher`,
`g2male_teacher`,
`g2female_teacher`,
`g2total_teacher`,
`g3male_teacher`,
`g3female_teacher`,
`g3total_teacher`,
`g4male_teacher`,
`g4female_teacher`,
`g4total_teacher`,
`g5male_teacher`,
`g5female_teacher`,
`g5total_teacher`,
`g6male_teacher`,
`g6female_teacher`,
`g6total_teacher`,
`spedmale_teacher`,
`spedfemale_teacher`,
`spedtotal_teacher`,
`total_male_teacher`,
`total_female_teacher`,
`total_teacher`)

SELECT
sph.sy_from AS SY_FROM,
sph.school_id AS SCHOOL_ID,

IFNULL(SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id = 172 and pps.level_id = 405 and pps.report_history_id = rh.id)),0) as 'Kinder Male Teacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id= 172 and pps.level_id = 405 and pps.report_history_id = rh.id)),0) as 'Kinder female Teacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id= 172 and pps.level_id = 405 and pps.report_history_id = rh.id)),0) as 'Kinder Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id = 172 and pps.level_id = 98 and pps.report_history_id = rh.id)),0) as 'G1 Male Teacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id= 172 and pps.level_id = 98 and pps.report_history_id = rh.id)),0) as 'G1 female Teacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id= 172 and pps.level_id = 98 and pps.report_history_id = rh.id)),0) as 'G1 Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id = 172 and pps.level_id = 99 and pps.report_history_id = rh.id)),0) as 'G2 Male Teacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id= 172 and pps.level_id = 99 and pps.report_history_id = rh.id)),0) as 'G2 female Teacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id= 172 and pps.level_id = 99 and pps.report_history_id = rh.id)),0) as 'G2 Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id = 172 and pps.level_id = 100 and pps.report_history_id = rh.id)),0) as 'G3 Male Teacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id= 172 and pps.level_id = 100 and pps.report_history_id = rh.id)),0) as 'G3 female Teacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id= 172 and pps.level_id = 100 and pps.report_history_id = rh.id)),0) as 'G3 Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id = 172 and pps.level_id = 101 and pps.report_history_id = rh.id)),0) as 'G4 Male Teacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id= 172 and pps.level_id = 101 and pps.report_history_id = rh.id)),0) as 'G4 female Teacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id= 172 and pps.level_id = 101 and pps.report_history_id = rh.id)),0) as 'G4 Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id = 172 and pps.level_id = 102 and pps.report_history_id = rh.id)),0) as 'G5 Male Teacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id= 172 and pps.level_id = 102 and pps.report_history_id = rh.id)),0) as 'G5 female Teacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id= 172 and pps.level_id = 102 and pps.report_history_id = rh.id)),0) as 'G5 Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id = 172 and pps.level_id = 103 and pps.report_history_id = rh.id)),0) as 'G6 Male Teacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id= 172 and pps.level_id = 103 and pps.report_history_id = rh.id)),0) as 'G6 female Teacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id= 172 and pps.level_id = 103 and pps.report_history_id = rh.id)),0) as 'G6 Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id = 172 and pps.level_id = 197 and pps.report_history_id = rh.id)),0) as 'SPED Male Teacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id= 172 and pps.level_id = 197 and pps.report_history_id = rh.id)),0) as 'SPED female Teacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id= 172 and pps.level_id = 197 and pps.report_history_id = rh.id)),0) as 'SPED Total Teacher',

IFNULL(SUM((SELECT SUM(IFNULL(pps.male,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id = 172 and pps.level_id in (405,98,99,100,101,102,103,197) and pps.report_history_id = rh.id)),0) as 'Total Male Teacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.female,0))  AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id= 172 and pps.level_id in (405,98,99,100,101,102,103,197) and pps.report_history_id = rh.id)),0) as 'Total Female Teacher',
IFNULL(SUM((SELECT SUM(IFNULL(pps.male,0)+IFNULL(pps.female,0))   AS qty FROM ebeisdb.teaching_assignment_summary pps WHERE pps.subject_standard_id = 597 and pps.category_level_id= 172 and pps.level_id in (405,98,99,100,101,102,103,197) and pps.report_history_id = rh.id)),0) as 'Total Teachers'


FROM ebeisdb.school_profile_history sph
LEFT JOIN ebeisdb.ref_reports reports on (reports.co_genclass_id=sph.co_gen_class 
 and reports.general_classification_id=sph.general_classification_id 
 AND reports.ref_report_generics_id = if(sph.sy_from between 2016 and 2016, 2, 1))
LEFT JOIN ebeisdb.ref_report_history rrh on (reports.id=rrh.report_id and rrh.sy_from = CAST(sph.sy_from AS CHAR))
LEFT JOIN ebeisdb.report_history rh on (rh.ref_report_history_id = rrh.id and rh.school_id=sph.school_id 
 and rh.report_status IN (301,302))

WHERE sph.SY_FROM = 2016 AND sph.general_classification_id = 7 AND sph.take_part_id in (1,2,3) AND sph.date_closed is null
 and sph.co_gen_class = 433
GROUP BY sph.sy_from, sph.SCHOOL_ID
ORDER BY sph.sy_from, sph.SCHOOL_ID ASC;

Commit;
