/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ph.gov.deped.data.ebeis;

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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ej
 */
@Entity
@Table(name = "school_quick_count", catalog = "sisdb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"report_history_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolQuickCount.findAll", query = "SELECT s FROM SchoolQuickCount s")})
public class SchoolQuickCount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "report_history_id")
    private Integer reportHistoryId;
    private Short male;
    private Short female;
    @Column(name = "natlfunded_teaching_personnels")
    private Short natlfundedTeachingPersonnels;
    @Column(name = "instructional_rooms")
    private Short instructionalRooms;
    private Short desks;
    @Column(name = "chair_tables")
    private Short chairTables;
    private Short armchairs;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "created_by")
    private Integer createdBy;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "updated_by")
    private Integer updatedBy;

    public SchoolQuickCount() {
    }

    public SchoolQuickCount(Integer id) {
        this.id = id;
    }

    public SchoolQuickCount(Integer id, Date createdAt, Date updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReportHistoryId() {
        return reportHistoryId;
    }

    public void setReportHistoryId(Integer reportHistoryId) {
        this.reportHistoryId = reportHistoryId;
    }

    public Short getMale() {
        return male;
    }

    public void setMale(Short male) {
        this.male = male;
    }

    public Short getFemale() {
        return female;
    }

    public void setFemale(Short female) {
        this.female = female;
    }

    public Short getNatlfundedTeachingPersonnels() {
        return natlfundedTeachingPersonnels;
    }

    public void setNatlfundedTeachingPersonnels(Short natlfundedTeachingPersonnels) {
        this.natlfundedTeachingPersonnels = natlfundedTeachingPersonnels;
    }

    public Short getInstructionalRooms() {
        return instructionalRooms;
    }

    public void setInstructionalRooms(Short instructionalRooms) {
        this.instructionalRooms = instructionalRooms;
    }

    public Short getDesks() {
        return desks;
    }

    public void setDesks(Short desks) {
        this.desks = desks;
    }

    public Short getChairTables() {
        return chairTables;
    }

    public void setChairTables(Short chairTables) {
        this.chairTables = chairTables;
    }

    public Short getArmchairs() {
        return armchairs;
    }

    public void setArmchairs(Short armchairs) {
        this.armchairs = armchairs;
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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
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
        if (!(object instanceof SchoolQuickCount)) {
            return false;
        }
        SchoolQuickCount other = (SchoolQuickCount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ph.gov.deped.data.ebeis.SchoolQuickCount[ id=" + id + " ]";
    }
    
}
