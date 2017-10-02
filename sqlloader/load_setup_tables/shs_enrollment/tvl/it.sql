
SET @dataset_parent_id=9049;
SET @dataset_table_id=54;
-- TABLE METADATA


SET @table_id=@dataset_table_id;
SET @parent_id=@dataset_parent_id;
SET @table_column_id=11146;
SET @table_column_syfrom=11147;

INSERT INTO orsdb.dataset_head
(name,description,owner_id,date_created,created_by,date_updated,updated_by,visible,parent_dataset_head,table_id,ranking)
VALUES
(
'Information and Communication Tech (ICT)',
'Information and Communication Tech (ICT)',
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
VALUES(@table_id,'g11male_ANIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_ANIM','Grade 11 Male Animation (NC II)','Grade 11 Male Animation (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_ANIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_ANIM','Grade 11 Female Animation (NC II)','Grade 11 Female Animation (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_ANIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_ANIM','Grade 11 Total Animation (NC II)','Grade 11 Total Animation (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_ANIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_ANIM','Grade 12 Male Animation (NC II)','Grade 12 Male Animation (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_ANIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_ANIM','Grade 12 Female Animation (NC II)','Grade 12 Female Animation (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_ANIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_ANIM','Grade 12 Total Animation (NC II)','Grade 12 Total Animation (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_ANIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_ANIM','Total Male for Animation (NC II)','Total Male for Animation (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_ANIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_ANIM','Total Female for Animation (NC II)','Total Female for Animation (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_ANIM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_ANIM','Total Animation (NC II)','Total Animation (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_FWS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_FWS','Grade 11 Male Broadband Installation (Fixed Wireless Systems) (NC II) ','Grade 11 Male Broadband Installation (Fixed Wireless Systems) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_FWS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_FWS','Grade 11 Female Broadband Installation (Fixed Wireless Systems) (NC II) ','Grade 11 Female Broadband Installation (Fixed Wireless Systems) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_FWS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_FWS','Grade 11 Total Broadband Installation (Fixed Wireless Systems) (NC II) ','Grade 11 Total Broadband Installation (Fixed Wireless Systems) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_FWS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_FWS','Grade 12 Male Broadband Installation (Fixed Wireless Systems) (NC II) ','Grade 12 Male Broadband Installation (Fixed Wireless Systems) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_FWS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_FWS','Grade 12 Female Broadband Installation (Fixed Wireless Systems) (NC II) ','Grade 12 Female Broadband Installation (Fixed Wireless Systems) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_FWS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_FWS','Grade 12 Total Broadband Installation (Fixed Wireless Systems) (NC II) ','Grade 12 Total Broadband Installation (Fixed Wireless Systems) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_FWS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_FWS','Total Male for Broadband Installation (Fixed Wireless Systems) (NC II) ','Total Male for Broadband Installation (Fixed Wireless Systems) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_FWS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_FWS','Total Female for Broadband Installation (Fixed Wireless Systems) (NC II) ','Total Female for Broadband Installation (Fixed Wireless Systems) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_FWS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_FWS','Total Broadband Installation (Fixed Wireless Systems) (NC II) ','Total Broadband Installation (Fixed Wireless Systems) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_CPNT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_CPNT','Grade 11 Male Computer Programming (.Net Technology) (NC III)','Grade 11 Male Computer Programming (.Net Technology) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_CPNT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_CPNT','Grade 11 Female Computer Programming (.Net Technology) (NC III)','Grade 11 Female Computer Programming (.Net Technology) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_CPNT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_CPNT','Grade 11 Total Computer Programming (.Net Technology) (NC III)','Grade 11 Total Computer Programming (.Net Technology) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_CPNT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_CPNT','Grade 12 Male Computer Programming (.Net Technology) (NC III)','Grade 12 Male Computer Programming (.Net Technology) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_CPNT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_CPNT','Grade 12 Female Computer Programming (.Net Technology) (NC III)','Grade 12 Female Computer Programming (.Net Technology) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_CPNT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_CPNT','Grade 12 Total Computer Programming (.Net Technology) (NC III)','Grade 12 Total Computer Programming (.Net Technology) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_CPNT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_CPNT','Total Male for Computer Programming (.Net Technology) (NC III)','Total Male for Computer Programming (.Net Technology) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_CPNT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_CPNT','Total Female for Computer Programming (.Net Technology) (NC III)','Total Female for Computer Programming (.Net Technology) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_CPNT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_CPNT','Total Computer Programming (.Net Technology) (NC III)','Total Computer Programming (.Net Technology) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_CPJV','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_CPJV','Grade 11 Male Computer Programming (Java) (NC III)','Grade 11 Male Computer Programming (Java) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_CPJV','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_CPJV','Grade 11 Female Computer Programming (Java) (NC III)','Grade 11 Female Computer Programming (Java) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_CPJV','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_CPJV','Grade 11 Total Computer Programming (Java) (NC III)','Grade 11 Total Computer Programming (Java) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_CPJV','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_CPJV','Grade 12 Male Computer Programming (Java) (NC III)','Grade 12 Male Computer Programming (Java) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_CPJV','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_CPJV','Grade 12 Female Computer Programming (Java) (NC III)','Grade 12 Female Computer Programming (Java) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_CPJV','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_CPJV','Grade 12 Total Computer Programming (Java) (NC III)','Grade 12 Total Computer Programming (Java) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_CPJV','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_CPJV','Total Male for Computer Programming (Java) (NC III)','Total Male for Computer Programming (Java) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_CPJV','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_CPJV','Total Female for Computer Programming (Java) (NC III)','Total Female for Computer Programming (Java) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_CPJV','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_CPJV','Total Computer Programming (Java) (NC III)','Total Computer Programming (Java) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_CPOR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_CPOR','Grade 11 Male Computer Programming (Oracle Database) (NC III) ','Grade 11 Male Computer Programming (Oracle Database) (NC III) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_CPOR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_CPOR','Grade 11 Female Computer Programming (Oracle Database) (NC III) ','Grade 11 Female Computer Programming (Oracle Database) (NC III) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_CPOR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_CPOR','Grade 11 Total Computer Programming (Oracle Database) (NC III) ','Grade 11 Total Computer Programming (Oracle Database) (NC III) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_CPOR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_CPOR','Grade 12 Male Computer Programming (Oracle Database) (NC III) ','Grade 12 Male Computer Programming (Oracle Database) (NC III) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_CPOR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_CPOR','Grade 12 Female Computer Programming (Oracle Database) (NC III) ','Grade 12 Female Computer Programming (Oracle Database) (NC III) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_CPOR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_CPOR','Grade 12 Total Computer Programming (Oracle Database) (NC III) ','Grade 12 Total Computer Programming (Oracle Database) (NC III) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_CPOR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_CPOR','Total Male for Computer Programming (Oracle Database) (NC III) ','Total Male for Computer Programming (Oracle Database) (NC III) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_CPOR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_CPOR','Total Female for Computer Programming (Oracle Database) (NC III) ','Total Female for Computer Programming (Oracle Database) (NC III) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_CPOR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_CPOR','Total Computer Programming (Oracle Database) (NC III) ','Total Computer Programming (Oracle Database) (NC III) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_CSS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_CSS','Grade 11 Male Computer Systems Servicing (NC II) ','Grade 11 Male Computer Systems Servicing (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_CSS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_CSS','Grade 11 Female Computer Systems Servicing (NC II) ','Grade 11 Female Computer Systems Servicing (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_CSS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_CSS','Grade 11 Total Computer Systems Servicing (NC II) ','Grade 11 Total Computer Systems Servicing (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_CSS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_CSS','Grade 12 Male Computer Systems Servicing (NC II) ','Grade 12 Male Computer Systems Servicing (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_CSS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_CSS','Grade 12 Female Computer Systems Servicing (NC II) ','Grade 12 Female Computer Systems Servicing (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_CSS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_CSS','Grade 12 Total Computer Systems Servicing (NC II) ','Grade 12 Total Computer Systems Servicing (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_CSS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_CSS','Total Male for Computer Systems Servicing (NC II) ','Total Male for Computer Systems Servicing (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_CSS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_CSS','Total Female for Computer Systems Servicing (NC II) ','Total Female for Computer Systems Servicing (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_CSS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_CSS','Total Computer Systems Servicing (NC II) ','Total Computer Systems Servicing (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_CCS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_CCS','Grade 11 Male Contact Center Services (NC II)','Grade 11 Male Contact Center Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_CCS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_CCS','Grade 11 Female Contact Center Services (NC II)','Grade 11 Female Contact Center Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_CCS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_CCS','Grade 11 Total Contact Center Services (NC II)','Grade 11 Total Contact Center Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_CCS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_CCS','Grade 12 Male Contact Center Services (NC II)','Grade 12 Male Contact Center Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_CCS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_CCS','Grade 12 Female Contact Center Services (NC II)','Grade 12 Female Contact Center Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_CCS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_CCS','Grade 12 Total Contact Center Services (NC II)','Grade 12 Total Contact Center Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_CCS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_CCS','Total Male for Contact Center Services (NC II)','Total Male for Contact Center Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_CCS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_CCS','Total Female for Contact Center Services (NC II)','Total Female for Contact Center Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_CCS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_CCS','Total Contact Center Services (NC II)','Total Contact Center Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_ILLUS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_ILLUS','Grade 11 Male Illustration (NC II)','Grade 11 Male Illustration (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_ILLUS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_ILLUS','Grade 11 Female Illustration (NC II)','Grade 11 Female Illustration (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_ILLUS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_ILLUS','Grade 11 Total Illustration (NC II)','Grade 11 Total Illustration (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_ILLUS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_ILLUS','Grade 12 Male Illustration (NC II)','Grade 12 Male Illustration (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_ILLUS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_ILLUS','Grade 12 Female Illustration (NC II)','Grade 12 Female Illustration (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_ILLUS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_ILLUS','Grade 12 Total Illustration (NC II)','Grade 12 Total Illustration (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_ILLUS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_ILLUS','Total Male for Illustration (NC II)','Total Male for Illustration (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_ILLUS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_ILLUS','Total Female for Illustration (NC II)','Total Female for Illustration (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_ILLUS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_ILLUS','Total Illustration (NC II)','Total Illustration (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_MT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_MT','Grade 11 Male Medical Transcription (NC II)','Grade 11 Male Medical Transcription (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_MT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_MT','Grade 11 Female Medical Transcription (NC II)','Grade 11 Female Medical Transcription (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_MT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_MT','Grade 11 Total Medical Transcription (NC II)','Grade 11 Total Medical Transcription (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_MT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_MT','Grade 12 Male Medical Transcription (NC II)','Grade 12 Male Medical Transcription (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_MT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_MT','Grade 12 Female Medical Transcription (NC II)','Grade 12 Female Medical Transcription (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_MT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_MT','Grade 12 Total Medical Transcription (NC II)','Grade 12 Total Medical Transcription (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_MT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_MT','Total Male for Medical Transcription (NC II)','Total Male for Medical Transcription (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_MT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_MT','Total Female for Medical Transcription (NC II)','Total Female for Medical Transcription (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_MT','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_MT','Total Medical Transcription (NC II)','Total Medical Transcription (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_TD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_TD','Grade 11 Male Technical Drafting (NC II)','Grade 11 Male Technical Drafting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_TD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_TD','Grade 11 Female Technical Drafting (NC II)','Grade 11 Female Technical Drafting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_TD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_TD','Grade 11 Total Technical Drafting (NC II)','Grade 11 Total Technical Drafting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_TD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_TD','Grade 12 Male Technical Drafting (NC II)','Grade 12 Male Technical Drafting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_TD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_TD','Grade 12 Female Technical Drafting (NC II)','Grade 12 Female Technical Drafting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_TD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_TD','Grade 12 Total Technical Drafting (NC II)','Grade 12 Total Technical Drafting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_TD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_TD','Total Male for Technical Drafting (NC II)','Total Male for Technical Drafting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_TD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_TD','Total Female for Technical Drafting (NC II)','Total Female for Technical Drafting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_TD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_TD','Total Technical Drafting (NC II)','Total Technical Drafting (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_CCPD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_CCPD','Grade 11 Male Telecom OSP and Subscriber Line Installation (Copper Cable/POTS and DSL) (NC II) ','Grade 11 Male Telecom OSP and Subscriber Line Installation (Copper Cable/POTS and DSL) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_CCPD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_CCPD','Grade 11 Female Telecom OSP and Subscriber Line Installation (Copper Cable/POTS and DSL) (NC II) ','Grade 11 Female Telecom OSP and Subscriber Line Installation (Copper Cable/POTS and DSL) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_CCPD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_CCPD','Grade 11 Total Telecom OSP and Subscriber Line Installation (Copper Cable/POTS and DSL) (NC II) ','Grade 11 Total Telecom OSP and Subscriber Line Installation (Copper Cable/POTS and DSL) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_CCPD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_CCPD','Grade 12 Male Telecom OSP and Subscriber Line Installation (Copper Cable/POTS and DSL) (NC II) ','Grade 12 Male Telecom OSP and Subscriber Line Installation (Copper Cable/POTS and DSL) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_CCPD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_CCPD','Grade 12 Female Telecom OSP and Subscriber Line Installation (Copper Cable/POTS and DSL) (NC II) ','Grade 12 Female Telecom OSP and Subscriber Line Installation (Copper Cable/POTS and DSL) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_CCPD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_CCPD','Grade 12 Total Telecom OSP and Subscriber Line Installation (Copper Cable/POTS and DSL) (NC II) ','Grade 12 Total Telecom OSP and Subscriber Line Installation (Copper Cable/POTS and DSL) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_CCPD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_CCPD','Total Male for Telecom OSP and Subscriber Line Installation (Copper Cable/POTS and DSL) (NC II) ','Total Male for Telecom OSP and Subscriber Line Installation (Copper Cable/POTS and DSL) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_CCPD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_CCPD','Total Female for Telecom OSP and Subscriber Line Installation (Copper Cable/POTS and DSL) (NC II) ','Total Female for Telecom OSP and Subscriber Line Installation (Copper Cable/POTS and DSL) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_CCPD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_CCPD','Total Telecom OSP and Subscriber Line Installation (Copper Cable/POTS and DSL) (NC II) ','Total Telecom OSP and Subscriber Line Installation (Copper Cable/POTS and DSL) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_FOC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_FOC','Grade 11 Male Telecom OSP Installation (Fiber Optic Cable) (NC II) ','Grade 11 Male Telecom OSP Installation (Fiber Optic Cable) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_FOC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_FOC','Grade 11 Female Telecom OSP Installation (Fiber Optic Cable) (NC II) ','Grade 11 Female Telecom OSP Installation (Fiber Optic Cable) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_FOC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_FOC','Grade 11 Total Telecom OSP Installation (Fiber Optic Cable) (NC II)','Grade 11 Total Telecom OSP Installation (Fiber Optic Cable) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_FOC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_FOC','Grade 11 Male Telecom OSP Installation (Fiber Optic Cable) (NC II) ','Grade 11 Male Telecom OSP Installation (Fiber Optic Cable) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_FOC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_FOC','Grade 11 Female Telecom OSP Installation (Fiber Optic Cable) (NC II) ','Grade 11 Female Telecom OSP Installation (Fiber Optic Cable) (NC II) ',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_FOC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_FOC','Grade 11 Total Telecom OSP Installation (Fiber Optic Cable) (NC II)','Grade 11 Total Telecom OSP Installation (Fiber Optic Cable) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_FOC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_FOC','Total Male for Telecom OSP Installation (Fiber Optic Cable) (NC II)','Total Male for Telecom OSP Installation (Fiber Optic Cable) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_FOC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_FOC','Total Female for Telecom OSP Installation (Fiber Optic Cable) (NC II)','Total Female for Telecom OSP Installation (Fiber Optic Cable) (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_FOC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_FOC','Total Telecom OSP Installation (Fiber Optic Cable) (NC II)','Total Telecom OSP Installation (Fiber Optic Cable) (NC II)',@dataset_head_id,1); 
 




