package com.reportconfig.conf;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.model.conf.DBProperties;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;


@Configuration
public class DataSourceConfig {

	
//	@Autowired
	private DBProperties dbProp;
	
//	public @Bean @Primary DataSource dataSource() {
	public  DataSource dataSource() {
        MysqlXADataSource mysqlDs = new MysqlXADataSource();
//        jdbc:mysql://${ors.dbHost}:${ors.dbPort}/${ors.dbName}
        mysqlDs.setURL(String.format("jdbc:mysql://%s:%s/%s", dbProp.getDbHost(),dbProp.getDbPort(),dbProp.getDbName()));
        mysqlDs.setUrl(String.format("jdbc:mysql://%s:%s/%s", dbProp.getDbHost(),dbProp.getDbPort(),dbProp.getDbName()));
        mysqlDs.setUser(dbProp.getDbUser());
        mysqlDs.setPassword(dbProp.getDbPass());
        mysqlDs.setQueryTimeoutKillsConnection(true);
        mysqlDs.setZeroDateTimeBehavior("convertToNull");
        mysqlDs.setCachePreparedStatements(true);
        mysqlDs.setCachePrepStmts(true);
        mysqlDs.setUseServerPreparedStmts(true);
        mysqlDs.setUseServerPrepStmts(true);
        mysqlDs.setCacheServerConfiguration(true);
        mysqlDs.setUseLocalSessionState(true);
        mysqlDs.setUseLocalTransactionState(true);
        mysqlDs.setUseUnbufferedInput(false);
        mysqlDs.setUseReadAheadInput(false);
        try {
            mysqlDs.setPreparedStatementCacheSize(200);
            mysqlDs.setPrepStmtCacheSize(200);
            mysqlDs.setPrepStmtCacheSqlLimit(2048);
        }
        catch (SQLException ex) {
           
        }

       

        return mysqlDs;
    }

	public DBProperties getDbProp() {
		return dbProp;
	}

	public void setDbProp(DBProperties dbProp) {
		this.dbProp = dbProp;
	}
	
	
	
}
