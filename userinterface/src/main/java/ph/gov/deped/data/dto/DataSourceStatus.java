package ph.gov.deped.data.dto;

import java.io.Serializable;

public class DataSourceStatus implements Serializable {

    private static final long serialVersionUID = -2467067657288665438L;
    
    private Status ebeisDbStatus;
    
    private Status lisDbStatus;
    
    private Status orsDbStatus;
    
    private String ebeisDbInfo;
    
    private String lisDbInfo;
    
    private String orsDbInfo;

    public Status getEbeisDbStatus() {
        return ebeisDbStatus;
    }

    public Status getLisDbStatus() {
        return lisDbStatus;
    }

    public Status getOrsDbStatus() {
        return orsDbStatus;
    }

    public String getEbeisDbInfo() {
        return ebeisDbInfo;
    }

    public String getLisDbInfo() {
        return lisDbInfo;
    }

    public String getOrsDbInfo() {
        return orsDbInfo;
    }

    public void setEbeisDbStatus(Status ebeisDbStatus) {
        this.ebeisDbStatus = ebeisDbStatus;
    }

    public void setLisDbStatus(Status lisDbStatus) {
        this.lisDbStatus = lisDbStatus;
    }

    public void setOrsDbStatus(Status orsDbStatus) {
        this.orsDbStatus = orsDbStatus;
    }

    public void setEbeisDbInfo(String ebeisDbInfo) {
        this.ebeisDbInfo = ebeisDbInfo;
    }

    public void setLisDbInfo(String lisDbInfo) {
        this.lisDbInfo = lisDbInfo;
    }

    public void setOrsDbInfo(String orsDbInfo) {
        this.orsDbInfo = orsDbInfo;
    }
}