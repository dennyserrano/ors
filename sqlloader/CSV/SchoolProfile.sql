SELECT sph.sy_from,sph.school_id,sph.school_name,sph.short_name,sph.previous_name,sph.school_head_name,sph.school_head_position_name,
sph.date_established,sph.date_closed,sph.close_reason,if(sph.date_closed is not null,'CLOSED','OPERATIONAL'),sph.street_address,
sph.branggay_id,ref_baranggay.brgy_name,sph.zip_cd,sph.region_id,ref_region.short_name,ref_region.region_name,sph.province_id,
ref_province.province_name,sph.ref_municipality_id,ref_municipality.municipality_name,sph.ref_legislative_id,rld.description,
sph.division_id,ref_d.office_name,sph.district_id,ref_dis.office_name,sph.telephone_no,sph.fax_no,sph.mobile_no,sph.email_address,
sph.web_address,sph.school_type_id,st.description,sph.mother_school_id,sph2.school_name,sph.general_classification_id,
sect.description,sph.school_subclassification_id,subc.description,sph.co_gen_class,genc.description,sph.curricular_class_id,
curr.description,sph.curricular_subclass_id,cosc.description,sph.elementary_class_id,ec.description,sph.class_organization_id,
corg.description,sph.site_ownership_id,ssown.description,sph.proof_of_ownership_id,ssproof.description,sph.ownership_issue_id,
ownissue.description,sph.topography_id,tp.description,sph.land_area,sph.night_school,sph.implementing_unit       
  
FROM ebeisdb.school_profile_history sph
INNER JOIN ebeisdb.ref_region
  ON (sph.REGION_ID = ref_region.ID)
LEFT JOIN ebeisdb.ref_municipality
  ON (sph.REF_MUNICIPALITY_ID = ref_municipality.ID)
LEFT JOIN ebeisdb.ref_province
  ON (ref_municipality.REF_PROVINCE_ID = ref_province.ID)
LEFT JOIN ebeisdb.ref_office ref_d
  ON (sph.DIVISION_ID = ref_d.ID)
LEFT JOIN ebeisdb.ref_office ref_dis
  ON (sph.DISTRICT_ID = ref_dis.ID)
LEFT JOIN ebeisdb.ref_legislative
  ON (sph.REF_LEGISLATIVE_ID = ref_legislative.ID)
LEFT JOIN ebeisdb.ref_code_setting rld
  ON (ref_legislative.DISTRICT_LABEL = rld.ID)
LEFT JOIN ebeisdb.ref_baranggay
  ON (sph.branggay_id = ref_baranggay.id)
LEFT JOIN ebeisdb.ref_municipality rlm
  ON (ref_legislative.REF_MUNICIPALITY_ID = rlm.ID)
LEFT JOIN ebeisdb.ref_province rlp
  ON (ref_legislative.REF_PROVINCE_ID = rlp.ID)
LEFT JOIN ebeisdb.ref_code_setting st
  ON (sph.SCHOOL_TYPE_ID = st.ID)
LEFT JOIN ebeisdb.ref_code_setting genc
  ON (sph.CO_GEN_CLASS = genc.ID)
LEFT JOIN ebeisdb.ref_code_setting sect
  ON (sph.general_classification_id = sect.id)
LEFT JOIN ebeisdb.ref_code_setting subc
  ON (sph.SCHOOL_SUBCLASSIFICATION_ID = subc.ID)
LEFT JOIN ebeisdb.ref_code_setting curr
  ON (sph.CURRICULAR_CLASS_ID = curr.ID)
LEFT JOIN ebeisdb.ref_code_setting corg
  ON (sph.CLASS_ORGANIZATION_ID = corg.ID)
LEFT JOIN ebeisdb.ref_income_class inc
  ON (ref_municipality.INCOMECLASS = inc.ID)
LEFT JOIN ebeisdb.school_profile_history sph2
  ON (sph2.school_id = sph.mother_school_id and sph2.sy_from = sph.sy_from)
LEFT JOIN ebeisdb.ref_code_setting cosc
  ON (sph.curricular_subclass_id = cosc.id)
LEFT JOIN ebeisdb.ref_code_setting ec
  ON (sph.elementary_class_id = ec.id)
LEFT JOIN ebeisdb.ref_code_setting ssown
  ON (sph.site_ownership_id = ssown.id)
LEFT JOIN ebeisdb.ref_code_setting ssproof
  ON (sph.proof_of_ownership_id = ssproof.id)
LEFT JOIN ebeisdb.ref_code_setting ownissue
  ON (sph.ownership_issue_id = ownissue.id)
LEFT JOIN ebeisdb.ref_code_setting tp
  ON (sph.topography_id = tp.id)
where sph.sy_from=2016 and sph.co_gen_class=434 and sph.general_classification_id=8 and sph.take_part_id=1
ORDER BY sph.sy_from, ref_region.rank, sph.school_id

INTO OUTFILE '/var/tmp/schoolprofile.csv'
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n';

