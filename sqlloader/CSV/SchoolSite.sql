select sph.sy_from, sph.school_id,if(sph.sy_from=2016,if(sph.site_ownership_id>0,so.description,""),""), 
if(sph.sy_from=2016,if(sph.proof_of_ownership_id>0,po.description,""),""),
if(sph.sy_from=2016,if(sph.ownership_issue_id>0,oi.description,""),""),
if(sph.sy_from=2016,if(sph.topography_id>0,ti.description,""),""),
ifnull(osd.yr_donation,0), ifnull(osd.yr_purchase,0), ifnull(osd.yr_usufruct,0), 
ifnull(osd.yr_expropriation,0), ifnull(osd.yr_exchange,0), ifnull(osd.yr_ppsp,0), ifnull(osd.yr_others,""), 
ifnull(osd.proof_title,0), ifnull(osd.proof_tax,0), ifnull(osd.proof_sale,0), ifnull(osd.proof_donation,0), 
ifnull(osd.proof_ppsp,0), ifnull(osd.proof_usufruct,0), ifnull(osd.proof_moa,0), ifnull(osd.proof_others,""), 
ifnull(osd.legal_adverse,0), ifnull(osd.legal_encroach,0), ifnull(osd.legal_others,""), ifnull(osd.topography_flat,0), 
ifnull(osd.topography_rolling,0), ifnull(osd.topography_hilly,0), ifnull(osd.topography_others,""),
ifnull(if(sph.sy_from=2016,sph.land_area,osd.land_area),0)
 
FROM ebeisdb.school_profile_history sph
   LEFT JOIN ref_region rr on (rr.id = sph.region_id)
   LEFT JOIN (ebeisdb.report_history rh 
	      inner join ebeisdb.ref_report_history rrh on rh.ref_report_history_id = rrh.id
	      inner join ebeisdb.ref_reports rrs on rrs.id  = rrh.report_id
	      inner join ebeisdb.ref_report_generics rrg on rrg.id = rrs.ref_report_generics_id and rrg.id=1
	 ) on rh.school_id = sph.school_id and rh.sy_from= sph.sy_from and rh.report_status > 300 -- cast( sph.sy_from as unsigned)
   LEFT JOIN ebeisdb.other_school_data osd on (osd.report_history_id = rh.id)
   LEFT JOIN ebeisdb.ref_code_setting so on (so.id = sph.site_ownership_id)
   LEFT JOIN ebeisdb.ref_code_setting po on (po.id = sph.proof_of_ownership_id)
   LEFT JOIN ebeisdb.ref_code_setting oi on (oi.id = sph.ownership_issue_id)
   LEFT JOIN ebeisdb.ref_code_setting ti on (ti.id = sph.topography_id)
   WHERE  sph.take_part_id IN (1,2,3) and sph.general_classification_id = 7 and sph.sy_from = 2016
   GROUP BY rh.sy_from, sph.SCHOOL_ID 
   ORDER BY sph.SY_FROM, rr.RANK ASC, sph.SCHOOL_ID ASC

INTO OUTFILE '/var/tmp/schoolsite.csv'
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n';
