SET SQL_SAFE_UPDATES = 0;

-- DELETE DH.*,DE.*,CM.*,TM.* FROM table_metadata TM
-- INNER JOIN column_metadata CM ON CM.table_id=TM.table_id
-- INNER JOIN dataset_element DE ON CM.column_id=DE.column_id
-- INNER JOIN dataset_head DH ON TM.table_id=DH.table_id
-- WHERE DH.id in (9036);

DELETE DE.* FROM dataset_head DH
INNER JOIN dataset_element DE ON DH.id=DE.dataset_head_id 
WHERE DH.id in (9054,9055,9056,9057,9058,9059,9060,9061,9062);

DELETE CM.* FROM dataset_head DH
INNER JOIN table_metadata TM ON DH.table_id=TM.table_id
INNER JOIN column_metadata CM ON CM.table_id=TM.table_id
WHERE DH.id in (9054,9055,9056,9057,9058,9059,9060,9061,9062);

DELETE TM.* FROM dataset_head DH
INNER JOIN table_metadata TM ON DH.table_id=TM.table_id
WHERE DH.id in (9054,9055,9056,9057,9058,9059,9060,9061,9062);

DELETE DH.* FROM dataset_head DH
WHERE DH.id in (9054,9055,9056,9057,9058,9059,9060,9061,9062);

SET SQL_SAFE_UPDATES = 1;