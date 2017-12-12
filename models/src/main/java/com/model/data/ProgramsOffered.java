/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "programs_offered", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"school_id", "co_subclass", "program_id"}),
    @UniqueConstraint(columnNames = {"school_id", "program_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramsOffered.findAll", query = "SELECT p FROM ProgramsOffered p")})
public class ProgramsOffered implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "co_subclass", nullable = false)
    private short coSubclass;
    @Basic(optional = false)
    @Column(name = "program_id", nullable = false)
    private short programId;
    private Boolean active;
    @JoinColumn(name = "school_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private School schoolId;

    public ProgramsOffered() {
    }

    public ProgramsOffered(Integer id) {
        this.id = id;
    }

    public ProgramsOffered(Integer id, short coSubclass, short programId) {
        this.id = id;
        this.coSubclass = coSubclass;
        this.programId = programId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getCoSubclass() {
        return coSubclass;
    }

    public void setCoSubclass(short coSubclass) {
        this.coSubclass = coSubclass;
    }

    public short getProgramId() {
        return programId;
    }

    public void setProgramId(short programId) {
        this.programId = programId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public School getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(School schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramsOffered)) {
            return false;
        }
        ProgramsOffered other = (ProgramsOffered) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.ProgramsOffered[ id=" + id + " ]";
    }
    
}
