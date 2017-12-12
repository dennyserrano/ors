package ph.gov.deped.data.dto;

import java.io.Serializable;

public class Datasets implements Serializable {

    private static final long serialVersionUID = -4700785272744678411L;
    
    private int schoolsCount;
    
    private int enrollmentCount;
    
    private int facilitiesCount;
    
    private int personnelCount;

    public int getSchoolsCount() {
        return schoolsCount;
    }

    public int getEnrollmentCount() {
        return enrollmentCount;
    }

    public int getFacilitiesCount() {
        return facilitiesCount;
    }

    public int getPersonnelCount() {
        return personnelCount;
    }

    public void setSchoolsCount(int schoolsCount) {
        this.schoolsCount = schoolsCount;
    }

    public void setEnrollmentCount(int enrollmentCount) {
        this.enrollmentCount = enrollmentCount;
    }

    public void setFacilitiesCount(int facilitiesCount) {
        this.facilitiesCount = facilitiesCount;
    }

    public void setPersonnelCount(int personnelCount) {
        this.personnelCount = personnelCount;
    }
}