/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ej
 */
@Embeddable
public class PersonnelNatlfundSummaryPK implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 8789634685374056590L;
    @Basic(optional = false)
    @Column(nullable = false)
    private short id;
    @Basic(optional = false)
    @Column(name = "school_id", nullable = false)
    private short schoolId;

    public PersonnelNatlfundSummaryPK() {
    }

    public PersonnelNatlfundSummaryPK(short id, short schoolId) {
        this.id = id;
        this.schoolId = schoolId;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public short getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(short schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) schoolId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonnelNatlfundSummaryPK)) {
            return false;
        }
        PersonnelNatlfundSummaryPK other = (PersonnelNatlfundSummaryPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.schoolId != other.schoolId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.PersonnelNatlfundSummaryPK[ id=" + id + ", schoolId=" + schoolId + " ]";
    }
    
}
