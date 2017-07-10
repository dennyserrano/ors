#!/bin/bash

array=(
"table_metadata_test.sql"
"column_metadata_test.sql"
"dataset_head_test.sql"
"dataset_element_test.sql"
"enrollment_table_metadata_test.sql"
"enrollment_column_metadata_test.sql"
"enrollment_dataset_test.sql"
"enrollment_dataset_element_test.sql"
"enrollment_correlation_dtl_test.sql"
"enrollment_correlation_test.sql"
"group_test.sql"
"group_details_test.sql"
"correlation_test.sql"
"correlation_dtl_test.sql"
)

for i in ${array[*]}
do
	mysql -u root -proot orsdb<$i
done
