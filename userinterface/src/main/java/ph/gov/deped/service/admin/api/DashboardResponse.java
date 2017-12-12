package ph.gov.deped.service.admin.api;

import java.io.Serializable;

import ph.gov.deped.common.command.IResponse;
import ph.gov.deped.common.command.ResponseContext;
import ph.gov.deped.data.dto.DataSourceStatus;
import ph.gov.deped.data.dto.Datasets;
import ph.gov.deped.data.dto.Memory;
import ph.gov.deped.data.dto.Users;

public class DashboardResponse implements IResponse, Serializable {

    private static final long serialVersionUID = 3174831270796536399L;
    
    private ResponseContext responseContext;
    
    private Users users;
    
    private Datasets datasets;
    
    private Memory memory;
    
    private DataSourceStatus dataSourceStatus;

    public DashboardResponse() {}

    public DashboardResponse(ResponseContext responseContext, Users users, Datasets datasets, Memory memory, DataSourceStatus dataSourceStatus) {
        this.responseContext = responseContext;
        this.users = users;
        this.datasets = datasets;
        this.memory = memory;
        this.dataSourceStatus = dataSourceStatus;
    }

    public ResponseContext getResponseContext() {
        return responseContext;
    }

    public Users getUsers() {
        return users;
    }

    public Datasets getDatasets() {
        return datasets;
    }

    public Memory getMemory() {
        return memory;
    }

    public DataSourceStatus getDataSourceStatus() {
        return dataSourceStatus;
    }

    public void setResponseContext(ResponseContext responseContext) {
        this.responseContext = responseContext;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public void setDatasets(Datasets datasets) {
        this.datasets = datasets;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void setDataSourceStatus(DataSourceStatus dataSourceStatus) {
        this.dataSourceStatus = dataSourceStatus;
    }
}
