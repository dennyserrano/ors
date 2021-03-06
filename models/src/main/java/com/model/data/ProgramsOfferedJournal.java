/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "programs_offered_journal", catalog = "sisdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramsOfferedJournal.findAll", query = "SELECT p FROM ProgramsOfferedJournal p")})
public class ProgramsOfferedJournal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "original_id", nullable = false)
    private int originalId;
    @Basic(optional = false)
    @Column(name = "school_id", nullable = false)
    private int schoolId;
    @Basic(optional = false)
    @Column(name = "co_subclass", nullable = false)
    private short coSubclass;
    @Basic(optional = false)
    @Column(name = "program_id", nullable = false)
    private short programId;
    private Boolean active;
    @Basic(optional = false)
    @Column(name = "original_created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date originalCreatedAt;
    @Column(name = "original_created_by")
    private Integer originalCreatedBy;
    @Basic(optional = false)
    @Column(name = "original_updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date originalUpdatedAt;
    @Column(name = "original_updated_by")
    private Integer originalUpdatedBy;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "created_by")
    private Integer createdBy;

    public ProgramsOfferedJournal() {
    }

    public ProgramsOfferedJournal(Integer id) {
        this.id = id;
    }

    public ProgramsOfferedJournal(Integer id, int originalId, int schoolId, short coSubclass, short programId, Date originalCreatedAt, Date originalUpdatedAt, Date createdAt) {
        this.id = id;
        this.originalId = originalId;
        this.schoolId = schoolId;
        this.coSubclass = coSubclass;
        this.programId = programId;
        this.originalCreatedAt = originalCreatedAt;
        this.originalUpdatedAt = originalUpdatedAt;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOriginalId() {
        return originalId;
    }

    public void setOriginalId(int originalId) {
        this.originalId = originalId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
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

    public Date getOriginalCreatedAt() {
        return originalCreatedAt;
    }

    public void setOriginalCreatedAt(Date originalCreatedAt) {
        this.originalCreatedAt = originalCreatedAt;
    }

    public Integer getOriginalCreatedBy() {
        return originalCreatedBy;
    }

    public void setOriginalCreatedBy(Integer originalCreatedBy) {
        this.originalCreatedBy = originalCreatedBy;
    }

    public Date getOriginalUpdatedAt() {
        return originalUpdatedAt;
    }

    public void setOriginalUpdatedAt(Date originalUpdatedAt) {
        this.originalUpdatedAt = originalUpdatedAt;
    }

    public Integer getOriginalUpdatedBy() {
        return originalUpdatedBy;
    }

    public void setOriginalUpdatedBy(Integer originalUpdatedBy) {
        this.originalUpdatedBy = originalUpdatedBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
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
        if (!(object instanceof ProgramsOfferedJournal)) {
            return false;
        }
        ProgramsOfferedJournal other = (ProgramsOfferedJournal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.ProgramsOfferedJournal[ id=" + id + " ]";
    }
    
}
