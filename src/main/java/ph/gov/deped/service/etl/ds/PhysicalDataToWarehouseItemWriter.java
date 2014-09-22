package ph.gov.deped.service.etl.ds;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.cassandra.core.CassandraOperations;

import ph.gov.deped.common.EbeisMetadata;
import ph.gov.deped.common.LisMetadata;
import ph.gov.deped.common.dw.DbType;

import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;

/**
 * Created by ej on 9/10/14.
 */
public class PhysicalDataToWarehouseItemWriter implements ItemWriter<DbTypeSqlMapping> {
    
    private static final Logger log = LogManager.getLogger(PhysicalDataToWarehouseItemWriter.class);
    
    private @Autowired @Qualifier(EbeisMetadata.DS) DataSource ebeisDataSource;

    private @Autowired @Qualifier(LisMetadata.DS) DataSource lisDataSource;

    private @Autowired CassandraOperations cassandraTemplate;

    public void write(List<? extends DbTypeSqlMapping> items) throws Exception {
        items.parallelStream().forEach(item -> {
            final String tableName = item.getMetadataHolder().getTableMetadata().getTableName();
            try (
                    Connection con = getConnection(item.getDbType());
                    PreparedStatement ps = con.prepareStatement(item.getSql().toString());
                    ResultSet rs = ps.executeQuery()
            ) {
                ResultSetMetaData rsMeta = rs.getMetaData();
                int colCount = rsMeta.getColumnCount();
                Map<String, Serializable> row;
                while (rs.next()) {
                    row = new HashMap<>();
                    Insert insert = QueryBuilder.insertInto(tableName);
                    for (int i = 1; i <= colCount; i++) {
                        mapRow(row, rsMeta, rs, i);
                    }
                    log.trace("Insert [{}] Into Cassandra[{}].[{}]", row, item.getDbType().getDbName(), tableName);
                    row.entrySet().forEach(e -> {
                        insert.value(e.getKey(), e.getValue());
                    });
                    cassandraTemplate.executeAsynchronously(insert);
                }
            }
            catch (SQLException ex) {
                log.error(new ParameterizedMessage("Error while reading data from DB [{}] Table [{}].",
                        new Object[] { item.getDbType(), tableName }, ex), ex);
                throw new EtlDataStreamingException(String.format("Unable to execute query from table [%s].", tableName), ex);
            }
            catch (DataAccessException ex) {
                log.error(new ParameterizedMessage("Error while inserting data to Cassandra table [{}].", new Object[] { tableName }, ex), ex);
                throw new EtlDataStreamingException("Unable to insert data.", ex);
            }
            catch (Exception ex) {
                log.error(new ParameterizedMessage("General streaming insertion failure on table [{}]!", new Object[] { tableName }, ex), ex);
                throw new EtlDataStreamingException("Unable to insert data.", ex);
            }
        });
    }
    
    private void mapRow(Map<String, Serializable> row, ResultSetMetaData rsMeta, ResultSet rs, int colIdx) throws SQLException {
        int sqlType = rsMeta.getColumnType(colIdx);
        int precision = rsMeta.getPrecision(colIdx);
        String columnName = rsMeta.getColumnName(colIdx);
        String typeName = rsMeta.getColumnTypeName(colIdx);
        log.trace("Retrieving column value using index [{}] corresponds to column [{}] of SQL type [{}]", colIdx, columnName, typeName);
        Serializable value;
        if (Types.TINYINT == sqlType && precision <= 3) { // prevents value converted to boolean when tinyint(n <= 3)
            value = rs.getInt(colIdx);
        }
        else if (Types.TIMESTAMP == sqlType) { // handle Timestamp invalid values
            String timestampStr = rs.getString(colIdx);
            if ("0000-00-00 00:00:00".equals(timestampStr)) { // handle empty time
                value = new Timestamp(1L);
            }
            else {
                value = rs.getTimestamp(colIdx);
            }
        }
        else {
            value = (Serializable) rs.getObject(colIdx);
        }
        row.put(columnName, value);
    }

    private Connection getConnection(DbType dbType) {
        try {
            if (DbType.EBEIS == dbType) {
                return ebeisDataSource.getConnection();
            }
            else if (DbType.LIS == dbType) {
                return lisDataSource.getConnection();
            }
            else {
                return null;
            }
        }
        catch (SQLException ex) {
            throw new RuntimeException("Unable to establish MySQL Database connection.", ex);
        }
    }
}
