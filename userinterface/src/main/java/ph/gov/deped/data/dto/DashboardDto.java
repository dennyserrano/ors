package ph.gov.deped.data.dto;

import java.io.Serializable;

public class DashboardDto implements Serializable {
    
    private static final long serialVersionUID = 6418126270649485637L;
    
    private Datasets datasets;
    
    private DataSourceStatus dataSourceStatus;
    
    private Memory memory;
    
    private Users users;

    public DashboardDto() {}

    public DashboardDto(Datasets datasets, DataSourceStatus dataSourceStatus, Memory memory, Users users) {
        this.datasets = datasets;
        this.dataSourceStatus = dataSourceStatus;
        this.memory = memory;
        this.users = users;
    }

    public Datasets getDatasets() {
        return datasets;
    }

    public DataSourceStatus getDataSourceStatus() {
        return dataSourceStatus;
    }

    public Memory getMemory() {
        return memory;
    }

    public Users getUsers() {
        return users;
    }

    public void setDatasets(Datasets datasets) {
        this.datasets = datasets;
    }

    public void setDataSourceStatus(DataSourceStatus dataSourceStatus) {
        this.dataSourceStatus = dataSourceStatus;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
