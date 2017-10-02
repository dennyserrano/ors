INSERT INTO orsdb.shs_tvl
(
sy_from,
school_id,
g11male_NW1,
g11female_NW1,
g11_TOT_NW1 ,
g11male_NW2,
g11female_NW2,
g11_TOT_NW2 ,
g11male_NW3,
g11female_NW3,
g11_TOT_NW3 ,
g11male_EW1,
g11female_EW1,
g11_TOT_EW1 ,
g11male_EW2,
g11female_EW2,
g11_TOT_EW2 ,
g11male_SFTY1,
g11female_SFTY1,
g11_TOT_SFTY1 ,
g11male_SFTY2,
g11female_SFTY2,
g11_TOT_SFTY2 ,
g11male_SCS,
g11female_SCS,
g11_TOT_SCS ,
g12male_NW1,
g12female_NW1,
g12_TOT_NW1 ,
g12male_NW2,
g12female_NW2,
g12_TOT_NW2 ,
g12male_NW3,
g12female_NW3,
g12_TOT_NW3 ,
g12male_EW1,
g12female_EW1,
g12_TOT_EW1 ,
g12male_EW2,
g12female_EW2,
g12_TOT_EW2 ,
g12male_SFTY1,
g12female_SFTY1,
g12_TOT_SFTY1 ,
g12male_SFTY2,
g12female_SFTY2,
g12_TOT_SFTY2 ,
g12male_SCS,
g12female_SCS,
g12_TOT_SCS 



)


SELECT
 
sph.sy_from,
sph.school_id,
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=166 
AND A.report_history_id=rh.id) 
) as g11male_NW1, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=166
AND A.report_history_id=rh.id) 
) as g11female_NW1, 
( 
@totalA+@totalB 
) as g11_TOT_NW1 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=167 
AND A.report_history_id=rh.id) 
) as g11male_NW2, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=167 
AND A.report_history_id=rh.id) 
) as g11female_NW2, 
( 
@totalA+@totalB 
) as g11_TOT_NW2 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=168 
AND A.report_history_id=rh.id) 
) as g11male_NW3, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=168 
AND A.report_history_id=rh.id) 
) as g11female_NW3, 
( 
@totalA+@totalB 
) as g11_TOT_NW3 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=169 
AND A.report_history_id=rh.id) 
) as g11male_EW1, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=169 
AND A.report_history_id=rh.id) 
) as g11female_EW1, 
( 
@totalA+@totalB 
) as g11_TOT_EW1 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=181 
AND A.report_history_id=rh.id) 
) as g11male_EW2, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=181 
AND A.report_history_id=rh.id) 
) as g11female_EW2, 
( 
@totalA+@totalB 
) as g11_TOT_EW2 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=182 
AND A.report_history_id=rh.id) 
) as g11male_SFTY1, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=182 
AND A.report_history_id=rh.id) 
) as g11female_SFTY1, 
( 
@totalA+@totalB 
) as g11_TOT_SFTY1 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=183 
AND A.report_history_id=rh.id) 
) as g11male_SFTY2, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=183 
AND A.report_history_id=rh.id) 
) as g11female_SFTY2, 
( 
@totalA+@totalB 
) as g11_TOT_SFTY2 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=184 
AND A.report_history_id=rh.id) 
) as g11male_SCS, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=497 
AND C.shs_subjects_id=184 
AND A.report_history_id=rh.id) 
) as g11female_SCS, 
( 
@totalA+@totalB 
) as g11_TOT_SCS ,

(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=595 
AND C.shs_subjects_id=166 
AND A.report_history_id=rh.id) 
) as g12male_NW1, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=595 
AND C.shs_subjects_id=166
AND A.report_history_id=rh.id) 
) as g12female_NW1, 
( 
@totalA+@totalB 
) as g12_TOT_NW1 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=595 
AND C.shs_subjects_id=167 
AND A.report_history_id=rh.id) 
) as g12male_NW2, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=595 
AND C.shs_subjects_id=167 
AND A.report_history_id=rh.id) 
) as g12female_NW2, 
( 
@totalA+@totalB 
) as g12_TOT_NW2 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=595 
AND C.shs_subjects_id=168 
AND A.report_history_id=rh.id) 
) as g12male_NW3, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=595 
AND C.shs_subjects_id=168 
AND A.report_history_id=rh.id) 
) as g12female_NW3, 
( 
@totalA+@totalB 
) as g12_TOT_NW3 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=595 
AND C.shs_subjects_id=169 
AND A.report_history_id=rh.id) 
) as g12male_EW1, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=595 
AND C.shs_subjects_id=169 
AND A.report_history_id=rh.id) 
) as g12female_EW1, 
( 
@totalA+@totalB 
) as g12_TOT_EW1 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=595 
AND C.shs_subjects_id=181 
AND A.report_history_id=rh.id) 
) as g12male_EW2, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=595 
AND C.shs_subjects_id=181 
AND A.report_history_id=rh.id) 
) as g12female_EW2, 
( 
@totalA+@totalB 
) as g12_TOT_EW2 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=595 
AND C.shs_subjects_id=182 
AND A.report_history_id=rh.id) 
) as g12male_SFTY1, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=595 
AND C.shs_subjects_id=182 
AND A.report_history_id=rh.id) 
) as g12female_SFTY1, 
( 
@totalA+@totalB 
) as g12_TOT_SFTY1 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=595 
AND C.shs_subjects_id=183 
AND A.report_history_id=rh.id) 
) as g12male_SFTY2, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=595 
AND C.shs_subjects_id=183 
AND A.report_history_id=rh.id) 
) as g12female_SFTY2, 
( 
@totalA+@totalB 
) as g12_TOT_SFTY2 ,
 
(
@totalA:=(SELECT 
IFNULL(SUM(A.male),0) FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=595 
AND C.shs_subjects_id=184 
AND A.report_history_id=rh.id) 
) as g12male_SCS, 
( 
@totalB:=(SELECT 
IFNULL(SUM(A.female),0) 
FROM ebeisdb.shs_enrolment_summary A INNER JOIN 
ebeisdb.shs_offerings B ON A.shs_offerings_id=B.id INNER JOIN 
ebeisdb.shs_tvl_enrolment_details C ON A.id=C.shs_enrolment_summary_id 
WHERE 
B.shs_track_id=906 -- TVL code 
AND A.grade_level_id=595 
AND C.shs_subjects_id=184 
AND A.report_history_id=rh.id) 
) as g12female_SCS, 
( 
@totalA+@totalB 
) as g12_TOT_SCS





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
g11male_NW1=VALUES(g11male_NW1),
 g11female_NW1=VALUES( g11female_NW1),
 g11_TOT_NW1 =VALUES( g11_TOT_NW1 ),
 g11male_NW2=VALUES( g11male_NW2),
 g11female_NW2=VALUES( g11female_NW2),
 g11_TOT_NW2 =VALUES( g11_TOT_NW2 ),
 g11male_NW3=VALUES( g11male_NW3),
 g11female_NW3=VALUES( g11female_NW3),
 g11_TOT_NW3 =VALUES( g11_TOT_NW3 ),
 g11male_EW1=VALUES( g11male_EW1),
 g11female_EW1=VALUES( g11female_EW1),
 g11_TOT_EW1 =VALUES( g11_TOT_EW1 ),
 g11male_EW2=VALUES( g11male_EW2),
 g11female_EW2=VALUES( g11female_EW2),
 g11_TOT_EW2 =VALUES( g11_TOT_EW2 ),
 g11male_SFTY1=VALUES( g11male_SFTY1),
 g11female_SFTY1=VALUES( g11female_SFTY1),
 g11_TOT_SFTY1 =VALUES( g11_TOT_SFTY1 ),
 g11male_SFTY2=VALUES( g11male_SFTY2),
 g11female_SFTY2=VALUES( g11female_SFTY2),
 g11_TOT_SFTY2 =VALUES( g11_TOT_SFTY2 ),
 g11male_SCS=VALUES( g11male_SCS),
 g11female_SCS=VALUES( g11female_SCS),
 g11_TOT_SCS =VALUES( g11_TOT_SCS ),
 g12male_NW1=VALUES( g12male_NW1),
 g12female_NW1=VALUES( g12female_NW1),
 g12_TOT_NW1 =VALUES( g12_TOT_NW1 ),
 g12male_NW2=VALUES( g12male_NW2),
 g12female_NW2=VALUES( g12female_NW2),
 g12_TOT_NW2 =VALUES( g12_TOT_NW2 ),
 g12male_NW3=VALUES( g12male_NW3),
 g12female_NW3=VALUES( g12female_NW3),
 g12_TOT_NW3 =VALUES( g12_TOT_NW3 ),
 g12male_EW1=VALUES( g12male_EW1),
 g12female_EW1=VALUES( g12female_EW1),
 g12_TOT_EW1 =VALUES( g12_TOT_EW1 ),
 g12male_EW2=VALUES( g12male_EW2),
 g12female_EW2=VALUES( g12female_EW2),
 g12_TOT_EW2 =VALUES( g12_TOT_EW2 ),
 g12male_SFTY1=VALUES( g12male_SFTY1),
 g12female_SFTY1=VALUES( g12female_SFTY1),
 g12_TOT_SFTY1 =VALUES( g12_TOT_SFTY1 ),
 g12male_SFTY2=VALUES( g12male_SFTY2),
 g12female_SFTY2=VALUES( g12female_SFTY2),
 g12_TOT_SFTY2 =VALUES( g12_TOT_SFTY2 ),
 g12male_SCS=VALUES( g12male_SCS),
 g12female_SCS=VALUES( g12female_SCS),
 g12_TOT_SCS=VALUES( g12_TOT_SCS);


COMMIT;











