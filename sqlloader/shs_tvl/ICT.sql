INSERT INTO orsdb.shs_tvl
(
g11male_ANIM,
 g11female_ANIM,
 g11_TOT_ANIM,
 g11male_FWS,
 g11female_FWS,
 g11_TOT_FWS,
 g11male_CPNT,
 g11female_CPNT,
 g11_TOT_CPNT,
 g11male_CPJV,
 g11female_CPJV,
 g11_TOT_CPJV,
 g11male_CPOR,
 g11female_CPOR,
 g11_TOT_CPOR,
 g11male_CSS,
 g11female_CSS,
 g11_TOT_CSS,
 g11male_CCS,
 g11female_CCS,
 g11_TOT_CCS,
 g11male_ILLUS,
 g11female_ILLUS,
 g11_TOT_ILLUS,
 g11male_MT,
 g11female_MT,
 g11_TOT_MT,
 g11male_TD,
 g11female_TD,
 g11_TOT_TD ,
 g11male_CCPD,
 g11female_CCPD,
 g11_TOT_CCPD ,
 g11male_FOC,
 g11female_FOC,
 g11_TOT_FOC ,
g12male_ANIM,
 g12female_ANIM,
 g12_TOT_ANIM,
 g12male_FWS,
 g12female_FWS,
 g12_TOT_FWS,
 g12male_CPNT,
 g12female_CPNT,
 g12_TOT_CPNT,
 g12male_CPJV,
 g12female_CPJV,
 g12_TOT_CPJV,
 g12male_CPOR,
 g12female_CPOR,
 g12_TOT_CPOR,
 g12male_CSS,
 g12female_CSS,
 g12_TOT_CSS,
 g12male_CCS,
 g12female_CCS,
 g12_TOT_CCS,
 g12male_ILLUS,
 g12female_ILLUS,
 g12_TOT_ILLUS,
 g12male_MT,
 g12female_MT,
 g12_TOT_MT,
 g12male_TD,
 g12female_TD,
 g12_TOT_TD,
 g12male_CCPD,
 g12female_CCPD,
 g12_TOT_CCPD ,
 g12male_FOC,
 g12female_FOC,
 g12_TOT_FOC 




)


SELECT
 (
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11male_ANIM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11female_ANIM,
(
	@totalA+@totalB
) as g11_TOT_ANIM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11male_FWS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11female_FWS,
(
	@totalA+@totalB
) as g11_TOT_FWS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11male_CPNT,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11female_CPNT,
(
	@totalA+@totalB
) as g11_TOT_CPNT,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11male_CPJV,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11female_CPJV,
(
	@totalA+@totalB
) as g11_TOT_CPJV,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11male_CPOR,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11female_CPOR,
(
	@totalA+@totalB
) as g11_TOT_CPOR,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11male_CSS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11female_CSS,
(
	@totalA+@totalB
) as g11_TOT_CSS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11male_CCS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11female_CCS,
(
	@totalA+@totalB
) as g11_TOT_CCS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11male_ILLUS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11female_ILLUS,
(
	@totalA+@totalB
) as g11_TOT_ILLUS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11male_MT,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11female_MT,
(
	@totalA+@totalB
) as g11_TOT_MT,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11male_TD,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11female_TD,
(
	@totalA+@totalB
) as g11_TOT_TD,

(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as g11male_CCPD, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as g11female_CCPD, 
( 
@totalA+@totalB 
) as g11_TOT_CCPD ,






(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as g11male_FOC, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as g11female_FOC, 
( 
@totalA+@totalB 
) as g11_TOT_FOC ,

(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12male_ANIM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12female_ANIM,
(
	@totalA+@totalB
) as g12_TOT_ANIM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12male_FWS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12female_FWS,
(
	@totalA+@totalB
) as g12_TOT_FWS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12male_CPNT,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12female_CPNT,
(
	@totalA+@totalB
) as g12_TOT_CPNT,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12male_CPJV,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12female_CPJV,
(
	@totalA+@totalB
) as g12_TOT_CPJV,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12male_CPOR,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12female_CPOR,
(
	@totalA+@totalB
) as g12_TOT_CPOR,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12male_CSS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12female_CSS,
(
	@totalA+@totalB
) as g12_TOT_CSS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12male_CCS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12female_CCS,
(
	@totalA+@totalB
) as g12_TOT_CCS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12male_ILLUS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12female_ILLUS,
(
	@totalA+@totalB
) as g12_TOT_ILLUS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12male_MT,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12female_MT,
(
	@totalA+@totalB
) as g12_TOT_MT,
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as g12male_TD, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as g12female_TD, 
( 
@totalA+@totalB 
) as g12_TOT_TD ,

(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as g12male_CCPD, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as g12female_CCPD, 
( 
@totalA+@totalB 
) as g12_TOT_CCPD ,






(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as g12male_FOC, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as g12female_FOC, 
( 
@totalA+@totalB 
) as g12_TOT_FOC 






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
   and rh.id=1
   GROUP BY sph.SCHOOL_ID
   ORDER BY sph.SY_FROM, rr.RANK ASC, sph.SCHOOL_ID ASC;










