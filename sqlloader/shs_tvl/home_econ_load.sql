INSERT INTO orsdb.shs_tvl
(
sy_from,
school_id,
g11male_ATPOE,
 g11female_ATPOE,
 g11_TOT_ATPOE,
 g11male_BARB,
 g11female_BARB,
 g11_TOT_BARB,
 g11male_BART,
 g11female_BART,
 g11_TOT_BART,
 g11male_BNC,
 g11female_BNC,
 g11_TOT_BNC,
 g11male_BNP,
 g11female_BNP,
 g11_TOT_BNP,
 g11male_CGV,
 g11female_CGV,
 g11_TOT_CGV,
 g11male_CC,
 g11female_CC,
 g11_TOT_CC,
 g11male_COOK,
 g11female_COOK,
 g11_TOT_COOK,
 g11male_DRESS,
 g11female_DRESS,
 g11_TOT_DRESS,
 g11male_EMS,
 g11female_EMS,
 g11_TOT_EMS,
 g11male_FD,
 g11female_FD,
 g11_TOT_FD,
 g11male_FBS,
 g11female_FBS,
 g11_TOT_FBS,
 g11male_FOS,
 g11female_FOS,
 g11_TOT_FOS,
 g11male_HDII,
 g11female_HDII,
 g11_TOT_HDII,
 g11male_HDIII,
 g11female_HDIII,
 g11_TOT_HDIII,
 g11male_HBM,
 g11female_HBM,
 g11_TOT_HBM,
 g11male_HFAP,
 g11female_HFAP,
 g11_TOT_HFAP,
 g11male_HN,
 g11female_HN,
 g11_TOT_HN,
 g11male_HWL,
 g11female_HWL,
 g11_TOT_HWL,
 g11male_HK,
 g11female_HK,
 g11_TOT_HK,
 g11male_LGS,
 g11female_LGS,
 g11_TOT_LGS,
 g11male_TLOR,
 g11female_TLOR,
 g11_TOT_TLOR,
 g11male_TPS,
 g11female_TPS,
 g11_TOT_TPS,
 g11male_TS,
 g11female_TS,
 g11_TOT_TS,
 g11male_WM,
 g11female_WM,
 g11_TOT_WM,
 g12male_ATPOE,
 g12female_ATPOE,
 g12_TOT_ATPOE,
 g12male_BARB,
 g12female_BARB,
 g12_TOT_BARB,
 g12male_BART,
 g12female_BART,
 g12_TOT_BART,
 g12male_BNC,
 g12female_BNC,
 g12_TOT_BNC,
 g12male_BNP,
 g12female_BNP,
 g12_TOT_BNP,
 g12male_CGV,
 g12female_CGV,
 g12_TOT_CGV,
 g12male_CC,
 g12female_CC,
 g12_TOT_CC,
 g12male_COOK,
 g12female_COOK,
 g12_TOT_COOK,
 g12male_DRESS,
 g12female_DRESS,
 g12_TOT_DRESS,
 g12male_EMS,
 g12female_EMS,
 g12_TOT_EMS,
 g12male_FD,
 g12female_FD,
 g12_TOT_FD,
 g12male_FBS,
 g12female_FBS,
 g12_TOT_FBS,
 g12male_FOS,
 g12female_FOS,
 g12_TOT_FOS,
 g12male_HDII,
 g12female_HDII,
 g12_TOT_HDII,
 g12male_HDIII,
 g12female_HDIII,
 g12_TOT_HDIII,
 g12male_HBM,
 g12female_HBM,
 g12_TOT_HBM,
 g12male_HFAP,
 g12female_HFAP,
 g12_TOT_HFAP,
 g12male_HN,
 g12female_HN,
 g12_TOT_HN,
 g12male_HWL,
 g12female_HWL,
 g12_TOT_HWL,
 g12male_HK,
 g12female_HK,
 g12_TOT_HK,
 g12male_LGS,
 g12female_LGS,
 g12_TOT_LGS,
 g12male_TLOR,
 g12female_TLOR,
 g12_TOT_TLOR,
 g12male_TPS,
 g12female_TPS,
 g12_TOT_TPS,
 g12male_TS,
 g12female_TS,
 g12_TOT_TS,
 g12male_WM,
 g12female_WM,
 g12_TOT_WM


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
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as g11male_ATPOE,
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
) as g11female_ATPOE,
(
	@totalA+@totalB
) as g11_TOT_ATPOE,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=18
    AND A.report_history_id=rh.id)
) as g11male_BARB,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=18
    AND A.report_history_id=rh.id)
) as g11female_BARB,
(
	@totalA+@totalB
) as g11_TOT_BARB,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=19
    AND A.report_history_id=rh.id)
) as g11male_BART,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=19
    AND A.report_history_id=rh.id)
) as g11female_BART,
(
	@totalA+@totalB
) as g11_TOT_BART,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=21
    AND A.report_history_id=rh.id)
) as g11male_BNC,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=21
    AND A.report_history_id=rh.id)
) as g11female_BNC,
(
	@totalA+@totalB
) as g11_TOT_BNC,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=22
    AND A.report_history_id=rh.id)
) as g11male_BNP,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=22
    AND A.report_history_id=rh.id)
) as g11female_BNP,
(
	@totalA+@totalB
) as g11_TOT_BNP,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=27
    AND A.report_history_id=rh.id)
) as g11male_CGV,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=27
    AND A.report_history_id=rh.id)
) as g11female_CGV,
(
	@totalA+@totalB
) as g11_TOT_CGV,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=30
    AND A.report_history_id=rh.id)
) as g11male_CC,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=30
    AND A.report_history_id=rh.id)
) as g11female_CC,
(
	@totalA+@totalB
) as g11_TOT_CC,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=38
    AND A.report_history_id=rh.id)
) as g11male_COOK,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=38
    AND A.report_history_id=rh.id)
) as g11female_COOK,
(
	@totalA+@totalB
) as g11_TOT_COOK,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=49
    AND A.report_history_id=rh.id)
) as g11male_DRESS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=49
    AND A.report_history_id=rh.id)
) as g11female_DRESS,
(
	@totalA+@totalB
) as g11_TOT_DRESS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=61
    AND A.report_history_id=rh.id)
) as g11male_EMS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=61
    AND A.report_history_id=rh.id)
) as g11female_EMS,
(
	@totalA+@totalB
) as g11_TOT_EMS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=63
    AND A.report_history_id=rh.id)
) as g11male_FD,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=63
    AND A.report_history_id=rh.id)
) as g11female_FD,
(
	@totalA+@totalB
) as g11_TOT_FD,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=72
    AND A.report_history_id=rh.id)
) as g11male_FBS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=72
    AND A.report_history_id=rh.id)
) as g11female_FBS,
(
	@totalA+@totalB
) as g11_TOT_FBS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=73
    AND A.report_history_id=rh.id)
) as g11male_FOS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=73
    AND A.report_history_id=rh.id)
) as g11female_FOS,
(
	@totalA+@totalB
) as g11_TOT_FOS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=86
    AND A.report_history_id=rh.id)
) as g11male_HDII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=86
    AND A.report_history_id=rh.id)
) as g11female_HDII,
(
	@totalA+@totalB
) as g11_TOT_HDII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=87
    AND A.report_history_id=rh.id)
) as g11male_HDIII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=87
    AND A.report_history_id=rh.id)
) as g11female_HDIII,
(
	@totalA+@totalB
) as g11_TOT_HDIII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=88
    AND A.report_history_id=rh.id)
) as g11male_HBM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=88
    AND A.report_history_id=rh.id)
) as g11female_HBM,
(
	@totalA+@totalB
) as g11_TOT_HBM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=89
    AND A.report_history_id=rh.id)
) as g11male_HFAP,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=89
    AND A.report_history_id=rh.id)
) as g11female_HFAP,
(
	@totalA+@totalB
) as g11_TOT_HFAP,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=90
    AND A.report_history_id=rh.id)
) as g11male_HN,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=90
    AND A.report_history_id=rh.id)
) as g11female_HN,
(
	@totalA+@totalB
) as g11_TOT_HN,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=91
    AND A.report_history_id=rh.id)
) as g11male_HWL,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=91
    AND A.report_history_id=rh.id)
) as g11female_HWL,
(
	@totalA+@totalB
) as g11_TOT_HWL,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=94
    AND A.report_history_id=rh.id)
) as g11male_HK,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=94
    AND A.report_history_id=rh.id)
) as g11female_HK,
(
	@totalA+@totalB
) as g11_TOT_HK,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=109
    AND A.report_history_id=rh.id)
) as g11male_LGS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=109
    AND A.report_history_id=rh.id)
) as g11female_LGS,
(
	@totalA+@totalB
) as g11_TOT_LGS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=154
    AND A.report_history_id=rh.id)
) as g11male_TLOR,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=154
    AND A.report_history_id=rh.id)
) as g11female_TLOR,
(
	@totalA+@totalB
) as g11_TOT_TLOR,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=160
    AND A.report_history_id=rh.id)
) as g11male_TPS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=160
    AND A.report_history_id=rh.id)
) as g11female_TPS,
(
	@totalA+@totalB
) as g11_TOT_TPS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=162
    AND A.report_history_id=rh.id)
) as g11male_TS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=162
    AND A.report_history_id=rh.id)
) as g11female_TS,
(
	@totalA+@totalB
) as g11_TOT_TS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=165
    AND A.report_history_id=rh.id)
) as g11male_WM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=165
    AND A.report_history_id=rh.id)
) as g11female_WM,
(
	@totalA+@totalB
) as g11_TOT_WM,
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
) as g12male_ATPOE,
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
) as g12female_ATPOE,
(
	@totalA+@totalB
) as g12_TOT_ATPOE,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=18
    AND A.report_history_id=rh.id)
) as g12male_BARB,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=18
    AND A.report_history_id=rh.id)
) as g12female_BARB,
(
	@totalA+@totalB
) as g12_TOT_BARB,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=19
    AND A.report_history_id=rh.id)
) as g12male_BART,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=19
    AND A.report_history_id=rh.id)
) as g12female_BART,
(
	@totalA+@totalB
) as g12_TOT_BART,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=21
    AND A.report_history_id=rh.id)
) as g12male_BNC,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=21
    AND A.report_history_id=rh.id)
) as g12female_BNC,
(
	@totalA+@totalB
) as g12_TOT_BNC,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=22
    AND A.report_history_id=rh.id)
) as g12male_BNP,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=22
    AND A.report_history_id=rh.id)
) as g12female_BNP,
(
	@totalA+@totalB
) as g12_TOT_BNP,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=27
    AND A.report_history_id=rh.id)
) as g12male_CGV,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=27
    AND A.report_history_id=rh.id)
) as g12female_CGV,
(
	@totalA+@totalB
) as g12_TOT_CGV,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=30
    AND A.report_history_id=rh.id)
) as g12male_CC,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=30
    AND A.report_history_id=rh.id)
) as g12female_CC,
(
	@totalA+@totalB
) as g12_TOT_CC,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=38
    AND A.report_history_id=rh.id)
) as g12male_COOK,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=38
    AND A.report_history_id=rh.id)
) as g12female_COOK,
(
	@totalA+@totalB
) as g12_TOT_COOK,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=49
    AND A.report_history_id=rh.id)
) as g12male_DRESS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=49
    AND A.report_history_id=rh.id)
) as g12female_DRESS,
(
	@totalA+@totalB
) as g12_TOT_DRESS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=61
    AND A.report_history_id=rh.id)
) as g12male_EMS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=61
    AND A.report_history_id=rh.id)
) as g12female_EMS,
(
	@totalA+@totalB
) as g12_TOT_EMS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=63
    AND A.report_history_id=rh.id)
) as g12male_FD,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=63
    AND A.report_history_id=rh.id)
) as g12female_FD,
(
	@totalA+@totalB
) as g12_TOT_FD,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=72
    AND A.report_history_id=rh.id)
) as g12male_FBS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=72
    AND A.report_history_id=rh.id)
) as g12female_FBS,
(
	@totalA+@totalB
) as g12_TOT_FBS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=73
    AND A.report_history_id=rh.id)
) as g12male_FOS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=73
    AND A.report_history_id=rh.id)
) as g12female_FOS,
(
	@totalA+@totalB
) as g12_TOT_FOS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=86
    AND A.report_history_id=rh.id)
) as g12male_HDII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=86
    AND A.report_history_id=rh.id)
) as g12female_HDII,
(
	@totalA+@totalB
) as g12_TOT_HDII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=87
    AND A.report_history_id=rh.id)
) as g12male_HDIII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=87
    AND A.report_history_id=rh.id)
) as g12female_HDIII,
(
	@totalA+@totalB
) as g12_TOT_HDIII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=88
    AND A.report_history_id=rh.id)
) as g12male_HBM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=88
    AND A.report_history_id=rh.id)
) as g12female_HBM,
(
	@totalA+@totalB
) as g12_TOT_HBM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=89
    AND A.report_history_id=rh.id)
) as g12male_HFAP,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=89
    AND A.report_history_id=rh.id)
) as g12female_HFAP,
(
	@totalA+@totalB
) as g12_TOT_HFAP,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=90
    AND A.report_history_id=rh.id)
) as g12male_HN,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=90
    AND A.report_history_id=rh.id)
) as g12female_HN,
(
	@totalA+@totalB
) as g12_TOT_HN,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=91
    AND A.report_history_id=rh.id)
) as g12male_HWL,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=91
    AND A.report_history_id=rh.id)
) as g12female_HWL,
(
	@totalA+@totalB
) as g12_TOT_HWL,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=94
    AND A.report_history_id=rh.id)
) as g12male_HK,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=94
    AND A.report_history_id=rh.id)
) as g12female_HK,
(
	@totalA+@totalB
) as g12_TOT_HK,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=109
    AND A.report_history_id=rh.id)
) as g12male_LGS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=109
    AND A.report_history_id=rh.id)
) as g12female_LGS,
(
	@totalA+@totalB
) as g12_TOT_LGS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=154
    AND A.report_history_id=rh.id)
) as g12male_TLOR,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=154
    AND A.report_history_id=rh.id)
) as g12female_TLOR,
(
	@totalA+@totalB
) as g12_TOT_TLOR,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=160
    AND A.report_history_id=rh.id)
) as g12male_TPS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=160
    AND A.report_history_id=rh.id)
) as g12female_TPS,
(
	@totalA+@totalB
) as g12_TOT_TPS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=162
    AND A.report_history_id=rh.id)
) as g12male_TS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=162
    AND A.report_history_id=rh.id)
) as g12female_TS,
(
	@totalA+@totalB
) as g12_TOT_TS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=165
    AND A.report_history_id=rh.id)
) as g12male_WM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    AND A.grade_level_id=497
    AND C.shs_subjects_id=165
    AND A.report_history_id=rh.id)
) as g12female_WM,
(
	@totalA+@totalB
) as g12_TOT_WM



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








 
