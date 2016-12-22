SET SQL_SAFE_UPDATES = 0;
UPDATE orsdb.dataset_correlation set right_table_prefix='age_esnon_graded' where right_table_prefix ='age_esnon-graded';
UPDATE orsdb.dataset_correlation set right_table_prefix='age_ssnon_graded' where right_table_prefix ='age_ssnon-graded';
UPDATE orsdb.dataset_correlation set right_table_prefix='per_non_teaching' where right_table_prefix ='per_non-teaching';
SET SQL_SAFE_UPDATES = 1;
