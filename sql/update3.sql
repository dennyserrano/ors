UPDATE orsdb.column_metadata 
SET column_name='sy_from'
WHERE column_id=6811;


-- SELECT * FROM orsdb.dataset_element A 
-- INNER JOIN orsdb.dataset_correlation_dtl B ON A.id=B.right_dataset_element_id
-- INNER JOIN orsdb.dataset_correlation C ON B.dataset_correlation_id=C.id
-- 
-- 
-- WHERE C.right_table_prefix='prog_es_alive' and A.name='school_year';
