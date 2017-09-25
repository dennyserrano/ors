
SET @dataset_parent_id=9025;
SET @dataset_table_id=1;
-- TABLE METADATA

SET @table_id=@dataset_table_id;
SET @parent_id=@dataset_parent_id;
SET @table_column_id=1;
SET @table_column_syfrom=1;

INSERT INTO orsdb.dataset_head
(name,description,owner_id,date_created,created_by,date_updated,updated_by,visible,parent_dataset_head,table_id,ranking)
VALUES
(
'Agri-Fishery Arts',
'Agri-Fishery Arts',
0,
CURDATE(),
'SYSTEM',
CURDATE(),
'SYSTEM',
1,
@parent_id,
@table_id,
921
);


SET @dataset_head_id=LAST_INSERT_ID();

-- COLUMN METADATA


INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(@table_column_id,NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','id','id','id',@dataset_head_id,0);


INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(@table_column_syfrom,NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','sy_from','sy_from','sy_from',@dataset_head_id,0);


INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES(@table_id,'school_id','int',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','school_id','school_id','school_id',@dataset_head_id,0);



 INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_ACPI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_ACPI','Grade 11 Male Agricultural Crops Production (NC I)','Grade 11 Male Agricultural Crops Production (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_ACPI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_ACPI','Grade 11 Female Agricultural Crops Production (NC I)','Grade 11 Female Agricultural Crops Production (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_ACPI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_ACPI','Grade 11 Total Agricultural Crops Production (NC I)','Grade 11 Total Agricultural Crops Production (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_ACPI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_ACPI','Grade 12 Male Agricultural Crops Production (NC I)','Grade 12 Male Agricultural Crops Production (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_ACPI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_ACPI','Grade 12 Female Agricultural Crops Production (NC I)','Grade 12 Female Agricultural Crops Production (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_ACPI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_ACPI','Grade 12 Total Agricultural Crops Production (NC I)','Grade 12 Total Agricultural Crops Production (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_ACPI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_ACPI','Total Male for Agricultural Crops Production (NC I)','Total Male for Agricultural Crops Production (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_ACPI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_ACPI','Total Female for Agricultural Crops Production (NC I)','Total Female for Agricultural Crops Production (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_ACPI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_ACPI','Total Agricultural Crops Production (NC I)','Total Agricultural Crops Production (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_ACPII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_ACPII','Grade 11 Male Agricultural Crops Production (NC II)','Grade 11 Male Agricultural Crops Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_ACPII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_ACPII','Grade 11 Female Agricultural Crops Production (NC II)','Grade 11 Female Agricultural Crops Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_ACPII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_ACPII','Grade 11 Total Agricultural Crops Production (NC II)','Grade 11 Total Agricultural Crops Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_ACPII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_ACPII','Grade 12 Male Agricultural Crops Production (NC II)','Grade 12 Male Agricultural Crops Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_ACPII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_ACPII','Grade 12 Female Agricultural Crops Production (NC II)','Grade 12 Female Agricultural Crops Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_ACPII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_ACPII','Grade 12 Total Agricultural Crops Production (NC II)','Grade 12 Total Agricultural Crops Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_ACPII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_ACPII','Total Male for Agricultural Crops Production (NC II)','Total Male for Agricultural Crops Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_ACPII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_ACPII','Total Female for Agricultural Crops Production (NC II)','Total Female for Agricultural Crops Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_ACPII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_ACPII','Total Agricultural Crops Production (NC II)','Total Agricultural Crops Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_ACPIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_ACPIII','Grade 11 Male Agricultural Crops Production (NC III)','Grade 11 Male Agricultural Crops Production (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_ACPIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_ACPIII','Grade 11 Female Agricultural Crops Production (NC III)','Grade 11 Female Agricultural Crops Production (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_ACPIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_ACPIII','Grade 11 Total Agricultural Crops Production (NC III)','Grade 11 Total Agricultural Crops Production (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_ACPIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_ACPIII','Grade 12 Male Agricultural Crops Production (NC III)','Grade 12 Male Agricultural Crops Production (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_ACPIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_ACPIII','Grade 12 Female Agricultural Crops Production (NC III)','Grade 12 Female Agricultural Crops Production (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_ACPIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_ACPIII','Grade 12 Total Agricultural Crops Production (NC III)','Grade 12 Total Agricultural Crops Production (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_ACPIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_ACPIII','Total Male for Agricultural Crops Production (NC III)','Total Male for Agricultural Crops Production (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_ACPIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_ACPIII','Total Female for Agricultural Crops Production (NC III)','Total Female for Agricultural Crops Production (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_ACPIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_ACPIII','Total Agricultural Crops Production (NC III)','Total Agricultural Crops Production (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_AHCM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_AHCM','Grade 11 Male Animal Health Care Management (NC III)','Grade 11 Male Animal Health Care Management (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_AHCM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_AHCM','Grade 11 Female Animal Health Care Management (NC III)','Grade 11 Female Animal Health Care Management (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_AHCM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_AHCM','Grade 11 Total Animal Health Care Management (NC III)','Grade 11 Total Animal Health Care Management (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_AHCM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_AHCM','Grade 12 Male Animal Health Care Management (NC III)','Grade 12 Male Animal Health Care Management (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_AHCM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_AHCM','Grade 12 Female Animal Health Care Management (NC III)','Grade 12 Female Animal Health Care Management (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_AHCM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_AHCM','Grade 12 Total Animal Health Care Management (NC III)','Grade 12 Total Animal Health Care Management (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_AHCM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_AHCM','Total Male for Animal Health Care Management (NC III)','Total Male for Animal Health Care Management (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_AHCM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_AHCM','Total Female for Animal Health Care Management (NC III)','Total Female for Animal Health Care Management (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_AHCM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_AHCM','Total Animal Health Care Management (NC III)','Total Animal Health Care Management (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_APPC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_APPC','Grade 11 Male Animal Production (Poultry-Chicken) (NC II)','Grade 11 Male Animal Production (Poultry-Chicken) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_APPC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_APPC','Grade 11 Female Animal Production (Poultry-Chicken) (NC II)','Grade 11 Female Animal Production (Poultry-Chicken) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_APPC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_APPC','Grade 11 Total Animal Production (Poultry-Chicken) (NC II)','Grade 11 Total Animal Production (Poultry-Chicken) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_APPC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_APPC','Grade 12 Male Animal Production (Poultry-Chicken) (NC II)','Grade 12 Male Animal Production (Poultry-Chicken) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_APPC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_APPC','Grade 12 Female Animal Production (Poultry-Chicken) (NC II)','Grade 12 Female Animal Production (Poultry-Chicken) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_APPC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_APPC','Grade 12 Total Animal Production (Poultry-Chicken) (NC II)','Grade 12 Total Animal Production (Poultry-Chicken) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_APPC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_APPC','Total Male for Animal Production (Poultry-Chicken) (NC II)','Total Male for Animal Production (Poultry-Chicken) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_APPC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_APPC','Total Female for Animal Production (Poultry-Chicken) (NC II)','Total Female for Animal Production (Poultry-Chicken) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_APPC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_APPC','Total Animal Production (Poultry-Chicken) (NC II)','Total Animal Production (Poultry-Chicken) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_APLR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_APLR','Grade 11 Male Animal Production (Large Ruminants) (NC II)','Grade 11 Male Animal Production (Large Ruminants) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_APLR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_APLR','Grade 11 Female Animal Production (Large Ruminants) (NC II)','Grade 11 Female Animal Production (Large Ruminants) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_APLR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_APLR','Grade 11 Total Animal Production (Large Ruminants) (NC II)','Grade 11 Total Animal Production (Large Ruminants) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_APLR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_APLR','Grade 12 Male Animal Production (Large Ruminants) (NC II)','Grade 12 Male Animal Production (Large Ruminants) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_APLR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_APLR','Grade 12 Female Animal Production (Large Ruminants) (NC II)','Grade 12 Female Animal Production (Large Ruminants) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_APLR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_APLR','Grade 12 Total Animal Production (Large Ruminants) (NC II)','Grade 12 Total Animal Production (Large Ruminants) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_APLR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_APLR','Total Male for Animal Production (Large Ruminants) (NC II)','Total Male for Animal Production (Large Ruminants) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_APLR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_APLR','Total Female for Animal Production (Large Ruminants) (NC II)','Total Female for Animal Production (Large Ruminants) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_APLR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_APLR','Total Animal Production (Large Ruminants) (NC II)','Total Animal Production (Large Ruminants) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_APS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_APS','Grade 11 Male Animal Production (Swine) (NC II)','Grade 11 Male Animal Production (Swine) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_APS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_APS','Grade 11 Female Animal Production (Swine) (NC II)','Grade 11 Female Animal Production (Swine) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_APS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_APS','Grade 11 Total Animal Production (Swine) (NC II)','Grade 11 Total Animal Production (Swine) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_APS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_APS','Grade 12 Male Animal Production (Swine) (NC II)','Grade 12 Male Animal Production (Swine) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_APS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_APS','Grade 12 Female Animal Production (Swine) (NC II)','Grade 12 Female Animal Production (Swine) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_APS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_APS','Grade 12 Total Animal Production (Swine) (NC II)','Grade 12 Total Animal Production (Swine) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_APS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_APS','Total Male for Animal Production (Swine) (NC II)','Total Male for Animal Production (Swine) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_APS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_APS','Total Female for Animal Production (Swine) (NC II)','Total Female for Animal Production (Swine) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_APS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_APS','Total Animal Production (Swine) (NC II)','Total Animal Production (Swine) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_AQUA','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_AQUA','Grade 11 Male Aquaculture (NC II)','Grade 11 Male Aquaculture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_AQUA','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_AQUA','Grade 11 Female Aquaculture (NC II)','Grade 11 Female Aquaculture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_AQUA','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_AQUA','Grade 11 Total Aquaculture (NC II)','Grade 11 Total Aquaculture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_AQUA','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_AQUA','Grade 12 Male Aquaculture (NC II)','Grade 12 Male Aquaculture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_AQUA','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_AQUA','Grade 12 Female Aquaculture (NC II)','Grade 12 Female Aquaculture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_AQUA','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_AQUA','Grade 12 Total Aquaculture (NC II)','Grade 12 Total Aquaculture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_AQUA','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_AQUA','Total Male for Aquaculture (NC II)','Total Male for Aquaculture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_AQUA','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_AQUA','Total Female for Aquaculture (NC II)','Total Female for Aquaculture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_AQUA','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_AQUA','Total Aquaculture (NC II)','Total Aquaculture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_AILR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_AILR','Grade 11 Male Artificial Insemination (Large Ruminants) (NC II)','Grade 11 Male Artificial Insemination (Large Ruminants) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_AILR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_AILR','Grade 11 Female Artificial Insemination (Large Ruminants) (NC II)','Grade 11 Female Artificial Insemination (Large Ruminants) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_AILR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_AILR','Grade 11 Total Artificial Insemination (Large Ruminants) (NC II)','Grade 11 Total Artificial Insemination (Large Ruminants) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_AILR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_AILR','Grade 12 Male Artificial Insemination (Large Ruminants) (NC II)','Grade 12 Male Artificial Insemination (Large Ruminants) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_AILR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_AILR','Grade 12 Female Artificial Insemination (Large Ruminants) (NC II)','Grade 12 Female Artificial Insemination (Large Ruminants) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_AILR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_AILR','Grade 12 Total Artificial Insemination (Large Ruminants) (NC II)','Grade 12 Total Artificial Insemination (Large Ruminants) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_AILR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_AILR','Total Male for Artificial Insemination (Large Ruminants) (NC II)','Total Male for Artificial Insemination (Large Ruminants) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_AILR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_AILR','Total Female for Artificial Insemination (Large Ruminants) (NC II)','Total Female for Artificial Insemination (Large Ruminants) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_AILR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_AILR','Total Artificial Insemination (Large Ruminants) (NC II)','Total Artificial Insemination (Large Ruminants) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_AIS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_AIS','Grade 11 Male Artificial Insemination (Swine) (NC II)','Grade 11 Male Artificial Insemination (Swine) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_AIS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_AIS','Grade 11 Female Artificial Insemination (Swine) (NC II)','Grade 11 Female Artificial Insemination (Swine) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_AIS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_AIS','Grade 11 Total Artificial Insemination (Swine) (NC II)','Grade 11 Total Artificial Insemination (Swine) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_AIS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_AIS','Grade 12 Male Artificial Insemination (Swine) (NC II)','Grade 12 Male Artificial Insemination (Swine) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_AIS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_AIS','Grade 12 Female Artificial Insemination (Swine) (NC II)','Grade 12 Female Artificial Insemination (Swine) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_AIS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_AIS','Grade 12 Total Artificial Insemination (Swine) (NC II)','Grade 12 Total Artificial Insemination (Swine) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_AIS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_AIS','Total Male for Artificial Insemination (Swine) (NC II)','Total Male for Artificial Insemination (Swine) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_AIS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_AIS','Total Female for Artificial Insemination (Swine) (NC II)','Total Female for Artificial Insemination (Swine) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_AIS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_AIS','Total Artificial Insemination (Swine) (NC II)','Total Artificial Insemination (Swine) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_FC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_FC','Grade 11 Male Fish Capture (NC II)','Grade 11 Male Fish Capture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_FC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_FC','Grade 11 Female Fish Capture (NC II)','Grade 11 Female Fish Capture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_FC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_FC','Grade 11 Total Fish Capture (NC II)','Grade 11 Total Fish Capture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_FC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_FC','Grade 12 Male Fish Capture (NC II)','Grade 12 Male Fish Capture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_FC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_FC','Grade 12 Female Fish Capture (NC II)','Grade 12 Female Fish Capture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_FC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_FC','Grade 12 Total Fish Capture (NC II)','Grade 12 Total Fish Capture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_FC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_FC','Total Male for Fish Capture (NC II)','Total Male for Fish Capture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_FC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_FC','Total Female for Fish Capture (NC II)','Total Female for Fish Capture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_FC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_FC','Total Fish Capture (NC II)','Total Fish Capture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_FGRM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_FGRM','Grade 11 Male Fishing Gear Repair and Maintenance (NC III)','Grade 11 Male Fishing Gear Repair and Maintenance (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_FGRM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_FGRM','Grade 11 Female Fishing Gear Repair and Maintenance (NC III)','Grade 11 Female Fishing Gear Repair and Maintenance (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_FGRM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_FGRM','Grade 11 Total Fishing Gear Repair and Maintenance (NC III)','Grade 11 Total Fishing Gear Repair and Maintenance (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_FGRM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_FGRM','Grade 12 Male Fishing Gear Repair and Maintenance (NC III)','Grade 12 Male Fishing Gear Repair and Maintenance (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_FGRM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_FGRM','Grade 12 Female Fishing Gear Repair and Maintenance (NC III)','Grade 12 Female Fishing Gear Repair and Maintenance (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_FGRM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_FGRM','Grade 12 Total Fishing Gear Repair and Maintenance (NC III)','Grade 12 Total Fishing Gear Repair and Maintenance (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_FGRM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_FGRM','Total Male for Fishing Gear Repair and Maintenance (NC III)','Total Male for Fishing Gear Repair and Maintenance (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_FGRM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_FGRM','Total Female for Fishing Gear Repair and Maintenance (NC III)','Total Female for Fishing Gear Repair and Maintenance (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_FGRM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_FGRM','Total Fishing Gear Repair and Maintenance (NC III)','Total Fishing Gear Repair and Maintenance (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_FPP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_FPP','Grade 11 Male Fish-Products Packaging (NC II)','Grade 11 Male Fish-Products Packaging (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_FPP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_FPP','Grade 11 Female Fish-Products Packaging (NC II)','Grade 11 Female Fish-Products Packaging (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_FPP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_FPP','Grade 11 Total Fish-Products Packaging (NC II)','Grade 11 Total Fish-Products Packaging (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_FPP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_FPP','Grade 12 Male Fish-Products Packaging (NC II)','Grade 12 Male Fish-Products Packaging (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_FPP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_FPP','Grade 12 Female Fish-Products Packaging (NC II)','Grade 12 Female Fish-Products Packaging (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_FPP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_FPP','Grade 12 Total Fish-Products Packaging (NC II)','Grade 12 Total Fish-Products Packaging (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_FPP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_FPP','Total Male for Fish-Products Packaging (NC II)','Total Male for Fish-Products Packaging (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_FPP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_FPP','Total Female for Fish-Products Packaging (NC II)','Total Female for Fish-Products Packaging (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_FPP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_FPP','Total Fish-Products Packaging (NC II)','Total Fish-Products Packaging (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_FWO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_FWO','Grade 11 Male Fish Wharf Operation (NC I)','Grade 11 Male Fish Wharf Operation (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_FWO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_FWO','Grade 11 Female Fish Wharf Operation (NC I)','Grade 11 Female Fish Wharf Operation (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_FWO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_FWO','Grade 11 Total Fish Wharf Operation (NC I)','Grade 11 Total Fish Wharf Operation (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_FWO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_FWO','Grade 12 Male Fish Wharf Operation (NC I)','Grade 12 Male Fish Wharf Operation (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_FWO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_FWO','Grade 12 Female Fish Wharf Operation (NC I)','Grade 12 Female Fish Wharf Operation (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_FWO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_FWO','Grade 12 Total Fish Wharf Operation (NC I)','Grade 12 Total Fish Wharf Operation (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_FWO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_FWO','Total Male for Fish Wharf Operation (NC I)','Total Male for Fish Wharf Operation (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_FWO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_FWO','Total Female for Fish Wharf Operation (NC I)','Total Female for Fish Wharf Operation (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_FWO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_FWO','Total Fish Wharf Operation (NC I)','Total Fish Wharf Operation (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_FP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_FP','Grade 11 Male Food Processing (NC II)','Grade 11 Male Food Processing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_FP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_FP','Grade 11 Female Food Processing (NC II)','Grade 11 Female Food Processing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_FP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_FP','Grade 11 Total Food Processing (NC II)','Grade 11 Total Food Processing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_FP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_FP','Grade 12 Male Food Processing (NC II)','Grade 12 Male Food Processing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_FP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_FP','Grade 12 Female Food Processing (NC II)','Grade 12 Female Food Processing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_FP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_FP','Grade 12 Total Food Processing (NC II)','Grade 12 Total Food Processing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_FP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_FP','Total Male for Food Processing (NC II)','Total Male for Food Processing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_FP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_FP','Total Female for Food Processing (NC II)','Total Female for Food Processing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_FP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_FP','Total Food Processing (NC II)','Total Food Processing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_HORT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_HORT','Grade 11 Male Horticulture (NC III)','Grade 11 Male Horticulture (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_HORT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_HORT','Grade 11 Female Horticulture (NC III)','Grade 11 Female Horticulture (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_HORT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_HORT','Grade 11 Total Horticulture (NC III)','Grade 11 Total Horticulture (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_HORT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_HORT','Grade 12 Male Horticulture (NC III)','Grade 12 Male Horticulture (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_HORT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_HORT','Grade 12 Female Horticulture (NC III)','Grade 12 Female Horticulture (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_HORT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_HORT','Grade 12 Total Horticulture (NC III)','Grade 12 Total Horticulture (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_HORT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_HORT','Total Male for Horticulture (NC III)','Total Male for Horticulture (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_HORT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_HORT','Total Female for Horticulture (NC III)','Total Female for Horticulture (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_HORT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_HORT','Total Horticulture (NC III)','Total Horticulture (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_LIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_LIM','Grade 11 Male Landscape Installation and Maintenance (NC II)','Grade 11 Male Landscape Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_LIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_LIM','Grade 11 Female Landscape Installation and Maintenance (NC II)','Grade 11 Female Landscape Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_LIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_LIM','Grade 11 Total Landscape Installation and Maintenance (NC II)','Grade 11 Total Landscape Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_LIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_LIM','Grade 12 Male Landscape Installation and Maintenance (NC II)','Grade 12 Male Landscape Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_LIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_LIM','Grade 12 Female Landscape Installation and Maintenance (NC II)','Grade 12 Female Landscape Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_LIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_LIM','Grade 12 Total Landscape Installation and Maintenance (NC II)','Grade 12 Total Landscape Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_LIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_LIM','Total Male for Landscape Installation and Maintenance (NC II)','Total Male for Landscape Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_LIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_LIM','Total Female for Landscape Installation and Maintenance (NC II)','Total Female for Landscape Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_LIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_LIM','Total Landscape Installation and Maintenance (NC II)','Total Landscape Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_OA','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_OA','Grade 11 Male Organic Agriculture (NC II)','Grade 11 Male Organic Agriculture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_OA','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_OA','Grade 11 Female Organic Agriculture (NC II)','Grade 11 Female Organic Agriculture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_OA','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_OA','Grade 11 Total Organic Agriculture (NC II)','Grade 11 Total Organic Agriculture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_OA','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_OA','Grade 12 Male Organic Agriculture (NC II)','Grade 12 Male Organic Agriculture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_OA','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_OA','Grade 12 Female Organic Agriculture (NC II)','Grade 12 Female Organic Agriculture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_OA','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_OA','Grade 12 Total Organic Agriculture (NC II)','Grade 12 Total Organic Agriculture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_OA','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_OA','Total Male for Organic Agriculture (NC II)','Total Male for Organic Agriculture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_OA','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_OA','Total Female for Organic Agriculture (NC II)','Total Female for Organic Agriculture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_OA','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_OA','Total Organic Agriculture (NC II)','Total Organic Agriculture (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_PM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_PM','Grade 11 Male Pest Management (NC II)','Grade 11 Male Pest Management (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_PM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_PM','Grade 11 Female Pest Management (NC II)','Grade 11 Female Pest Management (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_PM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_PM','Grade 11 Total Pest Management (NC II)','Grade 11 Total Pest Management (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_PM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_PM','Grade 12 Male Pest Management (NC II)','Grade 12 Male Pest Management (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_PM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_PM','Grade 12 Female Pest Management (NC II)','Grade 12 Female Pest Management (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_PM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_PM','Grade 12 Total Pest Management (NC II)','Grade 12 Total Pest Management (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_PM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_PM','Total Male for Pest Management (NC II)','Total Male for Pest Management (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_PM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_PM','Total Female for Pest Management (NC II)','Total Female for Pest Management (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_PM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_PM','Total Pest Management (NC II)','Total Pest Management (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_RMO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_RMO','Grade 11 Male Rice Machinery Operations (NC II)','Grade 11 Male Rice Machinery Operations (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_RMO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_RMO','Grade 11 Female Rice Machinery Operations (NC II)','Grade 11 Female Rice Machinery Operations (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_RMO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_RMO','Grade 11 Total Rice Machinery Operations (NC II)','Grade 11 Total Rice Machinery Operations (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_RMO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_RMO','Grade 12 Male Rice Machinery Operations (NC II)','Grade 12 Male Rice Machinery Operations (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_RMO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_RMO','Grade 12 Female Rice Machinery Operations (NC II)','Grade 12 Female Rice Machinery Operations (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_RMO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_RMO','Grade 12 Total Rice Machinery Operations (NC II)','Grade 12 Total Rice Machinery Operations (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_RMO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_RMO','Total Male for Rice Machinery Operations (NC II)','Total Male for Rice Machinery Operations (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_RMO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_RMO','Total Female for Rice Machinery Operations (NC II)','Total Female for Rice Machinery Operations (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_RMO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_RMO','Total Rice Machinery Operations (NC II)','Total Rice Machinery Operations (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_RP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_RP','Grade 11 Male Rubber Processing (NC II)','Grade 11 Male Rubber Processing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_RP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_RP','Grade 11 Female Rubber Processing (NC II)','Grade 11 Female Rubber Processing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_RP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_RP','Grade 11 Total Rubber Processing (NC II)','Grade 11 Total Rubber Processing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_RP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_RP','Grade 12 Male Rubber Processing (NC II)','Grade 12 Male Rubber Processing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_RP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_RP','Grade 12 Female Rubber Processing (NC II)','Grade 12 Female Rubber Processing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_RP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_RP','Grade 12 Total Rubber Processing (NC II)','Grade 12 Total Rubber Processing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_RP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_RP','Total Male for Rubber Processing (NC II)','Total Male for Rubber Processing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_RP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_RP','Total Female for Rubber Processing (NC II)','Total Female for Rubber Processing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_RP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_RP','Total Rubber Processing (NC II)','Total Rubber Processing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_RUBPROD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_RUBPROD','Grade 11 Male Rubber Production (NC II)','Grade 11 Male Rubber Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_RUBPROD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_RUBPROD','Grade 11 Female Rubber Production (NC II)','Grade 11 Female Rubber Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_RUBPROD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_RUBPROD','Grade 11 Total Rubber Production (NC II)','Grade 11 Total Rubber Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_RUBPROD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_RUBPROD','Grade 12 Male Rubber Production (NC II)','Grade 12 Male Rubber Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_RUBPROD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_RUBPROD','Grade 12 Female Rubber Production (NC II)','Grade 12 Female Rubber Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_RUBPROD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_RUBPROD','Grade 12 Total Rubber Production (NC II)','Grade 12 Total Rubber Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_RUBPROD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_RUBPROD','Total Male for Rubber Production (NC II)','Total Male for Rubber Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_RUBPROD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_RUBPROD','Total Female for Rubber Production (NC II)','Total Female for Rubber Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_RUBPROD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_RUBPROD','Total Rubber Production (NC II)','Total Rubber Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_SO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_SO','Grade 11 Male Slaughtering Operations (Hog/Swine/Pig) (NC II)','Grade 11 Male Slaughtering Operations (Hog/Swine/Pig) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_SO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_SO','Grade 11 Female Slaughtering Operations (Hog/Swine/Pig) (NC II)','Grade 11 Female Slaughtering Operations (Hog/Swine/Pig) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_SO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_SO','Grade 11 Total Slaughtering Operations (Hog/Swine/Pig) (NC II)','Grade 11 Total Slaughtering Operations (Hog/Swine/Pig) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_SO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_SO','Grade 12 Male Slaughtering Operations (Hog/Swine/Pig) (NC II)','Grade 12 Male Slaughtering Operations (Hog/Swine/Pig) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_SO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_SO','Grade 12 Female Slaughtering Operations (Hog/Swine/Pig) (NC II)','Grade 12 Female Slaughtering Operations (Hog/Swine/Pig) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_SO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_SO','Grade 12 Total Slaughtering Operations (Hog/Swine/Pig) (NC II)','Grade 12 Total Slaughtering Operations (Hog/Swine/Pig) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_SO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_SO','Total Male for Slaughtering Operations (Hog/Swine/Pig) (NC II)','Total Male for Slaughtering Operations (Hog/Swine/Pig) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_SO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_SO','Total Female for Slaughtering Operations (Hog/Swine/Pig) (NC II)','Total Female for Slaughtering Operations (Hog/Swine/Pig) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_SO','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_SO','Total Slaughtering Operations (Hog/Swine/Pig) (NC II)','Total Slaughtering Operations (Hog/Swine/Pig) (NC II)',@dataset_head_id,1); 
 




 





