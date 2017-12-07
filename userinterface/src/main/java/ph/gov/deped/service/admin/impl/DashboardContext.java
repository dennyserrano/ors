package ph.gov.deped.service.admin.impl;

import java.io.Serializable;

import ph.gov.deped.common.command.AbstractContext;
import ph.gov.deped.common.command.ResponseContext;
import ph.gov.deped.data.dto.DataSourceStatus;
import ph.gov.deped.data.dto.Datasets;
import ph.gov.deped.data.dto.Memory;
import ph.gov.deped.data.dto.Users;
import ph.gov.deped.service.admin.api.DashboardRequest;
import ph.gov.deped.service.admin.api.DashboardResponse;

public class DashboardContext extends AbstractContext<DashboardRequest, DashboardResponse> implements Serializable {

    private static final long serialVersionUID = 1923626897330046215L;
    
    private Datasets datasets;
    
    private Memory memory;
    
    private Users users;
    
    private DataSourceStatus dataSourceStatus;
    
    public DashboardContext(DashboardRequest request) {
        super(request);
    }

    public void setDatasets(Datasets datasets) {
        this.datasets = datasets;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public void setDataSourceStatus(DataSourceStatus dataSourceStatus) {
        this.dataSourceStatus = dataSourceStatus;
    }

    public void createResponse() {
        response = new DashboardResponse(new ResponseContext(true), users, datasets, memory, dataSourceStatus);
    }
}
