package ph.gov.deped.data.dto;

import java.io.Serializable;

public class Users implements Serializable {

    private static final long serialVersionUID = 7604989932281465832L;
    
    private int registeredCount;
    
    private int activeCount;
    
    private int loggedInCount;

    public int getRegisteredCount() {
        return registeredCount;
    }

    public int getActiveCount() {
        return activeCount;
    }

    public int getLoggedInCount() {
        return loggedInCount;
    }

    public void setRegisteredCount(int registeredCount) {
        this.registeredCount = registeredCount;
    }

    public void setActiveCount(int activeCount) {
        this.activeCount = activeCount;
    }

    public void setLoggedInCount(int loggedInCount) {
        this.loggedInCount = loggedInCount;
    }
}