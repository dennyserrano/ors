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
'nsbi_specifics',
'nsbi specifics report',
0,
0,
NULL,
curdate(),
'SYSTEM',
curdate(),
'SYSTEM'
);

SET @table_id=LAST_INSERT_ID();

SET @nsbi_summary_dataset_head_id=(SELECT id FROM dataset_head where name='National School Building Inventory');

-- DATASET HEAD

INSERT INTO orsdb.dataset_head
(name,description,owner_id,date_created,created_by,date_updated,updated_by,visible,parent_dataset_head,table_id,ranking)
VALUES
(
'Specifics Reports',
'Specifics Reports',
0,
CURDATE(),
'SYSTEM',
CURDATE(),
'SYSTEM',
1,
@nsbi_summary_dataset_head_id,
@table_id,
916
);


SET @dataset_head_id=LAST_INSERT_ID();

-- COLUMN METADATA

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES(@table_id,'id','int',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','id','id','id',@dataset_head_id,0);

SET @dataset_element_sy_from_id=LAST_INSERT_ID();

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES(@table_id,'sy_from','mediumint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);


INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','sy_from','school year from','School Year',@dataset_head_id,0);

SET @dataset_element_school_id=LAST_INSERT_ID();

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'school_id','int',0,0,10,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','school_id','school id','School ID',@dataset_head_id,0);


INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'bldg_struct','varchar',0,0,9,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','bldg_struct','Building Structure','Building Structure',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'bldg_struct_num','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','bldg_struct_num','Building Structure Number','Building Structure Number',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'bldg_struct_type_id','int',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','bldg_struct_type_id','bldg_struct_type_id','bldg_struct_type_id',@dataset_head_id,0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) -- ****
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','bldg_struct_type','Building Structure Type','Building Structure Type',@dataset_head_id,1); -- ****

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'bldg_cond_id','int',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','bldg_cond_id','bldg_cond_id','bldg_cond_id',@dataset_head_id,0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) -- ****
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','bldg_cond_id','Building Condition','Building Condition',@dataset_head_id,0); -- ****

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'bldg_class_id','int',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','bldg_class_id','bldg_class_id','bldg_class_id',@dataset_head_id,0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) -- ****
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','bldg_class','Building Classification','Building Classification',@dataset_head_id,0); -- ****

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'storeys','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','storeys','Storeys','Storeys',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'fund_src_id','int',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','fund_src_id','fund_src_id','fund_src_id',@dataset_head_id,0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) -- ****
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','fund_src','Fund Source','Fund Source',@dataset_head_id,0); -- ****

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'specific_fund_src_id','int',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','specific_fund_src_id','specific_fund_src_id','specific_fund_src_id',@dataset_head_id,0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) -- ****
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','specific_fund_src','Specific Fund Source','Specific Fund Source',@dataset_head_id,0); -- ****

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'bldg_dimnsn_len','float',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','bldg_dimnsn_len','Building Dimension Length','Building Dimension Length',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'bldg_dimnsn_wdth','float',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','bldg_dimnsn_wdth','Building Dimension Width','Building Dimension Width',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'rm_number','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','rm_number','Room Number','Room Number',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'class_cond_id','int',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','class_cond_id','class_cond_id','class_cond_id',@dataset_head_id,0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) -- ****
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','class_cond','Classroom Condition','Classroom Condition',@dataset_head_id,0); -- ****

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'repair_5yrs','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','repair_5yrs','Undergone Repair in the Last 5 Years','Undergone Repair in the Last 5 Years',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES(@table_id,'rm_dimnsn_len','float',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','rm_dimnsn_len','Room Dimension Length','Room Dimension Length',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'rm_dimnsn_wdth','float',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','rm_dimnsn_wdth','Room Dimension Width','Room Dimension Width',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'concurrent_usage','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','concurrent_usage','Concurrent Usage','Concurrent Usage',@dataset_head_id,0);


INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'kinder_mod_table','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','kinder_mod_table','Kinder Modular Table','Kinder Modular Table',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'kinder_chr','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','kinder_chr','Kinder Chair','Kinder Chair',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'arm_chr','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','arm_chr','Arm Chair','Arm Chair',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'school_desk','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','school_desk','School Desk','School Desk',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'sci_lbtble','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','sci_lbtble','Science Laboratory Table','Science Laboratory Table',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'sci_lbstool','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','sci_lbstool','Science Laboratory Stool','Science Laboratory Stool',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'wrkshp_tbl','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','wrkshp_tbl','Workshop Table','Workshop Table',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'mono_bloc_chr','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','mono_bloc_chr','Monobloc Chair','Monobloc Chair',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'mono_bloc_stl','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','mono_bloc_stl','Monobloc Stool','Monobloc Stool',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'clasrm_tbl','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','clasrm_tbl','Classroom Table','Classroom Table',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'clasrm_chr','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','clasrm_chr','Classroom Chair','Classroom Chair',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'behvr_chr','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','behvr_chr','Behavioral Chair','Behavioral Chair',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'teachr_tbl','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);


INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','teachr_tbl','Teacher Table','Teacher Table',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'teachr_chr','smallint',0,0,5,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','teachr_chr','Teacher Chair','Teacher Chair',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'conc_quad','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','conc_quad','Concrete Quadrangle','Concrete Quadrangle',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'entr_gate','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','entr_gate','Entrance Gate','Entrance Gate',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'perim_fence','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','perim_fence','Perimeter Fence','Perimeter Fence',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'playground','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','playground','Playground','Playground',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'schl_grdn','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','schl_grdn','School Garden','School Garden',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'kinder_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','kinder_class','Kinder Classroom','Kinder Classroom',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g1_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g1_class','Grade 1 Classroom','Grade 1 Classroom',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g2_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g2_class','Grade 2 Classroom','Grade 2 Classroom',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g3_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g3_class','Grade 3 Classroom','Grade 3 Classroom',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g4_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g4_class','Grade 4 Classroom','Grade 4 Classroom',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g5_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g5_class','Grade 5 Classroom','Grade 5 Classroom',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g6_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g6_class','Grade 6 Classroom','Grade 6 Classroom',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g7_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g7_class','Grade 7 Classroom','Grade 7 Classroom',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g8_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g8_class','Grade 8 Classroom','Grade 8 Classroom',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g9_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g9_class','Grade 9 Classroom','Grade 9 Classroom',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g10_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g10_class','Grade 10 Classroom','Grade 10 Classroom',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g11_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g11_class','Grade 11 Classroom','Grade 11 Classroom',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'g12_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','g12_class','Grade 12 Classroom','Grade 12 Classroom',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'sped_class','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','sped_class','SPED Classroom','SPED Classroom',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'als_rm','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','als_rm','ALS Room','ALS Room',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'comp_rm','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','comp_rm','Computer Room','Computer Room',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'indus_arts_rm','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','indus_arts_rm','Industrial Arts Room','Industrial Arts Room',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'home_econ_rm','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','home_econ_rm','Home Economic Room','Home Economic Room',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'sci_lab','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','sci_lab','Science Laboratory','Science Laboratory',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'speech_lab','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','speech_lab','Speech Laboratory','Speech Laboratory',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'research_lab','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','research_lab','Research Laboratory','Research Laboratory',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'inst_aud_visual','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','inst_aud_visual','Instructional Audio Visual','Instructional Audio Visual',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'inst_not_used','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','inst_not_used','Instructional Not Used','Instructional Not Used',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'lib_res_cntr','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','lib_res_cntr','Library/Learning Resource Center','Library/Learning Resource Center',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'canteen','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','canteen','Canteen','Canteen',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'clinic','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','clinic','Clinic','Clinic',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'conf_room','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','conf_room','Conference Room','Conference Room',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'offices','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','offices','Offices','Offices',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'faclty_rm','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','faclty_rm','Faculty Room','Faculty Room',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'museum','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','museum','Museum','Museum',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'supply_rm','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','supply_rm','Supply Room','Supply Room',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'datafle_rm','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','datafle_rm','Data File Room/Records Room','Data File Room/Records Room',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'stud_curr_cntr','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','stud_curr_cntr','Student Co-Curricular Center','Student Co-Curricular Center',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'youth_dev','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','youth_dev','Youth Development Center','Youth Development Center',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'nonInst_aud_vis','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','nonInst_aud_vis','Non Instructional Audio Visual','Non Instructional Audio Visual',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'nonInst_notUsed','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','nonInst_notUsed','Non Instructional Not Used','Non Instructional Not Used',@dataset_head_id,0);

INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key)
VALUES (@table_id,'others','tinyint',0,0,3,curdate(),'SYSTEM',curdate(),'SYSTEM',0);

INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible)
VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','others','Others','Others',@dataset_head_id,0);



INSERT INTO orsdb.dataset_correlation(
left_table_prefix,
left_dataset_head_id,
join_type,
right_table_prefix,
right_dataset_head_id,
date_created,
created_by,
date_updated,
updated_by
)
VALUES
(
'sp',
@school_basic_inf_dataset_head_id,
0,
'sbi_nsbi_summary',
@dataset_head_id,
curdate(),
'SYSTEM',
curdate(),
'SYSTEM'
);

SET @correlation_head_id=LAST_INSERT_ID();

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


