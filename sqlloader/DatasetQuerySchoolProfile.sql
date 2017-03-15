INSERT INTO orsdb.school_profile_history
(sy_from, school_id, school_name, short_name, previous_name, school_head, designation, date_established, date_closed, 
closed_reason, status_of_operation, street_address, barangay_id, barangay, zip_code, region_id, region_shortname, region_name, 
province_id, province_name, municipality_id, municipality_name, legislative_id, legislative_name, division_id, division_name, 
district_id, district_name, telephone_no, fax_no, mobile_no, email_address, web_address, school_type_id, school_type, 
mother_school_id, mother_school, sector_id, sector, school_classification_id, school_classification, level_of_education_id, 
level_of_education, coc_id, curricular_offering_classification, cosclass_id, curricular_offering_subclassification, elem_class_id, 
elementary_classification, class_org_id, class_organization, mode_of_acquisition_id, school_site_mode_of_acquisition, 
proof_of_ownership_id, proof_of_ownership, ownership_issue_id, legal_ownership_issue, topography_id, topography, land_area) 

SELECT sph.sy_from AS SCHOOL_YEAR,sph.school_id AS SCHOOL_ID,convert(sph.SCHOOL_NAME using latin1) AS SCHOOL_NAME,
convert(sph.SHORT_NAME using latin1) AS SHORT_NAME,convert(sph.PREVIOUS_NAME using latin1) AS PREVIOUS_NAME,
convert(sph.SCHOOL_HEAD_NAME using latin1) AS SCHOOL_HEAD,convert(sph.SCHOOL_HEAD_POSITION_NAME using latin1) AS DESIGNATION,
sph.DATE_ESTABLISHED AS DATE_ESTABLISHED,sph.date_closed AS DATE_CLOSED,convert(sph.close_reason using latin1) AS CLOSED_REASON,
convert(if(sph.date_closed is not null, 'CLOSED', 'OPERATIONAL') using latin1) AS STATUS_OF_OPERATION,
convert(sph.STREET_ADDRESS using latin1) AS STREET_ADDRESS,sph.branggay_id AS BARANGAY_ID,
convert(ref_baranggay.brgy_name using latin1) AS BARANGAY,convert(sph.zip_cd using latin1) AS ZIP_CODE,sph.region_id AS REGION_ID,
ref_region.SHORT_NAME AS REGION_SHORTNAME,ref_region.REGION_NAME AS REGION_NAME,sph.province_id AS PROVINCE_ID,
ref_province.PROVINCE_NAME AS PROVINCE_NAME,sph.ref_municipality_id AS MUNICIPALITY_ID,
ref_municipality.MUNICIPALITY_NAME AS MUNICIPALITY_NAME,sph.ref_legislative_id AS LEGISLATIVE_ID,rld.DESCRIPTION AS LEGISLATIVE_NAME,
sph.division_id AS DIVISION_ID,ref_d.OFFICE_NAME AS DIVISION_NAME,sph.district_id AS DISTRICT_ID,
ref_dis.OFFICE_NAME AS DISTRICT_NAME,convert(sph.telephone_no using latin1) AS TELEPHONE_NO,
convert(sph.fax_no using latin1) AS FAX_NO,convert(sph.mobile_no using latin1) AS MOBILE_NO,
convert(sph.email_address using latin1) AS EMAIL_ADDRESS,convert(sph.web_address using latin1) AS WEB_ADDRESS,
sph.school_type_id AS SCHOOL_TYPE_ID,st.DESCRIPTION AS SCHOOL_TYPE,sph.MOTHER_SCHOOL_ID AS MOTHER_SCHOOL_ID,
convert(sph2.school_name using latin1) AS MOTHER_SCHOOL,sph.general_classification_id AS SECTOR_ID,
sect.description AS SECTOR,sph.school_subclassification_id AS SCHOOL_CLASSIFICATION_ID,subc.DESCRIPTION AS SCHOOL_CLASSIFICATION,
sph.co_gen_class AS LEVEL_OF_EDUCATION_ID,genc.DESCRIPTION AS LEVEL_OF_EDUCATION,sph.curricular_class_id AS COC_ID,
curr.DESCRIPTION AS CURRICULAR_OFFERING_CLASSIFICATION,sph.curricular_subclass_id AS COSCLASS_ID,
cosc.description AS CURRICULAR_OFFERING_SUBCLASSIFICATION,sph.elementary_class_id AS ELEM_CLASS_ID,
ec.description AS ELEMENTARY_CLASSIFICATION,sph.class_organization_id AS CLASS_ORG_ID,corg.DESCRIPTION AS CLASS_ORGANIZATION,
sph.site_ownership_id AS MODE_OF_ACQUISITION_ID,ssown.description AS SCHOOL_SITE_MODE_OF_ACQUISITION,
sph.proof_of_ownership_id AS PROOF_OF_OWNERSHIP_ID,ssproof.description AS PROOF_OF_OWNERSHIP,
sph.ownership_issue_id AS OWNERSHIP_ISSUE_ID,ownissue.description AS LEGAL_OWNERSHIP_ISSUE,sph.topography_id AS TOPOGRAPHY_ID,
tp.description AS TOPOGRAPHY,sph.land_area AS LAND_AREA        
  
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
ORDER BY sph.sy_from, ref_region.rank, sph.school_id;

INSERT INTO orsdb.school_profile_history(sy_from,school_id,school_name,short_name,previous_name,school_head,designation,
 date_established,date_closed,closed_reason,status_of_operation,street_address,barangay_id,barangay,zip_code,region_id,
 region_shortname,region_name,province_id,province_name,municipality_id,municipality_name,legislative_id,legislative_name,
 division_id,division_name,district_id,district_name,telephone_no,fax_no,mobile_no,email_address,web_address,school_type_id,
 school_type,mother_school_id,mother_school,sector_id,sector,school_classification_id,school_classification,level_of_education_id, 
 level_of_education,coc_id,curricular_offering_classification,cosclass_id,curricular_offering_subclassification,elem_class_id, 
 elementary_classification,class_org_id,class_organization,mode_of_acquisition_id,school_site_mode_of_acquisition, 
 proof_of_ownership_id,proof_of_ownership,ownership_issue_id,legal_ownership_issue,topography_id,topography,land_area,
 night_school,implementing_unit) 
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
ORDER BY sph.sy_from, ref_region.rank, sph.school_id;
commit;

