insert into orsdb.mother_tongue(sy_from,school_id,akianon,bikol,cebuano,chabacano,hiligaynon,ibanag,iloko,ivatan,kapampangan,
kinaraya,maguindanaon,maranao,pangasinense,sambal,surigaonon,tagalog,tausug,waray,yakan,others)

select sph.sy_from, sph.school_id, ifnull(osd.mtbmle_akianon,0), ifnull(osd.mtbmle_bikol,0), ifnull(osd.mtbmle_cebuano,0), 
ifnull(osd.mtbmle_chabacano,0), ifnull(osd.mtbmle_hiligaynon,0), ifnull(osd.mtbmle_ibanag,0), ifnull(osd.mtbmle_iloko,0), 
ifnull(osd.mtbmle_ivatan,0), ifnull(osd.mtbmle_kapampangan,0), ifnull(osd.mtbmle_kinaraya,0), ifnull(osd.mtbmle_magiundanaon,0), 
ifnull(osd.mtbmle_maranao,0), ifnull(osd.mtbmle_pangasinense,0), ifnull(osd.mtbmle_sambal,0), ifnull(osd.mtbmle_surigaonon,0), 
ifnull(osd.mtbmle_tagalog,0), ifnull(osd.mtbmle_tausug,0), ifnull(osd.mtbmle_waray,0), ifnull(osd.mtbmle_yakan,0), osd.mtbmle_others
 
FROM ebeisdb.school_profile_history sph
   LEFT JOIN ref_region rr on (rr.id = sph.region_id)
   LEFT JOIN (ebeisdb.report_history rh 
	      inner join ebeisdb.ref_report_history rrh on rh.ref_report_history_id = rrh.id
	      inner join ebeisdb.ref_reports rrs on rrs.id  = rrh.report_id
	      inner join ebeisdb.ref_report_generics rrg on rrg.id = rrs.ref_report_generics_id and rrg.id=1
	 ) on rh.school_id = sph.school_id and rh.sy_from= sph.sy_from and rh.report_status > 300 -- cast( sph.sy_from as unsigned)
   LEFT JOIN ebeisdb.other_school_data osd on (osd.report_history_id = rh.id)
   WHERE  sph.take_part_id IN (1,2,3) and sph.general_classification_id = 7 and sph.sy_from BETWEEN 2016 and 2016 and sph.co_gen_class = 433 
   GROUP BY rh.sy_from, sph.SCHOOL_ID 
   ORDER BY sph.SY_FROM, rr.RANK ASC, sph.SCHOOL_ID ASC;

commit;
