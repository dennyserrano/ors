INSERT INTO `orsdb`.`personnel_locallyfunded`
(
`sy_from`,
`school_id`,
`kinder_sefprov`,
`kinder_sefmun`,
`kinder_lgu`,
`kinder_pta`,
`kinder_volunteer`,
`kinder_others`,
`kinder_total_funds`,
`kinder_deped`,
`elem_sefprov`,
`elem_sefmun`,
`elem_lgu`,
`elem_pta`,
`elem_volunteer`,
`elem_others`,
`elem_total_funds`,
`elem_deped`,
`sec_sefprov`,
`sec_sefmun`,
`sec_lgu`,
`sec_pta`,
`sec_volunteer`,
`sec_others`,
`sec_total_funds`,
`sec_deped`,
`als_sefprov`,
`als_sefmun`,
`als_lgu`,
`als_pta`,
`als_volunteer`,
`als_others`,
`als_total_funds`,
`als_deped`,
`alive_sefprov`,
`alive_sefmun`,
`alive_lgu`,
`alive_pta`,
`alive_volunteer`,
`alive_others`,
`alive_total_funds`,
`alive_deped`)


SELECT
sph.sy_from AS SY_FROM,
sph.school_id AS SCHOOL_ID,

IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (435,1307) and pps.fund_source_id= 92 and pps.report_history_id = rh.id)),0) as 'Kinder SEFProv ',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (435,1307) and pps.fund_source_id= 93 and pps.report_history_id = rh.id)),0) as 'Kinder SEFMmun ',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (435,1307) and pps.fund_source_id= 94 and pps.report_history_id = rh.id)),0) as 'Kinder LGU',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (435,1307) and pps.fund_source_id= 95 and pps.report_history_id = rh.id)),0) as 'Kinder PTA',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (435,1307) and pps.fund_source_id= 251 and pps.report_history_id = rh.id)),0) as 'Kinder Volunteer',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (435,1307) and pps.fund_source_id= 253 and pps.report_history_id = rh.id)),0) as 'Kinder Others',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (435,1307) and pps.fund_source_id in (92,93,94,95,251,253) and pps.report_history_id = rh.id)),0) as 'Kinder Total Fundsource',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (435,1307) and pps.fund_source_id= 341 and pps.report_history_id = rh.id)),0) as 'Kinder DepEd Subsidized',

IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (433,1308) and pps.fund_source_id= 92 and pps.report_history_id = rh.id)),0) as 'Elem SEFProv ',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (433,1308) and pps.fund_source_id= 93 and pps.report_history_id = rh.id)),0) as 'Elem SEFMmun ',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (433,1308) and pps.fund_source_id= 94 and pps.report_history_id = rh.id)),0) as 'Elem LGU',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (433,1308) and pps.fund_source_id= 95 and pps.report_history_id = rh.id)),0) as 'Elem PTA',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (433,1308) and pps.fund_source_id= 251 and pps.report_history_id = rh.id)),0) as 'Elem Volunteer',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (433,1308) and pps.fund_source_id= 253 and pps.report_history_id = rh.id)),0) as 'Elem Others',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (433,1308) and pps.fund_source_id in (92,93,94,95,251,253) and pps.report_history_id = rh.id)),0) as 'Elem Total Fundsource',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (433,1308) and pps.fund_source_id= 341 and pps.report_history_id = rh.id)),0) as 'Elem DepEd Subsidized',

IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (434,1312) and pps.fund_source_id= 92 and pps.report_history_id = rh.id)),0) as 'Sec SEFProv ',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (434,1312) and pps.fund_source_id= 93 and pps.report_history_id = rh.id)),0) as 'Sec SEFMmun ',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (434,1312) and pps.fund_source_id= 94 and pps.report_history_id = rh.id)),0) as 'Sec LGU',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (434,1312) and pps.fund_source_id= 95 and pps.report_history_id = rh.id)),0) as 'Sec PTA',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (434,1312) and pps.fund_source_id= 251 and pps.report_history_id = rh.id)),0) as 'Sec Volunteer',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (434,1312) and pps.fund_source_id= 253 and pps.report_history_id = rh.id)),0) as 'Sec Others',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (434,1312) and pps.fund_source_id in (92,93,94,95,251,253) and pps.report_history_id = rh.id)),0) as 'Sec Total Fundsource',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id in (434,1312) and pps.fund_source_id= 341 and pps.report_history_id = rh.id)),0) as 'Sec DepEd Subsidized',

IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id = 1310 and pps.fund_source_id= 92 and pps.report_history_id = rh.id)),0) as 'ALS SEFProv ',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id = 1310 and pps.fund_source_id= 93 and pps.report_history_id = rh.id)),0) as 'ALS SEFMmun ',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id = 1310 and pps.fund_source_id= 94 and pps.report_history_id = rh.id)),0) as 'ALS LGU',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id = 1310 and pps.fund_source_id= 95 and pps.report_history_id = rh.id)),0) as 'ALS PTA',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id = 1310 and pps.fund_source_id= 251 and pps.report_history_id = rh.id)),0) as 'ALS Volunteer',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id = 1310 and pps.fund_source_id= 253 and pps.report_history_id = rh.id)),0) as 'ALS Others',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id = 1310 and pps.fund_source_id in (92,93,94,95,251,253) and pps.report_history_id = rh.id)),0) as 'ALS Total Fundsource',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id = 1310 and pps.fund_source_id= 341 and pps.report_history_id = rh.id)),0) as 'ALS Subsidized',

IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id = 1311 and pps.fund_source_id= 92 and pps.report_history_id = rh.id)),0) as 'Alive SEFProv ',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id = 1311 and pps.fund_source_id= 93 and pps.report_history_id = rh.id)),0) as 'Alive SEFMmun ',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id = 1311 and pps.fund_source_id= 94 and pps.report_history_id = rh.id)),0) as 'Alive LGU',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id = 1311 and pps.fund_source_id= 95 and pps.report_history_id = rh.id)),0) as 'Alive PTA',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id = 1311 and pps.fund_source_id= 251 and pps.report_history_id = rh.id)),0) as 'Alive Volunteer',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id = 1311 and pps.fund_source_id= 253 and pps.report_history_id = rh.id)),0) as 'Alive Others',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id = 1311 and pps.fund_source_id in (92,93,94,95,251,253) and pps.report_history_id = rh.id)),0) as 'ALIVE Total Fundsource',
IFNULL(SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM ebeisdb.personnel_localfund_summary pps WHERE pps.education_level_id = 1311 and pps.fund_source_id= 341 and pps.report_history_id = rh.id)),0) as 'ALS_Subsidized'

FROM ebeisdb.school_profile_history sph
LEFT JOIN ebeisdb.ref_reports reports on (reports.co_genclass_id=sph.co_gen_class 
 and reports.general_classification_id=sph.general_classification_id 
 AND reports.ref_report_generics_id = if(sph.sy_from between 2016 and 2016, 2, 1))
LEFT JOIN ebeisdb.ref_report_history rrh on (reports.id=rrh.report_id and rrh.sy_from = CAST(sph.sy_from AS CHAR))
LEFT JOIN ebeisdb.report_history rh on (rh.ref_report_history_id = rrh.id and rh.school_id=sph.school_id 
 and rh.report_status IN (301,302))

WHERE sph.general_classification_id = 7 AND sph.take_part_id in (1,2,3) AND sph.date_closed is null and sph.sy_from = 2016
GROUP BY sph.sy_from, sph.SCHOOL_ID
ORDER BY sph.sy_from, sph.SCHOOL_ID ASC;

commit;
