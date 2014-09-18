Cassandra Setup:

DROP KEYSPACE IF EXISTS meta;

CREATE KEYSPACE IF NOT EXISTS meta WITH REPLICATION = {
  'class' : 'SimpleStrategy',
  'replication_factor' : 1
};

===================================================================

Tables and Columns Metadata query:

select tbl.table_name, tbl.table_rows, tbl.table_comment, tbl.create_time, tbl.update_time,
  col.column_name, col.column_comment, col.data_type, col.is_nullable,
col.column_type, col.column_key, col.numeric_precision, col.numeric_scale
from tables tbl
  inner join columns col on tbl.table_name = col.table_name
where tbl.table_schema = col.table_schema
  and tbl.table_schema = 'sisdb'
  and tbl.table_type = 'BASE TABLE'
order by tbl.table_name, col.ordinal_position;

===================================================================

Hadoop Test Cluster (proposed for development):
hadoop-dev: 10.0.0.68 (assigned test server)
hadoop-dev2: 10.0.0.201 (my local machine)
hadoop-dev3: 10.0.0.70 (also the Jasper Test Server)

===================================================================

Local/Application Database:

create database orsdb;

create user 'orsuser'@'%' identified by 'ors123';

grant all privileges on orsdb.* to 'orsuser'@'%';

flush privileges;

===================================================================

