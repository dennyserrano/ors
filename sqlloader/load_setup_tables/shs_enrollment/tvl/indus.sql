
SET @dataset_parent_id=9025;
SET @dataset_table_id=1;
-- TABLE METADATA


SET @table_id=@dataset_table_id;
SET @parent_id=@dataset_parent_id;
SET @table_column_id=11146;
SET @table_column_syfrom=11147;

INSERT INTO orsdb.dataset_head
(name,description,owner_id,date_created,created_by,date_updated,updated_by,visible,parent_dataset_head,table_id,ranking)
VALUES
(
'Industrial Arts',
'Industrial Arts',
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
VALUES(@table_id,'g11male_ASI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_ASI','Grade 11 Male Automotive Servicing (NC I) D195','Grade 11 Male Automotive Servicing (NC I) D195',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_ASI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_ASI','Grade 11 Female Automotive Servicing (NC I) D195','Grade 11 Female Automotive Servicing (NC I) D195',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_ASI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_ASI','Grade 11 Total Automotive Servicing (NC I) D195','Grade 11 Total Automotive Servicing (NC I) D195',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_ASII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_ASII','Grade 11 Male Automotive Servicing (NC II)','Grade 11 Male Automotive Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_ASII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_ASII','Grade 11 Female Automotive Servicing (NC II)','Grade 11 Female Automotive Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_ASII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_ASII','Grade 11 Total Automotive Servicing (NC II)','Grade 11 Total Automotive Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_ASI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_ASI','Total Male for Automotive Servicing (NC I) D195','Total Male for Automotive Servicing (NC I) D195',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_ASI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_ASI','Total Female for Automotive Servicing (NC I) D195','Total Female for Automotive Servicing (NC I) D195',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_ASI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_ASI','Total Automotive Servicing (NC I) D195','Total Automotive Servicing (NC I) D195',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_CARTII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_CARTII','Grade 11 Male Carpentry (NC II)','Grade 11 Male Carpentry (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_CARTII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_CARTII','Grade 11 Female Carpentry (NC II)','Grade 11 Female Carpentry (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_CARTII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_CARTII','Grade 11 Total Carpentry (NC II)','Grade 11 Total Carpentry (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_CARTIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_CARTIII','Grade 11 Male Carpentry (NC III)','Grade 11 Male Carpentry (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_CARTIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_CARTIII','Grade 11 Female Carpentry (NC III)','Grade 11 Female Carpentry (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_CARTIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_CARTIII','Grade 11 Total Carpentry (NC III)','Grade 11 Total Carpentry (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_ASII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_ASII','Total Male for Automotive Servicing (NC II)','Total Male for Automotive Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_ASII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_ASII','Total Female for Automotive Servicing (NC II)','Total Female for Automotive Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_ASII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_ASII','Total Automotive Servicing (NC II)','Total Automotive Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_CP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_CP','Grade 11 Male Construction Painting (NC II)','Grade 11 Male Construction Painting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_CP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_CP','Grade 11 Female Construction Painting (NC II)','Grade 11 Female Construction Painting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_CP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_CP','Grade 11 Total Construction Painting (NC II)','Grade 11 Total Construction Painting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_DOMRAC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_DOMRAC','Grade 11 Male Domestic Refrigeration and Air-Conditioning (DOMRAC) Servicing (NC II)','Grade 11 Male Domestic Refrigeration and Air-Conditioning (DOMRAC) Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_DOMRAC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_DOMRAC','Grade 11 Female Domestic Refrigeration and Air-Conditioning (DOMRAC) Servicing (NC II)','Grade 11 Female Domestic Refrigeration and Air-Conditioning (DOMRAC) Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_DOMRAC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_DOMRAC','Grade 11 Total Domestic Refrigeration and Air-Conditioning (DOMRAC) Servicing (NC II)','Grade 11 Total Domestic Refrigeration and Air-Conditioning (DOMRAC) Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_CARTII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_CARTII','Total Male for Carpentry (NC II)','Total Male for Carpentry (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_CARTII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_CARTII','Total Female for Carpentry (NC II)','Total Female for Carpentry (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_CARTII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_CARTII','Total Carpentry (NC II)','Total Carpentry (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_EIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_EIM','Grade 11 Male Electrical Installation and Maintenance (NC II)','Grade 11 Male Electrical Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_EIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_EIM','Grade 11 Female Electrical Installation and Maintenance (NC II)','Grade 11 Female Electrical Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_EIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_EIM','Grade 11 Total Electrical Installation and Maintenance (NC II)','Grade 11 Total Electrical Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_EPDLC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_EPDLC','Grade 11 Male Electric Power Distribution Line Construction (NC II)','Grade 11 Male Electric Power Distribution Line Construction (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_EPDLC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_EPDLC','Grade 11 Female Electric Power Distribution Line Construction (NC II)','Grade 11 Female Electric Power Distribution Line Construction (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_EPDLC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_EPDLC','Grade 11 Total Electric Power Distribution Line Construction (NC II)','Grade 11 Total Electric Power Distribution Line Construction (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_CARTIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_CARTIII','Total Male for Carpentry (NC III)','Total Male for Carpentry (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_CARTIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_CARTIII','Total Female for Carpentry (NC III)','Total Female for Carpentry (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_CARTIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_CARTIII','Total Carpentry (NC III)','Total Carpentry (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_EPAS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_EPAS','Grade 11 Male Electronic Products Assembly and Servicing (EPAS) (NC II)','Grade 11 Male Electronic Products Assembly and Servicing (EPAS) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_EPAS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_EPAS','Grade 11 Female Electronic Products Assembly and Servicing (EPAS) (NC II)','Grade 11 Female Electronic Products Assembly and Servicing (EPAS) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_EPAS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_EPAS','Grade 11 Total Electronic Products Assembly and Servicing (EPAS) (NC II)','Grade 11 Total Electronic Products Assembly and Servicing (EPAS) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_FM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_FM','Grade 11 Male Furniture Making (Finishing) (NC II)','Grade 11 Male Furniture Making (Finishing) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_FM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_FM','Grade 11 Female Furniture Making (Finishing) (NC II)','Grade 11 Female Furniture Making (Finishing) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_FM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_FM','Grade 11 Total Furniture Making (Finishing) (NC II)','Grade 11 Total Furniture Making (Finishing) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_CP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_CP','Total Male for Construction Painting (NC II)','Total Male for Construction Painting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_CP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_CP','Total Female for Construction Painting (NC II)','Total Female for Construction Painting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_CP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_CP','Total Construction Painting (NC II)','Total Construction Painting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_ICS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_ICS','Grade 11 Male Instrumentation and Control Servicing (NC II)','Grade 11 Male Instrumentation and Control Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_ICS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_ICS','Grade 11 Female Instrumentation and Control Servicing (NC II)','Grade 11 Female Instrumentation and Control Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_ICS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_ICS','Grade 11 Total Instrumentation and Control Servicing (NC II)','Grade 11 Total Instrumentation and Control Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_GMAW','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_GMAW','Grade 11 Male Gas Metal Arc Welding (GMAW) (NC II)','Grade 11 Male Gas Metal Arc Welding (GMAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_GMAW','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_GMAW','Grade 11 Female Gas Metal Arc Welding (GMAW) (NC II)','Grade 11 Female Gas Metal Arc Welding (GMAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_GMAW','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_GMAW','Grade 11 Total Gas Metal Arc Welding (GMAW) (NC II)','Grade 11 Total Gas Metal Arc Welding (GMAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_DOMRAC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_DOMRAC','Total Male for Domestic Refrigeration and Air-Conditioning (DOMRAC) Servicing (NC II)','Total Male for Domestic Refrigeration and Air-Conditioning (DOMRAC) Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_DOMRAC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_DOMRAC','Total Female for Domestic Refrigeration and Air-Conditioning (DOMRAC) Servicing (NC II)','Total Female for Domestic Refrigeration and Air-Conditioning (DOMRAC) Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_DOMRAC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_DOMRAC','Total Domestic Refrigeration and Air-Conditioning (DOMRAC) Servicing (NC II)','Total Domestic Refrigeration and Air-Conditioning (DOMRAC) Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_GTAW','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_GTAW','Grade 11 Male Gas Tungsten Arc Welding (GTAW) (NC II)','Grade 11 Male Gas Tungsten Arc Welding (GTAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_GTAW','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_GTAW','Grade 11 Female Gas Tungsten Arc Welding (GTAW) (NC II)','Grade 11 Female Gas Tungsten Arc Welding (GTAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_GTAW','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_GTAW','Grade 11 Total Gas Tungsten Arc Welding (GTAW) (NC II)','Grade 11 Total Gas Tungsten Arc Welding (GTAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_MACHI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_MACHI','Grade 11 Male Machining (NC I)','Grade 11 Male Machining (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_MACHI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_MACHI','Grade 11 Female Machining (NC I)','Grade 11 Female Machining (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_MACHI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_MACHI','Grade 11 Total Machining (NC I)','Grade 11 Total Machining (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_EIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_EIM','Total Male for Electrical Installation and Maintenance (NC II)','Total Male for Electrical Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_EIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_EIM','Total Female for Electrical Installation and Maintenance (NC II)','Total Female for Electrical Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_EIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_EIM','Total Electrical Installation and Maintenance (NC II)','Total Electrical Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_MACHII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_MACHII','Grade 11 Male Machining (NC II)','Grade 11 Male Machining (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_MACHII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_MACHII','Grade 11 Female Machining (NC II)','Grade 11 Female Machining (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_MACHII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_MACHII','Grade 11 Total Machining (NC II)','Grade 11 Total Machining (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_MSN','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_MSN','Grade 11 Male Masonry (NC II)','Grade 11 Male Masonry (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_MSN','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_MSN','Grade 11 Female Masonry (NC II)','Grade 11 Female Masonry (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_MSN','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_MSN','Grade 11 Total Masonry (NC II)','Grade 11 Total Masonry (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_EPDLC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_EPDLC','Total Male for Electric Power Distribution Line Construction (NC II)','Total Male for Electric Power Distribution Line Construction (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_EPDLC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_EPDLC','Total Female for Electric Power Distribution Line Construction (NC II)','Total Female for Electric Power Distribution Line Construction (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_EPDLC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_EPDLC','Total Electric Power Distribution Line Construction (NC II)','Total Electric Power Distribution Line Construction (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_MS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_MS','Grade 11 Male Mechatronics Servicing (NC II) ','Grade 11 Male Mechatronics Servicing (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_MS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_MS','Grade 11 Female Mechatronics Servicing (NC II) ','Grade 11 Female Mechatronics Servicing (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_MS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_MS','Grade 11 Total Mechatronics Servicing (NC II) ','Grade 11 Total Mechatronics Servicing (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_SES','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_SES','Grade 11 Male Motorcycle/Small Engine Servicing (NC II)','Grade 11 Male Motorcycle/Small Engine Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_SES','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_SES','Grade 11 Female Motorcycle/Small Engine Servicing (NC II)','Grade 11 Female Motorcycle/Small Engine Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_SES','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_SES','Grade 11 Total Motorcycle/Small Engine Servicing (NC II)','Grade 11 Total Motorcycle/Small Engine Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_EPAS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_EPAS','Total Male for Electronic Products Assembly and Servicing (EPAS) (NC II)','Total Male for Electronic Products Assembly and Servicing (EPAS) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_EPAS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_EPAS','Total Female for Electronic Products Assembly and Servicing (EPAS) (NC II)','Total Female for Electronic Products Assembly and Servicing (EPAS) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_EPAS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_EPAS','Total Electronic Products Assembly and Servicing (EPAS) (NC II)','Total Electronic Products Assembly and Servicing (EPAS) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_PLUMI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_PLUMI','Grade 11 Male Plumbing (NC I)','Grade 11 Male Plumbing (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_PLUMI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_PLUMI','Grade 11 Female Plumbing (NC I)','Grade 11 Female Plumbing (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_PLUMI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_PLUMI','Grade 11 Total Plumbing (NC I)','Grade 11 Total Plumbing (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_PLUMII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_PLUMII','Grade 11 Male Plumbing (NC II)','Grade 11 Male Plumbing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_PLUMII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_PLUMII','Grade 11 Female Plumbing (NC II)','Grade 11 Female Plumbing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_PLUMII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_PLUMII','Grade 11 Total Plumbing (NC II)','Grade 11 Total Plumbing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_FM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_FM','Total Male for Furniture Making (Finishing) (NC II)','Total Male for Furniture Making (Finishing) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_FM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_FM','Total Female for Furniture Making (Finishing) (NC II)','Total Female for Furniture Making (Finishing) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_FM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_FM','Total Furniture Making (Finishing) (NC II)','Total Furniture Making (Finishing) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_PACU','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_PACU','Grade 11 Male Refrigeration and Air-Conditioning  (Packaged Air-Conditioning Unit (PACU)/Commercial Refrigeration Equipment (CRE) Servicing (NC III)','Grade 11 Male Refrigeration and Air-Conditioning  (Packaged Air-Conditioning Unit (PACU)/Commercial Refrigeration Equipment (CRE) Servicing (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_PACU','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_PACU','Grade 11 Female Refrigeration and Air-Conditioning  (Packaged Air-Conditioning Unit (PACU)/Commercial Refrigeration Equipment (CRE) Servicing (NC III)','Grade 11 Female Refrigeration and Air-Conditioning  (Packaged Air-Conditioning Unit (PACU)/Commercial Refrigeration Equipment (CRE) Servicing (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_PACU','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_PACU','Grade 11 Total Refrigeration and Air-Conditioning  (Packaged Air-Conditioning Unit (PACU)/Commercial Refrigeration Equipment (CRE) Servicing (NC III)','Grade 11 Total Refrigeration and Air-Conditioning  (Packaged Air-Conditioning Unit (PACU)/Commercial Refrigeration Equipment (CRE) Servicing (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_SMAWI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_SMAWI','Grade 11 Male Shielded Metal Arc Welding (SMAW) (NC I)','Grade 11 Male Shielded Metal Arc Welding (SMAW) (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_SMAWI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_SMAWI','Grade 11 Female Shielded Metal Arc Welding (SMAW) (NC I)','Grade 11 Female Shielded Metal Arc Welding (SMAW) (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_SMAWI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_SMAWI','Grade 11 Total Shielded Metal Arc Welding (SMAW) (NC I)','Grade 11 Total Shielded Metal Arc Welding (SMAW) (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_ICS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_ICS','Total Male for Instrumentation and Control Servicing (NC II)','Total Male for Instrumentation and Control Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_ICS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_ICS','Total Female for Instrumentation and Control Servicing (NC II)','Total Female for Instrumentation and Control Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_ICS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_ICS','Total Instrumentation and Control Servicing (NC II)','Total Instrumentation and Control Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_SMAWII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_SMAWII','Grade 11 Male Shielded Metal Arc Welding (SMAW) (NC II)','Grade 11 Male Shielded Metal Arc Welding (SMAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_SMAWII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_SMAWII','Grade 11 Female Shielded Metal Arc Welding (SMAW) (NC II)','Grade 11 Female Shielded Metal Arc Welding (SMAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_SMAWII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_SMAWII','Grade 11 Total Shielded Metal Arc Welding (SMAW) (NC II)','Grade 11 Total Shielded Metal Arc Welding (SMAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_TILE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_TILE','Grade 11 Male Tile Setting (NC II)','Grade 11 Male Tile Setting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_TILE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_TILE','Grade 11 Female Tile Setting (NC II)','Grade 11 Female Tile Setting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_TILE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_TILE','Grade 11 Total Tile Setting (NC II)','Grade 11 Total Tile Setting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_GMAW','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_GMAW','Total Male for Gas Metal Arc Welding (GMAW) (NC II)','Total Male for Gas Metal Arc Welding (GMAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_GMAW','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_GMAW','Total Female for Gas Metal Arc Welding (GMAW) (NC II)','Total Female for Gas Metal Arc Welding (GMAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_GMAW','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_GMAW','Total Gas Metal Arc Welding (GMAW) (NC II)','Total Gas Metal Arc Welding (GMAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_TLIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_TLIM','Grade 11 Male Transmission Line Installation and Maintenance (NC II)','Grade 11 Male Transmission Line Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_TLIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_TLIM','Grade 11 Female Transmission Line Installation and Maintenance (NC II)','Grade 11 Female Transmission Line Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_TLIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_TLIM','Grade 11 Total Transmission Line Installation and Maintenance (NC II)','Grade 11 Total Transmission Line Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_ASI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_ASI','Grade 12 Male Automotive Servicing (NC I) D195','Grade 12 Male Automotive Servicing (NC I) D195',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_ASI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_ASI','Grade 12 Female Automotive Servicing (NC I) D195','Grade 12 Female Automotive Servicing (NC I) D195',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_ASI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_ASI','Grade 12 Total Automotive Servicing (NC I) D195','Grade 12 Total Automotive Servicing (NC I) D195',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_GTAW','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_GTAW','Total Male for Gas Tungsten Arc Welding (GTAW) (NC II)','Total Male for Gas Tungsten Arc Welding (GTAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_GTAW','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_GTAW','Total Female for Gas Tungsten Arc Welding (GTAW) (NC II)','Total Female for Gas Tungsten Arc Welding (GTAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_GTAW','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_GTAW','Total Gas Tungsten Arc Welding (GTAW) (NC II)','Total Gas Tungsten Arc Welding (GTAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_ASII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_ASII','Grade 12 Male Automotive Servicing (NC II)','Grade 12 Male Automotive Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_ASII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_ASII','Grade 12 Female Automotive Servicing (NC II)','Grade 12 Female Automotive Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_ASII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_ASII','Grade 12 Total Automotive Servicing (NC II)','Grade 12 Total Automotive Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_CARTII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_CARTII','Grade 12 Male Carpentry (NC II)','Grade 12 Male Carpentry (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_CARTII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_CARTII','Grade 12 Female Carpentry (NC II)','Grade 12 Female Carpentry (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_CARTII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_CARTII','Grade 12 Total Carpentry (NC II)','Grade 12 Total Carpentry (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_MACHI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_MACHI','Total Male for Machining (NC I)','Total Male for Machining (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_MACHI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_MACHI','Total Female for Machining (NC I)','Total Female for Machining (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_MACHI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_MACHI','Total Machining (NC I)','Total Machining (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_CARTIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_CARTIII','Grade 12 Male Carpentry (NC III)','Grade 12 Male Carpentry (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_CARTIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_CARTIII','Grade 12 Female Carpentry (NC III)','Grade 12 Female Carpentry (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_CARTIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_CARTIII','Grade 12 Total Carpentry (NC III)','Grade 12 Total Carpentry (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_CP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_CP','Grade 12 Male Construction Painting (NC II)','Grade 12 Male Construction Painting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_CP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_CP','Grade 12 Female Construction Painting (NC II)','Grade 12 Female Construction Painting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_CP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_CP','Grade 12 Total Construction Painting (NC II)','Grade 12 Total Construction Painting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_MACHII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_MACHII','Total Male for Machining (NC II)','Total Male for Machining (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_MACHII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_MACHII','Total Female for Machining (NC II)','Total Female for Machining (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_MACHII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_MACHII','Total Machining (NC II)','Total Machining (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_DOMRAC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_DOMRAC','Grade 12 Male Domestic Refrigeration and Air-Conditioning (DOMRAC) Servicing (NC II)','Grade 12 Male Domestic Refrigeration and Air-Conditioning (DOMRAC) Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_DOMRAC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_DOMRAC','Grade 12 Female Domestic Refrigeration and Air-Conditioning (DOMRAC) Servicing (NC II)','Grade 12 Female Domestic Refrigeration and Air-Conditioning (DOMRAC) Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_DOMRAC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_DOMRAC','Grade 12 Total Domestic Refrigeration and Air-Conditioning (DOMRAC) Servicing (NC II)','Grade 12 Total Domestic Refrigeration and Air-Conditioning (DOMRAC) Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_EIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_EIM','Grade 12 Male Electrical Installation and Maintenance (NC II)','Grade 12 Male Electrical Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_EIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_EIM','Grade 12 Female Electrical Installation and Maintenance (NC II)','Grade 12 Female Electrical Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_EIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_EIM','Grade 12 Total Electrical Installation and Maintenance (NC II)','Grade 12 Total Electrical Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_MSN','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_MSN','Total Male for Masonry (NC II)','Total Male for Masonry (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_MSN','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_MSN','Total Female for Masonry (NC II)','Total Female for Masonry (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_MSN','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_MSN','Total Masonry (NC II)','Total Masonry (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_EPDLC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_EPDLC','Grade 12 Male Electric Power Distribution Line Construction (NC II)','Grade 12 Male Electric Power Distribution Line Construction (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_EPDLC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_EPDLC','Grade 12 Female Electric Power Distribution Line Construction (NC II)','Grade 12 Female Electric Power Distribution Line Construction (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_EPDLC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_EPDLC','Grade 12 Total Electric Power Distribution Line Construction (NC II)','Grade 12 Total Electric Power Distribution Line Construction (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_EPAS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_EPAS','Grade 12 Male Electronic Products Assembly and Servicing (EPAS) (NC II)','Grade 12 Male Electronic Products Assembly and Servicing (EPAS) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_EPAS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_EPAS','Grade 12 Female Electronic Products Assembly and Servicing (EPAS) (NC II)','Grade 12 Female Electronic Products Assembly and Servicing (EPAS) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_EPAS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_EPAS','Grade 12 Total Electronic Products Assembly and Servicing (EPAS) (NC II)','Grade 12 Total Electronic Products Assembly and Servicing (EPAS) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_MS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_MS','Total Male for Mechatronics Servicing (NC II) ','Total Male for Mechatronics Servicing (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_MS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_MS','Total Female for Mechatronics Servicing (NC II) ','Total Female for Mechatronics Servicing (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_MS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_MS','Total Mechatronics Servicing (NC II) ','Total Mechatronics Servicing (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_FM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_FM','Grade 12 Male Furniture Making (Finishing) (NC II)','Grade 12 Male Furniture Making (Finishing) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_FM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_FM','Grade 12 Female Furniture Making (Finishing) (NC II)','Grade 12 Female Furniture Making (Finishing) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_FM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_FM','Grade 12 Total Furniture Making (Finishing) (NC II)','Grade 12 Total Furniture Making (Finishing) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_ICS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_ICS','Grade 12 Male Instrumentation and Control Servicing (NC II)','Grade 12 Male Instrumentation and Control Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_ICS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_ICS','Grade 12 Female Instrumentation and Control Servicing (NC II)','Grade 12 Female Instrumentation and Control Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_ICS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_ICS','Grade 12 Total Instrumentation and Control Servicing (NC II)','Grade 12 Total Instrumentation and Control Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_SES','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_SES','Total Male for Motorcycle/Small Engine Servicing (NC II)','Total Male for Motorcycle/Small Engine Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_SES','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_SES','Total Female for Motorcycle/Small Engine Servicing (NC II)','Total Female for Motorcycle/Small Engine Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_SES','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_SES','Total Motorcycle/Small Engine Servicing (NC II)','Total Motorcycle/Small Engine Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_GMAW','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_GMAW','Grade 12 Male Gas Metal Arc Welding (GMAW) (NC II)','Grade 12 Male Gas Metal Arc Welding (GMAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_GMAW','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_GMAW','Grade 12 Female Gas Metal Arc Welding (GMAW) (NC II)','Grade 12 Female Gas Metal Arc Welding (GMAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_GMAW','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_GMAW','Grade 12 Total Gas Metal Arc Welding (GMAW) (NC II)','Grade 12 Total Gas Metal Arc Welding (GMAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_GTAW','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_GTAW','Grade 12 Male Gas Tungsten Arc Welding (GTAW) (NC II)','Grade 12 Male Gas Tungsten Arc Welding (GTAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_GTAW','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_GTAW','Grade 12 Female Gas Tungsten Arc Welding (GTAW) (NC II)','Grade 12 Female Gas Tungsten Arc Welding (GTAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_GTAW','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_GTAW','Grade 12 Total Gas Tungsten Arc Welding (GTAW) (NC II)','Grade 12 Total Gas Tungsten Arc Welding (GTAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_PLUMI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_PLUMI','Total Male for Plumbing (NC I)','Total Male for Plumbing (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_PLUMI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_PLUMI','Total Female for Plumbing (NC I)','Total Female for Plumbing (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_PLUMI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_PLUMI','Total Plumbing (NC I)','Total Plumbing (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_MACHI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_MACHI','Grade 12 Male Machining (NC I)','Grade 12 Male Machining (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_MACHI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_MACHI','Grade 12 Female Machining (NC I)','Grade 12 Female Machining (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_MACHI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_MACHI','Grade 12 Total Machining (NC I)','Grade 12 Total Machining (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_MACHII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_MACHII','Grade 12 Male Machining (NC II)','Grade 12 Male Machining (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_MACHII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_MACHII','Grade 12 Female Machining (NC II)','Grade 12 Female Machining (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_MACHII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_MACHII','Grade 12 Total Machining (NC II)','Grade 12 Total Machining (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_PLUMII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_PLUMII','Total Male for Plumbing (NC II)','Total Male for Plumbing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_PLUMII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_PLUMII','Total Female for Plumbing (NC II)','Total Female for Plumbing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_PLUMII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_PLUMII','Total Plumbing (NC II)','Total Plumbing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_MSN','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_MSN','Grade 12 Male Masonry (NC II)','Grade 12 Male Masonry (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_MSN','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_MSN','Grade 12 Female Masonry (NC II)','Grade 12 Female Masonry (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_MSN','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_MSN','Grade 12 Total Masonry (NC II)','Grade 12 Total Masonry (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_MS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_MS','Grade 12 Male Mechatronics Servicing (NC II) ','Grade 12 Male Mechatronics Servicing (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_MS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_MS','Grade 12 Female Mechatronics Servicing (NC II) ','Grade 12 Female Mechatronics Servicing (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_MS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_MS','Grade 12 Total Mechatronics Servicing (NC II) ','Grade 12 Total Mechatronics Servicing (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_PACU','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_PACU','Total Male for Refrigeration and Air-Conditioning  (Packaged Air-Conditioning Unit (PACU)/Commercial Refrigeration Equipment (CRE) Servicing (NC III)','Total Male for Refrigeration and Air-Conditioning  (Packaged Air-Conditioning Unit (PACU)/Commercial Refrigeration Equipment (CRE) Servicing (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_PACU','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_PACU','Total Female for Refrigeration and Air-Conditioning  (Packaged Air-Conditioning Unit (PACU)/Commercial Refrigeration Equipment (CRE) Servicing (NC III)','Total Female for Refrigeration and Air-Conditioning  (Packaged Air-Conditioning Unit (PACU)/Commercial Refrigeration Equipment (CRE) Servicing (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_PACU','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_PACU','Total Refrigeration and Air-Conditioning  (Packaged Air-Conditioning Unit (PACU)/Commercial Refrigeration Equipment (CRE) Servicing (NC III)','Total Refrigeration and Air-Conditioning  (Packaged Air-Conditioning Unit (PACU)/Commercial Refrigeration Equipment (CRE) Servicing (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_SES','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_SES','Grade 12 Male Motorcycle/Small Engine Servicing (NC II)','Grade 12 Male Motorcycle/Small Engine Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_SES','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_SES','Grade 12 Female Motorcycle/Small Engine Servicing (NC II)','Grade 12 Female Motorcycle/Small Engine Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_SES','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_SES','Grade 12 Total Motorcycle/Small Engine Servicing (NC II)','Grade 12 Total Motorcycle/Small Engine Servicing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_PLUMI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_PLUMI','Grade 12 Male Plumbing (NC I)','Grade 12 Male Plumbing (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_PLUMI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_PLUMI','Grade 12 Female Plumbing (NC I)','Grade 12 Female Plumbing (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_PLUMI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_PLUMI','Grade 12 Total Plumbing (NC I)','Grade 12 Total Plumbing (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_SMAWI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_SMAWI','Total Male for Shielded Metal Arc Welding (SMAW) (NC I)','Total Male for Shielded Metal Arc Welding (SMAW) (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_SMAWI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_SMAWI','Total Female for Shielded Metal Arc Welding (SMAW) (NC I)','Total Female for Shielded Metal Arc Welding (SMAW) (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_SMAWI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_SMAWI','Total Shielded Metal Arc Welding (SMAW) (NC I)','Total Shielded Metal Arc Welding (SMAW) (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_PLUMII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_PLUMII','Grade 12 Male Plumbing (NC II)','Grade 12 Male Plumbing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_PLUMII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_PLUMII','Grade 12 Female Plumbing (NC II)','Grade 12 Female Plumbing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_PLUMII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_PLUMII','Grade 12 Total Plumbing (NC II)','Grade 12 Total Plumbing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_PACU','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_PACU','Grade 12 Male Refrigeration and Air-Conditioning  (Packaged Air-Conditioning Unit (PACU)/Commercial Refrigeration Equipment (CRE) Servicing (NC III)','Grade 12 Male Refrigeration and Air-Conditioning  (Packaged Air-Conditioning Unit (PACU)/Commercial Refrigeration Equipment (CRE) Servicing (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_PACU','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_PACU','Grade 12 Female Refrigeration and Air-Conditioning  (Packaged Air-Conditioning Unit (PACU)/Commercial Refrigeration Equipment (CRE) Servicing (NC III)','Grade 12 Female Refrigeration and Air-Conditioning  (Packaged Air-Conditioning Unit (PACU)/Commercial Refrigeration Equipment (CRE) Servicing (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_PACU','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_PACU','Grade 12 Total Refrigeration and Air-Conditioning  (Packaged Air-Conditioning Unit (PACU)/Commercial Refrigeration Equipment (CRE) Servicing (NC III)','Grade 12 Total Refrigeration and Air-Conditioning  (Packaged Air-Conditioning Unit (PACU)/Commercial Refrigeration Equipment (CRE) Servicing (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_SMAWII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_SMAWII','Total Male for Shielded Metal Arc Welding (SMAW) (NC II)','Total Male for Shielded Metal Arc Welding (SMAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_SMAWII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_SMAWII','Total Female for Shielded Metal Arc Welding (SMAW) (NC II)','Total Female for Shielded Metal Arc Welding (SMAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_SMAWII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_SMAWII','Total Shielded Metal Arc Welding (SMAW) (NC II)','Total Shielded Metal Arc Welding (SMAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_SMAWI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_SMAWI','Grade 12 Male Shielded Metal Arc Welding (SMAW) (NC I)','Grade 12 Male Shielded Metal Arc Welding (SMAW) (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_SMAWI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_SMAWI','Grade 12 Female Shielded Metal Arc Welding (SMAW) (NC I)','Grade 12 Female Shielded Metal Arc Welding (SMAW) (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_SMAWI','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_SMAWI','Grade 12 Total Shielded Metal Arc Welding (SMAW) (NC I)','Grade 12 Total Shielded Metal Arc Welding (SMAW) (NC I)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_SMAWII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_SMAWII','Grade 12 Male Shielded Metal Arc Welding (SMAW) (NC II)','Grade 12 Male Shielded Metal Arc Welding (SMAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_SMAWII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_SMAWII','Grade 12 Female Shielded Metal Arc Welding (SMAW) (NC II)','Grade 12 Female Shielded Metal Arc Welding (SMAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_SMAWII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_SMAWII','Grade 12 Total Shielded Metal Arc Welding (SMAW) (NC II)','Grade 12 Total Shielded Metal Arc Welding (SMAW) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_TILE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_TILE','Total Male for Tile Setting (NC II)','Total Male for Tile Setting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_TILE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_TILE','Total Female for Tile Setting (NC II)','Total Female for Tile Setting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_TILE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_TILE','Total Tile Setting (NC II)','Total Tile Setting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_TILE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_TILE','Grade 12 Male Tile Setting (NC II)','Grade 12 Male Tile Setting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_TILE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_TILE','Grade 12 Female Tile Setting (NC II)','Grade 12 Female Tile Setting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_TILE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_TILE','Grade 12 Total Tile Setting (NC II)','Grade 12 Total Tile Setting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_TLIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_TLIM','Grade 12 Male Transmission Line Installation and Maintenance (NC II)','Grade 12 Male Transmission Line Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_TLIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_TLIM','Grade 12 Female Transmission Line Installation and Maintenance (NC II)','Grade 12 Female Transmission Line Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_TLIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_TLIM','Grade 12 Total Transmission Line Installation and Maintenance (NC II)','Grade 12 Total Transmission Line Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_TILE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_TILE','Total Male for Transmission Line Installation and Maintenance (NC II)','Total Male for Transmission Line Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_TILE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_TILE','Total Female for Transmission Line Installation and Maintenance (NC II)','Total Female for Transmission Line Installation and Maintenance (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_TILE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_TILE','Total Transmission Line Installation and Maintenance (NC II)','Total Transmission Line Installation and Maintenance (NC II)',@dataset_head_id,1); 
 



