INSERT INTO orsdb.shs_tvl
(
 sy_from,
 school_id,
 g11male_ACPI,
 g11female_ACPI,
 g11_TOT_ACPI,
 g11male_ACPII,
 g11female_ACPII,
 g11_TOT_ACPII,
 g11male_ACPIII,
 g11female_ACPIII,
 g11_TOT_ACPIII,
 g11male_AHCM,
 g11female_AHCM,
 g11_TOT_AHCM,
 g11male_APPC,
 g11female_APPC,
 g11_TOT_APPC,
 g11male_APLR,
 g11female_APLR,
 g11_TOT_APLR,
 g11male_APS,
 g11female_APS,
 g11_TOT_APS,
 g11male_AQUA,
 g11female_AQUA,
 g11_TOT_AQUA,
 g11male_AILR,
 g11female_AILR,
 g11_TOT_AILR,
 g11male_AIS,
 g11female_AIS,
 g11_TOT_AIS,
 g11male_FC,
 g11female_FC,
 g11_TOT_FC,
 g11male_FGRM,
 g11female_FGRM,
 g11_TOT_FGRM,
 g11male_FPP,
 g11female_FPP,
 g11_TOT_FPP,
 g11male_FWO,
 g11female_FWO,
 g11_TOT_FWO,
 g11male_FP,
 g11female_FP,
 g11_TOT_FP,
 g11male_HORT,
 g11female_HORT,
 g11_TOT_HORT,
 g11male_LIM,
 g11female_LIM,
 g11_TOT_LIM,
 g11male_OA,
 g11female_OA,
 g11_TOT_OA,
 g11male_PM,
 g11female_PM,
 g11_TOT_PM,
 g11male_RMO,
 g11female_RMO,
 g11_TOT_RMO,
 g11male_RP,
 g11female_RP,
 g11_TOT_RP,
 g11male_RUBPROD,
 g11female_RUBPROD,
 g11_TOT_RUBPROD,
 g11male_SO,
 g11female_SO,
 g11_TOT_SO,
 g12male_ACPI,
 g12female_ACPI,
 g12_TOT_ACPI,
 g12male_ACPII,
 g12female_ACPII,
 g12_TOT_ACPII,
 g12male_ACPIII,
 g12female_ACPIII,
 g12_TOT_ACPIII,
 g12male_AHCM,
 g12female_AHCM,
 g12_TOT_AHCM,
 g12male_APPC,
 g12female_APPC,
 g12_TOT_APPC,
 g12male_APLR,
 g12female_APLR,
 g12_TOT_APLR,
 g12male_APS,
 g12female_APS,
 g12_TOT_APS,
 g12male_AQUA,
 g12female_AQUA,
 g12_TOT_AQUA,
 g12male_AILR,
 g12female_AILR,
 g12_TOT_AILR,
 g12male_AIS,
 g12female_AIS,
 g12_TOT_AIS,
 g12male_FC,
 g12female_FC,
 g12_TOT_FC,
 g12male_FGRM,
 g12female_FGRM,
 g12_TOT_FGRM,
 g12male_FPP,
 g12female_FPP,
 g12_TOT_FPP,
 g12male_FWO,
 g12female_FWO,
 g12_TOT_FWO,
 g12male_FP,
 g12female_FP,
 g12_TOT_FP,
 g12male_HORT,
 g12female_HORT,
 g12_TOT_HORT,
 g12male_LIM,
 g12female_LIM,
 g12_TOT_LIM,
 g12male_OA,
 g12female_OA,
 g12_TOT_OA,
 g12male_PM,
 g12female_PM,
 g12_TOT_PM,
 g12male_RMO,
 g12female_RMO,
 g12_TOT_RMO,
 g12male_RP,
 g12female_RP,
 g12_TOT_RP,
 g12male_RUBPROD,
 g12female_RUBPROD,
 g12_TOT_RUBPROD,
 g12male_SO,
 g12female_SO,
 g12_TOT_SO


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
    AND C.shs_subjects_id=2
    AND A.report_history_id=rh.id)
) as g11male_ACPI,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=2
    AND A.report_history_id=rh.id)
) as g11female_ACPI,
(
	@totalA+@totalB
) as g11_TOT_ACPI,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=3
    AND A.report_history_id=rh.id)
) as g11male_ACPII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=3
    AND A.report_history_id=rh.id)
) as g11female_ACPII,
(
	@totalA+@totalB
) as g11_TOT_ACPII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=4
    AND A.report_history_id=rh.id)
) as g11male_ACPIII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=4
    AND A.report_history_id=rh.id)
) as g11female_ACPIII,
(
	@totalA+@totalB
) as g11_TOT_ACPIII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=5
    AND A.report_history_id=rh.id)
) as g11male_AHCM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=5
    AND A.report_history_id=rh.id)
) as g11female_AHCM,
(
	@totalA+@totalB
) as g11_TOT_AHCM,
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
) as g11male_APPC,
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
) as g11female_APPC,
(
	@totalA+@totalB
) as g11_TOT_APPC,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=186
    AND A.report_history_id=rh.id)
) as g11male_APLR,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=186
    AND A.report_history_id=rh.id)
) as g11female_APLR,
(
	@totalA+@totalB
) as g11_TOT_APLR,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=8
    AND A.report_history_id=rh.id)
) as g11male_APS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=8
    AND A.report_history_id=rh.id)
) as g11female_APS,
(
	@totalA+@totalB
) as g11_TOT_APS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=12
    AND A.report_history_id=rh.id)
) as g11male_AQUA,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=12
    AND A.report_history_id=rh.id)
) as g11female_AQUA,
(
	@totalA+@totalB
) as g11_TOT_AQUA,
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
) as g11male_AILR,
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
) as g11female_AILR,
(
	@totalA+@totalB
) as g11_TOT_AILR,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=14
    AND A.report_history_id=rh.id)
) as g11male_AIS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=14
    AND A.report_history_id=rh.id)
) as g11female_AIS,
(
	@totalA+@totalB
) as g11_TOT_AIS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=65
    AND A.report_history_id=rh.id)
) as g11male_FC,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=65
    AND A.report_history_id=rh.id)
) as g11female_FC,
(
	@totalA+@totalB
) as g11_TOT_FC,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=67
    AND A.report_history_id=rh.id)
) as g11male_FGRM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=67
    AND A.report_history_id=rh.id)
) as g11female_FGRM,
(
	@totalA+@totalB
) as g11_TOT_FGRM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=68
    AND A.report_history_id=rh.id)
) as g11male_FPP,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=68
    AND A.report_history_id=rh.id)
) as g11female_FPP,
(
	@totalA+@totalB
) as g11_TOT_FPP,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=66
    AND A.report_history_id=rh.id)
) as g11male_FWO,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=66
    AND A.report_history_id=rh.id)
) as g11female_FWO,
(
	@totalA+@totalB
) as g11_TOT_FWO,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=71
    AND A.report_history_id=rh.id)
) as g11male_FP,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=71
    AND A.report_history_id=rh.id)
) as g11female_FP,
(
	@totalA+@totalB
) as g11_TOT_FP,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=93
    AND A.report_history_id=rh.id)
) as g11male_HORT,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=93
    AND A.report_history_id=rh.id)
) as g11female_HORT,
(
	@totalA+@totalB
) as g11_TOT_HORT,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=105
    AND A.report_history_id=rh.id)
) as g11male_LIM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=105
    AND A.report_history_id=rh.id)
) as g11female_LIM,
(
	@totalA+@totalB
) as g11_TOT_LIM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=121
    AND A.report_history_id=rh.id)
) as g11male_OA,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=121
    AND A.report_history_id=rh.id)
) as g11female_OA,
(
	@totalA+@totalB
) as g11_TOT_OA,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=126
    AND A.report_history_id=rh.id)
) as g11male_PM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=126
    AND A.report_history_id=rh.id)
) as g11female_PM,
(
	@totalA+@totalB
) as g11_TOT_PM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=144
    AND A.report_history_id=rh.id)
) as g11male_RMO,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=144
    AND A.report_history_id=rh.id)
) as g11female_RMO,
(
	@totalA+@totalB
) as g11_TOT_RMO,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=145
    AND A.report_history_id=rh.id)
) as g11male_RP,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=145
    AND A.report_history_id=rh.id)
) as g11female_RP,
(
	@totalA+@totalB
) as g11_TOT_RP,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=146
    AND A.report_history_id=rh.id)
) as g11male_RUBPROD,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=146
    AND A.report_history_id=rh.id)
) as g11female_RUBPROD,
(
	@totalA+@totalB
) as g11_TOT_RUBPROD,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=150
    AND A.report_history_id=rh.id)
) as g11male_SO,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=150
    AND A.report_history_id=rh.id)
) as g11female_SO,
(
	@totalA+@totalB
) as g11_TOT_SO,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=2
    AND A.report_history_id=rh.id)
) as g12male_ACPI,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=2
    AND A.report_history_id=rh.id)
) as g12female_ACPI,
(
	@totalA+@totalB
) as g12_TOT_ACPI,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=3
    AND A.report_history_id=rh.id)
) as g12male_ACPII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=3
    AND A.report_history_id=rh.id)
) as g12female_ACPII,
(
	@totalA+@totalB
) as g12_TOT_ACPII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=4
    AND A.report_history_id=rh.id)
) as g12male_ACPIII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=4
    AND A.report_history_id=rh.id)
) as g12female_ACPIII,
(
	@totalA+@totalB
) as g12_TOT_ACPIII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=5
    AND A.report_history_id=rh.id)
) as g12male_AHCM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=5
    AND A.report_history_id=rh.id)
) as g12female_AHCM,
(
	@totalA+@totalB
) as g12_TOT_AHCM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12male_APPC,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12female_APPC,
(
	@totalA+@totalB
) as g12_TOT_APPC,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=186
    AND A.report_history_id=rh.id)
) as g12male_APLR,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=186
    AND A.report_history_id=rh.id)
) as g12female_APLR,
(
	@totalA+@totalB
) as g12_TOT_APLR,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=8
    AND A.report_history_id=rh.id)
) as g12male_APS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=8
    AND A.report_history_id=rh.id)
) as g12female_APS,
(
	@totalA+@totalB
) as g12_TOT_APS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=12
    AND A.report_history_id=rh.id)
) as g12male_AQUA,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=12
    AND A.report_history_id=rh.id)
) as g12female_AQUA,
(
	@totalA+@totalB
) as g12_TOT_AQUA,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12male_AILR,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g12female_AILR,
(
	@totalA+@totalB
) as g12_TOT_AILR,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=14
    AND A.report_history_id=rh.id)
) as g12male_AIS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=14
    AND A.report_history_id=rh.id)
) as g12female_AIS,
(
	@totalA+@totalB
) as g12_TOT_AIS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=65
    AND A.report_history_id=rh.id)
) as g12male_FC,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=65
    AND A.report_history_id=rh.id)
) as g12female_FC,
(
	@totalA+@totalB
) as g12_TOT_FC,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=67
    AND A.report_history_id=rh.id)
) as g12male_FGRM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=67
    AND A.report_history_id=rh.id)
) as g12female_FGRM,
(
	@totalA+@totalB
) as g12_TOT_FGRM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=68
    AND A.report_history_id=rh.id)
) as g12male_FPP,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=68
    AND A.report_history_id=rh.id)
) as g12female_FPP,
(
	@totalA+@totalB
) as g12_TOT_FPP,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=66
    AND A.report_history_id=rh.id)
) as g12male_FWO,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=66
    AND A.report_history_id=rh.id)
) as g12female_FWO,
(
	@totalA+@totalB
) as g12_TOT_FWO,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=71
    AND A.report_history_id=rh.id)
) as g12male_FP,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=71
    AND A.report_history_id=rh.id)
) as g12female_FP,
(
	@totalA+@totalB
) as g12_TOT_FP,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=93
    AND A.report_history_id=rh.id)
) as g12male_HORT,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=93
    AND A.report_history_id=rh.id)
) as g12female_HORT,
(
	@totalA+@totalB
) as g12_TOT_HORT,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=105
    AND A.report_history_id=rh.id)
) as g12male_LIM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=105
    AND A.report_history_id=rh.id)
) as g12female_LIM,
(
	@totalA+@totalB
) as g12_TOT_LIM,
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
) as g12male_OA,
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
) as g12female_OA,
(
	@totalA+@totalB
) as g12_TOT_OA,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=126
    AND A.report_history_id=rh.id)
) as g12male_PM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=126
    AND A.report_history_id=rh.id)
) as g12female_PM,
(
	@totalA+@totalB
) as g12_TOT_PM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=144
    AND A.report_history_id=rh.id)
) as g12male_RMO,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=144
    AND A.report_history_id=rh.id)
) as g12female_RMO,
(
	@totalA+@totalB
) as g12_TOT_RMO,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=145
    AND A.report_history_id=rh.id)
) as g12male_RP,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=145
    AND A.report_history_id=rh.id)
) as g12female_RP,
(
	@totalA+@totalB
) as g12_TOT_RP,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=146
    AND A.report_history_id=rh.id)
) as g12male_RUBPROD,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=146
    AND A.report_history_id=rh.id)
) as g12female_RUBPROD,
(
	@totalA+@totalB
) as g12_TOT_RUBPROD,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=150
    AND A.report_history_id=rh.id)
) as g12male_SO,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=595
    AND C.shs_subjects_id=150
    AND A.report_history_id=rh.id)
) as g12female_SO,
(
	@totalA+@totalB
) as g12_TOT_SO




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

g11male_ACPI=VALUES(g11male_ACPI),
 g11female_ACPI=VALUES( g11female_ACPI),
 g11_TOT_ACPI=VALUES( g11_TOT_ACPI),
 g11male_ACPII=VALUES( g11male_ACPII),
 g11female_ACPII=VALUES( g11female_ACPII),
 g11_TOT_ACPII=VALUES( g11_TOT_ACPII),
 g11male_ACPIII=VALUES( g11male_ACPIII),
 g11female_ACPIII=VALUES( g11female_ACPIII),
 g11_TOT_ACPIII=VALUES( g11_TOT_ACPIII),
 g11male_AHCM=VALUES( g11male_AHCM),
 g11female_AHCM=VALUES( g11female_AHCM),
 g11_TOT_AHCM=VALUES( g11_TOT_AHCM),
 g11male_APPC=VALUES( g11male_APPC),
 g11female_APPC=VALUES( g11female_APPC),
 g11_TOT_APPC=VALUES( g11_TOT_APPC),
 g11male_APLR=VALUES( g11male_APLR),
 g11female_APLR=VALUES( g11female_APLR),
 g11_TOT_APLR=VALUES( g11_TOT_APLR),
 g11male_APS=VALUES( g11male_APS),
 g11female_APS=VALUES( g11female_APS),
 g11_TOT_APS=VALUES( g11_TOT_APS),
 g11male_AQUA=VALUES( g11male_AQUA),
 g11female_AQUA=VALUES( g11female_AQUA),
 g11_TOT_AQUA=VALUES( g11_TOT_AQUA),
 g11male_AILR=VALUES( g11male_AILR),
 g11female_AILR=VALUES( g11female_AILR),
 g11_TOT_AILR=VALUES( g11_TOT_AILR),
 g11male_AIS=VALUES( g11male_AIS),
 g11female_AIS=VALUES( g11female_AIS),
 g11_TOT_AIS=VALUES( g11_TOT_AIS),
 g11male_FC=VALUES( g11male_FC),
 g11female_FC=VALUES( g11female_FC),
 g11_TOT_FC=VALUES( g11_TOT_FC),
 g11male_FGRM=VALUES( g11male_FGRM),
 g11female_FGRM=VALUES( g11female_FGRM),
 g11_TOT_FGRM=VALUES( g11_TOT_FGRM),
 g11male_FPP=VALUES( g11male_FPP),
 g11female_FPP=VALUES( g11female_FPP),
 g11_TOT_FPP=VALUES( g11_TOT_FPP),
 g11male_FWO=VALUES( g11male_FWO),
 g11female_FWO=VALUES( g11female_FWO),
 g11_TOT_FWO=VALUES( g11_TOT_FWO),
 g11male_FP=VALUES( g11male_FP),
 g11female_FP=VALUES( g11female_FP),
 g11_TOT_FP=VALUES( g11_TOT_FP),
 g11male_HORT=VALUES( g11male_HORT),
 g11female_HORT=VALUES( g11female_HORT),
 g11_TOT_HORT=VALUES( g11_TOT_HORT),
 g11male_LIM=VALUES( g11male_LIM),
 g11female_LIM=VALUES( g11female_LIM),
 g11_TOT_LIM=VALUES( g11_TOT_LIM),
 g11male_OA=VALUES( g11male_OA),
 g11female_OA=VALUES( g11female_OA),
 g11_TOT_OA=VALUES( g11_TOT_OA),
 g11male_PM=VALUES( g11male_PM),
 g11female_PM=VALUES( g11female_PM),
 g11_TOT_PM=VALUES( g11_TOT_PM),
 g11male_RMO=VALUES( g11male_RMO),
 g11female_RMO=VALUES( g11female_RMO),
 g11_TOT_RMO=VALUES( g11_TOT_RMO),
 g11male_RP=VALUES( g11male_RP),
 g11female_RP=VALUES( g11female_RP),
 g11_TOT_RP=VALUES( g11_TOT_RP),
 g11male_RUBPROD=VALUES( g11male_RUBPROD),
 g11female_RUBPROD=VALUES( g11female_RUBPROD),
 g11_TOT_RUBPROD=VALUES( g11_TOT_RUBPROD),
 g11male_SO=VALUES( g11male_SO),
 g11female_SO=VALUES( g11female_SO),
 g11_TOT_SO=VALUES( g11_TOT_SO),
 g12male_ACPI=VALUES( g12male_ACPI),
 g12female_ACPI=VALUES( g12female_ACPI),
 g12_TOT_ACPI=VALUES( g12_TOT_ACPI),
 g12male_ACPII=VALUES( g12male_ACPII),
 g12female_ACPII=VALUES( g12female_ACPII),
 g12_TOT_ACPII=VALUES( g12_TOT_ACPII),
 g12male_ACPIII=VALUES( g12male_ACPIII),
 g12female_ACPIII=VALUES( g12female_ACPIII),
 g12_TOT_ACPIII=VALUES( g12_TOT_ACPIII),
 g12male_AHCM=VALUES( g12male_AHCM),
 g12female_AHCM=VALUES( g12female_AHCM),
 g12_TOT_AHCM=VALUES( g12_TOT_AHCM),
 g12male_APPC=VALUES( g12male_APPC),
 g12female_APPC=VALUES( g12female_APPC),
 g12_TOT_APPC=VALUES( g12_TOT_APPC),
 g12male_APLR=VALUES( g12male_APLR),
 g12female_APLR=VALUES( g12female_APLR),
 g12_TOT_APLR=VALUES( g12_TOT_APLR),
 g12male_APS=VALUES( g12male_APS),
 g12female_APS=VALUES( g12female_APS),
 g12_TOT_APS=VALUES( g12_TOT_APS),
 g12male_AQUA=VALUES( g12male_AQUA),
 g12female_AQUA=VALUES( g12female_AQUA),
 g12_TOT_AQUA=VALUES( g12_TOT_AQUA),
 g12male_AILR=VALUES( g12male_AILR),
 g12female_AILR=VALUES( g12female_AILR),
 g12_TOT_AILR=VALUES( g12_TOT_AILR),
 g12male_AIS=VALUES( g12male_AIS),
 g12female_AIS=VALUES( g12female_AIS),
 g12_TOT_AIS=VALUES( g12_TOT_AIS),
 g12male_FC=VALUES( g12male_FC),
 g12female_FC=VALUES( g12female_FC),
 g12_TOT_FC=VALUES( g12_TOT_FC),
 g12male_FGRM=VALUES( g12male_FGRM),
 g12female_FGRM=VALUES( g12female_FGRM),
 g12_TOT_FGRM=VALUES( g12_TOT_FGRM),
 g12male_FPP=VALUES( g12male_FPP),
 g12female_FPP=VALUES( g12female_FPP),
 g12_TOT_FPP=VALUES( g12_TOT_FPP),
 g12male_FWO=VALUES( g12male_FWO),
 g12female_FWO=VALUES( g12female_FWO),
 g12_TOT_FWO=VALUES( g12_TOT_FWO),
 g12male_FP=VALUES( g12male_FP),
 g12female_FP=VALUES( g12female_FP),
 g12_TOT_FP=VALUES( g12_TOT_FP),
 g12male_HORT=VALUES( g12male_HORT),
 g12female_HORT=VALUES( g12female_HORT),
 g12_TOT_HORT=VALUES( g12_TOT_HORT),
 g12male_LIM=VALUES( g12male_LIM),
 g12female_LIM=VALUES( g12female_LIM),
 g12_TOT_LIM=VALUES( g12_TOT_LIM),
 g12male_OA=VALUES( g12male_OA),
 g12female_OA=VALUES( g12female_OA),
 g12_TOT_OA=VALUES( g12_TOT_OA),
 g12male_PM=VALUES( g12male_PM),
 g12female_PM=VALUES( g12female_PM),
 g12_TOT_PM=VALUES( g12_TOT_PM),
 g12male_RMO=VALUES( g12male_RMO),
 g12female_RMO=VALUES( g12female_RMO),
 g12_TOT_RMO=VALUES( g12_TOT_RMO),
 g12male_RP=VALUES( g12male_RP),
 g12female_RP=VALUES( g12female_RP),
 g12_TOT_RP=VALUES( g12_TOT_RP),
 g12male_RUBPROD=VALUES( g12male_RUBPROD),
 g12female_RUBPROD=VALUES( g12female_RUBPROD),
 g12_TOT_RUBPROD=VALUES( g12_TOT_RUBPROD),
 g12male_SO=VALUES( g12male_SO),
 g12female_SO=VALUES( g12female_SO),
 g12_TOT_SO=VALUES( g12_TOT_SO);


COMMIT;




