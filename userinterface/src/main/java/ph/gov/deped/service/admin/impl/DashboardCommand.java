/**
 * 
 */
package ph.gov.deped.service.admin.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.repo.meta.DatasetRepository;

import ph.gov.deped.common.command.Command;
import ph.gov.deped.common.command.ICommand;
import ph.gov.deped.data.dto.DataSourceStatus;
import ph.gov.deped.data.dto.Datasets;
import ph.gov.deped.data.dto.Memory;
import ph.gov.deped.data.dto.Status;
import ph.gov.deped.data.dto.Users;

public @Command class DashboardCommand implements ICommand<DashboardContext> {
    
    private static final double MB_DIVISOR = 10241024.0;
    
    private @Autowired(required = false) @Lazy DataSource ebeisDataSource;
    
    private @Autowired(required = false) @Lazy DataSource lisDataSource;
    
    private @Autowired(required = false) @Lazy DataSource dataSource;

    private @Autowired DatasetRepository datasetRepository;

    public void execute(DashboardContext context) {
        Memory memory = retrieveMemory();
        Users users = retrieveUsers();
        Datasets datasets = retrieveDatasets();
        DataSourceStatus dataSourceStatus = retrieveDataSourceStatus();
        context.setMemory(memory);
        context.setUsers(users);
        context.setDatasets(datasets);
        context.setDataSourceStatus(dataSourceStatus);
        context.createResponse();
    }
    
    protected Memory retrieveMemory() {
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.freeMemory();
        long totalMemory = runtime.maxMemory();
        Memory memory = new Memory();
        memory.setTotal(totalMemory / MB_DIVISOR);
        memory.setFree(freeMemory / MB_DIVISOR);
        memory.setUsed((totalMemory - freeMemory) / MB_DIVISOR);
        return memory;
    }
    
    protected Users retrieveUsers() {
        Users users = new Users();
        users.setActiveCount(45_000);
        users.setRegisteredCount(58_000);
        users.setLoggedInCount(12_000);
        return users;
    }
    
    protected Datasets retrieveDatasets() {
        Datasets ds = new Datasets();
        // TODO Fetch from actual datasets using CassandraOperations
        ds.setSchoolsCount(65_000);
        ds.setEnrollmentCount(25_800_000);
        ds.setFacilitiesCount(342_678);
        ds.setPersonnelCount(12_500_000);
        return ds;
    }
    
    protected DataSourceStatus retrieveDataSourceStatus() {
        DataSourceStatus s = new DataSourceStatus();
        ConInfo ci = checkDataSource(ebeisDataSource);
        s.setEbeisDbInfo(ci.info);
        s.setEbeisDbStatus(ci.status);
        ci = checkDataSource(lisDataSource);
        s.setLisDbInfo(ci.info);
        s.setLisDbStatus(ci.status);        
        ci = checkDataSource(dataSource);
        s.setOrsDbInfo(ci.info);
        s.setOrsDbStatus(ci.status);
        return s;
    }
    
    private ConInfo checkDataSource(DataSource ds) {
        ConInfo ci = new ConInfo();
        try (Connection con = ds.getConnection()) {
            ci.info = buildDbInfo(con);
            ci.status = con.isClosed() ? Status.DOWN : Status.OK;
        }
        catch (Exception ex) {
            ci.status = Status.DOWN;
        }
        return ci;
    }

    private String buildDbInfo(Connection con) throws SQLException {
        DatabaseMetaData meta = con.getMetaData();
        String productName = meta.getDatabaseProductName();
        String productVersion = meta.getDatabaseProductVersion();
        int majorVersion = meta.getDatabaseMajorVersion();
        int minorVersion = meta.getDatabaseMinorVersion();
        return new StringBuilder(productName)
                .append(" ").append(productVersion)
                .append(" ").append(majorVersion)
                .append(".").append(minorVersion)
                .toString();
    }
    
    private static class ConInfo {
        protected String info;
        protected Status status;
    }
}
