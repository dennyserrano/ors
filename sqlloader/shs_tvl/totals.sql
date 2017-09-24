g11male_TOT
g11female_TOT
g12male_TOT
g12female_TOT

(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_ATPOE,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_ATPOE,
(
	@totalA+@totalB
) as TOT_ATPOE,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_BARB,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_BARB,
(
	@totalA+@totalB
) as TOT_BARB,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_BART,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_BART,
(
	@totalA+@totalB
) as TOT_BART,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_BNC,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_BNC,
(
	@totalA+@totalB
) as TOT_BNC,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_BNP,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_BNP,
(
	@totalA+@totalB
) as TOT_BNP,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_CGV,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_CGV,
(
	@totalA+@totalB
) as TOT_CGV,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_CC,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_CC,
(
	@totalA+@totalB
) as TOT_CC,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_COOK,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_COOK,
(
	@totalA+@totalB
) as TOT_COOK,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_DRESS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_DRESS,
(
	@totalA+@totalB
) as TOT_DRESS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_EMS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_EMS,
(
	@totalA+@totalB
) as TOT_EMS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_FD,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_FD,
(
	@totalA+@totalB
) as TOT_FD,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_FBS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_FBS,
(
	@totalA+@totalB
) as TOT_FBS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_FOS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_FOS,
(
	@totalA+@totalB
) as TOT_FOS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_HDII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_HDII,
(
	@totalA+@totalB
) as TOT_HDII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_HDIII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_HDIII,
(
	@totalA+@totalB
) as TOT_HDIII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_HBM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_HBM,
(
	@totalA+@totalB
) as TOT_HBM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_HFAP,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_HFAP,
(
	@totalA+@totalB
) as TOT_HFAP,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_HN,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_HN,
(
	@totalA+@totalB
) as TOT_HN,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_HWL,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_HWL,
(
	@totalA+@totalB
) as TOT_HWL,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_HK,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_HK,
(
	@totalA+@totalB
) as TOT_HK,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_LGS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_LGS,
(
	@totalA+@totalB
) as TOT_LGS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_TLOR,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_TLOR,
(
	@totalA+@totalB
) as TOT_TLOR,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_TPS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_TPS,
(
	@totalA+@totalB
) as TOT_TPS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_TS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_TS,
(
	@totalA+@totalB
) as TOT_TS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_WM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_WM,
(
	@totalA+@totalB
) as TOT_WM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_ACPI,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_ACPI,
(
	@totalA+@totalB
) as TOT_ACPI,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_ACPII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_ACPII,
(
	@totalA+@totalB
) as TOT_ACPII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_ACPIII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_ACPIII,
(
	@totalA+@totalB
) as TOT_ACPIII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_AHCM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_AHCM,
(
	@totalA+@totalB
) as TOT_AHCM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_APPC,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_APPC,
(
	@totalA+@totalB
) as TOT_APPC,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_APLR,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_APLR,
(
	@totalA+@totalB
) as TOT_APLR,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_APS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_APS,
(
	@totalA+@totalB
) as TOT_APS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_AQUA,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_AQUA,
(
	@totalA+@totalB
) as TOT_AQUA,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_AILR,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_AILR,
(
	@totalA+@totalB
) as TOT_AILR,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_AIS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_AIS,
(
	@totalA+@totalB
) as TOT_AIS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_FC,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_FC,
(
	@totalA+@totalB
) as TOT_FC,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_FGRM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_FGRM,
(
	@totalA+@totalB
) as TOT_FGRM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_FPP,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_FPP,
(
	@totalA+@totalB
) as TOT_FPP,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_FWO,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_FWO,
(
	@totalA+@totalB
) as TOT_FWO,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_FP,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_FP,
(
	@totalA+@totalB
) as TOT_FP,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_HORT,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_HORT,
(
	@totalA+@totalB
) as TOT_HORT,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_LIM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_LIM,
(
	@totalA+@totalB
) as TOT_LIM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_OA,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_OA,
(
	@totalA+@totalB
) as TOT_OA,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_PM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_PM,
(
	@totalA+@totalB
) as TOT_PM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_RMO,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_RMO,
(
	@totalA+@totalB
) as TOT_RMO,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_RP,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_RP,
(
	@totalA+@totalB
) as TOT_RP,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_RUBPROD,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_RUBPROD,
(
	@totalA+@totalB
) as TOT_RUBPROD,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_SO,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_SO,
(
	@totalA+@totalB
) as TOT_SO,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_ASI,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_ASI,
(
	@totalA+@totalB
) as TOT_ASI,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_ASII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_ASII,
(
	@totalA+@totalB
) as TOT_ASII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_CARTII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_CARTII,
(
	@totalA+@totalB
) as TOT_CARTII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_CARTIII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_CARTIII,
(
	@totalA+@totalB
) as TOT_CARTIII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_CP,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_CP,
(
	@totalA+@totalB
) as TOT_CP,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_DOMRAC,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_DOMRAC,
(
	@totalA+@totalB
) as TOT_DOMRAC,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_EIM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_EIM,
(
	@totalA+@totalB
) as TOT_EIM,

(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_EPDLC,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_EPDLC,
(
	@totalA+@totalB
) as TOT_EPDLC,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_EPAS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_EPAS,
(
	@totalA+@totalB
) as TOT_EPAS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_FM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_FM,
(
	@totalA+@totalB
) as TOT_FM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_ICS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_ICS,
(
	@totalA+@totalB
) as TOT_ICS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_GMAW,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_GMAW,
(
	@totalA+@totalB
) as TOT_GMAW,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_GTAW,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_GTAW,
(
	@totalA+@totalB
) as TOT_GTAW,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_MACHI,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_MACHI,
(
	@totalA+@totalB
) as TOT_MACHI,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_MACHII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_MACHII,
(
	@totalA+@totalB
) as TOT_MACHII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_MSN,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_MSN,
(
	@totalA+@totalB
) as TOT_MSN,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_MS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_MS,
(
	@totalA+@totalB
) as TOT_MS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_SES,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_SES,
(
	@totalA+@totalB
) as TOT_SES,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_PLUMI,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_PLUMI,
(
	@totalA+@totalB
) as TOT_PLUMI,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_PLUMII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_PLUMII,
(
	@totalA+@totalB
) as TOT_PLUMII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_PACU,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_PACU,
(
	@totalA+@totalB
) as TOT_PACU,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_SMAWI,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_SMAWI,
(
	@totalA+@totalB
) as TOT_SMAWI,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_SMAWII,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_SMAWII,
(
	@totalA+@totalB
) as TOT_SMAWII,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_TILE,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_TILE,
(
	@totalA+@totalB
) as TOT_TILE,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_TLIM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_TLIM,
(
	@totalA+@totalB
) as TOT_TLIM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_ANIM,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_ANIM,
(
	@totalA+@totalB
) as TOT_ANIM,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_FWS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_FWS,
(
	@totalA+@totalB
) as TOT_FWS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_CPNT,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_CPNT,
(
	@totalA+@totalB
) as TOT_CPNT,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_CPJV,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_CPJV,
(
	@totalA+@totalB
) as TOT_CPJV,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_CPOR,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_CPOR,
(
	@totalA+@totalB
) as TOT_CPOR,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_CSS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_CSS,
(
	@totalA+@totalB
) as TOT_CSS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_CCS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_CCS,
(
	@totalA+@totalB
) as TOT_CCS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_ILLUS,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_ILLUS,
(
	@totalA+@totalB
) as TOT_ILLUS,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_MT,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_MT,
(
	@totalA+@totalB
) as TOT_MT,
(
	@totalA:=(SELECT 
	 IFNULL(SUM(A.male),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gmale_TOT_TD,
(
	@totalB:=(SELECT 
	 IFNULL(SUM(A.female),0)
	FROM ebeisdb.shs_enrolment_summary A INNER JOIN
	ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN
	ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id
	WHERE
	B.shs_track_id=906 -- TVL code
    
    AND C.shs_subjects_id=15
    AND A.report_history_id=rh.id)
) as gfemale_TOT_TD,
(
	@totalA+@totalB
) as TOT_TD,

(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gmale_TOT_CCPD, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gfemale_TOT_CCPD, 
( 
@totalA+@totalB 
) as TOT_CCPD ,






(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gmale_TOT_FOC, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gfemale_TOT_FOC, 
( 
@totalA+@totalB 
) as TOT_FOC ,
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gmale_TOT_NW1, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gfemale_TOT_NW1, 
( 
@totalA+@totalB 
) as TOT_NW1 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gmale_TOT_NW2, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gfemale_TOT_NW2, 
( 
@totalA+@totalB 
) as TOT_NW2 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gmale_TOT_NW3, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gfemale_TOT_NW3, 
( 
@totalA+@totalB 
) as TOT_NW3 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gmale_TOT_EW1, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gfemale_TOT_EW1, 
( 
@totalA+@totalB 
) as TOT_EW1 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gmale_TOT_EW2, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gfemale_TOT_EW2, 
( 
@totalA+@totalB 
) as TOT_EW2 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gmale_TOT_SFTY1, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gfemale_TOT_SFTY1, 
( 
@totalA+@totalB 
) as TOT_SFTY1 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gmale_TOT_SFTY2, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gfemale_TOT_SFTY2, 
( 
@totalA+@totalB 
) as TOT_SFTY2 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gmale_TOT_SCS, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
 
AND C.shs_subjects_id=15 
AND A.report_history_id=rh.id) 
) as gfemale_TOT_SCS, 
( 
@totalA+@totalB 
) as TOT_SCS ,

