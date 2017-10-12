INSERT INTO orsdb.shs_tvl
(
sy_from,
school_id,
g11male_ASI,
 g11female_ASI,
 g11_TOT_ASI,
 g11male_ASII,
 g11female_ASII,
 g11_TOT_ASII,
 g11male_CARTII,
 g11female_CARTII,
 g11_TOT_CARTII,
 g11male_CARTIII,
 g11female_CARTIII,
 g11_TOT_CARTIII,
 g11male_CP,
 g11female_CP,
 g11_TOT_CP,
 g11male_DOMRAC,
 g11female_DOMRAC,
 g11_TOT_DOMRAC,
 g11male_EIM,
 g11female_EIM,
 g11_TOT_EIM,
 g11male_EPDLC,
 g11female_EPDLC,
 g11_TOT_EPDLC,
 g11male_EPAS,
 g11female_EPAS,
 g11_TOT_EPAS,
 g11male_FM,
 g11female_FM,
 g11_TOT_FM,
 g11male_ICS,
 g11female_ICS,
 g11_TOT_ICS,
 g11male_GMAW,
 g11female_GMAW,
 g11_TOT_GMAW,
 g11male_GTAW,
 g11female_GTAW,
 g11_TOT_GTAW,
 g11male_MACHI,
 g11female_MACHI,
 g11_TOT_MACHI,
 g11male_MACHII,
 g11female_MACHII,
 g11_TOT_MACHII,
 g11male_MSN,
 g11female_MSN,
 g11_TOT_MSN,
 g11male_MS,
 g11female_MS,
 g11_TOT_MS,
 g11male_SES,
 g11female_SES,
 g11_TOT_SES,
 g11male_PLUMI,
 g11female_PLUMI,
 g11_TOT_PLUMI,
 g11male_PLUMII,
 g11female_PLUMII,
 g11_TOT_PLUMII,
 g11male_PACU,
 g11female_PACU,
 g11_TOT_PACU,
 g11male_SMAWI,
 g11female_SMAWI,
 g11_TOT_SMAWI,
 g11male_SMAWII,
 g11female_SMAWII,
 g11_TOT_SMAWII,
 g11male_TILE,
 g11female_TILE,
 g11_TOT_TILE,
 g11male_TLIM,
 g11female_TLIM,
 g11_TOT_TLIM,
g12male_ASI,
 g12female_ASI,
 g12_TOT_ASI,
 g12male_ASII,
 g12female_ASII,
 g12_TOT_ASII,
 g12male_CARTII,
 g12female_CARTII,
 g12_TOT_CARTII,
 g12male_CARTIII,
 g12female_CARTIII,
 g12_TOT_CARTIII,
 g12male_CP,
 g12female_CP,
 g12_TOT_CP,
 g12male_DOMRAC,
 g12female_DOMRAC,
 g12_TOT_DOMRAC,
 g12male_EIM,
 g12female_EIM,
 g12_TOT_EIM,
 g12male_EPDLC,
 g12female_EPDLC,
 g12_TOT_EPDLC,
 g12male_EPAS,
 g12female_EPAS,
 g12_TOT_EPAS,
 g12male_FM,
 g12female_FM,
 g12_TOT_FM,
 g12male_ICS,
 g12female_ICS,
 g12_TOT_ICS,
 g12male_GMAW,
 g12female_GMAW,
 g12_TOT_GMAW,
 g12male_GTAW,
 g12female_GTAW,
 g12_TOT_GTAW,
 g12male_MACHI,
 g12female_MACHI,
 g12_TOT_MACHI,
 g12male_MACHII,
 g12female_MACHII,
 g12_TOT_MACHII,
 g12male_MSN,
 g12female_MSN,
 g12_TOT_MSN,
 g12male_MS,
 g12female_MS,
 g12_TOT_MS,
 g12male_SES,
 g12female_SES,
 g12_TOT_SES,
 g12male_PLUMI,
 g12female_PLUMI,
 g12_TOT_PLUMI,
 g12male_PLUMII,
 g12female_PLUMII,
 g12_TOT_PLUMII,
 g12male_PACU,
 g12female_PACU,
 g12_TOT_PACU,
 g12male_SMAWI,
 g12female_SMAWI,
 g12_TOT_SMAWI,
 g12male_SMAWII,
 g12female_SMAWII,
 g12_TOT_SMAWII,
 g12male_TILE,
 g12female_TILE,
 g12_TOT_TILE,
 g12male_TLIM,
 g12female_TLIM,
 g12_TOT_TLIM




)


SELECT
sph.sy_from,
sph.school_id,
 (
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=16
    AND A.report_history_id=rh.id)
) as g11male_ASI,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=16
    AND A.report_history_id=rh.id)
) as g11female_ASI,
(
	@totalA+@totalB
) as g11_TOT_ASI,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=17
    AND A.report_history_id=rh.id)
) as g11male_ASII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=17
    AND A.report_history_id=rh.id)
) as g11female_ASII,
(
	@totalA+@totalB
) as g11_TOT_ASII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=28
    AND A.report_history_id=rh.id)
) as g11male_CARTII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=28
    AND A.report_history_id=rh.id)
) as g11female_CARTII,
(
	@totalA+@totalB
) as g11_TOT_CARTII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=29
    AND A.report_history_id=rh.id)
) as g11male_CARTIII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=29
    AND A.report_history_id=rh.id)
) as g11female_CARTIII,
(
	@totalA+@totalB
) as g11_TOT_CARTIII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=34
    AND A.report_history_id=rh.id)
) as g11male_CP,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=34
    AND A.report_history_id=rh.id)
) as g11female_CP,
(
	@totalA+@totalB
) as g11_TOT_CP,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=48
    AND A.report_history_id=rh.id)
) as g11male_DOMRAC,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=48
    AND A.report_history_id=rh.id)
) as g11female_DOMRAC,
(
	@totalA+@totalB
) as g11_TOT_DOMRAC,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=56
    AND A.report_history_id=rh.id)
) as g11male_EIM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=56
    AND A.report_history_id=rh.id)
) as g11female_EIM,
(
	@totalA+@totalB
) as g11_TOT_EIM,

(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=55
    AND A.report_history_id=rh.id)
) as g11male_EPDLC,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=55
    AND A.report_history_id=rh.id)
) as g11female_EPDLC,
(
	@totalA+@totalB
) as g11_TOT_EPDLC,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=57
    AND A.report_history_id=rh.id)
) as g11male_EPAS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=57
    AND A.report_history_id=rh.id)
) as g11female_EPAS,
(
	@totalA+@totalB
) as g11_TOT_EPAS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=77
    AND A.report_history_id=rh.id)
) as g11male_FM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=77
    AND A.report_history_id=rh.id)
) as g11female_FM,
(
	@totalA+@totalB
) as g11_TOT_FM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=100
    AND A.report_history_id=rh.id)
) as g11male_ICS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=100
    AND A.report_history_id=rh.id)
) as g11female_ICS,
(
	@totalA+@totalB
) as g11_TOT_ICS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=78
    AND A.report_history_id=rh.id)
) as g11male_GMAW,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=78
    AND A.report_history_id=rh.id)
) as g11female_GMAW,
(
	@totalA+@totalB
) as g11_TOT_GMAW,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=79
    AND A.report_history_id=rh.id)
) as g11male_GTAW,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=79
    AND A.report_history_id=rh.id)
) as g11female_GTAW,
(
	@totalA+@totalB
) as g11_TOT_GTAW,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=110
    AND A.report_history_id=rh.id)
) as g11male_MACHI,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=110
    AND A.report_history_id=rh.id)
) as g11female_MACHI,
(
	@totalA+@totalB
) as g11_TOT_MACHI,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=111
    AND A.report_history_id=rh.id)
) as g11male_MACHII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=111
    AND A.report_history_id=rh.id)
) as g11female_MACHII,
(
	@totalA+@totalB
) as g11_TOT_MACHII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=112
    AND A.report_history_id=rh.id)
) as g11male_MSN,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=112
    AND A.report_history_id=rh.id)
) as g11female_MSN,
(
	@totalA+@totalB
) as g11_TOT_MSN,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=113
    AND A.report_history_id=rh.id)
) as g11male_MS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=113
    AND A.report_history_id=rh.id)
) as g11female_MS,
(
	@totalA+@totalB
) as g11_TOT_MS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=118
    AND A.report_history_id=rh.id)
) as g11male_SES,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=118
    AND A.report_history_id=rh.id)
) as g11female_SES,
(
	@totalA+@totalB
) as g11_TOT_SES,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=131
    AND A.report_history_id=rh.id)
) as g11male_PLUMI,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=131
    AND A.report_history_id=rh.id)
) as g11female_PLUMI,
(
	@totalA+@totalB
) as g11_TOT_PLUMI,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=132
    AND A.report_history_id=rh.id)
) as g11male_PLUMII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=132
    AND A.report_history_id=rh.id)
) as g11female_PLUMII,
(
	@totalA+@totalB
) as g11_TOT_PLUMII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=143
    AND A.report_history_id=rh.id)
) as g11male_PACU,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=143
    AND A.report_history_id=rh.id)
) as g11female_PACU,
(
	@totalA+@totalB
) as g11_TOT_PACU,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=148
    AND A.report_history_id=rh.id)
) as g11male_SMAWI,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=148
    AND A.report_history_id=rh.id)
) as g11female_SMAWI,
(
	@totalA+@totalB
) as g11_TOT_SMAWI,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=149
    AND A.report_history_id=rh.id)
) as g11male_SMAWII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=149
    AND A.report_history_id=rh.id)
) as g11female_SMAWII,
(
	@totalA+@totalB
) as g11_TOT_SMAWII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=159
    AND A.report_history_id=rh.id)
) as g11male_TILE,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=159
    AND A.report_history_id=rh.id)
) as g11female_TILE,
(
	@totalA+@totalB
) as g11_TOT_TILE,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=161
    AND A.report_history_id=rh.id)
) as g11male_TLIM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=161
    AND A.report_history_id=rh.id)
) as g11female_TLIM,
(
	@totalA+@totalB
) as g11_TOT_TLIM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=16
    AND A.report_history_id=rh.id)
) as g12male_ASI,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=16
    AND A.report_history_id=rh.id)
) as g12female_ASI,
(
	@totalA+@totalB
) as g12_TOT_ASI,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=17
    AND A.report_history_id=rh.id)
) as g12male_ASII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=17
    AND A.report_history_id=rh.id)
) as g12female_ASII,
(
	@totalA+@totalB
) as g12_TOT_ASII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=28
    AND A.report_history_id=rh.id)
) as g12male_CARTII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=28
    AND A.report_history_id=rh.id)
) as g12female_CARTII,
(
	@totalA+@totalB
) as g12_TOT_CARTII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=29
    AND A.report_history_id=rh.id)
) as g12male_CARTIII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=29
    AND A.report_history_id=rh.id)
) as g12female_CARTIII,
(
	@totalA+@totalB
) as g12_TOT_CARTIII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=34
    AND A.report_history_id=rh.id)
) as g12male_CP,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=34
    AND A.report_history_id=rh.id)
) as g12female_CP,
(
	@totalA+@totalB
) as g12_TOT_CP,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=48
    AND A.report_history_id=rh.id)
) as g12male_DOMRAC,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=48
    AND A.report_history_id=rh.id)
) as g12female_DOMRAC,
(
	@totalA+@totalB
) as g12_TOT_DOMRAC,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=56
    AND A.report_history_id=rh.id)
) as g12male_EIM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=56
    AND A.report_history_id=rh.id)
) as g12female_EIM,
(
	@totalA+@totalB
) as g12_TOT_EIM,

(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=55
    AND A.report_history_id=rh.id)
) as g12male_EPDLC,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=55
    AND A.report_history_id=rh.id)
) as g12female_EPDLC,
(
	@totalA+@totalB
) as g12_TOT_EPDLC,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=57
    AND A.report_history_id=rh.id)
) as g12male_EPAS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=57
    AND A.report_history_id=rh.id)
) as g12female_EPAS,
(
	@totalA+@totalB
) as g12_TOT_EPAS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=77
    AND A.report_history_id=rh.id)
) as g12male_FM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=77
    AND A.report_history_id=rh.id)
) as g12female_FM,
(
	@totalA+@totalB
) as g12_TOT_FM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=100
    AND A.report_history_id=rh.id)
) as g12male_ICS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=100
    AND A.report_history_id=rh.id)
) as g12female_ICS,
(
	@totalA+@totalB
) as g12_TOT_ICS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=78
    AND A.report_history_id=rh.id)
) as g12male_GMAW,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=78
    AND A.report_history_id=rh.id)
) as g12female_GMAW,
(
	@totalA+@totalB
) as g12_TOT_GMAW,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=79
    AND A.report_history_id=rh.id)
) as g12male_GTAW,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=79
    AND A.report_history_id=rh.id)
) as g12female_GTAW,
(
	@totalA+@totalB
) as g12_TOT_GTAW,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=120
    AND A.report_history_id=rh.id)
) as g12male_MACHI,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=120
    AND A.report_history_id=rh.id)
) as g12female_MACHI,
(
	@totalA+@totalB
) as g12_TOT_MACHI,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=121
    AND A.report_history_id=rh.id)
) as g12male_MACHII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=121
    AND A.report_history_id=rh.id)
) as g12female_MACHII,
(
	@totalA+@totalB
) as g12_TOT_MACHII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=122
    AND A.report_history_id=rh.id)
) as g12male_MSN,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=122
    AND A.report_history_id=rh.id)
) as g12female_MSN,
(
	@totalA+@totalB
) as g12_TOT_MSN,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=123
    AND A.report_history_id=rh.id)
) as g12male_MS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=123
    AND A.report_history_id=rh.id)
) as g12female_MS,
(
	@totalA+@totalB
) as g12_TOT_MS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=128
    AND A.report_history_id=rh.id)
) as g12male_SES,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=128
    AND A.report_history_id=rh.id)
) as g12female_SES,
(
	@totalA+@totalB
) as g12_TOT_SES,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=131
    AND A.report_history_id=rh.id)
) as g12male_PLUMI,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=131
    AND A.report_history_id=rh.id)
) as g12female_PLUMI,
(
	@totalA+@totalB
) as g12_TOT_PLUMI,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=132
    AND A.report_history_id=rh.id)
) as g12male_PLUMII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=132
    AND A.report_history_id=rh.id)
) as g12female_PLUMII,
(
	@totalA+@totalB
) as g12_TOT_PLUMII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=143
    AND A.report_history_id=rh.id)
) as g12male_PACU,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=143
    AND A.report_history_id=rh.id)
) as g12female_PACU,
(
	@totalA+@totalB
) as g12_TOT_PACU,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=148
    AND A.report_history_id=rh.id)
) as g12male_SMAWI,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=148
    AND A.report_history_id=rh.id)
) as g12female_SMAWI,
(
	@totalA+@totalB
) as g12_TOT_SMAWI,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=149
    AND A.report_history_id=rh.id)
) as g12male_SMAWII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=149
    AND A.report_history_id=rh.id)
) as g12female_SMAWII,
(
	@totalA+@totalB
) as g12_TOT_SMAWII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=159
    AND A.report_history_id=rh.id)
) as g12male_TILE,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=159
    AND A.report_history_id=rh.id)
) as g12female_TILE,
(
	@totalA+@totalB
) as g12_TOT_TILE,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=161
    AND A.report_history_id=rh.id)
) as g12male_TLIM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=161
    AND A.report_history_id=rh.id)
) as g12female_TLIM,
(
	@totalA+@totalB
) as g12_TOT_TLIM





FROM ebeisdb.school_profile_history sph
   LEFT JOIN ebeisdb.ref_region rr ON (rr.id=sph.region_id)
   LEFT JOIN (ebeisdb.report_history rh
                     inner join ebeisdb.ref_report_history rrh on 
rh.ref_report_history_id = rrh.id
                     inner join ebeisdb.ref_reports rrs on rrs.id  = 
rrh.report_id
                     inner join ebeisdb.ref_report_generics rrg on rrg.id 
= rrs.ref_report_generics_id and rrg.id=1
               ) on rh.school_id = sph.school_id and rh.sy_from= 
sph.sy_from and rh.report_status >= 297 -- cast( sph.sy_from as unsigned) 
 
               and rh.report_id in (7,8,9,33)
              
  
   WHERE 
   -- sph.take_part_id = 1 and 
   sph.sy_from = 2016 and 
   -- secondary only
   sph.co_gen_class=434 
   -- for senior highschool offering codes 
   and sph.curricular_class_id > 900 
   GROUP BY sph.SCHOOL_ID
   ORDER BY sph.SY_FROM, rr.RANK ASC, sph.SCHOOL_ID ASC

ON DUPLICATE KEY UPDATE

g11male_ASI=VALUES(g11male_ASI),
 g11female_ASI=VALUES( g11female_ASI),
 g11_TOT_ASI=VALUES( g11_TOT_ASI),
 g11male_ASII=VALUES( g11male_ASII),
 g11female_ASII=VALUES( g11female_ASII),
 g11_TOT_ASII=VALUES( g11_TOT_ASII),
 g11male_CARTII=VALUES( g11male_CARTII),
 g11female_CARTII=VALUES( g11female_CARTII),
 g11_TOT_CARTII=VALUES( g11_TOT_CARTII),
 g11male_CARTIII=VALUES( g11male_CARTIII),
 g11female_CARTIII=VALUES( g11female_CARTIII),
 g11_TOT_CARTIII=VALUES( g11_TOT_CARTIII),
 g11male_CP=VALUES( g11male_CP),
 g11female_CP=VALUES( g11female_CP),
 g11_TOT_CP=VALUES( g11_TOT_CP),
 g11male_DOMRAC=VALUES( g11male_DOMRAC),
 g11female_DOMRAC=VALUES( g11female_DOMRAC),
 g11_TOT_DOMRAC=VALUES( g11_TOT_DOMRAC),
 g11male_EIM=VALUES( g11male_EIM),
 g11female_EIM=VALUES( g11female_EIM),
 g11_TOT_EIM=VALUES( g11_TOT_EIM),
 g11male_EPDLC=VALUES( g11male_EPDLC),
 g11female_EPDLC=VALUES( g11female_EPDLC),
 g11_TOT_EPDLC=VALUES( g11_TOT_EPDLC),
 g11male_EPAS=VALUES( g11male_EPAS),
 g11female_EPAS=VALUES( g11female_EPAS),
 g11_TOT_EPAS=VALUES( g11_TOT_EPAS),
 g11male_FM=VALUES( g11male_FM),
 g11female_FM=VALUES( g11female_FM),
 g11_TOT_FM=VALUES( g11_TOT_FM),
 g11male_ICS=VALUES( g11male_ICS),
 g11female_ICS=VALUES( g11female_ICS),
 g11_TOT_ICS=VALUES( g11_TOT_ICS),
 g11male_GMAW=VALUES( g11male_GMAW),
 g11female_GMAW=VALUES( g11female_GMAW),
 g11_TOT_GMAW=VALUES( g11_TOT_GMAW),
 g11male_GTAW=VALUES( g11male_GTAW),
 g11female_GTAW=VALUES( g11female_GTAW),
 g11_TOT_GTAW=VALUES( g11_TOT_GTAW),
 g11male_MACHI=VALUES( g11male_MACHI),
 g11female_MACHI=VALUES( g11female_MACHI),
 g11_TOT_MACHI=VALUES( g11_TOT_MACHI),
 g11male_MACHII=VALUES( g11male_MACHII),
 g11female_MACHII=VALUES( g11female_MACHII),
 g11_TOT_MACHII=VALUES( g11_TOT_MACHII),
 g11male_MSN=VALUES( g11male_MSN),
 g11female_MSN=VALUES( g11female_MSN),
 g11_TOT_MSN=VALUES( g11_TOT_MSN),
 g11male_MS=VALUES( g11male_MS),
 g11female_MS=VALUES( g11female_MS),
 g11_TOT_MS=VALUES( g11_TOT_MS),
 g11male_SES=VALUES( g11male_SES),
 g11female_SES=VALUES( g11female_SES),
 g11_TOT_SES=VALUES( g11_TOT_SES),
 g11male_PLUMI=VALUES( g11male_PLUMI),
 g11female_PLUMI=VALUES( g11female_PLUMI),
 g11_TOT_PLUMI=VALUES( g11_TOT_PLUMI),
 g11male_PLUMII=VALUES( g11male_PLUMII),
 g11female_PLUMII=VALUES( g11female_PLUMII),
 g11_TOT_PLUMII=VALUES( g11_TOT_PLUMII),
 g11male_PACU=VALUES( g11male_PACU),
 g11female_PACU=VALUES( g11female_PACU),
 g11_TOT_PACU=VALUES( g11_TOT_PACU),
 g11male_SMAWI=VALUES( g11male_SMAWI),
 g11female_SMAWI=VALUES( g11female_SMAWI),
 g11_TOT_SMAWI=VALUES( g11_TOT_SMAWI),
 g11male_SMAWII=VALUES( g11male_SMAWII),
 g11female_SMAWII=VALUES( g11female_SMAWII),
 g11_TOT_SMAWII=VALUES( g11_TOT_SMAWII),
 g11male_TILE=VALUES( g11male_TILE),
 g11female_TILE=VALUES( g11female_TILE),
 g11_TOT_TILE=VALUES( g11_TOT_TILE),
 g11male_TLIM=VALUES( g11male_TLIM),
 g11female_TLIM=VALUES( g11female_TLIM),
 g11_TOT_TLIM=VALUES( g11_TOT_TLIM),
 g12male_ASI=VALUES( g12male_ASI),
 g12female_ASI=VALUES( g12female_ASI),
 g12_TOT_ASI=VALUES( g12_TOT_ASI),
 g12male_ASII=VALUES( g12male_ASII),
 g12female_ASII=VALUES( g12female_ASII),
 g12_TOT_ASII=VALUES( g12_TOT_ASII),
 g12male_CARTII=VALUES( g12male_CARTII),
 g12female_CARTII=VALUES( g12female_CARTII),
 g12_TOT_CARTII=VALUES( g12_TOT_CARTII),
 g12male_CARTIII=VALUES( g12male_CARTIII),
 g12female_CARTIII=VALUES( g12female_CARTIII),
 g12_TOT_CARTIII=VALUES( g12_TOT_CARTIII),
 g12male_CP=VALUES( g12male_CP),
 g12female_CP=VALUES( g12female_CP),
 g12_TOT_CP=VALUES( g12_TOT_CP),
 g12male_DOMRAC=VALUES( g12male_DOMRAC),
 g12female_DOMRAC=VALUES( g12female_DOMRAC),
 g12_TOT_DOMRAC=VALUES( g12_TOT_DOMRAC),
 g12male_EIM=VALUES( g12male_EIM),
 g12female_EIM=VALUES( g12female_EIM),
 g12_TOT_EIM=VALUES( g12_TOT_EIM),
 g12male_EPDLC=VALUES( g12male_EPDLC),
 g12female_EPDLC=VALUES( g12female_EPDLC),
 g12_TOT_EPDLC=VALUES( g12_TOT_EPDLC),
 g12male_EPAS=VALUES( g12male_EPAS),
 g12female_EPAS=VALUES( g12female_EPAS),
 g12_TOT_EPAS=VALUES( g12_TOT_EPAS),
 g12male_FM=VALUES( g12male_FM),
 g12female_FM=VALUES( g12female_FM),
 g12_TOT_FM=VALUES( g12_TOT_FM),
 g12male_ICS=VALUES( g12male_ICS),
 g12female_ICS=VALUES( g12female_ICS),
 g12_TOT_ICS=VALUES( g12_TOT_ICS),
 g12male_GMAW=VALUES( g12male_GMAW),
 g12female_GMAW=VALUES( g12female_GMAW),
 g12_TOT_GMAW=VALUES( g12_TOT_GMAW),
 g12male_GTAW=VALUES( g12male_GTAW),
 g12female_GTAW=VALUES( g12female_GTAW),
 g12_TOT_GTAW=VALUES( g12_TOT_GTAW),
 g12male_MACHI=VALUES( g12male_MACHI),
 g12female_MACHI=VALUES( g12female_MACHI),
 g12_TOT_MACHI=VALUES( g12_TOT_MACHI),
 g12male_MACHII=VALUES( g12male_MACHII),
 g12female_MACHII=VALUES( g12female_MACHII),
 g12_TOT_MACHII=VALUES( g12_TOT_MACHII),
 g12male_MSN=VALUES( g12male_MSN),
 g12female_MSN=VALUES( g12female_MSN),
 g12_TOT_MSN=VALUES( g12_TOT_MSN),
 g12male_MS=VALUES( g12male_MS),
 g12female_MS=VALUES( g12female_MS),
 g12_TOT_MS=VALUES( g12_TOT_MS),
 g12male_SES=VALUES( g12male_SES),
 g12female_SES=VALUES( g12female_SES),
 g12_TOT_SES=VALUES( g12_TOT_SES),
 g12male_PLUMI=VALUES( g12male_PLUMI),
 g12female_PLUMI=VALUES( g12female_PLUMI),
 g12_TOT_PLUMI=VALUES( g12_TOT_PLUMI),
 g12male_PLUMII=VALUES( g12male_PLUMII),
 g12female_PLUMII=VALUES( g12female_PLUMII),
 g12_TOT_PLUMII=VALUES( g12_TOT_PLUMII),
 g12male_PACU=VALUES( g12male_PACU),
 g12female_PACU=VALUES( g12female_PACU),
 g12_TOT_PACU=VALUES( g12_TOT_PACU),
 g12male_SMAWI=VALUES( g12male_SMAWI),
 g12female_SMAWI=VALUES( g12female_SMAWI),
 g12_TOT_SMAWI=VALUES( g12_TOT_SMAWI),
 g12male_SMAWII=VALUES( g12male_SMAWII),
 g12female_SMAWII=VALUES( g12female_SMAWII),
 g12_TOT_SMAWII=VALUES( g12_TOT_SMAWII),
 g12male_TILE=VALUES( g12male_TILE),
 g12female_TILE=VALUES( g12female_TILE),
 g12_TOT_TILE=VALUES( g12_TOT_TILE),
 g12male_TLIM=VALUES( g12male_TLIM),
 g12female_TLIM=VALUES( g12female_TLIM),
 g12_TOT_TLIM=VALUES( g12_TOT_TLIM);


COMMIT;











