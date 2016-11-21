INSERT INTO `sisdbtest`.`personnel_locallyfunded`
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

SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (435,1307) and pps.fund_source_id= 92 and pps.report_history_id = rh.id)) as 'Kinder SEFProv ',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (435,1307) and pps.fund_source_id= 93 and pps.report_history_id = rh.id)) as 'Kinder SEFMmun ',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (435,1307) and pps.fund_source_id= 94 and pps.report_history_id = rh.id)) as 'Kinder LGU',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (435,1307) and pps.fund_source_id= 95 and pps.report_history_id = rh.id)) as 'Kinder PTA',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (435,1307) and pps.fund_source_id= 251 and pps.report_history_id = rh.id)) as 'Kinder Volunteer',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (435,1307) and pps.fund_source_id= 253 and pps.report_history_id = rh.id)) as 'Kinder Others',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (435,1307) and pps.fund_source_id in (92,93,94,95,251,253) and pps.report_history_id = rh.id)) as 'Kinder Total Fundsource',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (435,1307) and pps.fund_source_id= 341 and pps.report_history_id = rh.id)) as 'Kinder DepEd Subsidized',

SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (433,1308) and pps.fund_source_id= 92 and pps.report_history_id = rh.id)) as 'Elem SEFProv ',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (433,1308) and pps.fund_source_id= 93 and pps.report_history_id = rh.id)) as 'Elem SEFMmun ',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (433,1308) and pps.fund_source_id= 94 and pps.report_history_id = rh.id)) as 'Elem LGU',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (433,1308) and pps.fund_source_id= 95 and pps.report_history_id = rh.id)) as 'Elem PTA',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (433,1308) and pps.fund_source_id= 251 and pps.report_history_id = rh.id)) as 'Elem Volunteer',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (433,1308) and pps.fund_source_id= 253 and pps.report_history_id = rh.id)) as 'Elem Others',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (433,1308) and pps.fund_source_id in (92,93,94,95,251,253) and pps.report_history_id = rh.id)) as 'Elem Total Fundsource',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (433,1308) and pps.fund_source_id= 341 and pps.report_history_id = rh.id)) as 'Elem DepEd Subsidized',

SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (434,1312) and pps.fund_source_id= 92 and pps.report_history_id = rh.id)) as 'Sec SEFProv ',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (434,1312) and pps.fund_source_id= 93 and pps.report_history_id = rh.id)) as 'Sec SEFMmun ',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (434,1312) and pps.fund_source_id= 94 and pps.report_history_id = rh.id)) as 'Sec LGU',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (434,1312) and pps.fund_source_id= 95 and pps.report_history_id = rh.id)) as 'Sec PTA',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (434,1312) and pps.fund_source_id= 251 and pps.report_history_id = rh.id)) as 'Sec Volunteer',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (434,1312) and pps.fund_source_id= 253 and pps.report_history_id = rh.id)) as 'Sec Others',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (434,1312) and pps.fund_source_id in (92,93,94,95,251,253) and pps.report_history_id = rh.id)) as 'Sec Total Fundsource',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id in (434,1312) and pps.fund_source_id= 341 and pps.report_history_id = rh.id)) as 'Sec DepEd Subsidized',

SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id = 1310 and pps.fund_source_id= 92 and pps.report_history_id = rh.id)) as 'ALS SEFProv ',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id = 1310 and pps.fund_source_id= 93 and pps.report_history_id = rh.id)) as 'ALS SEFMmun ',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id = 1310 and pps.fund_source_id= 94 and pps.report_history_id = rh.id)) as 'ALS LGU',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id = 1310 and pps.fund_source_id= 95 and pps.report_history_id = rh.id)) as 'ALS PTA',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id = 1310 and pps.fund_source_id= 251 and pps.report_history_id = rh.id)) as 'ALS Volunteer',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id = 1310 and pps.fund_source_id= 253 and pps.report_history_id = rh.id)) as 'ALS Others',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id = 1310 and pps.fund_source_id in (92,93,94,95,251,253) and pps.report_history_id = rh.id)) as 'ALS Total Fundsource',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id = 1310 and pps.fund_source_id= 341 and pps.report_history_id = rh.id)) as 'ALS Subsidized',

SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id = 1311 and pps.fund_source_id= 92 and pps.report_history_id = rh.id)) as 'Alive SEFProv ',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id = 1311 and pps.fund_source_id= 93 and pps.report_history_id = rh.id)) as 'Alive SEFMmun ',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id = 1311 and pps.fund_source_id= 94 and pps.report_history_id = rh.id)) as 'Alive LGU',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id = 1311 and pps.fund_source_id= 95 and pps.report_history_id = rh.id)) as 'Alive PTA',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id = 1311 and pps.fund_source_id= 251 and pps.report_history_id = rh.id)) as 'Alive Volunteer',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id = 1311 and pps.fund_source_id= 253 and pps.report_history_id = rh.id)) as 'Alive Others',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id = 1311 and pps.fund_source_id in (92,93,94,95,251,253) and pps.report_history_id = rh.id)) as 'ALIVE Total Fundsource',
SUM((SELECT SUM(IFNULL(pps.total,0))  AS qty FROM personnel_localfund_summary pps WHERE pps.education_level_id = 1311 and pps.fund_source_id= 341 and pps.report_history_id = rh.id)) as 'ALS_Subsidized'


FROM school_profile_history sph
LEFT JOIN ref_reports reports on (reports.co_genclass_id=sph.co_gen_class and reports.general_classification_id=sph.general_classification_id AND reports.ref_report_generics_id in (2))
LEFT JOIN ref_report_history rrh on (reports.id=rrh.report_id and rrh.sy_from = CAST(2016 AS CHAR))
LEFT JOIN report_history rh on (rh.ref_report_history_id = rrh.id and rh.school_id=sph.school_id and rh.report_status IN (301,302))

WHERE sph.SY_FROM = 2016 AND sph.general_classification_id = 7 AND sph.co_gen_class in (433,434) 
AND sph.take_part_id in (2,3) 
AND sph.date_closed is null
GROUP BY sph.SCHOOL_ID
ORDER BY sph.SCHOOL_ID ASC

;
