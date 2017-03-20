-- TABLE METADATA
INSERT INTO orsdb.table_metadata
(
db_id,
schema_name,
table_name,
description,
col_count,
row_count,
location,
date_created,
created_by,
date_updated,
updated_by
)
VALUES
(
2,
'sisdbtest',
'nsbi_summary',
'nsbi summary report',
0,
0,
NULL,
curdate(),
'SYSTEM',
curdate(),
'SYSTEM'
);

SET @table_id=LAST_INSERT_ID();

-- DATASET HEAD

INSERT INTO orsdb.dataset_head
(
name,
description,
owner_id,
date_created,
created_by,
date_updated,
updated_by,
visible,
parent_dataset_head,
table_id,
ranking
)
VALUES
(
'NSBI Summary',
'Summary of NSBI Reports',
0,
CURDATE(),
'SYSTEM',
CURDATE(),
'SYSTEM',
1,
0,
@table_id,
914
);

SET @dataset_head_id=LAST_INSERT_ID();

-- COLUMN METADATA

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES(@table_id,'id','int',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','id','id','id',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES(@table_id,'sy_from','mediumint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','sy_from','school year from','School Year',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'school_id','int',0,0,10,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','school_id','school id','School ID',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'total_struct','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','total_struct','Total Structure','Total Structure',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'struct_perm','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','struct_perm','Permanent Structure','Number of Permanent Structure',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'struct_semi_perm','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','struct_semi_perm','Semi Permanent Structure','Number of Semi Permanent Structure',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'struct_make_shift','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','struct_make_shift','Make Shift Structure','Number of Make Shift Structure',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'total_bldgs','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','total_bldgs','Total Buildings','Total Buildings',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'bldg_perm','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','bldg_perm','Permanent Building','Permanent Building',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'bldg_semi_perm','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','bldg_semi_perm','Semi Permanent Building','Semi Permanent Building',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'bldg_make_shift','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','bldg_make_shift','Building Make Shift','Building Make Shift',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'total_rm','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','total_rm','Room Total','Room Total',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'rm_cond_good','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','rm_cond_good','Room Good Condition','Room Good Condition',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'rm_cond_minRep','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','rm_cond_minRep','Minimum Repair Condition','Minimum Repair Condition',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'rm_cond_majRep','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','rm_cond_majRep','Major Repair Condition','Major Repair Condition',@dataset_head_id,0);


INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'rm_cond_ongoing_const','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','rm_cond_ongoing_const','On-going Construction Condition','On-going Construction Condition',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES(@table_id,'rm_cond_forComp','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','rm_cond_forComp','For Completion Condition','For Completion Condition',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'rm_cond_forCondemn','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','rm_cond_forCondemn','For Condemnation Condition','For Condemnation Condition',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'rm_cond_condemned','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','rm_cond_condemned','Condemnation Condition','Condemnation Condition',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'total_roomsRepUnder5Yrs','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','total_roomsRepUnder5Yrs','Rooms repaired under 5 years','Rooms repaired under 5 years',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'above40sq','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','above40sq','Above 40sq','Above 40sq',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'toilet_male','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'toilet_female','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'toilet_pwd','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'toilet_shared','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'non_function_bowls','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'sink_washbn','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'urinals','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'urinal_trough','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'septic_tank','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'with_faucet','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'without_faucet','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'kinder_mod_table','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'kinder_chr','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'arm_chr','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'school_desk','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'sci_lbtble','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'sci_lbstool','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'wrkshp_tbl','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'mono_bloc_chr','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'mono_bloc_stl','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'clasrm_tbl','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'clasrm_chr','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'behvr_chr','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'teachr_tbl','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'teachr_chr','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'conc_quad','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'entr_gate','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'perim_fence','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'playground','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'schl_grdn','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'kinder_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g1_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g2_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g3_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g4_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g5_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g6_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g7_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g8_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g9_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g10_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g11_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g12_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'sped_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'als_rm','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'comp_rm','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'indus_arts_rm','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'home_econ_rm','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'sci_lab','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'speech_lab','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'research_lab','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'inst_aud_visual','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'inst_not_used','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'lib_res_cntr','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'canteen','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'clinic','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'conf_room','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'offices','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'faclty_rm','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'museum','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'supply_rm','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'datafle_rm','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'stud_curr_cntr','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'youth_dev','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'nonInst_aud_vis','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'nonInst_notUsed','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'others','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);



