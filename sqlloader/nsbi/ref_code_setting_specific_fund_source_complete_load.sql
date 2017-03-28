-- VISIBLE INVISIBLE!!!@@#()!!!!@*#)(!@*#()@!*#!@#*)(!@#!@#(@!_#@!(#)!@(#)@!#*@!&#*(@!


-- TABLE METADATA
SET @school_basic_inf_dataset_head_id=8;
SET @school_basic_inf_sy_from_id=266;
SET @school_basic_inf_school_id=267;


INSERT INTO orsdb.table_metadata
(db_id,schema_name,table_name,description,col_count,row_count,location,date_created,created_by,date_updated,updated_by)
VALUES
(2,
'sisdbtest',
'ref_code_setting',
'ref_code_setting',
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
(name,description,owner_id,date_created,created_by,date_updated,updated_by,visible,parent_dataset_head,table_id,ranking)
VALUES
(
'Ref Code Specific Fund Source',
'Ref Code Specific Fund Source',
0,
CURDATE(),
'SYSTEM',
CURDATE(),
'SYSTEM',
0,
0,
@table_id,
918
);


SET @dataset_head_id=LAST_INSERT_ID();

-- COLUMN METADATA

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES(@table_id,'id','int',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','id','refcode_spcfcfundsrc_id','refcode_spcfcfundsrc_id',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES(@table_id,'description','varchar',0,0,500,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

SET @column_id=LAST_INSERT_ID();


INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(@column_id,NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','specific_fund_source','Specific Fund Source','Specific Fund Source',@dataset_head_id,0);

