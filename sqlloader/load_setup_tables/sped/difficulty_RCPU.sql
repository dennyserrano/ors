-- TABLE METADATA
SET @school_basic_inf_dataset_head_id=8;
SET @school_basic_inf_sy_from_id=266;
SET @school_basic_inf_school_id=267;
SET @existing_correlation=77;


SET @table_id=12;

SET @dataset_head_id=2035;

-- COLUMN METADATA

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES(@table_id,'id','int',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','id','id','id',@dataset_head_id,0);



INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES(@table_id,'sy_from','mediumint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);


INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','sy_from','school year from','School Year',@dataset_head_id,1);

SET @dataset_element_sy_from_id=LAST_INSERT_ID();


INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'school_id','int',0,0,10,curdate(),'SYSTEM',curdate(),'SYSTEM',0);


INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','school_id','school id','School ID',@dataset_head_id,1);


SET @dataset_element_school_id=LAST_INSERT_ID();


INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g7male_drcpu','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g7male_drcpu','Grade7 Male','Grade7 Male',@dataset_head_id,1);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g7female_drcpu','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g7female_drcpu','Grade7 Female','Grade7',@dataset_head_id,1);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g7total_drcpu','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g7total_drcpu','Grade7 Total','Grade7 Total',@dataset_head_id,1);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g8male_drcpu','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g8male_drcpu','Grade 8 Male','Grade 8 Male',@dataset_head_id,1);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g8female_drcpu','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g8female_drcpu','Grade 8 Female','Grade 8 Female',@dataset_head_id,1);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g9male_drcpu','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g9male_drcpu','Grade 9 Male','Grade 9 Male',@dataset_head_id,1);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g9female_drcpu','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g9female_drcpu','Grade 9 Female','Grade 9 Female',@dataset_head_id,1);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g9total_drcpu','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g9total_drcpu','Grade 9 Total','Grade 9 Total',@dataset_head_id,1);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g10male_drcpu','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g10male_drcpu','Grade 10 Male','Grade 10 Male',@dataset_head_id,1);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g10female_drcpu','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g10female_drcpu','Grade 10 Male','Grade 10 Male',@dataset_head_id,1);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g10total_drcpu','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g10total_drcpu','Grade 10 Total','Grade 10 Total',@dataset_head_id,1);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g11male_drcpu','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11male_drcpu','Grade 11 Male','Grade 11 Male',@dataset_head_id,1);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g11female_drcpu','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11female_drcpu','Grade 11 Female','Grade 11 Female',@dataset_head_id,1);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g11total_drcpu','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11total_drcpu','Grade 11 Total','Grade 11 Total',@dataset_head_id,1);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g12male_drcpu','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12male_drcpu','Grade 12 Male','Grade 12 Male',@dataset_head_id,1);


INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'ngmale_drcpu','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','ngmale_drcpu','Non-Graded Male','Non-Graded Male',@dataset_head_id,1);


INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'ngfemale_drcpu','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','ngfemale_drcpu','Non-Graded Female','Non-Graded Female',@dataset_head_id,1);


INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'ngtotal_drcpu','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','ngtotal_drcpu','Non-Graded Total','Non-Graded Total',@dataset_head_id,1);


INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'totmale_drcpu','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','totmale_drcpu','Total Male','Total Male',@dataset_head_id,1);


INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'totfemale_drcpu','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','totfemale_drcpu','Total Female','Total Female',@dataset_head_id,1);


INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'total_drcpu','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','total_drcpu','Total','Total',@dataset_head_id,1);


SET @correlation=(SELECT id FROM orsdb.dataset_correlation where id=@existing_correlation);

UPDATE orsdb.dataset_correlation
SET right_dataset_head_id=@dataset_head_id
WHERE id=@correlation;

SET SQL_SAFE_UPDATES = 0;
DELETE FROM orsdb.dataset_correlation_dtl
WHERE dataset_correlation_id=@correlation;
SET SQL_SAFE_UPDATES = 1;

SET @correlation_head_id=@correlation;

INSERT INTO orsdb.dataset_correlation_dtl(
dataset_correlation_id,
left_dataset_element_id,
operator,
right_dataset_element_id,
date_created,
created_by,
date_updated,
updated_by
)
VALUES
(@correlation_head_id,@school_basic_inf_sy_from_id,'EQ',@dataset_element_sy_from_id,curdate(),'SYSTEM',curdate(),'SYSTEM'),
(@correlation_head_id,@school_basic_inf_school_id,'EQ',@dataset_element_school_id,curdate(),'SYSTEM',curdate(),'SYSTEM');




