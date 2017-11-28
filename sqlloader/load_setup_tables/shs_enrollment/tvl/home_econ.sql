
SET @dataset_parent_id=9025;

-- TABLE METADATA

INSERT INTO orsdb.table_metadata
(db_id,schema_name,table_name,description,col_count,row_count,location,date_created,created_by,date_updated,updated_by)
VALUES
(2,
'sisdbtest',
'shs_tvl',
'SHS TVL',
0,
0,
NULL,
curdate(),
'SYSTEM',
curdate(),
'SYSTEM'
);

SET @table_id=LAST_INSERT_ID();

SET @parent_id=@dataset_parent_id;

INSERT INTO orsdb.dataset_head
(name,description,owner_id,date_created,created_by,date_updated,updated_by,visible,parent_dataset_head,table_id,ranking)
VALUES
(
'Home Economics',
'Home Economics',
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

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES(@table_id,'id','int',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','id','id','id',@dataset_head_id,0);


INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES(@table_id,'sy_from','int',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','sy_from','sy_from','sy_from',@dataset_head_id,0);


INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES(@table_id,'school_id','int',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','school_id','school_id','school_id',@dataset_head_id,0);


INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_ATPOE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_ATPOE','Grade 11 Male Attractions and Theme Parks Operations with Ecotourism (NC II)','Grade 11 Male Attractions and Theme Parks Operations with Ecotourism (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_ATPOE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_ATPOE','Grade 11 Female Attractions and Theme Parks Operations with Ecotourism (NC II)','Grade 11 Female Attractions and Theme Parks Operations with Ecotourism (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_ATPOE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_ATPOE','Grade 11 Total Attractions and Theme Parks Operations with Ecotourism (NC II)','Grade 11 Total Attractions and Theme Parks Operations with Ecotourism (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_ATPOE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_ATPOE','Grade 12 Male Attractions and Theme Parks Operations with Ecotourism (NC II)','Grade 12 Male Attractions and Theme Parks Operations with Ecotourism (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_ATPOE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_ATPOE','Grade 12 Female Attractions and Theme Parks Operations with Ecotourism (NC II)','Grade 12 Female Attractions and Theme Parks Operations with Ecotourism (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_ATPOE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_ATPOE','Grade 12 Total Attractions and Theme Parks Operations with Ecotourism (NC II)','Grade 12 Total Attractions and Theme Parks Operations with Ecotourism (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_ATPOE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_ATPOE','Total Male for Attractions and Theme Parks Operations with Ecotourism (NC II)','Total Male for Attractions and Theme Parks Operations with Ecotourism (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_ATPOE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_ATPOE','Total Female for Attractions and Theme Parks Operations with Ecotourism (NC II)','Total Female for Attractions and Theme Parks Operations with Ecotourism (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_ATPOE','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_ATPOE','Total Attractions and Theme Parks Operations with Ecotourism (NC II)','Total Attractions and Theme Parks Operations with Ecotourism (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_BARB','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_BARB','Grade 11 Male Barbering (NC II)','Grade 11 Male Barbering (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_BARB','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_BARB','Grade 11 Female Barbering (NC II)','Grade 11 Female Barbering (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_BARB','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_BARB','Grade 11 Total Barbering (NC II)','Grade 11 Total Barbering (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_BARB','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_BARB','Grade 12 Male Barbering (NC II)','Grade 12 Male Barbering (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_BARB','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_BARB','Grade 12 Female Barbering (NC II)','Grade 12 Female Barbering (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_BARB','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_BARB','Grade 12 Total Barbering (NC II)','Grade 12 Total Barbering (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_BARB','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_BARB','Total Male for Barbering (NC II)','Total Male for Barbering (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_BARB','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_BARB','Total Female for Barbering (NC II)','Total Female for Barbering (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_BARB','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_BARB','Total Barbering (NC II)','Total Barbering (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_BART','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_BART','Grade 11 Male Bartending (NC II)','Grade 11 Male Bartending (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_BART','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_BART','Grade 11 Female Bartending (NC II)','Grade 11 Female Bartending (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_BART','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_BART','Grade 11 Total Bartending (NC II)','Grade 11 Total Bartending (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_BART','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_BART','Grade 12 Male Bartending (NC II)','Grade 12 Male Bartending (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_BART','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_BART','Grade 12 Female Bartending (NC II)','Grade 12 Female Bartending (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_BART','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_BART','Grade 12 Total Bartending (NC II)','Grade 12 Total Bartending (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_BART','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_BART','Total Male for Bartending (NC II)','Total Male for Bartending (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_BART','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_BART','Total Female for Bartending (NC II)','Total Female for Bartending (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_BART','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_BART','Total Bartending (NC II)','Total Bartending (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_BNC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_BNC','Grade 11 Male Beauty/Nail Care (NC II)','Grade 11 Male Beauty/Nail Care (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_BNC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_BNC','Grade 11 Female Beauty/Nail Care (NC II)','Grade 11 Female Beauty/Nail Care (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_BNC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_BNC','Grade 11 Total Beauty/Nail Care (NC II)','Grade 11 Total Beauty/Nail Care (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_BNC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_BNC','Grade 12 Male Beauty/Nail Care (NC II)','Grade 12 Male Beauty/Nail Care (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_BNC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_BNC','Grade 12 Female Beauty/Nail Care (NC II)','Grade 12 Female Beauty/Nail Care (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_BNC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_BNC','Grade 12 Total Beauty/Nail Care (NC II)','Grade 12 Total Beauty/Nail Care (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_BNC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_BNC','Total Male for Beauty/Nail Care (NC II)','Total Male for Beauty/Nail Care (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_BNC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_BNC','Total Female for Beauty/Nail Care (NC II)','Total Female for Beauty/Nail Care (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_BNC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_BNC','Total Beauty/Nail Care (NC II)','Total Beauty/Nail Care (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_BNP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_BNP','Grade 11 Male Bread and Pastry Production (NC II)','Grade 11 Male Bread and Pastry Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_BNP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_BNP','Grade 11 Female Bread and Pastry Production (NC II)','Grade 11 Female Bread and Pastry Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_BNP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_BNP','Grade 11 Total Bread and Pastry Production (NC II)','Grade 11 Total Bread and Pastry Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_BNP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_BNP','Grade 12 Male Bread and Pastry Production (NC II)','Grade 12 Male Bread and Pastry Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_BNP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_BNP','Grade 12 Female Bread and Pastry Production (NC II)','Grade 12 Female Bread and Pastry Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_BNP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_BNP','Grade 12 Total Bread and Pastry Production (NC II)','Grade 12 Total Bread and Pastry Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_BNP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_BNP','Total Male for Bread and Pastry Production (NC II)','Total Male for Bread and Pastry Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_BNP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_BNP','Total Female for Bread and Pastry Production (NC II)','Total Female for Bread and Pastry Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_BNP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_BNP','Total Bread and Pastry Production (NC II)','Total Bread and Pastry Production (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_CGV','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_CGV','Grade 11 Male Caregiving (NC II)','Grade 11 Male Caregiving (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_CGV','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_CGV','Grade 11 Female Caregiving (NC II)','Grade 11 Female Caregiving (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_CGV','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_CGV','Grade 11 Total Caregiving (NC II)','Grade 11 Total Caregiving (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_CGV','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_CGV','Grade 12 Male Caregiving (NC II)','Grade 12 Male Caregiving (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_CGV','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_CGV','Grade 12 Female Caregiving (NC II)','Grade 12 Female Caregiving (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_CGV','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_CGV','Grade 12 Total Caregiving (NC II)','Grade 12 Total Caregiving (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_CGV','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_CGV','Total Male for Caregiving (NC II)','Total Male for Caregiving (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_CGV','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_CGV','Total Female for Caregiving (NC II)','Total Female for Caregiving (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_CGV','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_CGV','Total Caregiving (NC II)','Total Caregiving (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_CC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_CC','Grade 11 Male Commercial Cooking (NC III)','Grade 11 Male Commercial Cooking (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_CC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_CC','Grade 11 Female Commercial Cooking (NC III)','Grade 11 Female Commercial Cooking (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_CC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_CC','Grade 11 Total Commercial Cooking (NC III)','Grade 11 Total Commercial Cooking (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_CC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_CC','Grade 12 Male Commercial Cooking (NC III)','Grade 12 Male Commercial Cooking (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_CC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_CC','Grade 12 Female Commercial Cooking (NC III)','Grade 12 Female Commercial Cooking (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_CC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_CC','Grade 12 Total Commercial Cooking (NC III)','Grade 12 Total Commercial Cooking (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_CC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_CC','Total Male for Commercial Cooking (NC III)','Total Male for Commercial Cooking (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_CC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_CC','Total Female for Commercial Cooking (NC III)','Total Female for Commercial Cooking (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_CC','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_CC','Total Commercial Cooking (NC III)','Total Commercial Cooking (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_COOK','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_COOK','Grade 11 Male Cookery (NC II)','Grade 11 Male Cookery (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_COOK','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_COOK','Grade 11 Female Cookery (NC II)','Grade 11 Female Cookery (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_COOK','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_COOK','Grade 11 Total Cookery (NC II)','Grade 11 Total Cookery (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_COOK','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_COOK','Grade 12 Male Cookery (NC II)','Grade 12 Male Cookery (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_COOK','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_COOK','Grade 12 Female Cookery (NC II)','Grade 12 Female Cookery (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_COOK','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_COOK','Grade 12 Total Cookery (NC II)','Grade 12 Total Cookery (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_COOK','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_COOK','Total Male for Cookery (NC II)','Total Male for Cookery (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_COOK','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_COOK','Total Female for Cookery (NC II)','Total Female for Cookery (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_COOK','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_COOK','Total Cookery (NC II)','Total Cookery (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_DRESS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_DRESS','Grade 11 Male Dressmaking (NC II)','Grade 11 Male Dressmaking (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_DRESS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_DRESS','Grade 11 Female Dressmaking (NC II)','Grade 11 Female Dressmaking (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_DRESS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_DRESS','Grade 11 Total Dressmaking (NC II)','Grade 11 Total Dressmaking (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_DRESS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_DRESS','Grade 12 Male Dressmaking (NC II)','Grade 12 Male Dressmaking (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_DRESS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_DRESS','Grade 12 Female Dressmaking (NC II)','Grade 12 Female Dressmaking (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_DRESS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_DRESS','Grade 12 Total Dressmaking (NC II)','Grade 12 Total Dressmaking (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_DRESS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_DRESS','Total Male for Dressmaking (NC II)','Total Male for Dressmaking (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_DRESS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_DRESS','Total Female for Dressmaking (NC II)','Total Female for Dressmaking (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_DRESS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_DRESS','Total Dressmaking (NC II)','Total Dressmaking (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_EMS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_EMS','Grade 11 Male Events Management Services (NC III)','Grade 11 Male Events Management Services (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_EMS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_EMS','Grade 11 Female Events Management Services (NC III)','Grade 11 Female Events Management Services (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_EMS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_EMS','Grade 11 Total Events Management Services (NC III)','Grade 11 Total Events Management Services (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_EMS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_EMS','Grade 12 Male Events Management Services (NC III)','Grade 12 Male Events Management Services (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_EMS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_EMS','Grade 12 Female Events Management Services (NC III)','Grade 12 Female Events Management Services (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_EMS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_EMS','Grade 12 Total Events Management Services (NC III)','Grade 12 Total Events Management Services (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_EMS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_EMS','Total Male for Events Management Services (NC III)','Total Male for Events Management Services (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_EMS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_EMS','Total Female for Events Management Services (NC III)','Total Female for Events Management Services (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_EMS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_EMS','Total Events Management Services (NC III)','Total Events Management Services (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_FD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_FD','Grade 11 Male Fashion Design (Apparel) (NC III)','Grade 11 Male Fashion Design (Apparel) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_FD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_FD','Grade 11 Female Fashion Design (Apparel) (NC III)','Grade 11 Female Fashion Design (Apparel) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_FD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_FD','Grade 11 Total Fashion Design (Apparel) (NC III)','Grade 11 Total Fashion Design (Apparel) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_FD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_FD','Grade 12 Male Fashion Design (Apparel) (NC III)','Grade 12 Male Fashion Design (Apparel) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_FD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_FD','Grade 12 Female Fashion Design (Apparel) (NC III)','Grade 12 Female Fashion Design (Apparel) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_FD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_FD','Grade 12 Total Fashion Design (Apparel) (NC III)','Grade 12 Total Fashion Design (Apparel) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_FD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_FD','Total Male for Fashion Design (Apparel) (NC III)','Total Male for Fashion Design (Apparel) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_FD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_FD','Total Female for Fashion Design (Apparel) (NC III)','Total Female for Fashion Design (Apparel) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_FD','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_FD','Total Fashion Design (Apparel) (NC III)','Total Fashion Design (Apparel) (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_FBS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_FBS','Grade 11 Male Food and Beverage Services (NC II)','Grade 11 Male Food and Beverage Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_FBS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_FBS','Grade 11 Female Food and Beverage Services (NC III)','Grade 11 Female Food and Beverage Services (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_FBS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_FBS','Grade 11 Total Food and Beverage Services (NC III)','Grade 11 Total Food and Beverage Services (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_FBS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_FBS','Grade 12 Male Food and Beverage Services (NC II)','Grade 12 Male Food and Beverage Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_FBS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_FBS','Grade 12 Female Food and Beverage Services (NC III)','Grade 12 Female Food and Beverage Services (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_FBS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_FBS','Grade 12 Total Food and Beverage Services (NC III)','Grade 12 Total Food and Beverage Services (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_FBS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_FBS','Total Male for Food and Beverage Services (NC II)','Total Male for Food and Beverage Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_FBS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_FBS','Total Female for Food and Beverage Services (NC III)','Total Female for Food and Beverage Services (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_FBS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_FBS','Total Food and Beverage Services (NC III)','Total Food and Beverage Services (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_FOS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_FOS','Grade 11 Male Front Office Services (NC II)','Grade 11 Male Front Office Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_FOS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_FOS','Grade 11 Female Front Office Services (NC II)','Grade 11 Female Front Office Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_FOS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_FOS','Grade 11 Total Front Office Services (NC II)','Grade 11 Total Front Office Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_FOS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_FOS','Grade 12 Male Front Office Services (NC II)','Grade 12 Male Front Office Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_FOS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_FOS','Grade 12 Female Front Office Services (NC II)','Grade 12 Female Front Office Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_FOS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_FOS','Grade 12 Total Front Office Services (NC II)','Grade 12 Total Front Office Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_FOS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_FOS','Total Male for Front Office Services (NC II)','Total Male for Front Office Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_FOS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_FOS','Total Female for Front Office Services (NC II)','Total Female for Front Office Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_FOS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_FOS','Total Front Office Services (NC II)','Total Front Office Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_HDII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_HDII','Grade 11 Male Hairdressing (NC II)','Grade 11 Male Hairdressing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_HDII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_HDII','Grade 11 Female Hairdressing (NC II)','Grade 11 Female Hairdressing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_HDII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_HDII','Grade 11 Total Hairdressing (NC II)','Grade 11 Total Hairdressing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_HDII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_HDII','Grade 12 Male Hairdressing (NC II)','Grade 12 Male Hairdressing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_HDII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_HDII','Grade 12 Female Hairdressing (NC II)','Grade 12 Female Hairdressing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_HDII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_HDII','Grade 12 Total Hairdressing (NC II)','Grade 12 Total Hairdressing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_HDII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_HDII','Total Male for Hairdressing (NC II)','Total Male for Hairdressing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_HDII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_HDII','Total Female for Hairdressing (NC II)','Total Female for Hairdressing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_HDII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_HDII','Total Hairdressing (NC II)','Total Hairdressing (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_HDIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_HDIII','Grade 11 Male Hairdressing (NC III)','Grade 11 Male Hairdressing (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_HDIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_HDIII','Grade 11 Female Hairdressing (NC III)','Grade 11 Female Hairdressing (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_HDIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_HDIII','Grade 11 Total Hairdressing (NC III)','Grade 11 Total Hairdressing (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_HDIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_HDIII','Grade 12 Male Hairdressing (NC III)','Grade 12 Male Hairdressing (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_HDIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_HDIII','Grade 12 Female Hairdressing (NC III)','Grade 12 Female Hairdressing (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_HDIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_HDIII','Grade 12 Total Hairdressing (NC III)','Grade 12 Total Hairdressing (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_HDIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_HDIII','Total Male for Hairdressing (NC III)','Total Male for Hairdressing (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_HDIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_HDIII','Total Female for Hairdressing (NC III)','Total Female for Hairdressing (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_HDIII','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_HDIII','Total Hairdressing (NC III)','Total Hairdressing (NC III)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_HBM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_HBM','Grade 11 Male Handicraft (Basketry/Macrame) (Non-NC)','Grade 11 Male Handicraft (Basketry/Macrame) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_HBM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_HBM','Grade 11 Female Handicraft (Basketry/Macrame) (Non-NC)','Grade 11 Female Handicraft (Basketry/Macrame) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_HBM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_HBM','Grade 11 Total Handicraft (Basketry/Macrame) (Non-NC)','Grade 11 Total Handicraft (Basketry/Macrame) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_HBM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_HBM','Grade 12 Male Handicraft (Basketry/Macrame) (Non-NC)','Grade 12 Male Handicraft (Basketry/Macrame) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_HBM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_HBM','Grade 12 Female Handicraft (Basketry/Macrame) (Non-NC)','Grade 12 Female Handicraft (Basketry/Macrame) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_HBM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_HBM','Grade 12 Total Handicraft (Basketry/Macrame) (Non-NC)','Grade 12 Total Handicraft (Basketry/Macrame) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_HBM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_HBM','Total Male for Handicraft (Basketry/ Macrame) (Non-NC)','Total Male for Handicraft (Basketry/ Macrame) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_HBM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_HBM','Total Female for Handicraft (Basketry/ Macrame) (Non-NC)','Total Female for Handicraft (Basketry/ Macrame) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_HBM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_HBM','Total Handicraft (Basketry/ Macrame) (Non-NC)','Total Handicraft (Basketry/ Macrame) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_HFAP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_HFAP','Grade 11 Male Handicraft (Fashion/Accessories Paper Craft) (Non-NC)','Grade 11 Male Handicraft (Fashion/Accessories Paper Craft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_HFAP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_HFAP','Grade 11 Female Handicraft (Fashion/Accessories Paper Craft) (Non-NC)','Grade 11 Female Handicraft (Fashion/Accessories Paper Craft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_HFAP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_HFAP','Grade 11 Total Handicraft (Fashion/Accessories Paper Craft) (Non-NC)','Grade 11 Total Handicraft (Fashion/Accessories Paper Craft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_HFAP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_HFAP','Grade 12 Male Handicraft (Fashion/Accessories Paper Craft) (Non-NC)','Grade 12 Male Handicraft (Fashion/Accessories Paper Craft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_HFAP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_HFAP','Grade 12 Female Handicraft (Fashion/Accessories Paper Craft) (Non-NC)','Grade 12 Female Handicraft (Fashion/Accessories Paper Craft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_HFAP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_HFAP','Grade 12 Total Handicraft (Fashion/Accessories Paper Craft) (Non-NC)','Grade 12 Total Handicraft (Fashion/Accessories Paper Craft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_HFAP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_HFAP','Total Male for Handicraft (Fashion Accessories/ Paper Craft) (Non-NC)','Total Male for Handicraft (Fashion Accessories/ Paper Craft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_HFAP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_HFAP','Total Female for Handicraft (Fashion Accessories/ Paper Craft) (Non-NC)','Total Female for Handicraft (Fashion Accessories/ Paper Craft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_HFAP','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_HFAP','Total Handicraft (Fashion Accessories/ Paper Craft) (Non-NC)','Total Handicraft (Fashion Accessories/ Paper Craft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_HN','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_HN','Grade 11 Male Handicraft (Needlecraft) (Non-NC)','Grade 11 Male Handicraft (Needlecraft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_HN','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_HN','Grade 11 Female Handicraft (Needlecraft) (Non-NC)','Grade 11 Female Handicraft (Needlecraft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_HN','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_HN','Grade 11 Total Handicraft (Needlecraft) (Non-NC)','Grade 11 Total Handicraft (Needlecraft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_HN','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_HN','Grade 12 Male Handicraft (Needlecraft) (Non-NC)','Grade 12 Male Handicraft (Needlecraft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_HN','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_HN','Grade 12 Female Handicraft (Needlecraft) (Non-NC)','Grade 12 Female Handicraft (Needlecraft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_HN','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_HN','Grade 12 Total Handicraft (Needlecraft) (Non-NC)','Grade 12 Total Handicraft (Needlecraft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_HN','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_HN','Total Male for Handicraft (Needlecraft) (Non-NC)','Total Male for Handicraft (Needlecraft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_HN','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_HN','Total Female for Handicraft (Needlecraft) (Non-NC)','Total Female for Handicraft (Needlecraft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_HN','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_HN','Total Handicraft (Needlecraft) (Non-NC)','Total Handicraft (Needlecraft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_HWL','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_HWL','Grade 11 Male Handicraft (Woodcraft/Leathercraft) (Non-NC)','Grade 11 Male Handicraft (Woodcraft/Leathercraft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_HWL','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_HWL','Grade 11 Female Handicraft (Woodcraft/Leathercraft) (Non-NC)','Grade 11 Female Handicraft (Woodcraft/Leathercraft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_HWL','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_HWL','Grade 11 Total Handicraft (Woodcraft/Leathercraft) (Non-NC)','Grade 11 Total Handicraft (Woodcraft/Leathercraft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_HWL','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_HWL','Grade 12 Male Handicraft (Woodcraft/Leathercraft) (Non-NC)','Grade 12 Male Handicraft (Woodcraft/Leathercraft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_HWL','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_HWL','Grade 12 Female Handicraft (Woodcraft/Leathercraft) (Non-NC)','Grade 12 Female Handicraft (Woodcraft/Leathercraft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_HWL','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_HWL','Grade 12 Total Handicraft (Woodcraft/Leathercraft) (Non-NC)','Grade 12 Total Handicraft (Woodcraft/Leathercraft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_HWL','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_HWL','Total Male for Handicraft (Woodcraft/ Leathercraft) (Non-NC)','Total Male for Handicraft (Woodcraft/ Leathercraft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_HWL','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_HWL','Total Female for Handicraft (Woodcraft/ Leathercraft) (Non-NC)','Total Female for Handicraft (Woodcraft/ Leathercraft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_HWL','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_HWL','Total Handicraft (Woodcraft/ Leathercraft) (Non-NC)','Total Handicraft (Woodcraft/ Leathercraft) (Non-NC)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_HK','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_HK','Grade 11 Male Housekeeping (NC II)','Grade 11 Male Housekeeping (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_HK','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_HK','Grade 11 Female Housekeeping (NC II)','Grade 11 Female Housekeeping (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_HK','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_HK','Grade 11 Total Housekeeping (NC II)','Grade 11 Total Housekeeping (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_HK','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_HK','Grade 12 Male Housekeeping (NC II)','Grade 12 Male Housekeeping (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_HK','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_HK','Grade 12 Female Housekeeping (NC II)','Grade 12 Female Housekeeping (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_HK','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_HK','Grade 12 Total Housekeeping (NC II)','Grade 12 Total Housekeeping (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_HK','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_HK','Total Male for Housekeeping (NC II)','Total Male for Housekeeping (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_HK','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_HK','Total Female for Housekeeping (NC II)','Total Female for Housekeeping (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_HK','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_HK','Total Housekeeping (NC II)','Total Housekeeping (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_LGS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_LGS','Grade 11 Male Local Guiding Services (NC II)','Grade 11 Male Local Guiding Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_LGS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_LGS','Grade 11 Female Local Guiding Services (NC II)','Grade 11 Female Local Guiding Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_LGS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_LGS','Grade 11 Total Local Guiding Services (NC II)','Grade 11 Total Local Guiding Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_LGS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_LGS','Grade 12 Male Local Guiding Services (NC II)','Grade 12 Male Local Guiding Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_LGS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_LGS','Grade 12 Female Local Guiding Services (NC II)','Grade 12 Female Local Guiding Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_LGS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_LGS','Grade 12 Total Local Guiding Services (NC II)','Grade 12 Total Local Guiding Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_LGS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_LGS','Total Male for Local Guiding Services (NC II)','Total Male for Local Guiding Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_LGS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_LGS','Total Female for Local Guiding Services (NC II)','Total Female for Local Guiding Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_LGS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_LGS','Total Local Guiding Services (NC II)','Total Local Guiding Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_TLOR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_TLOR','Grade 11 Male Tailoring (NC II)','Grade 11 Male Tailoring (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_TLOR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_TLOR','Grade 11 Female Tailoring (NC II)','Grade 11 Female Tailoring (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_TLOR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_TLOR','Grade 11 Total Tailoring (NC II)','Grade 11 Total Tailoring (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_TLOR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_TLOR','Grade 12 Male Tailoring (NC II)','Grade 12 Male Tailoring (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_TLOR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_TLOR','Grade 12 Female Tailoring (NC II)','Grade 12 Female Tailoring (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_TLOR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_TLOR','Grade 12 Total Tailoring (NC II)','Grade 12 Total Tailoring (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_TLOR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_TLOR','Total Male for Tailoring (NC II)','Total Male for Tailoring (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_TLOR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_TLOR','Total Female for Tailoring (NC II)','Total Female for Tailoring (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_TLOR','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_TLOR','Total Tailoring (NC II)','Total Tailoring (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_TPS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_TPS','Grade 11 Male Tourism Promotion Services (NC II)','Grade 11 Male Tourism Promotion Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_TPS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_TPS','Grade 11 Female Tourism Promotion Services (NC II)','Grade 11 Female Tourism Promotion Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_TPS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_TPS','Grade 11 Total Tourism Promotion Services (NC II)','Grade 11 Total Tourism Promotion Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_TPS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_TPS','Grade 12 Male Tourism Promotion Services (NC II)','Grade 12 Male Tourism Promotion Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_TPS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_TPS','Grade 12 Female Tourism Promotion Services (NC II)','Grade 12 Female Tourism Promotion Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_TPS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_TPS','Grade 12 Total Tourism Promotion Services (NC II)','Grade 12 Total Tourism Promotion Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_TPS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_TPS','Total Male for Tourism Promotion Services (NC II)','Total Male for Tourism Promotion Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_TPS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_TPS','Total Female for Tourism Promotion Services (NC II)','Total Female for Tourism Promotion Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_TPS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_TPS','Total Tourism Promotion Services (NC II)','Total Tourism Promotion Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_TS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_TS','Grade 11 Male Travel Services (NC II)','Grade 11 Male Travel Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_TS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_TS','Grade 11 Female Travel Services (NC II)','Grade 11 Female Travel Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_TS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_TS','Grade 11 Total Travel Services (NC II)','Grade 11 Total Travel Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_TS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_TS','Grade 12 Male Travel Services (NC II)','Grade 12 Male Travel Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_TS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_TS','Grade 12 Female Travel Services (NC II)','Grade 12 Female Travel Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_TS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_TS','Grade 12 Total Travel Services (NC II)','Grade 12 Total Travel Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_TS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_TS','Total Male for Travel Services (NC II)','Total Male for Travel Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_TS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_TS','Total Female for Travel Services (NC II)','Total Female for Travel Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_TS','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_TS','Total Travel Services (NC II)','Total Travel Services (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11male_WM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_WM','Grade 11 Male Wellness Massage (NC II)','Grade 11 Male Wellness Massage (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11female_WM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_WM','Grade 11 Female Wellness Massage (NC II)','Grade 11 Female Wellness Massage (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g11_TOT_WM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_TOT_WM','Grade 11 Total Wellness Massage (NC II)','Grade 11 Total Wellness Massage (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12male_WM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_WM','Grade 12 Male Wellness Massage (NC II)','Grade 12 Male Wellness Massage (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12female_WM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12female_WM','Grade 12 Female Wellness Massage (NC II)','Grade 12 Female Wellness Massage (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'g12_TOT_WM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_TOT_WM','Grade 12 Total Wellness Massage (NC II)','Grade 12 Total Wellness Massage (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gmale_TOT_WM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gmale_TOT_WM','Total Male Wellness Massage (NC II)','Total Male Wellness Massage (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'gfemale_TOT_WM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','gfemale_TOT_WM','Total Female Wellness Massage (NC II)','Total Female Wellness Massage (NC II)',@dataset_head_id,1); 
 

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) 
VALUES(@table_id,'TOT_WM','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); 
 
INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) 
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','TOT_WM','Total Wellness Massage (NC II)','Total Wellness Massage (NC II)',@dataset_head_id,1); 
 


 


 




