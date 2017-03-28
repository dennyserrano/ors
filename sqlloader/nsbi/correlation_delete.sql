SET SQL_SAFE_UPDATES = 0;

DELETE DCD.*,DC.* FROM orsdb.dataset_correlation DC
INNER JOIN orsdb.dataset_correlation_dtl DCD ON DC.id=DCD.dataset_correlation_id
WHERE DC.id not in (238,239);

SET SQL_SAFE_UPDATES = 1;