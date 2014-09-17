/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

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
@Table(name = "programs_offered_history", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"school_profile_history_id", "co_subclass", "program_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramsOfferedHistory.findAll", query = "SELECT p FROM ProgramsOfferedHistory p")})
public class ProgramsOfferedHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "co_subclass")
    private Short coSubclass;
    @Basic(optional = false)
    @Column(name = "program_id", nullable = false)
    private short programId;
    private Boolean active;
    @JoinColumn(name = "school_profile_history_id", referencedColumnName = "id")
    @ManyToOne
    private SchoolProfileHistory schoolProfileHistoryId;

    public ProgramsOfferedHistory() {
    }

    public ProgramsOfferedHistory(Integer id) {
        this.id = id;
    }

    public ProgramsOfferedHistory(Integer id, short programId) {
        this.id = id;
        this.programId = programId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getCoSubclass() {
        return coSubclass;
    }

    public void setCoSubclass(Short coSubclass) {
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

    public SchoolProfileHistory getSchoolProfileHistoryId() {
        return schoolProfileHistoryId;
    }

    public void setSchoolProfileHistoryId(SchoolProfileHistory schoolProfileHistoryId) {
        this.schoolProfileHistoryId = schoolProfileHistoryId;
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
        if (!(object instanceof ProgramsOfferedHistory)) {
            return false;
        }
        ProgramsOfferedHistory other = (ProgramsOfferedHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.ProgramsOfferedHistory[ id=" + id + " ]";
    }
    
}
