select 'sy_from', 'schoolid', 'teacher_within_brgy', 'teacher_outside_brgy','teacher_within_citymun','teacher_outside_citymun'

UNION ALL

select sph.sy_from, sph.school_id as schoolid, ifnull(osd.teacher_within_brgy,0) as teacher_within_brgy, ifnull(osd.teacher_outside_brgy,0) as teacher_outside_brgy, 
ifnull(osd.teacher_within_citymun,0) as teacher_within_citymun, ifnull(osd.teacher_outside_citymun,0) as teacher_outside_citymun
 
FROM ebeisdb.school_profile_history sph
   LEFT JOIN ref_region rr on (rr.id = sph.region_id)
   LEFT JOIN (ebeisdb.report_history rh 
	      inner join ebeisdb.ref_report_history rrh on rh.ref_report_history_id = rrh.id
	      inner join ebeisdb.ref_reports rrs on rrs.id  = rrh.report_id
	      inner join ebeisdb.ref_report_generics rrg on rrg.id = rrs.ref_report_generics_id and rrg.id=2
	 ) on rh.school_id = sph.school_id and rh.sy_from= sph.sy_from and rh.report_status > 300 -- cast( sph.sy_from as unsigned)
   LEFT JOIN ebeisdb.other_school_data osd on (osd.report_history_id = rh.id)
   WHERE  sph.take_part_id IN (1,2,3) and sph.general_classification_id = 7 and sph.sy_from = 2016
   GROUP BY rh.sy_from, sph.SCHOOL_ID 
   ORDER BY sph.SY_FROM, rr.RANK ASC, sph.SCHOOL_ID ASC


INTO OUTFILE '/var/tmp/teachbyresidence.csv'
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n';
