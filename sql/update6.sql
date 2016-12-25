SET SQL_SAFE_UPDATES = 0;
UPDATE column_metadata
SET data_type='mediumint'
WHERE data_type='smallint';
SET SQL_SAFE_UPDATES = 1;

UPDATE column_metadata
SET data_type='smallint'
WHERE column_id=265
