SET @dataset_head_specifics_name="Specifics Reports";
SET @dataset_head_bldg_struct_type_name="Building Structure Type";
SET @dataset_head_specific_fund_src_name="Building Structure Specific Fund Source";
SET @dataset_head_fund_src_name="Building Structure Fund Source";
SET @dataset_head_bldg_room_name="Building Room";
SET @dataset_head_rc_bldg_cond_name="Ref Code Bldg Condition";
SET @dataset_head_rc_bldg_class_name="Ref Code Bldg Classification";
SET @dataset_head_rc_class_cond_name="Ref Code Classroom Condition";
SET @dataset_head_rc_fund_src_name="Ref Code Fund Source";
SET @dataset_head_rc_specific_fund_src_name="Ref Specific Fund Source";

SET @dataset_head_specifics_id=(SELECT id FROM orsdb.dataset_head where name=@dataset_head_specifics_name);
SET @dataset_head_bldg_struct_type_id=(SELECT id FROM orsdb.dataset_head where name=@dataset_head_bldg_struct_type_name);
SET @dataset_head_specific_fund_src_id=(SELECT id FROM orsdb.dataset_head where name=@dataset_head_specific_fund_src_name);
SET @dataset_head_fund_src_id=(SELECT id FROM orsdb.dataset_head where name=@dataset_head_fund_src_name);
SET @dataset_head_bldg_room_id=(SELECT id FROM orsdb.dataset_head where name=@dataset_head_bldg_room_name);
SET @dataset_head_rc_bldg_cond_id=(SELECT id FROM orsdb.dataset_head where name=@dataset_head_rc_bldg_cond_name);
SET @dataset_head_rc_bldg_class_id=(SELECT id FROM orsdb.dataset_head where name=@dataset_head_rc_bldg_class_name);
SET @dataset_head_rc_class_cond_id=(SELECT id FROM orsdb.dataset_head where name=@dataset_head_rc_class_cond_name);
SET @dataset_head_rc_fund_src_id=(SELECT id FROM orsdb.dataset_head where name=@dataset_head_rc_fund_src_name);
SET @dataset_head_rc_specific_fund_src_id=(SELECT id FROM orsdb.dataset_head where name=@dataset_head_rc_specific_fund_src_name);


-- SPECIFICS
INSERT INTO orsdb.dataset_correlation(left_table_prefix,left_dataset_head_id,join_type,right_table_prefix,right_dataset_head_id,date_created,created_by,date_updated,updated_by)
VALUES ('sp',8,'0','schlprof_nsbispec',@dataset_head_specifics_id,curdate(),'SYSTEM',curdate(),'SYSTEM');

SET @parent_id=LAST_INSERT_ID();
SET @left_school_id=(SELECT id FROM orsdb.dataset_element where dataset_head_id=8 and name='school_id');
SET @left_sy_from_id=(SELECT id FROM orsdb.dataset_element where dataset_head_id=8 and name='sy_from');
SET @right_school_id=(SELECT id FROM orsdb.dataset_element where dataset_head_id=@dataset_head_specifics_id and name='school_id');
SET @right_sy_from_id=(SELECT id FROM orsdb.dataset_element where dataset_head_id=@dataset_head_specifics_id and name='sy_from');


INSERT INTO orsdb.dataset_correlation_dtl(dataset_correlation_id,left_dataset_element_id,operator,right_dataset_element_id,date_created,created_by,date_updated,updated_by)
VALUES (@parent_id,@left_school_id,'EQ',@right_school_id,curdate(),'SYSTEM',curdate(),'SYSTEM'),
	   (@parent_id,@left_sy_from_id,'EQ',@right_sy_from_id,curdate(),'SYSTEM',curdate(),'SYSTEM');



-- BLDG STRUCT TYPE

INSERT INTO orsdb.dataset_correlation(left_table_prefix,left_dataset_head_id,join_type,right_table_prefix,right_dataset_head_id,date_created,created_by,date_updated,updated_by)
VALUES ('sp',@dataset_head_specifics_id,'0','specfc_strct_type',@dataset_head_bldg_struct_type_id,curdate(),'SYSTEM',curdate(),'SYSTEM');

SET @parent_id=LAST_INSERT_ID();
SET @right_id=(SELECT id FROM orsdb.dataset_element where dataset_head_id=@dataset_head_bldg_struct_type_id and name='id');
SET @left_id=(SELECT id FROM orsdb.dataset_element where dataset_head_id=@dataset_head_specifics_id and name='bldg_struct_type_id');


INSERT INTO orsdb.dataset_correlation_dtl(dataset_correlation_id,left_dataset_element_id,operator,right_dataset_element_id,date_created,created_by,date_updated,updated_by)
VALUES (@parent_id,@left_id,'EQ',@right_id,curdate(),'SYSTEM',curdate(),'SYSTEM');


-- BLDG CONDITION

INSERT INTO orsdb.dataset_correlation(left_table_prefix,left_dataset_head_id,join_type,right_table_prefix,right_dataset_head_id,date_created,created_by,date_updated,updated_by)
VALUES ('sp',@dataset_head_specifics_id,'0','specfc_bldg_cond',@dataset_head_rc_bldg_cond_id,curdate(),'SYSTEM',curdate(),'SYSTEM');

SET @parent_id=LAST_INSERT_ID();
SET @right_id=(SELECT id FROM orsdb.dataset_element where dataset_head_id=@dataset_head_rc_bldg_cond_id and name='id');
SET @left_id=(SELECT id FROM orsdb.dataset_element where dataset_head_id=@dataset_head_specifics_id and name='bldg_cond_id');


INSERT INTO orsdb.dataset_correlation_dtl(dataset_correlation_id,left_dataset_element_id,operator,right_dataset_element_id,date_created,created_by,date_updated,updated_by)
VALUES (@parent_id,@left_id,'EQ',@right_id,curdate(),'SYSTEM',curdate(),'SYSTEM');


-- BLDG CLASSIFICATION

INSERT INTO orsdb.dataset_correlation(left_table_prefix,left_dataset_head_id,join_type,right_table_prefix,right_dataset_head_id,date_created,created_by,date_updated,updated_by)
VALUES ('sp',@dataset_head_specifics_id,'0','specfc_bldg_class',@dataset_head_rc_bldg_class_id,curdate(),'SYSTEM',curdate(),'SYSTEM');

SET @parent_id=LAST_INSERT_ID();
SET @right_id=(SELECT id FROM orsdb.dataset_element where dataset_head_id=@dataset_head_rc_bldg_class_id and name='id');
SET @left_id=(SELECT id FROM orsdb.dataset_element where dataset_head_id=@dataset_head_specifics_id and name='bldg_class_id');


INSERT INTO orsdb.dataset_correlation_dtl(dataset_correlation_id,left_dataset_element_id,operator,right_dataset_element_id,date_created,created_by,date_updated,updated_by)
VALUES (@parent_id,@left_id,'EQ',@right_id,curdate(),'SYSTEM',curdate(),'SYSTEM');

-- BLDG STRUCT FUND SOURCE

INSERT INTO orsdb.dataset_correlation(left_table_prefix,left_dataset_head_id,join_type,right_table_prefix,right_dataset_head_id,date_created,created_by,date_updated,updated_by)
VALUES ('sp',@dataset_head_specifics_id,'0','specfc_fnd_src',@dataset_head_rc_fund_src_id,curdate(),'SYSTEM',curdate(),'SYSTEM');

SET @parent_id=LAST_INSERT_ID();
SET @right_id=(SELECT id FROM orsdb.dataset_element where dataset_head_id=@dataset_head_rc_fund_src_id and name='id');
SET @left_id=(SELECT id FROM orsdb.dataset_element where dataset_head_id=@dataset_head_specifics_id and name='fund_src_id');


INSERT INTO orsdb.dataset_correlation_dtl(dataset_correlation_id,left_dataset_element_id,operator,right_dataset_element_id,date_created,created_by,date_updated,updated_by)
VALUES (@parent_id,@left_id,'EQ',@right_id,curdate(),'SYSTEM',curdate(),'SYSTEM');


-- BLDG STRUCT SPECIFIC FUND SOURCE

INSERT INTO orsdb.dataset_correlation(left_table_prefix,left_dataset_head_id,join_type,right_table_prefix,right_dataset_head_id,date_created,created_by,date_updated,updated_by)
VALUES ('sp',@dataset_head_specifics_id,'0','specfc_spc_fnd_src',@dataset_head_rc_specific_fund_src_id,curdate(),'SYSTEM',curdate(),'SYSTEM');

SET @parent_id=LAST_INSERT_ID();
SET @right_id=(SELECT id FROM orsdb.dataset_element where dataset_head_id=@dataset_head_rc_specific_fund_src_id and name='id');
SET @left_id=(SELECT id FROM orsdb.dataset_element where dataset_head_id=@dataset_head_specifics_id and name='specific_fund_src_id');


INSERT INTO orsdb.dataset_correlation_dtl(dataset_correlation_id,left_dataset_element_id,operator,right_dataset_element_id,date_created,created_by,date_updated,updated_by)
VALUES (@parent_id,@left_id,'EQ',@right_id,curdate(),'SYSTEM',curdate(),'SYSTEM');


-- CLASSROOM CONDITION

INSERT INTO orsdb.dataset_correlation(left_table_prefix,left_dataset_head_id,join_type,right_table_prefix,right_dataset_head_id,date_created,created_by,date_updated,updated_by)
VALUES ('sp',@dataset_head_specifics_id,'0','specfc_class_cond',@dataset_head_rc_class_cond_id,curdate(),'SYSTEM',curdate(),'SYSTEM');

SET @parent_id=LAST_INSERT_ID();
SET @right_id=(SELECT id FROM orsdb.dataset_element where dataset_head_id=@dataset_head_rc_class_cond_id and name='id');
SET @left_id=(SELECT id FROM orsdb.dataset_element where dataset_head_id=@dataset_head_specifics_id and name='class_cond_id');


INSERT INTO orsdb.dataset_correlation_dtl(dataset_correlation_id,left_dataset_element_id,operator,right_dataset_element_id,date_created,created_by,date_updated,updated_by)
VALUES (@parent_id,@left_id,'EQ',@right_id,curdate(),'SYSTEM',curdate(),'SYSTEM');
