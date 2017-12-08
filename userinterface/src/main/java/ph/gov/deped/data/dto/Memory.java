package ph.gov.deped.data.dto;

import java.io.Serializable;

public class Memory implements Serializable {

    private static final long serialVersionUID = -3018879690315443630L;
    
    private double total;
    
    private double free;
    
    private double used;

    public double getTotal() {
        return total;
    }

    public double getFree() {
        return free;
    }

    public double getUsed() {
        return used;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setFree(double free) {
        this.free = free;
    }

    public void setUsed(double used) {
        this.used = used;
    }
}